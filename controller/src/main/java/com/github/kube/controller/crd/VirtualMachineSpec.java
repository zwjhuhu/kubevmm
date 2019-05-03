/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller.crd;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import java.util.List;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Wed May 01 17:15:35 CST 2019
 **/
@JsonDeserialize(using = JsonDeserializer.None.class)
public class VirtualMachineSpec implements KubernetesResource {

	private Domain domain;

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public class Domain {

		private Memory memory;

		private Vcpu vcpu;

		private List<Seclabel> seclabel;

		private java.lang.String description;

		private java.lang.String title;

		private java.lang.String uuid;

		private MaxMemory maxMemory;

		private Iothreadids iothreadids;

		private Features features;

		private java.lang.String on_crash;

		private Blkiotune blkiotune;

		private java.lang.String bootloader;

		private Sysinfo sysinfo;

		private Idmap idmap;

		private Memtune memtune;

		private Numatune numatune;

		private MemoryBacking memoryBacking;

		private Keywrap keywrap;

		private Perf perf;

		private java.lang.String on_poweroff;

		private java.lang.String image;

		private java.lang.String bootloader_args;

		private Os os;

		private Resource resource;

		private Devices devices;

		private java.lang.String on_reboot;

		private java.lang.String _type;

		private Cpu cpu;

		private Clock clock;

		private Vcpus vcpus;

		private Cputune cputune;

		private java.lang.String genid;

		private java.lang.String iothreads;

		private java.lang.String name;

		private CurrentMemory currentMemory;

		private java.lang.String _id;

		private Pm pm;

		public void setMemory(Memory memory) {
			this.memory = memory;
		}

		public Memory getMemory() {
			return this.memory;
		}

		public void setVcpu(Vcpu vcpu) {
			this.vcpu = vcpu;
		}

		public Vcpu getVcpu() {
			return this.vcpu;
		}

		public void setSeclabel(List<Seclabel> seclabel) {
			this.seclabel = seclabel;
		}

		public List<Seclabel> getSeclabel() {
			return this.seclabel;
		}

		public void setDescription(java.lang.String description) {
			this.description = description;
		}

		public java.lang.String getDescription() {
			return this.description;
		}

		public void setTitle(java.lang.String title) {
			this.title = title;
		}

		public java.lang.String getTitle() {
			return this.title;
		}

		public void setUuid(java.lang.String uuid) {
			this.uuid = uuid;
		}

		public java.lang.String getUuid() {
			return this.uuid;
		}

		public void setMaxMemory(MaxMemory maxMemory) {
			this.maxMemory = maxMemory;
		}

		public MaxMemory getMaxMemory() {
			return this.maxMemory;
		}

		public void setIothreadids(Iothreadids iothreadids) {
			this.iothreadids = iothreadids;
		}

		public Iothreadids getIothreadids() {
			return this.iothreadids;
		}

		public void setFeatures(Features features) {
			this.features = features;
		}

		public Features getFeatures() {
			return this.features;
		}

		public void setOn_crash(java.lang.String on_crash) {
			this.on_crash = on_crash;
		}

		public java.lang.String getOn_crash() {
			return this.on_crash;
		}

		public void setBlkiotune(Blkiotune blkiotune) {
			this.blkiotune = blkiotune;
		}

		public Blkiotune getBlkiotune() {
			return this.blkiotune;
		}

		public void setBootloader(java.lang.String bootloader) {
			this.bootloader = bootloader;
		}

		public java.lang.String getBootloader() {
			return this.bootloader;
		}

		public void setSysinfo(Sysinfo sysinfo) {
			this.sysinfo = sysinfo;
		}

		public Sysinfo getSysinfo() {
			return this.sysinfo;
		}

		public void setIdmap(Idmap idmap) {
			this.idmap = idmap;
		}

		public Idmap getIdmap() {
			return this.idmap;
		}

		public void setMemtune(Memtune memtune) {
			this.memtune = memtune;
		}

		public Memtune getMemtune() {
			return this.memtune;
		}

		public void setNumatune(Numatune numatune) {
			this.numatune = numatune;
		}

		public Numatune getNumatune() {
			return this.numatune;
		}

		public void setMemoryBacking(MemoryBacking memoryBacking) {
			this.memoryBacking = memoryBacking;
		}

		public MemoryBacking getMemoryBacking() {
			return this.memoryBacking;
		}

		public void setKeywrap(Keywrap keywrap) {
			this.keywrap = keywrap;
		}

		public Keywrap getKeywrap() {
			return this.keywrap;
		}

		public void setPerf(Perf perf) {
			this.perf = perf;
		}

		public Perf getPerf() {
			return this.perf;
		}

		public void setOn_poweroff(java.lang.String on_poweroff) {
			this.on_poweroff = on_poweroff;
		}

		public java.lang.String getOn_poweroff() {
			return this.on_poweroff;
		}

		public void setImage(java.lang.String image) {
			this.image = image;
		}

		public java.lang.String getImage() {
			return this.image;
		}

		public void setBootloader_args(java.lang.String bootloader_args) {
			this.bootloader_args = bootloader_args;
		}

		public java.lang.String getBootloader_args() {
			return this.bootloader_args;
		}

		public void setOs(Os os) {
			this.os = os;
		}

		public Os getOs() {
			return this.os;
		}

		public void setResource(Resource resource) {
			this.resource = resource;
		}

		public Resource getResource() {
			return this.resource;
		}

		public void setDevices(Devices devices) {
			this.devices = devices;
		}

		public Devices getDevices() {
			return this.devices;
		}

		public void setOn_reboot(java.lang.String on_reboot) {
			this.on_reboot = on_reboot;
		}

		public java.lang.String getOn_reboot() {
			return this.on_reboot;
		}

		public void set_type(java.lang.String _type) {
			this._type = _type;
		}

		public java.lang.String get_type() {
			return this._type;
		}

		public void setCpu(Cpu cpu) {
			this.cpu = cpu;
		}

		public Cpu getCpu() {
			return this.cpu;
		}

		public void setClock(Clock clock) {
			this.clock = clock;
		}

		public Clock getClock() {
			return this.clock;
		}

		public void setVcpus(Vcpus vcpus) {
			this.vcpus = vcpus;
		}

		public Vcpus getVcpus() {
			return this.vcpus;
		}

		public void setCputune(Cputune cputune) {
			this.cputune = cputune;
		}

		public Cputune getCputune() {
			return this.cputune;
		}

		public void setGenid(java.lang.String genid) {
			this.genid = genid;
		}

		public java.lang.String getGenid() {
			return this.genid;
		}

		public void setIothreads(java.lang.String iothreads) {
			this.iothreads = iothreads;
		}

		public java.lang.String getIothreads() {
			return this.iothreads;
		}

		public void setName(java.lang.String name) {
			this.name = name;
		}

		public java.lang.String getName() {
			return this.name;
		}

		public void setCurrentMemory(CurrentMemory currentMemory) {
			this.currentMemory = currentMemory;
		}

		public CurrentMemory getCurrentMemory() {
			return this.currentMemory;
		}

		public void set_id(java.lang.String _id) {
			this._id = _id;
		}

		public java.lang.String get_id() {
			return this._id;
		}

		public void setPm(Pm pm) {
			this.pm = pm;
		}

		public Pm getPm() {
			return this.pm;
		}

		public class Memory {

			private java.lang.String _unit;

			private java.lang.String text;

			private java.lang.String _dumpCore;

			public void set_unit(java.lang.String _unit) {
				this._unit = _unit;
			}

			public java.lang.String get_unit() {
				return this._unit;
			}

			public void setText(java.lang.String text) {
				this.text = text;
			}

			public java.lang.String getText() {
				return this.text;
			}

			public void set_dumpCore(java.lang.String _dumpCore) {
				this._dumpCore = _dumpCore;
			}

			public java.lang.String get_dumpCore() {
				return this._dumpCore;
			}
		}

		public class Vcpu {

			private java.lang.String _current;

			private java.lang.String _placement;

			private java.lang.String _cpuset;

			private java.lang.String text;

			public void set_current(java.lang.String _current) {
				this._current = _current;
			}

			public java.lang.String get_current() {
				return this._current;
			}

			public void set_placement(java.lang.String _placement) {
				this._placement = _placement;
			}

			public java.lang.String get_placement() {
				return this._placement;
			}

			public void set_cpuset(java.lang.String _cpuset) {
				this._cpuset = _cpuset;
			}

			public java.lang.String get_cpuset() {
				return this._cpuset;
			}

			public void setText(java.lang.String text) {
				this.text = text;
			}

			public java.lang.String getText() {
				return this.text;
			}
		}

		public class Seclabel {

			private java.lang.String imagelabel;

			private java.lang.String _type;

			private java.lang.String baselabel;

			private java.lang.String _model;

			private java.lang.String label;

			private java.lang.String _relabel;

			public void setImagelabel(java.lang.String imagelabel) {
				this.imagelabel = imagelabel;
			}

			public java.lang.String getImagelabel() {
				return this.imagelabel;
			}

			public void set_type(java.lang.String _type) {
				this._type = _type;
			}

			public java.lang.String get_type() {
				return this._type;
			}

			public void setBaselabel(java.lang.String baselabel) {
				this.baselabel = baselabel;
			}

			public java.lang.String getBaselabel() {
				return this.baselabel;
			}

			public void set_model(java.lang.String _model) {
				this._model = _model;
			}

			public java.lang.String get_model() {
				return this._model;
			}

			public void setLabel(java.lang.String label) {
				this.label = label;
			}

			public java.lang.String getLabel() {
				return this.label;
			}

			public void set_relabel(java.lang.String _relabel) {
				this._relabel = _relabel;
			}

			public java.lang.String get_relabel() {
				return this._relabel;
			}
		}

		public class MaxMemory {

			private java.lang.String _unit;

			private java.lang.String _slots;

			private java.lang.String text;

			public void set_unit(java.lang.String _unit) {
				this._unit = _unit;
			}

			public java.lang.String get_unit() {
				return this._unit;
			}

			public void set_slots(java.lang.String _slots) {
				this._slots = _slots;
			}

			public java.lang.String get_slots() {
				return this._slots;
			}

			public void setText(java.lang.String text) {
				this.text = text;
			}

			public java.lang.String getText() {
				return this.text;
			}
		}

		public class Iothreadids {

			private List<Iothread> iothread;

			public void setIothread(List<Iothread> iothread) {
				this.iothread = iothread;
			}

			public List<Iothread> getIothread() {
				return this.iothread;
			}

			public class Iothread {

				private java.lang.String _id;

				public void set_id(java.lang.String _id) {
					this._id = _id;
				}

				public java.lang.String get_id() {
					return this._id;
				}
			}
		}

		public class Features {

			private Gic gic;

			private Htm htm;

			private Kvm kvm;

			private Capabilities capabilities;

			private Apic apic;

			private Pvspinlock pvspinlock;

			private Vmport vmport;

			private Vmcoreinfo vmcoreinfo;

			private Hpt hpt;

			private Nested_hv nested_hv;

			private Smm smm;

			private Msrs msrs;

			private Hap hap;

			private Pmu pmu;

			private Ioapic ioapic;

			private Hyperv hyperv;

			public void setGic(Gic gic) {
				this.gic = gic;
			}

			public Gic getGic() {
				return this.gic;
			}

			public void setHtm(Htm htm) {
				this.htm = htm;
			}

			public Htm getHtm() {
				return this.htm;
			}

			public void setKvm(Kvm kvm) {
				this.kvm = kvm;
			}

			public Kvm getKvm() {
				return this.kvm;
			}

			public void setCapabilities(Capabilities capabilities) {
				this.capabilities = capabilities;
			}

			public Capabilities getCapabilities() {
				return this.capabilities;
			}

			public void setApic(Apic apic) {
				this.apic = apic;
			}

			public Apic getApic() {
				return this.apic;
			}

			public void setPvspinlock(Pvspinlock pvspinlock) {
				this.pvspinlock = pvspinlock;
			}

			public Pvspinlock getPvspinlock() {
				return this.pvspinlock;
			}

			public void setVmport(Vmport vmport) {
				this.vmport = vmport;
			}

			public Vmport getVmport() {
				return this.vmport;
			}

			public void setVmcoreinfo(Vmcoreinfo vmcoreinfo) {
				this.vmcoreinfo = vmcoreinfo;
			}

			public Vmcoreinfo getVmcoreinfo() {
				return this.vmcoreinfo;
			}

			public void setHpt(Hpt hpt) {
				this.hpt = hpt;
			}

			public Hpt getHpt() {
				return this.hpt;
			}

			public void setNested_hv(Nested_hv nested_hv) {
				this.nested_hv = nested_hv;
			}

			public Nested_hv getNested_hv() {
				return this.nested_hv;
			}

			public void setSmm(Smm smm) {
				this.smm = smm;
			}

			public Smm getSmm() {
				return this.smm;
			}

			public void setMsrs(Msrs msrs) {
				this.msrs = msrs;
			}

			public Msrs getMsrs() {
				return this.msrs;
			}

			public void setHap(Hap hap) {
				this.hap = hap;
			}

			public Hap getHap() {
				return this.hap;
			}

			public void setPmu(Pmu pmu) {
				this.pmu = pmu;
			}

			public Pmu getPmu() {
				return this.pmu;
			}

			public void setIoapic(Ioapic ioapic) {
				this.ioapic = ioapic;
			}

			public Ioapic getIoapic() {
				return this.ioapic;
			}

			public void setHyperv(Hyperv hyperv) {
				this.hyperv = hyperv;
			}

			public Hyperv getHyperv() {
				return this.hyperv;
			}

			public class Gic {

				private java.lang.String _version;

				public void set_version(java.lang.String _version) {
					this._version = _version;
				}

				public java.lang.String get_version() {
					return this._version;
				}
			}

			public class Htm {

				private java.lang.String _state;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}

			public class Kvm {

				private Hidden hidden;

				public void setHidden(Hidden hidden) {
					this.hidden = hidden;
				}

				public Hidden getHidden() {
					return this.hidden;
				}

				public class Hidden {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}
			}

			public class Capabilities {

				private Dac_read_Search dac_read_Search;

				private Fsetid fsetid;

				private Dac_override dac_override;

				private Syslog syslog;

				private java.lang.String _policy;

				private Net_raw net_raw;

				private Mac_override mac_override;

				private Setfcap setfcap;

				private Mknod mknod;

				private Sys_time sys_time;

				private Sys_tty_config sys_tty_config;

				private Net_broadcast net_broadcast;

				private Setpcap setpcap;

				private Ipc_lock ipc_lock;

				private Net_bind_service net_bind_service;

				private Wake_alarm wake_alarm;

				private Linux_immutable linux_immutable;

				private Sys_pacct sys_pacct;

				private Ipc_owner ipc_owner;

				private Net_admin net_admin;

				private Setgid setgid;

				private Sys_ptrace sys_ptrace;

				private Chown chown;

				private Sys_admin sys_admin;

				private Sys_module sys_module;

				private Sys_nice sys_nice;

				private Kill kill;

				private Audit_control audit_control;

				private Setuid setuid;

				private Fowner fowner;

				private Sys_resource sys_resource;

				private Sys_chroot sys_chroot;

				private Sys_rawio sys_rawio;

				private Audit_write audit_write;

				private Block_suspend block_suspend;

				private Lease lease;

				private Sys_boot sys_boot;

				private Mac_admin mac_admin;

				public void setDac_read_Search(Dac_read_Search dac_read_Search) {
					this.dac_read_Search = dac_read_Search;
				}

				public Dac_read_Search getDac_read_Search() {
					return this.dac_read_Search;
				}

				public void setFsetid(Fsetid fsetid) {
					this.fsetid = fsetid;
				}

				public Fsetid getFsetid() {
					return this.fsetid;
				}

				public void setDac_override(Dac_override dac_override) {
					this.dac_override = dac_override;
				}

				public Dac_override getDac_override() {
					return this.dac_override;
				}

				public void setSyslog(Syslog syslog) {
					this.syslog = syslog;
				}

				public Syslog getSyslog() {
					return this.syslog;
				}

				public void set_policy(java.lang.String _policy) {
					this._policy = _policy;
				}

				public java.lang.String get_policy() {
					return this._policy;
				}

				public void setNet_raw(Net_raw net_raw) {
					this.net_raw = net_raw;
				}

				public Net_raw getNet_raw() {
					return this.net_raw;
				}

				public void setMac_override(Mac_override mac_override) {
					this.mac_override = mac_override;
				}

				public Mac_override getMac_override() {
					return this.mac_override;
				}

				public void setSetfcap(Setfcap setfcap) {
					this.setfcap = setfcap;
				}

				public Setfcap getSetfcap() {
					return this.setfcap;
				}

				public void setMknod(Mknod mknod) {
					this.mknod = mknod;
				}

				public Mknod getMknod() {
					return this.mknod;
				}

				public void setSys_time(Sys_time sys_time) {
					this.sys_time = sys_time;
				}

				public Sys_time getSys_time() {
					return this.sys_time;
				}

				public void setSys_tty_config(Sys_tty_config sys_tty_config) {
					this.sys_tty_config = sys_tty_config;
				}

				public Sys_tty_config getSys_tty_config() {
					return this.sys_tty_config;
				}

				public void setNet_broadcast(Net_broadcast net_broadcast) {
					this.net_broadcast = net_broadcast;
				}

				public Net_broadcast getNet_broadcast() {
					return this.net_broadcast;
				}

				public void setSetpcap(Setpcap setpcap) {
					this.setpcap = setpcap;
				}

				public Setpcap getSetpcap() {
					return this.setpcap;
				}

				public void setIpc_lock(Ipc_lock ipc_lock) {
					this.ipc_lock = ipc_lock;
				}

				public Ipc_lock getIpc_lock() {
					return this.ipc_lock;
				}

				public void setNet_bind_service(Net_bind_service net_bind_service) {
					this.net_bind_service = net_bind_service;
				}

				public Net_bind_service getNet_bind_service() {
					return this.net_bind_service;
				}

				public void setWake_alarm(Wake_alarm wake_alarm) {
					this.wake_alarm = wake_alarm;
				}

				public Wake_alarm getWake_alarm() {
					return this.wake_alarm;
				}

				public void setLinux_immutable(Linux_immutable linux_immutable) {
					this.linux_immutable = linux_immutable;
				}

				public Linux_immutable getLinux_immutable() {
					return this.linux_immutable;
				}

				public void setSys_pacct(Sys_pacct sys_pacct) {
					this.sys_pacct = sys_pacct;
				}

				public Sys_pacct getSys_pacct() {
					return this.sys_pacct;
				}

				public void setIpc_owner(Ipc_owner ipc_owner) {
					this.ipc_owner = ipc_owner;
				}

				public Ipc_owner getIpc_owner() {
					return this.ipc_owner;
				}

				public void setNet_admin(Net_admin net_admin) {
					this.net_admin = net_admin;
				}

				public Net_admin getNet_admin() {
					return this.net_admin;
				}

				public void setSetgid(Setgid setgid) {
					this.setgid = setgid;
				}

				public Setgid getSetgid() {
					return this.setgid;
				}

				public void setSys_ptrace(Sys_ptrace sys_ptrace) {
					this.sys_ptrace = sys_ptrace;
				}

				public Sys_ptrace getSys_ptrace() {
					return this.sys_ptrace;
				}

				public void setChown(Chown chown) {
					this.chown = chown;
				}

				public Chown getChown() {
					return this.chown;
				}

				public void setSys_admin(Sys_admin sys_admin) {
					this.sys_admin = sys_admin;
				}

				public Sys_admin getSys_admin() {
					return this.sys_admin;
				}

				public void setSys_module(Sys_module sys_module) {
					this.sys_module = sys_module;
				}

				public Sys_module getSys_module() {
					return this.sys_module;
				}

				public void setSys_nice(Sys_nice sys_nice) {
					this.sys_nice = sys_nice;
				}

				public Sys_nice getSys_nice() {
					return this.sys_nice;
				}

				public void setKill(Kill kill) {
					this.kill = kill;
				}

				public Kill getKill() {
					return this.kill;
				}

				public void setAudit_control(Audit_control audit_control) {
					this.audit_control = audit_control;
				}

				public Audit_control getAudit_control() {
					return this.audit_control;
				}

				public void setSetuid(Setuid setuid) {
					this.setuid = setuid;
				}

				public Setuid getSetuid() {
					return this.setuid;
				}

				public void setFowner(Fowner fowner) {
					this.fowner = fowner;
				}

				public Fowner getFowner() {
					return this.fowner;
				}

				public void setSys_resource(Sys_resource sys_resource) {
					this.sys_resource = sys_resource;
				}

				public Sys_resource getSys_resource() {
					return this.sys_resource;
				}

				public void setSys_chroot(Sys_chroot sys_chroot) {
					this.sys_chroot = sys_chroot;
				}

				public Sys_chroot getSys_chroot() {
					return this.sys_chroot;
				}

				public void setSys_rawio(Sys_rawio sys_rawio) {
					this.sys_rawio = sys_rawio;
				}

				public Sys_rawio getSys_rawio() {
					return this.sys_rawio;
				}

				public void setAudit_write(Audit_write audit_write) {
					this.audit_write = audit_write;
				}

				public Audit_write getAudit_write() {
					return this.audit_write;
				}

				public void setBlock_suspend(Block_suspend block_suspend) {
					this.block_suspend = block_suspend;
				}

				public Block_suspend getBlock_suspend() {
					return this.block_suspend;
				}

				public void setLease(Lease lease) {
					this.lease = lease;
				}

				public Lease getLease() {
					return this.lease;
				}

				public void setSys_boot(Sys_boot sys_boot) {
					this.sys_boot = sys_boot;
				}

				public Sys_boot getSys_boot() {
					return this.sys_boot;
				}

				public void setMac_admin(Mac_admin mac_admin) {
					this.mac_admin = mac_admin;
				}

				public Mac_admin getMac_admin() {
					return this.mac_admin;
				}

				public class Dac_read_Search {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Fsetid {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Dac_override {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Syslog {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Net_raw {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Mac_override {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Setfcap {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Mknod {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_time {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_tty_config {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Net_broadcast {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Setpcap {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Ipc_lock {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Net_bind_service {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Wake_alarm {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Linux_immutable {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_pacct {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Ipc_owner {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Net_admin {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Setgid {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_ptrace {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Chown {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_admin {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_module {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_nice {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Kill {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Audit_control {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Setuid {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Fowner {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_resource {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_chroot {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_rawio {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Audit_write {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Block_suspend {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Lease {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Sys_boot {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Mac_admin {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}
			}

			public class Apic {

				private java.lang.String _eoi;

				public void set_eoi(java.lang.String _eoi) {
					this._eoi = _eoi;
				}

				public java.lang.String get_eoi() {
					return this._eoi;
				}
			}

			public class Pvspinlock {

				private java.lang.String _state;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}

			public class Vmport {

				private java.lang.String _state;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}

			public class Vmcoreinfo {

				private java.lang.String _state;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}

			public class Hpt {

				private Maxpagesize maxpagesize;

				private java.lang.String _resizing;

				public void setMaxpagesize(Maxpagesize maxpagesize) {
					this.maxpagesize = maxpagesize;
				}

				public Maxpagesize getMaxpagesize() {
					return this.maxpagesize;
				}

				public void set_resizing(java.lang.String _resizing) {
					this._resizing = _resizing;
				}

				public java.lang.String get_resizing() {
					return this._resizing;
				}

				public class Maxpagesize {

					private java.lang.String _unit;

					private java.lang.String text;

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class Nested_hv {

				private java.lang.String _state;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}

			public class Smm {

				private java.lang.String _state;

				private Tseg tseg;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}

				public void setTseg(Tseg tseg) {
					this.tseg = tseg;
				}

				public Tseg getTseg() {
					return this.tseg;
				}

				public class Tseg {

					private java.lang.String _unit;

					private java.lang.String text;

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class Msrs {

				private java.lang.String _unknown;

				public void set_unknown(java.lang.String _unknown) {
					this._unknown = _unknown;
				}

				public java.lang.String get_unknown() {
					return this._unknown;
				}
			}

			public class Hap {

				private java.lang.String _state;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}

			public class Pmu {

				private java.lang.String _state;

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}

			public class Ioapic {

				private java.lang.String _driver;

				public void set_driver(java.lang.String _driver) {
					this._driver = _driver;
				}

				public java.lang.String get_driver() {
					return this._driver;
				}
			}

			public class Hyperv {

				private Vpindex vpindex;

				private Stimer stimer;

				private Ipi ipi;

				private Reenlightenment reenlightenment;

				private Runtime runtime;

				private Evmcs evmcs;

				private Spinlocks spinlocks;

				private Tlbflush tlbflush;

				private Synic synic;

				private Relaxed relaxed;

				private Vapic vapic;

				private Vendor_id vendor_id;

				private Reset reset;

				private Frequencies frequencies;

				public void setVpindex(Vpindex vpindex) {
					this.vpindex = vpindex;
				}

				public Vpindex getVpindex() {
					return this.vpindex;
				}

				public void setStimer(Stimer stimer) {
					this.stimer = stimer;
				}

				public Stimer getStimer() {
					return this.stimer;
				}

				public void setIpi(Ipi ipi) {
					this.ipi = ipi;
				}

				public Ipi getIpi() {
					return this.ipi;
				}

				public void setReenlightenment(Reenlightenment reenlightenment) {
					this.reenlightenment = reenlightenment;
				}

				public Reenlightenment getReenlightenment() {
					return this.reenlightenment;
				}

				public void setRuntime(Runtime runtime) {
					this.runtime = runtime;
				}

				public Runtime getRuntime() {
					return this.runtime;
				}

				public void setEvmcs(Evmcs evmcs) {
					this.evmcs = evmcs;
				}

				public Evmcs getEvmcs() {
					return this.evmcs;
				}

				public void setSpinlocks(Spinlocks spinlocks) {
					this.spinlocks = spinlocks;
				}

				public Spinlocks getSpinlocks() {
					return this.spinlocks;
				}

				public void setTlbflush(Tlbflush tlbflush) {
					this.tlbflush = tlbflush;
				}

				public Tlbflush getTlbflush() {
					return this.tlbflush;
				}

				public void setSynic(Synic synic) {
					this.synic = synic;
				}

				public Synic getSynic() {
					return this.synic;
				}

				public void setRelaxed(Relaxed relaxed) {
					this.relaxed = relaxed;
				}

				public Relaxed getRelaxed() {
					return this.relaxed;
				}

				public void setVapic(Vapic vapic) {
					this.vapic = vapic;
				}

				public Vapic getVapic() {
					return this.vapic;
				}

				public void setVendor_id(Vendor_id vendor_id) {
					this.vendor_id = vendor_id;
				}

				public Vendor_id getVendor_id() {
					return this.vendor_id;
				}

				public void setReset(Reset reset) {
					this.reset = reset;
				}

				public Reset getReset() {
					return this.reset;
				}

				public void setFrequencies(Frequencies frequencies) {
					this.frequencies = frequencies;
				}

				public Frequencies getFrequencies() {
					return this.frequencies;
				}

				public class Vpindex {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Stimer {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Ipi {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Reenlightenment {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Runtime {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Evmcs {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Spinlocks {

					private java.lang.String _retries;

					public void set_retries(java.lang.String _retries) {
						this._retries = _retries;
					}

					public java.lang.String get_retries() {
						return this._retries;
					}
				}

				public class Tlbflush {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Synic {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Relaxed {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Vapic {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Vendor_id {

					private java.lang.String _string;

					public void set_string(java.lang.String _string) {
						this._string = _string;
					}

					public java.lang.String get_string() {
						return this._string;
					}
				}

				public class Reset {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Frequencies {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}
			}
		}

		public class Blkiotune {

			private java.lang.String weight;

			private List<Device> device;

			public void setWeight(java.lang.String weight) {
				this.weight = weight;
			}

			public java.lang.String getWeight() {
				return this.weight;
			}

			public void setDevice(List<Device> device) {
				this.device = device;
			}

			public List<Device> getDevice() {
				return this.device;
			}

			public class Device {

				private java.lang.String path;

				private java.lang.String write_bytes_sec;

				private java.lang.String write_iops_sec;

				private java.lang.String weight;

				private java.lang.String read_bytes_sec;

				private java.lang.String read_iops_sec;

				public void setPath(java.lang.String path) {
					this.path = path;
				}

				public java.lang.String getPath() {
					return this.path;
				}

				public void setWrite_bytes_sec(java.lang.String write_bytes_sec) {
					this.write_bytes_sec = write_bytes_sec;
				}

				public java.lang.String getWrite_bytes_sec() {
					return this.write_bytes_sec;
				}

				public void setWrite_iops_sec(java.lang.String write_iops_sec) {
					this.write_iops_sec = write_iops_sec;
				}

				public java.lang.String getWrite_iops_sec() {
					return this.write_iops_sec;
				}

				public void setWeight(java.lang.String weight) {
					this.weight = weight;
				}

				public java.lang.String getWeight() {
					return this.weight;
				}

				public void setRead_bytes_sec(java.lang.String read_bytes_sec) {
					this.read_bytes_sec = read_bytes_sec;
				}

				public java.lang.String getRead_bytes_sec() {
					return this.read_bytes_sec;
				}

				public void setRead_iops_sec(java.lang.String read_iops_sec) {
					this.read_iops_sec = read_iops_sec;
				}

				public java.lang.String getRead_iops_sec() {
					return this.read_iops_sec;
				}
			}
		}

		public class Sysinfo {

			private System system;

			private List<Memory> memory;

			private Bios bios;

			private List<BaseBoard> baseBoard;

			private java.lang.String _type;

			private Chassis chassis;

			private OemStrings oemStrings;

			private List<Processor> processor;

			public void setSystem(System system) {
				this.system = system;
			}

			public System getSystem() {
				return this.system;
			}

			public void setMemory(List<Memory> memory) {
				this.memory = memory;
			}

			public List<Memory> getMemory() {
				return this.memory;
			}

			public void setBios(Bios bios) {
				this.bios = bios;
			}

			public Bios getBios() {
				return this.bios;
			}

			public void setBaseBoard(List<BaseBoard> baseBoard) {
				this.baseBoard = baseBoard;
			}

			public List<BaseBoard> getBaseBoard() {
				return this.baseBoard;
			}

			public void set_type(java.lang.String _type) {
				this._type = _type;
			}

			public java.lang.String get_type() {
				return this._type;
			}

			public void setChassis(Chassis chassis) {
				this.chassis = chassis;
			}

			public Chassis getChassis() {
				return this.chassis;
			}

			public void setOemStrings(OemStrings oemStrings) {
				this.oemStrings = oemStrings;
			}

			public OemStrings getOemStrings() {
				return this.oemStrings;
			}

			public void setProcessor(List<Processor> processor) {
				this.processor = processor;
			}

			public List<Processor> getProcessor() {
				return this.processor;
			}

			public class System {

				private List<Entry> entry;

				public void setEntry(List<Entry> entry) {
					this.entry = entry;
				}

				public List<Entry> getEntry() {
					return this.entry;
				}

				public class Entry {

					private java.lang.String _name;

					private java.lang.String text;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class Memory {

				private List<Entry> entry;

				public void setEntry(List<Entry> entry) {
					this.entry = entry;
				}

				public List<Entry> getEntry() {
					return this.entry;
				}

				public class Entry {

					private java.lang.String _name;

					private java.lang.String text;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class Bios {

				private List<Entry> entry;

				public void setEntry(List<Entry> entry) {
					this.entry = entry;
				}

				public List<Entry> getEntry() {
					return this.entry;
				}

				public class Entry {

					private java.lang.String _name;

					private java.lang.String text;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class BaseBoard {

				private List<Entry> entry;

				public void setEntry(List<Entry> entry) {
					this.entry = entry;
				}

				public List<Entry> getEntry() {
					return this.entry;
				}

				public class Entry {

					private java.lang.String _name;

					private java.lang.String text;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class Chassis {

				private List<Entry> entry;

				public void setEntry(List<Entry> entry) {
					this.entry = entry;
				}

				public List<Entry> getEntry() {
					return this.entry;
				}

				public class Entry {

					private java.lang.String _name;

					private java.lang.String text;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class OemStrings {

				private java.lang.String entry;

				public void setEntry(java.lang.String entry) {
					this.entry = entry;
				}

				public java.lang.String getEntry() {
					return this.entry;
				}
			}

			public class Processor {

				private List<Entry> entry;

				public void setEntry(List<Entry> entry) {
					this.entry = entry;
				}

				public List<Entry> getEntry() {
					return this.entry;
				}

				public class Entry {

					private java.lang.String _name;

					private java.lang.String text;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}
		}

		public class Idmap {

			private List<Uid> uid;

			private List<Gid> gid;

			public void setUid(List<Uid> uid) {
				this.uid = uid;
			}

			public List<Uid> getUid() {
				return this.uid;
			}

			public void setGid(List<Gid> gid) {
				this.gid = gid;
			}

			public List<Gid> getGid() {
				return this.gid;
			}

			public class Uid {

				private java.lang.String _count;

				private java.lang.String _start;

				private java.lang.String _target;

				public void set_count(java.lang.String _count) {
					this._count = _count;
				}

				public java.lang.String get_count() {
					return this._count;
				}

				public void set_start(java.lang.String _start) {
					this._start = _start;
				}

				public java.lang.String get_start() {
					return this._start;
				}

				public void set_target(java.lang.String _target) {
					this._target = _target;
				}

				public java.lang.String get_target() {
					return this._target;
				}
			}

			public class Gid {

				private java.lang.String _count;

				private java.lang.String _start;

				private java.lang.String _target;

				public void set_count(java.lang.String _count) {
					this._count = _count;
				}

				public java.lang.String get_count() {
					return this._count;
				}

				public void set_start(java.lang.String _start) {
					this._start = _start;
				}

				public java.lang.String get_start() {
					return this._start;
				}

				public void set_target(java.lang.String _target) {
					this._target = _target;
				}

				public java.lang.String get_target() {
					return this._target;
				}
			}
		}

		public class Memtune {

			private Soft_limit soft_limit;

			private Min_guarantee min_guarantee;

			private Swap_hard_limit swap_hard_limit;

			private Hard_limit hard_limit;

			public void setSoft_limit(Soft_limit soft_limit) {
				this.soft_limit = soft_limit;
			}

			public Soft_limit getSoft_limit() {
				return this.soft_limit;
			}

			public void setMin_guarantee(Min_guarantee min_guarantee) {
				this.min_guarantee = min_guarantee;
			}

			public Min_guarantee getMin_guarantee() {
				return this.min_guarantee;
			}

			public void setSwap_hard_limit(Swap_hard_limit swap_hard_limit) {
				this.swap_hard_limit = swap_hard_limit;
			}

			public Swap_hard_limit getSwap_hard_limit() {
				return this.swap_hard_limit;
			}

			public void setHard_limit(Hard_limit hard_limit) {
				this.hard_limit = hard_limit;
			}

			public Hard_limit getHard_limit() {
				return this.hard_limit;
			}

			public class Soft_limit {

				private java.lang.String _unit;

				private java.lang.String text;

				public void set_unit(java.lang.String _unit) {
					this._unit = _unit;
				}

				public java.lang.String get_unit() {
					return this._unit;
				}

				public void setText(java.lang.String text) {
					this.text = text;
				}

				public java.lang.String getText() {
					return this.text;
				}
			}

			public class Min_guarantee {

				private java.lang.String _unit;

				private java.lang.String text;

				public void set_unit(java.lang.String _unit) {
					this._unit = _unit;
				}

				public java.lang.String get_unit() {
					return this._unit;
				}

				public void setText(java.lang.String text) {
					this.text = text;
				}

				public java.lang.String getText() {
					return this.text;
				}
			}

			public class Swap_hard_limit {

				private java.lang.String _unit;

				private java.lang.String text;

				public void set_unit(java.lang.String _unit) {
					this._unit = _unit;
				}

				public java.lang.String get_unit() {
					return this._unit;
				}

				public void setText(java.lang.String text) {
					this.text = text;
				}

				public java.lang.String getText() {
					return this.text;
				}
			}

			public class Hard_limit {

				private java.lang.String _unit;

				private java.lang.String text;

				public void set_unit(java.lang.String _unit) {
					this._unit = _unit;
				}

				public java.lang.String get_unit() {
					return this._unit;
				}

				public void setText(java.lang.String text) {
					this.text = text;
				}

				public java.lang.String getText() {
					return this.text;
				}
			}
		}

		public class Numatune {

			private Memory memory;

			private List<Memnode> memnode;

			public void setMemory(Memory memory) {
				this.memory = memory;
			}

			public Memory getMemory() {
				return this.memory;
			}

			public void setMemnode(List<Memnode> memnode) {
				this.memnode = memnode;
			}

			public List<Memnode> getMemnode() {
				return this.memnode;
			}

			public class Memory {

				private java.lang.String _nodeset;

				private java.lang.String _placement;

				private java.lang.String _mode;

				public void set_nodeset(java.lang.String _nodeset) {
					this._nodeset = _nodeset;
				}

				public java.lang.String get_nodeset() {
					return this._nodeset;
				}

				public void set_placement(java.lang.String _placement) {
					this._placement = _placement;
				}

				public java.lang.String get_placement() {
					return this._placement;
				}

				public void set_mode(java.lang.String _mode) {
					this._mode = _mode;
				}

				public java.lang.String get_mode() {
					return this._mode;
				}
			}

			public class Memnode {

				private java.lang.String _nodeset;

				private java.lang.String _cellid;

				private java.lang.String _mode;

				public void set_nodeset(java.lang.String _nodeset) {
					this._nodeset = _nodeset;
				}

				public java.lang.String get_nodeset() {
					return this._nodeset;
				}

				public void set_cellid(java.lang.String _cellid) {
					this._cellid = _cellid;
				}

				public java.lang.String get_cellid() {
					return this._cellid;
				}

				public void set_mode(java.lang.String _mode) {
					this._mode = _mode;
				}

				public java.lang.String get_mode() {
					return this._mode;
				}
			}
		}

		public class MemoryBacking {

			private Hugepages hugepages;

			private Allocation allocation;

			private Access access;

			private Source source;

			public void setHugepages(Hugepages hugepages) {
				this.hugepages = hugepages;
			}

			public Hugepages getHugepages() {
				return this.hugepages;
			}

			public void setAllocation(Allocation allocation) {
				this.allocation = allocation;
			}

			public Allocation getAllocation() {
				return this.allocation;
			}

			public void setAccess(Access access) {
				this.access = access;
			}

			public Access getAccess() {
				return this.access;
			}

			public void setSource(Source source) {
				this.source = source;
			}

			public Source getSource() {
				return this.source;
			}

			public class Hugepages {

				private List<Page> page;

				public void setPage(List<Page> page) {
					this.page = page;
				}

				public List<Page> getPage() {
					return this.page;
				}

				public class Page {

					private java.lang.String _size;

					private java.lang.String _unit;

					private java.lang.String _nodeset;

					public void set_size(java.lang.String _size) {
						this._size = _size;
					}

					public java.lang.String get_size() {
						return this._size;
					}

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void set_nodeset(java.lang.String _nodeset) {
						this._nodeset = _nodeset;
					}

					public java.lang.String get_nodeset() {
						return this._nodeset;
					}
				}
			}

			public class Allocation {

				private java.lang.String _mode;

				public void set_mode(java.lang.String _mode) {
					this._mode = _mode;
				}

				public java.lang.String get_mode() {
					return this._mode;
				}
			}

			public class Access {

				private java.lang.String _mode;

				public void set_mode(java.lang.String _mode) {
					this._mode = _mode;
				}

				public java.lang.String get_mode() {
					return this._mode;
				}
			}

			public class Source {

				private java.lang.String _type;

				public void set_type(java.lang.String _type) {
					this._type = _type;
				}

				public java.lang.String get_type() {
					return this._type;
				}
			}
		}

		public class Keywrap {

			private List<Cipher> cipher;

			public void setCipher(List<Cipher> cipher) {
				this.cipher = cipher;
			}

			public List<Cipher> getCipher() {
				return this.cipher;
			}

			public class Cipher {

				private java.lang.String _name;

				private java.lang.String _state;

				public void set_name(java.lang.String _name) {
					this._name = _name;
				}

				public java.lang.String get_name() {
					return this._name;
				}

				public void set_state(java.lang.String _state) {
					this._state = _state;
				}

				public java.lang.String get_state() {
					return this._state;
				}
			}
		}

		public class Perf {

			private List<Event> event;

			public void setEvent(List<Event> event) {
				this.event = event;
			}

			public List<Event> getEvent() {
				return this.event;
			}

			public class Event {

				private java.lang.String _name;

				private java.lang.String _enabled;

				public void set_name(java.lang.String _name) {
					this._name = _name;
				}

				public java.lang.String get_name() {
					return this._name;
				}

				public void set_enabled(java.lang.String _enabled) {
					this._enabled = _enabled;
				}

				public java.lang.String get_enabled() {
					return this._enabled;
				}
			}
		}

		public class Os {

			private java.lang.String init;

			private Bios bios;

			private java.lang.String loader;

			private java.lang.String kernel;

			private java.lang.String initarg;

			private Type type;

			private java.lang.String initrd;

			private Smbios smbios;

			private java.lang.String nvram;

			private java.lang.String cmdline;

			private java.lang.String dtb;

			private java.lang.String inituser;

			private Acpi acpi;

			private Bootmenu bootmenu;

			private java.lang.String initgroup;

			private List<Initenv> initenv;

			private java.lang.String initdir;

			private List<Boot> boot;

			public void setInit(java.lang.String init) {
				this.init = init;
			}

			public java.lang.String getInit() {
				return this.init;
			}

			public void setBios(Bios bios) {
				this.bios = bios;
			}

			public Bios getBios() {
				return this.bios;
			}

			public void setLoader(java.lang.String loader) {
				this.loader = loader;
			}

			public java.lang.String getLoader() {
				return this.loader;
			}

			public void setKernel(java.lang.String kernel) {
				this.kernel = kernel;
			}

			public java.lang.String getKernel() {
				return this.kernel;
			}

			public void setInitarg(java.lang.String initarg) {
				this.initarg = initarg;
			}

			public java.lang.String getInitarg() {
				return this.initarg;
			}

			public void setType(Type type) {
				this.type = type;
			}

			public Type getType() {
				return this.type;
			}

			public void setInitrd(java.lang.String initrd) {
				this.initrd = initrd;
			}

			public java.lang.String getInitrd() {
				return this.initrd;
			}

			public void setSmbios(Smbios smbios) {
				this.smbios = smbios;
			}

			public Smbios getSmbios() {
				return this.smbios;
			}

			public void setNvram(java.lang.String nvram) {
				this.nvram = nvram;
			}

			public java.lang.String getNvram() {
				return this.nvram;
			}

			public void setCmdline(java.lang.String cmdline) {
				this.cmdline = cmdline;
			}

			public java.lang.String getCmdline() {
				return this.cmdline;
			}

			public void setDtb(java.lang.String dtb) {
				this.dtb = dtb;
			}

			public java.lang.String getDtb() {
				return this.dtb;
			}

			public void setInituser(java.lang.String inituser) {
				this.inituser = inituser;
			}

			public java.lang.String getInituser() {
				return this.inituser;
			}

			public void setAcpi(Acpi acpi) {
				this.acpi = acpi;
			}

			public Acpi getAcpi() {
				return this.acpi;
			}

			public void setBootmenu(Bootmenu bootmenu) {
				this.bootmenu = bootmenu;
			}

			public Bootmenu getBootmenu() {
				return this.bootmenu;
			}

			public void setInitgroup(java.lang.String initgroup) {
				this.initgroup = initgroup;
			}

			public java.lang.String getInitgroup() {
				return this.initgroup;
			}

			public void setInitenv(List<Initenv> initenv) {
				this.initenv = initenv;
			}

			public List<Initenv> getInitenv() {
				return this.initenv;
			}

			public void setInitdir(java.lang.String initdir) {
				this.initdir = initdir;
			}

			public java.lang.String getInitdir() {
				return this.initdir;
			}

			public void setBoot(List<Boot> boot) {
				this.boot = boot;
			}

			public List<Boot> getBoot() {
				return this.boot;
			}

			public class Bios {

				private java.lang.String _rebootTimeout;

				private java.lang.String _useserial;

				public void set_rebootTimeout(java.lang.String _rebootTimeout) {
					this._rebootTimeout = _rebootTimeout;
				}

				public java.lang.String get_rebootTimeout() {
					return this._rebootTimeout;
				}

				public void set_useserial(java.lang.String _useserial) {
					this._useserial = _useserial;
				}

				public java.lang.String get_useserial() {
					return this._useserial;
				}
			}

			public class Type {

				private java.lang.String _machine;

				private java.lang.String text;

				private java.lang.String _arch;

				public void set_machine(java.lang.String _machine) {
					this._machine = _machine;
				}

				public java.lang.String get_machine() {
					return this._machine;
				}

				public void setText(java.lang.String text) {
					this.text = text;
				}

				public java.lang.String getText() {
					return this.text;
				}

				public void set_arch(java.lang.String _arch) {
					this._arch = _arch;
				}

				public java.lang.String get_arch() {
					return this._arch;
				}
			}

			public class Smbios {

				private java.lang.String _mode;

				public void set_mode(java.lang.String _mode) {
					this._mode = _mode;
				}

				public java.lang.String get_mode() {
					return this._mode;
				}
			}

			public class Acpi {

				private List<Table> table;

				public void setTable(List<Table> table) {
					this.table = table;
				}

				public List<Table> getTable() {
					return this.table;
				}

				public class Table {

					private java.lang.String _type;

					private java.lang.String text;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}
			}

			public class Bootmenu {

				private java.lang.String _enable;

				private java.lang.String _timeout;

				public void set_enable(java.lang.String _enable) {
					this._enable = _enable;
				}

				public java.lang.String get_enable() {
					return this._enable;
				}

				public void set_timeout(java.lang.String _timeout) {
					this._timeout = _timeout;
				}

				public java.lang.String get_timeout() {
					return this._timeout;
				}
			}

			public class Initenv {

				private java.lang.String _name;

				private java.lang.String text;

				public void set_name(java.lang.String _name) {
					this._name = _name;
				}

				public java.lang.String get_name() {
					return this._name;
				}

				public void setText(java.lang.String text) {
					this.text = text;
				}

				public java.lang.String getText() {
					return this.text;
				}
			}

			public class Boot {

				private java.lang.String _dev;

				public void set_dev(java.lang.String _dev) {
					this._dev = _dev;
				}

				public java.lang.String get_dev() {
					return this._dev;
				}
			}
		}

		public class Resource {

			private java.lang.String partition;

			public void setPartition(java.lang.String partition) {
				this.partition = partition;
			}

			public java.lang.String getPartition() {
				return this.partition;
			}
		}

		public class Devices {

			private List<Memory> memory;

			private List<Redirfilter> redirfilter;

			private List<Sound> sound;

			private List<Channel> channel;

			private Memballoon memballoon;

			private List<Video> video;

			private List<_interface> _interface;

			private Vsock vsock;

			private List<Hostdev> hostdev;

			private Nvram nvram;

			private Iommu iommu;

			private List<Parallel> parallel;

			private List<Console> console;

			private List<Controller> controller;

			private List<Shmem> shmem;

			private List<Redirdev> redirdev;

			private List<Rng> rng;

			private List<Smartcard> smartcard;

			private List<Filesystem> filesystem;

			private List<Panic> panic;

			private List<Tpm> tpm;

			private java.lang.String emulator;

			private List<Input> input;

			private List<Disk> disk;

			private Watchdog watchdog;

			private List<Hub> hub;

			private List<Serial> serial;

			private List<Lease> lease;

			public void setMemory(List<Memory> memory) {
				this.memory = memory;
			}

			public List<Memory> getMemory() {
				return this.memory;
			}

			public void setRedirfilter(List<Redirfilter> redirfilter) {
				this.redirfilter = redirfilter;
			}

			public List<Redirfilter> getRedirfilter() {
				return this.redirfilter;
			}

			public void setSound(List<Sound> sound) {
				this.sound = sound;
			}

			public List<Sound> getSound() {
				return this.sound;
			}

			public void setChannel(List<Channel> channel) {
				this.channel = channel;
			}

			public List<Channel> getChannel() {
				return this.channel;
			}

			public void setMemballoon(Memballoon memballoon) {
				this.memballoon = memballoon;
			}

			public Memballoon getMemballoon() {
				return this.memballoon;
			}

			public void setVideo(List<Video> video) {
				this.video = video;
			}

			public List<Video> getVideo() {
				return this.video;
			}

			public void set_interface(List<_interface> _interface) {
				this._interface = _interface;
			}

			public List<_interface> get_interface() {
				return this._interface;
			}

			public void setVsock(Vsock vsock) {
				this.vsock = vsock;
			}

			public Vsock getVsock() {
				return this.vsock;
			}

			public void setHostdev(List<Hostdev> hostdev) {
				this.hostdev = hostdev;
			}

			public List<Hostdev> getHostdev() {
				return this.hostdev;
			}

			public void setNvram(Nvram nvram) {
				this.nvram = nvram;
			}

			public Nvram getNvram() {
				return this.nvram;
			}

			public void setIommu(Iommu iommu) {
				this.iommu = iommu;
			}

			public Iommu getIommu() {
				return this.iommu;
			}

			public void setParallel(List<Parallel> parallel) {
				this.parallel = parallel;
			}

			public List<Parallel> getParallel() {
				return this.parallel;
			}

			public void setConsole(List<Console> console) {
				this.console = console;
			}

			public List<Console> getConsole() {
				return this.console;
			}

			public void setController(List<Controller> controller) {
				this.controller = controller;
			}

			public List<Controller> getController() {
				return this.controller;
			}

			public void setShmem(List<Shmem> shmem) {
				this.shmem = shmem;
			}

			public List<Shmem> getShmem() {
				return this.shmem;
			}

			public void setRedirdev(List<Redirdev> redirdev) {
				this.redirdev = redirdev;
			}

			public List<Redirdev> getRedirdev() {
				return this.redirdev;
			}

			public void setRng(List<Rng> rng) {
				this.rng = rng;
			}

			public List<Rng> getRng() {
				return this.rng;
			}

			public void setSmartcard(List<Smartcard> smartcard) {
				this.smartcard = smartcard;
			}

			public List<Smartcard> getSmartcard() {
				return this.smartcard;
			}

			public void setFilesystem(List<Filesystem> filesystem) {
				this.filesystem = filesystem;
			}

			public List<Filesystem> getFilesystem() {
				return this.filesystem;
			}

			public void setPanic(List<Panic> panic) {
				this.panic = panic;
			}

			public List<Panic> getPanic() {
				return this.panic;
			}

			public void setTpm(List<Tpm> tpm) {
				this.tpm = tpm;
			}

			public List<Tpm> getTpm() {
				return this.tpm;
			}

			public void setEmulator(java.lang.String emulator) {
				this.emulator = emulator;
			}

			public java.lang.String getEmulator() {
				return this.emulator;
			}

			public void setInput(List<Input> input) {
				this.input = input;
			}

			public List<Input> getInput() {
				return this.input;
			}

			public void setDisk(List<Disk> disk) {
				this.disk = disk;
			}

			public List<Disk> getDisk() {
				return this.disk;
			}

			public void setWatchdog(Watchdog watchdog) {
				this.watchdog = watchdog;
			}

			public Watchdog getWatchdog() {
				return this.watchdog;
			}

			public void setHub(List<Hub> hub) {
				this.hub = hub;
			}

			public List<Hub> getHub() {
				return this.hub;
			}

			public void setSerial(List<Serial> serial) {
				this.serial = serial;
			}

			public List<Serial> getSerial() {
				return this.serial;
			}

			public void setLease(List<Lease> lease) {
				this.lease = lease;
			}

			public List<Lease> getLease() {
				return this.lease;
			}

			public class Memory {

				private java.lang.String _discard;

				private java.lang.String _access;

				private Alias alias;

				private java.lang.String _model;

				private Source source;

				private Target target;

				public void set_discard(java.lang.String _discard) {
					this._discard = _discard;
				}

				public java.lang.String get_discard() {
					return this._discard;
				}

				public void set_access(java.lang.String _access) {
					this._access = _access;
				}

				public java.lang.String get_access() {
					return this._access;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Source {

					private java.lang.String path;

					private Alignsize alignsize;

					private java.lang.String nodemask;

					private Pagesize pagesize;

					public void setPath(java.lang.String path) {
						this.path = path;
					}

					public java.lang.String getPath() {
						return this.path;
					}

					public void setAlignsize(Alignsize alignsize) {
						this.alignsize = alignsize;
					}

					public Alignsize getAlignsize() {
						return this.alignsize;
					}

					public void setNodemask(java.lang.String nodemask) {
						this.nodemask = nodemask;
					}

					public java.lang.String getNodemask() {
						return this.nodemask;
					}

					public void setPagesize(Pagesize pagesize) {
						this.pagesize = pagesize;
					}

					public Pagesize getPagesize() {
						return this.pagesize;
					}

					public class Alignsize {

						private java.lang.String _unit;

						private java.lang.String text;

						public void set_unit(java.lang.String _unit) {
							this._unit = _unit;
						}

						public java.lang.String get_unit() {
							return this._unit;
						}

						public void setText(java.lang.String text) {
							this.text = text;
						}

						public java.lang.String getText() {
							return this.text;
						}
					}

					public class Pagesize {

						private java.lang.String _unit;

						private java.lang.String text;

						public void set_unit(java.lang.String _unit) {
							this._unit = _unit;
						}

						public java.lang.String get_unit() {
							return this._unit;
						}

						public void setText(java.lang.String text) {
							this.text = text;
						}

						public java.lang.String getText() {
							return this.text;
						}
					}
				}

				public class Target {

					private java.lang.String node;

					private Size size;

					private Label label;

					public void setNode(java.lang.String node) {
						this.node = node;
					}

					public java.lang.String getNode() {
						return this.node;
					}

					public void setSize(Size size) {
						this.size = size;
					}

					public Size getSize() {
						return this.size;
					}

					public void setLabel(Label label) {
						this.label = label;
					}

					public Label getLabel() {
						return this.label;
					}

					public class Size {

						private java.lang.String _unit;

						private java.lang.String text;

						public void set_unit(java.lang.String _unit) {
							this._unit = _unit;
						}

						public java.lang.String get_unit() {
							return this._unit;
						}

						public void setText(java.lang.String text) {
							this.text = text;
						}

						public java.lang.String getText() {
							return this.text;
						}
					}

					public class Label {

						private Size size;

						public void setSize(Size size) {
							this.size = size;
						}

						public Size getSize() {
							return this.size;
						}

						public class Size {

							private java.lang.String _unit;

							private java.lang.String text;

							public void set_unit(java.lang.String _unit) {
								this._unit = _unit;
							}

							public java.lang.String get_unit() {
								return this._unit;
							}

							public void setText(java.lang.String text) {
								this.text = text;
							}

							public java.lang.String getText() {
								return this.text;
							}
						}
					}
				}
			}

			public class Redirfilter {

				private List<Usbdev> usbdev;

				public void setUsbdev(List<Usbdev> usbdev) {
					this.usbdev = usbdev;
				}

				public List<Usbdev> getUsbdev() {
					return this.usbdev;
				}

				public class Usbdev {

					private java.lang.String _vendor;

					private java.lang.String _class;

					private java.lang.String _allow;

					private java.lang.String _product;

					private java.lang.String _version;

					public void set_vendor(java.lang.String _vendor) {
						this._vendor = _vendor;
					}

					public java.lang.String get_vendor() {
						return this._vendor;
					}

					public void set_class(java.lang.String _class) {
						this._class = _class;
					}

					public java.lang.String get_class() {
						return this._class;
					}

					public void set_allow(java.lang.String _allow) {
						this._allow = _allow;
					}

					public java.lang.String get_allow() {
						return this._allow;
					}

					public void set_product(java.lang.String _product) {
						this._product = _product;
					}

					public java.lang.String get_product() {
						return this._product;
					}

					public void set_version(java.lang.String _version) {
						this._version = _version;
					}

					public java.lang.String get_version() {
						return this._version;
					}
				}
			}

			public class Sound {

				private List<Codec> codec;

				private Alias alias;

				private java.lang.String _model;

				public void setCodec(List<Codec> codec) {
					this.codec = codec;
				}

				public List<Codec> getCodec() {
					return this.codec;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public class Codec {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Channel {

				private Protocol protocol;

				private Log log;

				private Alias alias;

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public class Protocol {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Log {

					private java.lang.String _file;

					private java.lang.String _append;

					public void set_file(java.lang.String _file) {
						this._file = _file;
					}

					public java.lang.String get_file() {
						return this._file;
					}

					public void set_append(java.lang.String _append) {
						this._append = _append;
					}

					public java.lang.String get_append() {
						return this._append;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Memballoon {

				private Driver driver;

				private Stats stats;

				private Alias alias;

				private java.lang.String _model;

				private java.lang.String _autodeflate;

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setStats(Stats stats) {
					this.stats = stats;
				}

				public Stats getStats() {
					return this.stats;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public void set_autodeflate(java.lang.String _autodeflate) {
					this._autodeflate = _autodeflate;
				}

				public java.lang.String get_autodeflate() {
					return this._autodeflate;
				}

				public class Driver {

					private java.lang.String _iommu;

					private java.lang.String _ats;

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}
				}

				public class Stats {

					private java.lang.String _period;

					public void set_period(java.lang.String _period) {
						this._period = _period;
					}

					public java.lang.String get_period() {
						return this._period;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Video {

				private Driver driver;

				private Alias alias;

				private Model model;

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setModel(Model model) {
					this.model = model;
				}

				public Model getModel() {
					return this.model;
				}

				public class Driver {

					private java.lang.String _vgaconf;

					private java.lang.String _iommu;

					private java.lang.String _ats;

					public void set_vgaconf(java.lang.String _vgaconf) {
						this._vgaconf = _vgaconf;
					}

					public java.lang.String get_vgaconf() {
						return this._vgaconf;
					}

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Model {

					private java.lang.String _heads;

					private java.lang.String _vgamem;

					private Acceleration acceleration;

					private java.lang.String _ram;

					private java.lang.String _vram;

					private java.lang.String _vram64;

					private java.lang.String _type;

					private java.lang.String _primary;

					public void set_heads(java.lang.String _heads) {
						this._heads = _heads;
					}

					public java.lang.String get_heads() {
						return this._heads;
					}

					public void set_vgamem(java.lang.String _vgamem) {
						this._vgamem = _vgamem;
					}

					public java.lang.String get_vgamem() {
						return this._vgamem;
					}

					public void setAcceleration(Acceleration acceleration) {
						this.acceleration = acceleration;
					}

					public Acceleration getAcceleration() {
						return this.acceleration;
					}

					public void set_ram(java.lang.String _ram) {
						this._ram = _ram;
					}

					public java.lang.String get_ram() {
						return this._ram;
					}

					public void set_vram(java.lang.String _vram) {
						this._vram = _vram;
					}

					public java.lang.String get_vram() {
						return this._vram;
					}

					public void set_vram64(java.lang.String _vram64) {
						this._vram64 = _vram64;
					}

					public java.lang.String get_vram64() {
						return this._vram64;
					}

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void set_primary(java.lang.String _primary) {
						this._primary = _primary;
					}

					public java.lang.String get_primary() {
						return this._primary;
					}

					public class Acceleration {

						private java.lang.String _accel3d;

						private java.lang.String _accel2d;

						public void set_accel3d(java.lang.String _accel3d) {
							this._accel3d = _accel3d;
						}

						public java.lang.String get_accel3d() {
							return this._accel3d;
						}

						public void set_accel2d(java.lang.String _accel2d) {
							this._accel2d = _accel2d;
						}

						public java.lang.String get_accel2d() {
							return this._accel2d;
						}
					}
				}
			}

			public class _interface {

				private Bandwidth bandwidth;

				private List<Ip> ip;

				private Link link;

				private Coalesce coalesce;

				private Filterref filterref;

				private Mac mac;

				private Script script;

				private Tune tune;

				private Target target;

				private Mtu mtu;

				private Rom rom;

				private List<Route> route;

				private Vlan vlan;

				private Driver driver;

				private java.lang.String _managed;

				private java.lang.String _trustGuestRxFilters;

				private Alias alias;

				private Guest guest;

				private Model model;

				private Backend backend;

				private Boot boot;

				private Virtualport virtualport;

				public void setBandwidth(Bandwidth bandwidth) {
					this.bandwidth = bandwidth;
				}

				public Bandwidth getBandwidth() {
					return this.bandwidth;
				}

				public void setIp(List<Ip> ip) {
					this.ip = ip;
				}

				public List<Ip> getIp() {
					return this.ip;
				}

				public void setLink(Link link) {
					this.link = link;
				}

				public Link getLink() {
					return this.link;
				}

				public void setCoalesce(Coalesce coalesce) {
					this.coalesce = coalesce;
				}

				public Coalesce getCoalesce() {
					return this.coalesce;
				}

				public void setFilterref(Filterref filterref) {
					this.filterref = filterref;
				}

				public Filterref getFilterref() {
					return this.filterref;
				}

				public void setMac(Mac mac) {
					this.mac = mac;
				}

				public Mac getMac() {
					return this.mac;
				}

				public void setScript(Script script) {
					this.script = script;
				}

				public Script getScript() {
					return this.script;
				}

				public void setTune(Tune tune) {
					this.tune = tune;
				}

				public Tune getTune() {
					return this.tune;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public void setMtu(Mtu mtu) {
					this.mtu = mtu;
				}

				public Mtu getMtu() {
					return this.mtu;
				}

				public void setRom(Rom rom) {
					this.rom = rom;
				}

				public Rom getRom() {
					return this.rom;
				}

				public void setRoute(List<Route> route) {
					this.route = route;
				}

				public List<Route> getRoute() {
					return this.route;
				}

				public void setVlan(Vlan vlan) {
					this.vlan = vlan;
				}

				public Vlan getVlan() {
					return this.vlan;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_managed(java.lang.String _managed) {
					this._managed = _managed;
				}

				public java.lang.String get_managed() {
					return this._managed;
				}

				public void set_trustGuestRxFilters(java.lang.String _trustGuestRxFilters) {
					this._trustGuestRxFilters = _trustGuestRxFilters;
				}

				public java.lang.String get_trustGuestRxFilters() {
					return this._trustGuestRxFilters;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setGuest(Guest guest) {
					this.guest = guest;
				}

				public Guest getGuest() {
					return this.guest;
				}

				public void setModel(Model model) {
					this.model = model;
				}

				public Model getModel() {
					return this.model;
				}

				public void setBackend(Backend backend) {
					this.backend = backend;
				}

				public Backend getBackend() {
					return this.backend;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public void setVirtualport(Virtualport virtualport) {
					this.virtualport = virtualport;
				}

				public Virtualport getVirtualport() {
					return this.virtualport;
				}

				public class Bandwidth {

					private Inbound inbound;

					private Outbound outbound;

					public void setInbound(Inbound inbound) {
						this.inbound = inbound;
					}

					public Inbound getInbound() {
						return this.inbound;
					}

					public void setOutbound(Outbound outbound) {
						this.outbound = outbound;
					}

					public Outbound getOutbound() {
						return this.outbound;
					}

					public class Inbound {

						private java.lang.String _peak;

						private java.lang.String _floor;

						private java.lang.String _average;

						private java.lang.String _burst;

						public void set_peak(java.lang.String _peak) {
							this._peak = _peak;
						}

						public java.lang.String get_peak() {
							return this._peak;
						}

						public void set_floor(java.lang.String _floor) {
							this._floor = _floor;
						}

						public java.lang.String get_floor() {
							return this._floor;
						}

						public void set_average(java.lang.String _average) {
							this._average = _average;
						}

						public java.lang.String get_average() {
							return this._average;
						}

						public void set_burst(java.lang.String _burst) {
							this._burst = _burst;
						}

						public java.lang.String get_burst() {
							return this._burst;
						}
					}

					public class Outbound {

						private java.lang.String _peak;

						private java.lang.String _floor;

						private java.lang.String _average;

						private java.lang.String _burst;

						public void set_peak(java.lang.String _peak) {
							this._peak = _peak;
						}

						public java.lang.String get_peak() {
							return this._peak;
						}

						public void set_floor(java.lang.String _floor) {
							this._floor = _floor;
						}

						public java.lang.String get_floor() {
							return this._floor;
						}

						public void set_average(java.lang.String _average) {
							this._average = _average;
						}

						public java.lang.String get_average() {
							return this._average;
						}

						public void set_burst(java.lang.String _burst) {
							this._burst = _burst;
						}

						public java.lang.String get_burst() {
							return this._burst;
						}
					}
				}

				public class Ip {

					private java.lang.String _address;

					private java.lang.String _prefix;

					private java.lang.String _family;

					private java.lang.String _peer;

					public void set_address(java.lang.String _address) {
						this._address = _address;
					}

					public java.lang.String get_address() {
						return this._address;
					}

					public void set_prefix(java.lang.String _prefix) {
						this._prefix = _prefix;
					}

					public java.lang.String get_prefix() {
						return this._prefix;
					}

					public void set_family(java.lang.String _family) {
						this._family = _family;
					}

					public java.lang.String get_family() {
						return this._family;
					}

					public void set_peer(java.lang.String _peer) {
						this._peer = _peer;
					}

					public java.lang.String get_peer() {
						return this._peer;
					}
				}

				public class Link {

					private java.lang.String _state;

					public void set_state(java.lang.String _state) {
						this._state = _state;
					}

					public java.lang.String get_state() {
						return this._state;
					}
				}

				public class Coalesce {

					private Rx rx;

					public void setRx(Rx rx) {
						this.rx = rx;
					}

					public Rx getRx() {
						return this.rx;
					}

					public class Rx {

						private Frames frames;

						public void setFrames(Frames frames) {
							this.frames = frames;
						}

						public Frames getFrames() {
							return this.frames;
						}

						public class Frames {

							private java.lang.String _max;

							public void set_max(java.lang.String _max) {
								this._max = _max;
							}

							public java.lang.String get_max() {
								return this._max;
							}
						}
					}
				}

				public class Filterref {

					private List<Parameter> parameter;

					private java.lang.String _filter;

					public void setParameter(List<Parameter> parameter) {
						this.parameter = parameter;
					}

					public List<Parameter> getParameter() {
						return this.parameter;
					}

					public void set_filter(java.lang.String _filter) {
						this._filter = _filter;
					}

					public java.lang.String get_filter() {
						return this._filter;
					}

					public class Parameter {

						private java.lang.String _name;

						private java.lang.String _string;

						public void set_name(java.lang.String _name) {
							this._name = _name;
						}

						public java.lang.String get_name() {
							return this._name;
						}

						public void set_string(java.lang.String _string) {
							this._string = _string;
						}

						public java.lang.String get_string() {
							return this._string;
						}
					}
				}

				public class Mac {

					private java.lang.String _address;

					public void set_address(java.lang.String _address) {
						this._address = _address;
					}

					public java.lang.String get_address() {
						return this._address;
					}
				}

				public class Script {

					private java.lang.String _path;

					public void set_path(java.lang.String _path) {
						this._path = _path;
					}

					public java.lang.String get_path() {
						return this._path;
					}
				}

				public class Tune {

					private java.lang.String sndbuf;

					public void setSndbuf(java.lang.String sndbuf) {
						this.sndbuf = sndbuf;
					}

					public java.lang.String getSndbuf() {
						return this.sndbuf;
					}
				}

				public class Target {

					private java.lang.String _dev;

					public void set_dev(java.lang.String _dev) {
						this._dev = _dev;
					}

					public java.lang.String get_dev() {
						return this._dev;
					}
				}

				public class Mtu {

					private java.lang.String _size;

					public void set_size(java.lang.String _size) {
						this._size = _size;
					}

					public java.lang.String get_size() {
						return this._size;
					}
				}

				public class Rom {

					private java.lang.String _file;

					private java.lang.String _bar;

					private java.lang.String _enabled;

					public void set_file(java.lang.String _file) {
						this._file = _file;
					}

					public java.lang.String get_file() {
						return this._file;
					}

					public void set_bar(java.lang.String _bar) {
						this._bar = _bar;
					}

					public java.lang.String get_bar() {
						return this._bar;
					}

					public void set_enabled(java.lang.String _enabled) {
						this._enabled = _enabled;
					}

					public java.lang.String get_enabled() {
						return this._enabled;
					}
				}

				public class Route {

					private java.lang.String _address;

					private java.lang.String _prefix;

					private java.lang.String _netmask;

					private java.lang.String _metric;

					private java.lang.String _family;

					private java.lang.String _gateway;

					public void set_address(java.lang.String _address) {
						this._address = _address;
					}

					public java.lang.String get_address() {
						return this._address;
					}

					public void set_prefix(java.lang.String _prefix) {
						this._prefix = _prefix;
					}

					public java.lang.String get_prefix() {
						return this._prefix;
					}

					public void set_netmask(java.lang.String _netmask) {
						this._netmask = _netmask;
					}

					public java.lang.String get_netmask() {
						return this._netmask;
					}

					public void set_metric(java.lang.String _metric) {
						this._metric = _metric;
					}

					public java.lang.String get_metric() {
						return this._metric;
					}

					public void set_family(java.lang.String _family) {
						this._family = _family;
					}

					public java.lang.String get_family() {
						return this._family;
					}

					public void set_gateway(java.lang.String _gateway) {
						this._gateway = _gateway;
					}

					public java.lang.String get_gateway() {
						return this._gateway;
					}
				}

				public class Vlan {

					private java.lang.String _trunk;

					private List<Tag> tag;

					public void set_trunk(java.lang.String _trunk) {
						this._trunk = _trunk;
					}

					public java.lang.String get_trunk() {
						return this._trunk;
					}

					public void setTag(List<Tag> tag) {
						this.tag = tag;
					}

					public List<Tag> getTag() {
						return this.tag;
					}

					public class Tag {

						private java.lang.String _nativeMode;

						private java.lang.String _id;

						public void set_nativeMode(java.lang.String _nativeMode) {
							this._nativeMode = _nativeMode;
						}

						public java.lang.String get_nativeMode() {
							return this._nativeMode;
						}

						public void set_id(java.lang.String _id) {
							this._id = _id;
						}

						public java.lang.String get_id() {
							return this._id;
						}
					}
				}

				public class Driver {

					private java.lang.String _name;

					private java.lang.String _queues;

					private java.lang.String _txmode;

					private java.lang.String _tx_queue_size;

					private java.lang.String _iommu;

					private Host host;

					private java.lang.String _ioeventfd;

					private Guest guest;

					private java.lang.String _event_idx;

					private java.lang.String _ats;

					private java.lang.String _rx_queue_size;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void set_queues(java.lang.String _queues) {
						this._queues = _queues;
					}

					public java.lang.String get_queues() {
						return this._queues;
					}

					public void set_txmode(java.lang.String _txmode) {
						this._txmode = _txmode;
					}

					public java.lang.String get_txmode() {
						return this._txmode;
					}

					public void set_tx_queue_size(java.lang.String _tx_queue_size) {
						this._tx_queue_size = _tx_queue_size;
					}

					public java.lang.String get_tx_queue_size() {
						return this._tx_queue_size;
					}

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void setHost(Host host) {
						this.host = host;
					}

					public Host getHost() {
						return this.host;
					}

					public void set_ioeventfd(java.lang.String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public java.lang.String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void setGuest(Guest guest) {
						this.guest = guest;
					}

					public Guest getGuest() {
						return this.guest;
					}

					public void set_event_idx(java.lang.String _event_idx) {
						this._event_idx = _event_idx;
					}

					public java.lang.String get_event_idx() {
						return this._event_idx;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}

					public void set_rx_queue_size(java.lang.String _rx_queue_size) {
						this._rx_queue_size = _rx_queue_size;
					}

					public java.lang.String get_rx_queue_size() {
						return this._rx_queue_size;
					}

					public class Host {

						private java.lang.String _tso4;

						private java.lang.String _ufo;

						private java.lang.String _tso6;

						private java.lang.String _mrg_rxbuf;

						private java.lang.String _gso;

						private java.lang.String _ecn;

						private java.lang.String _csum;

						public void set_tso4(java.lang.String _tso4) {
							this._tso4 = _tso4;
						}

						public java.lang.String get_tso4() {
							return this._tso4;
						}

						public void set_ufo(java.lang.String _ufo) {
							this._ufo = _ufo;
						}

						public java.lang.String get_ufo() {
							return this._ufo;
						}

						public void set_tso6(java.lang.String _tso6) {
							this._tso6 = _tso6;
						}

						public java.lang.String get_tso6() {
							return this._tso6;
						}

						public void set_mrg_rxbuf(java.lang.String _mrg_rxbuf) {
							this._mrg_rxbuf = _mrg_rxbuf;
						}

						public java.lang.String get_mrg_rxbuf() {
							return this._mrg_rxbuf;
						}

						public void set_gso(java.lang.String _gso) {
							this._gso = _gso;
						}

						public java.lang.String get_gso() {
							return this._gso;
						}

						public void set_ecn(java.lang.String _ecn) {
							this._ecn = _ecn;
						}

						public java.lang.String get_ecn() {
							return this._ecn;
						}

						public void set_csum(java.lang.String _csum) {
							this._csum = _csum;
						}

						public java.lang.String get_csum() {
							return this._csum;
						}
					}

					public class Guest {

						private java.lang.String _tso4;

						private java.lang.String _ufo;

						private java.lang.String _tso6;

						private java.lang.String _ecn;

						private java.lang.String _csum;

						public void set_tso4(java.lang.String _tso4) {
							this._tso4 = _tso4;
						}

						public java.lang.String get_tso4() {
							return this._tso4;
						}

						public void set_ufo(java.lang.String _ufo) {
							this._ufo = _ufo;
						}

						public java.lang.String get_ufo() {
							return this._ufo;
						}

						public void set_tso6(java.lang.String _tso6) {
							this._tso6 = _tso6;
						}

						public java.lang.String get_tso6() {
							return this._tso6;
						}

						public void set_ecn(java.lang.String _ecn) {
							this._ecn = _ecn;
						}

						public java.lang.String get_ecn() {
							return this._ecn;
						}

						public void set_csum(java.lang.String _csum) {
							this._csum = _csum;
						}

						public java.lang.String get_csum() {
							return this._csum;
						}
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Guest {

					private java.lang.String _actual;

					private java.lang.String _dev;

					public void set_actual(java.lang.String _actual) {
						this._actual = _actual;
					}

					public java.lang.String get_actual() {
						return this._actual;
					}

					public void set_dev(java.lang.String _dev) {
						this._dev = _dev;
					}

					public java.lang.String get_dev() {
						return this._dev;
					}
				}

				public class Model {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Backend {

					private java.lang.String _vhost;

					private java.lang.String _tap;

					public void set_vhost(java.lang.String _vhost) {
						this._vhost = _vhost;
					}

					public java.lang.String get_vhost() {
						return this._vhost;
					}

					public void set_tap(java.lang.String _tap) {
						this._tap = _tap;
					}

					public java.lang.String get_tap() {
						return this._tap;
					}
				}

				public class Boot {

					private java.lang.String _order;

					private java.lang.String _loadparm;

					public void set_order(java.lang.String _order) {
						this._order = _order;
					}

					public java.lang.String get_order() {
						return this._order;
					}

					public void set_loadparm(java.lang.String _loadparm) {
						this._loadparm = _loadparm;
					}

					public java.lang.String get_loadparm() {
						return this._loadparm;
					}
				}

				public class Virtualport {
				}
			}

			public class Vsock {

				private Alias alias;

				private java.lang.String _model;

				private Cid cid;

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public void setCid(Cid cid) {
					this.cid = cid;
				}

				public Cid getCid() {
					return this.cid;
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Cid {

					private java.lang.String _address;

					private java.lang.String _auto;

					public void set_address(java.lang.String _address) {
						this._address = _address;
					}

					public java.lang.String get_address() {
						return this._address;
					}

					public void set_auto(java.lang.String _auto) {
						this._auto = _auto;
					}

					public java.lang.String get_auto() {
						return this._auto;
					}
				}
			}

			public class Hostdev {

				private Rom rom;

				private java.lang.String _managed;

				private Alias alias;

				private Boot boot;

				public void setRom(Rom rom) {
					this.rom = rom;
				}

				public Rom getRom() {
					return this.rom;
				}

				public void set_managed(java.lang.String _managed) {
					this._managed = _managed;
				}

				public java.lang.String get_managed() {
					return this._managed;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public class Rom {

					private java.lang.String _file;

					private java.lang.String _bar;

					private java.lang.String _enabled;

					public void set_file(java.lang.String _file) {
						this._file = _file;
					}

					public java.lang.String get_file() {
						return this._file;
					}

					public void set_bar(java.lang.String _bar) {
						this._bar = _bar;
					}

					public java.lang.String get_bar() {
						return this._bar;
					}

					public void set_enabled(java.lang.String _enabled) {
						this._enabled = _enabled;
					}

					public java.lang.String get_enabled() {
						return this._enabled;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Boot {

					private java.lang.String _order;

					private java.lang.String _loadparm;

					public void set_order(java.lang.String _order) {
						this._order = _order;
					}

					public java.lang.String get_order() {
						return this._order;
					}

					public void set_loadparm(java.lang.String _loadparm) {
						this._loadparm = _loadparm;
					}

					public java.lang.String get_loadparm() {
						return this._loadparm;
					}
				}
			}

			public class Nvram {

				private Alias alias;

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Iommu {

				private Driver driver;

				private java.lang.String _model;

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public class Driver {

					private java.lang.String _caching_mode;

					private java.lang.String _eim;

					private java.lang.String _iotlb;

					private java.lang.String _intremap;

					public void set_caching_mode(java.lang.String _caching_mode) {
						this._caching_mode = _caching_mode;
					}

					public java.lang.String get_caching_mode() {
						return this._caching_mode;
					}

					public void set_eim(java.lang.String _eim) {
						this._eim = _eim;
					}

					public java.lang.String get_eim() {
						return this._eim;
					}

					public void set_iotlb(java.lang.String _iotlb) {
						this._iotlb = _iotlb;
					}

					public java.lang.String get_iotlb() {
						return this._iotlb;
					}

					public void set_intremap(java.lang.String _intremap) {
						this._intremap = _intremap;
					}

					public java.lang.String get_intremap() {
						return this._intremap;
					}
				}
			}

			public class Parallel {

				private Protocol protocol;

				private Log log;

				private Alias alias;

				private Target target;

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public class Protocol {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Log {

					private java.lang.String _file;

					private java.lang.String _append;

					public void set_file(java.lang.String _file) {
						this._file = _file;
					}

					public java.lang.String get_file() {
						return this._file;
					}

					public void set_append(java.lang.String _append) {
						this._append = _append;
					}

					public java.lang.String get_append() {
						return this._append;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Target {

					private java.lang.String _type;

					private java.lang.String _port;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void set_port(java.lang.String _port) {
						this._port = _port;
					}

					public java.lang.String get_port() {
						return this._port;
					}
				}
			}

			public class Console {

				private Protocol protocol;

				private Log log;

				private java.lang.String _tty;

				private Alias alias;

				private Target target;

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void set_tty(java.lang.String _tty) {
					this._tty = _tty;
				}

				public java.lang.String get_tty() {
					return this._tty;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public class Protocol {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Log {

					private java.lang.String _file;

					private java.lang.String _append;

					public void set_file(java.lang.String _file) {
						this._file = _file;
					}

					public java.lang.String get_file() {
						return this._file;
					}

					public void set_append(java.lang.String _append) {
						this._append = _append;
					}

					public java.lang.String get_append() {
						return this._append;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Target {

					private java.lang.String _type;

					private java.lang.String _port;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void set_port(java.lang.String _port) {
						this._port = _port;
					}

					public java.lang.String get_port() {
						return this._port;
					}
				}
			}

			public class Controller {

				private java.lang.String _index;

				private Driver driver;

				private java.lang.String _type;

				private Alias alias;

				private java.lang.String _model;

				public void set_index(java.lang.String _index) {
					this._index = _index;
				}

				public java.lang.String get_index() {
					return this._index;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_type(java.lang.String _type) {
					this._type = _type;
				}

				public java.lang.String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public class Driver {

					private java.lang.String _max_sectors;

					private java.lang.String _queues;

					private java.lang.String _iommu;

					private java.lang.String _ioeventfd;

					private java.lang.String _iothread;

					private java.lang.String _cmd_per_lun;

					private java.lang.String _ats;

					public void set_max_sectors(java.lang.String _max_sectors) {
						this._max_sectors = _max_sectors;
					}

					public java.lang.String get_max_sectors() {
						return this._max_sectors;
					}

					public void set_queues(java.lang.String _queues) {
						this._queues = _queues;
					}

					public java.lang.String get_queues() {
						return this._queues;
					}

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void set_ioeventfd(java.lang.String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public java.lang.String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void set_iothread(java.lang.String _iothread) {
						this._iothread = _iothread;
					}

					public java.lang.String get_iothread() {
						return this._iothread;
					}

					public void set_cmd_per_lun(java.lang.String _cmd_per_lun) {
						this._cmd_per_lun = _cmd_per_lun;
					}

					public java.lang.String get_cmd_per_lun() {
						return this._cmd_per_lun;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Shmem {

				private Server server;

				private Msi msi;

				private java.lang.String _name;

				private Size size;

				private Alias alias;

				private Model model;

				public void setServer(Server server) {
					this.server = server;
				}

				public Server getServer() {
					return this.server;
				}

				public void setMsi(Msi msi) {
					this.msi = msi;
				}

				public Msi getMsi() {
					return this.msi;
				}

				public void set_name(java.lang.String _name) {
					this._name = _name;
				}

				public java.lang.String get_name() {
					return this._name;
				}

				public void setSize(Size size) {
					this.size = size;
				}

				public Size getSize() {
					return this.size;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setModel(Model model) {
					this.model = model;
				}

				public Model getModel() {
					return this.model;
				}

				public class Server {

					private java.lang.String _path;

					public void set_path(java.lang.String _path) {
						this._path = _path;
					}

					public java.lang.String get_path() {
						return this._path;
					}
				}

				public class Msi {

					private java.lang.String _vectors;

					private java.lang.String _ioeventfd;

					private java.lang.String _enabled;

					public void set_vectors(java.lang.String _vectors) {
						this._vectors = _vectors;
					}

					public java.lang.String get_vectors() {
						return this._vectors;
					}

					public void set_ioeventfd(java.lang.String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public java.lang.String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void set_enabled(java.lang.String _enabled) {
						this._enabled = _enabled;
					}

					public java.lang.String get_enabled() {
						return this._enabled;
					}
				}

				public class Size {

					private java.lang.String _unit;

					private java.lang.String text;

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Model {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}
			}

			public class Redirdev {

				private Protocol protocol;

				private Alias alias;

				private Boot boot;

				private java.lang.String _bus;

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public void set_bus(java.lang.String _bus) {
					this._bus = _bus;
				}

				public java.lang.String get_bus() {
					return this._bus;
				}

				public class Protocol {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Boot {

					private java.lang.String _order;

					private java.lang.String _loadparm;

					public void set_order(java.lang.String _order) {
						this._order = _order;
					}

					public java.lang.String get_order() {
						return this._order;
					}

					public void set_loadparm(java.lang.String _loadparm) {
						this._loadparm = _loadparm;
					}

					public java.lang.String get_loadparm() {
						return this._loadparm;
					}
				}
			}

			public class Rng {

				private Driver driver;

				private Rate rate;

				private Alias alias;

				private java.lang.String _model;

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setRate(Rate rate) {
					this.rate = rate;
				}

				public Rate getRate() {
					return this.rate;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public class Driver {

					private java.lang.String _iommu;

					private java.lang.String _ats;

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}
				}

				public class Rate {

					private java.lang.String _period;

					private java.lang.String _bytes;

					public void set_period(java.lang.String _period) {
						this._period = _period;
					}

					public java.lang.String get_period() {
						return this._period;
					}

					public void set_bytes(java.lang.String _bytes) {
						this._bytes = _bytes;
					}

					public java.lang.String get_bytes() {
						return this._bytes;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Smartcard {

				private Protocol protocol;

				private java.lang.String database;

				private List<String> certificate;

				private Alias alias;

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setDatabase(java.lang.String database) {
					this.database = database;
				}

				public java.lang.String getDatabase() {
					return this.database;
				}

				public void setCertificate(List<String> certificate) {
					this.certificate = certificate;
				}

				public List<String> getCertificate() {
					return this.certificate;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public class Protocol {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Filesystem {

				private java.lang.String _accessmode;

				private Driver driver;

				private Space_hard_limit space_hard_limit;

				private Alias alias;

				private java.lang.String _model;

				private Space_soft_limit space_soft_limit;

				private Target target;

				public void set_accessmode(java.lang.String _accessmode) {
					this._accessmode = _accessmode;
				}

				public java.lang.String get_accessmode() {
					return this._accessmode;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setSpace_hard_limit(Space_hard_limit space_hard_limit) {
					this.space_hard_limit = space_hard_limit;
				}

				public Space_hard_limit getSpace_hard_limit() {
					return this.space_hard_limit;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public void setSpace_soft_limit(Space_soft_limit space_soft_limit) {
					this.space_soft_limit = space_soft_limit;
				}

				public Space_soft_limit getSpace_soft_limit() {
					return this.space_soft_limit;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public class Driver {

					private java.lang.String _name;

					private java.lang.String _type;

					private java.lang.String _iommu;

					private java.lang.String _format;

					private java.lang.String _wrpolicy;

					private java.lang.String _ats;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void set_format(java.lang.String _format) {
						this._format = _format;
					}

					public java.lang.String get_format() {
						return this._format;
					}

					public void set_wrpolicy(java.lang.String _wrpolicy) {
						this._wrpolicy = _wrpolicy;
					}

					public java.lang.String get_wrpolicy() {
						return this._wrpolicy;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}
				}

				public class Space_hard_limit {

					private java.lang.String _unit;

					private java.lang.String text;

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Space_soft_limit {

					private java.lang.String _unit;

					private java.lang.String text;

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void setText(java.lang.String text) {
						this.text = text;
					}

					public java.lang.String getText() {
						return this.text;
					}
				}

				public class Target {

					private java.lang.String _dir;

					public void set_dir(java.lang.String _dir) {
						this._dir = _dir;
					}

					public java.lang.String get_dir() {
						return this._dir;
					}
				}
			}

			public class Panic {

				private Alias alias;

				private java.lang.String _model;

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Tpm {

				private Alias alias;

				private java.lang.String _model;

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Input {

				private Driver driver;

				private java.lang.String _type;

				private Alias alias;

				private java.lang.String _model;

				private Source source;

				private java.lang.String _bus;

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_type(java.lang.String _type) {
					this._type = _type;
				}

				public java.lang.String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void set_bus(java.lang.String _bus) {
					this._bus = _bus;
				}

				public java.lang.String get_bus() {
					return this._bus;
				}

				public class Driver {

					private java.lang.String _iommu;

					private java.lang.String _ats;

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Source {

					private java.lang.String _evdev;

					public void set_evdev(java.lang.String _evdev) {
						this._evdev = _evdev;
					}

					public java.lang.String get_evdev() {
						return this._evdev;
					}
				}
			}

			public class Disk {

				private Iotune iotune;

				private Mirror mirror;

				private java.lang.String product;

				private java.lang.String _snapshot;

				private Auth auth;

				private java.lang.String _sgio;

				private Source source;

				private Blockio blockio;

				private java.lang.String _device;

				private Target target;

				private java.lang.String wwn;

				private Driver driver;

				private Encryption encryption;

				private java.lang.String serial;

				private java.lang.String vendor;

				private BackingStore backingStore;

				private Alias alias;

				private java.lang.String _model;

				private Geometry geometry;

				private Boot boot;

				private java.lang.String _rawio;

				public void setIotune(Iotune iotune) {
					this.iotune = iotune;
				}

				public Iotune getIotune() {
					return this.iotune;
				}

				public void setMirror(Mirror mirror) {
					this.mirror = mirror;
				}

				public Mirror getMirror() {
					return this.mirror;
				}

				public void setProduct(java.lang.String product) {
					this.product = product;
				}

				public java.lang.String getProduct() {
					return this.product;
				}

				public void set_snapshot(java.lang.String _snapshot) {
					this._snapshot = _snapshot;
				}

				public java.lang.String get_snapshot() {
					return this._snapshot;
				}

				public void setAuth(Auth auth) {
					this.auth = auth;
				}

				public Auth getAuth() {
					return this.auth;
				}

				public void set_sgio(java.lang.String _sgio) {
					this._sgio = _sgio;
				}

				public java.lang.String get_sgio() {
					return this._sgio;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setBlockio(Blockio blockio) {
					this.blockio = blockio;
				}

				public Blockio getBlockio() {
					return this.blockio;
				}

				public void set_device(java.lang.String _device) {
					this._device = _device;
				}

				public java.lang.String get_device() {
					return this._device;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public void setWwn(java.lang.String wwn) {
					this.wwn = wwn;
				}

				public java.lang.String getWwn() {
					return this.wwn;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setEncryption(Encryption encryption) {
					this.encryption = encryption;
				}

				public Encryption getEncryption() {
					return this.encryption;
				}

				public void setSerial(java.lang.String serial) {
					this.serial = serial;
				}

				public java.lang.String getSerial() {
					return this.serial;
				}

				public void setVendor(java.lang.String vendor) {
					this.vendor = vendor;
				}

				public java.lang.String getVendor() {
					return this.vendor;
				}

				public void setBackingStore(BackingStore backingStore) {
					this.backingStore = backingStore;
				}

				public BackingStore getBackingStore() {
					return this.backingStore;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public void setGeometry(Geometry geometry) {
					this.geometry = geometry;
				}

				public Geometry getGeometry() {
					return this.geometry;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public void set_rawio(java.lang.String _rawio) {
					this._rawio = _rawio;
				}

				public java.lang.String get_rawio() {
					return this._rawio;
				}

				public class Iotune {

					private java.lang.String write_iops_sec_max_length;

					private java.lang.String group_name;

					private java.lang.String write_iops_sec;

					private java.lang.String read_bytes_sec_max;

					private java.lang.String total_iops_sec;

					private java.lang.String write_iops_sec_max;

					private java.lang.String read_bytes_sec_max_length;

					private java.lang.String total_bytes_sec;

					private java.lang.String total_iops_sec_max;

					private java.lang.String total_bytes_sec_max_length;

					private java.lang.String write_bytes_sec;

					private java.lang.String total_bytes_sec_max;

					private java.lang.String write_bytes_sec_max;

					private java.lang.String read_iops_sec_max;

					private java.lang.String read_iops_sec_max_length;

					private java.lang.String size_iops_sec;

					private java.lang.String read_bytes_sec;

					private java.lang.String read_iops_sec;

					private java.lang.String write_bytes_sec_max_length;

					private java.lang.String total_iops_sec_max_length;

					public void setWrite_iops_sec_max_length(java.lang.String write_iops_sec_max_length) {
						this.write_iops_sec_max_length = write_iops_sec_max_length;
					}

					public java.lang.String getWrite_iops_sec_max_length() {
						return this.write_iops_sec_max_length;
					}

					public void setGroup_name(java.lang.String group_name) {
						this.group_name = group_name;
					}

					public java.lang.String getGroup_name() {
						return this.group_name;
					}

					public void setWrite_iops_sec(java.lang.String write_iops_sec) {
						this.write_iops_sec = write_iops_sec;
					}

					public java.lang.String getWrite_iops_sec() {
						return this.write_iops_sec;
					}

					public void setRead_bytes_sec_max(java.lang.String read_bytes_sec_max) {
						this.read_bytes_sec_max = read_bytes_sec_max;
					}

					public java.lang.String getRead_bytes_sec_max() {
						return this.read_bytes_sec_max;
					}

					public void setTotal_iops_sec(java.lang.String total_iops_sec) {
						this.total_iops_sec = total_iops_sec;
					}

					public java.lang.String getTotal_iops_sec() {
						return this.total_iops_sec;
					}

					public void setWrite_iops_sec_max(java.lang.String write_iops_sec_max) {
						this.write_iops_sec_max = write_iops_sec_max;
					}

					public java.lang.String getWrite_iops_sec_max() {
						return this.write_iops_sec_max;
					}

					public void setRead_bytes_sec_max_length(java.lang.String read_bytes_sec_max_length) {
						this.read_bytes_sec_max_length = read_bytes_sec_max_length;
					}

					public java.lang.String getRead_bytes_sec_max_length() {
						return this.read_bytes_sec_max_length;
					}

					public void setTotal_bytes_sec(java.lang.String total_bytes_sec) {
						this.total_bytes_sec = total_bytes_sec;
					}

					public java.lang.String getTotal_bytes_sec() {
						return this.total_bytes_sec;
					}

					public void setTotal_iops_sec_max(java.lang.String total_iops_sec_max) {
						this.total_iops_sec_max = total_iops_sec_max;
					}

					public java.lang.String getTotal_iops_sec_max() {
						return this.total_iops_sec_max;
					}

					public void setTotal_bytes_sec_max_length(java.lang.String total_bytes_sec_max_length) {
						this.total_bytes_sec_max_length = total_bytes_sec_max_length;
					}

					public java.lang.String getTotal_bytes_sec_max_length() {
						return this.total_bytes_sec_max_length;
					}

					public void setWrite_bytes_sec(java.lang.String write_bytes_sec) {
						this.write_bytes_sec = write_bytes_sec;
					}

					public java.lang.String getWrite_bytes_sec() {
						return this.write_bytes_sec;
					}

					public void setTotal_bytes_sec_max(java.lang.String total_bytes_sec_max) {
						this.total_bytes_sec_max = total_bytes_sec_max;
					}

					public java.lang.String getTotal_bytes_sec_max() {
						return this.total_bytes_sec_max;
					}

					public void setWrite_bytes_sec_max(java.lang.String write_bytes_sec_max) {
						this.write_bytes_sec_max = write_bytes_sec_max;
					}

					public java.lang.String getWrite_bytes_sec_max() {
						return this.write_bytes_sec_max;
					}

					public void setRead_iops_sec_max(java.lang.String read_iops_sec_max) {
						this.read_iops_sec_max = read_iops_sec_max;
					}

					public java.lang.String getRead_iops_sec_max() {
						return this.read_iops_sec_max;
					}

					public void setRead_iops_sec_max_length(java.lang.String read_iops_sec_max_length) {
						this.read_iops_sec_max_length = read_iops_sec_max_length;
					}

					public java.lang.String getRead_iops_sec_max_length() {
						return this.read_iops_sec_max_length;
					}

					public void setSize_iops_sec(java.lang.String size_iops_sec) {
						this.size_iops_sec = size_iops_sec;
					}

					public java.lang.String getSize_iops_sec() {
						return this.size_iops_sec;
					}

					public void setRead_bytes_sec(java.lang.String read_bytes_sec) {
						this.read_bytes_sec = read_bytes_sec;
					}

					public java.lang.String getRead_bytes_sec() {
						return this.read_bytes_sec;
					}

					public void setRead_iops_sec(java.lang.String read_iops_sec) {
						this.read_iops_sec = read_iops_sec;
					}

					public java.lang.String getRead_iops_sec() {
						return this.read_iops_sec;
					}

					public void setWrite_bytes_sec_max_length(java.lang.String write_bytes_sec_max_length) {
						this.write_bytes_sec_max_length = write_bytes_sec_max_length;
					}

					public java.lang.String getWrite_bytes_sec_max_length() {
						return this.write_bytes_sec_max_length;
					}

					public void setTotal_iops_sec_max_length(java.lang.String total_iops_sec_max_length) {
						this.total_iops_sec_max_length = total_iops_sec_max_length;
					}

					public java.lang.String getTotal_iops_sec_max_length() {
						return this.total_iops_sec_max_length;
					}
				}

				public class Mirror {

					private java.lang.String _job;

					private java.lang.String _ready;

					private Format format;

					private Source source;

					public void set_job(java.lang.String _job) {
						this._job = _job;
					}

					public java.lang.String get_job() {
						return this._job;
					}

					public void set_ready(java.lang.String _ready) {
						this._ready = _ready;
					}

					public java.lang.String get_ready() {
						return this._ready;
					}

					public void setFormat(Format format) {
						this.format = format;
					}

					public Format getFormat() {
						return this.format;
					}

					public void setSource(Source source) {
						this.source = source;
					}

					public Source getSource() {
						return this.source;
					}

					public class Format {

						private java.lang.String _type;

						public void set_type(java.lang.String _type) {
							this._type = _type;
						}

						public java.lang.String get_type() {
							return this._type;
						}
					}

					public class Source {

						private java.lang.String _index;

						private Encryption encryption;

						private Reservations reservations;

						private java.lang.String _startupPolicy;

						public void set_index(java.lang.String _index) {
							this._index = _index;
						}

						public java.lang.String get_index() {
							return this._index;
						}

						public void setEncryption(Encryption encryption) {
							this.encryption = encryption;
						}

						public Encryption getEncryption() {
							return this.encryption;
						}

						public void setReservations(Reservations reservations) {
							this.reservations = reservations;
						}

						public Reservations getReservations() {
							return this.reservations;
						}

						public void set_startupPolicy(java.lang.String _startupPolicy) {
							this._startupPolicy = _startupPolicy;
						}

						public java.lang.String get_startupPolicy() {
							return this._startupPolicy;
						}

						public class Encryption {

							private java.lang.String _format;

							private Secret secret;

							public void set_format(java.lang.String _format) {
								this._format = _format;
							}

							public java.lang.String get_format() {
								return this._format;
							}

							public void setSecret(Secret secret) {
								this.secret = secret;
							}

							public Secret getSecret() {
								return this.secret;
							}

							public class Secret {

								private java.lang.String _usage;

								private java.lang.String _type;

								private java.lang.String _uuid;

								public void set_usage(java.lang.String _usage) {
									this._usage = _usage;
								}

								public java.lang.String get_usage() {
									return this._usage;
								}

								public void set_type(java.lang.String _type) {
									this._type = _type;
								}

								public java.lang.String get_type() {
									return this._type;
								}

								public void set_uuid(java.lang.String _uuid) {
									this._uuid = _uuid;
								}

								public java.lang.String get_uuid() {
									return this._uuid;
								}
							}
						}

						public class Reservations {

							private java.lang.String _managed;

							private java.lang.String _enabled;

							public void set_managed(java.lang.String _managed) {
								this._managed = _managed;
							}

							public java.lang.String get_managed() {
								return this._managed;
							}

							public void set_enabled(java.lang.String _enabled) {
								this._enabled = _enabled;
							}

							public java.lang.String get_enabled() {
								return this._enabled;
							}
						}
					}
				}

				public class Auth {

					private java.lang.String _username;

					private Secret secret;

					public void set_username(java.lang.String _username) {
						this._username = _username;
					}

					public java.lang.String get_username() {
						return this._username;
					}

					public void setSecret(Secret secret) {
						this.secret = secret;
					}

					public Secret getSecret() {
						return this.secret;
					}

					public class Secret {

						private java.lang.String _usage;

						private java.lang.String _type;

						private java.lang.String _uuid;

						public void set_usage(java.lang.String _usage) {
							this._usage = _usage;
						}

						public java.lang.String get_usage() {
							return this._usage;
						}

						public void set_type(java.lang.String _type) {
							this._type = _type;
						}

						public java.lang.String get_type() {
							return this._type;
						}

						public void set_uuid(java.lang.String _uuid) {
							this._uuid = _uuid;
						}

						public java.lang.String get_uuid() {
							return this._uuid;
						}
					}
				}

				public class Source {

					private java.lang.String _index;

					private Encryption encryption;

					private Reservations reservations;

					private java.lang.String _startupPolicy;

					public void set_index(java.lang.String _index) {
						this._index = _index;
					}

					public java.lang.String get_index() {
						return this._index;
					}

					public void setEncryption(Encryption encryption) {
						this.encryption = encryption;
					}

					public Encryption getEncryption() {
						return this.encryption;
					}

					public void setReservations(Reservations reservations) {
						this.reservations = reservations;
					}

					public Reservations getReservations() {
						return this.reservations;
					}

					public void set_startupPolicy(java.lang.String _startupPolicy) {
						this._startupPolicy = _startupPolicy;
					}

					public java.lang.String get_startupPolicy() {
						return this._startupPolicy;
					}

					public class Encryption {

						private java.lang.String _format;

						private Secret secret;

						public void set_format(java.lang.String _format) {
							this._format = _format;
						}

						public java.lang.String get_format() {
							return this._format;
						}

						public void setSecret(Secret secret) {
							this.secret = secret;
						}

						public Secret getSecret() {
							return this.secret;
						}

						public class Secret {

							private java.lang.String _usage;

							private java.lang.String _type;

							private java.lang.String _uuid;

							public void set_usage(java.lang.String _usage) {
								this._usage = _usage;
							}

							public java.lang.String get_usage() {
								return this._usage;
							}

							public void set_type(java.lang.String _type) {
								this._type = _type;
							}

							public java.lang.String get_type() {
								return this._type;
							}

							public void set_uuid(java.lang.String _uuid) {
								this._uuid = _uuid;
							}

							public java.lang.String get_uuid() {
								return this._uuid;
							}
						}
					}

					public class Reservations {

						private java.lang.String _managed;

						private java.lang.String _enabled;

						public void set_managed(java.lang.String _managed) {
							this._managed = _managed;
						}

						public java.lang.String get_managed() {
							return this._managed;
						}

						public void set_enabled(java.lang.String _enabled) {
							this._enabled = _enabled;
						}

						public java.lang.String get_enabled() {
							return this._enabled;
						}
					}
				}

				public class Blockio {

					private java.lang.String _physical_block_size;

					private java.lang.String _logical_block_size;

					public void set_physical_block_size(java.lang.String _physical_block_size) {
						this._physical_block_size = _physical_block_size;
					}

					public java.lang.String get_physical_block_size() {
						return this._physical_block_size;
					}

					public void set_logical_block_size(java.lang.String _logical_block_size) {
						this._logical_block_size = _logical_block_size;
					}

					public java.lang.String get_logical_block_size() {
						return this._logical_block_size;
					}
				}

				public class Target {

					private java.lang.String _removable;

					private java.lang.String _tray;

					private java.lang.String _dev;

					private java.lang.String _bus;

					public void set_removable(java.lang.String _removable) {
						this._removable = _removable;
					}

					public java.lang.String get_removable() {
						return this._removable;
					}

					public void set_tray(java.lang.String _tray) {
						this._tray = _tray;
					}

					public java.lang.String get_tray() {
						return this._tray;
					}

					public void set_dev(java.lang.String _dev) {
						this._dev = _dev;
					}

					public java.lang.String get_dev() {
						return this._dev;
					}

					public void set_bus(java.lang.String _bus) {
						this._bus = _bus;
					}

					public java.lang.String get_bus() {
						return this._bus;
					}
				}

				public class Driver {

					private java.lang.String _detect_zeroes;

					private java.lang.String _name;

					private java.lang.String _rerror_policy;

					private java.lang.String _io;

					private java.lang.String _queues;

					private java.lang.String _type;

					private java.lang.String _iommu;

					private java.lang.String _ats;

					private java.lang.String _discard;

					private java.lang.String _copy_on_read;

					private java.lang.String _error_policy;

					private java.lang.String _ioeventfd;

					private java.lang.String _iothread;

					private java.lang.String _event_idx;

					private java.lang.String _cache;

					public void set_detect_zeroes(java.lang.String _detect_zeroes) {
						this._detect_zeroes = _detect_zeroes;
					}

					public java.lang.String get_detect_zeroes() {
						return this._detect_zeroes;
					}

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}

					public void set_rerror_policy(java.lang.String _rerror_policy) {
						this._rerror_policy = _rerror_policy;
					}

					public java.lang.String get_rerror_policy() {
						return this._rerror_policy;
					}

					public void set_io(java.lang.String _io) {
						this._io = _io;
					}

					public java.lang.String get_io() {
						return this._io;
					}

					public void set_queues(java.lang.String _queues) {
						this._queues = _queues;
					}

					public java.lang.String get_queues() {
						return this._queues;
					}

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void set_iommu(java.lang.String _iommu) {
						this._iommu = _iommu;
					}

					public java.lang.String get_iommu() {
						return this._iommu;
					}

					public void set_ats(java.lang.String _ats) {
						this._ats = _ats;
					}

					public java.lang.String get_ats() {
						return this._ats;
					}

					public void set_discard(java.lang.String _discard) {
						this._discard = _discard;
					}

					public java.lang.String get_discard() {
						return this._discard;
					}

					public void set_copy_on_read(java.lang.String _copy_on_read) {
						this._copy_on_read = _copy_on_read;
					}

					public java.lang.String get_copy_on_read() {
						return this._copy_on_read;
					}

					public void set_error_policy(java.lang.String _error_policy) {
						this._error_policy = _error_policy;
					}

					public java.lang.String get_error_policy() {
						return this._error_policy;
					}

					public void set_ioeventfd(java.lang.String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public java.lang.String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void set_iothread(java.lang.String _iothread) {
						this._iothread = _iothread;
					}

					public java.lang.String get_iothread() {
						return this._iothread;
					}

					public void set_event_idx(java.lang.String _event_idx) {
						this._event_idx = _event_idx;
					}

					public java.lang.String get_event_idx() {
						return this._event_idx;
					}

					public void set_cache(java.lang.String _cache) {
						this._cache = _cache;
					}

					public java.lang.String get_cache() {
						return this._cache;
					}
				}

				public class Encryption {

					private java.lang.String _format;

					private Secret secret;

					public void set_format(java.lang.String _format) {
						this._format = _format;
					}

					public java.lang.String get_format() {
						return this._format;
					}

					public void setSecret(Secret secret) {
						this.secret = secret;
					}

					public Secret getSecret() {
						return this.secret;
					}

					public class Secret {

						private java.lang.String _usage;

						private java.lang.String _type;

						private java.lang.String _uuid;

						public void set_usage(java.lang.String _usage) {
							this._usage = _usage;
						}

						public java.lang.String get_usage() {
							return this._usage;
						}

						public void set_type(java.lang.String _type) {
							this._type = _type;
						}

						public java.lang.String get_type() {
							return this._type;
						}

						public void set_uuid(java.lang.String _uuid) {
							this._uuid = _uuid;
						}

						public java.lang.String get_uuid() {
							return this._uuid;
						}
					}
				}

				public class BackingStore {

					private java.lang.String _index;

					private Format format;

					private Source source;

					public void set_index(java.lang.String _index) {
						this._index = _index;
					}

					public java.lang.String get_index() {
						return this._index;
					}

					public void setFormat(Format format) {
						this.format = format;
					}

					public Format getFormat() {
						return this.format;
					}

					public void setSource(Source source) {
						this.source = source;
					}

					public Source getSource() {
						return this.source;
					}

					public class Format {

						private java.lang.String _type;

						public void set_type(java.lang.String _type) {
							this._type = _type;
						}

						public java.lang.String get_type() {
							return this._type;
						}
					}

					public class Source {

						private java.lang.String _index;

						private Encryption encryption;

						private Reservations reservations;

						private java.lang.String _startupPolicy;

						public void set_index(java.lang.String _index) {
							this._index = _index;
						}

						public java.lang.String get_index() {
							return this._index;
						}

						public void setEncryption(Encryption encryption) {
							this.encryption = encryption;
						}

						public Encryption getEncryption() {
							return this.encryption;
						}

						public void setReservations(Reservations reservations) {
							this.reservations = reservations;
						}

						public Reservations getReservations() {
							return this.reservations;
						}

						public void set_startupPolicy(java.lang.String _startupPolicy) {
							this._startupPolicy = _startupPolicy;
						}

						public java.lang.String get_startupPolicy() {
							return this._startupPolicy;
						}

						public class Encryption {

							private java.lang.String _format;

							private Secret secret;

							public void set_format(java.lang.String _format) {
								this._format = _format;
							}

							public java.lang.String get_format() {
								return this._format;
							}

							public void setSecret(Secret secret) {
								this.secret = secret;
							}

							public Secret getSecret() {
								return this.secret;
							}

							public class Secret {

								private java.lang.String _usage;

								private java.lang.String _type;

								private java.lang.String _uuid;

								public void set_usage(java.lang.String _usage) {
									this._usage = _usage;
								}

								public java.lang.String get_usage() {
									return this._usage;
								}

								public void set_type(java.lang.String _type) {
									this._type = _type;
								}

								public java.lang.String get_type() {
									return this._type;
								}

								public void set_uuid(java.lang.String _uuid) {
									this._uuid = _uuid;
								}

								public java.lang.String get_uuid() {
									return this._uuid;
								}
							}
						}

						public class Reservations {

							private java.lang.String _managed;

							private java.lang.String _enabled;

							public void set_managed(java.lang.String _managed) {
								this._managed = _managed;
							}

							public java.lang.String get_managed() {
								return this._managed;
							}

							public void set_enabled(java.lang.String _enabled) {
								this._enabled = _enabled;
							}

							public java.lang.String get_enabled() {
								return this._enabled;
							}
						}
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Geometry {

					private java.lang.String _heads;

					private java.lang.String _secs;

					private java.lang.String _cyls;

					private java.lang.String _trans;

					public void set_heads(java.lang.String _heads) {
						this._heads = _heads;
					}

					public java.lang.String get_heads() {
						return this._heads;
					}

					public void set_secs(java.lang.String _secs) {
						this._secs = _secs;
					}

					public java.lang.String get_secs() {
						return this._secs;
					}

					public void set_cyls(java.lang.String _cyls) {
						this._cyls = _cyls;
					}

					public java.lang.String get_cyls() {
						return this._cyls;
					}

					public void set_trans(java.lang.String _trans) {
						this._trans = _trans;
					}

					public java.lang.String get_trans() {
						return this._trans;
					}
				}

				public class Boot {

					private java.lang.String _order;

					private java.lang.String _loadparm;

					public void set_order(java.lang.String _order) {
						this._order = _order;
					}

					public java.lang.String get_order() {
						return this._order;
					}

					public void set_loadparm(java.lang.String _loadparm) {
						this._loadparm = _loadparm;
					}

					public java.lang.String get_loadparm() {
						return this._loadparm;
					}
				}
			}

			public class Watchdog {

				private Alias alias;

				private java.lang.String _model;

				private java.lang.String _action;

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(java.lang.String _model) {
					this._model = _model;
				}

				public java.lang.String get_model() {
					return this._model;
				}

				public void set_action(java.lang.String _action) {
					this._action = _action;
				}

				public java.lang.String get_action() {
					return this._action;
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Hub {

				private java.lang.String _type;

				private Alias alias;

				public void set_type(java.lang.String _type) {
					this._type = _type;
				}

				public java.lang.String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}
			}

			public class Serial {

				private Protocol protocol;

				private Log log;

				private Alias alias;

				private Target target;

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public class Protocol {

					private java.lang.String _type;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}
				}

				public class Log {

					private java.lang.String _file;

					private java.lang.String _append;

					public void set_file(java.lang.String _file) {
						this._file = _file;
					}

					public java.lang.String get_file() {
						return this._file;
					}

					public void set_append(java.lang.String _append) {
						this._append = _append;
					}

					public java.lang.String get_append() {
						return this._append;
					}
				}

				public class Alias {

					private java.lang.String _name;

					public void set_name(java.lang.String _name) {
						this._name = _name;
					}

					public java.lang.String get_name() {
						return this._name;
					}
				}

				public class Target {

					private java.lang.String _type;

					private Model model;

					private java.lang.String _port;

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void setModel(Model model) {
						this.model = model;
					}

					public Model getModel() {
						return this.model;
					}

					public void set_port(java.lang.String _port) {
						this._port = _port;
					}

					public java.lang.String get_port() {
						return this._port;
					}

					public class Model {

						private java.lang.String _name;

						public void set_name(java.lang.String _name) {
							this._name = _name;
						}

						public java.lang.String get_name() {
							return this._name;
						}
					}
				}
			}

			public class Lease {

				private java.lang.String lockspace;

				private java.lang.String key;

				private Target target;

				public void setLockspace(java.lang.String lockspace) {
					this.lockspace = lockspace;
				}

				public java.lang.String getLockspace() {
					return this.lockspace;
				}

				public void setKey(java.lang.String key) {
					this.key = key;
				}

				public java.lang.String getKey() {
					return this.key;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public class Target {

					private java.lang.String _offset;

					private java.lang.String _path;

					public void set_offset(java.lang.String _offset) {
						this._offset = _offset;
					}

					public java.lang.String get_offset() {
						return this._offset;
					}

					public void set_path(java.lang.String _path) {
						this._path = _path;
					}

					public java.lang.String get_path() {
						return this._path;
					}
				}
			}
		}

		public class Cpu {

			private Cache cache;

			private List<Feature> feature;

			private java.lang.String vendor;

			private Topology topology;

			private Numa numa;

			private java.lang.String _check;

			private Model model;

			private java.lang.String _match;

			private java.lang.String _mode;

			public void setCache(Cache cache) {
				this.cache = cache;
			}

			public Cache getCache() {
				return this.cache;
			}

			public void setFeature(List<Feature> feature) {
				this.feature = feature;
			}

			public List<Feature> getFeature() {
				return this.feature;
			}

			public void setVendor(java.lang.String vendor) {
				this.vendor = vendor;
			}

			public java.lang.String getVendor() {
				return this.vendor;
			}

			public void setTopology(Topology topology) {
				this.topology = topology;
			}

			public Topology getTopology() {
				return this.topology;
			}

			public void setNuma(Numa numa) {
				this.numa = numa;
			}

			public Numa getNuma() {
				return this.numa;
			}

			public void set_check(java.lang.String _check) {
				this._check = _check;
			}

			public java.lang.String get_check() {
				return this._check;
			}

			public void setModel(Model model) {
				this.model = model;
			}

			public Model getModel() {
				return this.model;
			}

			public void set_match(java.lang.String _match) {
				this._match = _match;
			}

			public java.lang.String get_match() {
				return this._match;
			}

			public void set_mode(java.lang.String _mode) {
				this._mode = _mode;
			}

			public java.lang.String get_mode() {
				return this._mode;
			}

			public class Cache {

				private java.lang.String _level;

				private java.lang.String _mode;

				public void set_level(java.lang.String _level) {
					this._level = _level;
				}

				public java.lang.String get_level() {
					return this._level;
				}

				public void set_mode(java.lang.String _mode) {
					this._mode = _mode;
				}

				public java.lang.String get_mode() {
					return this._mode;
				}
			}

			public class Feature {

				private java.lang.String _name;

				private java.lang.String _policy;

				public void set_name(java.lang.String _name) {
					this._name = _name;
				}

				public java.lang.String get_name() {
					return this._name;
				}

				public void set_policy(java.lang.String _policy) {
					this._policy = _policy;
				}

				public java.lang.String get_policy() {
					return this._policy;
				}
			}

			public class Topology {

				private java.lang.String _cores;

				private java.lang.String _sockets;

				private java.lang.String _threads;

				public void set_cores(java.lang.String _cores) {
					this._cores = _cores;
				}

				public java.lang.String get_cores() {
					return this._cores;
				}

				public void set_sockets(java.lang.String _sockets) {
					this._sockets = _sockets;
				}

				public java.lang.String get_sockets() {
					return this._sockets;
				}

				public void set_threads(java.lang.String _threads) {
					this._threads = _threads;
				}

				public java.lang.String get_threads() {
					return this._threads;
				}
			}

			public class Numa {

				private List<Cell> cell;

				public void setCell(List<Cell> cell) {
					this.cell = cell;
				}

				public List<Cell> getCell() {
					return this.cell;
				}

				public class Cell {

					private java.lang.String _discard;

					private Distances distances;

					private java.lang.String _memory;

					private java.lang.String _unit;

					private java.lang.String _cpus;

					private java.lang.String _memAccess;

					private java.lang.String _id;

					public void set_discard(java.lang.String _discard) {
						this._discard = _discard;
					}

					public java.lang.String get_discard() {
						return this._discard;
					}

					public void setDistances(Distances distances) {
						this.distances = distances;
					}

					public Distances getDistances() {
						return this.distances;
					}

					public void set_memory(java.lang.String _memory) {
						this._memory = _memory;
					}

					public java.lang.String get_memory() {
						return this._memory;
					}

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void set_cpus(java.lang.String _cpus) {
						this._cpus = _cpus;
					}

					public java.lang.String get_cpus() {
						return this._cpus;
					}

					public void set_memAccess(java.lang.String _memAccess) {
						this._memAccess = _memAccess;
					}

					public java.lang.String get_memAccess() {
						return this._memAccess;
					}

					public void set_id(java.lang.String _id) {
						this._id = _id;
					}

					public java.lang.String get_id() {
						return this._id;
					}

					public class Distances {

						private List<Sibling> sibling;

						public void setSibling(List<Sibling> sibling) {
							this.sibling = sibling;
						}

						public List<Sibling> getSibling() {
							return this.sibling;
						}

						public class Sibling {

							private java.lang.String _string;

							private java.lang.String _id;

							public void set_string(java.lang.String _string) {
								this._string = _string;
							}

							public java.lang.String get_string() {
								return this._string;
							}

							public void set_id(java.lang.String _id) {
								this._id = _id;
							}

							public java.lang.String get_id() {
								return this._id;
							}
						}
					}
				}
			}

			public class Model {

				private java.lang.String _fallback;

				private java.lang.String _vendor_id;

				private java.lang.String text;

				public void set_fallback(java.lang.String _fallback) {
					this._fallback = _fallback;
				}

				public java.lang.String get_fallback() {
					return this._fallback;
				}

				public void set_vendor_id(java.lang.String _vendor_id) {
					this._vendor_id = _vendor_id;
				}

				public java.lang.String get_vendor_id() {
					return this._vendor_id;
				}

				public void setText(java.lang.String text) {
					this.text = text;
				}

				public java.lang.String getText() {
					return this.text;
				}
			}
		}

		public class Clock {

			private java.lang.String _basis;

			private List<Timer> timer;

			private java.lang.String _offset;

			private java.lang.String _adjustment;

			private java.lang.String _timezone;

			public void set_basis(java.lang.String _basis) {
				this._basis = _basis;
			}

			public java.lang.String get_basis() {
				return this._basis;
			}

			public void setTimer(List<Timer> timer) {
				this.timer = timer;
			}

			public List<Timer> getTimer() {
				return this.timer;
			}

			public void set_offset(java.lang.String _offset) {
				this._offset = _offset;
			}

			public java.lang.String get_offset() {
				return this._offset;
			}

			public void set_adjustment(java.lang.String _adjustment) {
				this._adjustment = _adjustment;
			}

			public java.lang.String get_adjustment() {
				return this._adjustment;
			}

			public void set_timezone(java.lang.String _timezone) {
				this._timezone = _timezone;
			}

			public java.lang.String get_timezone() {
				return this._timezone;
			}

			public class Timer {

				private java.lang.String _name;

				private Catchup catchup;

				private java.lang.String _track;

				private java.lang.String _frequency;

				private java.lang.String _present;

				private java.lang.String _tickpolicy;

				private java.lang.String _mode;

				public void set_name(java.lang.String _name) {
					this._name = _name;
				}

				public java.lang.String get_name() {
					return this._name;
				}

				public void setCatchup(Catchup catchup) {
					this.catchup = catchup;
				}

				public Catchup getCatchup() {
					return this.catchup;
				}

				public void set_track(java.lang.String _track) {
					this._track = _track;
				}

				public java.lang.String get_track() {
					return this._track;
				}

				public void set_frequency(java.lang.String _frequency) {
					this._frequency = _frequency;
				}

				public java.lang.String get_frequency() {
					return this._frequency;
				}

				public void set_present(java.lang.String _present) {
					this._present = _present;
				}

				public java.lang.String get_present() {
					return this._present;
				}

				public void set_tickpolicy(java.lang.String _tickpolicy) {
					this._tickpolicy = _tickpolicy;
				}

				public java.lang.String get_tickpolicy() {
					return this._tickpolicy;
				}

				public void set_mode(java.lang.String _mode) {
					this._mode = _mode;
				}

				public java.lang.String get_mode() {
					return this._mode;
				}

				public class Catchup {

					private java.lang.String _limit;

					private java.lang.String _slew;

					private java.lang.String _threshold;

					public void set_limit(java.lang.String _limit) {
						this._limit = _limit;
					}

					public java.lang.String get_limit() {
						return this._limit;
					}

					public void set_slew(java.lang.String _slew) {
						this._slew = _slew;
					}

					public java.lang.String get_slew() {
						return this._slew;
					}

					public void set_threshold(java.lang.String _threshold) {
						this._threshold = _threshold;
					}

					public java.lang.String get_threshold() {
						return this._threshold;
					}
				}
			}
		}

		public class Vcpus {

			private List<Vcpu> vcpu;

			public void setVcpu(List<Vcpu> vcpu) {
				this.vcpu = vcpu;
			}

			public List<Vcpu> getVcpu() {
				return this.vcpu;
			}

			public class Vcpu {

				private java.lang.String _order;

				private java.lang.String _hotpluggable;

				private java.lang.String _id;

				private java.lang.String _enabled;

				public void set_order(java.lang.String _order) {
					this._order = _order;
				}

				public java.lang.String get_order() {
					return this._order;
				}

				public void set_hotpluggable(java.lang.String _hotpluggable) {
					this._hotpluggable = _hotpluggable;
				}

				public java.lang.String get_hotpluggable() {
					return this._hotpluggable;
				}

				public void set_id(java.lang.String _id) {
					this._id = _id;
				}

				public java.lang.String get_id() {
					return this._id;
				}

				public void set_enabled(java.lang.String _enabled) {
					this._enabled = _enabled;
				}

				public java.lang.String get_enabled() {
					return this._enabled;
				}
			}
		}

		public class Cputune {

			private java.lang.String period;

			private java.lang.String global_quota;

			private List<Iothreadpin> iothreadpin;

			private java.lang.String emulator_period;

			private Emulatorpin emulatorpin;

			private List<Vcpusched> vcpusched;

			private List<Iothreadsched> iothreadsched;

			private java.lang.String iothread_period;

			private java.lang.String global_period;

			private java.lang.String emulator_quota;

			private java.lang.String shares;

			private List<Vcpupin> vcpupin;

			private List<Cachetune> cachetune;

			private java.lang.String quota;

			private java.lang.String iothread_quota;

			private List<Memorytune> memorytune;

			public void setPeriod(java.lang.String period) {
				this.period = period;
			}

			public java.lang.String getPeriod() {
				return this.period;
			}

			public void setGlobal_quota(java.lang.String global_quota) {
				this.global_quota = global_quota;
			}

			public java.lang.String getGlobal_quota() {
				return this.global_quota;
			}

			public void setIothreadpin(List<Iothreadpin> iothreadpin) {
				this.iothreadpin = iothreadpin;
			}

			public List<Iothreadpin> getIothreadpin() {
				return this.iothreadpin;
			}

			public void setEmulator_period(java.lang.String emulator_period) {
				this.emulator_period = emulator_period;
			}

			public java.lang.String getEmulator_period() {
				return this.emulator_period;
			}

			public void setEmulatorpin(Emulatorpin emulatorpin) {
				this.emulatorpin = emulatorpin;
			}

			public Emulatorpin getEmulatorpin() {
				return this.emulatorpin;
			}

			public void setVcpusched(List<Vcpusched> vcpusched) {
				this.vcpusched = vcpusched;
			}

			public List<Vcpusched> getVcpusched() {
				return this.vcpusched;
			}

			public void setIothreadsched(List<Iothreadsched> iothreadsched) {
				this.iothreadsched = iothreadsched;
			}

			public List<Iothreadsched> getIothreadsched() {
				return this.iothreadsched;
			}

			public void setIothread_period(java.lang.String iothread_period) {
				this.iothread_period = iothread_period;
			}

			public java.lang.String getIothread_period() {
				return this.iothread_period;
			}

			public void setGlobal_period(java.lang.String global_period) {
				this.global_period = global_period;
			}

			public java.lang.String getGlobal_period() {
				return this.global_period;
			}

			public void setEmulator_quota(java.lang.String emulator_quota) {
				this.emulator_quota = emulator_quota;
			}

			public java.lang.String getEmulator_quota() {
				return this.emulator_quota;
			}

			public void setShares(java.lang.String shares) {
				this.shares = shares;
			}

			public java.lang.String getShares() {
				return this.shares;
			}

			public void setVcpupin(List<Vcpupin> vcpupin) {
				this.vcpupin = vcpupin;
			}

			public List<Vcpupin> getVcpupin() {
				return this.vcpupin;
			}

			public void setCachetune(List<Cachetune> cachetune) {
				this.cachetune = cachetune;
			}

			public List<Cachetune> getCachetune() {
				return this.cachetune;
			}

			public void setQuota(java.lang.String quota) {
				this.quota = quota;
			}

			public java.lang.String getQuota() {
				return this.quota;
			}

			public void setIothread_quota(java.lang.String iothread_quota) {
				this.iothread_quota = iothread_quota;
			}

			public java.lang.String getIothread_quota() {
				return this.iothread_quota;
			}

			public void setMemorytune(List<Memorytune> memorytune) {
				this.memorytune = memorytune;
			}

			public List<Memorytune> getMemorytune() {
				return this.memorytune;
			}

			public class Iothreadpin {

				private java.lang.String _cpuset;

				private java.lang.String _iothread;

				public void set_cpuset(java.lang.String _cpuset) {
					this._cpuset = _cpuset;
				}

				public java.lang.String get_cpuset() {
					return this._cpuset;
				}

				public void set_iothread(java.lang.String _iothread) {
					this._iothread = _iothread;
				}

				public java.lang.String get_iothread() {
					return this._iothread;
				}
			}

			public class Emulatorpin {

				private java.lang.String _cpuset;

				public void set_cpuset(java.lang.String _cpuset) {
					this._cpuset = _cpuset;
				}

				public java.lang.String get_cpuset() {
					return this._cpuset;
				}
			}

			public class Vcpusched {

				private java.lang.String _scheduler;

				private java.lang.String _vcpus;

				private java.lang.String _priority;

				public void set_scheduler(java.lang.String _scheduler) {
					this._scheduler = _scheduler;
				}

				public java.lang.String get_scheduler() {
					return this._scheduler;
				}

				public void set_vcpus(java.lang.String _vcpus) {
					this._vcpus = _vcpus;
				}

				public java.lang.String get_vcpus() {
					return this._vcpus;
				}

				public void set_priority(java.lang.String _priority) {
					this._priority = _priority;
				}

				public java.lang.String get_priority() {
					return this._priority;
				}
			}

			public class Iothreadsched {

				private java.lang.String _scheduler;

				private java.lang.String _iothreads;

				private java.lang.String _priority;

				public void set_scheduler(java.lang.String _scheduler) {
					this._scheduler = _scheduler;
				}

				public java.lang.String get_scheduler() {
					return this._scheduler;
				}

				public void set_iothreads(java.lang.String _iothreads) {
					this._iothreads = _iothreads;
				}

				public java.lang.String get_iothreads() {
					return this._iothreads;
				}

				public void set_priority(java.lang.String _priority) {
					this._priority = _priority;
				}

				public java.lang.String get_priority() {
					return this._priority;
				}
			}

			public class Vcpupin {

				private java.lang.String _vcpu;

				private java.lang.String _cpuset;

				public void set_vcpu(java.lang.String _vcpu) {
					this._vcpu = _vcpu;
				}

				public java.lang.String get_vcpu() {
					return this._vcpu;
				}

				public void set_cpuset(java.lang.String _cpuset) {
					this._cpuset = _cpuset;
				}

				public java.lang.String get_cpuset() {
					return this._cpuset;
				}
			}

			public class Cachetune {

				private List<Cache> cache;

				private List<Monitor> monitor;

				private java.lang.String _vcpus;

				public void setCache(List<Cache> cache) {
					this.cache = cache;
				}

				public List<Cache> getCache() {
					return this.cache;
				}

				public void setMonitor(List<Monitor> monitor) {
					this.monitor = monitor;
				}

				public List<Monitor> getMonitor() {
					return this.monitor;
				}

				public void set_vcpus(java.lang.String _vcpus) {
					this._vcpus = _vcpus;
				}

				public java.lang.String get_vcpus() {
					return this._vcpus;
				}

				public class Cache {

					private java.lang.String _size;

					private java.lang.String _unit;

					private java.lang.String _level;

					private java.lang.String _type;

					private java.lang.String _id;

					public void set_size(java.lang.String _size) {
						this._size = _size;
					}

					public java.lang.String get_size() {
						return this._size;
					}

					public void set_unit(java.lang.String _unit) {
						this._unit = _unit;
					}

					public java.lang.String get_unit() {
						return this._unit;
					}

					public void set_level(java.lang.String _level) {
						this._level = _level;
					}

					public java.lang.String get_level() {
						return this._level;
					}

					public void set_type(java.lang.String _type) {
						this._type = _type;
					}

					public java.lang.String get_type() {
						return this._type;
					}

					public void set_id(java.lang.String _id) {
						this._id = _id;
					}

					public java.lang.String get_id() {
						return this._id;
					}
				}

				public class Monitor {

					private java.lang.String _level;

					private java.lang.String _vcpus;

					public void set_level(java.lang.String _level) {
						this._level = _level;
					}

					public java.lang.String get_level() {
						return this._level;
					}

					public void set_vcpus(java.lang.String _vcpus) {
						this._vcpus = _vcpus;
					}

					public java.lang.String get_vcpus() {
						return this._vcpus;
					}
				}
			}

			public class Memorytune {

				private List<Node> node;

				private java.lang.String _vcpus;

				public void setNode(List<Node> node) {
					this.node = node;
				}

				public List<Node> getNode() {
					return this.node;
				}

				public void set_vcpus(java.lang.String _vcpus) {
					this._vcpus = _vcpus;
				}

				public java.lang.String get_vcpus() {
					return this._vcpus;
				}

				public class Node {

					private java.lang.String _bandwidth;

					private java.lang.String _id;

					public void set_bandwidth(java.lang.String _bandwidth) {
						this._bandwidth = _bandwidth;
					}

					public java.lang.String get_bandwidth() {
						return this._bandwidth;
					}

					public void set_id(java.lang.String _id) {
						this._id = _id;
					}

					public java.lang.String get_id() {
						return this._id;
					}
				}
			}
		}

		public class CurrentMemory {

			private java.lang.String _unit;

			private java.lang.String text;

			public void set_unit(java.lang.String _unit) {
				this._unit = _unit;
			}

			public java.lang.String get_unit() {
				return this._unit;
			}

			public void setText(java.lang.String text) {
				this.text = text;
			}

			public java.lang.String getText() {
				return this.text;
			}
		}

		public class Pm {

			private Suspend_to_disk suspend_to_disk;

			private Suspend_to_mem suspend_to_mem;

			public void setSuspend_to_disk(Suspend_to_disk suspend_to_disk) {
				this.suspend_to_disk = suspend_to_disk;
			}

			public Suspend_to_disk getSuspend_to_disk() {
				return this.suspend_to_disk;
			}

			public void setSuspend_to_mem(Suspend_to_mem suspend_to_mem) {
				this.suspend_to_mem = suspend_to_mem;
			}

			public Suspend_to_mem getSuspend_to_mem() {
				return this.suspend_to_mem;
			}

			public class Suspend_to_disk {

				private java.lang.String _enabled;

				public void set_enabled(java.lang.String _enabled) {
					this._enabled = _enabled;
				}

				public java.lang.String get_enabled() {
					return this._enabled;
				}
			}

			public class Suspend_to_mem {

				private java.lang.String _enabled;

				public void set_enabled(java.lang.String _enabled) {
					this._enabled = _enabled;
				}

				public java.lang.String get_enabled() {
					return this._enabled;
				}
			}
		}
	}
}
