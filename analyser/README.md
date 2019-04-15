## Backgroud

In order to describe the XML schemas of libvirt, we design an algorithm based on [libvirt-go-xml](https://github.com/libvirt/libvirt-go-xml) to generate it. 
Please see [libvirt-xml.md](../docs/libvirt-xml.md) and [libvirt-json.md](../docs/libvirt-json.md).

In addition, we find that libvirt-go-xml is still not 'production ready'. So we plan to implement a kubernetes-based VM maangement platform
with [libvirt-python](https://github.com/libvirt/libvirt-python), which is used by [OpenStack](https://www.openstack.org)
