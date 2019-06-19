package com.github.kube.controller;

import java.io.File;
import java.io.FileInputStream;

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
    	
    }  
}
