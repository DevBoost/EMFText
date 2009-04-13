package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.DotClasspathGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DotClasspathCreator extends AbstractArtifactCreator {

	public DotClasspathCreator() {
		super(".classpath file");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File dotClasspathFile = new File(context.getPluginProjectFolder().getAbsolutePath() + File.separator + ".classpath");

		DotClasspathGenerator dotClasspathGenerator = new DotClasspathGenerator(context);
		
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>(1);
		artifacts.add(new Artifact(dotClasspathFile, invokeGeneration(dotClasspathGenerator, context.getProblemCollector())));
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DOT_CLASSPATH;
	}
}
