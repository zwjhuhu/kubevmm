
# Yaml style

As described in [Kubernetes](https://kubernetes.io/), the input can only be yaml style.
so we plan to convert the Libvirt's xml style to Kubernetes's yaml style basd in the
following rules

- 'interface' to '_interface'
- '#text' to 'text'
- '@' to '_'


## domain.yaml

```
domain:
  '_type': string
  '_id': string
  name: string
  uuid: string
  genid: string
  title: string
  description: string
  metadata: null
  maxMemory:
    '_unit': string
    '_slots': string
    'text': string
  memory:
    '_unit': string
    '_dumpCore': string
    'text': string
  currentMemory:
    '_unit': string
    'text': string
  blkiotune:
    weight: string
    device:
    - path: string
      weight: string
      read_iops_sec: string
      write_iops_sec: string
      read_bytes_sec: string
      write_bytes_sec: string
    - path: string
      weight: string
      read_iops_sec: string
      write_iops_sec: string
      read_bytes_sec: string
      write_bytes_sec: string
  memtune:
    hard_limit:
      '_unit': string
      'text': string
    soft_limit:
      '_unit': string
      'text': string
    min_guarantee:
      '_unit': string
      'text': string
    swap_hard_limit:
      '_unit': string
      'text': string
  memoryBacking:
    hugepages:
      page:
      - '_size': string
        '_unit': string
        '_nodeset': string
      - '_size': string
        '_unit': string
        '_nodeset': string
    nosharepages: null
    locked: null
    source:
      '_type': string
    access:
      '_mode': string
    allocation:
      '_mode': string
    discard: null
  vcpu:
    '_placement': string
    '_cpuset': string
    '_current': string
    'text': string
  vcpus:
    vcpu:
    - '_id': string
      '_enabled': string
      '_hotpluggable': string
      '_order': string
    - '_id': string
      '_enabled': string
      '_hotpluggable': string
      '_order': string
  iothreads: string
  iothreadids:
    iothread:
    - '_id': string
    - '_id': string
  cputune:
    shares: string
    period: string
    quota: string
    global_period: string
    global_quota: string
    emulator_period: string
    emulator_quota: string
    iothread_period: string
    iothread_quota: string
    vcpupin:
    - '_vcpu': string
      '_cpuset': string
    - '_vcpu': string
      '_cpuset': string
    emulatorpin:
      '_cpuset': string
    iothreadpin:
    - '_iothread': string
      '_cpuset': string
    - '_iothread': string
      '_cpuset': string
    vcpusched:
    - '_vcpus': string
      '_scheduler': string
      '_priority': string
    - '_vcpus': string
      '_scheduler': string
      '_priority': string
    iothreadsched:
    - '_iothreads': string
      '_scheduler': string
      '_priority': string
    - '_iothreads': string
      '_scheduler': string
      '_priority': string
    cachetune:
    - '_vcpus': string
      cache:
      - '_id': string
        '_level': string
        '_type': string
        '_size': string
        '_unit': string
      - '_id': string
        '_level': string
        '_type': string
        '_size': string
        '_unit': string
      monitor:
      - '_level': string
        '_vcpus': string
      - '_level': string
        '_vcpus': string
    - '_vcpus': string
      cache:
      - '_id': string
        '_level': string
        '_type': string
        '_size': string
        '_unit': string
      - '_id': string
        '_level': string
        '_type': string
        '_size': string
        '_unit': string
      monitor:
      - '_level': string
        '_vcpus': string
      - '_level': string
        '_vcpus': string
    memorytune:
    - '_vcpus': string
      node:
      - '_id': string
        '_bandwidth': string
      - '_id': string
        '_bandwidth': string
    - '_vcpus': string
      node:
      - '_id': string
        '_bandwidth': string
      - '_id': string
        '_bandwidth': string
  numatune:
    memory:
      '_mode': string
      '_nodeset': string
      '_placement': string
    memnode:
    - '_cellid': string
      '_mode': string
      '_nodeset': string
    - '_cellid': string
      '_mode': string
      '_nodeset': string
  resource:
    partition: string
  sysinfo:
    '_type': string
    bios:
      entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    system:
      entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    baseBoard:
    - entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    - entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    chassis:
      entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    processor:
    - entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    - entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    memory:
    - entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    - entry:
      - '_name': string
        'text': string
      - '_name': string
        'text': string
    oemStrings:
      entry: string
  bootloader: string
  bootloader_args: string
  os:
    type:
      '_arch': string
      '_machine': string
      'text': string
    init: string
    initarg: string
    initenv:
    - '_name': string
      'text': string
    - '_name': string
      'text': string
    initdir: string
    inituser: string
    initgroup: string
    loader: strin readonly='string' secure='string' type='string'>
    nvram: strin template='string'>
    kernel: string
    initrd: string
    cmdline: string
    dtb: string
    acpi:
      table:
      - '_type': string
        'text': string
      - '_type': string
        'text': string
    boot:
    - '_dev': string
    - '_dev': string
    bootmenu:
      '_enable': string
      '_timeout': string
    bios:
      '_useserial': string
      '_rebootTimeout': string
    smbios:
      '_mode': string
  idmap:
    uid:
    - '_start': string
      '_target': string
      '_count': string
    - '_start': string
      '_target': string
      '_count': string
    gid:
    - '_start': string
      '_target': string
      '_count': string
    - '_start': string
      '_target': string
      '_count': string
  features:
    pae: null
    acpi: null
    apic:
      '_eoi': string
    hap:
      '_state': string
    viridian: null
    privnet: null
    hyperv:
      relaxed:
        '_state': string
      vapic:
        '_state': string
      spinlocks:
        '_retries': string
      vpindex:
        '_state': string
      runtime:
        '_state': string
      synic:
        '_state': string
      stimer:
        '_state': string
      reset:
        '_state': string
      vendor_id:
        '_value': string
      frequencies:
        '_state': string
      reenlightenment:
        '_state': string
      tlbflush:
        '_state': string
      ipi:
        '_state': string
      evmcs:
        '_state': string
    kvm:
      hidden:
        '_state': string
    pvspinlock:
      '_state': string
    pmu:
      '_state': string
    vmport:
      '_state': string
    gic:
      '_version': string
    smm:
      '_state': string
      tseg:
        '_unit': string
        'text': string
    ioapic:
      '_driver': string
    hpt:
      '_resizing': string
      maxpagesize:
        '_unit': string
        'text': string
    htm:
      '_state': string
    nested-hv:
      '_state': string
    capabilities:
      '_policy': string
      audit_control:
        '_state': string
      audit_write:
        '_state': string
      block_suspend:
        '_state': string
      chown:
        '_state': string
      dac_override:
        '_state': string
      dac_read_Search:
        '_state': string
      fowner:
        '_state': string
      fsetid:
        '_state': string
      ipc_lock:
        '_state': string
      ipc_owner:
        '_state': string
      kill:
        '_state': string
      lease:
        '_state': string
      linux_immutable:
        '_state': string
      mac_admin:
        '_state': string
      mac_override:
        '_state': string
      mknod:
        '_state': string
      net_admin:
        '_state': string
      net_bind_service:
        '_state': string
      net_broadcast:
        '_state': string
      net_raw:
        '_state': string
      setgid:
        '_state': string
      setfcap:
        '_state': string
      setpcap:
        '_state': string
      setuid:
        '_state': string
      sys_admin:
        '_state': string
      sys_boot:
        '_state': string
      sys_chroot:
        '_state': string
      sys_module:
        '_state': string
      sys_nice:
        '_state': string
      sys_pacct:
        '_state': string
      sys_ptrace:
        '_state': string
      sys_rawio:
        '_state': string
      sys_resource:
        '_state': string
      sys_time:
        '_state': string
      sys_tty_config:
        '_state': string
      syslog:
        '_state': string
      wake_alarm:
        '_state': string
    vmcoreinfo:
      '_state': string
    msrs:
      '_unknown': string
  cpu:
    '_match': string
    '_mode': string
    '_check': string
    model:
      '_fallback': string
      '_vendor_id': string
      'text': string
    vendor: string
    topology:
      '_sockets': string
      '_cores': string
      '_threads': string
    cache:
      '_level': string
      '_mode': string
    feature:
    - '_policy': string
      '_name': string
    - '_policy': string
      '_name': string
    numa:
      cell:
      - '_id': string
        '_cpus': string
        '_memory': string
        '_unit': string
        '_memAccess': string
        '_discard': string
        distances:
          sibling:
          - '_id': string
            '_value': string
          - '_id': string
            '_value': string
      - '_id': string
        '_cpus': string
        '_memory': string
        '_unit': string
        '_memAccess': string
        '_discard': string
        distances:
          sibling:
          - '_id': string
            '_value': string
          - '_id': string
            '_value': string
  clock:
    '_offset': string
    '_basis': string
    '_adjustment': string
    '_timezone': string
    timer:
    - '_name': string
      '_track': string
      '_tickpolicy': string
      '_frequency': string
      '_mode': string
      '_present': string
      catchup:
        '_threshold': string
        '_slew': string
        '_limit': string
    - '_name': string
      '_track': string
      '_tickpolicy': string
      '_frequency': string
      '_mode': string
      '_present': string
      catchup:
        '_threshold': string
        '_slew': string
        '_limit': string
  on_poweroff: string
  on_reboot: string
  on_crash: string
  pm:
    suspend-to-mem:
      '_enabled': string
    suspend-to-disk:
      '_enabled': string
  perf:
    event:
    - '_name': string
      '_enabled': string
    - '_name': string
      '_enabled': string
  devices:
    emulator: string
    disk:
    - '_device': string
      '_rawio': string
      '_sgio': string
      '_snapshot': string
      '_model': string
      driver:
        '_name': string
        '_type': string
        '_cache': string
        '_error_policy': string
        '_rerror_policy': string
        '_io': string
        '_ioeventfd': string
        '_event_idx': string
        '_copy_on_read': string
        '_discard': string
        '_iothread': string
        '_detect_zeroes': string
        '_queues': string
        '_iommu': string
        '_ats': string
      auth:
        '_username': string
        secret:
          '_type': string
          '_usage': string
          '_uuid': string
      source:
        '_startupPolicy': string
        '_index': string
        encryption:
          '_format': string
          secret:
            '_type': string
            '_usage': string
            '_uuid': string
        reservations:
          '_enabled': string
          '_managed': string
          source: null
      backingStore:
        '_index': string
        format:
          '_type': string
        source:
          '_startupPolicy': string
          '_index': string
          encryption:
            '_format': string
            secret:
              '_type': string
              '_usage': string
              '_uuid': string
          reservations:
            '_enabled': string
            '_managed': string
            source: null
      geometry:
        '_cyls': string
        '_heads': string
        '_secs': string
        '_trans': string
      blockio:
        '_logical_block_size': string
        '_physical_block_size': string
      mirror:
        '_job': string
        '_ready': string
        format:
          '_type': string
        source:
          '_startupPolicy': string
          '_index': string
          encryption:
            '_format': string
            secret:
              '_type': string
              '_usage': string
              '_uuid': string
          reservations:
            '_enabled': string
            '_managed': string
            source: null
      target:
        '_dev': string
        '_bus': string
        '_tray': string
        '_removable': string
      iotune:
        total_bytes_sec: string
        read_bytes_sec: string
        write_bytes_sec: string
        total_iops_sec: string
        read_iops_sec: string
        write_iops_sec: string
        total_bytes_sec_max: string
        read_bytes_sec_max: string
        write_bytes_sec_max: string
        total_iops_sec_max: string
        read_iops_sec_max: string
        write_iops_sec_max: string
        total_bytes_sec_max_length: string
        read_bytes_sec_max_length: string
        write_bytes_sec_max_length: string
        total_iops_sec_max_length: string
        read_iops_sec_max_length: string
        write_iops_sec_max_length: string
        size_iops_sec: string
        group_name: string
      readonly: null
      shareable: null
      transient: null
      serial: string
      wwn: string
      vendor: string
      product: string
      encryption:
        '_format': string
        secret:
          '_type': string
          '_usage': string
          '_uuid': string
      boot:
        '_order': string
        '_loadparm': string
      alias:
        '_name': string
      address: null
    - '_device': string
      '_rawio': string
      '_sgio': string
      '_snapshot': string
      '_model': string
      driver:
        '_name': string
        '_type': string
        '_cache': string
        '_error_policy': string
        '_rerror_policy': string
        '_io': string
        '_ioeventfd': string
        '_event_idx': string
        '_copy_on_read': string
        '_discard': string
        '_iothread': string
        '_detect_zeroes': string
        '_queues': string
        '_iommu': string
        '_ats': string
      auth:
        '_username': string
        secret:
          '_type': string
          '_usage': string
          '_uuid': string
      source:
        '_startupPolicy': string
        '_index': string
        encryption:
          '_format': string
          secret:
            '_type': string
            '_usage': string
            '_uuid': string
        reservations:
          '_enabled': string
          '_managed': string
          source: null
      backingStore:
        '_index': string
        format:
          '_type': string
        source:
          '_startupPolicy': string
          '_index': string
          encryption:
            '_format': string
            secret:
              '_type': string
              '_usage': string
              '_uuid': string
          reservations:
            '_enabled': string
            '_managed': string
            source: null
      geometry:
        '_cyls': string
        '_heads': string
        '_secs': string
        '_trans': string
      blockio:
        '_logical_block_size': string
        '_physical_block_size': string
      mirror:
        '_job': string
        '_ready': string
        format:
          '_type': string
        source:
          '_startupPolicy': string
          '_index': string
          encryption:
            '_format': string
            secret:
              '_type': string
              '_usage': string
              '_uuid': string
          reservations:
            '_enabled': string
            '_managed': string
            source: null
      target:
        '_dev': string
        '_bus': string
        '_tray': string
        '_removable': string
      iotune:
        total_bytes_sec: string
        read_bytes_sec: string
        write_bytes_sec: string
        total_iops_sec: string
        read_iops_sec: string
        write_iops_sec: string
        total_bytes_sec_max: string
        read_bytes_sec_max: string
        write_bytes_sec_max: string
        total_iops_sec_max: string
        read_iops_sec_max: string
        write_iops_sec_max: string
        total_bytes_sec_max_length: string
        read_bytes_sec_max_length: string
        write_bytes_sec_max_length: string
        total_iops_sec_max_length: string
        read_iops_sec_max_length: string
        write_iops_sec_max_length: string
        size_iops_sec: string
        group_name: string
      readonly: null
      shareable: null
      transient: null
      serial: string
      wwn: string
      vendor: string
      product: string
      encryption:
        '_format': string
        secret:
          '_type': string
          '_usage': string
          '_uuid': string
      boot:
        '_order': string
        '_loadparm': string
      alias:
        '_name': string
      address: null
    controller:
    - '_type': string
      '_index': string
      '_model': string
      driver:
        '_queues': string
        '_cmd_per_lun': string
        '_max_sectors': string
        '_ioeventfd': string
        '_iothread': string
        '_iommu': string
        '_ats': string
      alias:
        '_name': string
      address: null
    - '_type': string
      '_index': string
      '_model': string
      driver:
        '_queues': string
        '_cmd_per_lun': string
        '_max_sectors': string
        '_ioeventfd': string
        '_iothread': string
        '_iommu': string
        '_ats': string
      alias:
        '_name': string
      address: null
    lease:
    - lockspace: string
      key: string
      target:
        '_path': string
        '_offset': string
    - lockspace: string
      key: string
      target:
        '_path': string
        '_offset': string
    filesystem:
    - '_accessmode': string
      '_model': string
      driver:
        '_type': string
        '_format': string
        '_name': string
        '_wrpolicy': string
        '_iommu': string
        '_ats': string
      source: null
      target:
        '_dir': string
      readonly: null
      space_hard_limit:
        '_unit': string
        'text': string
      space_soft_limit:
        '_unit': string
        'text': string
      alias:
        '_name': string
      address: null
    - '_accessmode': string
      '_model': string
      driver:
        '_type': string
        '_format': string
        '_name': string
        '_wrpolicy': string
        '_iommu': string
        '_ats': string
      source: null
      target:
        '_dir': string
      readonly: null
      space_hard_limit:
        '_unit': string
        'text': string
      space_soft_limit:
        '_unit': string
        'text': string
      alias:
        '_name': string
      address: null
    _interface:
    - '_managed': string
      '_trustGuestRxFilters': string
      mac:
        '_address': string
      source: null
      boot:
        '_order': string
        '_loadparm': string
      vlan:
        '_trunk': string
        tag:
        - '_id': string
          '_nativeMode': string
        - '_id': string
          '_nativeMode': string
      virtualport:
        parameters: null
      ip:
      - '_address': string
        '_family': string
        '_prefix': string
        '_peer': string
      - '_address': string
        '_family': string
        '_prefix': string
        '_peer': string
      route:
      - '_family': string
        '_address': string
        '_netmask': string
        '_prefix': string
        '_gateway': string
        '_metric': string
      - '_family': string
        '_address': string
        '_netmask': string
        '_prefix': string
        '_gateway': string
        '_metric': string
      script:
        '_path': string
      target:
        '_dev': string
      guest:
        '_dev': string
        '_actual': string
      model:
        '_type': string
      driver:
        '_name': string
        '_txmode': string
        '_ioeventfd': string
        '_event_idx': string
        '_queues': string
        '_rx_queue_size': string
        '_tx_queue_size': string
        '_iommu': string
        '_ats': string
        host:
          '_csum': string
          '_gso': string
          '_tso4': string
          '_tso6': string
          '_ecn': string
          '_ufo': string
          '_mrg_rxbuf': string
        guest:
          '_csum': string
          '_tso4': string
          '_tso6': string
          '_ecn': string
          '_ufo': string
      backend:
        '_tap': string
        '_vhost': string
      filterref:
        '_filter': string
        parameter:
        - '_name': string
          '_value': string
        - '_name': string
          '_value': string
      tune:
        sndbuf: string
      link:
        '_state': string
      mtu:
        '_size': string
      bandwidth:
        inbound:
          '_average': string
          '_peak': string
          '_burst': string
          '_floor': string
        outbound:
          '_average': string
          '_peak': string
          '_burst': string
          '_floor': string
      coalesce:
        rx:
          frames:
            '_max': string
      rom:
        '_bar': string
        '_file': string
        '_enabled': string
      alias:
        '_name': string
      address: null
    - '_managed': string
      '_trustGuestRxFilters': string
      mac:
        '_address': string
      source: null
      boot:
        '_order': string
        '_loadparm': string
      vlan:
        '_trunk': string
        tag:
        - '_id': string
          '_nativeMode': string
        - '_id': string
          '_nativeMode': string
      virtualport:
        parameters: null
      ip:
      - '_address': string
        '_family': string
        '_prefix': string
        '_peer': string
      - '_address': string
        '_family': string
        '_prefix': string
        '_peer': string
      route:
      - '_family': string
        '_address': string
        '_netmask': string
        '_prefix': string
        '_gateway': string
        '_metric': string
      - '_family': string
        '_address': string
        '_netmask': string
        '_prefix': string
        '_gateway': string
        '_metric': string
      script:
        '_path': string
      target:
        '_dev': string
      guest:
        '_dev': string
        '_actual': string
      model:
        '_type': string
      driver:
        '_name': string
        '_txmode': string
        '_ioeventfd': string
        '_event_idx': string
        '_queues': string
        '_rx_queue_size': string
        '_tx_queue_size': string
        '_iommu': string
        '_ats': string
        host:
          '_csum': string
          '_gso': string
          '_tso4': string
          '_tso6': string
          '_ecn': string
          '_ufo': string
          '_mrg_rxbuf': string
        guest:
          '_csum': string
          '_tso4': string
          '_tso6': string
          '_ecn': string
          '_ufo': string
      backend:
        '_tap': string
        '_vhost': string
      filterref:
        '_filter': string
        parameter:
        - '_name': string
          '_value': string
        - '_name': string
          '_value': string
      tune:
        sndbuf: string
      link:
        '_state': string
      mtu:
        '_size': string
      bandwidth:
        inbound:
          '_average': string
          '_peak': string
          '_burst': string
          '_floor': string
        outbound:
          '_average': string
          '_peak': string
          '_burst': string
          '_floor': string
      coalesce:
        rx:
          frames:
            '_max': string
      rom:
        '_bar': string
        '_file': string
        '_enabled': string
      alias:
        '_name': string
      address: null
    smartcard:
    - source: null
      protocol:
        '_type': string
      certificate:
      - string
      - string
      database: string
      alias:
        '_name': string
      address: null
    - source: null
      protocol:
        '_type': string
      certificate:
      - string
      - string
      database: string
      alias:
        '_name': string
      address: null
    serial:
    - source: null
      protocol:
        '_type': string
      target:
        '_type': string
        '_port': string
        model:
          '_name': string
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    - source: null
      protocol:
        '_type': string
      target:
        '_type': string
        '_port': string
        model:
          '_name': string
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    parallel:
    - source: null
      protocol:
        '_type': string
      target:
        '_type': string
        '_port': string
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    - source: null
      protocol:
        '_type': string
      target:
        '_type': string
        '_port': string
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    console:
    - '_tty': string
      source: null
      protocol:
        '_type': string
      target:
        '_type': string
        '_port': string
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    - '_tty': string
      source: null
      protocol:
        '_type': string
      target:
        '_type': string
        '_port': string
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    channel:
    - source: null
      protocol:
        '_type': string
      target: null
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    - source: null
      protocol:
        '_type': string
      target: null
      log:
        '_file': string
        '_append': string
      alias:
        '_name': string
      address: null
    input:
    - '_type': string
      '_bus': string
      '_model': string
      driver:
        '_iommu': string
        '_ats': string
      source:
        '_evdev': string
      alias:
        '_name': string
      address: null
    - '_type': string
      '_bus': string
      '_model': string
      driver:
        '_iommu': string
        '_ats': string
      source:
        '_evdev': string
      alias:
        '_name': string
      address: null
    tpm:
    - '_model': string
      backend: null
      alias:
        '_name': string
      address: null
    - '_model': string
      backend: null
      alias:
        '_name': string
      address: null
    graphics:
    - null
    - null
    sound:
    - '_model': string
      codec:
      - '_type': string
      - '_type': string
      alias:
        '_name': string
      address: null
    - '_model': string
      codec:
      - '_type': string
      - '_type': string
      alias:
        '_name': string
      address: null
    video:
    - model:
        '_type': string
        '_heads': string
        '_ram': string
        '_vram': string
        '_vram64': string
        '_vgamem': string
        '_primary': string
        acceleration:
          '_accel3d': string
          '_accel2d': string
      driver:
        '_vgaconf': string
        '_iommu': string
        '_ats': string
      alias:
        '_name': string
      address: null
    - model:
        '_type': string
        '_heads': string
        '_ram': string
        '_vram': string
        '_vram64': string
        '_vgamem': string
        '_primary': string
        acceleration:
          '_accel3d': string
          '_accel2d': string
      driver:
        '_vgaconf': string
        '_iommu': string
        '_ats': string
      alias:
        '_name': string
      address: null
    hostdev:
    - '_managed': string
      boot:
        '_order': string
        '_loadparm': string
      rom:
        '_bar': string
        '_file': string
        '_enabled': string
      alias:
        '_name': string
      address: null
    - '_managed': string
      boot:
        '_order': string
        '_loadparm': string
      rom:
        '_bar': string
        '_file': string
        '_enabled': string
      alias:
        '_name': string
      address: null
    redirdev:
    - '_bus': string
      source: null
      protocol:
        '_type': string
      boot:
        '_order': string
        '_loadparm': string
      alias:
        '_name': string
      address: null
    - '_bus': string
      source: null
      protocol:
        '_type': string
      boot:
        '_order': string
        '_loadparm': string
      alias:
        '_name': string
      address: null
    redirfilter:
    - usbdev:
      - '_class': string
        '_vendor': string
        '_product': string
        '_version': string
        '_allow': string
      - '_class': string
        '_vendor': string
        '_product': string
        '_version': string
        '_allow': string
    - usbdev:
      - '_class': string
        '_vendor': string
        '_product': string
        '_version': string
        '_allow': string
      - '_class': string
        '_vendor': string
        '_product': string
        '_version': string
        '_allow': string
    hub:
    - '_type': string
      alias:
        '_name': string
      address: null
    - '_type': string
      alias:
        '_name': string
      address: null
    watchdog:
      '_model': string
      '_action': string
      alias:
        '_name': string
      address: null
    memballoon:
      '_model': string
      '_autodeflate': string
      driver:
        '_iommu': string
        '_ats': string
      stats:
        '_period': string
      alias:
        '_name': string
      address: null
    rng:
    - '_model': string
      driver:
        '_iommu': string
        '_ats': string
      rate:
        '_bytes': string
        '_period': string
      backend: null
      alias:
        '_name': string
      address: null
    - '_model': string
      driver:
        '_iommu': string
        '_ats': string
      rate:
        '_bytes': string
        '_period': string
      backend: null
      alias:
        '_name': string
      address: null
    nvram:
      alias:
        '_name': string
      address: null
    panic:
    - '_model': string
      alias:
        '_name': string
      address: null
    - '_model': string
      alias:
        '_name': string
      address: null
    shmem:
    - '_name': string
      size:
        '_unit': string
        'text': string
      model:
        '_type': string
      server:
        '_path': string
      msi:
        '_enabled': string
        '_vectors': string
        '_ioeventfd': string
      alias:
        '_name': string
      address: null
    - '_name': string
      size:
        '_unit': string
        'text': string
      model:
        '_type': string
      server:
        '_path': string
      msi:
        '_enabled': string
        '_vectors': string
        '_ioeventfd': string
      alias:
        '_name': string
      address: null
    memory:
    - '_model': string
      '_access': string
      '_discard': string
      source:
        nodemask: string
        pagesize:
          '_unit': string
          'text': string
        path: string
        alignsize:
          '_unit': string
          'text': string
        pmem: null
      target:
        size:
          '_unit': string
          'text': string
        node: string
        label:
          size:
            '_unit': string
            'text': string
        readonly: null
      alias:
        '_name': string
      address: null
    - '_model': string
      '_access': string
      '_discard': string
      source:
        nodemask: string
        pagesize:
          '_unit': string
          'text': string
        path: string
        alignsize:
          '_unit': string
          'text': string
        pmem: null
      target:
        size:
          '_unit': string
          'text': string
        node: string
        label:
          size:
            '_unit': string
            'text': string
        readonly: null
      alias:
        '_name': string
      address: null
    iommu:
      '_model': string
      driver:
        '_intremap': string
        '_caching_mode': string
        '_eim': string
        '_iotlb': string
    vsock:
      '_model': string
      cid:
        '_auto': string
        '_address': string
      alias:
        '_name': string
      address: null
  seclabel:
  - '_type': string
    '_model': string
    '_relabel': string
    label: string
    imagelabel: string
    baselabel: string
  - '_type': string
    '_model': string
    '_relabel': string
    label: string
    imagelabel: string
    baselabel: string
  keywrap:
    cipher:
    - '_name': string
      '_state': string
    - '_name': string
      '_state': string
  launchSecurity: null

```

## network.yaml

```
network:
  '_ipv6': string
  '_trustGuestRxFilters': string
  name: string
  uuid: string
  metadata: null
  forward:
    '_mode': string
    '_dev': string
    '_managed': string
    driver:
      '_name': string
    pf:
    - '_dev': string
    - '_dev': string
    nat:
      address:
      - '_start': string
        '_end': string
      - '_start': string
        '_end': string
      port:
      - '_start': string
        '_end': string
      - '_start': string
        '_end': string
    _interface:
    - '_dev': string
    - '_dev': string
    address:
    - null
    - null
  bridge:
    '_name': string
    '_stp': string
    '_delay': string
    '_macTableManager': string
    '_zone': string
  mtu:
    '_size': string
  mac:
    '_address': string
  domain:
    '_name': string
    '_localOnly': string
  dns:
    '_enable': string
    '_forwardPlainNames': string
    forwarder:
    - '_domain': string
      '_addr': string
    - '_domain': string
      '_addr': string
    txt:
    - '_name': string
      '_value': string
    - '_name': string
      '_value': string
    host:
    - '_ip': string
      hostname:
      - string
      - string
    - '_ip': string
      hostname:
      - string
      - string
    srv:
    - '_service': string
      '_protocol': string
      '_target': string
      '_port': string
      '_priority': string
      '_weight': string
      '_domain': string
    - '_service': string
      '_protocol': string
      '_target': string
      '_port': string
      '_priority': string
      '_weight': string
      '_domain': string
  vlan:
    '_trunk': string
    tag:
    - '_id': string
      '_nativeMode': string
    - '_id': string
      '_nativeMode': string
  bandwidth:
    inbound:
      '_average': string
      '_peak': string
      '_burst': string
      '_floor': string
    outbound:
      '_average': string
      '_peak': string
      '_burst': string
      '_floor': string
  ip:
  - '_address': string
    '_family': string
    '_netmask': string
    '_prefix': string
    '_localPtr': string
    dhcp:
      range:
      - '_start': string
        '_end': string
      - '_start': string
        '_end': string
      host:
      - '_id': string
        '_mac': string
        '_name': string
        '_ip': string
      - '_id': string
        '_mac': string
        '_name': string
        '_ip': string
      bootp:
      - '_file': string
        '_server': string
      - '_file': string
        '_server': string
    tftp:
      '_root': string
  - '_address': string
    '_family': string
    '_netmask': string
    '_prefix': string
    '_localPtr': string
    dhcp:
      range:
      - '_start': string
        '_end': string
      - '_start': string
        '_end': string
      host:
      - '_id': string
        '_mac': string
        '_name': string
        '_ip': string
      - '_id': string
        '_mac': string
        '_name': string
        '_ip': string
      bootp:
      - '_file': string
        '_server': string
      - '_file': string
        '_server': string
    tftp:
      '_root': string
  route:
  - '_family': string
    '_address': string
    '_netmask': string
    '_prefix': string
    '_gateway': string
    '_metric': string
  - '_family': string
    '_address': string
    '_netmask': string
    '_prefix': string
    '_gateway': string
    '_metric': string
  virtualport:
    parameters: null
  portgroup:
  - '_name': string
    '_default': string
    '_trustGuestRxFilters': string
    vlan:
      '_trunk': string
      tag:
      - '_id': string
        '_nativeMode': string
      - '_id': string
        '_nativeMode': string
    virtualport:
      parameters: null
  - '_name': string
    '_default': string
    '_trustGuestRxFilters': string
    vlan:
      '_trunk': string
      tag:
      - '_id': string
        '_nativeMode': string
      - '_id': string
        '_nativeMode': string
    virtualport:
      parameters: null

```

## snapshot.yaml

```
domainsnapshot:
  name: string
  description: string
  state: string
  creationTime: string
  parent:
    name: string
  memory:
    '_snapshot': string
    '_file': string
  disks:
    disk:
    - '_name': string
      '_snapshot': string
      driver:
        '_type': string
      source:
        '_startupPolicy': string
        '_index': string
        encryption:
          '_format': string
          secret:
            '_type': string
            '_usage': string
            '_uuid': string
        reservations:
          '_enabled': string
          '_managed': string
          source: null
    - '_name': string
      '_snapshot': string
      driver:
        '_type': string
      source:
        '_startupPolicy': string
        '_index': string
        encryption:
          '_format': string
          secret:
            '_type': string
            '_usage': string
            '_uuid': string
        reservations:
          '_enabled': string
          '_managed': string
          source: null
  domain:
    '_type': string
    '_id': string
  active: string

```

## storage.yaml

```
pool:
  '_type': string
  name: string
  uuid: string
  allocation:
    '_unit': string
    'text': string
  capacity:
    '_unit': string
    'text': string
  available:
    '_unit': string
    'text': string
  target:
    path: string
    permissions:
      owner: string
      group: string
      mode: string
      label: string
    timestamps:
      atime: string
      mtime: string
      ctime: string
    encryption:
      '_format': string
      secret:
        '_type': string
        '_uuid': string
      cipher:
        '_name': string
        '_size': string
        '_mode': string
        '_hash': string
      ivgen:
        '_name': string
        '_hash': string
  source:
    name: string
    dir:
      '_path': string
    host:
    - '_name': string
      '_port': string
    - '_name': string
      '_port': string
    device:
    - '_path': string
      '_part_separator': string
      freeExtent:
      - '_start': string
        '_end': string
      - '_start': string
        '_end': string
    - '_path': string
      '_part_separator': string
      freeExtent:
      - '_start': string
        '_end': string
      - '_start': string
        '_end': string
    auth:
      '_type': string
      '_username': string
      secret:
        '_usage': string
        '_uuid': string
    vendor:
      '_name': string
    product:
      '_name': string
    format:
      '_type': string
    protocol:
      '_ver': string
    adapter:
      '_type': string
      '_name': string
      '_parent': string
      '_managed': string
      '_wwnn': string
      '_wwpn': string
      parentaddr:
        '_unique_id': string
        address:
          '_domain': string
          '_bus': string
          '_slot': string
          '_function': string
    initiator:
      iqn:
        '_name': string
  refresh:
    volume:
      '_allocation': string

```
