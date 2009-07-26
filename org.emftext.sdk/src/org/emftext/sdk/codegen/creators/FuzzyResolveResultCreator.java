package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.FuzzyResolveResultGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class FuzzyResolveResultCreator extends AbstractArtifactCreator {

	private static final String NAME = "FuzzyResolveResult";

	public FuzzyResolveResultCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.FUZZY_RESOLVE_RESULT);
		IGenerator generator = new FuzzyResolveResultGenerator(context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT;
	}
}
