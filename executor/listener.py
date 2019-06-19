'''
Created on 

@author: yk
'''

from kubernetes import client, config, watch, stream

NAME = 'virtualmachines.cloudplus.io'
PLURAL = 'virtualmachines'
VERSION = 'v1alpha3'
GROUP = 'cloudplus.io'

LABEL = 'host=node22'
CMD = 'http://127.0.0.1:9090/apis/[GROUP]/[VERSION]/[PLURAL]?labelSelector=host%3Dlocalhost.localdomain2&watch=true'

if __name__ == '__main__':
    config.load_kube_config(config_file='admin.conf')
#     crd = client.ApiextensionsV1beta1Api().read_custom_resource_definition(NAME)
#     client.CustomObjectsApi().list_cluster_custom_object_with_http_info(group=GROUP, version=VERSION, plural=PLURAL, labelSelector='host=a', watch=True);
    print('hello')
    w = watch.Watch()
    kwargs = {}
    kwargs['label_selector'] = LABEL
    kwargs['watch'] = True
    for vm in w.stream(client.CustomObjectsApi().list_cluster_custom_object,
                                group=GROUP, version=VERSION, plural=PLURAL, **kwargs):
        print(vm)
    pass