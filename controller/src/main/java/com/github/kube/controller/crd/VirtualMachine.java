/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller.crd;

import io.fabric8.kubernetes.client.CustomResource;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Wed May 01 17:10:52 CST 2019
 **/
public class VirtualMachine extends CustomResource {

	private VirtualMachineSpec spec;

	public void setSpec(VirtualMachineSpec spec) {
		this.spec = spec;
	}

	public VirtualMachineSpec getSpec() {
		return this.spec;
	}
}
