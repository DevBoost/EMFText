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
package org.emftext.test.printing.resource.printing.analysis;

public class PrintingTEXTTokenResolver implements org.emftext.test.printing.resource.printing.IPrintingTokenResolver {
	
	private org.emftext.test.printing.resource.printing.analysis.PrintingDefaultTokenResolver defaultTokenResolver = new org.emftext.test.printing.resource.printing.analysis.PrintingDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if ("ambigousAttribute".equals(feature.getName())) {
			if (Boolean.TRUE.equals(value)) {
				return "true";
			} else {
				return "false";
			}
		} else {
			java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
			return result;
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.test.printing.resource.printing.IPrintingTokenResolveResult result) {
		if ("ambigousAttribute".equals(feature.getName())) {
			if ("true".equals(lexem) || "yes".equals(lexem)) {
				result.setResolvedToken(Boolean.TRUE);
			} else {
				result.setResolvedToken(Boolean.FALSE);
			}
		} else {
			defaultTokenResolver.resolve(lexem, feature, result);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
