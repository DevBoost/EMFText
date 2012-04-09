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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult;
import org.emftext.sdk.util.StringUtil;

/** 
 * This resolver converts strings enclosed in double quotes. The conversion
 * is equal to the one performed for strings in Java source files.
 */
public class CsSTRINGTokenResolver implements org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver {
	
	private CsDefaultTokenResolver defaultTokenResolver = new CsDefaultTokenResolver();
	
	public void resolve(String lexem, EStructuralFeature feature, ICsTokenResolveResult result) {
		// remove outer double quotes
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		
		lexem = StringUtil.unescapeJavaString(lexem);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public String deResolve(java.lang.Object value, EStructuralFeature feature, EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		
		result = StringUtil.escapeToJavaString(result);
		// embed in double quotes
		result = "\"" + result + "\"";
		return result;
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
}
