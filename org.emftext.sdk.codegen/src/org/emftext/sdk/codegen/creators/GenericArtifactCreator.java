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

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IGenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class GenericArtifactCreator<ContextType extends IGenerationContext<ContextType>> extends AbstractArtifactCreator<ContextType> {

	private ArtifactDescriptor<ContextType> artifact;

	public GenericArtifactCreator(String artifactName) {
		super(artifactName);
	}

	public GenericArtifactCreator(ArtifactDescriptor<ContextType> artifact) {
		super(artifact.getClassNamePrefix() + artifact.getClassNameSuffix());
		this.artifact = artifact;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(ContextType context) {
	    File file = context.getFile(artifact);
		IGenerator<ContextType> generator = artifact.createGenerator(context);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + getArtifactDescription() + "."
	    );
	}

	@Override
	public OptionTypes getOverrideOption() {
		return artifact.getOverrideOption();
	}

	@Override
	protected boolean doOverride(ContextType context) {
		return true;
	}
}
