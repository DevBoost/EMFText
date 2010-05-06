package org.emftext.sdk.ui.jobs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractCreatePluginJob;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IProblemCollector;
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
		final List<GenerationProblem> problems = new ArrayList<GenerationProblem>();
		IProblemCollector problemConnector = new IProblemCollector() {
			
			public void addProblem(GenerationProblem problem) {
				problems.add(problem);
			}
		};
		IPluginDescriptor<NewProjectGenerationContext> newProjectPlugin = new IPluginDescriptor<NewProjectGenerationContext>() {

			public String getName(NewProjectGenerationContext context) {
				return context.getParameters().getProjectName();
			}
		};
		IProject project = createProject(monitor, newProjectPlugin, parameters.getProjectName());
		NewProjectGenerationContext context = new NewProjectGenerationContext(project, newProjectPlugin, parameters, problemConnector);
		new NewProjectContentsCreator().generate(context, monitor);
		refresh(monitor, project);
		
		// TODO expose problems to user
		for (GenerationProblem problem : problems) {
			System.out.println("CreateNewProjectJob.run() " + problem);
		}
	}

	public IProject createProject(IProgressMonitor progress, IPluginDescriptor<NewProjectGenerationContext> plugin, String pluginName) throws Exception {
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginName);
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		JavaCore.create(project);
		return project;
	}
}
