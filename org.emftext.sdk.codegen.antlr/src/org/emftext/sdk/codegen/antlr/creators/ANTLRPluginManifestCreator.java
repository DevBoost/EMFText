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
import org.emftext.sdk.codegen.ManifestParameters;
import org.emftext.sdk.codegen.antlr.ANTLRGenerationContext;
import org.emftext.sdk.codegen.antlr.ANTLRPluginArtifacts;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.generators.ManifestGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ANTLRPluginManifestCreator extends GenericArtifactCreator<ANTLRGenerationContext, ManifestParameters<ANTLRGenerationContext>> {

	public ANTLRPluginManifestCreator(ArtifactDescriptor<ANTLRGenerationContext, ManifestParameters<ANTLRGenerationContext>> artifact, ManifestParameters<ANTLRGenerationContext> parameters) {
		super(artifact, parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ANTLRGenerationContext context, ManifestParameters<ANTLRGenerationContext> parameters) {
		final File project = context.getProjectFolder(ANTLRPluginArtifacts.ANTLR_PLUGIN);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");

		IGenerator<ANTLRGenerationContext, ManifestParameters<ANTLRGenerationContext>> generator = new ManifestGenerator<ANTLRGenerationContext>(context, parameters);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		manifestMFFile,
	    		"Exception while generating manifest file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
	}
}
