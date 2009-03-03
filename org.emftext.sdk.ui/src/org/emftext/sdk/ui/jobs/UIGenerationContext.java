package org.emftext.sdk.ui.jobs;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A custom context that is used when a text resource plug-in
 * is generated in Eclipse.
 */
public class UIGenerationContext extends GenerationContext {

	public UIGenerationContext(ConcreteSyntax concreteSyntax,
			IProblemCollector problemCollector) {
		super(concreteSyntax, problemCollector);
	}

	private IJavaProject javaProject;

	public IProject getProject() {
		return javaProject.getProject();
	}

	public IJavaProject getJavaProject() {
		return javaProject;
	}

	public void setJavaProject(IJavaProject project) {
		this.javaProject = project;
	}

	public File getPluginProjectFolder() {
		return javaProject.getProject().getLocation().toFile().getAbsoluteFile();
	}

	@Override
	public String getSyntaxProjectName() {
		return getWorkspaceFile().getProject().getName();
	}

	@Override
	public String getProjectRelativePathToSyntaxFile() {
		return getWorkspaceFile().getProjectRelativePath().toString();
	}

	private IFile getWorkspaceFile() {
		return (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(getConcreteSyntax().eResource().getURI().toPlatformString(true));
	}
}
