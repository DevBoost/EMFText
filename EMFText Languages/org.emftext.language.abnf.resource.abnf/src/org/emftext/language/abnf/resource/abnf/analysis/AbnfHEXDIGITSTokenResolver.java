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
package org.emftext.language.abnf.resource.abnf.analysis;

public class AbnfHEXDIGITSTokenResolver implements org.emftext.language.abnf.resource.abnf.IAbnfTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert value instanceof Integer;
		Integer integerObject = (Integer) value;
		String hexString = Integer.toHexString(integerObject);
		if (hexString.length() < 2) {
			hexString = "0" + hexString;
		}
		return hexString;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.abnf.resource.abnf.IAbnfTokenResolveResult result) {
		int value = Integer.parseInt(lexem, 16);
		result.setResolvedToken(value);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
