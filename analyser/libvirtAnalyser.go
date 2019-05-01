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
		if len(xmlTag) == 0 || len(attrDesc) == 0 ||
			strings.EqualFold(attrDesc, "-") ||
			strings.Contains(attrDesc, "innerxml") {
			//strings.Contains(attrDesc, "omitempty") {
			continue
		}

		repeat := 1
		attr := strings.Split(attrDesc, ",")[0]
		if len(attr) == 0 && strings.Contains(attrDesc, "chardata") {
			xml = xml + "value"
		} else if strings.Contains(attrDesc, "attr") {
			xml = xml[:len(xml) - 1] + " " + attr +
						"='" + field.Type.String() + "'>"
		} else if !strings.Contains(field.Type.String(), "libvirtxml") {
			xml = xml + "<" + attr + ">" + field.Type.String() + "</" + attr + ">"
		} else if strings.Contains(field.Type.String(), "libvirtxml")  {
			objRef := objType

			if strings.Contains(field.Type.String(), "*") {
				objRef = reflect.TypeOf(reflect.New(field.Type.Elem()).Elem().Interface())
			} else if strings.Contains(field.Type.String(), "[]") {
				objRef = reflect.New(field.Type.Elem()).Elem().Type()
				// may write twice because it is an array
				repeat = 2
			} else {
				objRef = reflect.TypeOf(reflect.New(field.Type).Elem().Interface())
			}

			// nested loop
			if strings.EqualFold(objType.String(), objRef.String()) {
				continue
			}

			for a := 0; a < repeat; a++ {
				xml = xml + Analyse(objRef, attr)
			}
		}

	}

	return xml + "</" + xmlTag  + ">"
}



