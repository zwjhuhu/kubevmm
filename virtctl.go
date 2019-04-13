/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package main

import (
	"fmt"
	"github.com/libvirt/libvirt-go"
)


/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since 2019/4/10
 *
 */
func main() {

	conn, _ := libvirt.NewConnect("qemu:///system")
	domIds, _ := conn.ListDomains()
	for _, domId := range domIds {
		dom, _ := conn.LookupDomainById(domId)
		fmt.Println(dom.GetXMLDesc(0))
	}

}
