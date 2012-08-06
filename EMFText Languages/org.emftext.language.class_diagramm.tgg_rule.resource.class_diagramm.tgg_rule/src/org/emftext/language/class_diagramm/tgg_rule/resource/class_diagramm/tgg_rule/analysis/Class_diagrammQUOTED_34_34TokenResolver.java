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

public class Class_diagrammQUOTED_34_34TokenResolver implements org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleTokenResolver {
	
	private org.emftext.language.class_diagramm.resource.class_diagramm.analysis.Class_diagrammQUOTED_34_34TokenResolver importedResolver = new org.emftext.language.class_diagramm.resource.class_diagramm.analysis.Class_diagrammQUOTED_34_34TokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new org.emftext.language.class_diagramm.resource.class_diagramm.IClass_diagrammTokenResolveResult() {
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public Object getResolvedToken() {
				return result.getResolvedToken();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public void setResolvedToken(Object resolvedToken) {
				result.setResolvedToken(resolvedToken);
			}
			
		});
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		importedResolver.setOptions(options);
	}
	
}
