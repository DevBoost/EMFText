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
import org.emftext.sdk.codegen.generators.ManifestGenerator;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Create a MANIFEST.MF in the META-INF folder of generated text resource
 * plug-ins using the ManifestGenerator class to retrieve content for this
 * file.
 * 
 * TODO mseifert: replace two creators (ResourcePluginManifestCreator and
 * ResourceUIPluginManifestCreator) with a single one.
 */
public class ResourcePluginManifestCreator extends TextResourceArtifactCreator<ManifestParameters> {

	public ResourcePluginManifestCreator(ManifestParameters parameters) {
		super(TextResourceArtifacts.MANIFEST, parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, ManifestParameters parameters) {
		final File project = getFileSystemConnector().getProjectFolder(plugin);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");

		IGenerator<GenerationContext, ManifestParameters> generator = new ManifestGenerator<GenerationContext>(context, parameters);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		manifestMFFile,
	    		"Exception while generating manifest file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_MANIFEST;
	}
}
