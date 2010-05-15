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

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a set of given folders.
 */
public class FoldersCreator<ContextType> extends AbstractGenerationComponent implements IArtifactCreator<ContextType> {

	private File[] folders;

	public FoldersCreator(ICodeGenerationComponent parent, File... folders) {
		super(parent);
		this.folders = folders;
	}

	public void createArtifacts(IPluginDescriptor plugin, ContextType context) {
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
