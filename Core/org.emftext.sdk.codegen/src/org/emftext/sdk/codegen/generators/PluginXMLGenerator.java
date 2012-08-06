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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Map;

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.emftext.sdk.codegen.parameters.XMLParameters;
import org.emftext.sdk.codegen.parameters.xml.XMLElement;

/**
 * A generator for plugin.xml files.
 */
@SyntaxDependent
public class PluginXMLGenerator<ContextType extends IContext<ContextType>> extends AbstractGenerator<ContextType, XMLParameters<ContextType>> {

	@Override
	public void doGenerate(PrintWriter out) {
		StringComposite sc = new XMLComposite();
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<?eclipse version=\"3.2\"?>");
		XMLElement xmlContent = getParameters().getXmlContent();
		addContent(sc, xmlContent);
		out.write(sc.toString());
		out.flush();
	}

	private void addContent(StringComposite sc, XMLElement xmlElement) {
		String name = xmlElement.getName();
		Map<String, String> attributes = xmlElement.getAttributes();
		
		String openingTag = "<" + name;
		for (String attributeName : attributes.keySet()) {
			openingTag += " " + attributeName + "=\"" + attributes.get(attributeName) + "\"";
		}
		openingTag += ">";

		String closingTag = "</" + name + ">";
		
		sc.add(openingTag);
		for (XMLElement child : xmlElement.getChildren()) {
			addContent(sc, child);
		}
		sc.add(closingTag);
		if ("extension".equals(name) || "extension-point".equals(name)) {
			sc.addLineBreak();
		}
	}
}
