/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.newproject.generators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.util.StringUtil;

/**
 * Initializes a new generator model from the Ecore model generated before.
 */
public class GenModelGenerator extends ModelGenerator {

	private static final GenModelFactory GEN_MODEL_FACTORY = GenModelFactory.eINSTANCE;

	public GenModelGenerator() {
		super();
	}

	public EObject generateModel(NewProjectParameters parameters) {
		String projectName = parameters.getProjectName();
		String srcFolder = parameters.getSrcFolder();
        String name = parameters.getName();
        String basePackage = parameters.getBasePackage();
		
		return generateModel(projectName, srcFolder, name, basePackage, getModelPath());
	}

	public EObject generateModel(String projectName, String srcFolder,
			String name, String basePackage, String getModelPath) {
		EPackage ePackage = getContext().getEPackage();
		GenModel genModel = generateGenModel(projectName, srcFolder, name,
				basePackage, getModelPath, ePackage);
        getContext().setGenPackage(genModel.getGenPackages().get(0));
        return genModel;
	}

	public GenModel generateGenModel(String projectName, String srcFolder,
			String name, String basePackage, String getModelPath,
			EPackage ePackage) {
		URI genModelURI = URI.createPlatformResourceURI(getModelPath, true);

		GenModel genModel = GEN_MODEL_FACTORY.createGenModel();
		List<EPackage> ePackages = new ArrayList<EPackage>();
		ePackages.add(ePackage);
		genModel.initialize(ePackages);
		genModel.setModelDirectory("/" + projectName + "/" + srcFolder);
		genModel.setModelPluginID(projectName);
		genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);

        GenPackage genPackage = genModel.getGenPackages().get(0);
        genModel.setModelName(genModelURI.trimFileExtension().lastSegment());

		genPackage.setPrefix(StringUtil.capitalize(name));
		genPackage.setBasePackage(basePackage);
		return genModel;
	}

	@Override
	public String getModelPath() {
		NewProjectParameters parameters = getContext().getParameters();
		String genModelFileName = parameters.getGenmodelFile();
		return getFileInMetaModelFolder(genModelFileName);
	}
}
