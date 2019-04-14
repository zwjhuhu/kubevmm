/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package analyser

import (
	"fmt"
	"reflect"
)

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since 2019/4/14
 *
 */

 func GetMethod(input interface{}) {

	 getType := reflect.TypeOf(input)
	 fmt.Println("get Type is :", getType.Name())

	 // 获取方法字段
	 // 1. 先获取interface的reflect.Type，然后通过NumField进行遍历
	 // 2. 再通过reflect.Type的Field获取其Field
	 // 3. 最后通过Field的Interface()得到对应的value
	 for i := 0; i < getType.NumField(); i++ {
		 field := getType.Field(i)
		 fmt.Printf("%s: %v = %v: %s\n", field.Name, field.Type, field.Tag)
	 }
 }


