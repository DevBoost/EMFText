/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.ui.jobs;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.creators.PluginsCreator;
import org.emftext.sdk.codegen.generators.IResourceMarker;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A custom generator that creates adds a new project to the current
 * Eclipse workspace before generating the test resource plug-in.
 */
public class UIResourcePluginGenerator extends PluginsCreator {

	@Override
	public Result run(ConcreteSyntax concreteSyntax, GenerationContext context,
			IResourceMarker marker, IProgressMonitor monitor)
			throws Exception {
		
		Result result = super.run(concreteSyntax, context, marker, monitor);

		UIGenerationContext uiContext = (UIGenerationContext) context;
		refresh(monitor, uiContext, EPlugins.RESOURCE_PLUGIN);
		refresh(monitor, uiContext, EPlugins.ANTLR_PLUGIN);

		return result;
	}

	private void refresh(IProgressMonitor monitor, UIGenerationContext uiContext, EPlugins plugin)
			throws CoreException {
		IProject project = uiContext.getProject(plugin);
		if (project != null) {
			project.refreshLocal(IProject.DEPTH_INFINITE, monitor);
		}
	}

	public void createProject(GenerationContext context, SubMonitor progress, EPlugins plugin)
		throws CoreException, JavaModelException {
		
		UIGenerationContext uiContext = (UIGenerationContext) context;
		
		String projectName = plugin.getName(context.getConcreteSyntax());
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		IJavaProject javaProject = JavaCore.create(project);
		
		uiContext.setJavaProject(plugin, javaProject);
	}
}
