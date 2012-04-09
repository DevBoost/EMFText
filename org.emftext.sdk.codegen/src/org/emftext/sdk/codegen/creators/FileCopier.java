/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.util.StreamUtil;

/**
 * Copies files.
 */
public class FileCopier<ContextType extends IContext<ContextType>> implements IArtifactCreator<ContextType> {

	private InputStream inputStream;
	private File targetFile;
	private boolean override;

	public FileCopier(InputStream inputStream, File targetFile, boolean override) {
		this.inputStream = inputStream;
		this.targetFile = targetFile;
		this.override = override;
	}

	public void createArtifacts(IPluginDescriptor plugin, ContextType context) {
		if (!override && targetFile.exists()) {
			return;
		}
		try {
			StreamUtil.storeContentIfChanged(targetFile, inputStream);
		} catch (IOException e) {
			addError(context, e);
		} catch (NullPointerException e) {
			addError(context, e);
		}
	}

	private void addError(ContextType context, Exception e) {
		context.getProblemCollector().addProblem(new GenerationProblem("Exception while copying " + targetFile.getName() + ".", null, GenerationProblem.Severity.ERROR, e));
		EMFTextSDKPlugin.logError("Error while copying " + targetFile.getName() + ".", e);
	}

	public String getArtifactTypeDescription() {
		return targetFile.getName();
	}
}
