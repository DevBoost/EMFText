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

		sc.add("private " + bracketSetClassName + " bracketSet;");
		sc.addLineBreak();
		
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
		
		sc.addJavadoc("This method is only used for injecting a bracket set during tests.");
		sc.add("@Deprecated");
		sc.add("public void setBracketSet(" + bracketSetClassName + " bracketSet) {");
		sc.add("this.bracketSet = bracketSet;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("@Override");
		sc.add("public void customizeDocumentCommand(" + I_DOCUMENT(sc) + " document, " + DOCUMENT_COMMAND(sc) + " command) {");
		sc.add("String text = command.text;");
		sc.add("String textBefore = command.text;");
		sc.add("super.customizeDocumentCommand(document, command);");
		sc.add("String textAfter = command.text;");
		sc.add("if (textAfter.length() < textBefore.length()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("addClosingBracketAfterEnterIfRequired(document, command, text,");
		sc.add("textBefore, textAfter);");
		sc.add("addClosingBracket(command);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("protected void addClosingBracket(" + DOCUMENT_COMMAND(sc) + " command) {");
		sc.add("String insertedText = command.text;");
		sc.add("boolean closeInstantly = bracketSet.isCloseInstantly(insertedText);");
		sc.add("if (!closeInstantly) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String closingBracket = bracketSet.getCounterpart(insertedText);");
		sc.add("command.text = command.text + closingBracket;");
		sc.add("command.shiftsCaret = false;");
		sc.add("command.caretOffset = command.offset + 1;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("protected void addClosingBracketAfterEnterIfRequired(" + I_DOCUMENT(sc) + " document, " + DOCUMENT_COMMAND(sc) + " command, String text, String textBefore, String textAfter) {");
		sc.add("boolean isLineBreak = isLineBreak(text);");
		sc.add("if (!isLineBreak) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String openingBracketBefore = getCloseAfterBracketBefore(document.get(), command.offset);");
		sc.add("if (openingBracketBefore == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String indentation = textAfter.substring(0, textBefore.length());");
		sc.addComment("add additional indentation (because a line break was entered after an opening bracket)");
		// TODO Figure out when to use spaces instead of tabs
		sc.add("command.text = command.text + \"\\t\";");
		sc.add("command.text = command.text + indentation;");
		sc.addComment("add closing bracket");
		sc.add("String closingBracket = bracketSet.getCounterpart(openingBracketBefore);");
		sc.add("command.text = command.text + closingBracket;");
		sc.add("command.shiftsCaret = false;");
		sc.add("command.caretOffset = command.offset + indentation.length() + 1;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Searches for a bracket the must be closed when line breaks are entered " +
			"and which is located right before the cursor (ignoring whitespace)."
		);
		sc.add("protected String getCloseAfterBracketBefore(String text, int offset) {");
		sc.add("for (int i = offset - 1; i >= 0; i--) {");
		sc.add("char charAtI = text.charAt(i);");
		sc.add("String stringAtI = Character.toString(charAtI);");
		sc.add("if (bracketSet.isCloseAfterEnter(stringAtI)) {");
		sc.add("return stringAtI;");
		sc.add("}");
		sc.add("if (charAtI == ' ' || charAtI == '\t') {");
		sc.add("continue;");
		sc.add("}");
		sc.add("break;");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("protected boolean isLineBreak(String text) {");
		sc.add("return \"\\n\".equals(text) || \"\\r\".equals(text) || \"\\r\\n\".equals(text);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
