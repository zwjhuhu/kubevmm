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
import os
import sys
import subprocess
import ConfigParser
import xmltodict
import socket
import traceback
from json import loads
from json import dumps
from StringIO import StringIO as _StringIO
from xml.etree.ElementTree import fromstring

'''
Import third party libs
'''
from kubernetes import client, config, watch
from kubernetes.client.rest import ApiException
from xmltodict import unparse
from xmljson import badgerfish as bf

'''
Import local libs
'''
# sys.path.append('%s/utils' % (os.path.dirname(os.path.realpath(__file__))))
from utils.libvirt_util import get_xml, destroy, undefine, create, setmem, setvcpus, is_vm_active, is_vm_exists
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
PLURAL1 = config_raw.get('VirtualMachine', 'plural')
VERSION1 = config_raw.get('VirtualMachine', 'version')
GROUP1 = config_raw.get('VirtualMachine', 'group')
PLURAL2 = config_raw.get('VirtualMachineImage', 'plural')
VERSION2 = config_raw.get('VirtualMachineImage', 'version')
GROUP2 = config_raw.get('VirtualMachineImage', 'group')
VMSUPPORTCMDS1 = config_raw._sections['VirtualMachineSupportCmds1']
VMSUPPORTCMDS2 = config_raw._sections['VirtualMachineSupportCmds2']
VMSUPPORTCMDSALL = dict(VMSUPPORTCMDS1, **VMSUPPORTCMDS2)
IMAGESUPPORTCMDS = config_raw._sections['ImageSupportCmds']

LABEL = 'host=%s' % (socket.gethostname())

logger = logger.set_logger(os.path.basename(__file__), '/var/log/virtctl_output.log')

def main():
    watcher = watch.Watch()
    kwargs = {}
    kwargs['label_selector'] = LABEL
    kwargs['watch'] = True
    vMWatcher(watcher, **kwargs)
    imageWatcher(watcher, **kwargs)
    
def vMWatcher(watcher, **kwargs):
    for jsondict in watcher.stream(client.CustomObjectsApi().list_cluster_custom_object,
                                group=GROUP1, version=VERSION1, plural=PLURAL1, **kwargs):
        operation_type = jsondict.get('type')
#         print operation_type
        metadata_name = getMetadataName(jsondict)
        print('metadata name: %s' % metadata_name)
        jsondict = forceUsingMetadataName(metadata_name, jsondict)
#             print(jsondict)
        if operation_type == 'ADDED':
            if _isInstallVMFromISO(jsondict):
                cmd = unpackCmdFromJson(jsondict)
                if cmd:
                    runCmd(cmd)
                if not is_vm_active(metadata_name):
                    create(metadata_name)
            elif _isInstallVMFromImage(jsondict):
                (jsondict, new_vm_vcpus, new_vm_memory) = _preprocessInCreateVMFromImage(jsondict)
                cmd = unpackCmdFromJson(jsondict)
                if cmd: 
                    runCmd(cmd)
                '''
                Set new VM's CPU and Memory
                '''
                setvcpus(metadata_name, int(new_vm_vcpus), config=True)
                setmem(metadata_name, int(new_vm_memory), config=True)
                '''
                Start VM
                '''
                create(metadata_name)
            else:
                cmd = unpackCmdFromJson(jsondict)
                if cmd:     
                    runCmd(cmd)
        elif operation_type == 'MODIFIED':
            cmd = unpackCmdFromJson(jsondict)
            if cmd: 
                runCmd(cmd)
        elif operation_type == 'DELETED':
            if is_vm_exists(metadata_name):
                if is_vm_active(metadata_name):
                    destroy(metadata_name)
                undefine(metadata_name)
                
def imageWatcher(watcher, **kwargs):
    for jsondict in watcher.stream(client.CustomObjectsApi().list_cluster_custom_object,
                                group=GROUP2, version=VERSION2, plural=PLURAL2, **kwargs):
        operation_type = jsondict.get('type')
#         print operation_type
        metadata_name = getMetadataName(jsondict)
        print('metadata name: %s' % metadata_name)
