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
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.BuildPropertiesParameters;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BuildPropertiesGenerator;

public class BuildPropertiesCreator<ContextType extends IContext> extends GenericArtifactCreator<ContextType, BuildPropertiesParameters<ContextType>> {

	public BuildPropertiesCreator(ArtifactDescriptor<ContextType, BuildPropertiesParameters<ContextType>> artifact, BuildPropertiesParameters<ContextType> parameters) {
		super(artifact, parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, BuildPropertiesParameters<ContextType> parameters) {
		
		File buildPropertiesFile = new File(getFileSystemConnector().getProjectFolder(parameters.getProject()).getAbsolutePath() + File.separator + "build.properties");

		IGenerator<ContextType, BuildPropertiesParameters<ContextType>> generator = new BuildPropertiesGenerator<ContextType>(context, parameters);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		buildPropertiesFile,
	    		"Exception while generating build.properties file."
	    );
	}
	
	@Override
	protected boolean doOverride(ContextType context) {
		return true;
		// TODO mseifert: disable this creator in the content creators if 
		// override option is set to false
		/*
		if (parameters.getProject() == TextResourcePlugins.RESOURCE_PLUGIN) {
			return OptionTypes.OVERRIDE_BUILD_PROPERTIES;
		} else {
			return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		}
		*/
	}
}
