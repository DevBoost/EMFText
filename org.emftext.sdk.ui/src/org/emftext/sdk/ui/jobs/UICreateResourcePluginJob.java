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
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IResourceMarker;
import org.emftext.sdk.codegen.antlr.ANTLRPluginArtifacts;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.CreateTextResourcePluginsJob;

/**
 * A custom generator that creates adds a new project to the current
 * Eclipse workspace before generating the test resource plug-in.
 */
public class UICreateResourcePluginJob extends CreateTextResourcePluginsJob {

	@Override
	public Result run(GenerationContext context,
			IResourceMarker marker, IProgressMonitor monitor)
			throws Exception {
		
		Result result = super.run(context, marker, monitor);

		UIGenerationContext uiContext = (UIGenerationContext) context;
		refresh(monitor, uiContext.getProject(context.getResourcePlugin()));
		refresh(monitor, uiContext.getProject(context.getResourceUIPlugin()));
		refresh(monitor, uiContext.getProject(ANTLRPluginArtifacts.ANTLR_PLUGIN));

		return result;
	}

	public void createProject(IPluginDescriptor plugin, GenerationContext context, SubMonitor progress)
	//public void createProject(GenerationContext context, SubMonitor progress, PluginDescriptor plugin)
		throws CoreException, JavaModelException {
		
		String projectName = plugin.getName();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		IJavaProject javaProject = JavaCore.create(project);

		if (context instanceof UIGenerationContext) {
			UIGenerationContext uiContext = (UIGenerationContext) context;
			uiContext.setJavaProject(plugin, javaProject);
		}
	}
}
