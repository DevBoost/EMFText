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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.resource.efactory.analysis.helper.CustomEfactoryDefaultResolverDelegate;

public class ReferenceValueReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.Reference, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate<org.emftext.language.efactory.Reference, org.eclipse.emf.ecore.EObject> delegate = new CustomEfactoryDefaultResolverDelegate<org.emftext.language.efactory.Reference, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, org.emftext.language.efactory.Reference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (!(container.eContainer() instanceof Feature)) {
			return;
		}
		Feature feature = (Feature) container.eContainer();
		if (feature.getEFeature() instanceof EReference) {
			EReference realReference = (EReference) feature.getEFeature();
			delegate.resolve(identifier, container, realReference, position, resolveFuzzy, result);
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.efactory.Reference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
