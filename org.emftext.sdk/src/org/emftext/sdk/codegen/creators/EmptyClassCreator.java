package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.EmptyClassGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class EmptyClassCreator extends AbstractArtifactCreator {

	private File file;
	private String className;

	public EmptyClassCreator(File file, String className) {
		super("empty " + className);
		this.file = file;
		this.className = className;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		IGenerator generator = new EmptyClassGenerator(context, className);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + getArtifactDescription() + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		// TODO mseifert
		return null;
	}
}
