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

	public EObject generateModel() {
		NewProjectParameters parameters = getContext().getParameters();
		
		URI genModelURI = URI.createPlatformResourceURI(getModelPath(), true);

		GenModel genModel = GEN_MODEL_FACTORY.createGenModel();
		List<EPackage> ePackages = new ArrayList<EPackage>();
		ePackages.add(getContext().getEPackage());
		genModel.initialize(ePackages);
		genModel.setModelDirectory(parameters.getProjectName() + "/" + parameters.getSrcFolder());
		genModel.setModelPluginID(parameters.getProjectName());
		genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);

        GenPackage genPackage = genModel.getGenPackages().get(0);
        genModel.setModelName(genModelURI.trimFileExtension().lastSegment());

        genPackage.setPrefix(StringUtil.capitalize(parameters.getName()));
        genPackage.setBasePackage(parameters.getBasePackage());
        getContext().setGenPackage(genPackage);
        return genModel;
	}

	@Override
	public String getModelPath() {
		NewProjectParameters parameters = getContext().getParameters();
		String genModelFileName = parameters.getGenmodelFile();
		return getFileInMetaModelFolder(genModelFileName);
	}
}
