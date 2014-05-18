/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.STYLED_TEXT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

// TODO mseifert: Consider case where an opening bracket is deleted on the left side of the caret.
// In such a situation, the closing bracket on the right side of this caret must deleted as well.
public class BracketSetGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite jc) {
		
		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		jc.addJavadoc("A container for all bracket pairs.");
		jc.add("public class " + getResourceClassName() + " {");
		jc.addLineBreak();
		
		addConstants(jc);
		addFields(jc);
		addConstructor(jc);
		addMethods(jc);
		
		jc.add("}");
	}
	
	private void addConstants(JavaComposite jc) {
		jc.addJavadoc(
			"The separator between a bracket pair must not contain characters " +
			"that need to be escaped as it will be used as regular expression."
		);
		jc.add("public final static String BRACKET_SEPARATOR = \" and \";");
		jc.addLineBreak();
		
		jc.add("private final static String SERIAL_SEPARATOR = \"#\";");
		jc.addLineBreak();
		
		jc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		jc.addLineBreak();
	}

	private void addFields(JavaComposite jc) {
		jc.add("private " + ARRAY_LIST(jc) + "<" + iBracketPairClassName + "> bracketPairs;");
		jc.add("private String languageID;");
		jc.addLineBreak();
	}

	private void addConstructor(JavaComposite jc) {
		jc.addJavadoc("Creates a new bracket set to manage bracket pairs.");
		jc.add("public " + getResourceClassName() + "() {");
		jc.add("super();");
		jc.add("this.languageID = new " + metaInformationClassName + "().getSyntaxName();");
		jc.add("this.bracketPairs = new " + ARRAY_LIST(jc) + "<" + iBracketPairClassName + ">();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addMethods(JavaComposite jc) {
		addIsOpeningBracketMethod(jc);
		addIsClosingBracketMethod(jc);
		addIsBracketMethod(jc);
		addGetBracketPairMethod1(jc);
		addGetBracketPairMethod2(jc);
		addAddBracketPairMethod(jc);
		addResetBracketsMethod(jc);
		addGetCounterpartMethod(jc);
		addSizeMethod(jc);
		addRemoveMethod(jc);
		addRemoveBracketPairsMethod(jc);
		addDeserializeMethod(jc);
		addGetBracketArrayMethod(jc);
		addSerializeMethod(jc);
		addGetCaretOffsetMethod(jc);
		addFindAndHighlightMatchingBracketsMethod(jc);
		addGetInsertedBracketMethod(jc);
		addFindMatchingBracketPositionForIdenticalOpeningClosingBracketsMethod(jc);
		addFindMatchingBracketPositionForDistinctOpeningClosingBracketsMethod(jc);
		addIsCloseAfterEnterMethodMethod(jc);
		addIsCloseInstantlyMethodMethod(jc);
	}

	private void addGetCaretOffsetMethod(JavaComposite sc) {
		// TODO mseifert: MOVE THIS TO SOME OTHER CLASS
		sc.add("public int getCaretOffset(" + I_SOURCE_VIEWER(sc) + " viewer, " + STYLED_TEXT(sc) + " textWidget) {");
		sc.add(I_DOCUMENT(sc) + " document = viewer.getDocument();");
		sc.add(PROJECTION_VIEWER(sc) + " projectionViewer = null;");
		sc.add("if (viewer instanceof " + PROJECTION_VIEWER(sc) + ") {");
		sc.add("projectionViewer = (" + PROJECTION_VIEWER(sc) + ") viewer;");
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
	}
	
	private void addFindAndHighlightMatchingBracketsMethod(JavaComposite jc) {
		jc.addJavadoc(
			"Searches the matching bracket at the left side of the caret. The position " +
			"information will be stored in the <code>" + I_DOCUMENT(jc) + "</code> in the category " +
			"<code>ExtensionConstants.PositionCategory.BRACKET</code>."
			// TODO fix referenced class
		);
		jc.add("public void findAndHighlightMatchingBrackets(" + I_DOCUMENT(jc) + " document, int caretOffset) {");
		jc.add("String documentText = document.get();");
		jc.add("String insertedBracket = getInsertedBracket(documentText, caretOffset);");
		jc.addLineBreak();
		jc.addComment("Only highlight true brackets (not quotes etc.)");
		jc.add("if (insertedBracket == null || insertedBracket.equals(getCounterpart(insertedBracket))) {");
		jc.add("return;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("int position = findMatchingBrackets(documentText, caretOffset);");
		jc.add("highlightBrackets(document, position, caretOffset);");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addGetInsertedBracketMethod(JavaComposite jc) {
		jc.add("private String getInsertedBracket(String documentText, int caretOffset) {");
		jc.add("if (caretOffset <= 0) {");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("final String insertedText = Character.toString(documentText.charAt(caretOffset - 1));");
		jc.addLineBreak();
		jc.add("if (!isBracket(insertedText)) {");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return insertedText;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("public int findMatchingBrackets(String documentText, int caretOffset) {");
		jc.add("String insertedBracket = getInsertedBracket(documentText, caretOffset);");
		jc.addLineBreak();
		jc.add("if (insertedBracket == null) {");
		jc.add("return - 1;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("final int insertPosition = caretOffset - 1;");
		jc.addLineBreak();
		jc.add("if (insertedBracket.equals(getCounterpart(insertedBracket))) {");
		jc.add("return findMatchingBracketPositionForIdenticalOpeningClosingBrackets(documentText, insertPosition, insertedBracket);");
		jc.add("} else {");
		jc.add("return findMatchingBracketPositionForDistinctOpeningClosingBrackets(documentText, insertPosition, insertedBracket);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addFindMatchingBracketPositionForIdenticalOpeningClosingBracketsMethod(JavaComposite jc) {
		jc.add("private int findMatchingBracketPositionForIdenticalOpeningClosingBrackets(String documentText, int markerPosition, String marker) {");
		jc.add("char markerToSearch = marker.charAt(0);");
		jc.add("boolean opened = false;");
		jc.add("int lastOpenPosition = -1;");
		jc.addLineBreak();
		jc.addComment("Nesting is not possible!");
		jc.add("for (int i = 0; i < documentText.length() - 1; i++) {");
		jc.add("char currentCharacter = documentText.charAt(i);");
		jc.addLineBreak();
		jc.add("if (currentCharacter == markerToSearch) {");
		jc.add("opened = !opened;");
		jc.addLineBreak();	
		jc.add("if (opened) {");
		jc.add("lastOpenPosition = i;");
		jc.add("}");
		jc.addLineBreak();	
		jc.add("if (i == markerPosition && !opened) {");
		jc.add("return lastOpenPosition;");
		jc.add("}");
		jc.addLineBreak();	
		jc.add("if (i > markerPosition && !opened) {");
		jc.add("return i;");
		jc.add("}");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return -1;");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addFindMatchingBracketPositionForDistinctOpeningClosingBracketsMethod(JavaComposite jc) {
		jc.add("private int findMatchingBracketPositionForDistinctOpeningClosingBrackets(String documentText, int markerPosition, String insertedBracket) {");
		jc.add("boolean isForward = isOpeningBracket(insertedBracket);");
		jc.add("final String counterpart = getCounterpart(insertedBracket);");
		jc.addLineBreak();
		jc.add("int boundary = isForward ? documentText.length() : -1;");
		jc.add("int position = isForward ? markerPosition + 1 : markerPosition - 1;");
		jc.addLineBreak();
		jc.add("int openBrackets = 0;");
		jc.addLineBreak();
		jc.add("while (position != boundary) {");
		jc.add("String currentString = Character.toString(documentText.charAt(position));");
		jc.addLineBreak();
		jc.add("if (currentString.equals(insertedBracket)) {");
		jc.add("openBrackets++;");
		jc.add("} else if (currentString.equals(counterpart)) {");
		jc.add("if (openBrackets == 0) {");
		jc.add("return position;");
		jc.add("} else {");
		jc.add("openBrackets--;");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();	
		jc.add("position += isForward ? 1 : -1;");
		jc.add("}");
		jc.addLineBreak();	
		jc.add("return -1;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("public void highlightBrackets(" + I_DOCUMENT(jc) + " document, int position, int caretOffset) {");
		jc.add("if (position != -1 && position != document.getLength()) {");
		jc.add("positionHelper.addPosition(document, " + positionCategoryClassName + ".BRACKET.toString(), position, 1);");
		jc.add("positionHelper.addPosition(document, " + positionCategoryClassName + ".BRACKET.toString(), caretOffset - 1, 1);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSerializeMethod(JavaComposite jc) {
		jc.addJavadoc(
			"Returns this bracket set as <code>String</code>. This is useful to store the set in " +
			"the <code>" + I_PREFERENCE_STORE(jc) + "</code>.",
			"@see " + I_PREFERENCE_STORE(jc)
		);
		jc.add("public String serialize() {");
		jc.add("StringBuilder result = new StringBuilder();");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("result.append(bracketPair.getOpeningBracket());");
		jc.add("result.append(SERIAL_SEPARATOR);");
		jc.add("result.append(bracketPair.getClosingBracket());");
		jc.add("result.append(SERIAL_SEPARATOR);");
		jc.add("result.append(bracketPair.isClosingEnabledInside() ? \"1\" : \"0\");");
		jc.add("result.append(SERIAL_SEPARATOR);");
		jc.add("result.append(bracketPair.isCloseAfterEnter() ? \"1\" : \"0\");");
		jc.addComment("We use two separators to indicate the boundary between two bracket pairs");
		jc.add("result.append(SERIAL_SEPARATOR);");
		jc.add("result.append(SERIAL_SEPARATOR);");
		jc.add("}");
		jc.add("return result.toString();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetBracketArrayMethod(JavaComposite jc) {
		jc.addJavadoc(
			"Returns a list of bracket pairs. This call is for the list in the preference page.",
			"@return a list of bracket pairs in the form <code>String[]{\"{BRACKET_SEPARATOR}\",\"(BRACKET_SEPARATOR)\"}</code>"
		);
		jc.add("public String[] getBracketArray() {");
		jc.add("String[] ret = new String[bracketPairs.size()];");
		jc.add("int i = 0;");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("ret[i] = bracketPair.getOpeningBracket() + BRACKET_SEPARATOR + bracketPair.getClosingBracket();");
		jc.add("i++;");
		jc.add("}");
		jc.add("return ret;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addDeserializeMethod(JavaComposite jc) {
		jc.addJavadoc(
			"Removes the old bracket set and sets the given bracket set. It is useful " +
			"to take a stored <code>String</code> in a preference store. A bracket pair " +
			"contains of opening, closing and the flags 'closingEnabledInside' and 'closeAfterEnter'."
		);
		jc.add("public void deserialize(String bracketSet) {");
		jc.add("bracketPairs = new " + ARRAY_LIST(jc) + "<" + iBracketPairClassName + ">();");
		jc.add("String[] parts = bracketSet.split(SERIAL_SEPARATOR + SERIAL_SEPARATOR);");
		jc.add("for (String part : parts) {");
		jc.add("String[] fields = part.split(SERIAL_SEPARATOR);");
		jc.add("if (fields.length != 4) {");
		jc.add("continue;");
		jc.add("}");
		jc.add("addBracketPair(fields[0], fields[1], \"1\".equals(fields[2]), \"1\".equals(fields[3]));");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addRemoveBracketPairsMethod(JavaComposite jc) {
		jc.addJavadoc("Removes pairs of brackets.");
		jc.add("public void removeBracketPairs(String[] bracketsAsArray) {");
		jc.add("for (String bracket : bracketsAsArray) {");
		jc.add("String[] tmp = bracket.split(BRACKET_SEPARATOR);");
		jc.add("remove(tmp[0], tmp[1]);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addRemoveMethod(JavaComposite jc) {
		jc.addJavadoc("Removes the given bracket pair.");
		jc.add("public " + iBracketPairClassName + " remove(String opening, String closing) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracketPair.getOpeningBracket().equals(opening) && bracketPair.getClosingBracket().equals(closing)) {");
		jc.add("bracketPairs.remove(bracketPair);");
		jc.add("return bracketPair;");
		jc.add("}");
		jc.add("}");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSizeMethod(JavaComposite jc) {
		jc.add("public int size() {");
		jc.add("return bracketPairs.size();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetCounterpartMethod(JavaComposite jc) {
		jc.addJavadoc(
			"Returns the counter part of a bracket (i.e., the closing bracket for the opening one and the other way around). " +
			"If no respective bracket is found, <code>null</code> is returned."
		);
		jc.add("public String getCounterpart(String bracket) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		jc.add("return bracketPair.getClosingBracket();");
		jc.add("}");
		jc.add("if (bracket.equals(bracketPair.getClosingBracket())) {");
		jc.add("return bracketPair.getOpeningBracket();");
		jc.add("}");
		jc.add("}");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addResetBracketsMethod(JavaComposite jc) {
		jc.addJavadoc("Removes all bracket pairs from this bracket set and reloads the bracket set from the preference store.");
		jc.add("public boolean resetBrackets(" + I_PREFERENCE_STORE(jc) + " preferenceStore) {");
		jc.add("String bracketPairs = preferenceStore.getString(languageID + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX);");
		jc.add("if (bracketPairs == null) {");
		jc.add("return false;");
		jc.add("}");
		jc.add("deserialize(bracketPairs);");
		jc.add("return true;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addAddBracketPairMethod(JavaComposite jc) {
		jc.addJavadoc("Adds a new bracket pair to this bracket set.");
		jc.add("public boolean addBracketPair(String opening, String closing, boolean closingEnabledInside, boolean closeAfterEnter) {");
		jc.add("if (isBracket(opening) || isBracket(closing)) {");
		jc.add("return false;");
		jc.add("}");
		jc.add("bracketPairs.add(new " + bracketPairClassName + "(opening, closing, closingEnabledInside, closeAfterEnter));");
		jc.add("return true;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetBracketPairMethod1(JavaComposite jc) {
		jc.add("public " + iBracketPairClassName + " getBracketPair(int index) {");
		jc.add("try {");
		jc.add("return bracketPairs.get(index);");
		jc.add("} catch (Exception e) {");
		jc.add("return null;");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetBracketPairMethod2(JavaComposite jc) {
		jc.addJavadoc(
			"Returns the bracket pair with the given opening and closing bracket. " +
			"If no matching pair is found, <code>null</code> is returned."
		);
		jc.add("public " + iBracketPairClassName + " getBracketPair(String opening, String closing) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracketPair.getOpeningBracket().equals(opening) && bracketPair.getClosingBracket().equals(closing)) {");
		jc.add("return bracketPair;");
		jc.add("}");
		jc.add("}");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addIsBracketMethod(JavaComposite jc) {
		jc.addJavadoc("Checks whether the given string is a bracket (opening or closing).");
		jc.add("public boolean isBracket(String bracket) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracket.equals(bracketPair.getOpeningBracket()) || bracket.equals(bracketPair.getClosingBracket())) {");
		jc.add("return true;");
		jc.add("}");
		jc.add("}");
		jc.add("return false;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addIsOpeningBracketMethod(JavaComposite jc) {
		jc.addJavadoc("Checks whether the given string is an opening bracket.");
		jc.add("public boolean isOpeningBracket(String bracket) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		jc.add("return true;");
		jc.add("}");
		jc.add("}");
		jc.add("return false;");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addIsClosingBracketMethod(JavaComposite jc) {
		jc.addJavadoc("Checks whether the given string is a closing bracket.");
		jc.add("public boolean isClosingBracket(String bracket) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracket.equals(bracketPair.getClosingBracket())) {");
		jc.add("return true;");
		jc.add("}");
		jc.add("}");
		jc.add("return false;");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addIsCloseAfterEnterMethodMethod(JavaComposite jc) {
		jc.addJavadoc("Checks whether the given string is an opening bracket and closing is desired after entering a line break.");
		jc.add("public boolean isCloseAfterEnter(String bracket) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		jc.add("return bracketPair.isCloseAfterEnter();");
		jc.add("}");
		jc.add("}");
		jc.add("return false;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addIsCloseInstantlyMethodMethod(JavaComposite jc) {
		jc.addJavadoc("Checks whether the given string is an opening bracket and closing is desired right after entering this bracket.");
		jc.add("public boolean isCloseInstantly(String bracket) {");
		jc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		jc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		jc.add("return !bracketPair.isCloseAfterEnter();");
		jc.add("}");
		jc.add("}");
		jc.add("return false;");
		jc.add("}");
		jc.addLineBreak();
	}
}
