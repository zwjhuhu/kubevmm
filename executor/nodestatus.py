'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn
'''

import time, datetime
from dateutil.tz import tzutc
from kubernetes import client, config
from kubernetes.client.models.v1_node_status import V1NodeStatus
from kubernetes.client.models.v1_node_condition import V1NodeCondition

if __name__ == '__main__':
    config.load_kube_config(config_file='/etc/kubernetes/admin.conf')
#     thisLabel = 'kubernetes.io/hostname=node22'
#     ret = client.CoreV1Api().list_node(label_selector=thisLabel)
#     print(type(ret))
#     print(type(ret.items))
#     print(type(ret.items[0].status))
   
#     now = time.strftime("%Y-%m-%dT%H:%M:%SZ")
    now = datetime.datetime(2019, 6, 18, 7, 4, 3, tzinfo=tzutc())
    condition1 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet has sufficient memory available", \
                        reason="KubeletHasSufficientMemory", status="False", type="MemoryPressure")
    condition2 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet has no disk pressure", \
                        reason="KubeletHasNoDiskPressure", status="False", type="DiskPressure")
    condition3 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet has sufficient PID available", \
                        reason="KubeletHasSufficientPID", status="False", type="PIDPressure")
    condition4 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet is posting ready status", \
                        reason="KubeletReady", status="True", type="Ready")        
    node_status = V1NodeStatus(conditions=[condition1, condition2, condition3, condition4])
    print node_status
    print client.CoreV1Api().patch_node_status_with_http_info(name="k8s-node1", body=node_status)
    #client.CoreV1Api().patch_node_status(name="mocker", body=body)
    pass
