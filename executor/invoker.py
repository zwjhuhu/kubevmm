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
from xmltodict import unparse
from xmljson import badgerfish as bf

'''
Import local libs
'''
from libvirt_util import get_xml, destroy, undefine, create, setmem, setvcpus

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
SUPPORTCMDS = config_raw._sections['SupportCmds']

LABEL = 'host=%s' % (socket.gethostname())

def main():
    #     crd = client.ApiextensionsV1beta1Api().read_custom_resource_definition(NAME)
    #     client.CustomObjectsApi().list_cluster_custom_object_with_http_info(group=GROUP, version=VERSION, plural=PLURAL, labelSelector='host=a', watch=True);
    w = watch.Watch()
    kwargs = {}
    kwargs['label_selector'] = LABEL
    kwargs['watch'] = True
    for jsondict in w.stream(client.CustomObjectsApi().list_cluster_custom_object,
                                group=GROUP, version=VERSION, plural=PLURAL, **kwargs):
#         jsondict = json.loads(vm)
        operation_type = jsondict.get('type')
        print operation_type
        metadata_name = getMetadataName(jsondict)
        print('metadata name: %s' % metadata_name)
        jsondict = forceUsingMetadataName(metadata_name, jsondict)
#             print(jsondict)
        if operation_type == 'ADDED':
            if _isInstallVMFromISO(jsondict):
                cmd = unpackCmdFromJson(jsondict)
                runCmd(cmd)
#                     vm_xml = get_xml(metadata_name)
#                     vm_json = toKubeJson(xmlToJson(vm_xml))
#                     body = updateDomainStructureInJson(jsondict, vm_json)
#                     modifyVM(metadata_name, body)
            elif _isInstallVMFromImage(jsondict):
                (jsondict, new_vm_vcpus, new_vm_memory) = _preprocessInCreateVMFromImage(jsondict)
                print new_vm_vcpus, new_vm_memory
                cmd = unpackCmdFromJson(jsondict)
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
#                     vm_xml = get_xml(metadata_name)
#                     vm_json = toKubeJson(xmlToJson(vm_xml))
#                     body = updateDomainStructureInJson(jsondict, vm_json)
#                     modifyVM(metadata_name, body)
            else:
                cmd = unpackCmdFromJson(jsondict)
                runCmd(cmd)
        elif operation_type == 'MODIFIED':
            cmd = unpackCmdFromJson(jsondict)
            runCmd(cmd)
#                 if metadata_name:
#                     vm_xml = get_xml(metadata_name)
#                     vm_json = toKubeJson(xmlToJson(vm_xml))
#                     body = updateDomainStructureInJson(jsondict, vm_json)
#                     modifyVM(metadata_name, body)
        elif operation_type == 'DELETED':
            if metadata_name:
                destroy(metadata_name)
                undefine(metadata_name)

def getMetadataName(jsondict):
    return jsondict['raw_object']['metadata']['name']
            
'''
Get target VM name from Json.
'''
def getVMName(jsondict):
    spec = jsondict['raw_object']['spec']
    domain = spec.get('domain')
    if domain:
        return domain['name']['text']
    else:
        lifecycle = spec.get('lifecycle')
        the_key = None
        keys = lifecycle.keys()
        for key in keys:
            if key in SUPPORTCMDS.keys():
                cmd_head = SUPPORTCMDS.get(key)
                the_key = key
                break;
        print cmd_head
        if cmd_head and cmd_head.startswith('virt-'):
            return lifecycle[the_key].get('name')
    return None

def forceUsingMetadataName(metadata_name,jsondict):
    spec = jsondict['raw_object']['spec']
    lifecycle = spec.get('lifecycle')
    if lifecycle:
        the_key = None
        keys = lifecycle.keys()
        for key in keys:
            if key in SUPPORTCMDS.keys():
                cmd_head = SUPPORTCMDS.get(key)
                the_key = key
                break;
#         print(cmd_head)
        if cmd_head and cmd_head.startswith('virt-'):
            lifecycle[the_key]['name'] = metadata_name    
        elif cmd_head:
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
            if key in SUPPORTCMDS.keys():
                cmd_head = SUPPORTCMDS.get(key)
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
            if key in SUPPORTCMDS.keys():
                cmd_head = SUPPORTCMDS.get(key)
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
            if key in SUPPORTCMDS.keys():
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
                   
        
def modifyVM(name, body):
    retv = client.CustomObjectsApi().replace_namespaced_custom_object(
        group=GROUP, version=VERSION, namespace='default', plural=PLURAL, name=name, body=body)
    return retv

