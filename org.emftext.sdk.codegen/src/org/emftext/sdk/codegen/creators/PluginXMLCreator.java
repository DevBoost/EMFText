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
package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.generators.PluginXMLGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a plugin.xml file using the content provided by the 
 * PluginXMLGenerator class.
 * 
 * TODO mseifert: make this creator reusable
 */
public class PluginXMLCreator extends TextResourceArtifactCreator<Object> {

	public PluginXMLCreator() {
		super("plugin.xml", null);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context, Object parameters) {
		
		File project = context.getProjectFolder(TextResourcePlugins.RESOURCE_PLUGIN);
		File pluginXMLFile = new File(project.getAbsolutePath() + File.separator + "plugin.xml");

		IGenerator<GenerationContext, Object> generator = new PluginXMLGenerator().newInstance(context, parameters);

	    return createArtifact(
	    		context,
	    		generator,
	    		pluginXMLFile,
	    		"Exception while generating plugin.xml file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PLUGIN_XML;
	}
}
