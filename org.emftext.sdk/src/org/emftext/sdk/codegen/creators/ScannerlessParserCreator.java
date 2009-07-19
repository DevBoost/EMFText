package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ScannerlessParserGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ScannerlessParserCreator extends AbstractArtifactCreator {

	private static final String NAME = "scannerless parser";

	public ScannerlessParserCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File file = context.getScannerlessParserFile();
		IGenerator generator = new ScannerlessParserGenerator(context);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + NAME + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PARSER;
	}
}
