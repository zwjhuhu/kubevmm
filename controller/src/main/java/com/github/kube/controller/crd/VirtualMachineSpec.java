/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller.crd;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Tue May 07 21:15:23 CST 2019
 **/
@JsonDeserialize(using = JsonDeserializer.None.class)
public class VirtualMachineSpec implements KubernetesResource {

	private Domain domain;
	
	private String image;

	public VirtualMachineSpec() {
		this.domain = new Domain();

	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Domain getDomain() {
		return this.domain;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static class Domain {

		private String on_poweroff;

		private Memory memory;

		private Os os;

		private Vcpu vcpu;

		private Resource resource;

		private Devices devices;

		private String on_reboot;

		private String _type;

		private Cpu cpu;

		private Clock clock;

		private String uuid;

		private Features features;

		private String on_crash;

		private String name;

		private CurrentMemory currentMemory;

		private String _id;

		private Pm pm;

		public Domain() {
			this.on_poweroff = "destroy";
			this.memory = new Memory();
			this.os = new Os();
			this.vcpu = new Vcpu();
			this.resource = new Resource();
			this.devices = new Devices();
			this.on_reboot = "destroy";
			this._type = "kvm";
			this.cpu = new Cpu();
			this.clock = new Clock();
			this.features = new Features();
			this.on_crash = "destroy";
			this.name = "centos7.0";
			this.currentMemory = new CurrentMemory();
			this.pm = new Pm();

		}

		public void setOn_poweroff(String on_poweroff) {
			this.on_poweroff = on_poweroff;
		}

		public String getOn_poweroff() {
			return this.on_poweroff;
		}

		public void setMemory(Memory memory) {
			this.memory = memory;
		}

		public Memory getMemory() {
			return this.memory;
		}

		public void setOs(Os os) {
			this.os = os;
		}

		public Os getOs() {
			return this.os;
		}

		public void setVcpu(Vcpu vcpu) {
			this.vcpu = vcpu;
		}

		public Vcpu getVcpu() {
			return this.vcpu;
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

		public void setOn_reboot(String on_reboot) {
			this.on_reboot = on_reboot;
		}

		public String getOn_reboot() {
			return this.on_reboot;
		}

		public void set_type(String _type) {
			this._type = _type;
		}

		public String get_type() {
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

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getUuid() {
			return this.uuid;
		}

		public void setFeatures(Features features) {
			this.features = features;
		}

		public Features getFeatures() {
			return this.features;
		}

		public void setOn_crash(String on_crash) {
			this.on_crash = on_crash;
		}

		public String getOn_crash() {
			return this.on_crash;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void setCurrentMemory(CurrentMemory currentMemory) {
			this.currentMemory = currentMemory;
		}

		public CurrentMemory getCurrentMemory() {
			return this.currentMemory;
		}

		public void set_id(String _id) {
			this._id = _id;
		}

		public String get_id() {
			return this._id;
		}

		public void setPm(Pm pm) {
			this.pm = pm;
		}

		public Pm getPm() {
			return this.pm;
		}

		public static class Memory {

			private String _unit;

			private String text;

			public Memory() {
				this._unit = "KiB";
				this.text = "2097152";

			}

			public void set_unit(String _unit) {
				this._unit = _unit;
			}

			public String get_unit() {
				return this._unit;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Os {

			private Type type;

			private ArrayList<Boot> boot;

			public Os() {
				this.type = new Type();

			}

			public void setType(Type type) {
				this.type = type;
			}

			public Type getType() {
				return this.type;
			}

			public void setBoot(ArrayList<Boot> boot) {
				this.boot = boot;
			}

			public ArrayList<Boot> getBoot() {
				return this.boot;
			}

			public static class Type {

				private String _machine;

				private String text;

				private String _arch;

				public Type() {
					this._machine = "pc_i440fx_rhel7.6.0";
					this.text = "hvm";
					this._arch = "x86_64";

				}

				public void set_machine(String _machine) {
					this._machine = _machine;
				}

				public String get_machine() {
					return this._machine;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}

				public void set_arch(String _arch) {
					this._arch = _arch;
				}

				public String get_arch() {
					return this._arch;
				}
			}

			public static class Boot {

				private String _dev;

				public Boot() {
					this._dev = "cdrom";

				}

				public void set_dev(String _dev) {
					this._dev = _dev;
				}

				public String get_dev() {
					return this._dev;
				}
			}
		}

		public static class Vcpu {

			private String _placement;

			private String text;

			public Vcpu() {
				this._placement = "static";
				this.text = "2";

			}

			public void set_placement(String _placement) {
				this._placement = _placement;
			}

			public String get_placement() {
				return this._placement;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Resource {

			private String partition;

			public Resource() {
				this.partition = "/machine";

			}

			public void setPartition(String partition) {
				this.partition = partition;
			}

			public String getPartition() {
				return this.partition;
			}
		}

		public static class Devices {

			private Console console;

			private ArrayList<Controller> controller;

			private Sound sound;

			private ArrayList<Redirdev> redirdev;

			private ArrayList<Channel> channel;

			private Memballoon memballoon;

			private Graphics graphics;

			private Video video;

			private _interface _interface;

			private String emulator;

			private ArrayList<Input> input;

			private ArrayList<Disk> disk;

			private Serial serial;

			public Devices() {
				this.console = new Console();
				this.sound = new Sound();
				this.memballoon = new Memballoon();
				this.graphics = new Graphics();
				this.video = new Video();
				this.emulator = "/usr/libexec/qemu_kvm";
				this.serial = new Serial();

			}

			public void setConsole(Console console) {
				this.console = console;
			}

			public Console getConsole() {
				return this.console;
			}

			public void setController(ArrayList<Controller> controller) {
				this.controller = controller;
			}

			public ArrayList<Controller> getController() {
				return this.controller;
			}

			public void setSound(Sound sound) {
				this.sound = sound;
			}

			public Sound getSound() {
				return this.sound;
			}

			public void setRedirdev(ArrayList<Redirdev> redirdev) {
				this.redirdev = redirdev;
			}

			public ArrayList<Redirdev> getRedirdev() {
				return this.redirdev;
			}

			public void setChannel(ArrayList<Channel> channel) {
				this.channel = channel;
			}

			public ArrayList<Channel> getChannel() {
				return this.channel;
			}

			public void setMemballoon(Memballoon memballoon) {
				this.memballoon = memballoon;
			}

			public Memballoon getMemballoon() {
				return this.memballoon;
			}

			public void setGraphics(Graphics graphics) {
				this.graphics = graphics;
			}

			public Graphics getGraphics() {
				return this.graphics;
			}

			public void setVideo(Video video) {
				this.video = video;
			}

			public Video getVideo() {
				return this.video;
			}

			public void set_interface(_interface _interface) {
				this._interface = _interface;
			}

			public _interface get_interface() {
				return this._interface;
			}

			public void setEmulator(String emulator) {
				this.emulator = emulator;
			}

			public String getEmulator() {
				return this.emulator;
			}

			public void setInput(ArrayList<Input> input) {
				this.input = input;
			}

			public ArrayList<Input> getInput() {
				return this.input;
			}

			public void setDisk(ArrayList<Disk> disk) {
				this.disk = disk;
			}

			public ArrayList<Disk> getDisk() {
				return this.disk;
			}

			public void setSerial(Serial serial) {
				this.serial = serial;
			}

			public Serial getSerial() {
				return this.serial;
			}

			public static class Console {

				private String _tty;

				private String _type;

				private Alias alias;

				private Source source;

				private Target target;

				public Console() {
					this._tty = "/dev/pts/3";
					this._type = "pty";
					this.alias = new Alias();
					this.source = new Source();
					this.target = new Target();

				}

				public void set_tty(String _tty) {
					this._tty = _tty;
				}

				public String get_tty() {
					return this._tty;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
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

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "serial0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					private String _path;

					public Source() {
						this._path = "/dev/pts/3";

					}

					public void set_path(String _path) {
						this._path = _path;
					}

					public String get_path() {
						return this._path;
					}
				}

				public static class Target {

					private String _type;

					private String _port;

					public Target() {
						this._type = "serial";
						this._port = "0";

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}
				}
			}

			public static class Controller {

				private Address address;

				private String _index;

				private String _type;

				private Alias alias;

				private String _model;

				public Controller() {
					this.address = new Address();
					this._index = "0";
					this._type = "usb";
					this.alias = new Alias();
					this._model = "ich9_ehci1";

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_index(String _index) {
					this._index = _index;
				}

				public String get_index() {
					return this._index;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Address {

					private String _domain;

					private String _function;

					private String _type;

					private String _bus;

					private String _slot;

					public Address() {
						this._domain = "0x0000";
						this._function = "0x7";
						this._type = "pci";
						this._bus = "0x00";
						this._slot = "0x05";

					}

					public void set_domain(String _domain) {
						this._domain = _domain;
					}

					public String get_domain() {
						return this._domain;
					}

					public void set_function(String _function) {
						this._function = _function;
					}

					public String get_function() {
						return this._function;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_slot(String _slot) {
						this._slot = _slot;
					}

					public String get_slot() {
						return this._slot;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "usb";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Sound {

				private Address address;

				private Alias alias;

				private String _model;

				public Sound() {
					this.address = new Address();
					this.alias = new Alias();
					this._model = "ich6";

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Address {

					private String _domain;

					private String _function;

					private String _type;

					private String _bus;

					private String _slot;

					public Address() {
						this._domain = "0x0000";
						this._function = "0x0";
						this._type = "pci";
						this._bus = "0x00";
						this._slot = "0x04";

					}

					public void set_domain(String _domain) {
						this._domain = _domain;
					}

					public String get_domain() {
						return this._domain;
					}

					public void set_function(String _function) {
						this._function = _function;
					}

					public String get_function() {
						return this._function;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_slot(String _slot) {
						this._slot = _slot;
					}

					public String get_slot() {
						return this._slot;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "sound0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Redirdev {

				private Address address;

				private String _type;

				private Alias alias;

				private String _bus;

				public Redirdev() {
					this.address = new Address();
					this._type = "spicevmc";
					this.alias = new Alias();
					this._bus = "usb";

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_bus(String _bus) {
					this._bus = _bus;
				}

				public String get_bus() {
					return this._bus;
				}

				public static class Address {

					private String _type;

					private String _bus;

					private String _port;

					public Address() {
						this._type = "usb";
						this._bus = "0";
						this._port = "2";

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "redir0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Channel {

				private Address address;

				private String _type;

				private Alias alias;

				private Source source;

				private Target target;

				public Channel() {
					this.address = new Address();
					this._type = "unix";
					this.alias = new Alias();
					this.source = new Source();
					this.target = new Target();

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
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

				public static class Address {

					private String _controller;

					private String _type;

					private String _bus;

					private String _port;

					public Address() {
						this._controller = "0";
						this._type = "virtio_serial";
						this._bus = "0";
						this._port = "1";

					}

					public void set_controller(String _controller) {
						this._controller = _controller;
					}

					public String get_controller() {
						return this._controller;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "channel0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					private String _path;

					private String _mode;

					public Source() {
						this._path = "/var/lib/libvirt/qemu/channel/target/domain_2_centos7.0/org.qemu.guest_agent.0";
						this._mode = "bind";

					}

					public void set_path(String _path) {
						this._path = _path;
					}

					public String get_path() {
						return this._path;
					}

					public void set_mode(String _mode) {
						this._mode = _mode;
					}

					public String get_mode() {
						return this._mode;
					}
				}

				public static class Target {

					private String _name;

					private String _state;

					private String _type;

					public Target() {
						this._name = "org.qemu.guest_agent.0";
						this._state = "disconnected";
						this._type = "virtio";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}
			}

			public static class Memballoon {

				private Address address;

				private Alias alias;

				private String _model;

				public Memballoon() {
					this.address = new Address();
					this.alias = new Alias();
					this._model = "virtio";

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Address {

					private String _domain;

					private String _function;

					private String _type;

					private String _bus;

					private String _slot;

					public Address() {
						this._domain = "0x0000";
						this._function = "0x0";
						this._type = "pci";
						this._bus = "0x00";
						this._slot = "0x08";

					}

					public void set_domain(String _domain) {
						this._domain = _domain;
					}

					public String get_domain() {
						return this._domain;
					}

					public void set_function(String _function) {
						this._function = _function;
					}

					public String get_function() {
						return this._function;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_slot(String _slot) {
						this._slot = _slot;
					}

					public String get_slot() {
						return this._slot;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "balloon0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Graphics {

				private Image image;

				private String _type;

				private String _autoport;

				private Listen listen;

				private String _port;

				private String _listen;

				public Graphics() {
					this.image = new Image();
					this._type = "spice";
					this._autoport = "yes";
					this.listen = new Listen();
					this._port = "5900";
					this._listen = "127.0.0.1";

				}

				public void setImage(Image image) {
					this.image = image;
				}

				public Image getImage() {
					return this.image;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void set_autoport(String _autoport) {
					this._autoport = _autoport;
				}

				public String get_autoport() {
					return this._autoport;
				}

				public void setListen(Listen listen) {
					this.listen = listen;
				}

				public Listen getListen() {
					return this.listen;
				}

				public void set_port(String _port) {
					this._port = _port;
				}

				public String get_port() {
					return this._port;
				}

				public void set_listen(String _listen) {
					this._listen = _listen;
				}

				public String get_listen() {
					return this._listen;
				}

				public static class Image {

					private String _compression;

					public Image() {
						this._compression = "off";

					}

					public void set_compression(String _compression) {
						this._compression = _compression;
					}

					public String get_compression() {
						return this._compression;
					}
				}

				public static class Listen {

					private String _address;

					private String _type;

					public Listen() {
						this._address = "127.0.0.1";
						this._type = "address";

					}

					public void set_address(String _address) {
						this._address = _address;
					}

					public String get_address() {
						return this._address;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}
			}

			public static class Video {

				private Address address;

				private Alias alias;

				private Model model;

				public Video() {
					this.address = new Address();
					this.alias = new Alias();
					this.model = new Model();

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
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

				public static class Address {

					private String _domain;

					private String _function;

					private String _type;

					private String _bus;

					private String _slot;

					public Address() {
						this._domain = "0x0000";
						this._function = "0x0";
						this._type = "pci";
						this._bus = "0x00";
						this._slot = "0x02";

					}

					public void set_domain(String _domain) {
						this._domain = _domain;
					}

					public String get_domain() {
						return this._domain;
					}

					public void set_function(String _function) {
						this._function = _function;
					}

					public String get_function() {
						return this._function;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_slot(String _slot) {
						this._slot = _slot;
					}

					public String get_slot() {
						return this._slot;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "video0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Model {

					private String _vgamem;

					private String _heads;

					private String _ram;

					private String _vram;

					private String _type;

					private String _primary;

					public Model() {
						this._vgamem = "16384";
						this._heads = "1";
						this._ram = "65536";
						this._vram = "65536";
						this._type = "qxl";
						this._primary = "yes";

					}

					public void set_vgamem(String _vgamem) {
						this._vgamem = _vgamem;
					}

					public String get_vgamem() {
						return this._vgamem;
					}

					public void set_heads(String _heads) {
						this._heads = _heads;
					}

					public String get_heads() {
						return this._heads;
					}

					public void set_ram(String _ram) {
						this._ram = _ram;
					}

					public String get_ram() {
						return this._ram;
					}

					public void set_vram(String _vram) {
						this._vram = _vram;
					}

					public String get_vram() {
						return this._vram;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_primary(String _primary) {
						this._primary = _primary;
					}

					public String get_primary() {
						return this._primary;
					}
				}
			}

			public static class _interface {

				private Address address;

				private String _type;

				private Alias alias;

				private Model model;

				private Source source;

				private Mac mac;

				private Target target;

				public _interface() {
					this.address = new Address();
					this._type = "network";
					this.alias = new Alias();
					this.model = new Model();
					this.source = new Source();
					this.mac = new Mac();
					this.target = new Target();

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
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

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setMac(Mac mac) {
					this.mac = mac;
				}

				public Mac getMac() {
					return this.mac;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Address {

					private String _domain;

					private String _function;

					private String _type;

					private String _bus;

					private String _slot;

					public Address() {
						this._domain = "0x0000";
						this._function = "0x0";
						this._type = "pci";
						this._bus = "0x00";
						this._slot = "0x03";

					}

					public void set_domain(String _domain) {
						this._domain = _domain;
					}

					public String get_domain() {
						return this._domain;
					}

					public void set_function(String _function) {
						this._function = _function;
					}

					public String get_function() {
						return this._function;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_slot(String _slot) {
						this._slot = _slot;
					}

					public String get_slot() {
						return this._slot;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "net0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Model {

					private String _type;

					public Model() {
						this._type = "virtio";

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Source {

					private String _bridge;

					private String _network;

					public Source() {
						this._bridge = "virbr0";
						this._network = "default";

					}

					public void set_bridge(String _bridge) {
						this._bridge = _bridge;
					}

					public String get_bridge() {
						return this._bridge;
					}

					public void set_network(String _network) {
						this._network = _network;
					}

					public String get_network() {
						return this._network;
					}
				}

				public static class Mac {

					private String _address;

					public Mac() {
						this._address = "52:54:00:d9:e0:b9";

					}

					public void set_address(String _address) {
						this._address = _address;
					}

					public String get_address() {
						return this._address;
					}
				}

				public static class Target {

					private String _dev;

					public Target() {
						this._dev = "vnet0";

					}

					public void set_dev(String _dev) {
						this._dev = _dev;
					}

					public String get_dev() {
						return this._dev;
					}
				}
			}

			public static class Input {

				private Address address;

				private String _type;

				private Alias alias;

				private String _bus;

				public Input() {
					this.address = new Address();
					this._type = "tablet";
					this.alias = new Alias();
					this._bus = "usb";

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_bus(String _bus) {
					this._bus = _bus;
				}

				public String get_bus() {
					return this._bus;
				}

				public static class Address {

					private String _type;

					private String _bus;

					private String _port;

					public Address() {
						this._type = "usb";
						this._bus = "0";
						this._port = "1";

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "input0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Disk {

				private Address address;

				private Driver driver;

				private String _type;

				private Alias alias;

				private Source source;

				private String _device;

				private Target target;

				public Disk() {
					this.address = new Address();
					this.driver = new Driver();
					this._type = "file";
					this.alias = new Alias();
					this.source = new Source();
					this._device = "disk";
					this.target = new Target();

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void set_device(String _device) {
					this._device = _device;
				}

				public String get_device() {
					return this._device;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Address {

					private String _domain;

					private String _function;

					private String _type;

					private String _bus;

					private String _slot;

					public Address() {
						this._domain = "0x0000";
						this._function = "0x0";
						this._type = "pci";
						this._bus = "0x00";
						this._slot = "0x07";

					}

					public void set_domain(String _domain) {
						this._domain = _domain;
					}

					public String get_domain() {
						return this._domain;
					}

					public void set_function(String _function) {
						this._function = _function;
					}

					public String get_function() {
						return this._function;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}

					public void set_slot(String _slot) {
						this._slot = _slot;
					}

					public String get_slot() {
						return this._slot;
					}
				}

				public static class Driver {

					private String _name;

					private String _type;

					public Driver() {
						this._name = "qemu";
						this._type = "qcow2";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "virtio_disk0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					private String _file;

					public Source() {
						this._file = "/var/lib/libvirt/images/centos7.0.qcow2";

					}

					public void set_file(String _file) {
						this._file = _file;
					}

					public String get_file() {
						return this._file;
					}
				}

				public static class Target {

					private String _dev;

					private String _bus;

					public Target() {
						this._dev = "vda";
						this._bus = "virtio";

					}

					public void set_dev(String _dev) {
						this._dev = _dev;
					}

					public String get_dev() {
						return this._dev;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}
				}
			}

			public static class Serial {

				private String _type;

				private Alias alias;

				private Source source;

				private Target target;

				public Serial() {
					this._type = "pty";
					this.alias = new Alias();
					this.source = new Source();
					this.target = new Target();

				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
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

				public static class Alias {

					private String _name;

					public Alias() {
						this._name = "serial0";

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					private String _path;

					public Source() {
						this._path = "/dev/pts/3";

					}

					public void set_path(String _path) {
						this._path = _path;
					}

					public String get_path() {
						return this._path;
					}
				}

				public static class Target {

					private String _type;

					private Model model;

					private String _port;

					public Target() {
						this._type = "isa_serial";
						this.model = new Model();
						this._port = "0";

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void setModel(Model model) {
						this.model = model;
					}

					public Model getModel() {
						return this.model;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}

					public static class Model {

						private String _name;

						public Model() {
							this._name = "isa_serial";

						}

						public void set_name(String _name) {
							this._name = _name;
						}

						public String get_name() {
							return this._name;
						}
					}
				}
			}
		}

		public static class Cpu {

			private ArrayList<Feature> feature;

			private String _check;

			private Model model;

			private String _match;

			private String _mode;

			public Cpu() {
				this._check = "full";
				this.model = new Model();
				this._match = "exact";
				this._mode = "custom";

			}

			public void setFeature(ArrayList<Feature> feature) {
				this.feature = feature;
			}

			public ArrayList<Feature> getFeature() {
				return this.feature;
			}

			public void set_check(String _check) {
				this._check = _check;
			}

			public String get_check() {
				return this._check;
			}

			public void setModel(Model model) {
				this.model = model;
			}

			public Model getModel() {
				return this.model;
			}

			public void set_match(String _match) {
				this._match = _match;
			}

			public String get_match() {
				return this._match;
			}

			public void set_mode(String _mode) {
				this._mode = _mode;
			}

			public String get_mode() {
				return this._mode;
			}

			public static class Feature {

				private String _name;

				private String _policy;

				public Feature() {
					this._name = "vme";
					this._policy = "require";

				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void set_policy(String _policy) {
					this._policy = _policy;
				}

				public String get_policy() {
					return this._policy;
				}
			}

			public static class Model {

				private String _fallback;

				private String text;

				public Model() {
					this._fallback = "forbid";
					this.text = "Broadwell_noTSX_IBRS";

				}

				public void set_fallback(String _fallback) {
					this._fallback = _fallback;
				}

				public String get_fallback() {
					return this._fallback;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}
		}

		public static class Clock {

			private ArrayList<Timer> timer;

			private String _offset;

			public Clock() {
				this._offset = "utc";

			}

			public void setTimer(ArrayList<Timer> timer) {
				this.timer = timer;
			}

			public ArrayList<Timer> getTimer() {
				return this.timer;
			}

			public void set_offset(String _offset) {
				this._offset = _offset;
			}

			public String get_offset() {
				return this._offset;
			}

			public static class Timer {

				private String _name;

				private String _tickpolicy;

				public Timer() {
					this._name = "rtc";
					this._tickpolicy = "catchup";

				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void set_tickpolicy(String _tickpolicy) {
					this._tickpolicy = _tickpolicy;
				}

				public String get_tickpolicy() {
					return this._tickpolicy;
				}
			}
		}

		public static class Features {

			private Vmport vmport;

			public Features() {
				this.vmport = new Vmport();

			}

			public void setVmport(Vmport vmport) {
				this.vmport = vmport;
			}

			public Vmport getVmport() {
				return this.vmport;
			}

			public static class Vmport {

				private String _state;

				public Vmport() {
					this._state = "off";

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}
		}

		public static class CurrentMemory {

			private String _unit;

			private String text;

			public CurrentMemory() {
				this._unit = "KiB";
				this.text = "2097152";

			}

			public void set_unit(String _unit) {
				this._unit = _unit;
			}

			public String get_unit() {
				return this._unit;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Pm {

			private Suspend_to_disk suspend_to_disk;

			private Suspend_to_mem suspend_to_mem;

			public Pm() {
				this.suspend_to_disk = new Suspend_to_disk();
				this.suspend_to_mem = new Suspend_to_mem();

			}

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

			public static class Suspend_to_disk {

				private String _enabled;

				public Suspend_to_disk() {
					this._enabled = "no";

				}

				public void set_enabled(String _enabled) {
					this._enabled = _enabled;
				}

				public String get_enabled() {
					return this._enabled;
				}
			}

			public static class Suspend_to_mem {

				private String _enabled;

				public Suspend_to_mem() {
					this._enabled = "no";

				}

				public void set_enabled(String _enabled) {
					this._enabled = _enabled;
				}

				public String get_enabled() {
					return this._enabled;
				}
			}
		}
	}
}