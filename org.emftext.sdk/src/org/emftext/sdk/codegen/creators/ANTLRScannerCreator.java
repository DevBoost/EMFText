package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ANTLRScannerGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ANTLRScannerCreator extends AbstractArtifactCreator {

	private static final String NAME = "ANTLR scanner";

	public ANTLRScannerCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File file = context.getAntlrScannerFile();
		IGenerator generator = new ANTLRScannerGenerator(context);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + NAME + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_SCANNER;
	}
}
