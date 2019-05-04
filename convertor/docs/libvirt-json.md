# Json style

As described in [Kubernetes](https://kubernetes.io/). The input with yaml style must convert to json style (Kubernetes's annotation)


- 'interface' to '_interface'
- '$' to 'text'
- '@' to '_'

## domain.json

```
{
    "domain": {
        "_id": "string",
        "_type": "string",
        "blkiotune": {
            "device": [
                {
                    "path": {
                        "text": "string"
                    },
                    "read_bytes_sec": {
                        "text": "string"
                    },
                    "read_iops_sec": {
                        "text": "string"
                    },
                    "weight": {
                        "text": "string"
                    },
                    "write_bytes_sec": {
                        "text": "string"
                    },
                    "write_iops_sec": {
                        "text": "string"
                    }
                },
                {
                    "path": {
                        "text": "string"
                    },
                    "read_bytes_sec": {
                        "text": "string"
                    },
                    "read_iops_sec": {
                        "text": "string"
                    },
                    "weight": {
                        "text": "string"
                    },
                    "write_bytes_sec": {
                        "text": "string"
                    },
                    "write_iops_sec": {
                        "text": "string"
                    }
                }
            ],
            "weight": {
                "text": "string"
            }
        },
        "bootloader": {
            "text": "string"
        },
        "bootloader_args": {
            "text": "string"
        },
        "clock": {
            "_adjustment": "string",
            "_basis": "string",
            "_offset": "string",
            "_timezone": "string",
            "timer": [
                {
                    "_frequency": "string",
                    "_mode": "string",
                    "_name": "string",
                    "_present": "string",
                    "_tickpolicy": "string",
                    "_track": "string",
                    "catchup": {
                        "_limit": "string",
                        "_slew": "string",
                        "_threshold": "string"
                    }
                },
                {
                    "_frequency": "string",
                    "_mode": "string",
                    "_name": "string",
                    "_present": "string",
                    "_tickpolicy": "string",
                    "_track": "string",
                    "catchup": {
                        "_limit": "string",
                        "_slew": "string",
                        "_threshold": "string"
                    }
                }
            ]
        },
        "cpu": {
            "_check": "string",
            "_match": "string",
            "_mode": "string",
            "cache": {
                "_level": "string",
                "_mode": "string"
            },
            "feature": [
                {
                    "_name": "string",
                    "_policy": "string"
                },
                {
                    "_name": "string",
                    "_policy": "string"
                }
            ],
            "model": {
                "text": "string",
                "_fallback": "string",
                "_vendor_id": "string"
            },
            "numa": {
                "cell": [
                    {
                        "_cpus": "string",
                        "_discard": "string",
                        "_id": "string",
                        "_memAccess": "string",
                        "_memory": "string",
                        "_unit": "string",
                        "distances": {
                            "sibling": [
                                {
                                    "_id": "string",
                                    "_value": "string"
                                },
                                {
                                    "_id": "string",
                                    "_value": "string"
                                }
                            ]
                        }
                    },
                    {
                        "_cpus": "string",
                        "_discard": "string",
                        "_id": "string",
                        "_memAccess": "string",
                        "_memory": "string",
                        "_unit": "string",
                        "distances": {
                            "sibling": [
                                {
                                    "_id": "string",
                                    "_value": "string"
                                },
                                {
                                    "_id": "string",
                                    "_value": "string"
                                }
                            ]
                        }
                    }
                ]
            },
            "topology": {
                "_cores": "string",
                "_sockets": "string",
                "_threads": "string"
            },
            "vendor": {
                "text": "string"
            }
        },
        "cputune": {
            "cachetune": [
                {
                    "_vcpus": "string",
                    "cache": [
                        {
                            "_id": "string",
                            "_level": "string",
                            "_size": "string",
                            "_type": "string",
                            "_unit": "string"
                        },
                        {
                            "_id": "string",
                            "_level": "string",
                            "_size": "string",
                            "_type": "string",
                            "_unit": "string"
                        }
                    ],
                    "monitor": [
                        {
                            "_level": "string",
                            "_vcpus": "string"
                        },
                        {
                            "_level": "string",
                            "_vcpus": "string"
                        }
                    ]
                },
                {
                    "_vcpus": "string",
                    "cache": [
                        {
                            "_id": "string",
                            "_level": "string",
                            "_size": "string",
                            "_type": "string",
                            "_unit": "string"
                        },
                        {
                            "_id": "string",
                            "_level": "string",
                            "_size": "string",
                            "_type": "string",
                            "_unit": "string"
                        }
                    ],
                    "monitor": [
                        {
                            "_level": "string",
                            "_vcpus": "string"
                        },
                        {
                            "_level": "string",
                            "_vcpus": "string"
                        }
                    ]
                }
            ],
            "emulator_period": {
                "text": "string"
            },
            "emulator_quota": {
                "text": "string"
            },
            "emulatorpin": {
                "_cpuset": "string"
            },
            "global_period": {
                "text": "string"
            },
            "global_quota": {
                "text": "string"
            },
            "iothread_period": {
                "text": "string"
            },
            "iothread_quota": {
                "text": "string"
            },
            "iothreadpin": [
                {
                    "_cpuset": "string",
                    "_iothread": "string"
                },
                {
                    "_cpuset": "string",
                    "_iothread": "string"
                }
            ],
            "iothreadsched": [
                {
                    "_iothreads": "string",
                    "_priority": "string",
                    "_scheduler": "string"
                },
                {
                    "_iothreads": "string",
                    "_priority": "string",
                    "_scheduler": "string"
                }
            ],
            "memorytune": [
                {
                    "_vcpus": "string",
                    "node": [
                        {
                            "_bandwidth": "string",
                            "_id": "string"
                        },
                        {
                            "_bandwidth": "string",
                            "_id": "string"
                        }
                    ]
                },
                {
                    "_vcpus": "string",
                    "node": [
                        {
                            "_bandwidth": "string",
                            "_id": "string"
                        },
                        {
                            "_bandwidth": "string",
                            "_id": "string"
                        }
                    ]
                }
            ],
            "period": {
                "text": "string"
            },
            "quota": {
                "text": "string"
            },
            "shares": {
                "text": "string"
            },
            "vcpupin": [
                {
                    "_cpuset": "string",
                    "_vcpu": "string"
                },
                {
                    "_cpuset": "string",
                    "_vcpu": "string"
                }
            ],
            "vcpusched": [
                {
                    "_priority": "string",
                    "_scheduler": "string",
                    "_vcpus": "string"
                },
                {
                    "_priority": "string",
                    "_scheduler": "string",
                    "_vcpus": "string"
                }
            ]
        },
        "currentMemory": {
            "text": "string",
            "_unit": "string"
        },
        "description": {
            "text": "string"
        },
        "devices": {
            "channel": [
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {}
                },
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {}
                }
            ],
            "console": [
                {
                    "_tty": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {
                        "_port": "string",
                        "_type": "string"
                    }
                },
                {
                    "_tty": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {
                        "_port": "string",
                        "_type": "string"
                    }
                }
            ],
            "controller": [
                {
                    "_index": "string",
                    "_model": "string",
                    "_type": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_cmd_per_lun": "string",
                        "_ioeventfd": "string",
                        "_iommu": "string",
                        "_iothread": "string",
                        "_max_sectors": "string",
                        "_queues": "string"
                    }
                },
                {
                    "_index": "string",
                    "_model": "string",
                    "_type": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_cmd_per_lun": "string",
                        "_ioeventfd": "string",
                        "_iommu": "string",
                        "_iothread": "string",
                        "_max_sectors": "string",
                        "_queues": "string"
                    }
                }
            ],
            "disk": [
                {
                    "_device": "string",
                    "_model": "string",
                    "_rawio": "string",
                    "_sgio": "string",
                    "_snapshot": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "auth": {
                        "_username": "string",
                        "secret": {
                            "_type": "string",
                            "_usage": "string",
                            "_uuid": "string"
                        }
                    },
                    "backingStore": {
                        "_index": "string",
                        "format": {
                            "_type": "string"
                        },
                        "source": {
                            "_index": "string",
                            "_startupPolicy": "string",
                            "encryption": {
                                "_format": "string",
                                "secret": {
                                    "_type": "string",
                                    "_usage": "string",
                                    "_uuid": "string"
                                }
                            },
                            "reservations": {
                                "_enabled": "string",
                                "_managed": "string",
                                "source": {}
                            }
                        }
                    },
                    "blockio": {
                        "_logical_block_size": "string",
                        "_physical_block_size": "string"
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_cache": "string",
                        "_copy_on_read": "string",
                        "_detect_zeroes": "string",
                        "_discard": "string",
                        "_error_policy": "string",
                        "_event_idx": "string",
                        "_io": "string",
                        "_ioeventfd": "string",
                        "_iommu": "string",
                        "_iothread": "string",
                        "_name": "string",
                        "_queues": "string",
                        "_rerror_policy": "string",
                        "_type": "string"
                    },
                    "encryption": {
                        "_format": "string",
                        "secret": {
                            "_type": "string",
                            "_usage": "string",
                            "_uuid": "string"
                        }
                    },
                    "geometry": {
                        "_cyls": "string",
                        "_heads": "string",
                        "_secs": "string",
                        "_trans": "string"
                    },
                    "iotune": {
                        "group_name": {
                            "text": "string"
                        },
                        "read_bytes_sec": {
                            "text": "string"
                        },
                        "read_bytes_sec_max": {
                            "text": "string"
                        },
                        "read_bytes_sec_max_length": {
                            "text": "string"
                        },
                        "read_iops_sec": {
                            "text": "string"
                        },
                        "read_iops_sec_max": {
                            "text": "string"
                        },
                        "read_iops_sec_max_length": {
                            "text": "string"
                        },
                        "size_iops_sec": {
                            "text": "string"
                        },
                        "total_bytes_sec": {
                            "text": "string"
                        },
                        "total_bytes_sec_max": {
                            "text": "string"
                        },
                        "total_bytes_sec_max_length": {
                            "text": "string"
                        },
                        "total_iops_sec": {
                            "text": "string"
                        },
                        "total_iops_sec_max": {
                            "text": "string"
                        },
                        "total_iops_sec_max_length": {
                            "text": "string"
                        },
                        "write_bytes_sec": {
                            "text": "string"
                        },
                        "write_bytes_sec_max": {
                            "text": "string"
                        },
                        "write_bytes_sec_max_length": {
                            "text": "string"
                        },
                        "write_iops_sec": {
                            "text": "string"
                        },
                        "write_iops_sec_max": {
                            "text": "string"
                        },
                        "write_iops_sec_max_length": {
                            "text": "string"
                        }
                    },
                    "mirror": {
                        "_job": "string",
                        "_ready": "string",
                        "format": {
                            "_type": "string"
                        },
                        "source": {
                            "_index": "string",
                            "_startupPolicy": "string",
                            "encryption": {
                                "_format": "string",
                                "secret": {
                                    "_type": "string",
                                    "_usage": "string",
                                    "_uuid": "string"
                                }
                            },
                            "reservations": {
                                "_enabled": "string",
                                "_managed": "string",
                                "source": {}
                            }
                        }
                    },
                    "product": {
                        "text": "string"
                    },
                    "readonly": {},
                    "serial": {
                        "text": "string"
                    },
                    "shareable": {},
                    "source": {
                        "_index": "string",
                        "_startupPolicy": "string",
                        "encryption": {
                            "_format": "string",
                            "secret": {
                                "_type": "string",
                                "_usage": "string",
                                "_uuid": "string"
                            }
                        },
                        "reservations": {
                            "_enabled": "string",
                            "_managed": "string",
                            "source": {}
                        }
                    },
                    "target": {
                        "_bus": "string",
                        "_dev": "string",
                        "_removable": "string",
                        "_tray": "string"
                    },
                    "transient": {},
                    "vendor": {
                        "text": "string"
                    },
                    "wwn": {
                        "text": "string"
                    }
                },
                {
                    "_device": "string",
                    "_model": "string",
                    "_rawio": "string",
                    "_sgio": "string",
                    "_snapshot": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "auth": {
                        "_username": "string",
                        "secret": {
                            "_type": "string",
                            "_usage": "string",
                            "_uuid": "string"
                        }
                    },
                    "backingStore": {
                        "_index": "string",
                        "format": {
                            "_type": "string"
                        },
                        "source": {
                            "_index": "string",
                            "_startupPolicy": "string",
                            "encryption": {
                                "_format": "string",
                                "secret": {
                                    "_type": "string",
                                    "_usage": "string",
                                    "_uuid": "string"
                                }
                            },
                            "reservations": {
                                "_enabled": "string",
                                "_managed": "string",
                                "source": {}
                            }
                        }
                    },
                    "blockio": {
                        "_logical_block_size": "string",
                        "_physical_block_size": "string"
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_cache": "string",
                        "_copy_on_read": "string",
                        "_detect_zeroes": "string",
                        "_discard": "string",
                        "_error_policy": "string",
                        "_event_idx": "string",
                        "_io": "string",
                        "_ioeventfd": "string",
                        "_iommu": "string",
                        "_iothread": "string",
                        "_name": "string",
                        "_queues": "string",
                        "_rerror_policy": "string",
                        "_type": "string"
                    },
                    "encryption": {
                        "_format": "string",
                        "secret": {
                            "_type": "string",
                            "_usage": "string",
                            "_uuid": "string"
                        }
                    },
                    "geometry": {
                        "_cyls": "string",
                        "_heads": "string",
                        "_secs": "string",
                        "_trans": "string"
                    },
                    "iotune": {
                        "group_name": {
                            "text": "string"
                        },
                        "read_bytes_sec": {
                            "text": "string"
                        },
                        "read_bytes_sec_max": {
                            "text": "string"
                        },
                        "read_bytes_sec_max_length": {
                            "text": "string"
                        },
                        "read_iops_sec": {
                            "text": "string"
                        },
                        "read_iops_sec_max": {
                            "text": "string"
                        },
                        "read_iops_sec_max_length": {
                            "text": "string"
                        },
                        "size_iops_sec": {
                            "text": "string"
                        },
                        "total_bytes_sec": {
                            "text": "string"
                        },
                        "total_bytes_sec_max": {
                            "text": "string"
                        },
                        "total_bytes_sec_max_length": {
                            "text": "string"
                        },
                        "total_iops_sec": {
                            "text": "string"
                        },
                        "total_iops_sec_max": {
                            "text": "string"
                        },
                        "total_iops_sec_max_length": {
                            "text": "string"
                        },
                        "write_bytes_sec": {
                            "text": "string"
                        },
                        "write_bytes_sec_max": {
                            "text": "string"
                        },
                        "write_bytes_sec_max_length": {
                            "text": "string"
                        },
                        "write_iops_sec": {
                            "text": "string"
                        },
                        "write_iops_sec_max": {
                            "text": "string"
                        },
                        "write_iops_sec_max_length": {
                            "text": "string"
                        }
                    },
                    "mirror": {
                        "_job": "string",
                        "_ready": "string",
                        "format": {
                            "_type": "string"
                        },
                        "source": {
                            "_index": "string",
                            "_startupPolicy": "string",
                            "encryption": {
                                "_format": "string",
                                "secret": {
                                    "_type": "string",
                                    "_usage": "string",
                                    "_uuid": "string"
                                }
                            },
                            "reservations": {
                                "_enabled": "string",
                                "_managed": "string",
                                "source": {}
                            }
                        }
                    },
                    "product": {
                        "text": "string"
                    },
                    "readonly": {},
                    "serial": {
                        "text": "string"
                    },
                    "shareable": {},
                    "source": {
                        "_index": "string",
                        "_startupPolicy": "string",
                        "encryption": {
                            "_format": "string",
                            "secret": {
                                "_type": "string",
                                "_usage": "string",
                                "_uuid": "string"
                            }
                        },
                        "reservations": {
                            "_enabled": "string",
                            "_managed": "string",
                            "source": {}
                        }
                    },
                    "target": {
                        "_bus": "string",
                        "_dev": "string",
                        "_removable": "string",
                        "_tray": "string"
                    },
                    "transient": {},
                    "vendor": {
                        "text": "string"
                    },
                    "wwn": {
                        "text": "string"
                    }
                }
            ],
            "emulator": {
                "text": "string"
            },
            "filesystem": [
                {
                    "_accessmode": "string",
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_format": "string",
                        "_iommu": "string",
                        "_name": "string",
                        "_type": "string",
                        "_wrpolicy": "string"
                    },
                    "readonly": {},
                    "source": {},
                    "space_hard_limit": {
                        "text": "string",
                        "_unit": "string"
                    },
                    "space_soft_limit": {
                        "text": "string",
                        "_unit": "string"
                    },
                    "target": {
                        "_dir": "string"
                    }
                },
                {
                    "_accessmode": "string",
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_format": "string",
                        "_iommu": "string",
                        "_name": "string",
                        "_type": "string",
                        "_wrpolicy": "string"
                    },
                    "readonly": {},
                    "source": {},
                    "space_hard_limit": {
                        "text": "string",
                        "_unit": "string"
                    },
                    "space_soft_limit": {
                        "text": "string",
                        "_unit": "string"
                    },
                    "target": {
                        "_dir": "string"
                    }
                }
            ],
            "graphics": [
                {},
                {}
            ],
            "hostdev": [
                {
                    "_managed": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "rom": {
                        "_bar": "string",
                        "_enabled": "string",
                        "_file": "string"
                    }
                },
                {
                    "_managed": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "rom": {
                        "_bar": "string",
                        "_enabled": "string",
                        "_file": "string"
                    }
                }
            ],
            "hub": [
                {
                    "_type": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    }
                },
                {
                    "_type": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    }
                }
            ],
            "input": [
                {
                    "_bus": "string",
                    "_model": "string",
                    "_type": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_iommu": "string"
                    },
                    "source": {
                        "_evdev": "string"
                    }
                },
                {
                    "_bus": "string",
                    "_model": "string",
                    "_type": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_iommu": "string"
                    },
                    "source": {
                        "_evdev": "string"
                    }
                }
            ],
            "_interface": [
                {
                    "_managed": "string",
                    "_trustGuestRxFilters": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "backend": {
                        "_tap": "string",
                        "_vhost": "string"
                    },
                    "bandwidth": {
                        "inbound": {
                            "_average": "string",
                            "_burst": "string",
                            "_floor": "string",
                            "_peak": "string"
                        },
                        "outbound": {
                            "_average": "string",
                            "_burst": "string",
                            "_floor": "string",
                            "_peak": "string"
                        }
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "coalesce": {
                        "rx": {
                            "frames": {
                                "_max": "string"
                            }
                        }
                    },
                    "driver": {
                        "_ats": "string",
                        "_event_idx": "string",
                        "_ioeventfd": "string",
                        "_iommu": "string",
                        "_name": "string",
                        "_queues": "string",
                        "_rx_queue_size": "string",
                        "_tx_queue_size": "string",
                        "_txmode": "string",
                        "guest": {
                            "_csum": "string",
                            "_ecn": "string",
                            "_tso4": "string",
                            "_tso6": "string",
                            "_ufo": "string"
                        },
                        "host": {
                            "_csum": "string",
                            "_ecn": "string",
                            "_gso": "string",
                            "_mrg_rxbuf": "string",
                            "_tso4": "string",
                            "_tso6": "string",
                            "_ufo": "string"
                        }
                    },
                    "filterref": {
                        "_filter": "string",
                        "parameter": [
                            {
                                "_name": "string",
                                "_value": "string"
                            },
                            {
                                "_name": "string",
                                "_value": "string"
                            }
                        ]
                    },
                    "guest": {
                        "_actual": "string",
                        "_dev": "string"
                    },
                    "ip": [
                        {
                            "_address": "string",
                            "_family": "string",
                            "_peer": "string",
                            "_prefix": "string"
                        },
                        {
                            "_address": "string",
                            "_family": "string",
                            "_peer": "string",
                            "_prefix": "string"
                        }
                    ],
                    "link": {
                        "_state": "string"
                    },
                    "mac": {
                        "_address": "string"
                    },
                    "model": {
                        "_type": "string"
                    },
                    "mtu": {
                        "_size": "string"
                    },
                    "rom": {
                        "_bar": "string",
                        "_enabled": "string",
                        "_file": "string"
                    },
                    "route": [
                        {
                            "_address": "string",
                            "_family": "string",
                            "_gateway": "string",
                            "_metric": "string",
                            "_netmask": "string",
                            "_prefix": "string"
                        },
                        {
                            "_address": "string",
                            "_family": "string",
                            "_gateway": "string",
                            "_metric": "string",
                            "_netmask": "string",
                            "_prefix": "string"
                        }
                    ],
                    "script": {
                        "_path": "string"
                    },
                    "source": {},
                    "target": {
                        "_dev": "string"
                    },
                    "tune": {
                        "sndbuf": {
                            "text": "string"
                        }
                    },
                    "virtualport": {
                        "parameters": {}
                    },
                    "vlan": {
                        "_trunk": "string",
                        "tag": [
                            {
                                "_id": "string",
                                "_nativeMode": "string"
                            },
                            {
                                "_id": "string",
                                "_nativeMode": "string"
                            }
                        ]
                    }
                },
                {
                    "_managed": "string",
                    "_trustGuestRxFilters": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "backend": {
                        "_tap": "string",
                        "_vhost": "string"
                    },
                    "bandwidth": {
                        "inbound": {
                            "_average": "string",
                            "_burst": "string",
                            "_floor": "string",
                            "_peak": "string"
                        },
                        "outbound": {
                            "_average": "string",
                            "_burst": "string",
                            "_floor": "string",
                            "_peak": "string"
                        }
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "coalesce": {
                        "rx": {
                            "frames": {
                                "_max": "string"
                            }
                        }
                    },
                    "driver": {
                        "_ats": "string",
                        "_event_idx": "string",
                        "_ioeventfd": "string",
                        "_iommu": "string",
                        "_name": "string",
                        "_queues": "string",
                        "_rx_queue_size": "string",
                        "_tx_queue_size": "string",
                        "_txmode": "string",
                        "guest": {
                            "_csum": "string",
                            "_ecn": "string",
                            "_tso4": "string",
                            "_tso6": "string",
                            "_ufo": "string"
                        },
                        "host": {
                            "_csum": "string",
                            "_ecn": "string",
                            "_gso": "string",
                            "_mrg_rxbuf": "string",
                            "_tso4": "string",
                            "_tso6": "string",
                            "_ufo": "string"
                        }
                    },
                    "filterref": {
                        "_filter": "string",
                        "parameter": [
                            {
                                "_name": "string",
                                "_value": "string"
                            },
                            {
                                "_name": "string",
                                "_value": "string"
                            }
                        ]
                    },
                    "guest": {
                        "_actual": "string",
                        "_dev": "string"
                    },
                    "ip": [
                        {
                            "_address": "string",
                            "_family": "string",
                            "_peer": "string",
                            "_prefix": "string"
                        },
                        {
                            "_address": "string",
                            "_family": "string",
                            "_peer": "string",
                            "_prefix": "string"
                        }
                    ],
                    "link": {
                        "_state": "string"
                    },
                    "mac": {
                        "_address": "string"
                    },
                    "model": {
                        "_type": "string"
                    },
                    "mtu": {
                        "_size": "string"
                    },
                    "rom": {
                        "_bar": "string",
                        "_enabled": "string",
                        "_file": "string"
                    },
                    "route": [
                        {
                            "_address": "string",
                            "_family": "string",
                            "_gateway": "string",
                            "_metric": "string",
                            "_netmask": "string",
                            "_prefix": "string"
                        },
                        {
                            "_address": "string",
                            "_family": "string",
                            "_gateway": "string",
                            "_metric": "string",
                            "_netmask": "string",
                            "_prefix": "string"
                        }
                    ],
                    "script": {
                        "_path": "string"
                    },
                    "source": {},
                    "target": {
                        "_dev": "string"
                    },
                    "tune": {
                        "sndbuf": {
                            "text": "string"
                        }
                    },
                    "virtualport": {
                        "parameters": {}
                    },
                    "vlan": {
                        "_trunk": "string",
                        "tag": [
                            {
                                "_id": "string",
                                "_nativeMode": "string"
                            },
                            {
                                "_id": "string",
                                "_nativeMode": "string"
                            }
                        ]
                    }
                }
            ],
            "iommu": {
                "_model": "string",
                "driver": {
                    "_caching_mode": "string",
                    "_eim": "string",
                    "_intremap": "string",
                    "_iotlb": "string"
                }
            },
            "lease": [
                {
                    "key": {
                        "text": "string"
                    },
                    "lockspace": {
                        "text": "string"
                    },
                    "target": {
                        "_offset": "string",
                        "_path": "string"
                    }
                },
                {
                    "key": {
                        "text": "string"
                    },
                    "lockspace": {
                        "text": "string"
                    },
                    "target": {
                        "_offset": "string",
                        "_path": "string"
                    }
                }
            ],
            "memballoon": {
                "_autodeflate": "string",
                "_model": "string",
                "address": {},
                "alias": {
                    "_name": "string"
                },
                "driver": {
                    "_ats": "string",
                    "_iommu": "string"
                },
                "stats": {
                    "_period": "string"
                }
            },
            "memory": [
                {
                    "_access": "string",
                    "_discard": "string",
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "source": {
                        "alignsize": {
                            "text": "string",
                            "_unit": "string"
                        },
                        "nodemask": {
                            "text": "string"
                        },
                        "pagesize": {
                            "text": "string",
                            "_unit": "string"
                        },
                        "path": {
                            "text": "string"
                        },
                        "pmem": {}
                    },
                    "target": {
                        "label": {
                            "size": {
                                "text": "string",
                                "_unit": "string"
                            }
                        },
                        "node": {
                            "text": "string"
                        },
                        "readonly": {},
                        "size": {
                            "text": "string",
                            "_unit": "string"
                        }
                    }
                },
                {
                    "_access": "string",
                    "_discard": "string",
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "source": {
                        "alignsize": {
                            "text": "string",
                            "_unit": "string"
                        },
                        "nodemask": {
                            "text": "string"
                        },
                        "pagesize": {
                            "text": "string",
                            "_unit": "string"
                        },
                        "path": {
                            "text": "string"
                        },
                        "pmem": {}
                    },
                    "target": {
                        "label": {
                            "size": {
                                "text": "string",
                                "_unit": "string"
                            }
                        },
                        "node": {
                            "text": "string"
                        },
                        "readonly": {},
                        "size": {
                            "text": "string",
                            "_unit": "string"
                        }
                    }
                }
            ],
            "nvram": {
                "address": {},
                "alias": {
                    "_name": "string"
                }
            },
            "panic": [
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    }
                },
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    }
                }
            ],
            "parallel": [
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {
                        "_port": "string",
                        "_type": "string"
                    }
                },
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {
                        "_port": "string",
                        "_type": "string"
                    }
                }
            ],
            "redirdev": [
                {
                    "_bus": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {}
                },
                {
                    "_bus": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "boot": {
                        "_loadparm": "string",
                        "_order": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {}
                }
            ],
            "redirfilter": [
                {
                    "usbdev": [
                        {
                            "_allow": "string",
                            "_class": "string",
                            "_product": "string",
                            "_vendor": "string",
                            "_version": "string"
                        },
                        {
                            "_allow": "string",
                            "_class": "string",
                            "_product": "string",
                            "_vendor": "string",
                            "_version": "string"
                        }
                    ]
                },
                {
                    "usbdev": [
                        {
                            "_allow": "string",
                            "_class": "string",
                            "_product": "string",
                            "_vendor": "string",
                            "_version": "string"
                        },
                        {
                            "_allow": "string",
                            "_class": "string",
                            "_product": "string",
                            "_vendor": "string",
                            "_version": "string"
                        }
                    ]
                }
            ],
            "rng": [
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "backend": {},
                    "driver": {
                        "_ats": "string",
                        "_iommu": "string"
                    },
                    "rate": {
                        "_bytes": "string",
                        "_period": "string"
                    }
                },
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "backend": {},
                    "driver": {
                        "_ats": "string",
                        "_iommu": "string"
                    },
                    "rate": {
                        "_bytes": "string",
                        "_period": "string"
                    }
                }
            ],
            "serial": [
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {
                        "_port": "string",
                        "_type": "string",
                        "model": {
                            "_name": "string"
                        }
                    }
                },
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "log": {
                        "_append": "string",
                        "_file": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {},
                    "target": {
                        "_port": "string",
                        "_type": "string",
                        "model": {
                            "_name": "string"
                        }
                    }
                }
            ],
            "shmem": [
                {
                    "_name": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "model": {
                        "_type": "string"
                    },
                    "msi": {
                        "_enabled": "string",
                        "_ioeventfd": "string",
                        "_vectors": "string"
                    },
                    "server": {
                        "_path": "string"
                    },
                    "size": {
                        "text": "string",
                        "_unit": "string"
                    }
                },
                {
                    "_name": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "model": {
                        "_type": "string"
                    },
                    "msi": {
                        "_enabled": "string",
                        "_ioeventfd": "string",
                        "_vectors": "string"
                    },
                    "server": {
                        "_path": "string"
                    },
                    "size": {
                        "text": "string",
                        "_unit": "string"
                    }
                }
            ],
            "smartcard": [
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "certificate": [
                        {
                            "text": "string"
                        },
                        {
                            "text": "string"
                        }
                    ],
                    "database": {
                        "text": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {}
                },
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "certificate": [
                        {
                            "text": "string"
                        },
                        {
                            "text": "string"
                        }
                    ],
                    "database": {
                        "text": "string"
                    },
                    "protocol": {
                        "_type": "string"
                    },
                    "source": {}
                }
            ],
            "sound": [
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "codec": [
                        {
                            "_type": "string"
                        },
                        {
                            "_type": "string"
                        }
                    ]
                },
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "codec": [
                        {
                            "_type": "string"
                        },
                        {
                            "_type": "string"
                        }
                    ]
                }
            ],
            "tpm": [
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "backend": {}
                },
                {
                    "_model": "string",
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "backend": {}
                }
            ],
            "video": [
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_iommu": "string",
                        "_vgaconf": "string"
                    },
                    "model": {
                        "_heads": "string",
                        "_primary": "string",
                        "_ram": "string",
                        "_type": "string",
                        "_vgamem": "string",
                        "_vram": "string",
                        "_vram64": "string",
                        "acceleration": {
                            "_accel2d": "string",
                            "_accel3d": "string"
                        }
                    }
                },
                {
                    "address": {},
                    "alias": {
                        "_name": "string"
                    },
                    "driver": {
                        "_ats": "string",
                        "_iommu": "string",
                        "_vgaconf": "string"
                    },
                    "model": {
                        "_heads": "string",
                        "_primary": "string",
                        "_ram": "string",
                        "_type": "string",
                        "_vgamem": "string",
                        "_vram": "string",
                        "_vram64": "string",
                        "acceleration": {
                            "_accel2d": "string",
                            "_accel3d": "string"
                        }
                    }
                }
            ],
            "vsock": {
                "_model": "string",
                "address": {},
                "alias": {
                    "_name": "string"
                },
                "cid": {
                    "_address": "string",
                    "_auto": "string"
                }
            },
            "watchdog": {
                "_action": "string",
                "_model": "string",
                "address": {},
                "alias": {
                    "_name": "string"
                }
            }
        },
        "features": {
            "acpi": {},
            "apic": {
                "_eoi": "string"
            },
            "capabilities": {
                "_policy": "string",
                "audit_control": {
                    "_state": "string"
                },
                "audit_write": {
                    "_state": "string"
                },
                "block_suspend": {
                    "_state": "string"
                },
                "chown": {
                    "_state": "string"
                },
                "dac_override": {
                    "_state": "string"
                },
                "dac_read_Search": {
                    "_state": "string"
                },
                "fowner": {
                    "_state": "string"
                },
                "fsetid": {
                    "_state": "string"
                },
                "ipc_lock": {
                    "_state": "string"
                },
                "ipc_owner": {
                    "_state": "string"
                },
                "kill": {
                    "_state": "string"
                },
                "lease": {
                    "_state": "string"
                },
                "linux_immutable": {
                    "_state": "string"
                },
                "mac_admin": {
                    "_state": "string"
                },
                "mac_override": {
                    "_state": "string"
                },
                "mknod": {
                    "_state": "string"
                },
                "net_admin": {
                    "_state": "string"
                },
                "net_bind_service": {
                    "_state": "string"
                },
                "net_broadcast": {
                    "_state": "string"
                },
                "net_raw": {
                    "_state": "string"
                },
                "setfcap": {
                    "_state": "string"
                },
                "setgid": {
                    "_state": "string"
                },
                "setpcap": {
                    "_state": "string"
                },
                "setuid": {
                    "_state": "string"
                },
                "sys_admin": {
                    "_state": "string"
                },
                "sys_boot": {
                    "_state": "string"
                },
                "sys_chroot": {
                    "_state": "string"
                },
                "sys_module": {
                    "_state": "string"
                },
                "sys_nice": {
                    "_state": "string"
                },
                "sys_pacct": {
                    "_state": "string"
                },
                "sys_ptrace": {
                    "_state": "string"
                },
                "sys_rawio": {
                    "_state": "string"
                },
                "sys_resource": {
                    "_state": "string"
                },
                "sys_time": {
                    "_state": "string"
                },
                "sys_tty_config": {
                    "_state": "string"
                },
                "syslog": {
                    "_state": "string"
                },
                "wake_alarm": {
                    "_state": "string"
                }
            },
            "gic": {
                "_version": "string"
            },
            "hap": {
                "_state": "string"
            },
            "hpt": {
                "_resizing": "string",
                "maxpagesize": {
                    "text": "string",
                    "_unit": "string"
                }
            },
            "htm": {
                "_state": "string"
            },
            "hyperv": {
                "evmcs": {
                    "_state": "string"
                },
                "frequencies": {
                    "_state": "string"
                },
                "ipi": {
                    "_state": "string"
                },
                "reenlightenment": {
                    "_state": "string"
                },
                "relaxed": {
                    "_state": "string"
                },
                "reset": {
                    "_state": "string"
                },
                "runtime": {
                    "_state": "string"
                },
                "spinlocks": {
                    "_retries": "string"
                },
                "stimer": {
                    "_state": "string"
                },
                "synic": {
                    "_state": "string"
                },
                "tlbflush": {
                    "_state": "string"
                },
                "vapic": {
                    "_state": "string"
                },
                "vendor_id": {
                    "_value": "string"
                },
                "vpindex": {
                    "_state": "string"
                }
            },
            "ioapic": {
                "_driver": "string"
            },
            "kvm": {
                "hidden": {
                    "_state": "string"
                }
            },
            "msrs": {
                "_unknown": "string"
            },
            "nested-hv": {
                "_state": "string"
            },
            "pae": {},
            "pmu": {
                "_state": "string"
            },
            "privnet": {},
            "pvspinlock": {
                "_state": "string"
            },
            "smm": {
                "_state": "string",
                "tseg": {
                    "text": "string",
                    "_unit": "string"
                }
            },
            "viridian": {},
            "vmcoreinfo": {
                "_state": "string"
            },
            "vmport": {
                "_state": "string"
            }
        },
        "genid": {
            "text": "string"
        },
        "idmap": {
            "gid": [
                {
                    "_count": "string",
                    "_start": "string",
                    "_target": "string"
                },
                {
                    "_count": "string",
                    "_start": "string",
                    "_target": "string"
                }
            ],
            "uid": [
                {
                    "_count": "string",
                    "_start": "string",
                    "_target": "string"
                },
                {
                    "_count": "string",
                    "_start": "string",
                    "_target": "string"
                }
            ]
        },
        "iothreadids": {
            "iothread": [
                {
                    "_id": "string"
                },
                {
                    "_id": "string"
                }
            ]
        },
        "iothreads": {
            "text": "string"
        },
        "keywrap": {
            "cipher": [
                {
                    "_name": "string",
                    "_state": "string"
                },
                {
                    "_name": "string",
                    "_state": "string"
                }
            ]
        },
        "launchSecurity": {},
        "maxMemory": {
            "text": "string",
            "_slots": "string",
            "_unit": "string"
        },
        "memory": {
            "text": "string",
            "_dumpCore": "string",
            "_unit": "string"
        },
        "memoryBacking": {
            "access": {
                "_mode": "string"
            },
            "allocation": {
                "_mode": "string"
            },
            "discard": {},
            "hugepages": {
                "page": [
                    {
                        "_nodeset": "string",
                        "_size": "string",
                        "_unit": "string"
                    },
                    {
                        "_nodeset": "string",
                        "_size": "string",
                        "_unit": "string"
                    }
                ]
            },
            "locked": {},
            "nosharepages": {},
            "source": {
                "_type": "string"
            }
        },
        "memtune": {
            "hard_limit": {
                "text": "string",
                "_unit": "string"
            },
            "min_guarantee": {
                "text": "string",
                "_unit": "string"
            },
            "soft_limit": {
                "text": "string",
                "_unit": "string"
            },
            "swap_hard_limit": {
                "text": "string",
                "_unit": "string"
            }
        },
        "metadata": {},
        "name": {
            "text": "string"
        },
        "numatune": {
            "memnode": [
                {
                    "_cellid": "string",
                    "_mode": "string",
                    "_nodeset": "string"
                },
                {
                    "_cellid": "string",
                    "_mode": "string",
                    "_nodeset": "string"
                }
            ],
            "memory": {
                "_mode": "string",
                "_nodeset": "string",
                "_placement": "string"
            }
        },
        "on_crash": {
            "text": "string"
        },
        "on_poweroff": {
            "text": "string"
        },
        "on_reboot": {
            "text": "string"
        },
        "os": {
            "acpi": {
                "table": [
                    {
                        "text": "string",
                        "_type": "string"
                    },
                    {
                        "text": "string",
                        "_type": "string"
                    }
                ]
            },
            "bios": {
                "_rebootTimeout": "string",
                "_useserial": "string"
            },
            "boot": [
                {
                    "_dev": "string"
                },
                {
                    "_dev": "string"
                }
            ],
            "bootmenu": {
                "_enable": "string",
                "_timeout": "string"
            },
            "cmdline": {
                "text": "string"
            },
            "dtb": {
                "text": "string"
            },
            "init": {
                "text": "string"
            },
            "initarg": {
                "text": "string"
            },
            "initdir": {
                "text": "string"
            },
            "initenv": [
                {
                    "text": "string",
                    "_name": "string"
                },
                {
                    "text": "string",
                    "_name": "string"
                }
            ],
            "initgroup": {
                "text": "string"
            },
            "initrd": {
                "text": "string"
            },
            "inituser": {
                "text": "string"
            },
            "kernel": {
                "text": "string"
            },
            "loader": {
                "text": "strin readonly='string' secure='string' type='string'>"
            },
            "nvram": {
                "text": "strin template='string'>"
            },
            "smbios": {
                "_mode": "string"
            },
            "type": {
                "text": "string",
                "_arch": "string",
                "_machine": "string"
            }
        },
        "perf": {
            "event": [
                {
                    "_enabled": "string",
                    "_name": "string"
                },
                {
                    "_enabled": "string",
                    "_name": "string"
                }
            ]
        },
        "pm": {
            "suspend-to-disk": {
                "_enabled": "string"
            },
            "suspend-to-mem": {
                "_enabled": "string"
            }
        },
        "resource": {
            "partition": {
                "text": "string"
            }
        },
        "seclabel": [
            {
                "_model": "string",
                "_relabel": "string",
                "_type": "string",
                "baselabel": {
                    "text": "string"
                },
                "imagelabel": {
                    "text": "string"
                },
                "label": {
                    "text": "string"
                }
            },
            {
                "_model": "string",
                "_relabel": "string",
                "_type": "string",
                "baselabel": {
                    "text": "string"
                },
                "imagelabel": {
                    "text": "string"
                },
                "label": {
                    "text": "string"
                }
            }
        ],
        "sysinfo": {
            "_type": "string",
            "baseBoard": [
                {
                    "entry": [
                        {
                            "text": "string",
                            "_name": "string"
                        },
                        {
                            "text": "string",
                            "_name": "string"
                        }
                    ]
                },
                {
                    "entry": [
                        {
                            "text": "string",
                            "_name": "string"
                        },
                        {
                            "text": "string",
                            "_name": "string"
                        }
                    ]
                }
            ],
            "bios": {
                "entry": [
                    {
                        "text": "string",
                        "_name": "string"
                    },
                    {
                        "text": "string",
                        "_name": "string"
                    }
                ]
            },
            "chassis": {
                "entry": [
                    {
                        "text": "string",
                        "_name": "string"
                    },
                    {
                        "text": "string",
                        "_name": "string"
                    }
                ]
            },
            "memory": [
                {
                    "entry": [
                        {
                            "text": "string",
                            "_name": "string"
                        },
                        {
                            "text": "string",
                            "_name": "string"
                        }
                    ]
                },
                {
                    "entry": [
                        {
                            "text": "string",
                            "_name": "string"
                        },
                        {
                            "text": "string",
                            "_name": "string"
                        }
                    ]
                }
            ],
            "oemStrings": {
                "entry": {
                    "text": "string"
                }
            },
            "processor": [
                {
                    "entry": [
                        {
                            "text": "string",
                            "_name": "string"
                        },
                        {
                            "text": "string",
                            "_name": "string"
                        }
                    ]
                },
                {
                    "entry": [
                        {
                            "text": "string",
                            "_name": "string"
                        },
                        {
                            "text": "string",
                            "_name": "string"
                        }
                    ]
                }
            ],
            "system": {
                "entry": [
                    {
                        "text": "string",
                        "_name": "string"
                    },
                    {
                        "text": "string",
                        "_name": "string"
                    }
                ]
            }
        },
        "title": {
            "text": "string"
        },
        "uuid": {
            "text": "string"
        },
        "vcpu": {
            "text": "string",
            "_cpuset": "string",
            "_current": "string",
            "_placement": "string"
        },
        "vcpus": {
            "vcpu": [
                {
                    "_enabled": "string",
                    "_hotpluggable": "string",
                    "_id": "string",
                    "_order": "string"
                },
                {
                    "_enabled": "string",
                    "_hotpluggable": "string",
                    "_id": "string",
                    "_order": "string"
                }
            ]
        }
    }
}
```

## network.json

```
{
    "network": {
        "_ipv6": "string",
        "_trustGuestRxFilters": "string",
        "bandwidth": {
            "inbound": {
                "_average": "string",
                "_burst": "string",
                "_floor": "string",
                "_peak": "string"
            },
            "outbound": {
                "_average": "string",
                "_burst": "string",
                "_floor": "string",
                "_peak": "string"
            }
        },
        "bridge": {
            "_delay": "string",
            "_macTableManager": "string",
            "_name": "string",
            "_stp": "string",
            "_zone": "string"
        },
        "dns": {
            "_enable": "string",
            "_forwardPlainNames": "string",
            "forwarder": [
                {
                    "_addr": "string",
                    "_domain": "string"
                },
                {
                    "_addr": "string",
                    "_domain": "string"
                }
            ],
            "host": [
                {
                    "_ip": "string",
                    "hostname": [
                        {
                            "text": "string"
                        },
                        {
                            "text": "string"
                        }
                    ]
                },
                {
                    "_ip": "string",
                    "hostname": [
                        {
                            "text": "string"
                        },
                        {
                            "text": "string"
                        }
                    ]
                }
            ],
            "srv": [
                {
                    "_domain": "string",
                    "_port": "string",
                    "_priority": "string",
                    "_protocol": "string",
                    "_service": "string",
                    "_target": "string",
                    "_weight": "string"
                },
                {
                    "_domain": "string",
                    "_port": "string",
                    "_priority": "string",
                    "_protocol": "string",
                    "_service": "string",
                    "_target": "string",
                    "_weight": "string"
                }
            ],
            "txt": [
                {
                    "_name": "string",
                    "_value": "string"
                },
                {
                    "_name": "string",
                    "_value": "string"
                }
            ]
        },
        "domain": {
            "_localOnly": "string",
            "_name": "string"
        },
        "forward": {
            "_dev": "string",
            "_managed": "string",
            "_mode": "string",
            "address": [
                {},
                {}
            ],
            "driver": {
                "_name": "string"
            },
            "_interface": [
                {
                    "_dev": "string"
                },
                {
                    "_dev": "string"
                }
            ],
            "nat": {
                "address": [
                    {
                        "_end": "string",
                        "_start": "string"
                    },
                    {
                        "_end": "string",
                        "_start": "string"
                    }
                ],
                "port": [
                    {
                        "_end": "string",
                        "_start": "string"
                    },
                    {
                        "_end": "string",
                        "_start": "string"
                    }
                ]
            },
            "pf": [
                {
                    "_dev": "string"
                },
                {
                    "_dev": "string"
                }
            ]
        },
        "ip": [
            {
                "_address": "string",
                "_family": "string",
                "_localPtr": "string",
                "_netmask": "string",
                "_prefix": "string",
                "dhcp": {
                    "bootp": [
                        {
                            "_file": "string",
                            "_server": "string"
                        },
                        {
                            "_file": "string",
                            "_server": "string"
                        }
                    ],
                    "host": [
                        {
                            "_id": "string",
                            "_ip": "string",
                            "_mac": "string",
                            "_name": "string"
                        },
                        {
                            "_id": "string",
                            "_ip": "string",
                            "_mac": "string",
                            "_name": "string"
                        }
                    ],
                    "range": [
                        {
                            "_end": "string",
                            "_start": "string"
                        },
                        {
                            "_end": "string",
                            "_start": "string"
                        }
                    ]
                },
                "tftp": {
                    "_root": "string"
                }
            },
            {
                "_address": "string",
                "_family": "string",
                "_localPtr": "string",
                "_netmask": "string",
                "_prefix": "string",
                "dhcp": {
                    "bootp": [
                        {
                            "_file": "string",
                            "_server": "string"
                        },
                        {
                            "_file": "string",
                            "_server": "string"
                        }
                    ],
                    "host": [
                        {
                            "_id": "string",
                            "_ip": "string",
                            "_mac": "string",
                            "_name": "string"
                        },
                        {
                            "_id": "string",
                            "_ip": "string",
                            "_mac": "string",
                            "_name": "string"
                        }
                    ],
                    "range": [
                        {
                            "_end": "string",
                            "_start": "string"
                        },
                        {
                            "_end": "string",
                            "_start": "string"
                        }
                    ]
                },
                "tftp": {
                    "_root": "string"
                }
            }
        ],
        "mac": {
            "_address": "string"
        },
        "metadata": {},
        "mtu": {
            "_size": "string"
        },
        "name": {
            "text": "string"
        },
        "portgroup": [
            {
                "_default": "string",
                "_name": "string",
                "_trustGuestRxFilters": "string",
                "virtualport": {
                    "parameters": {}
                },
                "vlan": {
                    "_trunk": "string",
                    "tag": [
                        {
                            "_id": "string",
                            "_nativeMode": "string"
                        },
                        {
                            "_id": "string",
                            "_nativeMode": "string"
                        }
                    ]
                }
            },
            {
                "_default": "string",
                "_name": "string",
                "_trustGuestRxFilters": "string",
                "virtualport": {
                    "parameters": {}
                },
                "vlan": {
                    "_trunk": "string",
                    "tag": [
                        {
                            "_id": "string",
                            "_nativeMode": "string"
                        },
                        {
                            "_id": "string",
                            "_nativeMode": "string"
                        }
                    ]
                }
            }
        ],
        "route": [
            {
                "_address": "string",
                "_family": "string",
                "_gateway": "string",
                "_metric": "string",
                "_netmask": "string",
                "_prefix": "string"
            },
            {
                "_address": "string",
                "_family": "string",
                "_gateway": "string",
                "_metric": "string",
                "_netmask": "string",
                "_prefix": "string"
            }
        ],
        "uuid": {
            "text": "string"
        },
        "virtualport": {
            "parameters": {}
        },
        "vlan": {
            "_trunk": "string",
            "tag": [
                {
                    "_id": "string",
                    "_nativeMode": "string"
                },
                {
                    "_id": "string",
                    "_nativeMode": "string"
                }
            ]
        }
    }
}
```

## snapshot.json

```
{
    "domainsnapshot": {
        "active": {
            "text": "string"
        },
        "creationTime": {
            "text": "string"
        },
        "description": {
            "text": "string"
        },
        "disks": {
            "disk": [
                {
                    "_name": "string",
                    "_snapshot": "string",
                    "driver": {
                        "_type": "string"
                    },
                    "source": {
                        "_index": "string",
                        "_startupPolicy": "string",
                        "encryption": {
                            "_format": "string",
                            "secret": {
                                "_type": "string",
                                "_usage": "string",
                                "_uuid": "string"
                            }
                        },
                        "reservations": {
                            "_enabled": "string",
                            "_managed": "string",
                            "source": {}
                        }
                    }
                },
                {
                    "_name": "string",
                    "_snapshot": "string",
                    "driver": {
                        "_type": "string"
                    },
                    "source": {
                        "_index": "string",
                        "_startupPolicy": "string",
                        "encryption": {
                            "_format": "string",
                            "secret": {
                                "_type": "string",
                                "_usage": "string",
                                "_uuid": "string"
                            }
                        },
                        "reservations": {
                            "_enabled": "string",
                            "_managed": "string",
                            "source": {}
                        }
                    }
                }
            ]
        },
        "domain": {
            "_id": "string",
            "_type": "string"
        },
        "memory": {
            "_file": "string",
            "_snapshot": "string"
        },
        "name": {
            "text": "string"
        },
        "parent": {
            "name": {
                "text": "string"
            }
        },
        "state": {
            "text": "string"
        }
    }
}
```

## storage.json

```
{
    "pool": {
        "_type": "string",
        "allocation": {
            "text": "string",
            "_unit": "string"
        },
        "available": {
            "text": "string",
            "_unit": "string"
        },
        "capacity": {
            "text": "string",
            "_unit": "string"
        },
        "name": {
            "text": "string"
        },
        "refresh": {
            "volume": {
                "_allocation": "string"
            }
        },
        "source": {
            "adapter": {
                "_managed": "string",
                "_name": "string",
                "_parent": "string",
                "_type": "string",
                "_wwnn": "string",
                "_wwpn": "string",
                "parentaddr": {
                    "_unique_id": "string",
                    "address": {
                        "_bus": "string",
                        "_domain": "string",
                        "_function": "string",
                        "_slot": "string"
                    }
                }
            },
            "auth": {
                "_type": "string",
                "_username": "string",
                "secret": {
                    "_usage": "string",
                    "_uuid": "string"
                }
            },
            "device": [
                {
                    "_part_separator": "string",
                    "_path": "string",
                    "freeExtent": [
                        {
                            "_end": "string",
                            "_start": "string"
                        },
                        {
                            "_end": "string",
                            "_start": "string"
                        }
                    ]
                },
                {
                    "_part_separator": "string",
                    "_path": "string",
                    "freeExtent": [
                        {
                            "_end": "string",
                            "_start": "string"
                        },
                        {
                            "_end": "string",
                            "_start": "string"
                        }
                    ]
                }
            ],
            "dir": {
                "_path": "string"
            },
            "format": {
                "_type": "string"
            },
            "host": [
                {
                    "_name": "string",
                    "_port": "string"
                },
                {
                    "_name": "string",
                    "_port": "string"
                }
            ],
            "initiator": {
                "iqn": {
                    "_name": "string"
                }
            },
            "name": {
                "text": "string"
            },
            "product": {
                "_name": "string"
            },
            "protocol": {
                "_ver": "string"
            },
            "vendor": {
                "_name": "string"
            }
        },
        "target": {
            "encryption": {
                "_format": "string",
                "cipher": {
                    "_hash": "string",
                    "_mode": "string",
                    "_name": "string",
                    "_size": "string"
                },
                "ivgen": {
                    "_hash": "string",
                    "_name": "string"
                },
                "secret": {
                    "_type": "string",
                    "_uuid": "string"
                }
            },
            "path": {
                "text": "string"
            },
            "permissions": {
                "group": {
                    "text": "string"
                },
                "label": {
                    "text": "string"
                },
                "mode": {
                    "text": "string"
                },
                "owner": {
                    "text": "string"
                }
            },
            "timestamps": {
                "atime": {
                    "text": "string"
                },
                "ctime": {
                    "text": "string"
                },
                "mtime": {
                    "text": "string"
                }
            }
        },
        "uuid": {
            "text": "string"
        }
    }
}
```


