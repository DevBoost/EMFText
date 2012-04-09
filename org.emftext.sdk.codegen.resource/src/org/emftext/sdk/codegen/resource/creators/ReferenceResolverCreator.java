/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.ReferenceResolverParameters;
import org.emftext.sdk.codegen.resource.generators.ReferenceResolverGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java files for one reference resolvers using the content
 * provided by a ReferenceResolverGenerator. A reference resolver is generated
 * for each non-containment reference in the CS specification that is not
 * imported.
 */
public class ReferenceResolverCreator extends TextResourceArtifactCreator<ReferenceResolverParameters> {

	private final GeneratorUtil genUtil = new GeneratorUtil();
	
	public ReferenceResolverCreator(ReferenceResolverParameters parameters) {
		super(parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, ReferenceResolverParameters parameters) {
		IGenerator<GenerationContext, ReferenceResolverParameters> generator = new ReferenceResolverGenerator();
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>();
		ConcreteSyntax syntax = context.getConcreteSyntax();
		IPluginDescriptor resourcePlugin = context.getResourcePlugin();
		File resolverFile = genUtil.getResolverFile(
				syntax, 
				parameters.getReference(),
				context.getFileSystemConnector().getProjectFolder(resourcePlugin).getAbsolutePath()
		);
		artifacts.addAll(createArtifact(
	    		context,
	    		parameters,
	    		generator,
	    		resolverFile,
	    		"Exception while generating reference resolver."
	    ));
		
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
	}
}
