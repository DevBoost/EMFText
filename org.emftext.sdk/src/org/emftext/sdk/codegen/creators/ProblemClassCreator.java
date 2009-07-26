package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ProblemClassGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ProblemClassCreator extends AbstractArtifactCreator {

	private static final String NAME = "problem class";

	public ProblemClassCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File file = context.getFile(EArtifact.PROBLEM);
		IGenerator generator = new ProblemClassGenerator(context);
		
		return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + NAME + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PROBLEM_CLASS;
	}
}
