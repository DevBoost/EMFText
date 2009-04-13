package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.generators.TextPrinterBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class PrinterBaseCreator extends AbstractArtifactCreator {

	public PrinterBaseCreator() {
		super("printer base class");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		boolean generatePrinterStubOnly = OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OptionTypes.GENERATE_PRINTER_STUB_ONLY);
	    File printerBaseFile = context.getPrinterBaseFile();

		Collection<IArtifact> artifacts = new ArrayList<IArtifact>(1);
		if (!generatePrinterStubOnly) {
	        IGenerator printerBaseGenerator = new TextPrinterBaseGenerator(context);
	        artifacts.add(new Artifact(printerBaseFile, invokeGeneration(printerBaseGenerator, context.getProblemCollector())));	    		
    	}
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PRINTER_BASE;
	}
}
