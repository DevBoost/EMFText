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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MODIFY_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MODIFY_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STYLED_TEXT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.VERIFY_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.VERIFY_KEY_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.VERIFY_LISTENER;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class BracketSetGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
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
		sc.add("private void addListeners(" + editorClassName + " editor) {");
		sc.add("ClosingListener closingListener = new ClosingListener();");
		sc.add("textWidget.addVerifyListener(closingListener);");
		sc.add("textWidget.addVerifyKeyListener(closingListener);");
		sc.add("textWidget.addModifyListener(closingListener);");
		sc.add("editor.setBracketHandler(closingListener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketStringMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns this bracket set as <code>String</code>. This is useful to store the set in " +
			"the <code>" + I_PREFERENCE_STORE + "</code>.",
			"@return String the bracket set in the form \"()<>[]\"",
			"@see " + I_PREFERENCE_STORE
		);
		sc.add("public String getBracketString() {");
		sc.add("if (bracketPairs.size() < 1) {");
		sc.add("return \"\";");
		sc.add("}");
		sc.add("String result = \"\";");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("String isClosingStr = \"0\";");
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

	private void addSetBracketsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Removes the old bracket set and sets the given bracket set. It is useful " +
			"to take a stored <code>String</code> in a preference store. A bracket pair " +
			"contains of opening, closing and isClosingEnabledInside = {'1','0'}.",
			"@param bracketSet the bracket set as a <code>String</code> in the form \"()0<>0[]1\". This string must have length == 3*n",
			"@return <code>true</code> if successful"
		);
		sc.add("public boolean setBrackets(String bracketSet) {");
		sc.add("if (bracketSet.length() % 3 != 0) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("bracketPairs = new " + ARRAY_LIST + "<" + iBracketPairClassName + ">();");
		sc.add("for (int i = 0; i < bracketSet.length() / 3; i++) {");
		sc.add("addBracketPair(\"\" + bracketSet.charAt(i * 3), \"\" + bracketSet.charAt(i * 3 + 1), bracketSet.charAt(i * 3 + 2) != '0');");
		sc.add("}");
		sc.add("return true;");
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
		sc.addJavadoc("Returns the counter part of a bracket.");
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
		sc.addJavadoc("Removes all bracket pairs from this bracket set, reload the bracket set from the preference store.");
		sc.add("public boolean resetBrackets() {");
		sc.add("String bracketPairs = preferenceStore.getString(languageID + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX);");
		sc.add("if (bracketPairs == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("setBrackets(bracketPairs);");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetClosingInsideMethod(JavaComposite sc) {
		sc.addJavadoc("Sets whether other bracket pairs shall be automatically closed, when used inside of this bracket pair.");
		sc.add("public boolean setClosingEnabledInside(" + iBracketPairClassName + " bracketPair, boolean closingEnabledInside) {");
		sc.add("if (bracketPair instanceof BracketPair) {");
		sc.add("((BracketPair) bracketPair).setClosingEnabledInside(closingEnabledInside);");
		sc.add("return true;");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddBracketPairMethod(JavaComposite sc) {
		sc.addJavadoc("Adds the bracket pair to this bracket set.");
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
		sc.add("public " + iBracketPairClassName + " getBracketPair(int index) {");
		sc.add("try {");
		sc.add("return bracketPairs.get(index);");
		sc.add("} catch (Exception e) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketPairMethod1(JavaComposite sc) {
		sc.addJavadoc("Returns the bracket pair with the given opening and closing.");
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
		sc.addJavadoc("Checks whether the string is a bracket.");
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
		sc.addJavadoc("Checks whether the given string is an open bracket.");
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

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a bracket set to manage the bracket pairs.",
			"@param sourceViewer the source viewer for matching brackets"
		);
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " editor, " + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.add("languageID = new " + metaInformationClassName + "().getSyntaxName();");
		sc.add("this.bracketPairs = new " + ARRAY_LIST + "<" + iBracketPairClassName + ">();");
		sc.add("if (sourceViewer != null) {");
		sc.add("viewer = sourceViewer;");
		sc.add("textWidget = viewer.getTextWidget();");
		sc.add("}");
		sc.add("preferenceStore = " + uiPluginActivatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("if (sourceViewer != null && preferenceStore != null) {");
		sc.add("resetBrackets();");
		sc.add("addListeners(editor);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClasses(JavaComposite sc) {
		addBracketPairClass(sc);
		addClosingListenerClass(sc);
	}

	private void addClosingListenerClass(JavaComposite sc) {
		sc.addJavadoc("A listener for the automatic closing.");
		sc.add("private class ClosingListener implements " + iBracketHandlerClassName + ", " + VERIFY_LISTENER + ", " + MODIFY_LISTENER + ", " + VERIFY_KEY_LISTENER + " {");
		sc.add("private int closingLength = -1;");
		sc.add("private int addedPosition = -1;");
		sc.add("private boolean closingAdded = false;");
		sc.add("private boolean isEmbraced = false;");
		sc.add("private String closing;");
		sc.addLineBreak();
		
		sc.addJavadoc("Automatic closing will be activated if the text about to insert is a bracket.");
		sc.add("public void verifyText(" + VERIFY_EVENT + " e) {");
		sc.add("int caret = textWidget.getCaretOffset();");
		sc.add("if (!isOpeningBracket(e.text)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (caret > 0 && caret < textWidget.getCharCount()) {");
		sc.add(iBracketPairClassName + " bracketPair = getBracketPair(textWidget.getTextRange(caret - 1, 1), textWidget.getTextRange(caret, 1));");
		sc.add("if (bracketPair != null && !bracketPair.isClosingEnabledInside()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("closingAdded = true;");
		sc.add("closing = getCounterpart(e.text);");
		sc.add("e.text += closing;");
		sc.add("closingLength = closing.length();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"After a change there are two cases which have to be considered:",
			"1) if an automatic closing happened the caret will be set between the bracket pair",
			"2) if a bracket opening is deleted on the left side of the caret the " +
			"bracket closing on the right side of this caret is deleted as well"
		);
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
		
		sc.addJavadoc("This is for the Backspace key, if you want to delete a previous character.");
		sc.add("public void verifyKey(" + VERIFY_EVENT + " e) {");
		sc.add("int caretOffset = textWidget.getCaretOffset();");
		sc.add("int caret = caretOffset;");
		sc.addComment("Discard the closing bracket if there is one");
		sc.add("if (closing != null && closing.equals(\"\" + e.character) && addedPosition == caret) {");
		sc.add("e.doit = false;");
		sc.add("textWidget.setCaretOffset(caret + 1);");
		sc.add("}");
		sc.addComment(
			"if the CTRL key is pressed to activate the code completion, " +
			"we do clear the information about the recently closed bracket."
		);
		sc.add("if ((e.keyCode & " + SWT + ".CTRL) != 0) {");
		sc.add("return;");
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
		sc.add("public boolean addedClosingBracket() {");
		sc.add("return closing != null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getClosingBracket() {");
		sc.add("return closing;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addBracketPairClass(JavaComposite sc) {
		sc.addJavadoc("A single pair of brackets.");
		sc.add("private class BracketPair implements " + iBracketPairClassName + " {");
		sc.addLineBreak();
		sc.add("private final String[] brackets;");
		sc.add("private boolean closingEnabledInside;");
		sc.addLineBreak();
		sc.add("public BracketPair(String opening, String closing, boolean closingEnabledInside) {");
		sc.add("brackets = new String[] { opening, closing };");
		sc.add("this.closingEnabledInside = closingEnabledInside;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getClosingBracket() {");
		sc.add("return brackets[1];");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getOpeningBracket() {");
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

	private void addFields(JavaComposite sc) {
		sc.addJavadoc(
			"the separator between a bracket pair, should not contain escape needed " +
			"character, it will be used as regular expression"
		);
		sc.add("public final static String BRACKET_SEPARATOR = \" and \";");
		sc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		sc.add("private " + ARRAY_LIST + "<" + iBracketPairClassName + "> bracketPairs;");
		sc.add("private " + I_SOURCE_VIEWER + " viewer;");
		sc.add("private String languageID;");
		sc.add("private " + STYLED_TEXT + " textWidget;");
		sc.add("private " + I_PREFERENCE_STORE + " preferenceStore;");
		sc.addLineBreak();
	}

	
}
