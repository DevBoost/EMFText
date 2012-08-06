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
package org.emftext.sdk.ui.syntaxgenerator.jobs;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.sdk.generatorconfig.FeatureReference;
import org.emftext.sdk.generatorconfig.resource.generatorconfig.util.AbstractGeneratorconfigInterpreter;

public class GeneratorConfigInterpreter extends AbstractGeneratorconfigInterpreter<Boolean, InterpreterContext> {

	@Override
	public Boolean interprete_org_emftext_sdk_generatorconfig_FeatureReference(
			FeatureReference object, InterpreterContext context) {
		
		String featureName = object.getFeatureName();
		EPackage metaModel = context.getMetaModel();
		// TODO search feature
		return true;
	}
}
