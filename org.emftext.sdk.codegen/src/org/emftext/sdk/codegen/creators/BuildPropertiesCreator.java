package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BuildPropertiesGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BuildPropertiesCreator extends AbstractArtifactCreator {

	private EPlugins plugin;

	public BuildPropertiesCreator(EPlugins plugin) {
		super("build properties");
		this.plugin = plugin;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File buildPropertiesFile = new File(context.getProjectFolder(plugin).getAbsolutePath() + File.separator + "build.properties");

		IGenerator generator = new BuildPropertiesGenerator(context, plugin);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		buildPropertiesFile,
	    		"Exception while generating build.properties file."
	    );
	}

	public OptionTypes getOverrideOption() {
		if (plugin == EPlugins.RESOURCE_PLUGIN) {
			return OptionTypes.OVERRIDE_BUILD_PROPERTIES;
		} else {
			return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		}
	}
}
