'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn
'''

'''
Import python libs
'''
import os, socket, ConfigParser

'''
Import third party libs
'''
from kubernetes import client

'''
Import local libs
'''
from libvirt_util import get_xml, list_vms, vm_state

class parser(ConfigParser.ConfigParser):  
    def __init__(self,defaults=None):  
        ConfigParser.ConfigParser.__init__(self,defaults=None)  
    def optionxform(self, optionstr):  
        return optionstr 
    
cfg = "%s/default.cfg" % os.path.dirname(os.path.realpath(__file__))
config_raw = parser()
config_raw.read(cfg)

TOKEN = config_raw.get('Kubernetes', 'token_file')
PLURAL = config_raw.get('VirtualMachine', 'plural')
VERSION = config_raw.get('VirtualMachine', 'version')
GROUP = config_raw.get('VirtualMachine', 'group')

class VMWatcher:
    
    def __init__(self):
#         self.vms_in_libvirt = self.get_vms_in_libvirt()
#         self.vms_in_virtlet = self.get_vms_in_virtlet()
        pass

    def get_vms_in_libvirt(self):
        return list_vms()
    
    def get_vm_state_in_libvirt(self, vm):
        return vm_state(vm)

    def get_vms_in_virtlet(self):
        return client.CustomObjectsApi().list_namespaced_custom_object(group=GROUP, version=VERSION, namespace='default', plural=PLURAL)
        
    def get_vm_state_in_virtlet(self, vm):
        return client.CustomObjectsApi().list_namespaced_custom_object(group=GROUP, version=VERSION, namespace='default', plural=PLURAL)

        
if __name__ == '__main__':
    r = VMWatcher()
    print(r.get_vms_in_libvirt())
#     print(r.get_vms_in_virtlet())
    
#     print client.CoreV1Api().read_node_status(name="node11")
    #client.CoreV1Api().patch_node_status(name="mocker", body=body)
