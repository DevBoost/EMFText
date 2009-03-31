package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.TextResourceGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class TextResourceCreator extends AbstractArtifactCreator {

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
