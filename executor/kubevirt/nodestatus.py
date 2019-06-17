'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn
'''

from kubernetes import client, config

if __name__ == '__main__':
    config.load_kube_config(config_file='admin.conf')
    thisLabel = 'kubernetes.io/hostname=mocker'
    ret = client.CoreV1Api().list_node(label_selector=thisLabel)
    print(type(ret))
    print(type(ret.items))
    print(type(ret.items[0].status))
   
    body = ret.items[0].status
    print(body.conditions)
    client.CoreV1Api().patch_node_status(name="mocker", body=body)
    pass
