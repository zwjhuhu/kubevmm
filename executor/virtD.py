'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn

'''
 
import atexit, os, sys, time, signal, datetime
from dateutil.tz import gettz
from kubernetes import client, config
from kubernetes.client.models.v1_node_status import V1NodeStatus
from kubernetes.client.models.v1_node_condition import V1NodeCondition
from kubernetes.client.models.v1_node_daemon_endpoints import V1NodeDaemonEndpoints
from kubernetes.client.models.v1_node_system_info import V1NodeSystemInfo
from kubernetes.client.models.v1_node import V1Node
 
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
        config.load_kube_config(config_file='/etc/kubernetes/admin.conf')
        while True:
            node = client.CoreV1Api().read_node_status(name="node11")
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
            node.status = node_status
            client.CoreV1Api().replace_node_status(name="node11", body=node)
            time.sleep(5)
 
 
if __name__ == '__main__':
    help_msg = 'Usage: python %s <start|stop|restart|status>' % sys.argv[0]
    if len(sys.argv) != 2:
        print help_msg
        sys.exit(1)
    p_name = 'virtctl'
    pid_fn = '/tmp/virtctl_daemon.pid'
    log_fn = '/tmp/virtctl_daemon.log'
    err_fn = '/tmp/virtctl_error.log'
    cD = ClientDaemon(p_name, pid_fn, stderr=err_fn, verbose=1)
 
    if sys.argv[1] == 'start':
        cD.start(log_fn)
    elif sys.argv[1] == 'stop':
        cD.stop()
    elif sys.argv[1] == 'restart':
        cD.restart(log_fn)
    elif sys.argv[1] == 'status':
        alive = cD.is_running()
        if alive:
            print 'process [%s] is running ......' % cD.get_pid()
        else:
            print 'daemon process [%s] stopped' %cD.name
    else:
        print 'invalid argument!'
        print help_msg