def updateVM(name, body):
    retv = client.CustomObjectsApi().patch_namespaced_custom_object(
        group=GROUP, version=VERSION, namespace='default', plural=PLURAL, name=name, body=body)
    return retv

def deleteVM(name, body):
    retv = client.CustomObjectsApi().delete_namespaced_custom_object(
        group=GROUP, version=VERSION, namespace='default', plural=PLURAL, name=name, body=body)
    return retv

#     for item in ret[0]["items"]:
# #         name = item['metadata']['name']
#         domain = item['spec']
#         del domain['nodeName']
#         image = domain['image']
#         del domain['image']
#         print(jsontoxml(str(domain).replace('None', "''")))

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

def _convertCharsInJsonBackup(val, t):
#     if val[0:1] == '_':
#         val = '_' + val
    val = str(val)
    if t == 'key':
        val = val.replace('_', '-')
        if not val.startswith('--'):
            return ''
    elif t == 'value':
        val = val.replace('null', '')
    return val

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
                if key in SUPPORTCMDS.keys():
                    the_cmd_key = key
                    cmd_head = SUPPORTCMDS.get(key)
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
            print("The CMD is: %s" % cmd)
    return cmd

'''
Unpack the CMD that will be executed in Json format.
'''
def unpackCmdFromJsonBackup(jsondict):
    vm_ = None
    cmd = None
    if jsondict:
        '''
        Get target VM name from Json.
        '''
        vm_ = jsondict['items'][0].get('metadata').get('name')
        if not vm_:
            raise Exception('No target VM in Json')
        spec = jsondict['items'][0].get('spec')
        if spec:
            '''
            Iterate keys in 'spec' structure and map them to real CMDs in back-end.
            Note that only the first CMD will be executed.
            '''
            cmd_head = ''
            the_cmd_key = None
            lifecycle = spec.get('lifecycle')
            if not lifecycle:
                return None
            keys = lifecycle.keys()
            for key in keys:
                contents = lifecycle.get(key)
                if key in SUPPORTCMDS.keys():
                    the_cmd_key = key
                    cmd_head = SUPPORTCMDS.get(key)
                    break;
            '''
            Get the CMD body from 'dict' structure.
            '''
            if the_cmd_key:
                cmd_body = ''
                for k, v in contents.items():
                    (k, v) = _convertCharsInJson(k, v)
#                     print k, v
                    cmd_body = '%s %s %s' % (cmd_body, k, v)
                cmd = '%s %s' % (cmd_head, cmd_body)
            print cmd
        return cmd
    return cmd

'''
Run back-end command in subprocess.
'''
def runCmd(cmd):
    std_err = None
    if not cmd:
        return
    p = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    try:
        p.stdout.readlines()
        std_err = p.stderr.readlines()
        return std_err
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

# def createVM(options):
#     vm_uuid = randomUUID() if not options.get("uuid") else options.get("uuid")
#     vm_mac = randomMAC() if not options.get("mac") else options.get("mac")
#     vm_name = options.get("name", "vm-" + vm_uuid[0:8])
#     vm_cpus = options.get("vcpu", 1)
#     vm_mem_mb = options.get("memory", 1024)
#     vm_cdrom = options.get("cd-rom", "/root/ISO/CentOS-7-x86_64-Minimal-1511.iso")
#     vm_disk_size_gb = options.get("disk-size-gb", 10)
#     vm_net_bridge = options.get("net-bridge", "virbr0")
#     create_vm_command = "virt-install --name %s --virt-type kvm " \
#     "--vcpus %s --ram %s --cdrom=%s " \
#     "--disk size=%s,format=qcow2  --network bridge=%s,mac=%s " \
#     "--graphics vnc,listen=0.0.0.0 --noautoconsole" \
#     % (vm_name, str(vm_cpus), str(vm_mem_mb), vm_cdrom, str(vm_disk_size_gb), vm_net_bridge, vm_mac)
# #     print create_vm_command
#     p = subprocess.Popen(create_vm_command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
#     p.stdout.readlines()
#     p.stderr.readlines()
#     p.stdout.close()
#     p.stderr.close()

if __name__ == '__main__':
#     print vm_state('Centos')
    config.load_kube_config(config_file=TOKEN)
    main()
#     createVM(options)