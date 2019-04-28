
## XML 样式

以下libvirt支持的xml形式是由[代码](../analyser)自动生成，可对照[官方文档](https://libvirt.org/docs.html)进行查询,
我们发现libvirt-go-xml官方项目仍有很大改进空间，与官方文档可能有出入


### [Domain.xml](https://libvirt.org/formatdomain.html)

```
<?xml version="1.0" encoding="utf-8"?>

<domain id="*int">
  <genid>value</genid>
  <metadata/>
  <maxMemory>value</maxMemory>
  <memory>value</memory>
  <currentMemory>value</currentMemory>
  <blkiotune>
    <device>
      <path>string</path>
    </device>
  </blkiotune>
  <memtune>
    <hard_limit>value</hard_limit>
    <soft_limit>value</soft_limit>
    <min_guarantee>value</min_guarantee>
    <swap_hard_limit>value</swap_hard_limit>
  </memtune>
  <memoryBacking>
    <hugepages>
      <page size="uint"/>
    </hugepages>
    <nosharepages/>
    <locked/>
    <source/>
    <access/>
    <allocation/>
    <discard/>
  </memoryBacking>
  <vcpu>value</vcpu>
  <vcpus>
    <vcpu id="*uint" order="*uint"/>
  </vcpus>
  <iothreadids>
    <iothread id="uint"/>
  </iothreadids>
  <cputune>
    <shares>value</shares>
    <period>value</period>
    <quota>value</quota>
    <global_period>value</global_period>
    <global_quota>value</global_quota>
    <emulator_period>value</emulator_period>
    <emulator_quota>value</emulator_quota>
    <iothread_period>value</iothread_period>
    <iothread_quota>value</iothread_quota>
    <vcpupin vcpu="uint" cpuset="string"/>
    <emulatorpin cpuset="string"/>
    <iothreadpin iothread="uint" cpuset="string"/>
    <vcpusched vcpus="string" priority="*int"/>
    <iothreadsched iothreads="string" priority="*int"/>
    <cachetune>
      <cache id="uint" level="uint" type="string" size="uint" unit="string"/>
      <monitor/>
    </cachetune>
    <memorytune vcpus="string">
      <node id="uint" bandwidth="uint"/>
    </memorytune>
  </cputune>
  <numatune>
    <memory/>
    <memnode cellid="uint" mode="string" nodeset="string"/>
  </numatune>
  <resource/>
  <sysinfo type="string">
    <bios>
      <entry name="string">value</entry>
    </bios>
    <system>
      <entry name="string">value</entry>
    </system>
    <baseBoard>
      <entry name="string">value</entry>
    </baseBoard>
    <chassis>
      <entry name="string">value</entry>
    </chassis>
    <processor>
      <entry name="string">value</entry>
    </processor>
    <memory>
      <entry name="string">value</entry>
    </memory>
    <oemStrings>
      <entry>[]string</entry>
    </oemStrings>
  </sysinfo>
  <os>
    <type>value</type>
    <initarg>[]string</initarg>
    <initenv name="string">value</initenv>
    <loader>value</loader>
    <nvram>value</nvram>
    <acpi>
      <table type="string">value</table>
    </acpi>
    <boot dev="string"/>
    <bootmenu/>
    <bios rebootTimeout="*int"/>
    <smbios mode="string"/>
  </os>
  <idmap>
    <uid start="uint" target="uint" count="uint"/>
    <gid start="uint" target="uint" count="uint"/>
  </idmap>
  <features>
    <pae/>
    <acpi/>
    <apic/>
    <hap/>
    <viridian/>
    <privnet/>
    <hyperv>
      <relaxed/>
      <vapic/>
      <spinlocks/>
      <vpindex/>
      <runtime/>
      <synic/>
      <stimer/>
      <reset/>
      <vendor_id/>
      <frequencies/>
      <reenlightenment/>
      <tlbflush/>
      <ipi/>
      <evmcs/>
    </hyperv>
    <kvm>
      <hidden/>
    </kvm>
    <pvspinlock/>
    <pmu/>
    <vmport/>
    <gic/>
    <smm>
      <tseg>value</tseg>
    </smm>
    <ioapic/>
    <hpt>
      <maxpagesize>value</maxpagesize>
    </hpt>
    <htm/>
    <nested-hv/>
    <capabilities>
      <audit_control/>
      <audit_write/>
      <block_suspend/>
      <chown/>
      <dac_override/>
      <dac_read_Search/>
      <fowner/>
      <fsetid/>
      <ipc_lock/>
      <ipc_owner/>
      <kill/>
      <lease/>
      <linux_immutable/>
      <mac_admin/>
      <mac_override/>
      <mknod/>
      <net_admin/>
      <net_bind_service/>
      <net_broadcast/>
      <net_raw/>
      <setgid/>
      <setfcap/>
      <setpcap/>
      <setuid/>
      <sys_admin/>
      <sys_boot/>
      <sys_chroot/>
      <sys_module/>
      <sys_nice/>
      <sys_pacct/>
      <sys_ptrace/>
      <sys_rawio/>
      <sys_resource/>
      <sys_time/>
      <sys_tty_config/>
      <syslog/>
      <wake_alarm/>
    </capabilities>
    <vmcoreinfo/>
    <msrs unknown="string"/>
  </features>
  <cpu>
    <model>value</model>
    <topology/>
    <cache mode="string"/>
    <feature/>
    <numa>
      <cell id="*uint" cpus="string" memory="string">
        <distances>
          <sibling id="uint" value="uint"/>
        </distances>
      </cell>
    </numa>
  </cpu>
  <clock>
    <timer name="string">
      <catchup/>
    </timer>
  </clock>
  <pm>
    <suspend-to-mem enabled="string"/>
    <suspend-to-disk enabled="string"/>
  </pm>
  <perf>
    <event name="string" enabled="string"/>
  </perf>
  <devices>
    <disk>
      <driver iothread="*uint" queues="*uint"/>
      <auth>
        <secret/>
      </auth>
      <source>
        <encryption>
          <secret/>
        </encryption>
        <reservations>
          <source/>
        </reservations>
      </source>
      <backingStore>
        <format type="string"/>
        <source>
          <encryption>
            <secret/>
          </encryption>
          <reservations>
            <source/>
          </reservations>
        </source>
      </backingStore>
      <geometry cyls="uint" heads="uint" secs="uint"/>
      <blockio/>
      <mirror>
        <format type="string"/>
        <source>
          <encryption>
            <secret/>
          </encryption>
          <reservations>
            <source/>
          </reservations>
        </source>
      </mirror>
      <target/>
      <iotune/>
      <readonly/>
      <shareable/>
      <transient/>
      <encryption>
        <secret/>
      </encryption>
      <boot order="uint"/>
      <alias name="string"/>
      <address/>
    </disk>
    <controller type="string" index="*uint">
      <driver queues="*uint" cmd_per_lun="*uint" max_sectors="*uint"/>
      <alias name="string"/>
      <address/>
    </controller>
    <lease>
      <lockspace>string</lockspace>
      <key>string</key>
      <target path="string"/>
    </lease>
    <filesystem>
      <driver/>
      <source/>
      <target dir="string"/>
      <readonly/>
      <space_hard_limit>value</space_hard_limit>
      <space_soft_limit>value</space_soft_limit>
      <alias name="string"/>
      <address/>
    </filesystem>
    <interface>
      <mac address="string"/>
      <source/>
      <boot order="uint"/>
      <vlan>
        <tag id="uint"/>
      </vlan>
      <virtualport>
        <parameters/>
      </virtualport>
      <ip address="string"/>
      <route address="string" gateway="string"/>
      <script path="string"/>
      <target dev="string"/>
      <guest/>
      <model type="string"/>
      <driver>
        <host/>
        <guest/>
      </driver>
      <backend/>
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
      <rom/>
      <alias name="string"/>
      <address/>
    </interface>
    <smartcard>
      <source/>
      <protocol type="string"/>
      <certificate>value</certificate>
      <alias name="string"/>
      <address/>
    </smartcard>
    <serial>
      <source/>
      <protocol type="string"/>
      <target port="*uint">
        <model/>
      </target>
      <log file="string"/>
      <alias name="string"/>
      <address/>
    </serial>
    <parallel>
      <source/>
      <protocol type="string"/>
      <target port="*uint"/>
      <log file="string"/>
      <alias name="string"/>
      <address/>
    </parallel>
    <console>
      <source/>
      <protocol type="string"/>
      <target port="*uint"/>
      <log file="string"/>
      <alias name="string"/>
      <address/>
    </console>
    <channel>
      <source/>
      <protocol type="string"/>
      <target/>
      <log file="string"/>
      <alias name="string"/>
      <address/>
    </channel>
    <input type="string">
      <driver/>
      <source evdev="string"/>
      <alias name="string"/>
      <address/>
    </input>
    <tpm>
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
      <model type="string">
        <acceleration/>
      </model>
      <driver/>
      <alias name="string"/>
      <address/>
    </video>
    <hostdev>
      <boot order="uint"/>
      <rom/>
      <alias name="string"/>
      <address/>
    </hostdev>
    <redirdev>
      <source/>
      <protocol type="string"/>
      <boot order="uint"/>
      <alias name="string"/>
      <address/>
    </redirdev>
    <redirfilter>
      <usbdev class="*uint" vendor="*uint" product="*uint" allow="string"/>
    </redirfilter>
    <hub type="string">
      <alias name="string"/>
      <address/>
    </hub>
    <watchdog model="string">
      <alias name="string"/>
      <address/>
    </watchdog>
    <memballoon model="string">
      <driver/>
      <stats period="uint"/>
      <alias name="string"/>
      <address/>
    </memballoon>
    <rng model="string">
      <driver/>
      <rate bytes="uint"/>
      <backend/>
      <alias name="string"/>
      <address/>
    </rng>
    <nvram>
      <alias name="string"/>
      <address/>
    </nvram>
    <panic>
      <alias name="string"/>
      <address/>
    </panic>
    <shmem name="string">
      <size>value</size>
      <model type="string"/>
      <server/>
      <msi/>
      <alias name="string"/>
      <address/>
    </shmem>
    <memory model="string">
      <source>
        <pagesize>value</pagesize>
        <alignsize>value</alignsize>
        <pmem/>
      </source>
      <target>
        <size>value</size>
        <node>value</node>
        <label>
          <size>value</size>
        </label>
        <readonly/>
      </target>
      <alias name="string"/>
      <address/>
    </memory>
    <iommu model="string">
      <driver/>
    </iommu>
    <vsock>
      <cid/>
      <alias name="string"/>
      <address/>
    </vsock>
  </devices>
  <seclabel/>
  <keywrap>
    <cipher name="string" state="string"/>
  </keywrap>
  <launchSecurity/>
</domain>
```


### [Network xml](https://libvirt.org/formatnetwork.html)

```
<?xml version="1.0" encoding="utf-8"?>

<network>
  <metadata/>
  <forward>
    <driver name="string"/>
    <pf dev="string"/>
    <nat>
      <address start="string" end="string"/>
      <port start="uint" end="uint"/>
    </nat>
    <interface/>
    <address/>
  </forward>
  <bridge/>
  <mtu size="uint"/>
  <mac/>
  <domain/>
  <dns>
    <forwarder/>
    <txt name="string" value="string"/>
    <host ip="string">
      <hostname>value</hostname>
    </host>
    <srv/>
  </dns>
  <vlan>
    <tag id="uint"/>
  </vlan>
  <bandwidth>
    <inbound average="*uint" peak="*uint" burst="*uint" floor="*uint"/>
    <outbound average="*uint" peak="*uint" burst="*uint" floor="*uint"/>
  </bandwidth>
  <ip>
    <dhcp>
      <range/>
      <host/>
      <bootp/>
    </dhcp>
    <tftp/>
  </ip>
  <route/>
  <virtualport>
    <parameters/>
  </virtualport>
  <portgroup>
    <vlan>
      <tag id="uint"/>
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
  <allocation>value</allocation>
  <capacity>value</capacity>
  <available>value</available>
  <target>
    <permissions/>
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
    <dir path="string"/>
    <host name="string"/>
    <device path="string">
      <freeExtent start="uint64" end="uint64"/>
    </device>
    <auth type="string" username="string">
      <secret/>
    </auth>
    <vendor name="string"/>
    <product name="string"/>
    <format type="string"/>
    <protocol ver="string"/>
    <adapter>
      <parentaddr unique_id="uint64">
        <address domain="*uint" bus="*uint" slot="*uint" function="*uint"/>
      </parentaddr>
    </adapter>
    <initiator>
      <iqn/>
    </initiator>
  </source>
  <refresh>
    <volume allocation="string"/>
  </refresh>
</pool>
```


### [Snapshot](https://libvirt.org/formatsnapshot.html)

```
<?xml version="1.0" encoding="utf-8"?>

<domainsnapshot>
  <parent>
    <name>string</name>
  </parent>
  <memory snapshot="string"/>
  <disks>
    <disk name="string">
      <driver/>
      <source>
        <encryption>
          <secret/>
        </encryption>
        <reservations>
          <source/>
        </reservations>
      </source>
    </disk>
  </disks>
  <domain id="*int">
    ...
  </domain>
  <active>*uint</active>
</domainsnapshot>

```
