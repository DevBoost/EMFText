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
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.TokenResolverGenerator;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java files for the token resolvers using the content
 * provided by TokenResolverGenerator. A token resolver is generated
 * for all tokens that are used and that are not imported.
 */
public class TokenResolversCreator extends TextResourceArtifactCreator<CompleteTokenDefinition> {

	public TokenResolversCreator(ICodeGenerationComponent parent, CompleteTokenDefinition parameters) {
		super(parent, TextResourceArtifacts.TOKEN_RESOLVERS, parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, CompleteTokenDefinition parameters) {
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>();
		
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		File resolverFile = context.getTokenResolverFile(syntax, parameters);
		TokenResolverGenerator resolverGenerator = (TokenResolverGenerator) TokenResolverGenerator.PROVIDER.newInstance(getParent(), context, parameters);

		artifacts.addAll(createArtifact(
	    		context,
	    		resolverGenerator,
	    		resolverFile,
	    		"Exception while generating token resolver."
	    ));

		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_TOKEN_RESOLVERS;
	}
}
