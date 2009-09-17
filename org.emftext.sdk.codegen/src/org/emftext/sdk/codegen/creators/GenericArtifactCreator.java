package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class GenericArtifactCreator extends AbstractArtifactCreator {

	private EArtifact artifact;

	public GenericArtifactCreator(EArtifact artifact) {
		super(artifact.getClassNameSuffix());
		this.artifact = artifact;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File file = context.getFile(artifact);
		IGenerator generator = artifact.createGenerator(context);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + getArtifactDescription() + "."
	    );
	}

	@Override
	public OptionTypes getOverrideOption() {
		return artifact.getOverrideOption();
	}
}
