/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller.crd;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.client.CustomResourceDoneable;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Sat May 04 20:50:19 CST 2019
 **/
public class DoneableVirtualMachine extends CustomResourceDoneable<VirtualMachine> {

	public DoneableVirtualMachine(VirtualMachine resource, Function function) {
		super(resource, function);
	}
}

