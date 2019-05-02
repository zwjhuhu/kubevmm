/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.convertor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSON;
import com.github.kube.convertor.crd.DoneableVirtualMachine;
import com.github.kube.convertor.crd.VirtualMachine;
import com.github.kube.convertor.crd.VirtualMachineList;
import com.github.kubesys.kubedev.CustomResourceWatcher;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.FilterWatchListMultiDeletable;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Wed May 01 17:26:22 CST 2019
 * 
 * https://www.json2yaml.com/
 * http://www.bejson.com/xml2json/
 **/
public class VirtualMachineWatcher extends CustomResourceWatcher {
	
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineWatcher.class.getName());

	public final static String ACTION_CREATE      = "ADDED";
	
	public final static String ACTION_REMOVE      = "DELETED";
	
	public final static String POD_PREFIX         = "vm2pod";
	
	public final static String POD_NAMESPACE      = "default";
	
	public final static String KIND_ANNOTATION    = "crdKind";
	
	public final static String NS_ANNOTATION      = "crdNamespace";
	
	public final static String VERSION_ANNOTATION = "crdVersion";
	
	public final static String GROUP_ANNOTATION   = "crdGroup";
	
	public final static String NAME_ANNOTATION    = "crdName";
	
	public final static String CONTENT_ANNOTATION = "crdYaml";
	
	public final static String CPU_RESOURCE       = "cpu";
	
	public final static String RAM_RESOURCE       = "memory";
	
	public final static String DEFAULT_IMAGE      = "fake";
	
	public VirtualMachineWatcher() throws Exception {
		super();
	}

	@Override
	public void watch(CustomResourceDefinition crd, Class<? extends HasMetadata> resourceType,
			Class<? extends KubernetesResourceList> resourceList, Class<? extends Doneable> doneableRespurce) {

		getWatcher(crd, resourceType, resourceList, doneableRespurce)
								.watch(new Watcher<VirtualMachine>() {

			public void eventReceived(Action action, VirtualMachine vm) {
				String podName = POD_PREFIX + "-" + vm.getMetadata().getName() 
						+ "-" + vm.getMetadata().getNamespace();
				
				
				if (action.toString().equals(ACTION_CREATE)) {
					Pod pod = new Pod();
					ObjectMeta metadata = new ObjectMeta();
					metadata.setName(podName);
					Map<String, String> annotations = new HashMap<String, String>();
					annotations.put(KIND_ANNOTATION, VirtualMachineGenerator.NAME);
					annotations.put(GROUP_ANNOTATION, VirtualMachineGenerator.GROUP);
					annotations.put(VERSION_ANNOTATION, VirtualMachineGenerator.VERSION);
					annotations.put(NAME_ANNOTATION, vm.getMetadata().getName());
					annotations.put(NS_ANNOTATION, vm.getMetadata().getNamespace());
					annotations.put(CONTENT_ANNOTATION, JSON.toJSONString(vm));
					metadata.setAnnotations(annotations );
					pod.setMetadata(metadata );
					
					
					PodSpec spec = new PodSpec();
					List<Container> containers = new ArrayList<Container>();
					Container container = new Container();
					container.setName(podName);
					container.setImage(DEFAULT_IMAGE);
					ResourceRequirements resources = new ResourceRequirements();
					Map<String, Quantity> requests = new HashMap<String, Quantity>();
					requests.put(CPU_RESOURCE, new Quantity(vm.getSpec().getDomain().getVcpu().getText()));
					requests.put(RAM_RESOURCE, new Quantity(vm.getSpec().getDomain().getMemory().getText()));
					resources.setRequests(requests );
					container.setResources(resources);
					containers.add(container);
					spec.setContainers(containers );
					
					spec.setSchedulerName("kubecrd-scheduler");
					
					pod.setSpec(spec );
					if (client.pods().inNamespace(POD_NAMESPACE).withName(podName).get() == null) {
						client.pods().inNamespace(POD_NAMESPACE).create(pod );
						m_logger.log(Level.INFO, "Create VM '" + vm.getMetadata().getName() 
								+ "' in namespace '" + vm.getMetadata().getNamespace() + "'");
						m_logger.log(Level.INFO, "Create Pod '" + podName 
								+ "' in namespace '" + POD_NAMESPACE + "'");
					}
				} else if (action.toString().equals(ACTION_REMOVE)) {
					if (client.pods().inNamespace(POD_NAMESPACE).withName(podName).get() != null) {
						client.pods().inNamespace(POD_NAMESPACE).withName(podName).delete();
						m_logger.log(Level.INFO, "Delete Pod '" + podName 
								+ "' in namespace '" + POD_NAMESPACE + "'");
						m_logger.log(Level.INFO, "Delete VM '" + vm.getMetadata().getName() 
								+ "' in namespace '" + vm.getMetadata().getNamespace() + "'");
					}
				}
			}

			public void onClose(KubernetesClientException cause) {
				m_logger.log(Level.INFO, "Stop VirtualMachineWatcher");
			}

		});
	}

	private FilterWatchListMultiDeletable<VirtualMachine, VirtualMachineList, Boolean, Watch, Watcher<VirtualMachine>> getWatcher(
			CustomResourceDefinition crd, Class<? extends HasMetadata> resourceType,
			Class<? extends KubernetesResourceList> resourceList, Class<? extends Doneable> doneableRespurce) {
		return (FilterWatchListMultiDeletable<VirtualMachine, VirtualMachineList, Boolean, Watch, Watcher<VirtualMachine>>) 
				client.customResources(crd, resourceType, resourceList, doneableRespurce).inAnyNamespace();
	}
	
	public static void main(String[] args) throws Exception {
		m_logger.log(Level.INFO, "Start VirtualMachineWatcher");
		VirtualMachineWatcher watcher = new VirtualMachineWatcher();
		CustomResourceDefinition crd = watcher.getCustomResourceDefinition(
						VirtualMachineGenerator.NAME, VirtualMachine.class);
		if (crd != null) {
			watcher.watch(crd, VirtualMachine.class, VirtualMachineList.class, DoneableVirtualMachine.class);
		} else {
			m_logger.log(Level.SEVERE, "VirtualMachineWatcher does not work");
		}
		
	}

}
