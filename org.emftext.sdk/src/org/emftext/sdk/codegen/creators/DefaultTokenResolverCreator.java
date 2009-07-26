package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.DefaultTokenResolverGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DefaultTokenResolverCreator extends AbstractArtifactCreator {

	private static final String NAME = "DefaultTokenResolver";

	public DefaultTokenResolverCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.DEFAULT_TOKEN_RESOLVER);
		IGenerator generator = new DefaultTokenResolverGenerator(context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER;
	}
}
