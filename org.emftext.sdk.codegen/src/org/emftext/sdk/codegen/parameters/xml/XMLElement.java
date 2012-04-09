/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
