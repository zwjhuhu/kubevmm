/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package main

import (
	"fmt"
	"github.com/kubesys/kubevirt/analyser"
	libvirtxml "github.com/libvirt/libvirt-go-xml"
	"reflect"
)

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since 2019/4/26
 *
 */



func main() {
	xmlDesc(reflect.TypeOf(libvirtxml.Domain{}), "domain")
	xmlDesc(reflect.TypeOf(libvirtxml.Network{}), "network")
	xmlDesc(reflect.TypeOf(libvirtxml.StoragePool{}), "pool")
	xmlDesc(reflect.TypeOf(libvirtxml.DomainSnapshot{}), "domainsnapshot")
}

func xmlDesc(objType reflect.Type, tag string)  {
	fmt.Println(analyser.Analyse(objType, tag))
}
