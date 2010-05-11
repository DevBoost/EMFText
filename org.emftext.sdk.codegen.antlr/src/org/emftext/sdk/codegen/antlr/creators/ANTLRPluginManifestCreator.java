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
package org.emftext.sdk.codegen.antlr.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.antlr.ANTLRGenerationContext;
import org.emftext.sdk.codegen.antlr.ANTLRPluginArtifacts;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.generators.ManifestGenerator;
import org.emftext.sdk.codegen.parameters.ManifestParameters;

public class ANTLRPluginManifestCreator extends GenericArtifactCreator<ANTLRGenerationContext, ManifestParameters> {

	public ANTLRPluginManifestCreator(ArtifactDescriptor<ANTLRGenerationContext, ManifestParameters> artifact, ManifestParameters parameters) {
		super(artifact, parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ANTLRGenerationContext context, ManifestParameters parameters) {
		final File project = context.getProjectFolder(ANTLRPluginArtifacts.ANTLR_PLUGIN);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");

		IGenerator<ANTLRGenerationContext, ManifestParameters> generator = new ManifestGenerator<ANTLRGenerationContext>(context, parameters);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		manifestMFFile,
	    		"Exception while generating manifest file."
	    );
	}

	@Override
	public boolean doOverride(ANTLRGenerationContext context) {
		return true;
	}
}
