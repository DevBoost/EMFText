/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ant;

import java.io.File;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This class implements a custom GenerationContext that is slightly
 * different from the GenerationContext used when generating text
 * resource plug-in in Eclipse.
 */
public class AntGenerationContext extends GenerationContext {

	private File workspaceRootFolder;
	private String syntaxProjectName;

	public AntGenerationContext(
			ConcreteSyntax concreteSyntax,
			File workspaceRootFolder,
			String syntaxProjectName,
			IProblemCollector problemCollector) {
		super(concreteSyntax, problemCollector);
		this.workspaceRootFolder = workspaceRootFolder;
		this.syntaxProjectName = syntaxProjectName;
	}

	public File getPluginProjectFolder() {
		return new File(workspaceRootFolder.getAbsolutePath() + File.separator + getPluginName());
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
}
