/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package main

import (
	"fmt"
	"k8s.io/libvirt-go"
	"reflect"
)

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since 2019/4/26
 *
 */
func main() {
	domain := libvirt.Domain{}
	fmt.Println(reflect.TypeOf(domain))
	//fmt.Println(analyser.DoAnalyse(reflect.TypeOf(domain)))
}
