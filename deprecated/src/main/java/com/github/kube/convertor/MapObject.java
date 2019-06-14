/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kube.convertor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author shizhonghao17@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Wed May 01 17:26:22 CST 2019
 * 
 *        https://github.com/stleary/JSON-java
 **/
public class MapObject {

	public final static String ATTR_TAG = "-";
	
	public final static String TEXT_TAG = "#text";
	
    private static Map<String, Object> createMap(final org.w3c.dom.Node node) {
		
        final Map<String, Object> objectMap = new LinkedHashMap<String, Object>();
        final Map<String, Object> valuesMap = new LinkedHashMap<String, Object>();
        
        objectMap.put(node.getNodeName(), valuesMap);
        
        // attrValues
        Map<String, Object> attrValues = createAttributes(node);
		valuesMap.putAll(attrValues);
		
		//nodeValue
		if (node.getChildNodes().getLength() == 1) {
    		String key = (attrValues.size() == 0) 
					? node.getLocalName() : TEXT_TAG;
			valuesMap.put(key, node.getTextContent());
    	} 
        
        final NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
        	Node item = nodeList.item(i);
        	if (item.getNodeName().equals("#text")) {
        		continue;
        	} else if (item.getChildNodes().getLength() == 1
        			&& item.getAttributes().getLength() == 0) {
        		if (valuesMap.containsKey(item.getNodeName())) {
        			List<Object> objList = createList(valuesMap, item);
        			objList.add(item.getTextContent());
        			valuesMap.put(item.getNodeName(), objList);
        		} else {
        			valuesMap.put(item.getNodeName(), item.getTextContent());
        		}
        	} 
//        	else if (item.getChildNodes().getLength() == 1
//        			&& item.getAttributes().getLength() > 0) {
//        		if (valuesMap.containsKey(item.getNodeName())) {
//        			List<Object> objList = createList(valuesMap, item);
//        			objList.add(createMap(item));
//        			valuesMap.put(item.getNodeName(), objList);
//        		} else {
//        			valuesMap.putAll(createMap(item));
//        		}
//        	} 
        	else {
        		if (valuesMap.containsKey(item.getNodeName())) {
        			List<Object> objList = createList(valuesMap, item);
        			objList.add(createMap(item).get(item.getNodeName()));
        			valuesMap.put(item.getNodeName(), objList);
        		} else {
        			valuesMap.putAll(createMap(item));
        		}
        	}
        
		}
        
        return objectMap;
    }

	private static List<Object> createList(final Map<String, Object> valuesMap, Node item) {
		List<Object> objList = new ArrayList<Object>();
		Object oldObj  = valuesMap.remove(item.getNodeName());
		try {
			objList.add(oldObj);
		} catch (Exception ex) {
			objList.addAll((Collection<? extends Object>) oldObj);
		}
		return objList;
	}

	private static Map<String, Object> createAttributes(final org.w3c.dom.Node node) {
		Map<String, Object> valueMap  = new LinkedHashMap<String, Object>();
		NamedNodeMap attrs = node.getAttributes();
    	int attrLen = (attrs == null) ? 0 :attrs.getLength();
		for (int i = 0; i < attrLen; i ++) {
			Node attr = attrs.item(i);
			valueMap.put(ATTR_TAG + attr.getNodeName(), 
					attr.getNodeValue());
		}
		return valueMap;
	}

	public static Object fromXml(final String xml) throws Exception {
		final java.io.InputStream stream = new java.io.ByteArrayInputStream(xml.getBytes("UTF-8"));
		final javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory
				.newInstance();
		factory.setNamespaceAware(true);
		final org.w3c.dom.Document document = factory.newDocumentBuilder().parse(stream);
		return createMap(document.getDocumentElement());
	}

}
