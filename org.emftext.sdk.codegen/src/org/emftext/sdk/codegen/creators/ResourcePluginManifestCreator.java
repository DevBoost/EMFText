/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ResourcePluginManifestGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Create a MANIFEST.MF in the META-INF folder of generated text resource
 * plug-ins using the ManifestGenerator class to retrieve content for this
 * file.
 */
public class ResourcePluginManifestCreator extends AbstractArtifactCreator {

	public ResourcePluginManifestCreator() {
		super("manifest");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		final File project = context.getProjectFolder(EPlugins.RESOURCE_PLUGIN);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");

		IGenerator generator = new ResourcePluginManifestGenerator(context);
		
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
