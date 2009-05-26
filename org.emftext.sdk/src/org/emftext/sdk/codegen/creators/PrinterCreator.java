package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.generators.TextPrinterGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java file for the printer class using the content
 * provided by TextPrinterGenerator.
 */
public class PrinterCreator extends AbstractArtifactCreator {

	public PrinterCreator() {
		super("printer class");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		boolean generatePrinterStubOnly = OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OptionTypes.GENERATE_PRINTER_STUB_ONLY);
		
	    File printerFile = context.getPrinterFile();

	    IGenerator printerGenerator;
		if (generatePrinterStubOnly) {
    		printerGenerator = new TextPrinterGenerator(context, false);
		} else {
    		printerGenerator = new TextPrinterGenerator(context, true);
		}
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>(1);
		artifacts.add(new Artifact(printerFile, invokeGeneration(printerGenerator, context.getProblemCollector())));
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PRINTER;
	}
}
