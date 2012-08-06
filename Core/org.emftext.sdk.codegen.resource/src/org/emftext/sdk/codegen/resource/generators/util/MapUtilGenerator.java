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
package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class MapUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addCastToMapMethod(sc);
		addCastToEMapMethod(sc);
		addPutAndMergeKeysMethod(sc);
		sc.add("}");
	}

	private void addCastToEMapMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method encapsulate an unchecked cast from Object to " +
			E_MAP + "<Object, Object>. This case can not be performed type " +
			"safe, because type parameters are not available for " +
			"reflective access to Ecore models.",
			"@return the same object casted to a map"
		);
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add("public static " + E_MAP + "<Object, Object> castToEMap(Object value) {");
		sc.add("return (" + E_MAP + "<Object,Object>) value;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static " + MAP + "<Object, Object> copySafelyToObjectToObjectMap(" + MAP + "<?, ?> map) {");
		sc.add(MAP + "<Object, Object> castedCopy = new " + LINKED_HASH_MAP + "<Object, Object>();");
		sc.addLineBreak();
		sc.add("if (map == null) {");
		sc.add("return castedCopy;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(ITERATOR + "<?> it = map.keySet().iterator();");
		sc.add("while (it.hasNext()) {");
		sc.add("Object nextKey = it.next();");
		sc.add("castedCopy.put(nextKey, map.get(nextKey));");
		sc.add("}");
		sc.add("return castedCopy;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCastToMapMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method encapsulate an unchecked cast from Object to " +
			MAP + "<Object, Object>. This case can not be performed type " +
			"safe, because type parameters are not available for " +
			"reflective access to Ecore models.",
			"@param value the object to cast",
			"@return the same object casted to a map"
		);
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public static " + MAP + "<Object, Object> castToMap(Object value) {");
		sc.add("return (" + MAP + "<Object,Object>) value;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPutAndMergeKeysMethod(JavaComposite sc) {
		sc.addJavadoc("Adds a new key,value pair to the given map. If there "
				+ "is already an entry with the same key, the two values are "
				+ "collected in a list.");
		sc.add("public static <K> void putAndMergeKeys(" + MAP
				+ "<K, Object> map, K key, Object value) {");
		sc.addComment("check if there is already an option set");
		sc.add("if (map.containsKey(key)) {");
		sc.add("Object currentValue = map.get(key);");
		sc.add("if (currentValue instanceof " + LIST + "<?>) {");
		sc.addComment("if the current value is a list, we add the new value to this list");
		sc.add(LIST + "<?> currentValueAsList = (" + LIST
				+ "<?>) currentValue;");
		sc.add(LIST + "<Object> currentValueAsObjectList = "
				+ listUtilClassName
				+ ".copySafelyToObjectList(currentValueAsList);");
		sc.add("if (value instanceof " + COLLECTION + "<?>) {");
		sc.add("currentValueAsObjectList.addAll((" + COLLECTION
				+ "<?>) value);");
		sc.add("} else {");
		sc.add("currentValueAsObjectList.add(value);");
		sc.add("}");
		sc.add("map.put(key, currentValueAsObjectList);");
		sc.add("} else {");
		sc.addComment("if the current value is not a list, we create a fresh list "
				+ "and add both the old (current) and the new value to this list");
		sc.add(LIST + "<Object> newValueList = new " + ARRAY_LIST
				+ "<Object>();");
		sc.add("newValueList.add(currentValue);");
		sc.add("if (value instanceof " + COLLECTION + "<?>) {");
		sc.add("newValueList.addAll((" + COLLECTION + "<?>) value);");
		sc.add("} else {");
		sc.add("newValueList.add(value);");
		sc.add("}");
		sc.add("map.put(key, newValueList);");
		sc.add("}");
		sc.add("} else {");
		sc.add("map.put(key, value);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
