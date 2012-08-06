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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.emftext.language.abnf.AbnfPackage;

public class AbnfDIGITSTokenResolver implements org.emftext.language.abnf.resource.abnf.IAbnfTokenResolver {
	
	private org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultTokenResolver defaultTokenResolver = new org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.abnf.resource.abnf.IAbnfTokenResolveResult result) {
		Set<EClass> hexClasses = new LinkedHashSet<EClass>();
		hexClasses.add(AbnfPackage.eINSTANCE.getHexadecimalTerminal());
		hexClasses.add(AbnfPackage.eINSTANCE.getHexTerminalTail());
		hexClasses.add(AbnfPackage.eINSTANCE.getHexRangeEnd());
		hexClasses.add(AbnfPackage.eINSTANCE.getAdditionalHexTerminal());
		
		if (hexClasses.contains(feature.eContainer())) {
			int value = Integer.parseInt(lexem, 16);
			result.setResolvedToken(value);
		} else {
			defaultTokenResolver.resolve(lexem, feature, result);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
