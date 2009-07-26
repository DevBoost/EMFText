package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ReferenceResolveResultGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ReferenceResolveResultCreator extends AbstractArtifactCreator {

	private static final String NAME = "ReferenceResolveResult";

	public ReferenceResolveResultCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.REFERENCE_RESOLVE_RESULT);
		IGenerator generator = new ReferenceResolveResultGenerator(context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT;
	}
}
