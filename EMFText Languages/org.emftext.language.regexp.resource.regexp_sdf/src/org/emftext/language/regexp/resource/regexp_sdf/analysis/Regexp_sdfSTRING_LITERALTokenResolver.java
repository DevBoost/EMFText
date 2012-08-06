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
package org.emftext.language.regexp.resource.regexp_sdf.analysis;

public class Regexp_sdfSTRING_LITERALTokenResolver implements org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		return "\"" + value + "\"";
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTokenResolveResult result) {
		result.setResolvedToken(lexem.substring(1, lexem.length() - 1));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
