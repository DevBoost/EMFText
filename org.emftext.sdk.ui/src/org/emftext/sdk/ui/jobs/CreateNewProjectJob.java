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
import org.emftext.sdk.codegen.newproject.creators.NewProjectParameters;

public class CreateNewProjectJob extends AbstractCreatePluginJob {

	private NewProjectParameters parameters;
	
	public CreateNewProjectJob(NewProjectParameters parameters) {
		super();
		this.parameters = parameters;
	}

	public void run(IProgressMonitor monitor) throws Exception {
		IProblemCollector problemConnector = new IProblemCollector() {
			
			public void addProblem(GenerationProblem problem) {
				// TODO handle problem 
			}
		};
		NewProjectGenerationContext context = new NewProjectGenerationContext(parameters, problemConnector);
		IProject project = createProject(monitor, NewProjectConstants.NEW_PROJECT_PLUGIN);
		new NewProjectContentsCreator().generate(context, monitor);
		refresh(monitor, project);
	}

	public IProject createProject(IProgressMonitor progress, IPluginDescriptor<NewProjectGenerationContext> plugin) throws Exception {
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(plugin.getName(null));
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		JavaCore.create(project);
		return project;
	}
}
