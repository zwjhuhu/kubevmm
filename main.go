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
	domain  := libvirtxml.Domain{}
	objType := reflect.TypeOf(domain)
	fmt.Println(analyser.Analyse(objType, "domain"))
}
