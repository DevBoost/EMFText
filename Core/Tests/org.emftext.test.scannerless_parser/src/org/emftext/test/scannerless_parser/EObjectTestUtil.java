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
package org.emftext.test.scannerless_parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.test.grammar_features.resource.grammar_features.util.Grammar_featuresStringUtil;

public class EObjectTestUtil {

	public static String convertToString(EObject root) {
		return convertToString(root, true);
	}

	public static String convertToString(EObject root, boolean includeContainedObjects) {
		final String name = root.eClass().getName();
		List<EObject> contents = root.eContents();
		List<Object> contentStrings = new ArrayList<Object>();
		for (EObject eObject : contents) {
			contentStrings.add(convertToString(eObject));
		}

		List<EStructuralFeature> features = root.eClass().getEAllStructuralFeatures();
		String attributes = "";
		String crossReferences = "";
		for (EStructuralFeature feature : features) {
			String featureName = feature.getName();
			if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				Object attributeValue = root.eGet(attribute);

				if (attributeValue != null) {
					attributes += featureName;
					attributes += "=";
					attributes += "" + attributeValue;
				}
			} else if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (!reference.isContainment()) {
					Object referenceValue = root.eGet(reference);
					String referenceValueString = null;
					if (referenceValue instanceof EObject) {
						referenceValueString = convertToString((EObject) referenceValue, false);
					}
					if (referenceValue instanceof List<?>) {
						List<Object> referenceValues = new ArrayList<Object>();
						List<?> list = (List<?>) referenceValue;
						Iterator<?> it = list.iterator();
						while (it.hasNext()) {
							Object next = it.next();
							if (next instanceof EObject) {
								referenceValues.add(convertToString((EObject) next, false));
							}
						}
						referenceValueString = Grammar_featuresStringUtil.explode(referenceValues, ";");
					}
					if (referenceValue == null) {
						continue;
					}
					if ("".equals(referenceValueString)) {
						continue;
					}

					crossReferences += featureName;
					crossReferences += "->";
					crossReferences += referenceValueString;
				}
			}
		}
		String containedObjects = Grammar_featuresStringUtil.explode(contentStrings, ",");
		if (!("".equals(attributes))) {
			attributes = "(" + attributes + ")";
		}
		if (!("".equals(crossReferences))) {
			crossReferences = "[" + crossReferences + "]";
		}
		if (!("".equals(containedObjects))) {
			containedObjects = "{" + containedObjects + "}";
		}
		String result = name;
		result += attributes;
		result += crossReferences;
		if (includeContainedObjects) {
			result += containedObjects;
		}
		return result;
	}
}
