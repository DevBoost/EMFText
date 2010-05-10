package org.emftext.sdk.codegen.newproject;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.IResourceMarker;
import org.emftext.sdk.codegen.creators.AbstractGenerationComponent;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class NewProjectGenerationContext extends AbstractGenerationComponent implements IContext {

	private IPluginDescriptor pluginDescriptor;
	private NewProjectParameters parameters;
	private IProject project;
	private EPackage ePackage;
	private GenPackage genPackage;
	private IProgressMonitor monitor;
	private IResourceMarker resourceMarker;
	private ConcreteSyntax concreteSyntax;
	private GenerationContext generationContext;

	public NewProjectGenerationContext(
			IProject project,
			IPluginDescriptor pluginDescriptor,
			NewProjectParameters parameters) {
		super();
		this.project = project;
		this.pluginDescriptor = pluginDescriptor;
		this.parameters = parameters;
	}

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<?, ?> artifact) {
		return new File(getPackagePath(artifact) + File.separator + artifact.getClassNameSuffix());
	}

	public String getPackagePath(ArtifactDescriptor<?, ?> artifact) {
		File targetFolder = getProjectFolder(null);
		String targetFolderPath = targetFolder.getAbsolutePath();
		String packagePath = targetFolderPath + File.separator + artifact.getPackage() + File.separator;
		return packagePath;
	}

	public File getProjectFolder(IPluginDescriptor plugin) {
		return project.getLocation().toFile().getAbsoluteFile();
	}

	public NewProjectParameters getParameters() {
		return parameters;
	}

	public IPluginDescriptor getPluginDescriptor() {
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

	public ConcreteSyntax getConcreteSyntax() {
		return concreteSyntax;
	}

	public void setConcreteSyntax(ConcreteSyntax concreteSyntax) {
		this.concreteSyntax = concreteSyntax;
	}

	public GenerationContext getGenerationContext() {
		return generationContext;
	}

	public void setGenerationContext(GenerationContext generationContext) {
		this.generationContext = generationContext;
	}
}
