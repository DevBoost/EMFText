/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.impl.AbstractTokenResolver;
import org.emftext.sdk.concretesyntax.resource.cs.CsDefaultTokenResolver;

public class CsQUOTED_39_39TokenResolver extends AbstractTokenResolver {
	
	private CsDefaultTokenResolver defaultResolver = new CsDefaultTokenResolver();
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = defaultResolver.deResolve(value,feature,container);
		result = result.replaceAll(java.util.regex.Pattern.quote("'"),"\\\\'");
		result += "'";
		result = "'" + result;
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ITokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0,lexem.length()-1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote("'"),"'");
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
		defaultResolver.setOptions(options);
	}
}
