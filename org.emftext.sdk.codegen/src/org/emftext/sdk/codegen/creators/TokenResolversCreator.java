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
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.TokenResolverGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;

/**
 * Creates the Java files for the token resolvers using the content
 * provided by TokenResolverGenerator. A token resolver is generated
 * for all tokens that are used and that are not imported.
 */
public class TokenResolversCreator extends AbstractArtifactCreator {

	public TokenResolversCreator() {
		super("token resolvers");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>();
		
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (!tokenDefinition.isUsed()) {
				continue;
			}
			File resolverFile = context.getTokenResolverFile(syntax, tokenDefinition);
			TokenResolverGenerator resolverGenerator = (TokenResolverGenerator) new TokenResolverGenerator().newInstance(context);
			resolverGenerator.setTokenDefinition(tokenDefinition);

			artifacts.addAll(createArtifact(
		    		context,
		    		resolverGenerator,
		    		resolverFile,
		    		"Exception while generating token resolver."
		    ));
		}

		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_TOKEN_RESOLVERS;
	}
}
