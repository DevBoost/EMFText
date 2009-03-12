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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.IResourceMarker;
import org.emftext.sdk.codegen.generators.ResourcePluginGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A custom generator that creates adds a new project to the current
 * Eclipse workspace before generating the test resource plug-in.
 */
public class UIResourcePluginGenerator extends ResourcePluginGenerator {

	@Override
	public Result run(ConcreteSyntax concreteSyntax, GenerationContext context,
			IResourceMarker marker, IProgressMonitor monitor)
			throws Exception {
		
		Result result = super.run(concreteSyntax, context, marker, monitor);

		UIGenerationContext uiContext = (UIGenerationContext) context;
		uiContext.getProject().refreshLocal(IProject.DEPTH_INFINITE, monitor);

		return result;
	}

	public void createProject(GenerationContext context, SubMonitor progress)
		throws CoreException, JavaModelException {
		
		UIGenerationContext uiContext = (UIGenerationContext) context;
		
		String projectName = context.getPluginName();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists()) {
			project.create(progress.newChild(TICKS_CREATE_PROJECT));
		} else {
			progress.internalWorked(TICKS_CREATE_PROJECT);
		}
		project.open(progress.newChild(TICKS_OPEN_PROJECT));
		IJavaProject javaProject = JavaCore.create(project);
		
		uiContext.setJavaProject(javaProject);
	}
}
