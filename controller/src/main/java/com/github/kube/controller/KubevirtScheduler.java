/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.controller;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;

/**
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @author wuheng@otcaix.iscas.ac.cn
 * @since Wed May 01 17:26:22 CST 2019
 * 
 * https://www.json2yaml.com/
 * http://www.bejson.com/xml2json/
 * 
 * debug at runWatch method of io.fabric8.kubernetes.client.dsl.internal.WatchConnectionManager
 **/
public class KubevirtScheduler {
	
	protected final static Logger m_logger = Logger.getLogger(KubevirtScheduler.class.getName());

	public final static String TOKEN              = "/etc/kubernetes/admin.conf";
	
	protected final ExtendedKubernetesClient client;
	
	public KubevirtScheduler() throws Exception {
		super();
		client = ExtendedKubernetesClient.defaultConfig(new FileInputStream(TOKEN));
	}
	
	public void start() {
		client.watchVirtualMachine(new VirtualMachineWatcher(client));
	}
	
	public static void main(String[] args) throws Exception {
		m_logger.log(Level.INFO, "Start VirtualMachineWatcher");
		KubevirtScheduler scheduler = new KubevirtScheduler();
		scheduler.start();
	}

}
