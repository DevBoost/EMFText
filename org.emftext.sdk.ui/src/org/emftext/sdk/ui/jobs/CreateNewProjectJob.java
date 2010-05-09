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
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.generators.IResourceMarker;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.codegen.newproject.creators.NewProjectContentsCreator;

public class CreateNewProjectJob extends AbstractCreatePluginJob {

	private NewProjectParameters parameters;
	private IResourceMarker resourceMarker;
	
	public CreateNewProjectJob(NewProjectParameters parameters, IResourceMarker resourceMarker) {
		super();
		this.parameters = parameters;
		this.resourceMarker = resourceMarker;
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
		context.setMonitor(monitor);
		context.setResourceMarker(resourceMarker);
		new NewProjectContentsCreator().generate(context, null, monitor);
		refresh(monitor, project);
		refresh(monitor, getProject(TextResourcePlugins.RESOURCE_PLUGIN.getName(context.getConcreteSyntax())));
		refresh(monitor, getProject(TextResourcePlugins.ANTLR_PLUGIN.getName(null)));
		
		// TODO expose problems to user
		for (GenerationProblem problem : problems) {
			System.out.println("CreateNewProjectJob.run() " + problem);
		}
	}

	public IProject createProject(IProgressMonitor progress, IPluginDescriptor<NewProjectGenerationContext> plugin, String pluginName) throws Exception {
		
		IProject getProject = getProject(pluginName);
		IProject project = getProject;
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		JavaCore.create(project);
		return project;
	}

	private IProject getProject(String pluginName) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(pluginName);
	}
}
