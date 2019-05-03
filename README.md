# KubeVirt

**KubeVirt** is a virtual machine management add-on for Kubernetes.
The aim is to provide a common ground for virtualization solutions on top of
Kubernetes.

**Note:** KubeVirt is a heavy work in progress.

# Introduction

## Virtualization extension for Kubernetes

At its core, KubeVirt extends [Kubernetes][k8s] by adding
additional virtualization resource types (especially the `VM` type) through
[Kubernetes's Custom Resource Definitions API][crd].
By using this mechanism, the Kubernetes API can be used to manage these `VM`
resources alongside all other resources Kubernetes provides.

Unlike [kubevirt/kubebirt](https://github.com/kubevirt/kubevirt), we do not
plan to manage VM using the pod model. Instead, we design a new virtctl to
support VM's lifecycle.


# Architecture

![avatar](docs/arch.png)


- **Analyser**: converte libvirt's XML to Kubernetes's YAML, the libvirt's XML is used by [Openstack](https://www.openstack.org/). 
- **Controller**: extend Kubernetes to support VirtualMachine resource
- **Scheduler**:  extend Kubernetes to schedule VirtualMachine
- **Executor**:  manage VM's lifecycle.
- **Parser**: converte Kubernetes's YAML to libvirt's XML.

# Roadmap

- **2019.5**： support VM's lifecycle
- **2019.6**:  support snapshot's lefecycle
- **2019.7**:  support cni, so we can reuse kubernetes's network