#         jsondict = forceUsingMetadataName(metadata_name, jsondict)
# #             print(jsondict)
#         if operation_type == 'ADDED':
#             if _isInstallVMFromISO(jsondict):
#                 cmd = unpackCmdFromJson(jsondict)
#                 runCmd(cmd)
#             elif _isInstallVMFromImage(jsondict):
#                 (jsondict, new_vm_vcpus, new_vm_memory) = _preprocessInCreateVMFromImage(jsondict)
#                 cmd = unpackCmdFromJson(jsondict)
#                 runCmd(cmd)
#                 '''
#                 Set new VM's CPU and Memory
#                 '''
#                 setvcpus(metadata_name, int(new_vm_vcpus), config=True)
#                 setmem(metadata_name, int(new_vm_memory), config=True)
#                 '''
#                 Start VM
#                 '''
#                 create(metadata_name)
#             else:
#                 cmd = unpackCmdFromJson(jsondict)
#                 runCmd(cmd)
#         elif operation_type == 'MODIFIED':
#             cmd = unpackCmdFromJson(jsondict)
#             runCmd(cmd)
#         elif operation_type == 'DELETED':
#             if metadata_name:
#                 destroy(metadata_name)
#                 undefine(metadata_name)

def getMetadataName(jsondict):
    return jsondict['raw_object']['metadata']['name']
            

def forceUsingMetadataName(metadata_name,jsondict):
    spec = jsondict['raw_object']['spec']
    lifecycle = spec.get('lifecycle')
    if lifecycle:
        the_key = None
        keys = lifecycle.keys()
        for key in keys:
            if key in VMSUPPORTCMDSALL.keys():
                cmd_head = VMSUPPORTCMDSALL.get(key)
                the_key = key
                break;
#         print(cmd_head)
        if the_key in VMSUPPORTCMDS1:
            lifecycle[the_key]['name'] = metadata_name    
        elif the_key in VMSUPPORTCMDS2:
            lifecycle[the_key]['domain'] = metadata_name
    return jsondict


'''
Install VM from ISO.
'''
def _isInstallVMFromISO(jsondict):
    spec = jsondict['raw_object'].get('spec')
    if spec:
        '''
        Iterate keys in 'spec' structure and map them to real CMDs in back-end.
        Note that only the first CMD will be executed.
        '''
        cmd_head = ''
        lifecycle = spec.get('lifecycle')
        if not lifecycle:
            return False
        keys = lifecycle.keys()
        for key in keys:
            if key in VMSUPPORTCMDS1.keys():
                cmd_head = VMSUPPORTCMDS1.get(key)
                break;
        if cmd_head and cmd_head.startswith('virt-install'):
            return True
    return False

'''
Install VM from image.
'''
def _isInstallVMFromImage(jsondict):
    spec = jsondict['raw_object'].get('spec')
    if spec:
        '''
        Iterate keys in 'spec' structure and map them to real CMDs in back-end.
        Note that only the first CMD will be executed.
        '''
        cmd_head = ''
        lifecycle = spec.get('lifecycle')
        if not lifecycle:
            return False
        keys = lifecycle.keys()
        for key in keys:
            if key in VMSUPPORTCMDS1.keys():
                cmd_head = VMSUPPORTCMDS1.get(key)
                break;
        if cmd_head and cmd_head.startswith('virt-clone'):
            return True
    return False

def _preprocessInCreateVMFromImage(jsondict):
    new_vm_memory = None
    new_vm_vcpus = None
    '''
    Get target VM name from Json.
    '''
    spec = jsondict['raw_object'].get('spec')
    if spec:
        '''
        Iterate keys in 'spec' structure and map them to real CMDs in back-end.
        Note that only the first CMD will be executed.
        '''
        the_cmd_key = None
        lifecycle = spec.get('lifecycle')
        if not lifecycle:
            return
        keys = lifecycle.keys()
        for key in keys:
            if key in VMSUPPORTCMDSALL.keys():
                the_cmd_key = key
                break;
        '''
        Get the CMD body from 'dict' structure.
        '''
        if the_cmd_key:
            contents = lifecycle.get(the_cmd_key)
            for k, v in contents.items():
                if k == "memory":
                    new_vm_memory = v
                    del jsondict['raw_object']['spec']['lifecycle'][the_cmd_key][k]
                elif k == 'vcpus':
                    new_vm_vcpus = v
                    del jsondict['raw_object']['spec']['lifecycle'][the_cmd_key][k]
                else:
                    continue
        print jsondict
        return (jsondict, new_vm_vcpus, new_vm_memory)
        
def jsontoxml(jsonstr):
    json = jsonstr.replace('_interface', 'interface').replace('_transient', 'transient').replace(
        'suspend_to_mem', 'suspend-to-mem').replace('suspend_to_disk', 'suspend-to-disk').replace(
            'on_crash', 'on-crash').replace('on_poweroff', 'on-poweroff').replace('on_reboot', 'on-reboot').replace(
            'nested_hv', "nested-hv").replace('_', '@').replace('text', '#text').replace('\'', '"')
    return unparse(loads(json))

