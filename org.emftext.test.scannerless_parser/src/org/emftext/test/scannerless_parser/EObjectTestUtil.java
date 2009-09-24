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
		List<String> contentStrings = new ArrayList<String>();
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
						List<String> referenceValues = new ArrayList<String>();
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
