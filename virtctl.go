/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package main

import (
	"fmt"
	"github.com/libvirt/libvirt-go-xml"
	"reflect"
	"strings"
)

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since 2019/4/14
 *
 */

 func main() {


 	//domcfg := libvirtxml.Domain{}
 	fmt.Println(DoAnalyse(reflect.TypeOf(libvirtxml.DomainVideo{})))
 	//fmt.Println(DoAnalyse(reflect.TypeOf(domcfg)))

 }

func DoAnalyse(objType reflect.Type) (string) {

	xmlinfo  := ""
	endelem  := ""
	previous := ""

	for i := 0; i < objType.NumField(); i++ {
		field := objType.Field(i)
		//fmt.Printf("%s: %v = %v: %s\n", field.Name, field.Type, field.Tag)
		xmlTag := field.Tag.Get("xml")
		//if strings.Contains(xmlTag, "omitempty") ||
		if len(xmlTag) == 0  || strings.EqualFold(xmlTag, "-"){
			continue
		} else if strings.Contains(xmlTag, "attr") {
			if previous == "" {
				//fmt.Println(str + "%s=%s", objType, xmlTag)
				continue
			}

			old :=  previous
			new :=  previous[0:len(previous)-1] + " " +
						strings.Split(xmlTag, ",")[0] +
						"=\"" + field.Type.String() + "\">"
			xmlinfo = strings.Replace(xmlinfo, old, new, -1)
			previous = new
		} else {

			if !strings.Contains(xmlinfo, previous) {
				xmlinfo += previous
			}

			if len(endelem) == 0 {
				if !strings.Contains(xmlTag, ",") {
					endelem  = "</" + xmlTag + ">"
					previous = "<" + xmlTag + ">"
					xmlinfo  = "<" + xmlTag + ">"
				} else {
					xmlTag = xmlTag[1: ]
					endelem  = "</" + xmlTag + ">"
					previous = "<" + xmlTag + ">"
					xmlinfo  = "<" + xmlTag + ">"
				}
			} else {

				if strings.Contains(field.Type.String(), "libvirtxml") {
					name := field.Type.String()
					if strings.Contains(name, "*") {
						previous = DoAnalyse(reflect.TypeOf(reflect.New(field.Type.Elem()).Elem().Interface()))
					} else if strings.Contains(name, "[]") {
						fmt.Println(reflect.New(field.Type.Elem()).Elem().Type())
						previous = DoAnalyse(reflect.New(field.Type.Elem()).Elem().Type())
					} else {
						previous = DoAnalyse(reflect.TypeOf(reflect.New(field.Type).Elem().Interface()))
					}
				} else {
					previous = "<" + xmlTag + ">" +
						field.Type.String() +
						"</" + xmlTag + ">"
				}

			}

		}
	}

	if len(xmlinfo) == 0 {
		return previous + endelem
	} else {
		return xmlinfo + endelem
	}
}


