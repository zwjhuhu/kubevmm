/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller.crd;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.kube.convertor.Domain;

import io.fabric8.kubernetes.api.model.KubernetesResource;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Tue May 07 21:15:23 CST 2019
 **/
@JsonDeserialize(using = JsonDeserializer.None.class)
public class VirtualMachineSpec implements KubernetesResource {

	private Domain domain;
	
	private String image;

	public VirtualMachineSpec() {
		this.domain = new Domain();

	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Domain getDomain() {
		return this.domain;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}