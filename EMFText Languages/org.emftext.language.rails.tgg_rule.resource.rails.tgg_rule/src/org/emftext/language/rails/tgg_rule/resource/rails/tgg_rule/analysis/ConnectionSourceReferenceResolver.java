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
package org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.analysis;

public class ConnectionSourceReferenceResolver implements org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.IRails_tgg_ruleReferenceResolver<org.emftext.language.rails.Connection, org.emftext.language.rails.Out> {
	
	private org.emftext.language.rails.resource.rails.analysis.ConnectionSourceReferenceResolver delegate = new org.emftext.language.rails.resource.rails.analysis.ConnectionSourceReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rails.Connection container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.IRails_tgg_ruleReferenceResolveResult<org.emftext.language.rails.Out> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.rails.resource.rails.IRailsReferenceResolveResult<org.emftext.language.rails.Out>() {
			
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
			
			public java.util.Collection<org.emftext.language.rails.resource.rails.IRailsReferenceMapping<org.emftext.language.rails.Out>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.rails.Out target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.rails.Out target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.rails.Out element, org.emftext.language.rails.Connection container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
