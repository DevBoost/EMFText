package org.emftext.sdk.codegen.newproject.generators;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.newproject.creators.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.creators.NewProjectParameters;

public class MetaModelGenerator extends AbstractGenerator<NewProjectGenerationContext> {

	private static final EcoreFactory ECORE_FACTORY = EcoreFactory.eINSTANCE;

	public MetaModelGenerator() {
		super();
	}

	public MetaModelGenerator(NewProjectGenerationContext context) {
		super(context);
	}

	public boolean generate(OutputStream outputStream) {
		NewProjectParameters parameters = context.getParameters();

		EClass shapeClass = ECORE_FACTORY.createEClass();
		shapeClass.setName("Shape");
		shapeClass.setAbstract(true);
		
		EClass rectangleClass = ECORE_FACTORY.createEClass();
		rectangleClass.setName("Rectangle");
		rectangleClass.getESuperTypes().add(shapeClass);
		
		EClass circleClass = ECORE_FACTORY.createEClass();
		circleClass.setName("Circle");
		circleClass.getESuperTypes().add(shapeClass);

		EPackage ePackage = ECORE_FACTORY.createEPackage();
		ePackage.getEClassifiers().add(shapeClass);
		ePackage.getEClassifiers().add(rectangleClass);
		ePackage.getEClassifiers().add(circleClass);
		
		ePackage.setName(parameters.getName());
		ePackage.setNsPrefix(parameters.getNamespacePrefix());
		ePackage.setNsURI(parameters.getNamespaceUri());

		String projectName = parameters.getProjectName();
		String metaModelFolder = parameters.getMetamodelFolder();
		String metaModelFileName = parameters.getName();
		String pathToMetaModel = projectName + "/" + metaModelFolder + "/" + metaModelFileName;
		
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createPlatformResourceURI(pathToMetaModel, true));
		r.getContents().add(ePackage);
		try {
			r.save(outputStream, null);
			return true;
		} catch (IOException e) {
			addProblem(new GenerationProblem(e.getMessage(), null));
			return false;
		}
	}

	public IGenerator<NewProjectGenerationContext> newInstance(
			NewProjectGenerationContext context) {
		return new MetaModelGenerator(context);
	}
}
