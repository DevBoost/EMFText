package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.EmptyClassGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class EmptyClassCreator extends AbstractArtifactCreator {

	private File file;
	private String className;
	private OptionTypes overrideOption;

	public EmptyClassCreator(File file, String className, OptionTypes overrideOption) {
		super("empty " + className);
		this.file = file;
		this.className = className;
		this.overrideOption = overrideOption;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		EmptyClassGenerator generator = (EmptyClassGenerator) new EmptyClassGenerator().newInstance(context);
		generator.setClassName(className);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + getArtifactDescription() + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
