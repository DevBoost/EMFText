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
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BuildPropertiesGenerator;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;

/**
 * Create build.properties files according to the given parameters.
 *
 * @param <ContextType>
 */
public class BuildPropertiesCreator<ContextType extends IContext<ContextType>> extends GenericArtifactCreator<ContextType, BuildPropertiesParameters<ContextType>> {

	public static final String FILENAME = "build.properties";
	
	private final boolean override;

	public BuildPropertiesCreator(
			BuildPropertiesParameters<ContextType> parameters,
			boolean override) {
		super(parameters);
		this.override = override;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, BuildPropertiesParameters<ContextType> parameters) {
		
		File buildPropertiesFile = new File(context.getFileSystemConnector().getProjectFolder(parameters.getProject()).getAbsolutePath() + File.separator + FILENAME);

		IGenerator<ContextType, BuildPropertiesParameters<ContextType>> generator = new BuildPropertiesGenerator<ContextType>();
		
	    return createArtifact(
	    		context,
	    		parameters,
	    		generator,
	    		buildPropertiesFile,
	    		"Exception while generating " + FILENAME + " file."
	    );
	}
	
	@Override
	public boolean doOverride(ContextType context) {
		return override;
	}
}
