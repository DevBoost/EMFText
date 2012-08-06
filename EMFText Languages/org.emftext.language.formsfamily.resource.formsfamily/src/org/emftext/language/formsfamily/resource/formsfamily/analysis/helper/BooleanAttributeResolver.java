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
package org.emftext.language.formsfamily.resource.formsfamily.analysis.helper;

import org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyTokenResolveResult;

public class BooleanAttributeResolver {

	public java.lang.String deResolve(java.lang.Object value,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return feature.getName().substring(0, 1).toLowerCase()
					+ feature.getName().substring(1);
		} else {
			return "";
		}
	}

	public void resolve(java.lang.String lexem,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			IFormsfamilyTokenResolveResult result) {
		if (feature.getName().equalsIgnoreCase(lexem)) {
			result.setResolvedToken(true);
		} else {
			result.setResolvedToken(false);
		}
	}

}
