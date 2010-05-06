package org.emftext.sdk.codegen.newproject.generators;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.newproject.creators.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.creators.NewProjectParameters;

public class GenModelGenerator extends AbstractGenerator<NewProjectGenerationContext> {

	private static final GenModelFactory GEN_MODEL_FACTORY = GenModelFactory.eINSTANCE;

	public GenModelGenerator() {
		super();
	}

	public GenModelGenerator(NewProjectGenerationContext context) {
		super(context);
	}

	public boolean generate(OutputStream outputStream) {
		NewProjectParameters parameters = context.getParameters();

		GenModel genModel = GEN_MODEL_FACTORY.createGenModel();
		//GenPackage genPackage = GEN_MODEL_FACTORY.createGenPackage();
		//genPackage.setEcorePackage(context.getEPackage());
		List<EPackage> ePackages = new ArrayList<EPackage>();
		ePackages.add(context.getEPackage());
		genModel.initialize(ePackages);
		genModel.setModelDirectory(parameters.getSrcFolder());
		
		String projectName = parameters.getProjectName();
		String metaModelFolder = parameters.getMetamodelFolder();
		String genModelFileName = parameters.getGenmodelFile();
		String pathToGenModel = projectName + "/" + metaModelFolder + "/" + genModelFileName;
		
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createPlatformResourceURI(pathToGenModel, true));
		r.getContents().add(genModel);
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
		return new GenModelGenerator(context);
	}
}
