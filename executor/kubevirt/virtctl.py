'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuheng@otcaix.iscas.ac.cn
@author: wuyuewen@otcaix.iscas.ac.cn
@author: shizhonghao17@otcaix.iscas.ac.cn

https://pypi.org/project/json2xml/
https://github.com/kubernetes/kubernetes/issues/51046
'''

from kubernetes import client, config
from json import loads
from json import dumps
from xmltodict import unparse
import os
import subprocess
import libvirt
import socket, random

GROUP = 'cloudplus.io'
VERSION = 'v1alpha3'
PLURAL = 'virtualmachines'

VMs = []

def listVM():
#     config.load_kube_config(config_file='/root/.kube/config')
#     thisLabel = "host==" + socket.gethostname()
    config.load_kube_config(config_file='/home/config')
    thisLabel = "host==node22"
    ret = client.CustomObjectsApi().list_cluster_custom_object_with_http_info(
        group=GROUP, version=VERSION, plural=PLURAL, label_selector=thisLabel)
    
    print ret

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
    
'''
   VM lifecycle
'''

def startVM():
    conn = libvirt.open("qemu:///system")
    domList = conn.listAllDomains(0)
    for domain in domList:
        xml = domain.XMLDesc()
        conn.createLinux(xml)
        
def randomUUID():
    u = [random.randint(0, 255) for ignore in range(0, 16)]
    u[6] = (u[6] & 0x0F) | (4 << 4)
    u[8] = (u[8] & 0x3F) | (2 << 6)
    return "-".join(["%02x" * 4, "%02x" * 2, "%02x" * 2, "%02x" * 2,
                     "%02x" * 6]) % tuple(u)

def randomMAC():
    mac = [ 0x52, 0x54, 0x00,
        random.randint(0x00, 0x7f),
        random.randint(0x00, 0xff),
        random.randint(0x00, 0xff) ]
    return ':'.join(map(lambda x: "%02x" % x, mac))
        
def createVM(options):
    vm_uuid = randomUUID() if not options.get("uuid") else options.get("uuid")
    vm_mac = randomMAC() if not options.get("mac") else options.get("mac")
    vm_name = options.get("name", "vm-" + vm_uuid[0:8])
    vm_cpus = options.get("cpu", 1)
    vm_mem_mb = options.get("mem-mb", 1024)
    vm_cdrom = options.get("cd-rom", "/root/ISO/CentOS-7-x86_64-Minimal-1511.iso")
    vm_disk_size_gb = options.get("disk-size-gb", 10)
    vm_net_bridge = options.get("net-bridge", "virbr0")
    create_vm_command = "virt-install --name %s --virt-type kvm " \
    "--vcpus %s --ram %s --cdrom=%s " \
    "--disk size=%s,format=qcow2  --network bridge=%s,mac=%s " \
    "--graphics vnc,listen=0.0.0.0 --noautoconsole" \
    % (vm_name, str(vm_cpus), str(vm_mem_mb), vm_cdrom, str(vm_disk_size_gb), vm_net_bridge, vm_mac)
#     print create_vm_command
    p = subprocess.Popen(create_vm_command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    p.stdout.readlines()
    p.stderr.readlines()
    p.stdout.close()
    p.stderr.close()

if __name__ == '__main__':
    listVM()
    options = {}
    createVM(options)

    
