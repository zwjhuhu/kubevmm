'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn

https://pypi.org/project/json2xml/
https://github.com/kubernetes/kubernetes/issues/51046
'''

'''
Import python libs
'''
import os
import subprocess
import random
import ConfigParser
import xmltodict
import re
from xml.dom import minidom
from StringIO import StringIO as _StringIO

'''
Import third party libs
'''
from kubernetes import client, config
from json import loads
from json import dumps
from xmltodict import unparse

try:
    import libvirt
    HAS_LIBVIRT = True
except ImportError:
    HAS_LIBVIRT = False

cfg = "%s/default.cfg" % os.path.realpath(__file__)
config_raw = ConfigParser.RawConfigParser()
config_raw.read(cfg)

TOKEN = config_raw.get('Kubernetes', 'token_file')
PLURAL = config_raw.get('VirtualMachine', 'plural')
VERSION = config_raw.get('VirtualMachine', 'version')
GROUP = config_raw.get('VirtualMachine', 'group')
SUPPORTCMDS = config_raw.items('SupportCmds')

VIRT_STATE_NAME_MAP = {0: 'running',
                       1: 'running',
                       2: 'running',
                       3: 'paused',
                       4: 'shutdown',
                       5: 'shutdown',
                       6: 'crashed'}

def listVM(node):
#     config.load_kube_config(config_file='/root/.kube/config')
#     thisLabel = "host==" + socket.gethostname()
    config.load_kube_config(config_file=TOKEN)
    thisLabel = "host==%s" % node
    retv = client.CustomObjectsApi().list_cluster_custom_object(
        group=GROUP, version=VERSION, plural=PLURAL, label_selector=thisLabel)
    return retv
    
#     for item in ret[0]["items"]:
# #         name = item['metadata']['name']
#         domain = item['spec']
#         del domain['nodeName']
#         image = domain['image']
#         del domain['image']
#         print(jsontoxml(str(domain).replace('None', "''")))

def jsontoxml(jsonstr):
    json = jsonstr.replace('_interface', 'interface').replace('_transient', 'transient').replace(
        'suspend_to_mem', 'suspend-to-mem').replace('suspend_to_disk', 'suspend-to-disk').replace(
            'on_crash', 'on-crash').replace('on_poweroff', 'on-poweroff').replace('on_reboot', 'on-reboot').replace(
            'nested_hv', "nested-hv").replace('_', '@').replace('text', '#text').replace('\'', '"')
    return unparse(loads(json))

'''
Covert chars according to real CMD in back-end.
'''
def _convertCharsInJson(val, t):
    if t == 'key':
        val.replace('_', '-') 
    elif t == 'value':
        val.replace('null', '')
    return val

'''
Unpack the CMD that will be executed in Json format.
'''
def unpackCmdFromJson(jsondict):
    vm_ = None
    cmd = None
    if jsondict:
        '''
        Get target VM name from Json. 
        '''
        vm_ = jsondict['items'][0].get('metadata').get('name')
        if not vm_:
            raise Exception('No target VM in Json')
        spec = jsondict['items'][0].get('spec')
        if spec:
            '''
            Iterate keys in 'spec' structure and map them to real CMDs in back-end.
            Note that only the first CMD will be executed.
            '''
            cmd_head = None
            the_cmd_key = None
            keys = spec.getKeys()
            for key in keys:
                if key in SUPPORTCMDS.keys():
                    the_cmd_key = key
                    cmd_head = SUPPORTCMDS.get(key)
                    break;
            '''
            Get the CMD body from 'dict' structure. 
            '''
            if the_cmd_key:
                cmd_body = None
                contents = spec.get(the_cmd_key)
                for k, v in contents.items():
                    k = _convertCharsInJson(k, 'key')
                    v = _convertCharsInJson(v, 'value')
                    cmd_body += k,v
                cmd = cmd_head, cmd_body
            print cmd
        return cmd
    return cmd

'''
Run back-end command in subprocess.
'''
def runCmd(cmd):
    try:
        p = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        p.stdout.readlines()
        p.stderr.readlines()
    finally:
        p.stdout.close()
        p.stderr.close() 
    
'''
   VM lifecycle
