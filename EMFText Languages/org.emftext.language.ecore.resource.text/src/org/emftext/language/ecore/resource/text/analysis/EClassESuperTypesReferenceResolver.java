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
package org.emftext.language.ecore.resource.text.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.ecore.resource.text.ITextEcoreReferenceResolveResult;
import org.emftext.language.ecore.resource.text.ITextEcoreReferenceResolver;
import org.emftext.language.ecore.resource.text.analysis.helper.EMFTypesResolver;

public class EClassESuperTypesReferenceResolver implements ITextEcoreReferenceResolver<org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EClass> {
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.eclipse.emf.ecore.EClass container, org.eclipse.emf.ecore.EReference reference) {
		return new EMFTypesResolver().doDeResolve(element, container);
	}
	
	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EClass container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITextEcoreReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		new EMFTypesResolver().doResolve(identifier, container, reference, EcorePackage.eINSTANCE.getEClass(), resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
