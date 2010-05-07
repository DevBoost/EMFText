package org.emftext.sdk.codegen.newproject;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractGenerationContext;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.generators.IResourceMarker;

public class NewProjectGenerationContext extends AbstractGenerationContext<NewProjectGenerationContext> {

	private IPluginDescriptor<NewProjectGenerationContext> pluginDescriptor;
	private NewProjectParameters parameters;
	private IProject project;
	private EPackage ePackage;
	private GenPackage genPackage;
	private IProgressMonitor monitor;
	private IResourceMarker resourceMarker;

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

	public EPackage getEPackage() {
		return ePackage;
	}

	public void setEPackage(EPackage ePackage) {
		this.ePackage = ePackage;
	}

	public GenPackage getGenPackage() {
		return genPackage;
	}

	public void setGenPackage(GenPackage genPackage) {
		this.genPackage = genPackage;
	}

	public IProgressMonitor getMonitor() {
		return monitor;
	}

	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	public IResourceMarker getResourceMarker() {
		return resourceMarker;
	}

	public void setResourceMarker(IResourceMarker resourceMarker) {
		this.resourceMarker = resourceMarker;
	}
}
