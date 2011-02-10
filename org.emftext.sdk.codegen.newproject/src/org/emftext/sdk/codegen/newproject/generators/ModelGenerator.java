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
package org.emftext.sdk.codegen.newproject.generators;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.codegen.parameters.SimpleParameter;

/**
 * An abstract superclass for all generators that produce models. This class
 * takes care of serializing the generator models by saving them to EMF resources.
 */
public abstract class ModelGenerator extends AbstractGenerator<NewProjectGenerationContext, SimpleParameter<NewProjectGenerationContext, String>> {

	public ModelGenerator() {
		super();
	}

	@Override
	public final void generate(NewProjectGenerationContext context, SimpleParameter<NewProjectGenerationContext, String> parameters, OutputStream outputStream) {
		init(context, parameters);
		
		EObject generatedModel = generateModel();
		ResourceSet rs = new ResourceSetImpl();
		String modelPath = getModelPath();
		Resource r = rs.createResource(URI.createPlatformResourceURI(modelPath, true));
		r.getContents().add(generatedModel);
		try {
			r.save(outputStream, null);
		} catch (IOException e) {
			addProblem(new GenerationProblem(e.getMessage(), null));
		}
	}
	
	protected String getFileInMetaModelFolder(String fileName) {
		NewProjectParameters parameters = getContext().getParameters();
		String projectName = parameters.getProjectName();
		String metaModelFolder = parameters.getMetamodelFolder();
		String pathToMetaModel = projectName + "/" + metaModelFolder + "/" + fileName;
		return pathToMetaModel;
	}

	public abstract String getModelPath();
	public abstract EObject generateModel();
}
