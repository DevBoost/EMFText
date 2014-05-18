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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEFAULT_INDENT_LINE_AUTO_EDIT_STRATEGY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DOCUMENT_COMMAND;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PREFERENCE_STORE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class AutoEditStrategyGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The " + getResourceClassName() + " extends the default auto " +
			"edit strategy such that an additional tab is added if a line " +
			"break is entered after opening brackets which are configured " +
			"as <code>closeAfterEnter</code>. Also, closing brackets are automatically " +
			"inserted right away when opening brackets are added where " +
			"<code>closeAfterEnter</code> is set to <code>false</code>."
		);
		sc.add("public class " + getResourceClassName() + " extends " + DEFAULT_INDENT_LINE_AUTO_EDIT_STRATEGY(sc) + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}
	
	private void addFields(JavaComposite sc) {
		sc.add("private " + bracketSetClassName + " bracketSet;");
		sc.addLineBreak();
	}
	
	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add(uiPluginActivatorClassName + " plugin = " + uiPluginActivatorClassName + ".getDefault();");
		sc.add("if (plugin != null) {");
		sc.add(I_PREFERENCE_STORE(sc) + " preferenceStore = plugin.getPreferenceStore();");
		sc.add("bracketSet = new " + bracketSetClassName + "();");
		sc.add("bracketSet.resetBrackets(preferenceStore);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMethods(JavaComposite jc) {
		addSetBracketSetMethod(jc);
		addCustomizeDocumentCommandMethod(jc);
		addConsumeAddedClosingBracketMethod(jc);
		addAddClosingBracketMethod(jc);
		addAddClosingBracketAfterEnterIfRequiredMethod(jc);
		addCountMethod(jc);
		addGetCloseAfterBracketBeforeMethod(jc);
		addIsLineBreakMethod(jc);
	}
	
	private void addSetBracketSetMethod(JavaComposite jc) {
		jc.addJavadoc("This method is only used for injecting a bracket set during tests.");
		jc.add("@Deprecated");
		jc.add("public void setBracketSet(" + bracketSetClassName + " bracketSet) {");
		jc.add("this.bracketSet = bracketSet;");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addCustomizeDocumentCommandMethod(JavaComposite jc) {
		jc.add("@Override");
		jc.add("public void customizeDocumentCommand(" + I_DOCUMENT(jc) + " document, " + DOCUMENT_COMMAND(jc) + " command) {");
		jc.add("String text = command.text;");
		jc.add("String textBefore = command.text;");
		jc.add("super.customizeDocumentCommand(document, command);");
		jc.add("String textAfter = command.text;");
		jc.add("if (textAfter.length() < textBefore.length()) {");
		jc.add("return;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("consumeAddedClosingBracket(document, command);");
		jc.add("addClosingBracketAfterEnterIfRequired(document, command, text, textBefore, textAfter);");
		jc.add("addClosingBracket(document, command);");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addConsumeAddedClosingBracketMethod(JavaComposite jc) {
		jc.add("protected void consumeAddedClosingBracket(" + I_DOCUMENT(jc) + " document, " + DOCUMENT_COMMAND(jc) + " command) {");
		jc.addComment("When typing the closing bracket manually and the next character is an auto generated closing bracket, then do not insert the new closing bracket (i.e., make it feel like it was overridden).");
		jc.add("String insertedText = command.text;");
		jc.addLineBreak();
		jc.add("if (!bracketSet.isClosingBracket(insertedText) || insertedText.length() != 1) {");
		jc.add("return;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("try {");
		jc.add("char insertedBracket = insertedText.charAt(0);");
		jc.addLineBreak();
		jc.add("int offset = command.offset;");
		jc.add("char nextCharacter = document.getChar(offset);");
		jc.addLineBreak();
		jc.addComment("NOTE: To be entirely accurate, one would have to check whether the next character truly _functions_ as a closing bracket (e.g., is the second of a pair of quotes, not the first).");
		jc.add("boolean nextCharacterIsClosingBracket = bracketSet.isClosingBracket(Character.toString(nextCharacter));");
		jc.addLineBreak();
		// TODO chseidl: find a way to determine that
		jc.add("boolean nextCharacterWasAddedAutomatically = true;");
		jc.addLineBreak();	
		jc.add("if (insertedBracket == nextCharacter && nextCharacterIsClosingBracket && nextCharacterWasAddedAutomatically) {");
		jc.addComment("Do not add the character again but forward the caret. Effectively gives the illusion of overriding the previously automatically added closing bracket.");
		jc.add("command.text = \"\";");
		jc.add("command.caretOffset = offset + 1;");
		jc.add("command.shiftsCaret = true;");
		jc.add("}");
		jc.add("} catch(" + BAD_LOCATION_EXCEPTION(jc) + " e) {");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addAddClosingBracketMethod(JavaComposite jc) {
		jc.add("protected void addClosingBracket(" + I_DOCUMENT(jc) + " document, " + DOCUMENT_COMMAND(jc) + " command) {");
		jc.add("String openingBracket = command.text;");
		jc.addLineBreak();
		jc.add("if (!bracketSet.isOpeningBracket(openingBracket) || !bracketSet.isCloseInstantly(openingBracket)) {");
		jc.add("return;");
		jc.add("}");
		jc.addLineBreak();
		jc.addComment("Only add closing bracket if the bracket itself is not already the closing one (i.e., check whether an opening bracket is still open). This often happens for quotes where the opening and closing mark are identical.");
		jc.add("String closingBracket = bracketSet.getCounterpart(openingBracket);");
		jc.addLineBreak();
		jc.addComment("Check if there is an open bracket");
		jc.add("int caretOffset = command.offset;");
		jc.addLineBreak();
		jc.add("String documentText = document.get();");
		jc.add("String before = documentText.substring(0, caretOffset);");
		jc.add("String after = documentText.substring(caretOffset);");
		jc.add("String modifiedDocumentText = before + openingBracket + after;");
		jc.addLineBreak();
		jc.add("int matchingBracketPosition = bracketSet.findMatchingBrackets(modifiedDocumentText, caretOffset + 1);");
		jc.addLineBreak();
		jc.add("boolean bracketPairIsOpen = (matchingBracketPosition != -1 && matchingBracketPosition < caretOffset);");
		jc.add("boolean insertedTextIsClosingBracket = (openingBracket != null && openingBracket.equals(closingBracket));");
		jc.addLineBreak();	
		jc.addComment("Only add the closing bracket if there actually is an according opening bracket. This may not be the case if opening and closing bracket use the same symbol and the closing bracket is typed manually.");
		jc.add("if (!(bracketPairIsOpen && insertedTextIsClosingBracket)) {");
		jc.add("command.text = command.text + closingBracket;");
		jc.add("command.shiftsCaret = false;");
		jc.add("command.caretOffset = command.offset + 1;");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addAddClosingBracketAfterEnterIfRequiredMethod(JavaComposite jc) {
		jc.add("protected void addClosingBracketAfterEnterIfRequired(" + I_DOCUMENT(jc) + " document, " + DOCUMENT_COMMAND(jc) + " command, String text, String textBefore, String textAfter) {");
		jc.add("boolean isLineBreak = isLineBreak(text);");
		jc.add("if (!isLineBreak) {");
		jc.add("return;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("String documentText = document.get();");
		jc.add("String openingBracketBefore = getCloseAfterBracketBefore(documentText, command.offset);");
		jc.add("if (openingBracketBefore == null) {");
		jc.add("return;");
		jc.add("}");
		jc.addComment("add additional indentation (because a line break was entered after an opening bracket)");
		// TODO Figure out when to use spaces instead of tabs
		jc.add("command.text = command.text + \"\\t\";");
		jc.add("String closingBracket = bracketSet.getCounterpart(openingBracketBefore);");
		jc.add("boolean closingBracketIsMissing = count(documentText, openingBracketBefore) != count(documentText, closingBracket);");
		jc.addComment("add closing bracket (if required)");
		jc.add("if (closingBracketIsMissing) {");
		jc.add("command.text = command.text + textAfter;");
		jc.add("command.text = command.text + closingBracket;");
		jc.add("}");
		jc.add("command.shiftsCaret = false;");
		jc.add("command.caretOffset = command.offset + textAfter.length() + 1;");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addCountMethod(JavaComposite jc) {
		jc.addJavadoc("Returns the number of occurrences of 'searchString' in 'text'.");
		jc.add("protected int count(String text, String searchString) {");
		jc.add("int index = text.indexOf(searchString);");
		jc.add("int count = 0;");
		jc.add("while (index >= 0) {");
		jc.add("count++;");
		jc.add("index = text.indexOf(searchString, index + 1);");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return count;");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addGetCloseAfterBracketBeforeMethod(JavaComposite jc) {
		jc.addJavadoc(
			"Searches for a bracket that must be closed when line breaks are entered " +
			"and which is located right before the cursor (ignoring whitespace)."
		);
		jc.add("protected String getCloseAfterBracketBefore(String text, int offset) {");
		jc.add("for (int i = offset - 1; i >= 0; i--) {");
		jc.add("char charAtI = text.charAt(i);");
		jc.add("String stringAtI = Character.toString(charAtI);");
		jc.add("if (bracketSet.isCloseAfterEnter(stringAtI)) {");
		jc.add("return stringAtI;");
		jc.add("}");
		jc.add("if (charAtI == ' ' || charAtI == '\\t') {");
		jc.add("continue;");
		jc.add("}");
		jc.add("break;");
		jc.add("}");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addIsLineBreakMethod(JavaComposite jc) {
		jc.add("protected boolean isLineBreak(String text) {");
		jc.add("return \"\\n\".equals(text) || \"\\r\".equals(text) || \"\\r\\n\".equals(text);");
		jc.add("}");
		jc.addLineBreak();
	}
}
