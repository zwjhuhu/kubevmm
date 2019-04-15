/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package main

import (
	"fmt"
	"github.com/libvirt/libvirt-go-xml"
	"reflect"
)

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since 2019/4/14
 *
 * go get github.com/libvirt/libvirt-go
 * go get github.com/libvirt/libvirt-go-xml
 * go get github.com/kubesys/kubevirt
 */

 func main() {
 	fmt.Println(analyser.DoAnalyse(reflect.TypeOf(libvirtxml.DomainSnapshot{})))
 }




