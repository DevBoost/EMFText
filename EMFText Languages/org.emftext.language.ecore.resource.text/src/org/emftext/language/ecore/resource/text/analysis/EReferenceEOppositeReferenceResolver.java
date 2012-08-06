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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.ecore.resource.text.ITextEcoreReferenceResolveResult;
import org.emftext.language.ecore.resource.text.ITextEcoreReferenceResolver;

public class EReferenceEOppositeReferenceResolver implements ITextEcoreReferenceResolver<org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EReference> {
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EReference element, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITextEcoreReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		EClass oppositeType = container.getEReferenceType();
		if (!resolveFuzzy) {
			EStructuralFeature opposite = oppositeType.getEStructuralFeature(identifier);
			result.addMapping(identifier, (EReference) opposite);
		} else {
			EList<EReference> references = oppositeType.getEReferences();
			for (EReference structuralFeature : references) {
				if (structuralFeature.getName().startsWith(identifier)) {
					result.addMapping(structuralFeature.getName(), structuralFeature);
				}
			}
		}
		
	}

	public void setOptions(Map<?, ?> options) {
	}
}
