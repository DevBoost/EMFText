/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MODIFY_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MODIFY_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STYLED_TEXT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.VERIFY_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.VERIFY_KEY_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.VERIFY_LISTENER;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class BracketSetGenerator extends JavaBaseGenerator {

	private String positionCategoryClassName;

	public BracketSetGenerator() {
		super();
	}

	private BracketSetGenerator(GenerationContext context) {
		super(context, EArtifact.BRACKET_SET);
		positionCategoryClassName = getContext().getQualifiedClassName(EArtifact.POSITION_CATEGORY);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc("A container for all bracket pairs.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addInnerClasses(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addIsOpeningBracketMethod(sc);
		addIsBracketMethod(sc);
		addGetBracketPairMethod1(sc);
		addGetBracketPairMethod2(sc);
		addAddBracketPairMethod(sc);
		addSetClosingInsideMethod(sc);
		addResetBracketsMethod(sc);
		addGetCounterpartMethod(sc);
		addSizeMethod(sc);
		addRemoveMethod(sc);
		addRemoveBracketPairsMethod(sc);
		addSetBracketsMethod(sc);
		addGetBracketArrayMethod(sc);
		addGetBracketStringMethod(sc);
		addAddListenersMethod(sc);
		addMatchingBracketsMethod(sc);
	}

	private void addMatchingBracketsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Searches the matching bracket at the left side of the caret. The position " +
			"information will be stored in the <code>" + I_DOCUMENT + "</code> in the category " +
			"<code>ExtensionConstants.PositionCategory.BRACKET</code>."
			// TODO fix referenced class
		);
		sc.add("public void matchingBrackets() {");
		sc.add(I_DOCUMENT + " document = viewer.getDocument();");
		sc.add(PROJECTION_VIEWER + " projectionViewer = null;");
		sc.add("if (viewer instanceof " + PROJECTION_VIEWER + ") {");
		sc.add("projectionViewer = (" + PROJECTION_VIEWER + ") viewer;");
		sc.add("}");
		sc.add("if (document == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int caretOffset = textWidget.getCaretOffset();");
		sc.add("if (projectionViewer != null) {");
		sc.add("caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);");
		sc.add("}");
		sc.add("final String prevStr;");
		sc.add("if (caretOffset == 0) {");
		sc.add("return;");
		sc.add("}");
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
	}

	private void addAddListenersMethod(JavaComposite sc) {
		sc.addJavadoc("Adds listeners to handle bracket automatic closing.");
		sc.add("private void addListeners() {");
		sc.add("ClosingListener closingListener = new ClosingListener();");
		sc.add("textWidget.addVerifyListener(closingListener);");
		sc.add("textWidget.addVerifyKeyListener(closingListener);");
		sc.add("textWidget.addModifyListener(closingListener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketStringMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns this bracket set as <code>String</code>. This is useful to store the set in " +
			"the <code>" + I_PREFERENCE_STORE + "</code>.\n\n" +
			"@return String the bracket set in the form \"()<>[]\"\n" +
			"@see " + I_PREFERENCE_STORE
		);
		sc.add("public " + STRING + " getBracketString() {");
		sc.add("if (bracketPairs.size() < 1) {");
		sc.add("return \"\";");
		sc.add("}");
		sc.add(STRING + " result = \"\";");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
		sc.add(STRING + " isClosingStr = \"0\";");
		sc.add("if (bracketPair.isClosingEnabledInside()) {");
		sc.add("isClosingStr = \"1\";");
		sc.add("}");
		sc.add("result += bracketPair.getOpeningBracket() + bracketPair.getClosingBracket() + isClosingStr;");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketArrayMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns a list of bracket pairs. This call is for the list in the preference page.\n\n" +
			"@return a list of bracket pairs in the form <code>String[]{\"{BRACKET_SEPARATOR}\",\"(BRACKET_SEPARATOR)\"}</code>"
		);
		sc.add("public String[] getBracketArray() {");
		sc.add("String[] ret = new String[bracketPairs.size()];");
		sc.add("int i = 0;");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
		sc.add("ret[i] = bracketPair.getOpeningBracket() + BRACKET_SEPARATOR + bracketPair.getClosingBracket();");
		sc.add("i++;");
		sc.add("}");
		sc.add("return ret;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetBracketsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Removes the old bracket set and sets the given bracket set. It is useful " +
			"to take a stored <code>String</code> in a preference store. A bracket pair " +
			"contains of opening, closing and isClosingEnabledInside = {'1','0'}.\n\n" +
			"@param bracketSet the bracket set as a <code>String</code> in the form \"()0<>0[]1\". This string must have length == 3*n\n" +
			"@return <code>true</code> if successful"
		);
		sc.add("public boolean setBrackets(String bracketSet) {");
		sc.add("if (bracketSet.length() % 3 != 0) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("bracketPairs = new " + ARRAY_LIST + "<" + getClassNameHelper().getI_BRACKET_PAIR() + ">();");
		sc.add("for (int i = 0; i < bracketSet.length() / 3; i++) {");
		sc.add("addBracketPair(\"\" + bracketSet.charAt(i * 3), \"\" + bracketSet.charAt(i * 3 + 1), bracketSet.charAt(i * 3 + 2) != '0');");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveBracketPairsMethod(StringComposite sc) {
		sc.add("// Removes brackets.");
		sc.add("public void removeBracketPairs(String bracketsAsArray[]) {");
		sc.add("for (String bracket : bracketsAsArray) {");
		sc.add("String[] tmp = bracket.split(BRACKET_SEPARATOR);");
		sc.add("remove(tmp[0], tmp[1]);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveMethod(StringComposite sc) {
		sc.add("// Removes the given bracket pair.");
		sc.add("public " + getClassNameHelper().getI_BRACKET_PAIR() + " remove(String opening, String closing) {");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
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

	private void addGetCounterpartMethod(StringComposite sc) {
		sc.add("// Gets the counter part of a bracket.");
		sc.add("public String getCounterpart(String bracket) {");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
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

	private void addResetBracketsMethod(StringComposite sc) {
		sc.add("// Removes all bracket pairs from this bracket set, reload the bracket set from the preference store.");
		sc.add("public boolean resetBrackets() {");
		sc.add("String bracketPairs = preferenceStore.getString(languageID + " + getClassNameHelper().getPREFERENCE_CONSTANTS() + ".EDITOR_BRACKETS_SUFFIX);");
		sc.add("if (bracketPairs == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("setBrackets(bracketPairs);");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetClosingInsideMethod(StringComposite sc) {
		sc.add("// Sets whether other bracket pairs shall be automatically closed, when used inside of this bracket pair.");
		sc.add("public boolean setClosingEnabledInside(" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair, boolean closingEnabledInside) {");
		sc.add("if (bracketPair instanceof BracketPair) {");
		sc.add("((BracketPair) bracketPair).setClosingEnabledInside(closingEnabledInside);");
		sc.add("return true;");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddBracketPairMethod(StringComposite sc) {
		sc.add("// Adds the bracket pair to this bracket set.");
		sc.add("public boolean addBracketPair(String opening, String closing, boolean closingEnabledInside) {");
		sc.add("if (isBracket(opening) || isBracket(closing)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("bracketPairs.add(new BracketPair(opening, closing, closingEnabledInside));");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketPairMethod2(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_BRACKET_PAIR() + " getBracketPair(int index) {");
		sc.add("try {");
		sc.add("return bracketPairs.get(index);");
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketPairMethod1(StringComposite sc) {
		sc.add("// Returns the bracket pair with the given opening and closing.");
		sc.add("public " + getClassNameHelper().getI_BRACKET_PAIR() + " getBracketPair(String opening, String closing) {");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
		sc.add("if (bracketPair.getOpeningBracket().equals(opening) && bracketPair.getClosingBracket().equals(closing)) {");
		sc.add("return bracketPair;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsBracketMethod(StringComposite sc) {
		sc.add("// Checks whether the string is a bracket.");
		sc.add("public boolean isBracket(String bracket) {");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
		sc.add("if (bracket.equals(bracketPair.getOpeningBracket()) || bracket.equals(bracketPair.getClosingBracket())) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsOpeningBracketMethod(StringComposite sc) {
		sc.add("// Checks whether the given string is an open bracket.");
		sc.add("public boolean isOpeningBracket(String bracket) {");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
		sc.add("if (bracket.equals(bracketPair.getOpeningBracket())) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("// Creates a bracket set to manage the bracket pairs.");
		sc.add("//");
		sc.add("// @param sourceViewer");
		sc.add("//            the source viewer for matching brackets");
		sc.add("// @param extension");
		sc.add("//            the file extension of the DSL");
		sc.add("public " + getResourceClassName() + "(" + I_SOURCE_VIEWER + " sourceViewer, String extension) {");
		sc.add("languageID = extension;");
		sc.add("this.bracketPairs = new " + ARRAY_LIST + "<" + getClassNameHelper().getI_BRACKET_PAIR() + ">();");
		sc.add("if (sourceViewer != null) {");
		sc.add("viewer = sourceViewer;");
		sc.add("textWidget = viewer.getTextWidget();");
		sc.add("}");
		sc.add("preferenceStore = " + getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR) + ".getDefault().getPreferenceStore();");
		sc.add("if (sourceViewer != null && preferenceStore != null) {");
		sc.add("resetBrackets();");
		sc.add("addListeners();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClasses(StringComposite sc) {
		addBracketPairClass(sc);
		addClosingListenerClass(sc);
	}

	private void addClosingListenerClass(StringComposite sc) {
		sc.add("// A listener for the automatic closing.");
		sc.add("private class ClosingListener implements " + VERIFY_LISTENER + ", " + MODIFY_LISTENER + ", " + VERIFY_KEY_LISTENER + " {");
		sc.add("private int closingLength = -1;");
		sc.add("private int addedPosition = -1;");
		sc.add("private boolean closingAdded = false;");
		sc.add("private boolean isEmbraced = false;");
		sc.add("private String closing;");
		sc.addLineBreak();
		
		sc.add("// Automatic closing will be activated if the text about to insert is a bracket.");
		sc.add("public void verifyText(" + VERIFY_EVENT + " e) {");
		sc.add("int caret = textWidget.getCaretOffset();");
		sc.add("if (!isOpeningBracket(e.text)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (caret > 0 && caret < textWidget.getCharCount()) {");
		sc.add(getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair = getBracketPair(textWidget.getTextRange(caret - 1, 1), textWidget.getTextRange(caret, 1));");
		sc.add("if (bracketPair != null && !bracketPair.isClosingEnabledInside())");
		sc.add("return;");
		sc.add("}");
		sc.add("closingAdded = true;");
		sc.add("closing = getCounterpart(e.text);");
		sc.add("e.text += closing;");
		sc.add("closingLength = closing.length();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// After a change there are two cases which have to be considered:");
		sc.add("// 1) if an automatic closing happened the caret will be set between the bracket pair");
		sc.add("// 2) if a bracket opening is deleted on the left side of the caret the");
		sc.add("//    bracket closing on the right side of this caret is deleted as well");
		sc.add("public void modifyText(" + MODIFY_EVENT + " e) {");
		sc.add("if (closingAdded) {");
		sc.add("closingAdded = false;");
		sc.add("addedPosition = textWidget.getCaretOffset() - closingLength;");
		sc.add("textWidget.setCaretOffset(addedPosition);");
		sc.add("closingLength = -1;");
		sc.add("}");
		sc.add("if (isEmbraced) {");
		sc.add("isEmbraced = false;");
		sc.add("textWidget.replaceTextRange(textWidget.getCaretOffset(), 1, \"\");");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// This is for the Backspace key, if you want to delete a previous character.");
		sc.add("public void verifyKey(" + VERIFY_EVENT + " e) {");
		sc.add("int caretOffset = textWidget.getCaretOffset();");
		sc.add("int caret = caretOffset;");
		sc.add("// Discard the closing bracket if there is one");
		sc.add("if (closing != null && closing.equals(\"\" + e.character) && addedPosition == caret) {");
		sc.add("e.doit = false;");
		sc.add("textWidget.setCaretOffset(caret + 1);");
		sc.add("}");
		sc.add("closing = null;");
		sc.add("addedPosition = -1;");
		sc.addLineBreak();
		sc.add("if (caret == 0 || e.keyCode != " + SWT + ".BS || caret == textWidget.getCharCount()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String prevStr = textWidget.getTextRange(caretOffset - 1, 1);");
		sc.add("String nextStr = textWidget.getTextRange(caretOffset, 1);");
		sc.add("if (e.keyCode == " + SWT + ".BS && isOpeningBracket(prevStr) && getCounterpart(prevStr).equals(nextStr)) {");
		sc.add("isEmbraced = true;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addBracketPairClass(StringComposite sc) {
		sc.add("// A single pair of brackets.");
		sc.add("private class BracketPair implements " + getClassNameHelper().getI_BRACKET_PAIR() + " {");
		sc.addLineBreak();
		sc.add("private final " + STRING + "[] brackets;");
		sc.add("private boolean closingEnabledInside;");
		sc.addLineBreak();
		sc.add("public BracketPair(" + STRING + " opening, " + STRING + " closing, boolean closingEnabledInside) {");
		sc.add("brackets = new " + STRING + "[] { opening, closing };");
		sc.add("this.closingEnabledInside = closingEnabledInside;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + STRING + " getClosingBracket() {");
		sc.add("return brackets[1];");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + STRING + " getOpeningBracket() {");
		sc.add("return brackets[0];");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isClosingEnabledInside() {");
		sc.add("return closingEnabledInside;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setClosingEnabledInside(boolean closingEnabledInside) {");
		sc.add("this.closingEnabledInside=closingEnabledInside;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		String positionHelperClassName = getContext().getQualifiedClassName(EArtifact.POSITION_HELPER);
		
		sc.add("// the separator between a bracket pair, should not contain escape needed");
		sc.add("// character, it will be used as regular expression");
		sc.add("public final static " + STRING + " BRACKET_SEPARATOR = \" and \";");
		sc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		sc.add("private " + ARRAY_LIST + "<" + getClassNameHelper().getI_BRACKET_PAIR() + "> bracketPairs;");
		sc.add("private " + I_SOURCE_VIEWER + " viewer;");
		sc.add("private String languageID;");
		sc.add("private " + STYLED_TEXT + " textWidget;");
		sc.add("private " + I_PREFERENCE_STORE + " preferenceStore;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new BracketSetGenerator(context);
	}
}
