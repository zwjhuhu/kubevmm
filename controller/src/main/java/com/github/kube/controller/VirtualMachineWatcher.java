/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSON;
import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;

/**
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @author wuheng@otcaix.iscas.ac.cn
 * @since Wed May 01 17:26:22 CST 2019
 * 
 *        https://www.json2yaml.com/ http://www.bejson.com/xml2json/
 * 
 *        debug at runWatch method of
 *        io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager
 **/
public class VirtualMachineWatcher implements Watcher<VirtualMachine> {

	protected final static Logger m_logger = Logger.getLogger(VirtualMachineWatcher.class.getName());

	protected final ExtendedKubernetesClient client;

	public VirtualMachineWatcher(ExtendedKubernetesClient client) {
		super();
		this.client = client;
	}

	// actions
	public final static String ACTION_CREATE = "ADDED";

	public final static String ACTION_REMOVE = "DELETED";

	// pod attributions
	public final static String POD_PREFIX = "vm2pod";

	public final static String POD_NAMESPACE = "default";

	public void eventReceived(Action action, VirtualMachine vm) {

		String podName = POD_PREFIX + "-" + vm.getMetadata().getName() + "-" + vm.getMetadata().getNamespace();

		if (action.toString().equals(ACTION_CREATE)) {
			Pod pod = createPod(vm, podName);
			if (client.pods().inNamespace(POD_NAMESPACE).withName(podName).get() == null) {

				client.pods().inNamespace(POD_NAMESPACE).create(pod);
				m_logger.log(Level.INFO, "Create VM '" + vm.getMetadata().getName() + "' in namespace '"
						+ vm.getMetadata().getNamespace() + "'");
				m_logger.log(Level.INFO, "Create Pod '" + podName + "' in namespace '" + POD_NAMESPACE + "'");
			}
		} else if (action.toString().equals(ACTION_REMOVE)) {
			if (client.pods().inNamespace(POD_NAMESPACE).withName(podName).get() != null) {
				client.pods().inNamespace(POD_NAMESPACE).withName(podName).delete();
				m_logger.log(Level.INFO, "Delete Pod '" + podName + "' in namespace '" + POD_NAMESPACE + "'");
				m_logger.log(Level.INFO, "Delete VM '" + vm.getMetadata().getName() + "' in namespace '"
						+ vm.getMetadata().getNamespace() + "'");
			}
		}
	}

	private Pod createPod(VirtualMachine vm, String podName) {
		Pod pod = new Pod();
		// metadata and podSpec
		pod.setMetadata(createMetadataFrom(vm, podName));
		pod.setSpec(createPodSpecFrom(vm, podName));
		return pod;
	}

	// default values

	public final static String DEFAULT_SCHEDULER = "kubevirt-scheduler";

	private PodSpec createPodSpecFrom(VirtualMachine vm, String podName) {
		PodSpec spec = new PodSpec();
		spec.setContainers(createContainerFrom(vm, podName));
		spec.setSchedulerName(System.getProperty("scheduler-name", DEFAULT_SCHEDULER));
		return spec;
	}

	public final static String DEFAULT_IMAGE = "fake";

	private List<Container> createContainerFrom(VirtualMachine vm, String podName) {
		List<Container> containers = new ArrayList<Container>();
		Container container = new Container();
		container.setName(podName);
		container.setImage(DEFAULT_IMAGE);
		container.setResources(createResourceDemands(vm));
		containers.add(container);
		return containers;
	}

	// resources
	public final static String CPU_RESOURCE = "cpu";

	public final static String RAM_RESOURCE = "memory";

	private ResourceRequirements createResourceDemands(VirtualMachine vm) {
		ResourceRequirements resources = new ResourceRequirements();
		Map<String, Quantity> requests = new HashMap<String, Quantity>();
		requests.put(CPU_RESOURCE, new Quantity(vm.getSpec().getLifecycle().getInstall().get__vcpus()));
		requests.put(RAM_RESOURCE, new Quantity(vm.getSpec().getLifecycle().getInstall().get__memory()));
		resources.setRequests(requests);
		return resources;
	}

	private ObjectMeta createMetadataFrom(VirtualMachine vm, String podName) {
		ObjectMeta metadata = new ObjectMeta();
		metadata.setName(podName);
		metadata.setAnnotations(createAnnotations(vm));
		return metadata;
	}

	// annotations
	public final static String KIND_ANNOTATION = "crdKind";

	public final static String NS_ANNOTATION = "crdNamespace";

	public final static String VERSION_ANNOTATION = "crdVersion";

	public final static String GROUP_ANNOTATION = "crdGroup";

	public final static String NAME_ANNOTATION = "crdName";

	public final static String CONTENT_ANNOTATION = "crdYaml";

	public final static String PLURAL = "virtualmachines";

	public final static String GROUP = "cloudplus.io";

	public final static String VERSION = "v1alpha3";

	private Map<String, String> createAnnotations(VirtualMachine vm) {
		Map<String, String> annotations = new HashMap<String, String>();
		annotations.put(KIND_ANNOTATION, PLURAL);
		annotations.put(GROUP_ANNOTATION, GROUP);
		annotations.put(VERSION_ANNOTATION, VERSION);
		annotations.put(NAME_ANNOTATION, vm.getMetadata().getName());
		annotations.put(NS_ANNOTATION, vm.getMetadata().getNamespace());
		annotations.put(CONTENT_ANNOTATION, JSON.toJSONString(vm.getSpec()));
		return annotations;
	}

	public void onClose(KubernetesClientException cause) {
		m_logger.log(Level.INFO, "Stop VirtualMachineWatcher");
	}

}
