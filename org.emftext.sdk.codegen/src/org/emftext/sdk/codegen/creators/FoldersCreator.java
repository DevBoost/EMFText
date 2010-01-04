/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.creators;

import java.io.File;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the given folders.
 * The names of this folders may vary depending on the values set for
 * options OptionTypes.SOURCE_FOLDER and OptionTypes.SOURCE_GEN_FOLDER.
 * 
 * @see org.emftext.sdk.concretesyntax.OptionTypes
 */
public class FoldersCreator implements IArtifactCreator {

	private File[] folders;

	public FoldersCreator(File... folders) {
		this.folders = folders;
	}

	public void createArtifacts(GenerationContext context) {
		for (File folder : folders) {
			createIfNeeded(folder);
		}
	}

	private void createIfNeeded(File targetFolder) {
		if (!targetFolder.exists()) {
		   	targetFolder.mkdirs();
		}
	}

	public OptionTypes getOverrideOption() {
		// there is not option to prevent the creation of the folders
		return null;
	}

	public String getArtifactDescription() {
		return "folders";
	}
}
