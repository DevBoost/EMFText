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

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;

/**
 * Creates the folder META-INF in generated text resource plug-ins.
 */
public class MetaInfFolderCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
		File project = context.getProjectFolder(EPlugins.RESOURCE_PLUGIN);
		File metaFolder = new File(project.getAbsolutePath() + File.separator +  "META-INF");
		if (!metaFolder.exists()) {
			metaFolder.mkdir();
		}
	}

	public String getArtifactDescription() {
		return "META-INF folder";
	}
}
