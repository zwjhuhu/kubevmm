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


# To start developing KubeVirt

You can learn more about how KubeVirt is designed (and why it is that way),
and learn more about the major components by taking a look at
[our developer documentation](docs/):

 * [Architecture]() - High-level view on the architecture
 * [Components]() - Detailed look at all components
 * [API Reference]()


## (Reference links)
   [k8s]: https://kubernetes.io
   [crd]: https://kubernetes.io/docs/tasks/access-kubernetes-api/extend-api-custom-resource-definitions/
   [libvirt]: https://www.libvirt.org
   [kubedev]: https://github.com/kubesys/kubedev
