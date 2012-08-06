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
package org.emftext.language.javaproperties.resource.properties.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.javaproperties.resource.properties.IPropertiesTokenResolveResult;
import org.emftext.language.javaproperties.resource.properties.IPropertiesTokenResolver;

public class PropertiesVALUETokenResolver implements IPropertiesTokenResolver {

	public final static String VALUE_PREFIX_REGEX = "^(\\u0020|\\t|\\f|=|:)*";
	public final static String VALUE_LINEBREAK_REGEX = "\\\\(\\r|\\n)*";
	public final static String VALUE_SUFFIX_REGEX = "(\\r|\\n)*";

	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		assert value instanceof String;
		// TODO escape backslash characters
		return "= " + (String) value + "\n";
	}
	
	public void resolve(String lexem, EStructuralFeature feature, IPropertiesTokenResolveResult result) {
		// we remove the whitespace and delimiter characters before the value,
		String cleaned = lexem.replaceAll(VALUE_PREFIX_REGEX, "");
		// the line breaks within the value
		cleaned = cleaned.replaceAll(VALUE_LINEBREAK_REGEX, "");
		// and the line break at the end of the value string
		cleaned = cleaned.replaceAll(VALUE_SUFFIX_REGEX, "");
		// TODO unescape backslash characters
		result.setResolvedToken(cleaned);
	}
	
	public void setOptions(Map<?,?> options) {
		// do nothing
	}
}
