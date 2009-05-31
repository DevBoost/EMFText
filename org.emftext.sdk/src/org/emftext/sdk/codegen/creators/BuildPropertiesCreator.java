package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.BuildPropertiesGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BuildPropertiesCreator extends AbstractArtifactCreator {

	public BuildPropertiesCreator() {
		super("build properties");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File buildPropertiesFile = new File(context.getPluginProjectFolder().getAbsolutePath() + File.separator + "build.properties");

		BuildPropertiesGenerator generator = new BuildPropertiesGenerator(context);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		buildPropertiesFile,
	    		"Exception while generating build.properties file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_BUILD_PROPERTIES;
	}
}
