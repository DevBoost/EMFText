/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.syntax_analysis;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that checks whether the EMF generator model referenced
 * by a syntax is valid. If not, an error is raised.
 */
public class GenModelAnalyser extends AbstractPostProcessor {

	public static final String INVALID_GENMODEL_MESSAGE = "The genmodel (%s) is invalid. Please reconcile it.";

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		GenPackage genPackage = syntax.getPackage();
		if (genPackage == null || genPackage.eIsProxy()) {
			return;
		}
		GenModel genModel = genPackage.getGenModel();
		if (genModel == null || genModel.eIsProxy()) {
			return;
		}
		IStatus status = genModel.validate();
		if (status.getSeverity() == IStatus.ERROR) {
			// TODO we can give more detailed information about what is wrong
			// with the genmodel by iterating over status.getChildren(), but
			// the question is how to pass this information to the user in a 
			// meaningful way. Often there is a lot of errors in the genmodel
			// and adding all of them to the resource might cause confusion. 
			String path = genModel.eResource().getURI().toString();
			addProblem(resource, ECsProblemType.INVALID_GEN_MODEL, String.format(INVALID_GENMODEL_MESSAGE, path), 0, 0, 0, 0);
		}
	}

	@Override
	protected boolean doAnalysisAfterPreviousErrors() {
		return true;
	}

	@Override
	protected boolean doResolveProxiesBeforeAnalysis() {
		return false;
	}
}
