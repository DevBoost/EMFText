/**
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
 *  
 */
package org.emftext.test.generics.resource.generics.analysis;

public class GenericsTEXTTokenResolver implements org.emftext.test.generics.resource.generics.IGenericsTokenResolver {
	
	private org.emftext.test.generics.resource.generics.analysis.GenericsDefaultTokenResolver defaultTokenResolver = new org.emftext.test.generics.resource.generics.analysis.GenericsDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.test.generics.resource.generics.IGenericsTokenResolveResult result) {
		// custom resolve code because the generic feature has type EJavaObject
		if ("a".equals(lexem)) {
			result.setResolvedToken("a");
		}
		if ("2".equals(lexem)) {
			result.setResolvedToken(2);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
