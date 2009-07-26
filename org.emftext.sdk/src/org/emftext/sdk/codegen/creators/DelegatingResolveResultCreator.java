package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.DelegatingResolveResultGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DelegatingResolveResultCreator extends AbstractArtifactCreator {

	private static final String NAME = "DelegatingResolveResult";

	public DelegatingResolveResultCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.DELEGATING_RESOLVE_RESULT);
		IGenerator generator = new DelegatingResolveResultGenerator(context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT;
	}
}
