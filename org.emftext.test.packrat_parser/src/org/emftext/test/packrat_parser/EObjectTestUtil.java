package org.emftext.test.packrat_parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.util.StringUtil;

public class EObjectTestUtil {

	public static String convertToString(EObject root) {
		final String name = root.eClass().getName();
		List<EObject> contents = root.eContents();
		List<String> contentStrings = new ArrayList<String>();
		for (EObject eObject : contents) {
			contentStrings.add(convertToString(eObject));
		}
		
		List<EStructuralFeature> features = root.eClass().getEAllStructuralFeatures();
		String attributes = "";
		for (EStructuralFeature feature : features) {
			if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				String attributeName = attribute.getName();
				Object attributeValue = root.eGet(attribute);
				
				if (attributeValue != null) {
					attributes += attributeName;
					attributes += "=";
					attributes += "" + attributeValue;
				}
			}
		}
		String containedObjects = StringUtil.explode(contentStrings, ",");
		if (!("".equals(attributes))) {
			attributes = "(" + attributes + ")";
		}
		if (!("".equals(containedObjects))) {
			containedObjects = "{" + containedObjects + "}";
		}
		return name + attributes + containedObjects;
	}
}
