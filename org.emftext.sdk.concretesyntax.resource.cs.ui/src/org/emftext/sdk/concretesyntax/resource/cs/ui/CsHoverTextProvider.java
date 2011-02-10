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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.concretesyntax.resource.cs.ICsHoverTextProvider;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil;

/**
 * A customized HoverTextProvider for the CS language. It provides special hover text for
 * EClasses, EStructuralFeatures, GenClasses, GenFeatures, GenPackages and some of the CS
 * types.
 */
public class CsHoverTextProvider implements ICsHoverTextProvider {
	
	public String getHoverText(EObject eObject) {
		if (eObject == null) {
			return null;
		}
		if (eObject instanceof LineBreak) {
			LineBreak linebreak = (LineBreak) eObject;
			int tabs = linebreak.getTab();
			return "<strong>" + eObject.eClass().getName() + "</strong>" + "<br/><br/>" + "Inserts a line break and " + tabs + " tab character(s) when printing this model element.";
		}
		if (eObject instanceof WhiteSpaces) {
			WhiteSpaces whitespace = (WhiteSpaces) eObject;
			int spaces = whitespace.getAmount();
			return "<strong>" + eObject.eClass().getName() + "</strong>" + "<br/><br/>" + "Inserts " + spaces + " whitespace character(s) when printing this model element.";
		}
		String htmlForObject = getHTML(eObject);
		if (eObject instanceof Option) {
			Option option = (Option) eObject;
			return htmlForObject + "<br/>" + EcoreUtil.getDocumentation(ConcretesyntaxPackage.eINSTANCE.getOptionTypes().getEEnumLiteral(option.getType().getName()));
		}
		if (eObject instanceof GenClass) {
			// for generator classes we do also show the properties of the
			// corresponding EClass
			GenClass genClass = (GenClass) eObject;
			EClass ecoreClass = genClass.getEcoreClass();
			if (ecoreClass != null) {
				String htmlForEClass = getHTML(ecoreClass, EcorePackage.eINSTANCE.getEClass_EStructuralFeatures().getName());
				return htmlForEClass; // + "<br/><br/>" + htmlForObject;
			}
		}
		if (eObject instanceof GenPackage) {
			// for generator package we do also show the properties of the
			// corresponding EPackage
			GenPackage genPackage = (GenPackage) eObject;
			EPackage ecorePackage = genPackage.getEcorePackage();
			if (ecorePackage != null) {
				String htmlForEPackage = getHTML(ecorePackage);
				return htmlForEPackage + "<br/><br/>" + htmlForObject;
			}
		}
		if (eObject instanceof GenFeature) {
			// for generator features we do also show the properties of the
			// corresponding EClass
			GenFeature genFeature = (GenFeature) eObject;
			EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
			if (ecoreFeature != null) {
				String htmlForEFeature = getHTML(ecoreFeature);
				// and we want to show the type of the feature
				EClassifier type = ecoreFeature.getEType();
				String htmlForEType = getHTML(type);
				return htmlForEFeature + "<br/><br/>Type: " + htmlForEType;// + "<br/><br/>" + htmlForObject;
			}
		}
		return htmlForObject;
	}

