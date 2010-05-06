package org.emftext.sdk.ui.jobs;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractCreatePluginJob;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.newproject.NewProjectConstants;
import org.emftext.sdk.codegen.newproject.creators.NewProjectContentsCreator;
import org.emftext.sdk.codegen.newproject.creators.NewProjectGenerationContext;

public class CreateNewProjectJob extends AbstractCreatePluginJob {

	public void run(IProgressMonitor monitor) throws Exception {
		IProblemCollector problemConnector = new IProblemCollector() {
			
			public void addProblem(GenerationProblem problem) {
				// TODO handle problem 
			}
		};
		NewProjectGenerationContext context = new NewProjectGenerationContext(problemConnector);
		IProject project = createProject(monitor, NewProjectConstants.NEW_PROJECT_PLUGIN);
		new NewProjectContentsCreator().generate(context, monitor);
		refresh(monitor, project);
	}

	public IProject createProject(IProgressMonitor progress, IPluginDescriptor plugin) throws Exception {
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(plugin.getName(null));
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		JavaCore.create(project);
		return project;
	}
}
