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
from xmltodict import unparse
import libvirt
import socket

GROUP = 'cloudplus.io'
VERSION = 'v1alpha3'
PLURAL = 'virtualmachines'

def jsontoxml(jsonstr):
    json = jsonstr.replace('_interface', 'interface').replace(
        '_', '@').replace('text', '#text').replace('\'', '"')
    return unparse(loads(json))
    

def watchkube():
    config.load_kube_config(config_file='/root/.kube/config')
    thisLabel = "host==" + socket.gethostname()
    ret = client.CustomObjectsApi().list_cluster_custom_object_with_http_info(
        group=GROUP, version=VERSION, plural=PLURAL, label_selector=thisLabel)

    for item in ret[0]["items"]:
        del item["spec"]["nodeName"]
        print(jsontoxml(str(item['spec'])))
#   


def startVM():
    conn = libvirt.open("qemu:///system")
    domList = conn.listAllDomains(0)
    for domain in domList:
        xml = domain.XMLDesc()
        conn.createLinux(xml)

if __name__ == '__main__':
     watchkube()

    
