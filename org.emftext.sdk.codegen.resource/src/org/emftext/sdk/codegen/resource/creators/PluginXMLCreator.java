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
package org.emftext.sdk.codegen.resource.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.PluginXMLGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a plugin.xml file using the content provided by the 
 * PluginXMLGenerator class.
 * 
 * TODO mseifert: make this creator reusable
 */
public class PluginXMLCreator extends TextResourceArtifactCreator<ArtifactParameter<GenerationContext>> {

	public static final String FILENAME = "plugin.xml";

	public PluginXMLCreator() {
		super(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.PLUGIN_XML));
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, ArtifactParameter<GenerationContext> parameters) {
		IPluginDescriptor resourcePlugin = context.getResourcePlugin();
		File project = context.getFileSystemConnector().getProjectFolder(resourcePlugin);
		File pluginXMLFile = new File(project.getAbsolutePath() + File.separator + FILENAME);

		IGenerator<GenerationContext, ArtifactParameter<GenerationContext>> generator = new PluginXMLGenerator();

	    return createArtifact(
	    		context,
	    		parameters,
	    		generator,
	    		pluginXMLFile,
	    		"Exception while generating " + FILENAME + " file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PLUGIN_XML;
	}
}
