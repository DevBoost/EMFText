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

public class FacetValuesReferenceResolver implements org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolver<org.emftext.language.description.Facet, org.emftext.language.description.FacetValue> {
	
	private org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.Facet, org.emftext.language.description.FacetValue> delegate = new org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.Facet, org.emftext.language.description.FacetValue>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.description.Facet container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolveResult<org.emftext.language.description.FacetValue> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.description.FacetValue element, org.emftext.language.description.Facet container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
