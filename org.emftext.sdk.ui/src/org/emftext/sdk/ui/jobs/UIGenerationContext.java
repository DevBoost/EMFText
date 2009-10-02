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
package org.emftext.sdk.ui.jobs;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A custom context that is used when a text resource plug-in
 * is generated in Eclipse.
 */
public class UIGenerationContext extends GenerationContext {

	public UIGenerationContext(ConcreteSyntax concreteSyntax,
			IProblemCollector problemCollector) {
		super(concreteSyntax, problemCollector);
	}

	private Map<EPlugins, IJavaProject> javaProjects = new LinkedHashMap<EPlugins, IJavaProject>();

	public IProject getProject(EPlugins plugin) {
		if (!javaProjects.containsKey(plugin)) {
			return null;
		}
		IJavaProject javaProject = javaProjects.get(plugin);
		if (javaProject != null) {
			return javaProject.getProject();
		} else {
			return null;
		}
	}

	public IJavaProject getJavaProject(EPlugins plugin) {
		if (!javaProjects.containsKey(plugin)) {
			return null;
		}
		return javaProjects.get(plugin);
	}

	public void setJavaProject(EPlugins plugin, IJavaProject project) {
		javaProjects.put(plugin, project);
	}

	public File getProjectFolder(EPlugins plugin) {
		return getProject(plugin).getLocation().toFile().getAbsoluteFile();
	}

	@Override
	public String getSyntaxProjectName() {
		return getWorkspaceFile().getProject().getName();
	}

	@Override
	public String getProjectRelativePathToSyntaxFile() {
		return getWorkspaceFile().getProjectRelativePath().toString();
	}

	private IFile getWorkspaceFile() {
		return (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(getConcreteSyntax().eResource().getURI().toPlatformString(true));
	}
}
