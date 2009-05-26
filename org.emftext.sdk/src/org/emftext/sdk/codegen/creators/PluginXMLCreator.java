package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.PluginXMLGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a plugin.xml file using the content provided by the 
 * PluginXMLGenerator class.
 */
public class PluginXMLCreator extends AbstractArtifactCreator {

	public PluginXMLCreator() {
		super("plugin.xml");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File project = context.getPluginProjectFolder();
		File pluginXMLFile = new File(project.getAbsolutePath() + File.separator + "plugin.xml");

		PluginXMLGenerator generator = new PluginXMLGenerator(context);

		Artifact artifact = new Artifact(pluginXMLFile, invokeGeneration(generator, context.getProblemCollector()));
		return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PLUGIN_XML;
	}
}
