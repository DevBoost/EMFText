package org.emftext.sdk.codegen.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;

public class GenModelUtil {

	/**
	 * Runs the EMF code generation for the given generator
	 * package.
	 * 
	 * @param genPackage the package to generate code for
	 * @param monitor a progress monitor to track progress
	 */
	public void generateMetaModelCode(
			GenPackage genPackage,
			IProgressMonitor monitor) {
		monitor.setTaskName("generating metamodel code...");
			
		GenModel genModel = genPackage.getGenModel();
		genModel.setCanGenerate(true);

		// generate the code
		Generator generator = new Generator();
		generator.setInput(genModel);
		generator.generate(genModel,
				GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor.EclipseSubProgress(monitor, 100));
	}
}
