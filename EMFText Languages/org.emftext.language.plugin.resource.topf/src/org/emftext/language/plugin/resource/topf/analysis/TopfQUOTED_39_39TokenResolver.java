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
package org.emftext.language.plugin.resource.topf.analysis;

import java.util.Map;

import org.emftext.language.plugin.resource.topf.ITopfTokenResolveResult;
import org.emftext.language.plugin.resource.topf.ITopfTokenResolver;

public class TopfQUOTED_39_39TokenResolver implements ITopfTokenResolver {

	private TopfDefaultTokenResolver defaultResolver = new TopfDefaultTokenResolver();

	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		result = result.replaceAll(java.util.regex.Pattern.quote("'"),"\\\\'");
		result += "'";
		result = "'" + result;
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ITopfTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote("'"),"'");
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
