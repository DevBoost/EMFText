package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ScannerlessScannerGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ScannerlessScannerCreator extends AbstractArtifactCreator {

	private static final String NAME = "scannerless scanner";

	public ScannerlessScannerCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File file = context.getScannerlessScannerFile();
		IGenerator generator = new ScannerlessScannerGenerator(context);
		
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
