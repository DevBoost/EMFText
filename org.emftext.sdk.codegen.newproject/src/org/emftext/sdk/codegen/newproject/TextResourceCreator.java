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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.JavaCore;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.CreateResourcePluginsJob;
import org.emftext.sdk.codegen.resource.ui.CreateResourcePluginsJob.Result;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This class can be used to create the text resource plug-ins for a new EMFText
 * project. It calls the EMF code generation as well as the EMFText code generators.
 */
public class TextResourceCreator implements IArtifactCreator<NewProjectGenerationContext> {

	public void createArtifacts(IPluginDescriptor plugin, final NewProjectGenerationContext context) {
		ResourceSet rs = new ResourceSetImpl();
		NewProjectParameters parameters = context.getParameters();
		String syntaxFile = parameters.getSyntaxFile();
		String syntaxFilePath = parameters.getProjectName() + "/" + parameters.getMetamodelFolder() + "/" + syntaxFile;
		Resource csResource = rs.getResource(URI.createPlatformResourceURI(syntaxFilePath, true), true);
		
		ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
		context.setConcreteSyntax(concreteSyntax);
		GenerationContext genContext = new GenerationContext(context.getFileSystemConnector(), context.getProblemCollector(), concreteSyntax) {

			@Override
			public boolean getGenerateANTLRPlugin() {
				return true;
			}

			@Override
			public String getProjectRelativePathToSyntaxFile() {
				NewProjectParameters parameters = context.getParameters();
				return parameters.getMetamodelFolder() + "/" + parameters.getSyntaxFile();
			}

			@Override
			public String getSyntaxProjectName() {
				return context.getParameters().getProjectName();
			}
		};
		context.setGenerationContext(genContext);
		
		try {
			Result result = new CreateResourcePluginsJob() {

				@Override
				public void createProject(
						IPluginDescriptor plugin, GenerationContext context, SubMonitor progress)
						throws Exception {
					String projectName = plugin.getName();
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					if (!project.exists()) {
						project.create(new NullProgressMonitor());
					}
					project.open(new NullProgressMonitor());
					JavaCore.create(project);
				}
			}.run(genContext, context.getResourceMarker(), context.getMonitor());
			if (result != Result.SUCCESS) {
				context.getProblemCollector().addProblem(new GenerationProblem(result.toString(), concreteSyntax));
			}
		} catch (Exception e) {
			context.getProblemCollector().addProblem(new GenerationProblem("Exception while generating text resource plug-ins: " + e.getMessage(), concreteSyntax));
		}
	}

	public String getArtifactTypeDescription() {
		return "text resource plug-in";
	}
}
