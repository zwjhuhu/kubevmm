'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn
'''

import time, datetime, socket
from dateutil.tz import gettz
from kubernetes import client, config
from kubernetes.client.models.v1_node_status import V1NodeStatus
from kubernetes.client.models.v1_node_condition import V1NodeCondition
from kubernetes.client.models.v1_node_daemon_endpoints import V1NodeDaemonEndpoints
from kubernetes.client.models.v1_node_system_info import V1NodeSystemInfo
from kubernetes.client.models.v1_node import V1Node
from kubernetes.client.models.v1_node_spec import V1NodeSpec
from kubernetes.client.models.v1_object_meta import V1ObjectMeta
from kubernetes.client.models.v1_node_address import V1NodeAddress

class VMWatcher:
    
    def __init__(self):
        self.node = V1Node()
        self.node_api_version = 'v1'
        self.node_kind = 'Node'
        self.node_metadata = V1ObjectMeta()
        self.node_spec = V1NodeSpec()
        pass

    def get_node(self):
        pass
        
    def get_status_address(self):
        hostname = socket.gethostname()
        ip = socket.gethostbyname(hostname)
        print hostname
        print ip

    def get_status_condition(self):
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
        
if __name__ == '__main__':
    r = VMWatcher()
    
#     print client.CoreV1Api().read_node_status(name="node11")
    #client.CoreV1Api().patch_node_status(name="mocker", body=body)
