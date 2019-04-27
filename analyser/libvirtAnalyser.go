/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package analyser

import (
	"reflect"
	"strings"
)

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since 2019/4/14
 *
 */

func DoAnalyse(objType reflect.Type) (string) {
	return analyse(objType, "", "", "")
}

func analyse(objType reflect.Type, xmlinfo string, previous string, endelem string) (string) {

	for i := 0; i < objType.NumField(); i++ {

		field := objType.Field(i)
		xmlTag := field.Tag.Get("xml")

		if len(endelem) == 0 {
			attr := strings.Split(xmlTag, ",")[0]
			endelem  = "</" + attr  + ">"
			previous = "<" + attr + ">"
			xmlinfo  = "<" + attr + ">"
		} else if len(xmlTag) == 0 || strings.EqualFold(xmlTag, "-") || len(strings.Split(xmlTag, ",")[0]) == 0 {
			continue
		} else if strings.Contains(xmlTag, "attr") {
			old := previous
			new := ""
			if strings.EqualFold(previous[1:len(previous) - 1], strings.Split(xmlTag, ",")[0])        {
				new =  "<" +
					strings.Split(xmlTag, ",")[0] +
					"=\"" + field.Type.String() + "\">"
			} else {
				new =  previous[0:len(previous)-1] + " " +
					strings.Split(xmlTag, ",")[0] +
					"=\"" + field.Type.String() + "\">"
			}
			xmlinfo = strings.Replace(xmlinfo, old, new, -1)
			previous = new
		} else {
			if strings.Contains(field.Type.String(), "libvirtxml") {
				attr := strings.Split(xmlTag, ",")[0]
				end  := "</" + attr  + ">"
				prev := "<" + attr + ">"
				name := field.Type.String()
				if strings.Contains(name, "*") {
					previous = analyse(reflect.TypeOf(reflect.New(field.Type.Elem()).Elem().Interface()), prev, prev, end)
				} else if strings.Contains(name, "[]") {
					previous = analyse(reflect.New(field.Type.Elem()).Elem().Type(), prev, prev, end)
				} else {
					previous = analyse(reflect.TypeOf(reflect.New(field.Type).Elem().Interface()), prev, prev, end)
				}
			} else {
				previous = "<" + strings.Split(xmlTag, ",")[0] + ">" +
					field.Type.String() +
					"</" + strings.Split(xmlTag, ",")[0] + ">"

			}

			if !strings.Contains(xmlinfo, previous) {
				xmlinfo += previous
			}

		}
	}

	return xmlinfo + endelem
 }


