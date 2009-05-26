package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.TextResourceGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java file for the text resource class using the content
 * provided by TextResourceGenerator.
 */
public class TextResourceCreator extends AbstractArtifactCreator {

	public TextResourceCreator() {
		super("text resource");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File resourceFile = context.getTextResourceFile();
		IGenerator generator = new TextResourceGenerator(context);
		
		Artifact artifact = new Artifact(resourceFile, invokeGeneration(generator, context.getProblemCollector()));
		return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_TEXT_RESOURCE;
	}
}
