package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.NewFileWizardGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Create the NewFileWizard class using the content provided by the
 * NewFileWizardGenerator.
 */
public class NewFileWizardCreator extends AbstractArtifactCreator {

	public NewFileWizardCreator() {
		super("new file wizard");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File newFileActionFile = context.getNewFileWizardFile();
		IGenerator generator = new NewFileWizardGenerator(context);
		
		Artifact artifact = new Artifact(newFileActionFile, invokeGeneration(generator, context.getProblemCollector()));
		return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_NEW_FILE_WIZARD;
	}
}
