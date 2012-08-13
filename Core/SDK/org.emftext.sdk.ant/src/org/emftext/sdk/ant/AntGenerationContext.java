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
package org.emftext.sdk.ant;

import java.io.File;

import org.emftext.sdk.codegen.IFileSystemConnector;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This class implements a custom GenerationContext that is slightly
 * different from the GenerationContext used when generating text
 * resource plug-ins in Eclipse.
 */
public class AntGenerationContext extends GenerationContext {

	private final File workspaceRootFolder;
	private String syntaxProjectName;
	private boolean generateANTLRPlugin;
	private boolean generateModelCode;

	public AntGenerationContext(
			IFileSystemConnector fileSystemConnector,
			IProblemCollector problemCollector,
			ConcreteSyntax concreteSyntax,
			final File workspaceRootFolder,
			String syntaxProjectName,
			boolean generateANTLRPlugin,
			boolean generateModelCode) {
		super(fileSystemConnector, problemCollector, concreteSyntax);
		this.workspaceRootFolder = workspaceRootFolder;
		this.syntaxProjectName = syntaxProjectName;
		this.generateANTLRPlugin = generateANTLRPlugin;
		this.generateModelCode = generateModelCode;
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

	@Override
	public boolean getGeneratorModelCode() {
		return generateModelCode;
	}
}
