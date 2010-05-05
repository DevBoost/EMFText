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
package org.emftext.sdk.ant;

import java.io.File;

import org.emftext.sdk.PluginDescriptor;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This class implements a custom GenerationContext that is slightly
 * different from the GenerationContext used when generating text
 * resource plug-ins in Eclipse.
 */
public class AntGenerationContext extends GenerationContext {

	private File workspaceRootFolder;
	private String syntaxProjectName;
	private boolean generateANTLRPlugin;

	public AntGenerationContext(
			ConcreteSyntax concreteSyntax,
			File workspaceRootFolder,
			String syntaxProjectName,
			IProblemCollector problemCollector,
			boolean generateANTLRPlugin) {
		super(concreteSyntax, problemCollector);
		this.workspaceRootFolder = workspaceRootFolder;
		this.syntaxProjectName = syntaxProjectName;
		this.generateANTLRPlugin = generateANTLRPlugin;
	}

	public File getProjectFolder(PluginDescriptor plugin) {
		return new File(workspaceRootFolder.getAbsolutePath() + File.separator + getPluginName(plugin));
	}

	@Override
	public String getSyntaxProjectName() {
		return syntaxProjectName;
	}

	@Override
	public String getProjectRelativePathToSyntaxFile() {
		String syntaxFilePath = getConcreteSyntaxFile().getAbsolutePath();
		String syntaxPluginFolderPath = workspaceRootFolder.getAbsolutePath() + File.separator + getSyntaxProjectName() + File.separator;
		return syntaxFilePath.substring(syntaxPluginFolderPath.length()).replace(File.separator, "/");
	}

	@Override
	public boolean getGenerateANTLRPlugin() {
		return generateANTLRPlugin;
	}
}
