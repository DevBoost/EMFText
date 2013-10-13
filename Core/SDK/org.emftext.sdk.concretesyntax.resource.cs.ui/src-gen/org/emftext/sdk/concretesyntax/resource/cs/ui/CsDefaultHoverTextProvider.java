/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class CsDefaultHoverTextProvider implements org.emftext.sdk.concretesyntax.resource.cs.ICsHoverTextProvider {
	
	public String getHoverText(EObject container, EObject referencedObject) {
		return getHoverText(referencedObject);
	}
	
	public String getHoverText(EObject object) {
		if (object == null) {
			return null;
		}
		EClass eClass = object.eClass();
		String label = "<strong>" + eClass.getName() + "</strong>";
		String documentation = EcoreUtil.getDocumentation(eClass);
		String documentationHTML = documentation == null ? "" : " (" + documentation +")";
		label += documentationHTML;
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			Object value = null;
			try {
				value = object.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				label += "<br />" + attribute.getName() + ": " + object.eGet(attribute).toString();
			}
		}
		return label;
	}
	
}
