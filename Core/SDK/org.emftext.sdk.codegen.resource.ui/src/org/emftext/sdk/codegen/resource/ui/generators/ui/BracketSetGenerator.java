/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STYLED_TEXT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

// TODO mseifert: Consider case where an opening bracket is deleted on the left side of the caret.
// In such a situation, the closing bracket on the right side of this caret must deleted as well.
public class BracketSetGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc("A container for all bracket pairs.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addConstants(sc);
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}
	
	private void addConstants(JavaComposite sc) {
		sc.addJavadoc(
			"The separator between a bracket pair, must not contain characters " +
			"that need to be escaped as it will be used as regular expression."
		);
		sc.add("public final static String BRACKET_SEPARATOR = \" and \";");
		sc.addLineBreak();
		
		sc.add("private final static String SERIAL_SEPARATOR = \"#\";");
		sc.addLineBreak();
		
		sc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + ARRAY_LIST + "<" + iBracketPairClassName + "> bracketPairs;");
		sc.add("private String languageID;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc("Creates a new bracket set to manage bracket pairs.");
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("this.languageID = new " + metaInformationClassName + "().getSyntaxName();");
		sc.add("this.bracketPairs = new " + ARRAY_LIST + "<" + iBracketPairClassName + ">();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addIsOpeningBracketMethod(sc);
		addIsBracketMethod(sc);
		addGetBracketPairMethod1(sc);
		addGetBracketPairMethod2(sc);
		addAddBracketPairMethod(sc);
		addResetBracketsMethod(sc);
		addGetCounterpartMethod(sc);
		addSizeMethod(sc);
		addRemoveMethod(sc);
		addRemoveBracketPairsMethod(sc);
		addDeserializeMethod(sc);
		addGetBracketArrayMethod(sc);
		addSerializeMethod(sc);
		addMatchingBracketsMethod(sc);
		addIsCloseAfterEnterMethod(sc);
		addIsCloseInstantlyMethod(sc);
	}

	private void addMatchingBracketsMethod(JavaComposite sc) {
		// TODO mseifert: MOVE THIS TO SOME OTHER CLASS
		sc.add("public int getCaretOffset(" + I_SOURCE_VIEWER + " viewer, " + STYLED_TEXT + " textWidget) {");
		sc.add(I_DOCUMENT + " document = viewer.getDocument();");
		sc.add(PROJECTION_VIEWER + " projectionViewer = null;");
		sc.add("if (viewer instanceof " + PROJECTION_VIEWER + ") {");
		sc.add("projectionViewer = (" + PROJECTION_VIEWER + ") viewer;");
		sc.add("}");
		sc.add("if (document == null) {");
		sc.add("return -1;");
		sc.add("}");
		sc.add("int caretOffset = textWidget.getCaretOffset();");
		sc.add("if (projectionViewer != null) {");
		sc.add("caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);");
		sc.add("}");
		sc.add("return caretOffset;");
		sc.add("}");
		sc.addLineBreak();

		sc.addJavadoc(
			"Searches the matching bracket at the left side of the caret. The position " +
			"information will be stored in the <code>" + I_DOCUMENT + "</code> in the category " +
			"<code>ExtensionConstants.PositionCategory.BRACKET</code>."
			// TODO fix referenced class
		);
		sc.add("public void findAndHighlightMatchingBrackets(" + I_DOCUMENT + " document, int caretOffset) {");
		sc.add("if (caretOffset <= 0) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("final String prevStr;");
		sc.add("try {");
		sc.add("prevStr = \"\" + document.getChar(caretOffset - 1);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("return;");
		sc.add("}");
		sc.add("if (!isBracket(prevStr) || prevStr.equals(getCounterpart(prevStr))) {");
		sc.add("return;");
		sc.add("}");
		sc.add("boolean isForward = isOpeningBracket(prevStr);");
		sc.add("final String toFindStr = getCounterpart(prevStr);");
		sc.add("int boundary = isForward ? document.getLength() : -1;");
		sc.add("int position = isForward ? caretOffset : caretOffset - 2;");
		sc.add("String currentStr;");
		sc.add("int count = 0;");
		sc.add("try {");
		sc.add("while (position != boundary) {");
		sc.add("currentStr = \"\" + document.getChar(position);");
		sc.add("if (toFindStr.equals(currentStr) && count == 0) {");
		sc.add("break;");
		sc.add("} else if (prevStr.equals(currentStr)) {");
		sc.add("count++;");
		sc.add("} else if (currentStr.equals(toFindStr)) {");
		sc.add("count--;");
		sc.add("}");
		sc.add("position += isForward ? 1 : -1;");
		sc.add("}");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("return;");
		sc.add("}");
		sc.add("if (position != -1 && position != document.getLength()) {");
		sc.add("positionHelper.addPosition(document, " + positionCategoryClassName + ".BRACKET.toString(), position, 1);");
		sc.add("positionHelper.addPosition(document, " + positionCategoryClassName + ".BRACKET.toString(), caretOffset - 1, 1);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSerializeMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns this bracket set as <code>String</code>. This is useful to store the set in " +
			"the <code>" + I_PREFERENCE_STORE + "</code>.",
			"@see " + I_PREFERENCE_STORE
		);
		sc.add("public String serialize() {");
		sc.add("StringBuilder result = new StringBuilder();");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("result.append(bracketPair.getOpeningBracket());");
		sc.add("result.append(SERIAL_SEPARATOR);");
		sc.add("result.append(bracketPair.getClosingBracket());");
		sc.add("result.append(SERIAL_SEPARATOR);");
		sc.add("result.append(bracketPair.isClosingEnabledInside() ? \"1\" : \"0\");");
		sc.add("result.append(SERIAL_SEPARATOR);");
		sc.add("result.append(bracketPair.isCloseAfterEnter() ? \"1\" : \"0\");");
		sc.addComment("We use two separators to indicate the boundary between two bracket pairs");
		sc.add("result.append(SERIAL_SEPARATOR);");
		sc.add("result.append(SERIAL_SEPARATOR);");
		sc.add("}");
		sc.add("return result.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketArrayMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns a list of bracket pairs. This call is for the list in the preference page.",
			"@return a list of bracket pairs in the form <code>String[]{\"{BRACKET_SEPARATOR}\",\"(BRACKET_SEPARATOR)\"}</code>"
		);
		sc.add("public String[] getBracketArray() {");
		sc.add("String[] ret = new String[bracketPairs.size()];");
		sc.add("int i = 0;");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("ret[i] = bracketPair.getOpeningBracket() + BRACKET_SEPARATOR + bracketPair.getClosingBracket();");
		sc.add("i++;");
		sc.add("}");
		sc.add("return ret;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeserializeMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Removes the old bracket set and sets the given bracket set. It is useful " +
			"to take a stored <code>String</code> in a preference store. A bracket pair " +
			"contains of opening, closing and the flags 'closingEnabledInside' and 'closeAfterEnter'."
		);
		sc.add("public void deserialize(String bracketSet) {");
		sc.add("bracketPairs = new " + ARRAY_LIST + "<" + iBracketPairClassName + ">();");
		sc.add("String[] parts = bracketSet.split(SERIAL_SEPARATOR + SERIAL_SEPARATOR);");
		sc.add("for (String part : parts) {");
		sc.add("String[] fields = part.split(SERIAL_SEPARATOR);");
		sc.add("if (fields.length != 4) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("addBracketPair(fields[0], fields[1], \"1\".equals(fields[2]), \"1\".equals(fields[3]));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveBracketPairsMethod(JavaComposite sc) {
		sc.addJavadoc("Removes pairs of brackets.");
		sc.add("public void removeBracketPairs(String[] bracketsAsArray) {");
		sc.add("for (String bracket : bracketsAsArray) {");
		sc.add("String[] tmp = bracket.split(BRACKET_SEPARATOR);");
		sc.add("remove(tmp[0], tmp[1]);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveMethod(JavaComposite sc) {
		sc.addJavadoc("Removes the given bracket pair.");
		sc.add("public " + iBracketPairClassName + " remove(String opening, String closing) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("if (bracketPair.getOpeningBracket().equals(opening) && bracketPair.getClosingBracket().equals(closing)) {");
		sc.add("bracketPairs.remove(bracketPair);");
		sc.add("return bracketPair;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSizeMethod(StringComposite sc) {
		sc.add("public int size() {");
		sc.add("return bracketPairs.size();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCounterpartMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the counter part of a bracket (i.e., the closing bracket for the opening one and the other way around). " +
			"If no respective bracket is found, <code>null</code> is returned."
		);
		sc.add("public String getCounterpart(String bracket) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		sc.add("return bracketPair.getClosingBracket();");
		sc.add("}");
		sc.add("if (bracket.equals(bracketPair.getClosingBracket())) {");
		sc.add("return bracketPair.getOpeningBracket();");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResetBracketsMethod(JavaComposite sc) {
		sc.addJavadoc("Removes all bracket pairs from this bracket set and reloads the bracket set from the preference store.");
		sc.add("public boolean resetBrackets(" + I_PREFERENCE_STORE + " preferenceStore) {");
		sc.add("String bracketPairs = preferenceStore.getString(languageID + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX);");
		sc.add("if (bracketPairs == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("deserialize(bracketPairs);");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddBracketPairMethod(JavaComposite sc) {
		sc.addJavadoc("Adds a new bracket pair to this bracket set.");
		sc.add("public boolean addBracketPair(String opening, String closing, boolean closingEnabledInside, boolean closeAfterEnter) {");
		sc.add("if (isBracket(opening) || isBracket(closing)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("bracketPairs.add(new " + bracketPairClassName + "(opening, closing, closingEnabledInside, closeAfterEnter));");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketPairMethod1(StringComposite sc) {
		sc.add("public " + iBracketPairClassName + " getBracketPair(int index) {");
		sc.add("try {");
		sc.add("return bracketPairs.get(index);");
		sc.add("} catch (Exception e) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketPairMethod2(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the bracket pair with the given opening and closing bracket. " +
			"If no matching pair is found, <code>null</code> is returned."
		);
		sc.add("public " + iBracketPairClassName + " getBracketPair(String opening, String closing) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("if (bracketPair.getOpeningBracket().equals(opening) && bracketPair.getClosingBracket().equals(closing)) {");
		sc.add("return bracketPair;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsBracketMethod(JavaComposite sc) {
		sc.addJavadoc("Checks whether the given string is a bracket (opening or closing).");
		sc.add("public boolean isBracket(String bracket) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("if (bracket.equals(bracketPair.getOpeningBracket()) || bracket.equals(bracketPair.getClosingBracket())) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsOpeningBracketMethod(JavaComposite sc) {
		sc.addJavadoc("Checks whether the given string is an opening bracket.");
		sc.add("public boolean isOpeningBracket(String bracket) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addIsCloseAfterEnterMethod(JavaComposite sc) {
		sc.addJavadoc("Checks whether the given string is an opening bracket and closing is desired after entering a line break.");
		sc.add("public boolean isCloseAfterEnter(String bracket) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		sc.add("return bracketPair.isCloseAfterEnter();");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsCloseInstantlyMethod(JavaComposite sc) {
		sc.addJavadoc("Checks whether the given string is an opening bracket and closing is desired right after entering this bracket.");
		sc.add("public boolean isCloseInstantly(String bracket) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		sc.add("return !bracketPair.isCloseAfterEnter();");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