def xmlToJson(xmlStr):
    return dumps(bf.data(fromstring(xmlStr)), sort_keys=True, indent=4)

def toKubeJson(json):
    return json.replace('@', '_').replace('$', 'text').replace(
            'interface', '_interface').replace('transient', '_transient').replace(
                    'nested-hv', 'nested_hv').replace('suspend-to-mem', 'suspend_to_mem').replace('suspend-to-disk', 'suspend_to_disk')

def updateDomainStructureInJson(jsondict, body):
    if jsondict:
        '''
        Get target VM name from Json.
        '''
        spec = jsondict['raw_object']['spec']
        if spec:
            print spec.keys()
            lifecycle = spec.get('lifecycle')
            if lifecycle:
                del spec['lifecycle']
            spec.update(loads(body))
    return jsondict['raw_object']

def updateDomainStructureInJsonBackup(jsondict, body):
    if jsondict:
        '''
        Get target VM name from Json.
        '''
        vm_ = jsondict['items'][0].get('metadata').get('name')
        if not vm_:
            raise Exception('No target VM in Json')
        spec = jsondict['items'][0].get('spec')
        if spec:
            lifecycle = spec.get('lifecycle')
            if lifecycle:
                del spec['lifecycle']
            spec.update(loads(body))
    return jsondict['items'][0]

'''
Covert chars according to real CMD in back-end.
'''
def _convertCharsInJson(key, value):
#     if val[0:1] == '_':
#         val = '_' + val
    key, value = str(key), str(value)
    if value == 'True':
        value = ''
    return ('--%s' % key.replace('_', '-'), value)

'''
Unpack the CMD that will be executed in Json format.
'''
def unpackCmdFromJson(jsondict):
    cmd = None
    if jsondict:
        '''
        Get target VM name from Json.
        '''
        spec = jsondict['raw_object'].get('spec')
        if spec:
            '''
            Iterate keys in 'spec' structure and map them to real CMDs in back-end.
            Note that only the first CMD will be executed.
            '''
            cmd_head = ''
            the_cmd_key = None
            lifecycle = spec.get('lifecycle')
            if not lifecycle:
                return
            keys = lifecycle.keys()
            for key in keys:
                if key in VMSUPPORTCMDSALL.keys():
                    the_cmd_key = key
                    cmd_head = VMSUPPORTCMDSALL.get(key)
                    break;
            '''
            Get the CMD body from 'dict' structure.
            '''
            if the_cmd_key:
                cmd_body = ''
                contents = lifecycle.get(the_cmd_key)
                for k, v in contents.items():
                    (k, v) = _convertCharsInJson(k, v)
#                     print k, v
                    cmd_body = '%s %s %s' % (cmd_body, k, v)
                cmd = '%s %s' % (cmd_head, cmd_body)
            logger.debug("The CMD is: %s" % cmd)
    return cmd

'''
Run back-end command in subprocess.
'''
def runCmd(cmd):
    std_err = None
    if not cmd:
#         logger.debug('No CMD to execute.')
        return
    p = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    try:
        std_out = p.stdout.readlines()
        std_err = p.stderr.readlines()
        if std_out:
            logger.debug(str.strip(std_out[0]))
        if std_err:
            logger.error(str.strip(std_err[0]))
#         return (str.strip(std_out[0]) if std_out else '', str.strip(std_err[0]) if std_err else '')
        return
    finally:
        p.stdout.close()
        p.stderr.close()

# def randomUUID():
#     u = [random.randint(0, 255) for ignore in range(0, 16)]
#     u[6] = (u[6] & 0x0F) | (4 << 4)
#     u[8] = (u[8] & 0x3F) | (2 << 6)
#     return "-".join(["%02x" * 4, "%02x" * 2, "%02x" * 2, "%02x" * 2,
#                      "%02x" * 6]) % tuple(u)
#
# def randomMAC():
#     mac = [ 0x52, 0x54, 0x00,
#         random.randint(0x00, 0x7f),
#         random.randint(0x00, 0xff),
#         random.randint(0x00, 0xff) ]
#     return ':'.join(map(lambda x: "%02x" % x, mac))

if __name__ == '__main__':
    config.load_kube_config(config_file=TOKEN)
    main()
