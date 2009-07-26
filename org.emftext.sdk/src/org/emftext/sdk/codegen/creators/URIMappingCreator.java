package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.URIMappingGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class URIMappingCreator extends AbstractArtifactCreator {

	private static final String NAME = "URIMapping";

	public URIMappingCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.URI_MAPPING);
		IGenerator generator = new URIMappingGenerator(context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_URI_MAPPING;
	}
}
