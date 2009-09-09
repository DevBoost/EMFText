package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ParseResultGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ParseResultCreator extends AbstractArtifactCreator {

	public ParseResultCreator() {
		super("parse result class");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File file = context.getFile(EArtifact.PARSE_RESULT);

   		IGenerator generator = new ParseResultGenerator(context);
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating parse result class."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PARSE_RESULT;
	}
}
