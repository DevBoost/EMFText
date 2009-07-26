package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.PluginMetaInformationGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class PluginMetaInformationCreator extends AbstractArtifactCreator {

	private static final String PLUG_IN_META_INFORMATION = "plug-in meta information class";

	public PluginMetaInformationCreator() {
		super(PLUG_IN_META_INFORMATION);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		IGenerator generator = new PluginMetaInformationGenerator(context);
        File file = context.getFile(EArtifact.META_INFORMATION);
		return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + PLUG_IN_META_INFORMATION + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PLUGIN_META_INFORMATION_CLASS;
	}
}
