/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver;

// TODO this resolver is buggy. it does escape and unescape backslashes
// and double quotes, but it does not correctly handle escape sequences
// such as \n, \r or \t. Calls to resolve() should replace such sequences
// with the actual character (newline, return or tab). Calls to deResolve()
// should correctly escape such special characters.
//
// If this resolver is fixed, the code generation may fail, because some
// of the generators rely on this (faulty) behavior. Nonetheless, this bug
// should be fixed to obtain consistent values for the attributes that
// are parsed using this token.
public class CsQUOTED_34_34_92TokenResolver implements ICsTokenResolver {
	
	private CsDefaultTokenResolver defaultTokenResolver = new CsDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result = result.replace("\\", "\\\\");
		result = result.replace("\"", "\\\"");
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ICsTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		lexem = lexem.replace("\\\"", "\"");
		lexem = lexem.replace("\\\\", "\\");
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
