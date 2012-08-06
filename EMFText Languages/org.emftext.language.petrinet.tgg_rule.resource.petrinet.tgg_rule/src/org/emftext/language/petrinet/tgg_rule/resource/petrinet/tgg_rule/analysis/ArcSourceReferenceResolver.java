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
package org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.analysis;

public class ArcSourceReferenceResolver implements org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.IPetrinet_tgg_ruleReferenceResolver<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.RefNodes> {
	
	private org.emftext.language.petrinet.resource.petrinet.analysis.ArcSourceReferenceResolver delegate = new org.emftext.language.petrinet.resource.petrinet.analysis.ArcSourceReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.IPetrinet_tgg_ruleReferenceResolveResult<org.emftext.language.petrinet.RefNodes> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceResolveResult<org.emftext.language.petrinet.RefNodes>() {
			
			public boolean wasResolvedUniquely() {
				return result.wasResolvedUniquely();
			}
			
			public boolean wasResolvedMultiple() {
				return result.wasResolvedMultiple();
			}
			
			public boolean wasResolved() {
				return result.wasResolved();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public java.util.Collection<org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceMapping<org.emftext.language.petrinet.RefNodes>> getMappings() {
				throw new UnsupportedOperationException();
			}
			
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier) {
				result.addMapping(identifier, newIdentifier);
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
				result.addMapping(identifier, newIdentifier, warning);
			}
			
			public void addMapping(String identifier, org.emftext.language.petrinet.RefNodes target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.petrinet.RefNodes target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.petrinet.RefNodes element, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
