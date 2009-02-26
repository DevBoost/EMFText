package org.emftext.sdk.ui.jobs;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
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
		
		UIGenerationContext uiContext = (UIGenerationContext) context;

		Result result = super.run(concreteSyntax, context, marker, monitor);

		uiContext.getProject().refreshLocal(IProject.DEPTH_INFINITE, monitor);

		return result;
	}

	public void createProject(GenerationContext context, SubMonitor progress)
		throws CoreException, JavaModelException {
		
		UIGenerationContext uiContext = (UIGenerationContext) context;
		
		String projectName = context.getPackageName();
		IJavaProject javaProject = createJavaProject(progress, projectName);
		uiContext.setJavaProject(javaProject);
		setClasspath(context, progress);
	}

	private IJavaProject createJavaProject(SubMonitor progress,
			String projectName) throws CoreException, JavaModelException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				projectName);
		if (!project.exists()) {
			project.create(progress.newChild(TICKS_CREATE_PROJECT));
		} else {
			progress.internalWorked(TICKS_CREATE_PROJECT);
		}
		project.open(progress.newChild(TICKS_OPEN_PROJECT));
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID,
				"org.eclipse.pde.PluginNature" });
		ICommand command1 = description.newCommand();
		command1.setBuilderName("org.eclipse.jdt.core.javabuilder");
		ICommand command2 = description.newCommand();
		command2.setBuilderName("org.eclipse.pde.ManifestBuilder");
		ICommand command3 = description.newCommand();
		command3.setBuilderName("org.eclipse.pde.SchemaBuilder");
		description.setBuildSpec(new ICommand[] { command1, command2, command3 });
		project.setDescription(description, null);

		IJavaProject javaProject = JavaCore.create(project);
		return javaProject;
	}

	private void setClasspath(GenerationContext context, SubMonitor progress)
		throws JavaModelException {
		
		UIGenerationContext uiContext = (UIGenerationContext) context;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		
		IPath srcLocation= Path.fromOSString(context.getSourceFolder().getAbsolutePath());
		IFile[] srcFolders = root.findFilesForLocation(srcLocation);
		IFile srcFolder = srcFolders[0];
		
		IPath outLocation= Path.fromOSString(context.getOutputFolder().getAbsolutePath());
		IFile[] outFolders = root.findFilesForLocation(outLocation);
		IFile outFolder = outFolders[0];
		
		uiContext.getJavaProject().setRawClasspath(new IClasspathEntry[] {
				JavaCore.newSourceEntry(srcFolder.getFullPath()),
				JavaCore.newContainerEntry(new Path(JavaRuntime.JRE_CONTAINER)),
				JavaCore.newContainerEntry(new Path(
						"org.eclipse.pde.core.requiredPlugins")) }, outFolder
				.getFullPath(), progress.newChild(TICKS_SET_CLASSPATH));
	}
}
