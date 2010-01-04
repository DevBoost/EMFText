/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;

public class DefaultLoadOptionsExtensionPointSchemaGenerator implements IGenerator {

	private GenerationContext context;

	public DefaultLoadOptionsExtensionPointSchemaGenerator(
			GenerationContext context) {
		super();
		this.context = context;
	}

	public boolean generate(PrintWriter out) {
		String resourcePluginName = EPlugins.RESOURCE_PLUGIN.getName(context.getConcreteSyntax());

		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version='1.0' encoding='UTF-8'?>");
		sc.add("<schema targetNamespace=\"" + resourcePluginName + "\" xmlns=\"http://www.w3.org/2001/XMLSchema\">");
		sc.add("<annotation>");
		sc.add("<appinfo>");
		sc.add("<meta.schema plugin=\"" + resourcePluginName + "\" id=\"" + resourcePluginName + ".default_load_options\" name=\"Default Load Options\"/>");
		sc.add("</appinfo>");
		sc.add("<documentation>");
		sc.add("This extension point can be used to configure the default load options for resources.");
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.addLineBreak();
		sc.add("<element name=\"extension\">");
		sc.add("<annotation>");
		sc.add("<appinfo>");
		sc.add("<meta.element>");
		sc.add("</meta.element>");
		sc.add("</appinfo>");
		sc.add("</annotation>");
		sc.add("<complexType>");
		sc.add("<sequence>");
		sc.add("<element ref=\"provider\"/>");
		sc.add("</sequence>");
		sc.add("<attribute name=\"point\" type=\"string\" use=\"required\">");
		sc.add("<annotation>");
		sc.add("<documentation>");
		sc.addLineBreak();
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.add("</attribute>");
		sc.add("<attribute name=\"id\" type=\"string\">");
		sc.add("<annotation>");
		sc.add("<documentation>");
		sc.addLineBreak();
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.add("</attribute>");
		sc.add("<attribute name=\"name\" type=\"string\">");
		sc.add("<annotation>");
		sc.add("<documentation>");
		sc.addLineBreak();
		sc.add("</documentation>");
		sc.add("<appinfo>");
		sc.add("<meta.attribute translatable=\"true\"/>");
		sc.add("</appinfo>");
		sc.add("</annotation>");
		sc.add("</attribute>");
		sc.add("</complexType>");
		sc.add("</element>");
		sc.addLineBreak();
		sc.add("<element name=\"provider\">");
		sc.add("<complexType>");
		sc.add("<attribute name=\"id\" type=\"string\" use=\"required\">");
		sc.add("<annotation>");
		sc.add("<documentation>");
		sc.addLineBreak();
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.add("</attribute>");
		sc.add("<attribute name=\"name\" type=\"string\">");
		sc.add("<annotation>");
		sc.add("<documentation>");
		sc.addLineBreak();
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.add("</attribute>");
		sc.add("<attribute name=\"class\" type=\"string\" use=\"required\">");
		sc.add("<annotation>");
		sc.add("<documentation>");
		sc.addLineBreak();
		sc.add("</documentation>");
		sc.add("<appinfo>");
		sc.add("<meta.attribute kind=\"java\" basedOn=\":" + context.getQualifiedClassName(EArtifact.I_OPTION_PROVIDER) + "\"/>");
		sc.add("</appinfo>");
		sc.add("</annotation>");
		sc.add("</attribute>");
		sc.add("<annotation>");
		sc.add("<documentation>");
		sc.addLineBreak();
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.add("</complexType>");
		sc.add("</element>");
		sc.addLineBreak();
		sc.add("<annotation>");
		sc.add("<appinfo>");
		sc.add("<meta.section type=\"since\">");
		sc.add("</meta.section>");
		sc.add("</appinfo>");
		sc.add("<documentation>");
		sc.add("[Enter the first release in which this extension point appears.]");
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.addLineBreak();
		sc.add("<annotation>");
		sc.add("<appinfo>");
		sc.add("<meta.section type=\"examples\"/>");
		sc.add("</appinfo>");
		sc.add("<documentation>");
		sc.add("[Enter extension point usage example here.]");
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.addLineBreak();
		sc.add("<annotation>");
		sc.add("<appinfo>");
		sc.add("<meta.section type=\"apiinfo\"/>");
		sc.add("</appinfo>");
		sc.add("<documentation>");
		sc.add("[Enter API information here.]");
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.addLineBreak();
		sc.add("<annotation>");
		sc.add("<appinfo>");
		sc.add("<meta.section type=\"implementation\">");
		sc.add("</meta.section>");
		sc.add("</appinfo>");
		sc.add("<documentation>");
		sc.add("[Enter information about supplied implementation of this extension point.]");
		sc.add("</documentation>");
		sc.add("</annotation>");
		sc.add("</schema>");
		sc.addLineBreak();
		
		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new DefaultLoadOptionsExtensionPointSchemaGenerator(context);
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptyList();
	}
}
