package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.TokenResolverFactoryGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class TokenResolverFactoryCreator extends AbstractArtifactCreator {

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File tokenResolverFactoryFile = context.getTokenResolverFactoryFile();
		IGenerator generator = new TokenResolverFactoryGenerator(context);
		
		Artifact artifact = new Artifact(tokenResolverFactoryFile, invokeGeneration(generator, context.getProblemCollector()));
		return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY;
	}
}