'''

def __get_conn():
    '''
    Detects what type of dom this node is and attempts to connect to the
    correct hypervisor via libvirt.
    '''
    # This has only been tested on kvm and xen, it needs to be expanded to
    # support all vm layers supported by libvirt
    try:
        conn = libvirt.open('qemu:///system')
    except Exception:
        raise Exception(
            'Sorry, {0} failed to open a connection to the hypervisor '
            'software'
        )
    return conn
   
   
def _get_dom(vm_):
    '''
    Return a domain object for the named vm
    '''
    conn = __get_conn()
    if vm_ not in list_vms():
        raise Exception('The specified vm is not present')
    return conn.lookupByName(vm_)

def list_vms():
    '''
    Return a list of virtual machine names on the minion
   
    CLI Example::
   
        salt '*' virt.list_vms
    '''
    vms = []
    vms.extend(list_active_vms())
    vms.extend(list_inactive_vms())
    return vms

def list_active_vms():
    '''
    Return a list of names for active virtual machine on the minion
   
    CLI Example::
   
        salt '*' virt.list_active_vms
    '''
    conn = __get_conn()
    vms = []
    for id_ in conn.listDomainsID():
        vms.append(conn.lookupByID(id_).name())
    return vms
   
   
def list_inactive_vms():
    '''
    Return a list of names for inactive virtual machine on the minion
   
    CLI Example::
   
        salt '*' virt.list_inactive_vms
    '''
    conn = __get_conn()
    vms = []
    for id_ in conn.listDefinedDomains():
        vms.append(id_)
    return vms

def vm_info(vm_=None):
    '''
    Return detailed information about the vms on this hyper in a
    list of dicts::
   
        [
            'your-vm': {
                'cpu': <int>,
                'maxMem': <int>,
                'mem': <int>,
                'state': '<state>',
                'cputime' <int>
                },
            ...
            ]
   
    If you pass a VM name in as an argument then it will return info
    for just the named VM, otherwise it will return all VMs.
   
    CLI Example::
   
        salt '*' virt.vm_info
    '''
    def _info(vm_):
        dom = _get_dom(vm_)
        raw = dom.info()
        return {'cpu': raw[3],
                'cputime': int(raw[4]),
                'disks': get_disks(vm_),
                'graphics': get_graphics(vm_),
                'nics': get_nics(vm_),
                'maxMem': int(raw[1]),
                'mem': int(raw[2]),
                'state': VIRT_STATE_NAME_MAP.get(raw[0], 'unknown')}
    info = {}
    if vm_:
        info[vm_] = _info(vm_)
    else:
        for vm_ in list_vms():
            info[vm_] = _info(vm_)
    return info
   
   
def vm_state(vm_=None):
    '''
    Return list of all the vms and their state.
   
    If you pass a VM name in as an argument then it will return info
    for just the named VM, otherwise it will return all VMs.
   
    CLI Example::
   
        salt '*' virt.vm_state <vm name>
    '''
    def _info(vm_):
        state = ''
        dom = _get_dom(vm_)
        raw = dom.info()
        state = VIRT_STATE_NAME_MAP.get(raw[0], 'unknown')
        return state
    info = {}
    if vm_:
        info[vm_] = _info(vm_)
    else:
        for vm_ in list_vms():
            info[vm_] = _info(vm_)
    return info
   
   
def node_info():
    '''
    Return a dict with information about this node
   
    CLI Example::
   
        salt '*' virt.node_info
    '''
    conn = __get_conn()
    raw = conn.getInfo()
    info = {'cpucores': raw[6],
            'cpumhz': raw[3],
            'cpumodel': str(raw[0]),
            'cpus': raw[2],
            'cputhreads': raw[7],
            'numanodes': raw[4],
            'phymemory': raw[1],
            'sockets': raw[5]}
    return info

def get_nics(vm_):
    '''
    Return info about the network interfaces of a named vm
   
    CLI Example::
   
        salt '*' virt.get_nics <vm name>
    '''
    nics = {}
    doc = minidom.parse(_StringIO(get_xml(vm_)))
    for node in doc.getElementsByTagName('devices'):
        i_nodes = node.getElementsByTagName('interface')
        for i_node in i_nodes:
            nic = {}
            nic['type'] = i_node.getAttribute('type')
            for v_node in i_node.getElementsByTagName('*'):
                if v_node.tagName == 'mac':
                    nic['mac'] = v_node.getAttribute('address')
                if v_node.tagName == 'model':
                    nic['model'] = v_node.getAttribute('type')
                if v_node.tagName == 'target':
                    nic['target'] = v_node.getAttribute('dev')
                # driver, source, and match can all have optional attributes
                if re.match('(driver|source|address)', v_node.tagName):
                    temp = {}
                    for key in v_node.attributes.keys():
                        temp[key] = v_node.getAttribute(key)
                    nic[str(v_node.tagName)] = temp
                # virtualport needs to be handled separately, to pick up the
                # type attribute of the virtualport itself
                if v_node.tagName == 'virtualport':
                    temp = {}
                    temp['type'] = v_node.getAttribute('type')
                    for key in v_node.attributes.keys():
                        temp[key] = v_node.getAttribute(key)
                    nic['virtualport'] = temp
            if 'mac' not in nic:
                continue
            nics[nic['mac']] = nic
    return nics
   
   
def get_macs(vm_):
    '''
    Return a list off MAC addresses from the named vm
   
    CLI Example::
   
        salt '*' virt.get_macs <vm name>
    '''
    macs = []
    doc = minidom.parse(_StringIO(get_xml(vm_)))
    for node in doc.getElementsByTagName('devices'):
        i_nodes = node.getElementsByTagName('interface')
        for i_node in i_nodes:
            for v_node in i_node.getElementsByTagName('mac'):
                macs.append(v_node.getAttribute('address'))
    return macs
   
   
def get_graphics(vm_):
    '''
    Returns the information on vnc for a given vm
   
    CLI Example::
   
        salt '*' virt.get_graphics <vm name>
    '''
    out = {'autoport': 'None',
           'keymap': 'None',
           'listen': 'None',
           'port': 'None',
           'type': 'vnc'}
    xml = get_xml(vm_)
    ssock = _StringIO(xml)
    doc = minidom.parse(ssock)
    for node in doc.getElementsByTagName('domain'):
        g_nodes = node.getElementsByTagName('graphics')
        for g_node in g_nodes:
            for key in g_node.attributes.keys():
                out[key] = g_node.getAttribute(key)
    return out
   
   
def get_disks(vm_):
    '''
    Return the disks of a named vm
   
    CLI Example::
   
        salt '*' virt.get_disks <vm name>
    '''
    disks = {}
    doc = minidom.parse(_StringIO(get_xml(vm_)))
    for elem in doc.getElementsByTagName('disk'):
        sources = elem.getElementsByTagName('source')
        targets = elem.getElementsByTagName('target')
        if len(sources) > 0:
            source = sources[0]
        else:
            continue
        if len(targets) > 0:
            target = targets[0]
        else:
            continue
        if target.hasAttribute('dev'):
            qemu_target = ''
            if source.hasAttribute('file'):
                qemu_target = source.getAttribute('file')
            elif source.hasAttribute('dev'):
                qemu_target = source.getAttribute('dev')
            elif source.hasAttribute('protocol') and \
                    source.hasAttribute('name'): # For rbd network
                qemu_target = '%s:%s' %(
                        source.getAttribute('protocol'),
                        source.getAttribute('name'))
            if qemu_target:
                disks[target.getAttribute('dev')] = {\
                    'file': qemu_target}
    for dev in disks:
        try:
            output = []
            qemu_output = subprocess.Popen(['qemu-img', 'info',
                disks[dev]['file']],
                shell=False,
                stdout=subprocess.PIPE).communicate()[0]
            snapshots = False
            columns = None
            lines = qemu_output.strip().split('\n')
            for line in lines:
                if line.startswith('Snapshot list:'):
                    snapshots = True
                    continue
                elif snapshots:
                    if line.startswith('ID'):  # Do not parse table headers
                        line = line.replace('VM SIZE', 'VMSIZE')
                        line = line.replace('VM CLOCK', 'TIME VMCLOCK')
                        columns = re.split('\s+', line)
                        columns = [c.lower() for c in columns]
                        output.append('snapshots:')
                        continue
                    fields = re.split('\s+', line)
                    for i, field in enumerate(fields):
                        sep = ' '
                        if i == 0:
                            sep = '-'
                        output.append(
                            '{0} {1}: "{2}"'.format(
                                sep, columns[i], field
                            )
                        )
                    continue
                output.append(line)
            output = '\n'.join(output)
            disks[dev].update(output)
        except TypeError:
            disks[dev].update('image: Does not exist')
    return disks
   
   
def setmem(vm_, memory, config=False):
    '''
    Changes the amount of memory allocated to VM. The VM must be shutdown
    for this to work.
   
    memory is to be specified in MB
    If config is True then we ask libvirt to modify the config as well
   
    CLI Example::
   
        salt '*' virt.setmem myvm 768
    '''
    if vm_state(vm_) != 'shutdown':
        return False
   
    dom = _get_dom(vm_)
   
    # libvirt has a funny bitwise system for the flags in that the flag
    # to affect the "current" setting is 0, which means that to set the
    # current setting we have to call it a second time with just 0 set
    flags = libvirt.VIR_DOMAIN_MEM_MAXIMUM
    if config:
        flags = flags | libvirt.VIR_DOMAIN_AFFECT_CONFIG
   
    ret1 = dom.setMemoryFlags(memory * 1024, flags)
    ret2 = dom.setMemoryFlags(memory * 1024, libvirt.VIR_DOMAIN_AFFECT_CURRENT)
   
    # return True if both calls succeeded
    return ret1 == ret2 == 0
   
   
def setvcpus(vm_, vcpus, config=False):
    '''
    Changes the amount of vcpus allocated to VM. The VM must be shutdown
    for this to work.
   
    vcpus is an int representing the number to be assigned
    If config is True then we ask libvirt to modify the config as well
   
    CLI Example::
   
        salt '*' virt.setvcpus myvm 2
    '''
    if vm_state(vm_) != 'shutdown':
        return False
   
    dom = _get_dom(vm_)
   
    # see notes in setmem
    flags = libvirt.VIR_DOMAIN_VCPU_MAXIMUM
    if config:
        flags = flags | libvirt.VIR_DOMAIN_AFFECT_CONFIG
   
    ret1 = dom.setVcpusFlags(vcpus, flags)
    ret2 = dom.setVcpusFlags(vcpus, libvirt.VIR_DOMAIN_AFFECT_CURRENT)
   
    return ret1 == ret2 == 0
   
   
def freemem():
    '''
    Return an int representing the amount of memory that has not been given
    to virtual machines on this node
   
    CLI Example::
   
        salt '*' virt.freemem
    '''
    conn = __get_conn()
    mem = conn.getInfo()[1]
    # Take off just enough to sustain the hypervisor
    mem -= 256
    for vm_ in list_vms():
        dom = _get_dom(vm_)
        if dom.ID() > 0:
            mem -= dom.info()[2] / 1024
    return mem
   
   
def freecpu():
    '''
    Return an int representing the number of unallocated cpus on this
    hypervisor
   
    CLI Example::
   
        salt '*' virt.freecpu
    '''
    conn = __get_conn()
    cpus = conn.getInfo()[2]
    for vm_ in list_vms():
        dom = _get_dom(vm_)
        if dom.ID() > 0:
            cpus -= dom.info()[3]
    return cpus
   
   
def full_info():
    '''
    Return the node_info, vm_info and freemem
   
    CLI Example::
   
        salt '*' virt.full_info
    '''
    return {'freecpu': freecpu(),
            'freemem': freemem(),
            'node_info': node_info(),
            'vm_info': vm_info()}
   
   
def get_xml(vm_):
    '''
    Returns the xml for a given vm
   
    CLI Example::
   
        salt '*' virt.get_xml <vm name>
    '''
    dom = _get_dom(vm_)
    return dom.XMLDesc(0)
   
   
def shutdown(vm_):
    '''
    Send a soft shutdown signal to the named vm
   
    CLI Example::
   
        salt '*' virt.shutdown <vm name>
    '''
    dom = _get_dom(vm_)
    return dom.shutdown() == 0
   
   
def pause(vm_):
    '''
    Pause the named vm
   
    CLI Example::
   
        salt '*' virt.pause <vm name>
    '''
    dom = _get_dom(vm_)
    return dom.suspend() == 0
   
   
def resume(vm_):
    '''
    Resume the named vm
   
    CLI Example::
   
        salt '*' virt.resume <vm name>
    '''
    dom = _get_dom(vm_)
    return dom.resume() == 0
   
   
def create(vm_):
    '''
    Start a defined domain
   
    CLI Example::
   
        salt '*' virt.create <vm name>
    '''
    dom = _get_dom(vm_)
    return dom.create() == 0
   
   
def start(vm_):
    '''
    Alias for the obscurely named 'create' function
   
    CLI Example::
   
        salt '*' virt.start <vm name>
    '''
    return create(vm_)
   
   
def reboot(vm_):
    '''
    Reboot a domain via ACPI request
   
    CLI Example::
   
        salt '*' virt.reboot <vm name>
    '''
    dom = _get_dom(vm_)
   
    # reboot has a few modes of operation, passing 0 in means the
    # hypervisor will pick the best method for rebooting
    return dom.reboot(0) == 0
   
   
def reset(vm_):
    '''
    Reset a VM by emulating the reset button on a physical machine
   
    CLI Example::
   
        salt '*' virt.reset <vm name>
    '''
    dom = _get_dom(vm_)
   
    # reset takes a flag, like reboot, but it is not yet used
    # so we just pass in 0
    # see: http://libvirt.org/html/libvirt-libvirt.html#virDomainReset
    return dom.reset(0) == 0
   
   
def ctrl_alt_del(vm_):
    '''
    Sends CTRL+ALT+DEL to a VM
   
    CLI Example::
   
        salt '*' virt.ctrl_alt_del <vm name>
    '''
    dom = _get_dom(vm_)
    return dom.sendKey(0, 0, [29, 56, 111], 3, 0) == 0
        
# def randomUUID():
#     u = [random.randint(0, 255) for ignore in range(0, 16)]
#     u[6] = (u[6] & 0x0F) | (4 << 4)
#     u[8] = (u[8] & 0x3F) | (2 << 6)
#     return "-".join(["%02x" * 4, "%02x" * 2, "%02x" * 2, "%02x" * 2,
#                      "%02x" * 6]) % tuple(u)
# 
# def randomMAC():
#     mac = [ 0x52, 0x54, 0x00,
#         random.randint(0x00, 0x7f),
#         random.randint(0x00, 0xff),
#         random.randint(0x00, 0xff) ]
#     return ':'.join(map(lambda x: "%02x" % x, mac))   
        
# def createVM(options):
#     vm_uuid = randomUUID() if not options.get("uuid") else options.get("uuid")
#     vm_mac = randomMAC() if not options.get("mac") else options.get("mac")
#     vm_name = options.get("name", "vm-" + vm_uuid[0:8])
#     vm_cpus = options.get("vcpu", 1)
#     vm_mem_mb = options.get("memory", 1024)
#     vm_cdrom = options.get("cd-rom", "/root/ISO/CentOS-7-x86_64-Minimal-1511.iso")
#     vm_disk_size_gb = options.get("disk-size-gb", 10)
#     vm_net_bridge = options.get("net-bridge", "virbr0")
#     create_vm_command = "virt-install --name %s --virt-type kvm " \
#     "--vcpus %s --ram %s --cdrom=%s " \
#     "--disk size=%s,format=qcow2  --network bridge=%s,mac=%s " \
#     "--graphics vnc,listen=0.0.0.0 --noautoconsole" \
#     % (vm_name, str(vm_cpus), str(vm_mem_mb), vm_cdrom, str(vm_disk_size_gb), vm_net_bridge, vm_mac)
# #     print create_vm_command
#     p = subprocess.Popen(create_vm_command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
#     p.stdout.readlines()
#     p.stderr.readlines()
#     p.stdout.close()
#     p.stderr.close()

if __name__ == '__main__':
    print get_xml('Server')
    print vm_info('Server')
    jsondict = listVM('node22')
    print jsondict
    cmd = unpackCmdFromJson(jsondict)
#     runCmd(cmd)
#     createVM(options)

    
