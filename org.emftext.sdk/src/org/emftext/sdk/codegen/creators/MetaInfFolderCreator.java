package org.emftext.sdk.codegen.creators;

import java.io.File;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;

public class MetaInfFolderCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
		File project = context.getPluginProjectFolder();
		File metaFolder = new File(project.getAbsolutePath() + File.separator +  "META-INF");
		if (!metaFolder.exists()) {
			metaFolder.mkdir();
		}
	}

	public String getArtifactDescription() {
		return "META-INF folder";
	}
}
