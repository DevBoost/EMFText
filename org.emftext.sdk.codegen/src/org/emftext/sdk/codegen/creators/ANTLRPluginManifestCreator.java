package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.AntlrPluginManifestGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ANTLRPluginManifestCreator extends AbstractArtifactCreator {

	public ANTLRPluginManifestCreator() {
		super("manifest");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		final File project = context.getProjectFolder(EPlugins.ANTLR_PLUGIN);
		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");

		IGenerator generator = new AntlrPluginManifestGenerator(context);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		manifestMFFile,
	    		"Exception while generating manifest file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
	}
}
