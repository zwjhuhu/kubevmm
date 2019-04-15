## Backgroud

Kubernetes's Custom Resource Definitions (CRD) API can create a new RESTful resource path for each version you specify.
If you plan to extend kubernetes to support VirtualMachine, you have to design a new CRD named [vm-resource.yaml](vm-resource.yaml).

```
kubectl apply -f vm-resource.yaml
```

Then, you can create a new kind named virtualmachine with the specified content described in [libvirt-json.md](libvirt-json.md)
. For example:

```
apiVersion: cloudplus.io/v1alpha3
kind: VirtualMachine
metadata:
  name: testvmi-nocloud
spec:
  terminationGracePeriodSeconds: 30
  domain:
    resources:
      requests:
        memory: 1024M
    devices:
      disks:
      - name: containerdisk
        disk:
          bus: virtio
      - name: emptydisk
        disk:
          bus: virtio
      - disk:
          bus: virtio
        name: cloudinitdisk
  volumes:
  - name: containerdisk
    containerDisk:
      image: kubevirt/fedora-cloud-container-disk-demo:latest
  - name: emptydisk
    emptyDisk:
      capacity: "2Gi"
  - name: cloudinitdisk
    cloudInitNoCloud:
      userData: |-
        #cloud-config
        password: fedora
        chpasswd: { expire: False }
```

This example would create a new virtual machine with the following steps:
- this VM with json description would first go to [cloudplus-scheduler](../scheduler). Then, scheduler register the relationship between VM and Node to api-server.
- Each node listens to the api-server though [virtctl](../virtctl). Then, it start the VM using libvirt 
