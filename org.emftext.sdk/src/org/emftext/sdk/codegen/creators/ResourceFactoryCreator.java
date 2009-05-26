package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ResourceFactoryGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java file for the resource factory class using the content
 * provided by ResourceFactoryGenerator.
 */
public class ResourceFactoryCreator extends AbstractArtifactCreator {

	public ResourceFactoryCreator() {
		super("resource factory");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		IGenerator resourceFactoryGen = new ResourceFactoryGenerator(context);
        File resourceFactoryFile = context.getResourceFactoryFile();
		Artifact artifact = new Artifact(resourceFactoryFile, invokeGeneration(resourceFactoryGen, context.getProblemCollector()));
		return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_RESOURCE_FACTORY;
	}
}
