package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;

public class NewFileIconCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
		File iconsDir = context.getIconsDir();
		iconsDir.mkdir();
		
		InputStream in = AbstractNewFileWizard.class.getResourceAsStream("default_new_icon.gif");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(context.getNewIconFile());
			int read;
			while ((read = in.read()) >= 0) {
				fos.write(read);
			}
			fos.close();
		} catch (IOException e) {
			EMFTextRuntimePlugin.logError("Error while copying icon.", e);
		}
	}

	public String getArtifactDescription() {
		return "new file icon";
	}
}
