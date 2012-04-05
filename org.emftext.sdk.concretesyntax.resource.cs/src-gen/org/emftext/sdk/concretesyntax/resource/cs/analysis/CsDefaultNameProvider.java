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

package org.emftext.sdk.concretesyntax.resource.cs.analysis;

public class CsDefaultNameProvider implements org.emftext.sdk.concretesyntax.resource.cs.ICsNameProvider {
	
	public final static String NAME_FEATURE = "name";
	
	/**
	 * Returns a list of potential identifiers that may be used to reference the given
	 * element. This method can be overridden to customize the identification of
	 * elements.
	 */
	public java.util.List<String> getNames(org.eclipse.emf.ecore.EObject element) {
		java.util.List<String> names = new java.util.ArrayList<String>();
		
		// first check for attributes that have set the ID flag to true
		java.util.List<org.eclipse.emf.ecore.EAttribute> attributes = element.eClass().getEAllAttributes();
		for (org.eclipse.emf.ecore.EAttribute attribute : attributes) {
			if (attribute.isID()) {
				Object attributeValue = element.eGet(attribute);
				if (attributeValue != null) {
					names.add(attributeValue.toString());
				}
			}
		}
		
		// then check for an attribute that is called 'name'
		org.eclipse.emf.ecore.EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if (nameAttr instanceof org.eclipse.emf.ecore.EAttribute) {
			Object attributeValue = element.eGet(nameAttr);
			if (attributeValue != null) {
				names.add(attributeValue.toString());
			}
		} else {
			// try any other string attribute found
			for (org.eclipse.emf.ecore.EAttribute attribute : attributes) {
				if ("java.lang.String".equals(attribute.getEType().getInstanceClassName())) {
					Object attributeValue = element.eGet(attribute);
					if (attributeValue != null) {
						names.add(attributeValue.toString());
					}
				}
			}
			
			// try operations without arguments that return strings and which have a name that
			// ends with 'name'
			for (org.eclipse.emf.ecore.EOperation operation : element.eClass().getEAllOperations()) {
				if (operation.getName().toLowerCase().endsWith(NAME_FEATURE) && operation.getEParameters().size() == 0) {
					Object result = org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil.invokeOperation(element, operation);
					if (result != null) {
						names.add(result.toString());
					}
				}
			}
		}
		return names;
	}
	
}
