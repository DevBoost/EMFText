/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil;

public class CsHoverTextProvider implements org.emftext.sdk.concretesyntax.resource.cs.ICsHoverTextProvider {
	
	public java.lang.String getHoverText(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof LineBreak) {
			LineBreak linebreak = (LineBreak) object;
			int tabs = linebreak.getTab();
			return "<strong>" + object.eClass().getName() + "</strong>" + "<br/><br/>" + "Inserts a line break and " + tabs + " tab character(s) when printing this model element.";
		}
		if (object instanceof WhiteSpaces) {
			WhiteSpaces whitespace = (WhiteSpaces) object;
			int spaces = whitespace.getAmount();
			return "<strong>" + object.eClass().getName() + "</strong>" + "<br/><br/>" + "Inserts " + spaces + " whitespace character(s) when printing this model element.";
		}
		String htmlForObject = getHTML(object);
		if (object instanceof GenClass) {
			// for generator classes we do also show the properties of the
			// corresponding EClass
			GenClass genClass = (GenClass) object;
			EClass ecoreClass = genClass.getEcoreClass();
			if (ecoreClass != null) {
				String htmlForEClass = getHTML(ecoreClass);
				return htmlForEClass + "<br/><br/>" + htmlForObject;
			}
		}
		if (object instanceof GenPackage) {
			// for generator package we do also show the properties of the
			// corresponding EPackage
			GenPackage genPackage = (GenPackage) object;
			EPackage ecorePackage = genPackage.getEcorePackage();
			if (ecorePackage != null) {
				String htmlForEPackage = getHTML(ecorePackage);
				return htmlForEPackage + "<br/><br/>" + htmlForObject;
			}
		}
		if (object instanceof GenFeature) {
			// for generator features we do also show the properties of the
			// corresponding EClass
			GenFeature genFeature = (GenFeature) object;
			EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
			if (ecoreFeature != null) {
				String htmlForEFeature = getHTML(ecoreFeature);
				// and we want to show the type of the feature
				EClassifier type = ecoreFeature.getEType();
				String htmlForEType = getHTML(type);
				return htmlForEFeature + "<br/><br/>Type:<br/>" + htmlForEType + "<br/><br/>" + htmlForObject;
			}
		}
		return htmlForObject;
	}

	private java.lang.String getHTML(EObject object) {
		if (object == null) {
			return "";
		}
		EClass eClass = object.eClass();

		List<Object> booleanAttributes = new ArrayList<Object>();
		StringBuffer nonBooleanAttributes = new StringBuffer();
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			Object value = null;
			try {
				value = object.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				if ("EBoolean".equals(attribute.getEType().getName()) && value instanceof Boolean) {
					Boolean booleanValue = (Boolean) value;
					if (booleanValue) {
						booleanAttributes.add(attribute.getName());
					}
				} else {
					nonBooleanAttributes.append("<br />" + attribute.getName() + ": " + object.eGet(attribute).toString());
				}
			}
		}
		String booleanAttributeValue = CsStringUtil.explode(booleanAttributes, ", ");
		if (booleanAttributeValue.length() > 0) {
			booleanAttributeValue = " (" + booleanAttributeValue + ")";
		}
		String label = "<strong>" + eClass.getName() + booleanAttributeValue + "</strong>";
		label += nonBooleanAttributes.toString();
		return label;
	}
}
