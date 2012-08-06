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
package org.emftext.language.ecore.resource.facade.analysis;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreTokenResolveResult;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreTokenResolver;

public class FacadeEcoreQUOTED_34_34TokenResolver implements IFacadeEcoreTokenResolver {
	
	private FacadeEcoreDefaultTokenResolver defaultResolver = new FacadeEcoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// == nsURI field is is misused here as attribute that holds the path to the annotated Ecore file.
		Resource resource = container.eResource();
		if (feature.equals(EcorePackage.Literals.EPACKAGE__NS_URI) && resource != null && !resource.getContents().isEmpty()) {
			for(Adapter a : resource.eAdapters()) {
				if (a instanceof AnnotatedURI) {
					value = ((AnnotatedURI)a).getUri();
				}
			}
		}
		// ==
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		result = result.replaceAll(java.util.regex.Pattern.quote("\""),"\\\\\"");
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IFacadeEcoreTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote("\""),"\"");
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
