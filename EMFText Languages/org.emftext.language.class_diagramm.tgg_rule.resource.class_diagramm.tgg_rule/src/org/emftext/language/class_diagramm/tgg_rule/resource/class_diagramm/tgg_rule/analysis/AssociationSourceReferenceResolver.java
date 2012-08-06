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
package org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.analysis;

public class AssociationSourceReferenceResolver implements org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleReferenceResolver<org.emftext.language.class_diagramm.Association, org.emftext.language.class_diagramm.RefClass> {
	
	private org.emftext.language.class_diagramm.resource.class_diagramm.analysis.AssociationSourceReferenceResolver delegate = new org.emftext.language.class_diagramm.resource.class_diagramm.analysis.AssociationSourceReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.class_diagramm.Association container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleReferenceResolveResult<org.emftext.language.class_diagramm.RefClass> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.class_diagramm.resource.class_diagramm.IClass_diagrammReferenceResolveResult<org.emftext.language.class_diagramm.RefClass>() {
			
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
			
			public java.util.Collection<org.emftext.language.class_diagramm.resource.class_diagramm.IClass_diagrammReferenceMapping<org.emftext.language.class_diagramm.RefClass>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.class_diagramm.RefClass target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.class_diagramm.RefClass target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.class_diagramm.RefClass element, org.emftext.language.class_diagramm.Association container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
