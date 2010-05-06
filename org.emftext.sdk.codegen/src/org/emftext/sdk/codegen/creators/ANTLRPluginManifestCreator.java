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
import org.emftext.sdk.codegen.generators.AntlrPluginManifestGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ANTLRPluginManifestCreator extends TextResourceArtifactCreator {

	public ANTLRPluginManifestCreator() {
		super("manifest");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		final File project = context.getProjectFolder(TextResourcePlugins.ANTLR_PLUGIN);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");

		IGenerator<GenerationContext> generator = new AntlrPluginManifestGenerator(context);
		
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
