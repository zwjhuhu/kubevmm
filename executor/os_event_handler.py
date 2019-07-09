'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn

https://pypi.org/project/json2xml/
https://github.com/kubernetes/kubernetes/issues/51046
'''

'''
Import python libs
'''
import ConfigParser
import time
import traceback
from json import loads
from json import dumps
from xml.etree.ElementTree import fromstring

'''
Import third party libs
'''
from watchdog.observers import Observer
from watchdog.events import *
from kubernetes import client, config
from kubernetes.client.rest import ApiException
from kubernetes.client import V1DeleteOptions
from xmljson import badgerfish as bf

'''
Import local libs
'''
from utils.libvirt_util import list_pools, list_volumes, get_volume_xml
from utils import logger

class parser(ConfigParser.ConfigParser):  
    def __init__(self,defaults=None):  
        ConfigParser.ConfigParser.__init__(self,defaults=None)  
    def optionxform(self, optionstr):  
        return optionstr 

cfg = "%s/default.cfg" % os.path.dirname(os.path.realpath(__file__))
config_raw = parser()
config_raw.read(cfg)

TOKEN = config_raw.get('Kubernetes', 'token_file')
PLURAL_VM_DISK = config_raw.get('VirtualMachineDisk', 'plural')
VERSION_VM_DISK = config_raw.get('VirtualMachineDisk', 'version')
GROUP_VM_DISK = config_raw.get('VirtualMachineDisk', 'group')

WATCH_DIRS = config_raw.items('DefaultVolumeDirs')

logger = logger.set_logger(os.path.basename(__file__), '/var/log/virtctl_output.log')

def modifyVol(name, body):
    retv = client.CustomObjectsApi().replace_namespaced_custom_object(
        group=GROUP_VM_DISK, version=VERSION_VM_DISK, namespace='default', plural=PLURAL_VM_DISK, name=name, body=body)
    return retv

def deleteVol(name, body):
    retv = client.CustomObjectsApi().delete_namespaced_custom_object(
        group=GROUP_VM_DISK, version=VERSION_VM_DISK, namespace='default', plural=PLURAL_VM_DISK, name=name, body=body)
    return retv

def xmlToJson(xmlStr):
    return dumps(bf.data(fromstring(xmlStr)), sort_keys=True, indent=4)

def toKubeJson(json):
    return json.replace('@', '_').replace('$', 'text').replace(
            'interface', '_interface').replace('transient', '_transient').replace(
                    'nested-hv', 'nested_hv').replace('suspend-to-mem', 'suspend_to_mem').replace('suspend-to-disk', 'suspend_to_disk')
                    
def updateXmlStructureInJson(jsondict, body):
    if jsondict:
        '''
        Get target VM name from Json.
        '''
        spec = jsondict['spec']
        if spec:
            lifecycle = spec.get('lifecycle')
            if lifecycle:
                del spec['lifecycle']
            spec.update(loads(body))
    return jsondict

def myVolEventHandler(event, pool, vol):
    try:
        jsondict = client.CustomObjectsApi().get_namespaced_custom_object(group=GROUP_VM_DISK, version=VERSION_VM_DISK, namespace='default', plural=PLURAL_VM_DISK, name=vol)
    #     print(jsondict)
        if  event == "Delete":
            logger.debug('Callback domain deletion to virtlet')
            deleteVol(vol, V1DeleteOptions())
        else:
            logger.debug('Callback domain changes to virtlet')
            vm_xml = get_volume_xml(pool, vol)
            vm_json = toKubeJson(xmlToJson(vm_xml))
            body = updateXmlStructureInJson(jsondict, vm_json)
            modifyVol(vol, body)
    except ApiException, e:
        if e.status == 404:
            logger.error('The vol(%s) does not exist in kubevirt.' % vol)
            return
        else:
            traceback.print_exc()

class FileEventHandler(FileSystemEventHandler):
    def __init__(self, pool, target):
        FileSystemEventHandler.__init__(self)
        self.pool = pool
        self.target = target

    def on_moved(self, event):
        if event.is_directory:
            logger.debug("directory moved from {0} to {1}".format(event.src_path,event.dest_path))
        else:
            logger.debug("file moved from {0} to {1}".format(event.src_path,event.dest_path))

    def on_created(self, event):
        if event.is_directory:
            logger.debug("directory created:{0}".format(event.src_path))
        else:
            logger.info(event)
            logger.debug("file created:{0}".format(event.src_path))
            path,vol = os.path.split(event.src_path)
            myVolEventHandler('Create', self.pool, vol)
                

    def on_deleted(self, event):
        if event.is_directory:
            logger.debug("directory deleted:{0}".format(event.src_path))
        else:
            logger.debug("file deleted:{0}".format(event.src_path))
            path,vol = os.path.split(event.src_path)
            myVolEventHandler('Delete', self.pool, vol)

    def on_modified(self, event):
        if event.is_directory:
            logger.debug("directory modified:{0}".format(event.src_path))
        else:
            logger.debug("file modified:{0}".format(event.src_path))
            
def main():
    observer = Observer()
    for ob in WATCH_DIRS:
        if not os.path.exists(ob[1]):
            os.makedirs(ob[1])
        event_handler = FileEventHandler(ob[0], ob[1])
        observer.schedule(event_handler,ob[1],True)
    observer.start()
    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        observer.stop()
    observer.join()    

if __name__ == "__main__":
    config.load_kube_config(config_file=TOKEN)
    main()
