package org.emftext.sdk.codegen.parameters.xml;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple implementation of XML element nodes, which is used to parameterize
 * XML generators. A XMLElement has a name, attributes (key-value pairs of
 * strings) and children.
 */
public class XMLElement {

	private String name;
	private Map<String, String> attributes = new LinkedHashMap<String, String>();
	private List<XMLElement> children = new ArrayList<XMLElement>();
	
	public XMLElement(String name) {
		super();
		this.name = name;
	}
	
	public void setAttribute(String name, String value) {
		attributes.put(name, value);
	}
	
	public void addChild(XMLElement child) {
		children.add(child);
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public List<XMLElement> getChildren() {
		return children;
	}

	public XMLElement createChild(String name) {
		XMLElement child = new XMLElement(name);
		getChildren().add(child);
		return child;
	}
}