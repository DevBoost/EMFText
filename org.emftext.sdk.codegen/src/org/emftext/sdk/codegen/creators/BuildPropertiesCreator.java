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

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.generators.BuildPropertiesGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BuildPropertiesCreator extends TextResourceArtifactCreator<IPluginDescriptor<GenerationContext>> {

	public BuildPropertiesCreator(IPluginDescriptor<GenerationContext> plugin) {
		super("build properties", plugin);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context, IPluginDescriptor<GenerationContext> parameters) {
		
		File buildPropertiesFile = new File(context.getProjectFolder(parameters).getAbsolutePath() + File.separator + "build.properties");

		IGenerator<GenerationContext, IPluginDescriptor<GenerationContext>> generator = new BuildPropertiesGenerator(context, parameters);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		buildPropertiesFile,
	    		"Exception while generating build.properties file."
	    );
	}

	public OptionTypes getOverrideOption() {
		if (parameters == TextResourcePlugins.RESOURCE_PLUGIN) {
			return OptionTypes.OVERRIDE_BUILD_PROPERTIES;
		} else {
			return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		}
	}
}
