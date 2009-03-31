package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.DotProjectGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DotProjectCreator extends AbstractArtifactCreator {

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		File dotProjectFile = new File(context.getPluginProjectFolder().getAbsolutePath() + File.separator + ".project");
		
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>(1);
		artifacts.add(new Artifact(dotProjectFile, invokeGeneration(new DotProjectGenerator(context), context.getProblemCollector())));
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DOT_PROJECT;
	}
}
