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
import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.sdk.PluginDescriptor;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.StringUtil;

public class BuildPropertiesGenerator extends BaseGenerator {

	private PluginDescriptor plugin;

	public BuildPropertiesGenerator(GenerationContext context, PluginDescriptor plugin) {
		super(context, TextResourceArtifacts.BUILD_PROPERTIES);
		this.plugin = plugin;
	}

	@Override
	public boolean generate(PrintWriter out) {
		String sourceFolder = getFolder(OptionTypes.SOURCE_FOLDER, "src");
		String sourceGenFolder = getFolder(OptionTypes.SOURCE_GEN_FOLDER, "src-gen");
		
		Set<String> sourceFolders = new LinkedHashSet<String>();
		sourceFolders.add(sourceFolder + "/");
		// only the resource plug-in has a 'src-gen' folder
		if (plugin == PluginDescriptor.RESOURCE_PLUGIN) {
			sourceFolders.add(sourceGenFolder + "/");
		}

		StringBuilder sc = new StringBuilder();
		
		Collection<String> binIncludes = getBinIncludes();
		sc.append("bin.includes = " + StringUtil.explode(binIncludes, ",\\\n"));
		sc.append("\n");
		sc.append("source.. = " + StringUtil.explode(sourceFolders, ","));
		sc.append("\n");

		out.write(sc.toString());
		return true;
	}

	private String getFolder(OptionTypes option, String defaultValue) {
		String folderOptionValue = OptionManager.INSTANCE.getStringOptionValue(getContext().getConcreteSyntax(), option);
		String folder = defaultValue;
		if (folderOptionValue != null) {
			folder = folderOptionValue;
		}
		return folder;
	}
	
	private Collection<String> getBinIncludes() {
		Collection<String> binIncludes = new LinkedHashSet<String>();
		binIncludes.add("META-INF/");
		binIncludes.add(".");
		if (plugin == PluginDescriptor.RESOURCE_PLUGIN) {
			binIncludes.add("icons/");
			binIncludes.add("css/");
			binIncludes.add("plugin.xml");
		}
		return binIncludes;
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		throw new UnsupportedOperationException();
	}
}
