/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.convertor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Wed May 01 17:26:22 CST 2019
 * 
 * https://github.com/javadev/underscore-java
 **/
public class Convertor {

	public static final String XML_FILE = "conf/domain.xml";
	
	public static String xmlToJson(String xmlStr) throws Exception {
		return JSON.toJSONString(MapObject.fromXml(xmlStr));
	}
	
	
	public static String jsonToXml(String jsonStr) {
		return null;
	}
	
	public static String readXML(File file) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(xmlToJson(
				readXML(new File(XML_FILE))));
	}
}
