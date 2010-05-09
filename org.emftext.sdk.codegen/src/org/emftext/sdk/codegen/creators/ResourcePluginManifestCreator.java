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
import org.emftext.sdk.codegen.ManifestParameters;
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.generators.ManifestGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Create a MANIFEST.MF in the META-INF folder of generated text resource
 * plug-ins using the ManifestGenerator class to retrieve content for this
 * file.
 */
public class ResourcePluginManifestCreator extends TextResourceArtifactCreator<ManifestParameters<GenerationContext>> {

	public ResourcePluginManifestCreator(ManifestParameters<GenerationContext> parameters) {
		super("manifest", parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context, ManifestParameters<GenerationContext> parameters) {
		final File project = context.getProjectFolder(TextResourcePlugins.RESOURCE_PLUGIN);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");

		IGenerator<GenerationContext, ManifestParameters<GenerationContext>> generator = new ManifestGenerator<GenerationContext>(context, parameters);
		
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
