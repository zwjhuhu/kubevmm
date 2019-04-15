'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuheng@otcaix.iscas.ac.cn
'''

from kubernetes import client, config
import libvirt

def startVM():
    conn = libvirt.open("qemu:///system")
    domList = conn.listAllDomains(0)
    for domain in domList:
        xml = domain.XMLDesc()
        conn.createLinux(xml)

if __name__ == '__main__':
    config.load_kube_config(config_file='/root/.kube/config')
    v1 = client.CoreV1Api()
    ret = v1.list_pod_for_all_namespaces(watch=False)
    for i in ret.items:
        print("%s\t%s\t%s" % (i.status.pod_ip, i.metadata.namespace, i.metadata.name))