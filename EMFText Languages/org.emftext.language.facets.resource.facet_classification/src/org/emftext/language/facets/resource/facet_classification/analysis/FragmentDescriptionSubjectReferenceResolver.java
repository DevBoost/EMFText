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
package org.emftext.language.facets.resource.facet_classification.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class FragmentDescriptionSubjectReferenceResolver implements org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolver<org.emftext.language.description.FragmentDescription, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.FragmentDescription, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.FragmentDescription, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.description.FragmentDescription container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		EObject target = container.eResource().getResourceSet().getEObject(URI.createURI(identifier), false);
		if (target != null) {
			result.addMapping(identifier, target);
		}
		return;
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.description.FragmentDescription container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
