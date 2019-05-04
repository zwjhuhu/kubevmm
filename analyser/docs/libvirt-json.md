
## XML 样式

以下libvirt支持的xml形式是由[代码](../analyser)自动生成，可对照[官方文档](https://libvirt.org/docs.html)进行查询,
我们发现libvirt-go-xml官方项目仍有很大改进空间，与官方文档可能有出入


### [Domain.xml](https://libvirt.org/formatdomain.html)

```
{
  "domain": {
    "-type": "string",
    "-id": "*int",
    "name": "string",
    "uuid": "string",
    "title": "string",
    "description": "string",
    "maxMemory": {
      "-unit": "string",
      "-slots": "uint"
    },
    "memory": {
      "-unit": "string",
      "-dumpCore": "string"
    },
    "currentMemory": { "-unit": "string" },
    "blkiotune": {
      "weight": "uint",
      "device": {
        "path": "string",
        "weight": "uint",
        "read_iops_sec": "uint",
        "write_iops_sec": "uint",
        "read_bytes_sec": "uint",
        "write_bytes_sec": "uint"
      }
    },
    "memtune": {
      "hard_limit": { "-unit": "string" },
      "soft_limit": { "-unit": "string" },
      "min_guarantee": { "-unit": "string" },
      "swap_hard_limit": { "-unit": "string" }
    },
    "memoryBacking": {
      "hugepages": {
        "page": {
          "-size": "uint",
          "-unit": "string",
          "-nodeset": "string"
        }
      },
      "source": { "-type": "string" },
      "access": { "-mode": "string" },
      "allocation": { "-mode": "string" }
    },
    "vcpu": {
      "-placement": "string",
      "-cpuset": "string",
      "-current": "string"
    },
    "vcpus": {
      "vcpu": {
        "-id": "*uint",
        "-enabled": "string",
        "-hotpluggable": "string",
        "-order": "*uint"
      }
    },
    "iothreads": "uint",
    "iothreadids": {
      "iothread": { "-id": "uint" }
    },
    "cputune": {
      "vcpupin": {
        "-vcpu": "uint",
        "-cpuset": "string"
      },
      "emulatorpin": { "-cpuset": "string" },
      "iothreadpin": {
        "-iothread": "uint",
        "-cpuset": "string"
      },
      "vcpusched": {
        "-vcpus": "string",
        "-scheduler": "string",
        "-priority": "*int"
      },
      "iothreadsched": {
        "-iothreads": "string",
        "-scheduler": "string",
        "-priority": "*int"
      },
      "cachetune": {
        "-vcpus": "string",
        "cache": {
          "-id": "uint",
          "-level": "uint",
          "-type": "string",
          "-size": "uint",
          "-unit": "string"
        },
        "monitor": {
          "-level": "uint",
          "-vcpus": "string"
        }
      },
      "memorytune": {
        "-vcpus": "string",
        "node": {
          "-id": "uint",
          "-bandwidth": "uint"
        }
      }
    },
    "numatune": {
      "memory": {
        "-mode": "string",
        "-nodeset": "string",
        "-placement": "string"
      },
      "memnode": {
        "-cellid": "uint",
        "-mode": "string",
        "-nodeset": "string"
      }
    },
    "resource": { "partition": "string" },
    "sysinfo": {
      "-type": "string",
      "bios": {
        "entry": { "-name": "string" }
      },
      "system": {
        "entry": { "-name": "string" }
      },
      "baseBoard": {
        "entry": { "-name": "string" }
      },
      "chassis": {
        "entry": { "-name": "string" }
      },
      "processor": {
        "entry": { "-name": "string" }
      },
      "memory": {
        "entry": { "-name": "string" }
      },
      "oemStrings": {
        "entry": "[]string"
      }
    },
    "bootloader": "string",
    "bootloader_args": "string",
    "os": {
      "-firmware": "string",
      "type": {
        "-arch": "string",
        "-machine": "string"
      },
      "init": "string",
      "initarg": "[]string",
      "initenv": { "-name": "string" },
      "initdir": "string",
      "inituser": "string",
      "initgroup": "string",
      "loader": {
        "-readonly": "string",
        "-secure": "string",
        "-type": "string"
      },
      "nvram": { "-template": "string" },
      "kernel": "string",
      "initrd": "string",
      "cmdline": "string",
      "dtb": "string",
      "acpi": {
        "table": { "-type": "string" }
      },
      "boot": { "-dev": "string" },
      "bootmenu": {
        "-enable": "string",
        "-timeout": "string"
      },
      "bios": {
        "-useserial": "string",
        "-rebootTimeout": "*int"
      },
      "smbios": { "-mode": "string" }
    },
    "idmap": {
      "uid": {
        "-start": "uint",
        "-target": "uint",
        "-count": "uint"
      },
      "gid": {
        "-start": "uint",
        "-target": "uint",
        "-count": "uint"
      }
    },
    "features": {
      "apic": { "-eoi": "string" },
      "hap": { "-state": "string" },
      "hyperv": {
        "relaxed": { "-state": "string" },
        "vapic": { "-state": "string" },
        "spinlocks": { "-retries": "uint" },
        "vpindex": { "-state": "string" },
        "runtime": { "-state": "string" },
        "synic": { "-state": "string" },
        "stimer": { "-state": "string" },
        "reset": { "-state": "string" },
        "vendor_id": { "-value": "string" },
        "frequencies": { "-state": "string" },
        "reenlightenment": { "-state": "string" },
        "tlbflush": { "-state": "string" },
        "ipi": { "-state": "string" },
        "evmcs": { "-state": "string" }
      },
      "kvm": {
        "hidden": { "-state": "string" }
      },
      "pvspinlock": { "-state": "string" },
      "pmu": { "-state": "string" },
      "vmport": { "-state": "string" },
      "gic": { "-version": "string" },
      "smm": {
        "-state": "string",
        "tseg": { "-unit": "string" }
      },
      "ioapic": { "-driver": "string" },
      "hpt": {
        "-resizing": "string",
        "maxpagesize": { "-unit": "string" }
      },
      "htm": { "-state": "string" },
      "nested-hv": { "-state": "string" },
      "capabilities": {
        "-policy": "string",
        "audit_control": { "-state": "string" },
        "audit_write": { "-state": "string" },
        "block_suspend": { "-state": "string" },
        "chown": { "-state": "string" },
        "dac_override": { "-state": "string" },
        "dac_read_Search": { "-state": "string" },
        "fowner": { "-state": "string" },
        "fsetid": { "-state": "string" },
        "ipc_lock": { "-state": "string" },
        "ipc_owner": { "-state": "string" },
        "kill": { "-state": "string" },
        "lease": { "-state": "string" },
        "linux_immutable": { "-state": "string" },
        "mac_admin": { "-state": "string" },
        "mac_override": { "-state": "string" },
        "mknod": { "-state": "string" },
        "net_admin": { "-state": "string" },
        "net_bind_service": { "-state": "string" },
        "net_broadcast": { "-state": "string" },
        "net_raw": { "-state": "string" },
        "setgid": { "-state": "string" },
        "setfcap": { "-state": "string" },
        "setpcap": { "-state": "string" },
        "setuid": { "-state": "string" },
        "sys_admin": { "-state": "string" },
        "sys_boot": { "-state": "string" },
        "sys_chroot": { "-state": "string" },
        "sys_module": { "-state": "string" },
        "sys_nice": { "-state": "string" },
        "sys_pacct": { "-state": "string" },
        "sys_ptrace": { "-state": "string" },
        "sys_rawio": { "-state": "string" },
        "sys_resource": { "-state": "string" },
        "sys_time": { "-state": "string" },
        "sys_tty_config": { "-state": "string" },
        "syslog": { "-state": "string" },
        "wake_alarm": { "-state": "string" }
      },
      "vmcoreinfo": { "-state": "string" },
      "msrs": { "-unknown": "string" }
    },
    "cpu": {
      "-match": "string",
      "-mode": "string",
      "-check": "string",
      "model": {
        "-fallback": "string",
        "-vendor_id": "string"
      },
      "vendor": "string",
      "topology": {
        "-sockets": "int",
        "-cores": "int",
        "-threads": "int"
      },
      "cache": {
        "-level": "uint",
        "-mode": "string"
      },
      "feature": {
        "-policy": "string",
        "-name": "string"
      },
      "numa": {
        "cell": {
          "-id": "*uint",
          "-cpus": "string",
          "-memory": "string",
          "-unit": "string",
          "-memAccess": "string",
          "-discard": "string",
          "distances": {
            "sibling": {
              "-id": "uint",
              "-value": "uint"
            }
          }
        }
      }
    },
    "clock": {
      "-offset": "string",
      "-basis": "string",
      "-adjustment": "string",
      "-timezone": "string",
      "timer": {
        "-name": "string",
        "-track": "string",
        "-tickpolicy": "string",
        "-frequency": "uint32",
        "-mode": "string",
        "-present": "string",
        "catchup": {
          "-threshold": "uint",
          "-slew": "uint",
          "-limit": "uint"
        }
      }
    },
    "on_poweroff": "string",
    "on_reboot": "string",
    "on_crash": "string",
    "pm": {
      "suspend-to-mem": { "-enabled": "string" },
      "suspend-to-disk": { "-enabled": "string" }
    },
    "perf": {
      "event": {
        "-name": "string",
        "-enabled": "string"
      }
    },
    "devices": {
      "emulator": "string",
      "disk": {
        "-device": "string",
        "-rawio": "string",
        "-sgio": "string",
        "-snapshot": "string",
        "-model": "string",
        "driver": {
          "-name": "string",
          "-type": "string",
          "-cache": "string",
          "-error_policy": "string",
          "-rerror_policy": "string",
          "-io": "string",
          "-ioeventfd": "string",
          "-event_idx": "string",
          "-copy_on_read": "string",
          "-discard": "string",
          "-iothread": "*uint",
          "-detect_zeroes": "string",
          "-queues": "*uint",
          "-iommu": "string",
          "-ats": "string"
        },
        "auth": {
          "-username": "string",
          "secret": {
            "-type": "string",
            "-usage": "string",
            "-uuid": "string"
          }
        },
        "source": {
          "-startupPolicy": "string",
          "-index": "uint",
          "encryption": {
            "-format": "string",
            "secret": {
              "-type": "string",
              "-usage": "string",
              "-uuid": "string"
            }
          },
          "reservations": {
            "-enabled": "string",
            "-managed": "string"
          }
        },
        "backingStore": {
          "-index": "uint",
          "format": { "-type": "string" },
          "source": {
            "-startupPolicy": "string",
            "-index": "uint",
            "encryption": {
              "-format": "string",
              "secret": {
                "-type": "string",
                "-usage": "string",
                "-uuid": "string"
              }
            },
            "reservations": {
              "-enabled": "string",
              "-managed": "string"
            }
          }
        },
        "geometry": {
          "-cyls": "uint",
          "-heads": "uint",
          "-secs": "uint",
          "-trans": "string"
        },
        "blockio": {
          "-logical_block_size": "uint",
          "-physical_block_size": "uint"
        },
        "mirror": {
          "-job": "string",
          "-ready": "string",
          "format": { "-type": "string" },
          "source": {
            "-startupPolicy": "string",
            "-index": "uint",
            "encryption": {
              "-format": "string",
              "secret": {
                "-type": "string",
                "-usage": "string",
                "-uuid": "string"
              }
            },
            "reservations": {
              "-enabled": "string",
              "-managed": "string"
            }
          },
          "backingStore": {
            "-index": "uint",
            "format": { "-type": "string" },
            "source": {
              "-startupPolicy": "string",
              "-index": "uint",
              "encryption": {
                "-format": "string",
                "secret": {
                  "-type": "string",
                  "-usage": "string",
                  "-uuid": "string"
                }
              },
              "reservations": {
                "-enabled": "string",
                "-managed": "string"
              }
            }
          }
        },
        "target": {
          "-dev": "string",
          "-bus": "string",
          "-tray": "string",
          "-removable": "string"
        },
        "iotune": {
          "total_bytes_sec": "uint64",
          "read_bytes_sec": "uint64",
          "write_bytes_sec": "uint64",
          "total_iops_sec": "uint64",
          "read_iops_sec": "uint64",
          "write_iops_sec": "uint64",
          "total_bytes_sec_max": "uint64",
          "read_bytes_sec_max": "uint64",
          "write_bytes_sec_max": "uint64",
          "total_iops_sec_max": "uint64",
          "read_iops_sec_max": "uint64",
          "write_iops_sec_max": "uint64",
          "total_bytes_sec_max_length": "uint64",
          "read_bytes_sec_max_length": "uint64",
          "write_bytes_sec_max_length": "uint64",
          "total_iops_sec_max_length": "uint64",
          "read_iops_sec_max_length": "uint64",
          "write_iops_sec_max_length": "uint64",
          "size_iops_sec": "uint64",
          "group_name": "string"
        },
        "serial": "string",
        "wwn": "string",
        "vendor": "string",
        "product": "string",
        "boot": {
          "-order": "uint",
          "-loadparm": "string"
        },
        "alias": { "-name": "string" }
      },
      "controller": {
        "-type": "string",
        "-index": "*uint",
        "-model": "string",
        "driver": {
          "-queues": "*uint",
          "-cmd_per_lun": "*uint",
          "-max_sectors": "*uint",
          "-ioeventfd": "string",
          "-iothread": "uint",
          "-iommu": "string",
          "-ats": "string"
        },
        "alias": { "-name": "string" }
      },
      "lease": {
        "lockspace": "string",
        "key": "string",
        "target": {
          "-path": "string",
          "-offset": "uint64"
        }
      },
      "filesystem": {
        "-accessmode": "string",
        "-model": "string",
        "driver": {
          "-type": "string",
          "-format": "string",
          "-name": "string",
          "-wrpolicy": "string",
          "-iommu": "string",
          "-ats": "string"
        },
        "target": { "-dir": "string" },
        "space_hard_limit": { "-unit": "string" },
        "space_soft_limit": { "-unit": "string" },
        "alias": { "-name": "string" }
      },
      "interface": {
        "-managed": "string",
        "-trustGuestRxFilters": "string",
        "mac": { "-address": "string" },
        "boot": {
          "-order": "uint",
          "-loadparm": "string"
        },
        "vlan": {
          "-trunk": "string",
          "tag": {
            "-id": "uint",
            "-nativeMode": "string"
          }
        },
        "virtualport": {
          
        },
        "ip": {
          "-address": "string",
          "-family": "string",
          "-prefix": "uint",
          "-peer": "string"
        },
        "route": {
          "-family": "string",
          "-address": "string",
          "-netmask": "string",
          "-prefix": "uint",
          "-gateway": "string",
          "-metric": "uint"
        },
        "script": { "-path": "string" },
        "target": { "-dev": "string" },
        "guest": {
          "-dev": "string",
          "-actual": "string"
        },
        "model": { "-type": "string" },
        "driver": {
          "-name": "string",
          "-txmode": "string",
          "-ioeventfd": "string",
          "-event_idx": "string",
          "-queues": "uint",
          "-rx_queue_size": "uint",
          "-tx_queue_size": "uint",
          "-iommu": "string",
          "-ats": "string",
          "host": {
            "-csum": "string",
            "-gso": "string",
            "-tso4": "string",
            "-tso6": "string",
            "-ecn": "string",
            "-ufo": "string",
            "-mrg_rxbuf": "string"
          },
          "guest": {
            "-csum": "string",
            "-tso4": "string",
            "-tso6": "string",
            "-ecn": "string",
            "-ufo": "string"
          }
        },
        "backend": {
          "-tap": "string",
          "-vhost": "string"
        },
        "filterref": {
          "-filter": "string",
          "parameter": {
            "-name": "string",
            "-value": "string"
          }
        },
        "tune": { "sndbuf": "uint" },
        "link": { "-state": "string" },
        "mtu": { "-size": "uint" },
        "bandwidth": {
          "inbound": {
            "-average": "*int",
            "-peak": "*int",
            "-burst": "*int",
            "-floor": "*int"
          },
          "outbound": {
            "-average": "*int",
            "-peak": "*int",
            "-burst": "*int",
            "-floor": "*int"
          }
        },
        "coalesce": {
          "rx": {
            "frames": { "-max": "*uint" }
          }
        },
        "rom": {
          "-bar": "string",
          "-file": "string",
          "-enabled": "string"
        },
        "alias": { "-name": "string" }
      },
      "smartcard": {
        "protocol": { "-type": "string" },
        "database": "string",
        "alias": { "-name": "string" }
      },
      "serial": {
        "serial": "xml.Name",
        "protocol": { "-type": "string" },
        "target": {
          "-type": "string",
          "-port": "*uint",
          "model": { "-name": "string" }
        },
        "log": {
          "-file": "string",
          "-append": "string"
        },
        "alias": { "-name": "string" }
      },
      "parallel": {
        "parallel": "xml.Name",
        "protocol": { "-type": "string" },
        "target": {
          "-type": "string",
          "-port": "*uint"
        },
        "log": {
          "-file": "string",
          "-append": "string"
        },
        "alias": { "-name": "string" }
      },
      "console": {
        "-tty": "string",
        "protocol": { "-type": "string" },
        "target": {
          "-type": "string",
          "-port": "*uint"
        },
        "log": {
          "-file": "string",
          "-append": "string"
        },
        "alias": { "-name": "string" }
      },
      "channel": {
        "protocol": { "-type": "string" },
        "log": {
          "-file": "string",
          "-append": "string"
        },
        "alias": { "-name": "string" }
      },
      "input": {
        "-type": "string",
        "-bus": "string",
        "-model": "string",
        "driver": {
          "-iommu": "string",
          "-ats": "string"
        },
        "source": { "-evdev": "string" },
        "alias": { "-name": "string" }
      },
      "tpm": {
        "-model": "string",
        "alias": { "-name": "string" }
      },
      "sound": {
        "-model": "string",
        "codec": { "-type": "string" },
        "alias": { "-name": "string" }
      },
      "video": {
        "model": {
          "-type": "string",
          "-heads": "uint",
          "-ram": "uint",
          "-vram": "uint",
          "-vram64": "uint",
          "-vgamem": "uint",
          "-primary": "string",
          "acceleration": {
            "-accel3d": "string",
            "-accel2d": "string"
          }
        },
        "driver": {
          "-vgaconf": "string",
          "-iommu": "string",
          "-ats": "string"
        },
        "alias": { "-name": "string" }
      },
      "hostdev": {
        "-managed": "string",
        "boot": {
          "-order": "uint",
          "-loadparm": "string"
        },
        "rom": {
          "-bar": "string",
          "-file": "string",
          "-enabled": "string"
        },
        "alias": { "-name": "string" }
      },
      "redirdev": {
        "-bus": "string",
        "protocol": { "-type": "string" },
        "boot": {
          "-order": "uint",
          "-loadparm": "string"
        },
        "alias": { "-name": "string" }
      },
      "redirfilter": {
        "usbdev": {
          "-class": "*uint",
          "-vendor": "*uint",
          "-product": "*uint",
          "-version": "string",
          "-allow": "string"
        }
      },
      "hub": {
        "-type": "string",
        "alias": { "-name": "string" }
      },
      "watchdog": {
        "-model": "string",
        "-action": "string",
        "alias": { "-name": "string" }
      },
      "memballoon": {
        "-model": "string",
        "-autodeflate": "string",
        "driver": {
          "-iommu": "string",
          "-ats": "string"
        },
        "stats": { "-period": "uint" },
        "alias": { "-name": "string" }
      },
      "rng": {
        "-model": "string",
        "driver": {
          "-iommu": "string",
          "-ats": "string"
        },
        "rate": {
          "-bytes": "uint",
          "-period": "uint"
        },
        "alias": { "-name": "string" }
      },
      "nvram": {
        "alias": { "-name": "string" }
      },
      "panic": {
        "-model": "string",
        "alias": { "-name": "string" }
      },
      "shmem": {
        "-name": "string",
        "size": { "-unit": "string" },
        "model": { "-type": "string" },
        "server": { "-path": "string" },
        "msi": {
          "-enabled": "string",
          "-vectors": "uint",
          "-ioeventfd": "string"
        },
        "alias": { "-name": "string" }
      },
      "memory": {
        "-model": "string",
        "-access": "string",
        "-discard": "string",
        "source": {
          "nodemask": "string",
          "pagesize": { "-unit": "string" },
          "path": "string",
          "alignsize": { "-unit": "string" }
        },
        "target": {
          "size": { "-unit": "string" },
          "label": {
            "size": { "-unit": "string" }
          }
        },
        "alias": { "-name": "string" }
      },
      "iommu": {
        "-model": "string",
        "driver": {
          "-intremap": "string",
          "-caching_mode": "string",
          "-eim": "string",
          "-iotlb": "string"
        }
      },
      "vsock": {
        "-model": "string",
        "cid": {
          "-auto": "string",
          "-address": "string"
        },
        "alias": { "-name": "string" }
      }
    },
    "seclabel": {
      "-type": "string",
      "-model": "string",
      "-relabel": "string",
      "label": "string",
      "imagelabel": "string",
      "baselabel": "string"
    },
    "keywrap": {
      "cipher": {
        "-name": "string",
        "-state": "string"
      }
    }
  }
}
```


### [Network xml](https://libvirt.org/formatnetwork.html)

```
{
  "network": {
    "-ipv6": "string",
    "-trustGuestRxFilters": "string",
    "name": "string",
    "uuid": "string",
    "forward": {
      "-mode": "string",
      "-dev": "string",
      "-managed": "string",
      "driver": { "-name": "string" },
      "pf": { "-dev": "string" },
      "nat": {
        "address": {
          "-start": "string",
          "-end": "string"
        },
        "port": {
          "-start": "uint",
          "-end": "uint"
        }
      },
      "interface": { "-dev": "string" }
    },
    "bridge": {
      "-name": "string",
      "-stp": "string",
      "-delay": "string",
      "-macTableManager": "string",
      "-zone": "string"
    },
    "mtu": { "-size": "uint" },
    "mac": { "-address": "string" },
    "domain": {
      "-name": "string",
      "-localOnly": "string"
    },
    "dns": {
      "-enable": "string",
      "-forwardPlainNames": "string",
      "forwarder": {
        "-domain": "string",
        "-addr": "string"
      },
      "txt": {
        "-name": "string",
        "-value": "string"
      },
      "host": { "-ip": "string" },
      "srv": {
        "-service": "string",
        "-protocol": "string",
        "-target": "string",
        "-port": "uint",
        "-priority": "uint",
        "-weight": "uint",
        "-domain": "string"
      }
    },
    "vlan": {
      "-trunk": "string",
      "tag": {
        "-id": "uint",
        "-nativeMode": "string"
      }
    },
    "bandwidth": {
      "inbound": {
        "-average": "*uint",
        "-peak": "*uint",
        "-burst": "*uint",
        "-floor": "*uint"
      },
      "outbound": {
        "-average": "*uint",
        "-peak": "*uint",
        "-burst": "*uint",
        "-floor": "*uint"
      }
    },
    "ip": {
      "-address": "string",
      "-family": "string",
      "-netmask": "string",
      "-prefix": "uint",
      "-localPtr": "string",
      "dhcp": {
        "range": {
          "-start": "string",
          "-end": "string"
        },
        "host": {
          "-id": "string",
          "-mac": "string",
          "-name": "string",
          "-ip": "string"
        },
        "bootp": {
          "-file": "string",
          "-server": "string"
        }
      },
      "tftp": { "-root": "string" }
    },
    "route": {
      "-family": "string",
      "-address": "string",
      "-netmask": "string",
      "-prefix": "uint",
      "-gateway": "string",
      "-metric": "string"
    },
    "virtualport": {
      
    },
    "portgroup": {
      "-name": "string",
      "-default": "string",
      "-trustGuestRxFilters": "string",
      "vlan": {
        "-trunk": "string",
        "tag": {
          "-id": "uint",
          "-nativeMode": "string"
        }
      },
      "virtualport": {
        
      }
    }
  }
}

```

### [storage](https://libvirt.org/formatstorage.html)

```
{
  "pool": {
    "-type": "string",
    "name": "string",
    "uuid": "string",
    "allocation": { "-unit": "string" },
    "capacity": { "-unit": "string" },
    "available": { "-unit": "string" },
    "target": {
      "path": "string",
      "permissions": {
        "owner": "string",
        "group": "string",
        "mode": "string",
        "label": "string"
      },
      "timestamps": {
        "atime": "string",
        "mtime": "string",
        "ctime": "string"
      },
      "encryption": {
        "-format": "string",
        "secret": {
          "-type": "string",
          "-uuid": "string"
        },
        "cipher": {
          "-name": "string",
          "-size": "uint64",
          "-mode": "string",
          "-hash": "string"
        },
        "ivgen": {
          "-name": "string",
          "-hash": "string"
        }
      }
    },
    "source": {
      "name": "string",
      "dir": { "-path": "string" },
      "host": {
        "-name": "string",
        "-port": "string"
      },
      "device": {
        "-path": "string",
        "-part_separator": "string",
        "freeExtent": {
          "-start": "uint64",
          "-end": "uint64"
        }
      },
      "auth": {
        "-type": "string",
        "-username": "string",
        "secret": {
          "-usage": "string",
          "-uuid": "string"
        }
      },
      "vendor": { "-name": "string" },
      "product": { "-name": "string" },
      "format": { "-type": "string" },
      "protocol": { "-ver": "string" },
      "adapter": {
        "-type": "string",
        "-name": "string",
        "-parent": "string",
        "-managed": "string",
        "-wwnn": "string",
        "-wwpn": "string",
        "parentaddr": {
          "-unique_id": "uint64",
          "address": {
            "-domain": "*uint",
            "-bus": "*uint",
            "-slot": "*uint",
            "-function": "*uint"
          }
        }
      },
      "initiator": {
        "iqn": { "-name": "string" }
      }
    },
    "refresh": {
      "volume": { "-allocation": "string" }
    }
  }
}
```

### [Node device](https://libvirt.org/formatsecret.html)

```
{
  "device": {
    "name": "string",
    "path": "string",
    "devnode": { "-type": "string" },
    "parent": "string",
    "driver": { "name": "string" }
  }
}

```

### [Secret](https://libvirt.org/formatsecret.html)

```
{
  "secret": {
    "-ephemeral": "string",
    "-private": "string",
    "description": "string",
    "uuid": "string",
    "usage": {
      "-type": "string",
      "volume": "string",
      "name": "string",
      "target": "string"
    }
  }
}

```

### [Snapshot](https://libvirt.org/formatsnapshot.html)

```
{
  "domainsnapshot": {
    "name": "string",
    "description": "string",
    "state": "string",
    "creationTime": "string",
    "parent": { "name": "string" },
    "memory": {
      "-snapshot": "string",
      "-file": "string"
    },
    "disks": {
      "disk": {
        "-name": "string",
        "-snapshot": "string",
        "driver": { "-type": "string" },
        "source": {
          "-startupPolicy": "string",
          "-index": "uint",
          "encryption": {
            "-format": "string",
            "secret": {
              "-type": "string",
              "-usage": "string",
              "-uuid": "string"
            }
          },
          "reservations": {
            "-enabled": "string",
            "-managed": "string"
          }
        }
      }
    },
    "active": "*uint",
    "domain": "..."
  }
}
```
