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
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ManifestGenerator;
import org.emftext.sdk.codegen.parameters.ManifestParameters;

/**
 * Create a MANIFEST.MF in the META-INF folder of generated text resource
 * plug-ins using the ManifestGenerator class to retrieve content for this
 * file.
 */
public class ManifestCreator<ContextType extends IContext> extends GenericArtifactCreator<ContextType, ManifestParameters> {

	public static final String FILENAME = "MANIFEST.MF";
	private boolean override;

	public ManifestCreator(ICodeGenerationComponent parent, ArtifactDescriptor<ContextType, ManifestParameters> artifact, ManifestParameters parameters, boolean override) {
		super(parent, artifact, parameters);
		this.override = override;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, ManifestParameters parameters) {
		final File project = getFileSystemConnector().getProjectFolder(plugin);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + FILENAME);

		IGenerator<ContextType, ManifestParameters> generator = new ManifestGenerator<ContextType>(this, context, parameters);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		manifestMFFile,
	    		"Exception while generating manifest file."
	    );
	}

	public boolean doOverride(ContextType context) {
		return override;
	}
}
