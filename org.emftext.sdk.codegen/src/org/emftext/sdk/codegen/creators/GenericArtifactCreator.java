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
import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.IGenerator;

/**
 * A generic creator for artifacts. If uses the given ArtifactDescriptor to determine the name and the
 * location of the artifact to generator. The actual code generator class is also obtained from the
 * ArtifactDescriptor.
 *
 * @param <ContextType>
 * @param <ParameterType>
 */
public abstract class GenericArtifactCreator<ContextType extends IContext, ParameterType extends IArtifactParameter<ContextType, ParameterType>> extends AbstractArtifactCreator<ContextType, ParameterType> {

	public GenericArtifactCreator(ParameterType parameters) {
		super(parameters.getArtifact().getClassNamePrefix() + parameters.getArtifact().getClassNameSuffix(), parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, ParameterType parameters) {
	    ArtifactDescriptor<ContextType, ParameterType> artifact = parameters.getArtifact();
		File file = context.getFile(plugin, artifact);
		IGenerator<ContextType, ParameterType> generator = artifact.createGenerator();
		
	    return createArtifact(
	    		context,
	    		parameters,
	    		generator,
	    		file,
	    		"Exception while generating " + getArtifactTypeDescription() + "."
	    );
	}
}
