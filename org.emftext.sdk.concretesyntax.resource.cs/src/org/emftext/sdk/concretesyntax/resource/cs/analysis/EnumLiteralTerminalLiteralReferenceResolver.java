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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;


public class EnumLiteralTerminalLiteralReferenceResolver implements ICsReferenceResolver<EnumLiteralTerminal, EEnumLiteral> {
	
	private CsDefaultResolverDelegate<EnumLiteralTerminal, EEnumLiteral> delegate = new CsDefaultResolverDelegate<EnumLiteralTerminal, EEnumLiteral>();
	
	public void resolve(String identifier, EnumLiteralTerminal container, EReference reference, int position, boolean resolveFuzzy, final ICsReferenceResolveResult<EEnumLiteral> result) {
		EObject parent = container.eContainer();
		if (!(parent instanceof EnumTerminal)) {
			return;
		}
		EnumTerminal enumTerminal = (EnumTerminal) parent;
		GenFeature genFeature = enumTerminal.getFeature();
		if (genFeature == null) {
			return;
		}
		EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		if (ecoreFeature == null) {
			return;
		}
		EClassifier eType = ecoreFeature.getEType();
		if (eType == null) {
			return;
		}
		// we use tryToResolveIdentifierInObjectTree() instead of resolver(), because we
		// want to search only for EEnumLiterals in the referenced EEnum
		delegate.tryToResolveIdentifierInObjectTree(identifier, container, eType, reference, position, resolveFuzzy, result, true);
	}
	
	public String deResolve(EEnumLiteral element, EnumLiteralTerminal container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
