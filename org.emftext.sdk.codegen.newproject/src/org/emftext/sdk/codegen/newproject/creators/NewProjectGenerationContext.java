package org.emftext.sdk.codegen.newproject.creators;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractGenerationContext;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IProblemCollector;

public class NewProjectGenerationContext extends AbstractGenerationContext<NewProjectGenerationContext> {

	private IPluginDescriptor<NewProjectGenerationContext> pluginDescriptor;
	private NewProjectParameters parameters;
	private IProject project;

	public NewProjectGenerationContext(
			IProject project,
			IPluginDescriptor<NewProjectGenerationContext> pluginDescriptor,
			NewProjectParameters parameters, 
			IProblemCollector problemCollector) {
		super(problemCollector);
		this.project = project;
		this.pluginDescriptor = pluginDescriptor;
		this.parameters = parameters;
	}

	public File getFile(ArtifactDescriptor<NewProjectGenerationContext> artifact) {
		return new File(getPackagePath(artifact) + File.separator + artifact.getClassNameSuffix());
	}

	public String getPackagePath(ArtifactDescriptor<NewProjectGenerationContext> artifact) {
		File targetFolder = getProjectFolder();
		String targetFolderPath = targetFolder.getAbsolutePath();
		String packagePath = targetFolderPath + File.separator + artifact.getPackage() + File.separator;
		return packagePath;
	}

	public File getProjectFolder() {
		return project.getLocation().toFile().getAbsoluteFile();
	}

	public NewProjectParameters getParameters() {
		return parameters;
	}

	public IPluginDescriptor<NewProjectGenerationContext> getPluginDescriptor() {
		return pluginDescriptor;
	}
}
