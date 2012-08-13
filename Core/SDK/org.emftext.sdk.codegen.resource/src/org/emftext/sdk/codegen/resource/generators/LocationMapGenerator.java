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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMPARATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IDENTITY_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class LocationMapGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static final String SYNCHRONISATION_COMMENT = 
		"We need to synchronize the write access, because other threads may iterate over the map concurrently.";

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A basic implementation of the ILocationMap interface. Instances " +
			"store information about element locations using four maps.",
			"<p>",
			"The set-methods can be called multiple times by the parser that may visit " +
			"multiple children from which it copies the localization information for the parent " +
			"element (i.e., the element for which set-method is called). " +
			"It implements the following behavior:",
			"<p>",
			"Line:   The lowest of all sources is used for target<br>",
			"Column: The lowest of all sources is used for target<br>",
			"Start:  The lowest of all sources is used for target<br>",
			"End:    The highest of all sources is used for target<br>"
		);
		sc.add("public class " + getResourceClassName() + " implements " + iLocationMapClassName + " {");
		sc.addLineBreak();
		addInnerClassISelector(sc);
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addSetLineMethod(sc);
		addGetLineMethod(sc);
		addSetColumnMethod(sc);
		addGetColumnMethod(sc);
		addSetCharStartMethod(sc);
		addGetCharStartMethod(sc);
		addSetCharEndMethod(sc);
		addGetCharEndMethod(sc);
		addGetMapValueMethod(sc);
		addSetMapValueToMinMethod(sc);
		addSetMapValueToMaxMethod(sc);
		addGetElementsAtMethod(sc);
		addGetElementsBetween(sc);
		addGetElementsMethod(sc);
	}

	private void addGetElementsMethod(JavaComposite sc) {
		sc.add("private " + LIST + "<" + E_OBJECT + "> getElements(ISelector s) {");
		sc.addComment(
			"There might be more than one element at the given offset. " +
			"Thus, we collect all of them and sort them afterwards."
		);
		sc.add(LIST + "<" + E_OBJECT + "> result = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.addLineBreak();
		sc.addComment(SYNCHRONISATION_COMMENT);
		sc.add("synchronized (this) {");
		sc.add("for (" + E_OBJECT + " next : charStartMap.keySet()) {");
		sc.add("Integer start = charStartMap.get(next);");
		sc.add("Integer end = charEndMap.get(next);");
		sc.add("if (start == null || end == null) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("if (s.accept(start, end)) {");
		sc.add("result.add(next);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add(COLLECTIONS + ".sort(result, new " + COMPARATOR + "<" + E_OBJECT + ">() {");
		sc.add("public int compare(" + E_OBJECT + " objectA, " + E_OBJECT + " objectB) {");
		sc.add("int lengthA = getCharEnd(objectA) - getCharStart(objectA);");
		sc.add("int lengthB = getCharEnd(objectB) - getCharStart(objectB);");
		sc.add("return lengthA - lengthB;");
		sc.add("}");
		sc.add("});");
		sc.add("return result;");
		sc.add("}");
	}

	private void addGetElementsBetween(JavaComposite sc) {
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsBetween(final int startOffset, final int endOffset) {");
		sc.add("" + LIST + "<" + E_OBJECT + "> result = getElements(new ISelector() {");
		sc.add("public boolean accept(int start, int end) {");
		sc.add("return start >= startOffset && end <= endOffset;");
		sc.add("}");
		sc.add("});");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetElementsAtMethod(JavaComposite sc) {
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsAt(final int documentOffset) {");
		sc.add(LIST + "<" + E_OBJECT + "> result = getElements(new ISelector() {");
		sc.add("public boolean accept(int start, int end) {");
		sc.add("return start <= documentOffset && end >= documentOffset;");
		sc.add("}");
		sc.add("});");
		sc.addComment("sort elements according to containment hierarchy");
		sc.add(COLLECTIONS + ".sort(result, new " + COMPARATOR + "<" + E_OBJECT + ">() {");
		sc.add("public int compare(" + E_OBJECT + " objectA, " + E_OBJECT + " objectB) {");
		sc.add("if (" + ECORE_UTIL + ".isAncestor(objectA, objectB)) {");
		sc.add("return 1;");
		sc.add("} else {");
		sc.add("if (" + ECORE_UTIL + ".isAncestor(objectB, objectA)) {");
		sc.add("return -1;");
		sc.add("} else {");
		sc.add("return 0;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetMapValueToMaxMethod(JavaComposite sc) {
		sc.add("private void setMapValueToMax(" + MAP + "<" + E_OBJECT + ", Integer> map, " + E_OBJECT + " element, int value) {");
		sc.addComment(SYNCHRONISATION_COMMENT);
		sc.add("synchronized (this) {");
		sc.add("if (element == null || value < 0) return;");
		sc.add("if (map.containsKey(element) && map.get(element) > value) return;");
		sc.add("map.put(element, value);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetMapValueToMinMethod(JavaComposite sc) {
		sc.add("private void setMapValueToMin(" + MAP + "<" + E_OBJECT + ", Integer> map, " + E_OBJECT + " element, int value) {");
		sc.addComment(SYNCHRONISATION_COMMENT);
		sc.add("synchronized (this) {");
		sc.add("if (element == null || value < 0) return;");
		sc.add("if (map.containsKey(element) && map.get(element) < value) return;");
		sc.add("map.put(element, value);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMapValueMethod(JavaComposite sc) {
		sc.add("private int getMapValue(" + MAP + "<" + E_OBJECT + ", Integer> map, " + E_OBJECT + " element) {");
		sc.add("if (!map.containsKey(element)) return -1;");
		sc.add("Integer value = map.get(element);");
		sc.add("return value == null ? -1 : value.intValue();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharEndMethod(JavaComposite sc) {
		sc.add("public int getCharEnd(" + E_OBJECT + " element) {");
		sc.add("return getMapValue(charEndMap, element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetCharEndMethod(JavaComposite sc) {
		sc.add("public void setCharEnd(" + E_OBJECT + " element, int charEnd) {");
		sc.add("setMapValueToMax(charEndMap, element, charEnd);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharStartMethod(JavaComposite sc) {
		sc.add("public int getCharStart(" + E_OBJECT + " element) {");
		sc.add("return getMapValue(charStartMap, element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetCharStartMethod(JavaComposite sc) {
		sc.add("public void setCharStart(" + E_OBJECT + " element, int charStart) {");
		sc.add("setMapValueToMin(charStartMap, element, charStart);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetColumnMethod(JavaComposite sc) {
		sc.add("public int getColumn(" + E_OBJECT + " element) {");
		sc.add("return getMapValue(columnMap, element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetColumnMethod(JavaComposite sc) {
		sc.add("public void setColumn(" + E_OBJECT + " element, int column) {");
		sc.add("setMapValueToMin(columnMap, element, column);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLineMethod(JavaComposite sc) {
		sc.add("public int getLine(" + E_OBJECT + " element) {");
		sc.add("return getMapValue(lineMap, element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetLineMethod(JavaComposite sc) {
		sc.add("public void setLine(" + E_OBJECT + " element, int line) {");
		sc.add("setMapValueToMin(lineMap, element, line);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("protected " + MAP + "<" + E_OBJECT + ", Integer> columnMap = new " + IDENTITY_HASH_MAP + "<" + E_OBJECT + ", Integer>();");
		sc.add("protected " + MAP + "<" + E_OBJECT + ", Integer> lineMap = new " + IDENTITY_HASH_MAP + "<" + E_OBJECT + ", Integer>();");
		sc.add("protected " + MAP + "<" + E_OBJECT + ", Integer> charStartMap = new " + IDENTITY_HASH_MAP + "<" + E_OBJECT + ", Integer>();");
		sc.add("protected " + MAP + "<" + E_OBJECT + ", Integer> charEndMap = new " + IDENTITY_HASH_MAP + "<" + E_OBJECT + ", Integer>();");
		sc.addLineBreak();
	}

	private void addInnerClassISelector(JavaComposite sc) {
		sc.addJavadoc(
			"A basic interface that can be implemented to select " +
			"EObjects based of their location in a text resource."
		);
		sc.add("public interface ISelector {");
		sc.add("boolean accept(int startOffset, int endOffset);");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
