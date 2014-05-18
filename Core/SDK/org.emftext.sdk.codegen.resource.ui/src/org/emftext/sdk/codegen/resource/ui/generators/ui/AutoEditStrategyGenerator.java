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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEFAULT_INDENT_LINE_AUTO_EDIT_STRATEGY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DOCUMENT_COMMAND;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BAD_LOCATION_EXCEPTION;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class AutoEditStrategyGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
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
	
	private void addMethods(JavaComposite sc) {
		addSetBracketSet(sc);
		addCustomizeDocumentCommand(sc);
		addConsumeAddedClosingBracket(sc);
		addAddClosingBracket(sc);
		addAddClosingBracketAfterEnterIfRequired(sc);
		addCount(sc);
		addGetCloseAfterBracketBefore(sc);
		addIsLineBreak(sc);
	}
	
	private void addSetBracketSet(JavaComposite sc) {
		sc.addJavadoc("This method is only used for injecting a bracket set during tests.");
		sc.add("@Deprecated");
		sc.add("public void setBracketSet(" + bracketSetClassName + " bracketSet) {");
		sc.add("this.bracketSet = bracketSet;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addCustomizeDocumentCommand(JavaComposite sc) {
		sc.add("@Override");
		sc.add("public void customizeDocumentCommand(" + I_DOCUMENT(sc) + " document, " + DOCUMENT_COMMAND(sc) + " command) {");
		sc.add("String text = command.text;");
		sc.add("String textBefore = command.text;");
		sc.add("super.customizeDocumentCommand(document, command);");
		sc.add("String textAfter = command.text;");
		sc.add("if (textAfter.length() < textBefore.length()) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("consumeAddedClosingBracket(document, command);");
		sc.add("addClosingBracketAfterEnterIfRequired(document, command, text, textBefore, textAfter);");
		sc.add("addClosingBracket(document, command);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addConsumeAddedClosingBracket(JavaComposite sc) {
		sc.add("protected void consumeAddedClosingBracket(" + I_DOCUMENT(sc) + " document, " + DOCUMENT_COMMAND(sc) + " command) {");
		sc.addComment("When typing the closing bracket manually and the next character is an auto generated closing bracket, then do not insert the new closing bracket (i.e., make it feel like it was overridden).");
		sc.add("String insertedText = command.text;");
		sc.addLineBreak();
		sc.add("if (!bracketSet.isClosingBracket(insertedText) || insertedText.length() != 1) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("try {");
		sc.add("char insertedBracket = insertedText.charAt(0);");
		sc.addLineBreak();
		sc.add("int offset = command.offset;");
		sc.add("char nextCharacter = document.getChar(offset);");
		sc.addLineBreak();
		sc.addComment("NOTE: To be entirely accurate, one would have to check whether the next character truly _functions_ as a closing bracket (e.g., is the second of a pair of quotes, not the first).");
		sc.add("boolean nextCharacterIsClosingBracket = bracketSet.isClosingBracket(Character.toString(nextCharacter));");
		sc.addLineBreak();
		sc.addComment("TODO: chseidl: find a way to determine that");
		sc.add("boolean nextCharacterWasAddedAutomatically = true;");
		sc.addLineBreak();	
		sc.add("if (insertedBracket == nextCharacter && nextCharacterIsClosingBracket && nextCharacterWasAddedAutomatically) {");
		sc.addComment("Do not add the character again but forward the caret. Effectively gives the illusion of overriding the previously automatically added closing bracket.");
		sc.add("command.text = \"\";");
		sc.add("command.caretOffset = offset + 1;");
		sc.add("command.shiftsCaret = true;");
		sc.add("}");
		sc.add("} catch(" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addAddClosingBracket(JavaComposite sc) {
		sc.add("protected void addClosingBracket(" + I_DOCUMENT(sc) + " document, " + DOCUMENT_COMMAND(sc) + " command) {");
		sc.add("String openingBracket = command.text;");
		sc.addLineBreak();
		sc.add("if (!bracketSet.isOpeningBracket(openingBracket) || !bracketSet.isCloseInstantly(openingBracket)) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("Only add closing bracket if the bracket itself is not already the closing one (i.e., check whether an opening bracket is still open). This often happens for quotes where the opening and closing mark are identical.");
		sc.add("String closingBracket = bracketSet.getCounterpart(openingBracket);");
		sc.addLineBreak();
		sc.addComment("Check if there is an open bracket");
		sc.add("int caretOffset = command.offset;");
		sc.addLineBreak();
		sc.add("String documentText = document.get();");
		sc.add("String before = documentText.substring(0, caretOffset);");
		sc.add("String after = documentText.substring(caretOffset);");
		sc.add("String modifiedDocumentText = before + openingBracket + after;");
		sc.addLineBreak();
		sc.add("int matchingBracketPosition = bracketSet.findMatchingBrackets(modifiedDocumentText, caretOffset + 1);");
		sc.addLineBreak();
		sc.add("boolean bracketPairIsOpen = (matchingBracketPosition != -1 && matchingBracketPosition < caretOffset);");
		sc.add("boolean insertedTextIsClosingBracket = (openingBracket != null && openingBracket.equals(closingBracket));");
		sc.addLineBreak();	
		sc.addComment("Only add the closing bracket if there actually is an according opening bracket. This may not be the case if opening and closing bracket use the same symbol and the closing bracket is typed manually.");
		sc.add("if (!(bracketPairIsOpen && insertedTextIsClosingBracket)) {");
		sc.add("command.text = command.text + closingBracket;");
		sc.add("command.shiftsCaret = false;");
		sc.add("command.caretOffset = command.offset + 1;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addAddClosingBracketAfterEnterIfRequired(JavaComposite sc) {
		sc.add("protected void addClosingBracketAfterEnterIfRequired(" + I_DOCUMENT(sc) + " document, " + DOCUMENT_COMMAND(sc) + " command, String text, String textBefore, String textAfter) {");
		sc.add("boolean isLineBreak = isLineBreak(text);");
		sc.add("if (!isLineBreak) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("String documentText = document.get();");
		sc.add("String openingBracketBefore = getCloseAfterBracketBefore(documentText, command.offset);");
		sc.add("if (openingBracketBefore == null) {");
		sc.add("return;");
		sc.add("}");
		sc.addComment("add additional indentation (because a line break was entered after an opening bracket)");
		// TODO Figure out when to use spaces instead of tabs
		sc.add("command.text = command.text + \"\\t\";");
		sc.add("String closingBracket = bracketSet.getCounterpart(openingBracketBefore);");
		sc.add("boolean closingBracketIsMissing = count(documentText, openingBracketBefore) != count(documentText, closingBracket);");
		sc.addComment("add closing bracket (if required)");
		sc.add("if (closingBracketIsMissing) {");
		sc.add("command.text = command.text + textAfter;");
		sc.add("command.text = command.text + closingBracket;");
		sc.add("}");
		sc.add("command.shiftsCaret = false;");
		sc.add("command.caretOffset = command.offset + textAfter.length() + 1;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addCount(JavaComposite sc) {
		sc.addJavadoc("Returns the number of occurrences of 'searchString' in 'text'.");
		sc.add("protected int count(String text, String searchString) {");
		sc.add("int index = text.indexOf(searchString);");
		sc.add("int count = 0;");
		sc.add("while (index >= 0) {");
		sc.add("count++;");
		sc.add("index = text.indexOf(searchString, index + 1);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return count;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetCloseAfterBracketBefore(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for a bracket that must be closed when line breaks are entered " +
			"and which is located right before the cursor (ignoring whitespace)."
		);
		sc.add("protected String getCloseAfterBracketBefore(String text, int offset) {");
		sc.add("for (int i = offset - 1; i >= 0; i--) {");
		sc.add("char charAtI = text.charAt(i);");
		sc.add("String stringAtI = Character.toString(charAtI);");
		sc.add("if (bracketSet.isCloseAfterEnter(stringAtI)) {");
		sc.add("return stringAtI;");
		sc.add("}");
		sc.add("if (charAtI == ' ' || charAtI == '\\t') {");
		sc.add("continue;");
		sc.add("}");
		sc.add("break;");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addIsLineBreak(JavaComposite sc) {
		sc.add("protected boolean isLineBreak(String text) {");
		sc.add("return \"\\n\".equals(text) || \"\\r\".equals(text) || \"\\r\\n\".equals(text);");
		sc.add("}");
		sc.addLineBreak();
	}
}
