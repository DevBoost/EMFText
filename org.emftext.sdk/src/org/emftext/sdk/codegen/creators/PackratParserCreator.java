package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.PackratParserGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class PackratParserCreator extends AbstractArtifactCreator {

	private static final String NAME = "packrat parser";

	public PackratParserCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File file = context.getPackratParserFile();
		PackratParserGenerator generator = new PackratParserGenerator(context);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + NAME + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DOT_CLASSPATH;
	}
}
