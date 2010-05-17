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

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;

/**
 * Creates the content for .project files, which are used by Eclipse to store meta data
 * about plug-ins. The content of the file is determined by the given plug-in descriptor.
 */
public class DotProjectGenerator<ContextType> extends AbstractGenerator<ContextType, IPluginDescriptor> {

	private IPluginDescriptor plugin;

	public DotProjectGenerator(ICodeGenerationComponent parent, ContextType context, IPluginDescriptor plugin) {
		super(parent, context, null);
		this.plugin = plugin;
	}

	@Override
	public void generate(PrintWriter out) {
		String resourcePluginName = plugin.getName();

		StringComposite sc = new XMLComposite();
		
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<projectDescription>");
		sc.add("<name>" + resourcePluginName + "</name>");
		sc.add("<comment></comment>");
		sc.add("<projects>");
		sc.add("</projects>");
		sc.add("<buildSpec>");
		sc.add("<buildCommand>");
		sc.add("<name>org.eclipse.jdt.core.javabuilder</name>");
		sc.add("<arguments>");
		sc.add("</arguments>");
		sc.add("</buildCommand>");
		sc.add("<buildCommand>");
		sc.add("<name>org.eclipse.pde.ManifestBuilder</name>");
		sc.add("<arguments>");
		sc.add("</arguments>");
		sc.add("</buildCommand>");
		sc.add("<buildCommand>");
		sc.add("<name>org.eclipse.pde.SchemaBuilder</name>");
		sc.add("<arguments>");
		sc.add("</arguments>");
		sc.add("</buildCommand>");
		sc.add("</buildSpec>");
		sc.add("<natures>");
		sc.add("<nature>org.eclipse.jdt.core.javanature</nature>");
		sc.add("<nature>org.eclipse.pde.PluginNature</nature>");
		sc.add("</natures>");
		sc.add("</projectDescription>");
		
		out.write(sc.toString());
	}

	public IGenerator<ContextType, IPluginDescriptor> newInstance(ICodeGenerationComponent parent, ContextType context, IPluginDescriptor plugin) {
		return new DotProjectGenerator<ContextType>(parent, context, plugin);
	}
}
