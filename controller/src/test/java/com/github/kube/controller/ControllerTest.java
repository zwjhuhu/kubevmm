package com.github.kube.controller;

import java.io.File;
import java.io.FileInputStream;

import com.github.kube.controller.crd.DoneableVirtualMachine;
import com.github.kube.controller.crd.VirtualMachine;
import com.github.kube.controller.crd.VirtualMachineList;

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

/**
 * Unit test for simple App.
 */
public class ControllerTest 
{
	
	public final static String CONFIG    = "/etc/kubernetes/admin.conf";
	
	public final static String NAME      = "virtualmachines.cloudplus.io";
	
    public static void main(String[] args) throws Exception {
    	KubernetesClient client = DefaultKubernetesClient
    			.fromConfig(new FileInputStream(new File(CONFIG)));
    	
    	CustomResourceDefinition crd = client.customResourceDefinitions().withName(NAME).get();
    	
    	KubernetesDeserializer.registerCustomKind("cloudplus.io/v1alpha3", 
    			VirtualMachine.class.getSimpleName(), VirtualMachine.class);
    	
    	Watcher<VirtualMachine> watcher = new Watcher<VirtualMachine>() {

			public void eventReceived(Action action, VirtualMachine resource) {
				System.out.println(action);
				
			}

			public void onClose(KubernetesClientException cause) {
				// TODO Auto-generated method stub
				
			}
    		
    	};
    	System.out.println(watcher);
		client.customResources(crd, VirtualMachine.class, VirtualMachineList.class, 
				DoneableVirtualMachine.class).watch(watcher );
    }
}
