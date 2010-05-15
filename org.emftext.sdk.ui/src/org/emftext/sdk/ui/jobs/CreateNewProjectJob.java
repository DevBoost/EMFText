package org.emftext.sdk.ui.jobs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractCreatePluginJob;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.IResourceMarker;
import org.emftext.sdk.codegen.RootComponent;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.codegen.newproject.creators.NewProjectContentsCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class CreateNewProjectJob extends AbstractCreatePluginJob {

	private NewProjectParameters parameters;
	private IResourceMarker resourceMarker;
	
	public CreateNewProjectJob(NewProjectParameters parameters, IResourceMarker resourceMarker) {
		super();
		this.parameters = parameters;
		this.resourceMarker = resourceMarker;
	}

	public void run(IProgressMonitor monitor2) throws Exception {
		SubMonitor progress = SubMonitor.convert(monitor2, 100);

		final List<GenerationProblem> problems = new ArrayList<GenerationProblem>();
		final IProblemCollector problemCollector = new IProblemCollector() {
			
			public void addProblem(GenerationProblem problem) {
				problems.add(problem);
			}
		};
		final String newProjectName = parameters.getProjectName();
		IPluginDescriptor newProjectPlugin = new IPluginDescriptor() {

			public String getName() {
				return newProjectName;
			}
		};
		IProject project = createProject(progress.newChild(2), newProjectPlugin, parameters.getProjectName());
		ICodeGenerationComponent root = new RootComponent(new WorkspaceConnector(), problemCollector);
		NewProjectGenerationContext context = new NewProjectGenerationContext(root, project, newProjectPlugin, parameters);
		context.setMonitor(progress.newChild(92));
		context.setResourceMarker(resourceMarker);
		
		new NewProjectContentsCreator(root).create(newProjectPlugin, context, null, null);
		refresh(progress.newChild(2), project);
		GenerationContext generationContext = context.getGenerationContext();
		refresh(progress.newChild(2), getProject(generationContext.getResourcePlugin().getName()));
		refresh(progress.newChild(2), getProject(generationContext.getResourceUIPlugin().getName()));
		refresh(progress.newChild(2), getProject(generationContext.getAntlrPlugin().getName()));
		
		// TODO expose problems to user
		for (GenerationProblem problem : problems) {
			System.out.println("CreateNewProjectJob.run() " + problem);
		}
	}

	public IProject createProject(IProgressMonitor progress, IPluginDescriptor plugin, String pluginName) throws Exception {
		progress.beginTask("Creating project", 2);
		IProject getProject = getProject(pluginName);
		IProject project = getProject;
		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}
		project.open(new NullProgressMonitor());
		progress.worked(1);
		JavaCore.create(project);
		progress.worked(1);
		return project;
	}

	private IProject getProject(String pluginName) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(pluginName);
	}
}
