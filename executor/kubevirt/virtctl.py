'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuheng@otcaix.iscas.ac.cn
@author: wuyuewen@otcaix.iscas.ac.cn
@author: shizhonghao17@otcaix.iscas.ac.cn

https://github.com/kubernetes/kubernetes/issues/51046
'''

from kubernetes import client, config, watch
import libvirt
import socket
from lib2to3.pgen2.tokenize import group
from kubernetes.client.models import v1_resource_field_selector
from curses.ascii import SO

GROUP = 'cloudplus.io'
VERSION = 'v1alpha3'
PLURAL = 'virtualmachines'

def watchkube():
    config.load_kube_config(config_file='/root/.kube/config')
#     ret = client.CustomObjectsApi().list_cluster_custom_object_with_http_info(
#         group=GROUP, version=VERSION, plural=PLURAL)
    v1 = client.CustomObjectsApi()
    w  = watch.Watch()
    for event in w.stream(v1.list_cluster_custom_object, group=GROUP, version=VERSION, plural=PLURAL):
        if event["object"]["spec"]["nodeName"] == socket.gethostname():
            vmname    = event["object"]["metadata"]["name"]
            namespace = event["object"]["metadata"]["namespace"]
            if event["type"] == "ADDED":
                client.CustomObjectsApi().list_cluster_custom_object(group=GROUP, version=VERSION, plural=PLURAL)


def startVM():
    conn = libvirt.open("qemu:///system")
    domList = conn.listAllDomains(0)
    for domain in domList:
        xml = domain.XMLDesc()
        conn.createLinux(xml)

if __name__ == '__main__':
     watchkube()

    
