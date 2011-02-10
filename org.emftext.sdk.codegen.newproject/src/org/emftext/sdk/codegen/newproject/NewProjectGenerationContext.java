/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.newproject;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractGenerationContext;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IFileSystemConnector;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.IResourceMarker;
import org.emftext.sdk.codegen.ISyntaxContext;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This context class is passed along the generators and creators that are used while
 * creating a new EMFText project. It carries the parameters that were given by users
 * for creating the new project.
 */
public class NewProjectGenerationContext extends AbstractGenerationContext<NewProjectGenerationContext> implements ISyntaxContext {

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
			IFileSystemConnector fileSystemConnector, 
			IProblemCollector problemCollector,
			IProject project,
			IPluginDescriptor pluginDescriptor,
			NewProjectParameters parameters) {
		super(fileSystemConnector, problemCollector);
		this.project = project;
		this.pluginDescriptor = pluginDescriptor;
		this.parameters = parameters;
	}

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<NewProjectGenerationContext, ?> artifact) {
		return new File(getPackagePath(artifact) + File.separator + artifact.getClassNameSuffix());
	}

	public String getPackagePath(ArtifactDescriptor<?, ?> artifact) {
		File targetFolder = getProjectFolder(null);
		String targetFolderPath = targetFolder.getAbsolutePath();
		String packagePath = targetFolderPath + File.separator + artifact.getPackage().getName(this) + File.separator;
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
