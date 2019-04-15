
## XML 样式

以下libvirt支持的xml形式是由[代码](../analyser)自动生成，可对照[官方文档](https://libvirt.org/docs.html)进行查询,
我们发现libvirt-go-xml官方项目仍有很大改进空间，与官方文档可能有出入


### [Domain.xml](https://libvirt.org/formatdomain.html)

```
<?xml version="1.0" encoding="utf-8"?>

<domain type="string" id="*int">
  <name>string</name>
  <uuid>string</uuid>
  <genid/>
  <title>string</title>
  <description>string</description>
  <metadata/>
  <maxMemory unit="string" slots="uint"/>
  <memory unit="string" dumpCore="string"/>
  <currentMemory unit="string"/>
  <blkiotune>
    <weight>uint</weight>
    <device>
      <path>string</path>
      <weight>uint</weight>
      <read_iops_sec>uint</read_iops_sec>
      <write_iops_sec>uint</write_iops_sec>
      <read_bytes_sec>uint</read_bytes_sec>
      <write_bytes_sec>uint</write_bytes_sec>
    </device>
  </blkiotune>
  <memtune>
    <hard_limit unit="string"/>
    <soft_limit unit="string"/>
    <min_guarantee unit="string"/>
    <swap_hard_limit unit="string"/>
  </memtune>
  <memoryBacking>
    <hugepages>
      <page size="uint" unit="string" nodeset="string"/>
    </hugepages>
    <nosharepages/>
    <locked/>
    <source type="string"/>
    <access mode="string"/>
    <allocation mode="string"/>
    <discard/>
  </memoryBacking>
  <vcpu placement="string" cpuset="string" current="string"/>
  <vcpus>
    <vcpu id="*uint" enabled="string" hotpluggable="string" order="*uint"/>
  </vcpus>
  <iothreads>uint</iothreads>
  <iothreadids>
    <iothread id="uint"/>
  </iothreadids>
  <cputune>
    <shares/>
    <period/>
    <quota/>
    <global_period/>
    <global_quota/>
    <emulator_period/>
    <emulator_quota/>
    <iothread_period/>
    <iothread_quota/>
    <vcpupin vcpu="uint" cpuset="string"/>
    <emulatorpin cpuset="string"/>
    <iothreadpin iothread="uint" cpuset="string"/>
    <vcpusched vcpus="string" scheduler="string" priority="*int"/>
    <iothreadsched iothreads="string" scheduler="string" priority="*int"/>
    <cachetune vcpus="string">
      <cache id="uint" level="uint" type="string" size="uint" unit="string"/>
      <monitor level="uint" vcpus="string"/>
    </cachetune>
    <memorytune vcpus="string">
      <node id="uint" bandwidth="uint"/>
    </memorytune>
  </cputune>
  <numatune>
    <memory mode="string" nodeset="string" placement="string"/>
    <memnode cellid="uint" mode="string" nodeset="string"/>
  </numatune>
  <resource>
    <partition>string</partition>
  </resource>
  <sysinfo type="string">
    <bios>
      <entry name="string"/>
    </bios>
    <system>
      <entry name="string"/>
    </system>
    <baseBoard>
      <entry name="string"/>
    </baseBoard>
    <chassis>
      <entry name="string"/>
    </chassis>
    <processor>
      <entry name="string"/>
    </processor>
    <memory>
      <entry name="string"/>
    </memory>
    <oemStrings>
      <entry>[]string</entry>
    </oemStrings>
  </sysinfo>
  <bootloader>string</bootloader>
  <bootloader_args>string</bootloader_args>
  <os firmware="string">
    <type arch="string" machine="string"/>
    <init>string</init>
    <initarg>[]string</initarg>
    <initenv name="string"/>
    <initdir>string</initdir>
    <inituser>string</inituser>
    <initgroup>string</initgroup>
    <loader readonly="string" secure="string" type="string"/>
    <nvram template="string"/>
    <kernel>string</kernel>
    <initrd>string</initrd>
    <cmdline>string</cmdline>
    <dtb>string</dtb>
    <acpi>
      <table type="string"/>
    </acpi>
    <boot dev="string"/>
    <bootmenu enable="string" timeout="string"/>
    <bios useserial="string" rebootTimeout="*int"/>
    <smbios mode="string"/>
  </os>
  <idmap>
    <uid start="uint" target="uint" count="uint"/>
    <gid start="uint" target="uint" count="uint"/>
  </idmap>
  <features>
    <pae/>
    <acpi/>
    <apic eoi="string"/>
    <hap state="string"/>
    <viridian/>
    <privnet/>
    <hyperv>
      <relaxed state="string"/>
      <vapic state="string"/>
      <spinlocks retries="uint"/>
      <vpindex state="string"/>
      <runtime state="string"/>
      <synic state="string"/>
      <stimer state="string"/>
      <reset state="string"/>
      <vendor_id value="string"/>
      <frequencies state="string"/>
      <reenlightenment state="string"/>
      <tlbflush state="string"/>
      <ipi state="string"/>
      <evmcs state="string"/>
    </hyperv>
    <kvm>
      <hidden state="string"/>
    </kvm>
    <pvspinlock state="string"/>
    <pmu state="string"/>
    <vmport state="string"/>
    <gic version="string"/>
    <smm state="string">
      <tseg unit="string"/>
    </smm>
    <ioapic driver="string"/>
    <hpt resizing="string">
      <maxpagesize unit="string"/>
    </hpt>
    <htm state="string"/>
    <nested-hv state="string"/>
    <capabilities policy="string">
      <audit_control state="string"/>
      <audit_write state="string"/>
      <block_suspend state="string"/>
      <chown state="string"/>
      <dac_override state="string"/>
      <dac_read_Search state="string"/>
      <fowner state="string"/>
      <fsetid state="string"/>
      <ipc_lock state="string"/>
      <ipc_owner state="string"/>
      <kill state="string"/>
      <lease state="string"/>
      <linux_immutable state="string"/>
      <mac_admin state="string"/>
      <mac_override state="string"/>
      <mknod state="string"/>
      <net_admin state="string"/>
      <net_bind_service state="string"/>
      <net_broadcast state="string"/>
      <net_raw state="string"/>
      <setgid state="string"/>
      <setfcap state="string"/>
      <setpcap state="string"/>
      <setuid state="string"/>
      <sys_admin state="string"/>
      <sys_boot state="string"/>
      <sys_chroot state="string"/>
      <sys_module state="string"/>
      <sys_nice state="string"/>
      <sys_pacct state="string"/>
      <sys_ptrace state="string"/>
      <sys_rawio state="string"/>
      <sys_resource state="string"/>
      <sys_time state="string"/>
      <sys_tty_config state="string"/>
      <syslog state="string"/>
      <wake_alarm state="string"/>
    </capabilities>
    <vmcoreinfo state="string"/>
    <msrs unknown="string"/>
  </features>
  <cpu match="string" mode="string" check="string">
    <model fallback="string" vendor_id="string"/>
    <vendor>string</vendor>
    <topology sockets="int" cores="int" threads="int"/>
    <cache level="uint" mode="string"/>
    <feature policy="string" name="string"/>
    <numa>
      <cell id="*uint" cpus="string" memory="string" unit="string" memAccess="string" discard="string">
        <distances>
          <sibling id="uint" value="uint"/>
        </distances>
      </cell>
    </numa>
  </cpu>
  <clock offset="string" basis="string" adjustment="string" timezone="string">
    <timer name="string" track="string" tickpolicy="string" frequency="uint32" mode="string" present="string">
      <catchup threshold="uint" slew="uint" limit="uint"/>
    </timer>
  </clock>
  <on_poweroff>string</on_poweroff>
  <on_reboot>string</on_reboot>
  <on_crash>string</on_crash>
  <pm>
    <suspend-to-mem enabled="string"/>
    <suspend-to-disk enabled="string"/>
  </pm>
  <perf>
    <event name="string" enabled="string"/>
  </perf>
  <devices>
    <emulator>string</emulator>
    <disk device="string" rawio="string" sgio="string" snapshot="string" model="string">
      <driver name="string" type="string" cache="string" error_policy="string" rerror_policy="string" io="string" ioeventfd="string" event_idx="string" copy_on_read="string" discard="string" iothread="*uint" detect_zeroes="string" queues="*uint" iommu="string" ats="string"/>
      <auth username="string">
        <secret type="string" usage="string" uuid="string"/>
      </auth>
      <source startupPolicy="string" index="uint">
        <encryption format="string">
          <secret type="string" usage="string" uuid="string"/>
        </encryption>
        <reservations enabled="string" managed="string">
          <source/>
        </reservations>
      </source>
      <backingStore index="uint">
        <format type="string"/>
        <source startupPolicy="string" index="uint">
          <encryption format="string">
            <secret type="string" usage="string" uuid="string"/>
          </encryption>
          <reservations enabled="string" managed="string">
            <source/>
          </reservations>
        </source>
      </backingStore>
      <geometry cyls="uint" heads="uint" secs="uint" trans="string"/>
      <blockio logical_block_size="uint" physical_block_size="uint"/>
      <mirror job="string" ready="string">
        <format type="string"/>
        <source startupPolicy="string" index="uint">
          <encryption format="string">
            <secret type="string" usage="string" uuid="string"/>
          </encryption>
          <reservations enabled="string" managed="string">
            <source/>
          </reservations>
        </source>
        <backingStore index="uint">
          <format type="string"/>
          <source startupPolicy="string" index="uint">
            <encryption format="string">
              <secret type="string" usage="string" uuid="string"/>
            </encryption>
            <reservations enabled="string" managed="string">
              <source/>
            </reservations>
          </source>
        </backingStore>
      </mirror>
      <target dev="string" bus="string" tray="string" removable="string"/>
      <iotune>
        <total_bytes_sec>uint64</total_bytes_sec>
        <read_bytes_sec>uint64</read_bytes_sec>
        <write_bytes_sec>uint64</write_bytes_sec>
        <total_iops_sec>uint64</total_iops_sec>
        <read_iops_sec>uint64</read_iops_sec>
        <write_iops_sec>uint64</write_iops_sec>
        <total_bytes_sec_max>uint64</total_bytes_sec_max>
        <read_bytes_sec_max>uint64</read_bytes_sec_max>
        <write_bytes_sec_max>uint64</write_bytes_sec_max>
        <total_iops_sec_max>uint64</total_iops_sec_max>
        <read_iops_sec_max>uint64</read_iops_sec_max>
        <write_iops_sec_max>uint64</write_iops_sec_max>
        <total_bytes_sec_max_length>uint64</total_bytes_sec_max_length>
        <read_bytes_sec_max_length>uint64</read_bytes_sec_max_length>
        <write_bytes_sec_max_length>uint64</write_bytes_sec_max_length>
        <total_iops_sec_max_length>uint64</total_iops_sec_max_length>
        <read_iops_sec_max_length>uint64</read_iops_sec_max_length>
        <write_iops_sec_max_length>uint64</write_iops_sec_max_length>
        <size_iops_sec>uint64</size_iops_sec>
        <group_name>string</group_name>
      </iotune>
      <readonly/>
      <shareable/>
      <transient/>
      <serial>string</serial>
      <wwn>string</wwn>
      <vendor>string</vendor>
      <product>string</product>
      <boot order="uint" loadparm="string"/>
      <alias name="string"/>
      <address/>
    </disk>
    <controller type="string" index="*uint" model="string">
      <driver queues="*uint" cmd_per_lun="*uint" max_sectors="*uint" ioeventfd="string" iothread="uint" iommu="string" ats="string"/>
      <alias name="string"/>
      <address/>
    </controller>
    <lease>
      <lockspace>string</lockspace>
      <key>string</key>
      <target path="string" offset="uint64"/>
    </lease>
    <filesystem accessmode="string" model="string">
      <driver type="string" format="string" name="string" wrpolicy="string" iommu="string" ats="string"/>
      <source/>
      <target dir="string"/>
      <readonly/>
      <space_hard_limit unit="string"/>
      <space_soft_limit unit="string"/>
      <alias name="string"/>
      <address/>
    </filesystem>
    <interface managed="string" trustGuestRxFilters="string">
      <mac address="string"/>
      <source/>
      <boot order="uint" loadparm="string"/>
      <vlan trunk="string">
        <tag id="uint" nativeMode="string"/>
      </vlan>
      <virtualport>
        <parameters/>
      </virtualport>
      <ip address="string" family="string" prefix="uint" peer="string"/>
      <route family="string" address="string" netmask="string" prefix="uint" gateway="string" metric="uint"/>
      <script path="string"/>
      <target dev="string"/>
      <guest dev="string" actual="string"/>
      <model type="string"/>
      <driver name="string" txmode="string" ioeventfd="string" event_idx="string" queues="uint" rx_queue_size="uint" tx_queue_size="uint" iommu="string" ats="string">
        <host csum="string" gso="string" tso4="string" tso6="string" ecn="string" ufo="string" mrg_rxbuf="string"/>
        <guest csum="string" tso4="string" tso6="string" ecn="string" ufo="string"/>
      </driver>
      <backend tap="string" vhost="string"/>
      <filterref filter="string">
        <parameter name="string" value="string"/>
      </filterref>
      <tune>
        <sndbuf>uint</sndbuf>
      </tune>
      <link state="string"/>
      <mtu size="uint"/>
      <bandwidth>
        <inbound average="*int" peak="*int" burst="*int" floor="*int"/>
        <outbound average="*int" peak="*int" burst="*int" floor="*int"/>
      </bandwidth>
      <coalesce>
        <rx>
          <frames max="*uint"/>
        </rx>
      </coalesce>
      <rom bar="string" file="string" enabled="string"/>
      <alias name="string"/>
      <address/>
    </interface>
    <smartcard>
      <source/>
      <protocol type="string"/>
      <certificate/>
      <database>string</database>
      <alias name="string"/>
      <address/>
    </smartcard>
    <serial>
      <serial>xml.Name</serial>
      <source/>
      <protocol type="string"/>
      <target type="string" port="*uint">
        <model name="string"/>
      </target>
      <log file="string" append="string"/>
      <alias name="string"/>
      <address/>
    </serial>
    <parallel>
      <parallel>xml.Name</parallel>
      <source/>
      <protocol type="string"/>
      <target type="string" port="*uint"/>
      <log file="string" append="string"/>
      <alias name="string"/>
      <address/>
    </parallel>
    <console tty="string">
      <source/>
      <protocol type="string"/>
      <target type="string" port="*uint"/>
      <log file="string" append="string"/>
      <alias name="string"/>
      <address/>
    </console>
    <channel>
      <source/>
      <protocol type="string"/>
      <target/>
      <log file="string" append="string"/>
      <alias name="string"/>
      <address/>
    </channel>
    <input type="string" bus="string" model="string">
      <driver iommu="string" ats="string"/>
      <source evdev="string"/>
      <alias name="string"/>
      <address/>
    </input>
    <tpm model="string">
      <backend/>
      <alias name="string"/>
      <address/>
    </tpm>
    <graphics/>
    <sound model="string">
      <codec type="string"/>
      <alias name="string"/>
      <address/>
    </sound>
    <video>
      <model type="string" heads="uint" ram="uint" vram="uint" vram64="uint" vgamem="uint" primary="string">
        <acceleration accel3d="string" accel2d="string"/>
      </model>
      <driver vgaconf="string" iommu="string" ats="string"/>
      <alias name="string"/>
      <address/>
    </video>
    <hostdev managed="string">
      <boot order="uint" loadparm="string"/>
      <rom bar="string" file="string" enabled="string"/>
      <alias name="string"/>
      <address/>
    </hostdev>
    <redirdev bus="string">
      <source/>
      <protocol type="string"/>
      <boot order="uint" loadparm="string"/>
      <alias name="string"/>
      <address/>
    </redirdev>
    <redirfilter>
      <usbdev class="*uint" vendor="*uint" product="*uint" version="string" allow="string"/>
    </redirfilter>
    <hub type="string">
      <alias name="string"/>
      <address/>
    </hub>
    <watchdog model="string" action="string">
      <alias name="string"/>
      <address/>
    </watchdog>
    <memballoon model="string" autodeflate="string">
      <driver iommu="string" ats="string"/>
      <stats period="uint"/>
      <alias name="string"/>
      <address/>
    </memballoon>
    <rng model="string">
      <driver iommu="string" ats="string"/>
      <rate bytes="uint" period="uint"/>
      <backend/>
      <alias name="string"/>
      <address/>
    </rng>
    <nvram>
      <alias name="string"/>
      <address/>
    </nvram>
    <panic model="string">
      <alias name="string"/>
      <address/>
    </panic>
    <shmem name="string">
      <size unit="string"/>
      <model type="string"/>
      <server path="string"/>
      <msi enabled="string" vectors="uint" ioeventfd="string"/>
      <alias name="string"/>
      <address/>
    </shmem>
    <memory model="string" access="string" discard="string">
      <source>
        <nodemask>string</nodemask>
        <pagesize unit="string"/>
        <path>string</path>
        <alignsize unit="string"/>
        <pmem/>
      </source>
      <target>
        <size unit="string"/>
        <node/>
        <label>
          <size unit="string"/>
        </label>
        <readonly/>
      </target>
      <alias name="string"/>
      <address/>
    </memory>
    <iommu model="string">
      <driver intremap="string" caching_mode="string" eim="string" iotlb="string"/>
    </iommu>
    <vsock model="string">
      <cid auto="string" address="string"/>
      <alias name="string"/>
      <address/>
    </vsock>
  </devices>
  <seclabel type="string" model="string" relabel="string">
    <label>string</label>
    <imagelabel>string</imagelabel>
    <baselabel>string</baselabel>
  </seclabel>
  <keywrap>
    <cipher name="string" state="string"/>
  </keywrap>
  <launchSecurity/>
</domain>
```


### [Network xml](https://libvirt.org/formatnetwork.html)

```
<?xml version="1.0" encoding="utf-8"?>

<network ipv6="string" trustGuestRxFilters="string">
  <name>string</name>
  <uuid>string</uuid>
  <metadata/>
  <forward mode="string" dev="string" managed="string">
    <driver name="string"/>
    <pf dev="string"/>
    <nat>
      <address start="string" end="string"/>
      <port start="uint" end="uint"/>
    </nat>
    <interface dev="string"/>
    <address/>
  </forward>
  <bridge name="string" stp="string" delay="string" macTableManager="string" zone="string"/>
  <mtu size="uint"/>
  <mac address="string"/>
  <domain name="string" localOnly="string"/>
  <dns enable="string" forwardPlainNames="string">
    <forwarder domain="string" addr="string"/>
    <txt name="string" value="string"/>
    <host ip="string">
      <hostname/>
    </host>
    <srv service="string" protocol="string" target="string" port="uint" priority="uint" weight="uint" domain="string"/>
  </dns>
  <vlan trunk="string">
    <tag id="uint" nativeMode="string"/>
  </vlan>
  <bandwidth>
    <inbound average="*uint" peak="*uint" burst="*uint" floor="*uint"/>
    <outbound average="*uint" peak="*uint" burst="*uint" floor="*uint"/>
  </bandwidth>
  <ip address="string" family="string" netmask="string" prefix="uint" localPtr="string">
    <dhcp>
      <range start="string" end="string"/>
      <host id="string" mac="string" name="string" ip="string"/>
      <bootp file="string" server="string"/>
    </dhcp>
    <tftp root="string"/>
  </ip>
  <route family="string" address="string" netmask="string" prefix="uint" gateway="string" metric="string"/>
  <virtualport>
    <parameters/>
  </virtualport>
  <portgroup name="string" default="string" trustGuestRxFilters="string">
    <vlan trunk="string">
      <tag id="uint" nativeMode="string"/>
    </vlan>
    <virtualport>
      <parameters/>
    </virtualport>
  </portgroup>
</network>
```

### [storage](https://libvirt.org/formatstorage.html)

```
<?xml version="1.0" encoding="utf-8"?>

<pool type="string">
  <name>string</name>
  <uuid>string</uuid>
  <allocation unit="string"/>
  <capacity unit="string"/>
  <available unit="string"/>
  <target>
    <path>string</path>
    <permissions>
      <owner>string</owner>
      <group>string</group>
      <mode>string</mode>
      <label>string</label>
    </permissions>
    <timestamps>
      <atime>string</atime>
      <mtime>string</mtime>
      <ctime>string</ctime>
    </timestamps>
    <encryption format="string">
      <secret type="string" uuid="string"/>
      <cipher name="string" size="uint64" mode="string" hash="string"/>
      <ivgen name="string" hash="string"/>
    </encryption>
  </target>
  <source>
    <name>string</name>
    <dir path="string"/>
    <host name="string" port="string"/>
    <device path="string" part_separator="string">
      <freeExtent start="uint64" end="uint64"/>
    </device>
    <auth type="string" username="string">
      <secret usage="string" uuid="string"/>
    </auth>
    <vendor name="string"/>
    <product name="string"/>
    <format type="string"/>
    <protocol ver="string"/>
    <adapter type="string" name="string" parent="string" managed="string" wwnn="string" wwpn="string">
      <parentaddr unique_id="uint64">
        <address domain="*uint" bus="*uint" slot="*uint" function="*uint"/>
      </parentaddr>
    </adapter>
    <initiator>
      <iqn name="string"/>
    </initiator>
  </source>
  <refresh>
    <volume allocation="string"/>
  </refresh>
</pool>

```

### [Node device](https://libvirt.org/formatsecret.html)

```
<?xml version="1.0" encoding="utf-8"?>

<device>
  <name>string</name>
  <path>string</path>
  <devnode type="string"/>
  <parent>string</parent>
  <driver>
    <name>string</name>
  </driver>
  <capability/>
</device>

```

### [Secret](https://libvirt.org/formatsecret.html)

```
<?xml version="1.0" encoding="utf-8"?>

<secret ephemeral="string" private="string">
  <description>string</description>
  <uuid>string</uuid>
  <usage type="string">
    <volume>string</volume>
    <name>string</name>
    <target>string</target>
  </usage>
</secret>

```

### [Snapshot](https://libvirt.org/formatsnapshot.html)

```
<?xml version="1.0" encoding="utf-8"?>

<domainsnapshot>
  <name>string</name>
  <description>string</description>
  <state>string</state>
  <creationTime>string</creationTime>
  <parent>
    <name>string</name>
  </parent>
  <memory snapshot="string" file="string"/>
  <disks>
    <disk name="string" snapshot="string">
      <driver type="string"/>
      <source startupPolicy="string" index="uint">
        <encryption format="string">
          <secret type="string" usage="string" uuid="string"/>
        </encryption>
        <reservations enabled="string" managed="string">
          <source/>
        </reservations>
      </source>
    </disk>
  </disks>
  <active>*uint</active>
  <domain>...</domain>
</domainsnapshot>
```
