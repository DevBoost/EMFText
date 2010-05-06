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
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.PluginDescriptor;
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.creators.CreateTextResourcePluginsJob;
import org.emftext.sdk.codegen.generators.IResourceMarker;

/**
 * A custom generator that creates adds a new project to the current
 * Eclipse workspace before generating the test resource plug-in.
 */
public class UIResourcePluginGenerator extends CreateTextResourcePluginsJob {

	@Override
	public Result run(GenerationContext context,
			IResourceMarker marker, IProgressMonitor monitor)
			throws Exception {
		
		Result result = super.run(context, marker, monitor);

		UIGenerationContext uiContext = (UIGenerationContext) context;
		refresh(monitor, uiContext.getProject(TextResourcePlugins.RESOURCE_PLUGIN));
		refresh(monitor, uiContext.getProject(TextResourcePlugins.ANTLR_PLUGIN));

		return result;
	}

	public void createProject(GenerationContext context, SubMonitor progress, PluginDescriptor plugin)
		throws CoreException, JavaModelException {
		
		UIGenerationContext uiContext = (UIGenerationContext) context;
		
		String projectName = plugin.getName(context);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		IJavaProject javaProject = JavaCore.create(project);
		
		uiContext.setJavaProject(plugin, javaProject);
	}
}
