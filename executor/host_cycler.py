'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn
'''

'''
Import python libs
'''
import os, sys, time, datetime, socket, subprocess, time, atexit, signal, traceback
import ConfigParser
from dateutil.tz import gettz

'''
Import third party libs
'''
from kubernetes import client, config
from kubernetes.client.models.v1_node_status import V1NodeStatus
from kubernetes.client.models.v1_node_condition import V1NodeCondition
from kubernetes.client.models.v1_node_daemon_endpoints import V1NodeDaemonEndpoints
from kubernetes.client.models.v1_node_system_info import V1NodeSystemInfo
from kubernetes.client.models.v1_node import V1Node
from kubernetes.client.models.v1_node_spec import V1NodeSpec
from kubernetes.client.models.v1_object_meta import V1ObjectMeta
from kubernetes.client.models.v1_node_address import V1NodeAddress

'''
Import local libs
'''
from libvirt_util import freecpu, freemem, node_info
import logger

class parser(ConfigParser.ConfigParser):  
    def __init__(self,defaults=None):  
        ConfigParser.ConfigParser.__init__(self,defaults=None)  
    def optionxform(self, optionstr):  
        return optionstr 

cfg = "%s/default.cfg" % os.path.dirname(os.path.realpath(__file__))
config_raw = parser()
config_raw.read(cfg)

TOKEN = config_raw.get('Kubernetes', 'token_file')
HOSTNAME = socket.gethostname()

logger = logger.set_logger('/var/log/virtlet_host_cycler_output.log')

class CDaemon:
    '''
    a generic daemon class.
    usage: subclass the CDaemon class and override the run() method
    stderr:
    verbose:
    save_path:
    '''
    def __init__(self, save_path, stdin=os.devnull, stdout=os.devnull, stderr=os.devnull, home_dir='.', umask=022, verbose=1):
        self.stdin = stdin
        self.stdout = stdout
        self.stderr = stderr
        self.pidfile = save_path
        self.home_dir = home_dir
        self.verbose = verbose
        self.umask = umask
        self.daemon_alive = True
 
    def daemonize(self):
        try:
            pid = os.fork()
            if pid > 0:
                sys.exit(0)
        except OSError, e:
            sys.stderr.write('fork #1 failed: %d (%s)\n' % (e.errno, e.strerror))
            sys.exit(1)
 
        os.chdir(self.home_dir)
        os.setsid()
        os.umask(self.umask)
 
        try:
            pid = os.fork()
            if pid > 0:
                sys.exit(0)
        except OSError, e:
            sys.stderr.write('fork #2 failed: %d (%s)\n' % (e.errno, e.strerror))
            sys.exit(1)
 
        sys.stdout.flush()
        sys.stderr.flush()
 
        si = file(self.stdin, 'r')
        so = file(self.stdout, 'a+')
        if self.stderr:
            se = file(self.stderr, 'a+', 0)
        else:
            se = so
 
        os.dup2(si.fileno(), sys.stdin.fileno())
        os.dup2(so.fileno(), sys.stdout.fileno())
        os.dup2(se.fileno(), sys.stderr.fileno())
 
        def sig_handler(signum, frame):
            self.daemon_alive = False
        signal.signal(signal.SIGTERM, sig_handler)
        signal.signal(signal.SIGINT, sig_handler)
 
        if self.verbose >= 1:
            print 'daemon process started ...'
 
        atexit.register(self.del_pid)
        pid = str(os.getpid())
        file(self.pidfile, 'w+').write('%s\n' % pid)
 
    def get_pid(self):
        try:
            pf = file(self.pidfile, 'r')
            pid = int(pf.read().strip())
            pf.close()
        except IOError:
            pid = None
        except SystemExit:
            pid = None
        return pid
 
    def del_pid(self):
        if os.path.exists(self.pidfile):
            os.remove(self.pidfile)
 
    def start(self, *args, **kwargs):
        if self.verbose >= 1:
            print 'ready to starting ......'
        #check for a pid file to see if the daemon already runs
        pid = self.get_pid()
        if pid:
            msg = 'pid file %s already exists, is it already running?\n'
            sys.stderr.write(msg % self.pidfile)
            sys.exit(1)
        #start the daemon
        self.daemonize()
        self.run(*args, **kwargs)
 
    def stop(self):
        if self.verbose >= 1:
            print 'stopping ...'
        pid = self.get_pid()
        if not pid:
            msg = 'pid file [%s] does not exist. Not running?\n' % self.pidfile
            sys.stderr.write(msg)
            if os.path.exists(self.pidfile):
                os.remove(self.pidfile)
            return
        #try to kill the daemon process
        try:
            i = 0
            while 1:
                os.kill(pid, signal.SIGTERM)
                time.sleep(0.1)
                i = i + 1
                if i % 10 == 0:
                    os.kill(pid, signal.SIGHUP)
        except OSError, err:
            err = str(err)
            if err.find('No such process') > 0:
                if os.path.exists(self.pidfile):
                    os.remove(self.pidfile)
            else:
                print str(err)
                sys.exit(1)
            if self.verbose >= 1:
                print 'Stopped!'
 
    def restart(self, *args, **kwargs):
        self.stop()
        self.start(*args, **kwargs)
 
    def is_running(self):
        pid = self.get_pid()
        #print(pid)
        return pid and os.path.exists('/proc/%d' % pid)
 
    def run(self, *args, **kwargs):
        'NOTE: override the method in subclass'
        print 'base class run()'
 
class ClientDaemon(CDaemon):
    def __init__(self, name, save_path, stdin=os.devnull, stdout=os.devnull, stderr=os.devnull, home_dir='.', umask=022, verbose=1):
        CDaemon.__init__(self, save_path, stdin, stdout, stderr, home_dir, umask, verbose)
        self.name = name
 
    def run(self, output_fn, **kwargs):
        try:
            main()
        except Exception, e:
            traceback.print_exc()
            main()
            
def daemonize():
    help_msg = 'Usage: python %s <start|stop|restart|status>' % sys.argv[0]
    if len(sys.argv) != 2:
        print help_msg
        sys.exit(1)
    p_name = 'virtlet_host_cycler'
    pid_fn = '/tmp/virtlet_host_cycler_daemon.pid'
    log_fn = '/var/log/virtlet_host_cycler_output.log'
    err_fn = '/var/log/virtlet_host_cycler_error.log'
    cD1 = ClientDaemon(p_name, pid_fn, stdout=log_fn, stderr=err_fn, verbose=1)
 
    if sys.argv[1] == 'start':
        cD1.start(log_fn)
    elif sys.argv[1] == 'stop':
        cD1.stop()
    elif sys.argv[1] == 'restart':
        cD1.restart(log_fn)
    elif sys.argv[1] == 'status':
        alive = cD1.is_running()
        if alive:
            print 'process [%s] is running ......' % cD1.get_pid()
        else:
            print 'daemon process [%s] stopped' %cD1.name
    else:
        print 'invalid argument!'
        print help_msg

def main():
    config.load_kube_config(config_file=TOKEN)
    while True:
        host = client.CoreV1Api().read_node_status(name='node12')
        node_watcher = HostCycler()
        host.status = node_watcher.get_node_status()
        client.CoreV1Api().replace_node_status(name='node12', body=host)
        time.sleep(8)

class HostCycler:
    
    def __init__(self):
        self.node_status = V1NodeStatus(addresses=self.get_status_address(), allocatable=self.get_status_allocatable(), 
                            capacity=self.get_status_capacity(), conditions=self.get_status_condition(),
                            daemon_endpoints=self.get_status_daemon_endpoints(), node_info=self.get_status_node_info())
        self.node = V1Node(api_version='v1', kind='Node', metadata=self.get_object_metadata(), spec=self.get_node_spec(), status=self.node_status)
        self.__node = self.node
        self.__node_status = self.node_status

    def get_node(self):
        return self.__node

    def get_node_status(self):
        return self.__node_status

    def _format_mem_to_mb(self, mem):
        return int(round(int(mem) / 1000))
    
    '''
    Run back-end command in subprocess.
    '''
    def runCmd(self, cmd):
        std_err = None
        if not cmd:
            return
        p = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        try:
            std_out = p.stdout.readlines()
            std_err = p.stderr.readlines()
            return str.strip(std_out[0]) if std_out else ''
        finally:
            p.stdout.close()
            p.stderr.close()

    def get_node_spec(self):
        return V1NodeSpec()
    
    def get_object_metadata(self):
        return V1ObjectMeta(annotations=[], name=socket.gethostname(), uid='', labels=[], resource_version='', self_link='')
    
    def get_status_address(self):
        hostname = socket.gethostname()
        ip = socket.gethostbyname(hostname)
        node_status_address1 = V1NodeAddress(address=ip, type='InternalIP')
        node_status_address2 = V1NodeAddress(address=hostname, type='Hostname')
        return [node_status_address1, node_status_address2]
    
    def get_status_allocatable(self):
        cpu_allocatable = freecpu()
        mem_allocatable = self._format_mem_to_mb(freemem())
        return {'cpu': str(cpu_allocatable), 'memory': str(mem_allocatable)}
    
    def get_status_capacity(self):
        node_info_dict = node_info()
        cpu_capacity = node_info_dict.get('cpus')
        mem_capacity = self._format_mem_to_mb(node_info_dict.get('phymemory'))
        return {'cpu': str(cpu_capacity), 'memory': str(mem_capacity)}
    
    def get_status_daemon_endpoints(self):
        return V1NodeDaemonEndpoints(kubelet_endpoint={'port':0})

    def get_status_condition(self):
        time_zone = gettz('Asia/Shanghai')
        now = datetime.datetime.now(tz=time_zone)
        condition1 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="virtlet has sufficient memory available", \
                            reason="VirtletHasSufficientMemory", status="False", type="MemoryPressure")
        condition2 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="virtlet has no disk pressure", \
                            reason="VirtletHasNoDiskPressure", status="False", type="DiskPressure")
        condition3 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="virtlet has sufficient PID available", \
                            reason="VirtletHasSufficientPID", status="False", type="PIDPressure")
        condition4 = V1NodeCondition(last_heartbeat_time=now, last_transition_time=now, message="virtlet is posting ready status", \
                            reason="VirtletReady", status="True", type="Ready")    
        return [condition1, condition2, condition3, condition4]
    
#         node_status = V1NodeStatus(conditions=[condition1, condition2, condition3, condition4], daemon_endpoints=daemon_endpoints, \
#                                    node_info=node_info)
#         self.node.status = node_status
#         client.CoreV1Api().replace_node_status(name="node11", body=self.node)
        
    def get_status_node_info(self):
        ARCHITECTURE = self.runCmd('uname -m')
        BOOT_ID = self.runCmd('cat /sys/class/dmi/id/product_uuid')
        RUNTIME_VERSION = 'QEMU-KVM://%s' % (self.runCmd('/usr/libexec/qemu-kvm -version | awk \'NR==1 {print $4}\''))
        KERNEL_VERSION = self.runCmd('cat /proc/sys/kernel/osrelease')
        KUBE_PROXY_VERSION = self.runCmd('kubelet --version | awk \'{print $2}\'')
        KUBELET_VERSION = KUBE_PROXY_VERSION
        MACHINE_ID = BOOT_ID
        OPERATING_SYSTEM = self.runCmd('cat /proc/sys/kernel/ostype')
        OS_IMAGE = self.runCmd('cat /etc/os-release | grep PRETTY_NAME | awk -F"\\"" \'{print$2}\'')
        SYSTEM_UUID = BOOT_ID
        return V1NodeSystemInfo(architecture=ARCHITECTURE, boot_id=BOOT_ID, container_runtime_version=RUNTIME_VERSION, \
                     kernel_version=KERNEL_VERSION, kube_proxy_version=KUBE_PROXY_VERSION, kubelet_version=KUBELET_VERSION, \
                     machine_id=MACHINE_ID, operating_system=OPERATING_SYSTEM, os_image=OS_IMAGE, system_uuid=SYSTEM_UUID)
        
    node = property(get_node, "node's docstring")
    node_status = property(get_node_status, "node_status's docstring")

if __name__ == "__main__":
    daemonize()
