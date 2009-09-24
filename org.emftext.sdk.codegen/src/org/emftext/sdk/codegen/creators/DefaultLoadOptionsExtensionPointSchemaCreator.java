package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.DefaultLoadOptionsExtensionPointSchemaGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DefaultLoadOptionsExtensionPointSchemaCreator extends AbstractArtifactCreator {

	public DefaultLoadOptionsExtensionPointSchemaCreator() {
		super("default_load_options.exsd");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File pluginXMLFile = new File(context.getSchemaFolder().getAbsolutePath() + File.separator + "default_load_options.exsd");
		IGenerator generator = new DefaultLoadOptionsExtensionPointSchemaGenerator(context);

	    return createArtifact(
	    		context,
	    		generator,
	    		pluginXMLFile,
	    		"Exception while generating default_load_options.exsd file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA;
	}
}
