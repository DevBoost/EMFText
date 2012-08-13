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
package org.emftext.sdk.codegen.newproject.creators;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.codegen.util.GenModelUtil;

/**
 * This creator call the EMF code generation to obtain the EMF model code using
 * a generator model.
 */
public class GenerateCodeCreator implements IArtifactCreator<NewProjectGenerationContext> {

	public GenerateCodeCreator() {
		super();
	}

	public void createArtifacts(IPluginDescriptor plugin, NewProjectGenerationContext context) {
		GenModelUtil util = new GenModelUtil();
		GenPackage genPackage = context.getGenPackage();
		IProgressMonitor monitor = context.getMonitor();

		NewProjectParameters parameters = context.getParameters();
		if (parameters.isGenerateModelCode()) {
			util.generateMetaModelCode(genPackage, monitor, GenModelUtil.ProjectType.MODEL);
		}
		if (parameters.isGenerateEditCode()) {
			util.generateMetaModelCode(genPackage, monitor, GenModelUtil.ProjectType.EDIT);
		}
		if (parameters.isGenerateEditorCode()) {
			util.generateMetaModelCode(genPackage, monitor, GenModelUtil.ProjectType.EDITOR);
		}
		if (parameters.isGenerateTestCode()) {
			util.generateMetaModelCode(genPackage, monitor, GenModelUtil.ProjectType.TESTS);
		}
	}

	public String getArtifactTypeDescription() {
		return "metamodel code";
	}
}
