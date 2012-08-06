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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;

import java.io.PrintWriter;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

@SyntaxDependent
public class AdditionalExtensionParserExtensionPointSchemaGenerator extends ResourceBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void doGenerate(PrintWriter out) {
		super.doGenerate(out);
		IPluginDescriptor resourcePlugin = getContext().getResourcePlugin();
		String resourcePluginName = resourcePlugin.getName();
		String syntaxName = getContext().getConcreteSyntax().getName();

		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version='1.0' encoding='UTF-8'?>");
		sc.add("<schema targetNamespace=\"" + resourcePluginName + "\" xmlns=\"http://www.w3.org/2001/XMLSchema\">");
		sc.add("<annotation>");
		sc.add("<appinfo>");
		sc.add("<meta.schema plugin=\"" + resourcePluginName + "\" id=\"" + resourcePluginName + ".additional_extension_parser\" name=\"Additional Extension Parser\"/>");
		sc.add("</appinfo>");
		sc.add("<documentation>");
		sc.add("This extension point can be used to add another parser for '" + syntaxName + "' files.");
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
		sc.add("<element ref=\"parser\"/>");
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
		sc.add("<element name=\"parser\">");
		sc.add("<complexType>");
		sc.add("<attribute name=\"type\" type=\"string\">");
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
		sc.add("<meta.attribute kind=\"java\" basedOn=\"" + RESOURCE + ".Factory\"/>");
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
	}

	
}
