/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller.crd;

import java.util.List;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceConversion;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionNames;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceSubresources;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceValidation;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Wed May 01 17:15:35 CST 2019
 **/
@JsonDeserialize(using = JsonDeserializer.None.class)
public class VirtualMachineDifinitionSpec extends CustomResourceDefinitionSpec {

	public VirtualMachineDifinitionSpec() {
		super();
		CustomResourceConversion cc = new CustomResourceConversion();
	}

	public VirtualMachineDifinitionSpec(List<CustomResourceColumnDefinition> additionalPrinterColumns,
			CustomResourceConversion conversion, String group, CustomResourceDefinitionNames names, String scope,
			CustomResourceSubresources subresources, CustomResourceValidation validation, String version,
			List<CustomResourceDefinitionVersion> versions) {
		super(additionalPrinterColumns, conversion, group, names, scope, subresources, validation, version, versions);
	}

}
