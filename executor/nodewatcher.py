'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn
'''

import time, datetime
from dateutil.tz import gettz
from kubernetes import client, config
from kubernetes.client.models.v1_node_status import V1NodeStatus
from kubernetes.client.models.v1_node_condition import V1NodeCondition
from kubernetes.client.models.v1_node_daemon_endpoints import V1NodeDaemonEndpoints
from kubernetes.client.models.v1_node_system_info import V1NodeSystemInfo
from kubernetes.client.models.v1_node import V1Node

class NodeWatcher:
    
    def __init__(self, node, interval):
        self.node = V1Node()
        self.interval = interval

    def get_node(self):
        return self.__node

    def set_node(self, value):
        self.__node = value

    def get_interval(self):
        return self.__interval

    def set_interval(self, value):
        self.__interval = value

    def getCondition(self):
        time_zone = gettz('Asia/Shanghai')
        now = datetime.datetime.now(tz=time_zone)
        condition1 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet has sufficient memory available", \
                            reason="KubeletHasSufficientMemory", status="False", type="MemoryPressure")
        condition2 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet has no disk pressure", \
                            reason="KubeletHasNoDiskPressure", status="False", type="DiskPressure")
        condition3 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet has sufficient PID available", \
                            reason="KubeletHasSufficientPID", status="False", type="PIDPressure")
        condition4 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="kubelet is posting ready status", \
                            reason="KubeletReady", status="True", type="Ready")    
        daemon_endpoints = V1NodeDaemonEndpoints(kubelet_endpoint={'port':0})
        node_info = V1NodeSystemInfo(architecture="", boot_id="", container_runtime_version="", \
                                     kernel_version="", kube_proxy_version="", kubelet_version="", \
                                     machine_id="", operating_system="", os_image="", system_uuid="")    
        node_status = V1NodeStatus(conditions=[condition1, condition2, condition3, condition4], daemon_endpoints=daemon_endpoints, \
                                   node_info=node_info)
        self.node.status = node_status
        client.CoreV1Api().replace_node_status(name="node11", body=self.node)
        
    interval = property(get_interval, set_interval, "interval's docstring")
    node = property(get_node, set_node, "node's docstring")

if __name__ == '__main__':
    r = NodeWatcher()
    
#     print client.CoreV1Api().read_node_status(name="node11")
    #client.CoreV1Api().patch_node_status(name="mocker", body=body)