	private String getHTML(EObject eObject, String... referencesToPrint) {
		if (eObject == null) {
			return "";
		}
		EClass eClass = eObject.eClass();
		if (eObject instanceof EStructuralFeature) {
			EStructuralFeature eFeature = (EStructuralFeature) eObject;
			int upperBound = eFeature.getUpperBound();
			String documentation = EcoreUtil.getDocumentation(eFeature);
			String documentationHTML = documentation == null ? "" : " (" + documentation +")";
			return "<strong>" + eClass.getName() + "</strong> " + eFeature.getName() + documentationHTML + " : " + 
				eFeature.getEType().getName() + " " + eFeature.getLowerBound() + ".." + 
				(upperBound >= 0 ? upperBound : "*") + getBooleanString(eObject);
		}

		List<EAttribute> booleanAttributes = getBooleanAttributes(eObject);
		List<EAttribute> nameAttributes = getNameAttributes(eObject);
		
		List<EAttribute> remainingAttributes = new ArrayList<EAttribute>();
		remainingAttributes.addAll(eClass.getEAllAttributes());
		remainingAttributes.removeAll(booleanAttributes);
		remainingAttributes.removeAll(nameAttributes);
		
		StringBuffer nonBooleanAttributes = new StringBuffer();
		for (EAttribute attribute : remainingAttributes) {
			Object value = null;
			try {
				value = eObject.eGet(attribute);
			} catch (Exception e) {
				// do nothing - if eGet() fails, we show 'null'.
			}
			if (value == null) {
				value = "null";
			}
			nonBooleanAttributes.append("<br />" + attribute.getName() + ": " + value.toString());
		}
		
		String referencesHTML = "<br />";
		for (EReference reference : eClass.getEReferences()) {
			String name = reference.getName();
			if (contains(referencesToPrint, name)) {
				Object value = eObject.eGet(reference);
				if (value instanceof List<?>) {
					List<?> list = (List<?>) value;
					for (Object next : list) {
						if (next instanceof EObject) {
							referencesHTML += getHTML((EObject) next) + "<br />";
						}
					}
				} else if (value instanceof EObject) {
					referencesHTML += getHTML((EObject) value) + "<br />";
				}
			}
		}

		String booleanAttributeValue = getBooleanString(eObject);
		List<Object> nameAttributesNames = getAttributeNames(eObject, nameAttributes);
		String nameValue = CsStringUtil.explode(nameAttributesNames, ", ");
		if (nameValue.length() > 0) {
			nameValue = " " + nameValue;
		}
		String documentation = EcoreUtil.getDocumentation(eClass);
		String documentationHTML = documentation == null ? "" : " (" + documentation +")";
		String label = "<strong>" + eClass.getName() + "</strong>" + nameValue + booleanAttributeValue + documentationHTML;
		label += nonBooleanAttributes.toString();
		label += referencesHTML;
		return label;
	}

	private String getBooleanString(EObject eObject) {
		List<EAttribute> booleanAttributes = getBooleanAttributes(eObject);
		List<Object> setBooleanAttributes = getSetBooleanAttributes(eObject, booleanAttributes);
		String booleanAttributeValue = CsStringUtil.explode(setBooleanAttributes, ", ");
		if (booleanAttributeValue.length() > 0) {
			booleanAttributeValue = " (" + booleanAttributeValue + ")";
		}
		return booleanAttributeValue;
	}
	
	private List<Object> getAttributeNames(EObject eObject, List<EAttribute> nameAttributes) {
		List<Object> names = new ArrayList<Object>();
		for (EAttribute eAttribute : nameAttributes) {
			Object value = null;
			try {
				value = eObject.eGet(eAttribute);
			} catch (Exception e) {
				// exception in eGet() - do nothing 
			}
			if (value == null) {
				value = "null";
			}
			names.add(value);
		}
		return names;
	}

	private List<Object> getSetBooleanAttributes(EObject object,
			List<EAttribute> booleanAttributes) {
		List<Object> values = new ArrayList<Object>();
		for (EAttribute eAttribute : booleanAttributes) {
			try {
				Object value = object.eGet(eAttribute);
				if (Boolean.TRUE.equals(value)) {
					values.add(eAttribute.getName());
				}
			} catch (Exception e) {
				// exception in eGet() - do nothing 
			}
		}
		return values;
	}

	private List<EAttribute> getBooleanAttributes(EObject eObject) {
		EClass eClass = eObject.eClass();
		List<EAttribute> booleanAttributes = new ArrayList<EAttribute>();
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			Object value = null;
			try {
				value = eObject.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				if ("EBoolean".equals(attribute.getEType().getName()) && value instanceof Boolean) {
					booleanAttributes.add(attribute);
				}
			}
		}
		return booleanAttributes;
	}

	private List<EAttribute> getNameAttributes(EObject eObject) {
		EClass eClass = eObject.eClass();
		List<EAttribute> nameAttributes = new ArrayList<EAttribute>();
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			String name = attribute.getName();
			Object value = null;
			try {
				value = eObject.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				if (("name".equals(name) || "id".equals(name)) && (value instanceof Integer || value instanceof String)) {
					nameAttributes.add(attribute);
				}
			}
		}
		return nameAttributes;
	}

	private boolean contains(String[] strings, String key) {
		for (String string : strings) {
			if (string.equals(key)) {
				return true;
			}
		}
		return false;
	}
}
