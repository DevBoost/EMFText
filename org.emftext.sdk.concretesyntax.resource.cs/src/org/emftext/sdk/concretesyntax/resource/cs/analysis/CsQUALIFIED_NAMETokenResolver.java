/*******************************************************************************
 * Copyright (c) 2006-2011
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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

public class CsQUALIFIED_NAMETokenResolver implements ICsTokenResolver {
	
	private CsDefaultTokenResolver defaultResolver = new CsDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		if (value == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
			return "_";
		}
		String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}

	public void resolve(String lexem, EStructuralFeature feature, ICsTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
		defaultResolver.setOptions(options);
	}
}
