package org.emftext.test.packrat_parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.util.StringUtil;

public class EObjectTestUtil {

	public static String convertToString(EObject root) {
		final String name = root.eClass().getName();
		List<EObject> contents = root.eContents();
		List<String> contentStrings = new ArrayList<String>();
		for (EObject eObject : contents) {
			contentStrings.add(convertToString(eObject));
		}
		return name + "(" + StringUtil.explode(contentStrings, ",")+ ")";
	}
}
