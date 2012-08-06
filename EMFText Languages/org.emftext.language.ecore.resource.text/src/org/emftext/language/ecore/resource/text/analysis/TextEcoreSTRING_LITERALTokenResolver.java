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
package org.emftext.language.ecore.resource.text.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.ecore.resource.text.ITextEcoreTokenResolveResult;
import org.emftext.language.ecore.resource.text.analysis.helper.CharacterEscaper;


public class TextEcoreSTRING_LITERALTokenResolver implements org.emftext.language.ecore.resource.text.ITextEcoreTokenResolver {
	
	private org.emftext.language.ecore.resource.text.analysis.TextEcoreDefaultTokenResolver defaultTokenResolver = new org.emftext.language.ecore.resource.text.analysis.TextEcoreDefaultTokenResolver();
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		
		//escape escapes
		result = CharacterEscaper.escapeEscapedCharacters(result);
		
		result = '"' + result + '"';
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ITextEcoreTokenResolveResult result) {
		// remove double quotes
		assert lexem.charAt(0) == '"';
		assert lexem.charAt(lexem.length() - 1) == '"';
		lexem = lexem.substring(1, lexem.length() - 1);
		
		lexem = CharacterEscaper.unescapeEscapedCharacters(lexem);
		
		result.setResolvedToken(lexem);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
