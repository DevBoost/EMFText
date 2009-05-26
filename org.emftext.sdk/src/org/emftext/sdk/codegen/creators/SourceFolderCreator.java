package org.emftext.sdk.codegen.creators;

import java.io.File;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the source folder for generated text resource plug-ins.
 * The name of this folder may vary depending on the value set for
 * option OptionTypes.SOURCE_FOLDER.
 * 
 * @see org.emftext.sdk.concretesyntax.OptionTypes
 */
public class SourceFolderCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
		File targetFolder = context.getSourceFolder();
		if (!targetFolder.exists()) {
		   	targetFolder.mkdir();
		}
	}

	public OptionTypes getOverrideOption() {
		// there is not option to prevent the creation of the source folder
		return null;
	}

	public String getArtifactDescription() {
		return "source folder";
	}
}
