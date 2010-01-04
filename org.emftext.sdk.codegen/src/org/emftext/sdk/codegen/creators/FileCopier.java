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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.util.StreamUtil;

/**
 * Creates default icons (for the editor and the NewFileWizard) 
 * and style sheets (for text hovers) of 
 * generated text resources by copying the default_icon.gif and
 * hover_style.css contained in this package.
 */
public class FileCopier implements IArtifactCreator {

	private InputStream inputStream;
	private File targetFile;

	public FileCopier(InputStream inputStream, File targetFile) {
		this.inputStream = inputStream;
		this.targetFile = targetFile;
	}

	public void createArtifacts(GenerationContext context) {
		File iconsDir = context.getIconsDir();
		iconsDir.mkdir();
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(targetFile);
			StreamUtil.copy(inputStream, fos);
			fos.close();
		} catch (IOException e) {
			addError(context, e);
		} catch (NullPointerException e) {
			addError(context, e);
		}
	}

	private void addError(GenerationContext context, Exception e) {
		context.getProblemCollector().addProblem(new GenerationProblem("Exception while copying " + targetFile.getName() + ".", null, GenerationProblem.Severity.ERROR, e));
		EMFTextSDKPlugin.logError("Error while copying " + targetFile.getName() + ".", e);
	}

	public String getArtifactDescription() {
		return targetFile.getName();
	}
}
