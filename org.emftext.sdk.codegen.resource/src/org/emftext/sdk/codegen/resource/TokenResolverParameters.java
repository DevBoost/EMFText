package org.emftext.sdk.codegen.resource;

import org.emftext.sdk.codegen.parameters.AbstractArtifactParameter;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;

public class TokenResolverParameters extends AbstractArtifactParameter<GenerationContext, TokenResolverParameters> {

	private CompleteTokenDefinition definition;

	public TokenResolverParameters(CompleteTokenDefinition definition) {
		super(TextResourceArtifacts.TOKEN_RESOLVER);
		this.definition = definition;
	}

	public CompleteTokenDefinition getDefinition() {
		return definition;
	}
}
