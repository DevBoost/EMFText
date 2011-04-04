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
package org.emftext.sdk.codegen.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;

public class GenModelUtil {
	
	public enum ProjectType {
		MODEL, EDIT, EDITOR, TESTS
	}

	/**
	 * Runs the EMF code generation for the given generator
	 * package.
	 * 
	 * @param genPackage the package to generate code for
	 * @param monitor a progress monitor to track progress
	 */
	public void generateMetaModelCode(
			GenPackage genPackage,
			IProgressMonitor monitor,
			ProjectType projectType) {
		monitor.setTaskName("generating metamodel code...");
			
		GenModel genModel = genPackage.getGenModel();
		genModel.setCanGenerate(true);

		// generate the code
		Generator generator = new Generator();
		generator.setInput(genModel);
		String type = GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE;
		if (projectType == ProjectType.EDIT) {
			type = GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE;
		}
		if (projectType == ProjectType.EDITOR) {
			type = GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE;
		}
		if (projectType == ProjectType.TESTS) {
			type = GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE;
		}
		generator.generate(genModel,
				type,
				new BasicMonitor.EclipseSubProgress(monitor, 100));
	}
}
