package org.emftext.sdk.codegen.newproject.generators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IGeneratorProvider;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;

/**
 * Initializes a new generator model from the Ecore model generated before.
 */
public class GenModelGenerator extends ModelGenerator {

	private static final GenModelFactory GEN_MODEL_FACTORY = GenModelFactory.eINSTANCE;

	public static final IGeneratorProvider<NewProjectGenerationContext, Object> PROVIDER = new GeneratorProvider<NewProjectGenerationContext, Object>(new GenModelGenerator());

	private GenModelGenerator() {
		super();
	}

	public GenModelGenerator(ICodeGenerationComponent parent, NewProjectGenerationContext context) {
		super(parent, context);
	}

	public EObject generateModel() {
		NewProjectParameters parameters = context.getParameters();
		
		URI genModelURI = URI.createPlatformResourceURI(getModelPath(), true);

		GenModel genModel = GEN_MODEL_FACTORY.createGenModel();
		List<EPackage> ePackages = new ArrayList<EPackage>();
		ePackages.add(context.getEPackage());
		genModel.initialize(ePackages);
		genModel.setModelDirectory(parameters.getProjectName() + "/" + parameters.getSrcFolder());
		genModel.setModelPluginID(parameters.getProjectName());

        GenPackage genPackage = genModel.getGenPackages().get(0);
        genModel.setModelName(genModelURI.trimFileExtension().lastSegment());

        genPackage.setPrefix(parameters.getName());
        genPackage.setBasePackage(parameters.getBasePackage());
		context.setGenPackage(genPackage);
        return genModel;
	}

	public IGenerator<NewProjectGenerationContext, Object> newInstance(
			ICodeGenerationComponent parent, NewProjectGenerationContext context, Object parameters) {
		return new GenModelGenerator(parent, context);
	}

	@Override
	public String getModelPath() {
		NewProjectParameters parameters = context.getParameters();
		String genModelFileName = parameters.getGenmodelFile();
		return getFileInMetaModelFolder(genModelFileName);
	}
}
