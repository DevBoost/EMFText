package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ContextDependentURIFragmentGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ContextDependentURIFragmentCreator extends AbstractArtifactCreator {

	private static final String NAME = "ContextDependentURIFragment";

	public ContextDependentURIFragmentCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT);
		IGenerator generator = new ContextDependentURIFragmentGenerator(context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT;
	}
}
