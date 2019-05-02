/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.convertor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.github.kubesys.kubedev.generators.DoneableGenerator;
import com.github.kubesys.kubedev.generators.ResourceGenerator;
import com.github.kubesys.kubedev.generators.ResourceListGenerator;
import com.github.kubesys.kubedev.generators.SpecGenerator;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Wed May 01 17:26:22 CST 2019
 **/
public class VirtualMachineGenerator {

	/**
	 * metadata.name in VirtualMachineCRD.yaml
	 */
	public final static String NAME    = "virtualmachines.cloudplus.io";
	
	public final static String GROUP   = "cloudplus.io";
	
	public final static String VERSION = "v1alpha3";
	
	/**
	 * spec.name.kind in VirtualMachineCRD.yaml
	 */
	public final static String KIND    = "VirtualMachine";

	/**
	 * 
	 */
	public final static String CONF    = "conf/domain.json";
	
	/**
	 * 
	 */
	public final static String PKG  = "com.github.kube.convertor.crd";
	
	public final static String AUTHOR = "\n\n/**\r\n" 
						+ " * @author wuheng@otcaix.iscas.ac.cn\r\n"
						+ " * @author xuyuanjia2017@otcaix.iscas.ac.cn\r\n" 
						+ " * @author yangchen18@otcaix.iscas.ac.cn\r\n" 
						+ " * @since " + new Date() + "\r\n"
						+ " **/\n";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ResourceGenerator rg = new ResourceGenerator();
		System.out.println(rg.autoGen(PKG, KIND));
		
		
		Map map = JSON.parseObject(new FileInputStream(
				new File("conf/domain.json")), Map.class);
		SpecGenerator sg = new SpecGenerator(PKG);
		System.out.println(sg.autoGen(map, KIND));
		
		ResourceListGenerator lg = new ResourceListGenerator();
		System.out.println(lg.autoGen(PKG, KIND));
		
		DoneableGenerator dg = new DoneableGenerator();
		System.out.println(dg.autoGen(PKG, KIND));
	}

}
