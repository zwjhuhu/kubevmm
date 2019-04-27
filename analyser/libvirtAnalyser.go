/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
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

func Analyse(objType reflect.Type, xmlTag string) (string) {

	xml := "<" + xmlTag  + ">"

	/**
	 *  take libvirtxml.domain for example, the structure is
	 *  type Domain struct {
	 *  XMLName        xml.Name              `xml:"domain"`
	 *  Type           string                `xml:"type,attr,omitempty"`
	 *  ID             *int                  `xml:"id,attr"`
	 *  Name           string                `xml:"name,omitempty"`
	 *  UUID           string                `xml:"uuid,omitempty"`
	 *  GenID          *DomainGenID          `xml:"genid"`
	 * ...}
	 *
	 *  the term 'field' is a row, such as 'MLName        xml.Name              `xml:"domain"`'
	 *  the term 'attrDesc' is a substring of the third column, such as 'domain', 'type, attr, omitempty'
	 *  the term 'attr' is a substring of the third column, such as 'domain', 'type', 'id'
	 */

	for i := 0; i < objType.NumField(); i++ {

		// ignore this case
		// I do not known why only some classes have this attr,
		// may be we cannot use libvit-go in production
		field := objType.Field(i)
		if strings.EqualFold(field.Type.String(), "xml.Name") {
			continue
		}

		// ignore this case
		// I do not known why only some classes have this attr,
		// may be we cannot use libvit-go in production
		attrDesc := field.Tag.Get("xml")
		if len(xmlTag) == 0 ||
			strings.EqualFold(attrDesc, "-") ||
			len(strings.Split(attrDesc, ",")[0]) == 0  ||
			strings.Contains(attrDesc, "omitempty") {
			continue
		}

		attr := strings.Split(attrDesc, ",")[0]
		if strings.Contains(attrDesc, "attr") {
			xml = xml[:len(xml) - 1] + " " + attr +
						"='" + field.Type.String() + "'>"
		} else if !strings.Contains(field.Type.String(), "libvirtxml") {
			xml = xml + "<" + attr + ">" + field.Type.String() + "</" + attr + ">"
		} else {
			objRef := objType

			if strings.Contains(field.Type.String(), "*") {
				objRef = reflect.TypeOf(reflect.New(field.Type.Elem()).Elem().Interface())
			} else if strings.Contains(field.Type.String(), "[]") {
				objRef = reflect.New(field.Type.Elem()).Elem().Type()
			} else {
				objRef = reflect.TypeOf(reflect.New(field.Type).Elem().Interface())
			}

			// nested loop
			if strings.EqualFold(objType.String(), objRef.String()) {
				continue
			}
			xml = xml + Analyse(objRef, attr)
		}

	}

	return xml + "</" + xmlTag  + ">"
}



