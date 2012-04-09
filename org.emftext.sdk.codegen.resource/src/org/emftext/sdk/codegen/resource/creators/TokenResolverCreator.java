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
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TokenResolverParameters;
import org.emftext.sdk.codegen.resource.generators.TokenResolverGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java file for one token resolvers using the content
 * provided by a TokenResolverGenerator. A token resolver is generated
 * for all tokens that are used and that are not imported.
 */
public class TokenResolverCreator extends TextResourceArtifactCreator<TokenResolverParameters> {

	public TokenResolverCreator(TokenResolverParameters parameters) {
		super(parameters);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, TokenResolverParameters parameters) {
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>();
		
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		File resolverFile = context.getTokenResolverFile(syntax, parameters.getDefinition());
		TokenResolverGenerator resolverGenerator = new TokenResolverGenerator();

		artifacts.addAll(createArtifact(
	    		context,
	    		parameters,
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
