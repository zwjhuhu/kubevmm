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

The resources themselves are not enough to launch virtual machines.
For this to happen the _functionality and business logic_ needs to be added to
the cluster. The functionality is not added to Kubernetes itself, but rather
added to a Kubernetes cluster by _running_ additional controllers and agents
on an existing cluster.

The necessary controllers and agents are provided by KubeVirt.

As of today KubeVirt can be used to declaratively

 * Create a predefined VM
 * Schedule a VM on a Kubernetes cluster
 * Launch a VM
 * Stop a VM
 * Delete a VM


# To start using KubeVirt

Try our quickstart at [kubevirt.io](http://kubevirt.io/get_kubevirt/).

See our user documentation at [kubevirt.io/docs](http://kubevirt.io/user-guide).

# To start developing KubeVirt

To set up a development environment please read our
[Getting Started Guide](docs/getting-started.md). To learn how to contribute, please read our [contribution guide](https://github.com/kubevirt/kubevirt/blob/master/CONTRIBUTING.md).

You can learn more about how KubeVirt is designed (and why it is that way),
and learn more about the major components by taking a look at
[our developer documentation](docs/):

 * [Architecture](docs/architecture.md) - High-level view on the architecture
 * [Components](docs/components.md) - Detailed look at all components
 * [API Reference](https://www.kubevirt.io/api-reference/)


## Related resources

 * [Kubernetes][k8s]
 * [Libvirt][libvirt]
 * [Cockpit][cockpit]
 * [Kubevirt-ansible][kubevirt-ansible]


## (Reference links)
   [k8s]: https://kubernetes.io
   [crd]: https://kubernetes.io/docs/tasks/access-kubernetes-api/extend-api-custom-resource-definitions/
   [ovirt]: https://www.ovirt.org
   [cockpit]: https://cockpit-project.org/
   [libvirt]: https://www.libvirt.org
