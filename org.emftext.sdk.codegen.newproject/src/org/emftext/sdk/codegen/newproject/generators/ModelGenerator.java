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
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;

/**
 * An abstract superclass for all generators that produce models. This class
 * takes care of serializing the generator models by saving them to EMF resources.
 */
public abstract class ModelGenerator extends AbstractGenerator<NewProjectGenerationContext, Object> {

	public ModelGenerator() {
		super();
	}

	public ModelGenerator(ICodeGenerationComponent parent, NewProjectGenerationContext context) {
		super(parent, context, null);
	}
	
	public void generate(OutputStream outputStream) {
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
		NewProjectParameters parameters = context.getParameters();
		String projectName = parameters.getProjectName();
		String metaModelFolder = parameters.getMetamodelFolder();
		String pathToMetaModel = projectName + "/" + metaModelFolder + "/" + fileName;
		return pathToMetaModel;
	}

	public abstract String getModelPath();
	public abstract EObject generateModel();
}
