/*******************************************************************************
 * Copyright (c) 2006-2011
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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TOKEN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TOKEN_SCANNER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.J_FACE_TOKEN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PREFERENCE_CONVERTER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TEXT_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class TokenScannerGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"An adapter from the Eclipse <code>" + I_TOKEN_SCANNER + "</code> interface " +
			"to the generated lexer."
		);
		sc.add("public class " + getResourceClassName() + " implements " + I_TOKEN_SCANNER + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + iTextScannerClassName + " lexer;");
		sc.add("private " + iTextTokenClassName + " currentToken;");
		sc.add("private " + LIST +  "<" + iTextTokenClassName + "> nextTokens;");
		sc.add("private int offset;");
		sc.add("private String languageId;");
		sc.add("private " + I_PREFERENCE_STORE + " store;");
		sc.add("private " + colorManagerClassName + " colorManager;");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.addLineBreak();
	}
	
	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc("@param colorManager A manager to obtain color objects");
		sc.add("public " + getResourceClassName() + "(" + iTextResourceClassName + " resource, " + colorManagerClassName + " colorManager) {");
		sc.add("this.resource = resource;");
		sc.add("this.colorManager = colorManager;");
		sc.add("this.lexer = new " + metaInformationClassName + "().createLexer();");
		sc.add("this.languageId = new " + metaInformationClassName + "().getSyntaxName();");
		sc.add(uiPluginActivatorClassName + " plugin = " + uiPluginActivatorClassName + ".getDefault();");
		sc.add("if (plugin != null) {");
		sc.add("this.store = plugin.getPreferenceStore();");
		sc.add("}");
		sc.add("this.nextTokens = new " + ARRAY_LIST + "<" + iTextTokenClassName + ">();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetTokenLengthMethod(sc);
		addGetTokenOffsetMethod(sc);
		addNextTokenMethod(sc);
		addSetRangeMethod(sc);
		addGetTokenTextMethod(sc);
		addConvertToIntArrayMethod(sc);
		addGetStaticTokenStyleMethod(sc);
		addGetDynamicTokenStyleMethod(sc);
		addGetTextAttributeMethod(sc);
		addSplitCurrentTokenMethod(sc);
	}

	private void addGetStaticTokenStyleMethod(JavaComposite sc) {
		String styleProperty = syntaxColoringHelperClassName + ".StyleProperty";

		sc.add("public " + iTokenStyleClassName + " getStaticTokenStyle() {");
		sc.add(iTokenStyleClassName + " staticStyle = null;");
		sc.add("String tokenName = currentToken.getName();");
		sc.add("String enableKey = " + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".ENABLE);");
		sc.add("boolean enabled = store.getBoolean(enableKey);");
		sc.add("if (enabled) {");
		sc.add("String colorKey = " + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".COLOR);");
		sc.add(RGB + " foregroundRGB = " + PREFERENCE_CONVERTER + ".getColor(store, colorKey);");
		// TODO support background color for token styles
		sc.add(RGB + " backgroundRGB = null;");
		sc.add("boolean bold = store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".BOLD));");
		sc.add("boolean italic = store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".ITALIC));");
		sc.add("boolean strikethrough = store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".STRIKETHROUGH));");
		sc.add("boolean underline = store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".UNDERLINE));");
		sc.add("staticStyle = new " + tokenStyleClassName + "(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);");
		sc.add("}");
		sc.add("return staticStyle;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDynamicTokenStyleMethod(JavaComposite sc) {
		sc.add("public " + iTokenStyleClassName + " getDynamicTokenStyle(" + iTokenStyleClassName + " staticStyle) {");
		sc.add(dynamicTokenStyleClassName + " dynamicTokenStyler = new " + dynamicTokenStyleClassName + "();");
		sc.add(iTokenStyleClassName + " dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);");
		sc.add("return dynamicStyle;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConvertToIntArrayMethod(JavaComposite sc) {
		sc.add("public int[] convertToIntArray(" + RGB + " rgb) {");
		sc.add("if (rgb == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return new int[] {rgb.red, rgb.green, rgb.blue};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenTextMethod(StringComposite sc) {
		sc.add("public String getTokenText() {");
		sc.add("return currentToken.getText();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetRangeMethod(JavaComposite sc) {
		sc.add("public void setRange(" + I_DOCUMENT + " document, int offset, int length) {");
		sc.add("this.offset = offset;");
		sc.add("try {");
		sc.add("lexer.setText(document.get(offset, length));");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.addComment("ignore this error. It might occur during editing when locations are outdated quickly.");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addSplitCurrentTokenMethod(JavaComposite sc) {
		sc.addJavadoc("Tries to split the current token if it contains task items.");
		sc.add("public void splitCurrentToken() {");
		sc.add("final String text = currentToken.getText();");
		sc.add("final String name = currentToken.getName();");
		sc.add("final int line = currentToken.getLine();");
		sc.add("final int charStart = currentToken.getOffset();");
		sc.add("final int column = currentToken.getColumn();");
		sc.addLineBreak();
		sc.add(LIST + "<" + taskItemClassName + "> taskItems = new " + taskItemDetectorClassName + "().findTaskItems(text, line, charStart);");
		sc.addLineBreak();
		sc.addComment("this is the offset for the next token to be added");
		sc.add("int offset = charStart;");
		sc.add("int itemBeginRelative;");
		sc.add(sc.declareArrayList("newItems", iTextTokenClassName));
		sc.add("for (" + taskItemClassName + " taskItem : taskItems) {");
		sc.add("int itemBegin = taskItem.getCharStart();");
		sc.add("int itemLine = taskItem.getLine();");
		sc.add("int itemColumn = 0;");
		sc.addLineBreak();
		sc.add("itemBeginRelative = itemBegin - charStart;");
		sc.addComment("create token before task item (TODO if required)");
		sc.add("String textBefore = text.substring(offset - charStart, itemBeginRelative);");
		//sc.add("System.out.println("textBefore = '" + textBefore + "'");");
		sc.add("int textBeforeLength = textBefore.length();");
		sc.add("newItems.add(new " + textTokenClassName + "(name, textBefore, offset, textBeforeLength, line, column, true));");
		sc.addLineBreak();
		sc.addComment("create token for the task item itself");
		sc.add("offset = offset + textBeforeLength;");
		sc.add("String itemText = taskItem.getKeyword();");
		sc.add("int itemTextLength = itemText.length();");
		sc.add("newItems.add(new " + textTokenClassName + "(" + tokenStyleInformationProviderClassName + ".TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));");
		sc.addLineBreak();
		sc.add("offset = offset + itemTextLength;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (!taskItems.isEmpty()) {");
		sc.addComment("create token after last task item (TODO if required)");
		sc.add("String textAfter = text.substring(offset - charStart);");
		sc.add("newItems.add(new " + textTokenClassName + "(name, textAfter, offset, textAfter.length(), line, column, true));");
		sc.add("}");
		sc.addLineBreak();
		/*
		sc.add("for (IHedlTextToken iHedlTextToken : newItems) {");
		sc.add("System.out.println("HedlTokenScanner.splitCurrentToken() " + iHedlTextToken.getOffset() + " - " + iHedlTextToken.getLength());");
		sc.add("}");
		sc.addLineBreak();
		*/
		sc.add("if (!newItems.isEmpty()) {");
		sc.addComment("replace tokens");
		sc.add("currentToken = newItems.remove(0);");
		sc.add("nextTokens = newItems;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
	}

	private void addNextTokenMethod(JavaComposite sc) {
		sc.add("public " + I_TOKEN + " nextToken() {");
		sc.add("boolean isOriginalToken = true;");
		sc.add("if (!nextTokens.isEmpty()) {");
		sc.add("currentToken = nextTokens.remove(0);");
		sc.add("isOriginalToken = false;");
		sc.add("} else {");
		sc.add("currentToken = lexer.getNextToken();");
		sc.add("}");
		sc.add("if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {");
		sc.add("return " + J_FACE_TOKEN + ".EOF;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (isOriginalToken) {");
		sc.add("splitCurrentToken();");
		sc.add("}");
		sc.addLineBreak();
		sc.add(TEXT_ATTRIBUTE + " textAttribute = null;");
		sc.add("String tokenName = currentToken.getName();");
		sc.add("if (tokenName != null) {");
		sc.add(iTokenStyleClassName + " staticStyle = getStaticTokenStyle();");
		sc.addComment("now call dynamic token styler to allow to apply modifications to the static style");
		sc.add(iTokenStyleClassName + " dynamicStyle = getDynamicTokenStyle(staticStyle);");
		sc.add("if (dynamicStyle != null) {");
		sc.add("textAttribute = getTextAttribute(dynamicStyle);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		// potential performance improvement for large files in the future:
		// build a map of tokens and reuse them instead of creating new ones
		sc.add("return new " + J_FACE_TOKEN + "(textAttribute);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextAttributeMethod(StringComposite sc) {
		sc.add("public " + TEXT_ATTRIBUTE + " getTextAttribute(" + iTokenStyleClassName + " tokeStyle) {");
		sc.add("int[] foregroundColorArray = tokeStyle.getColorAsRGB();");
		sc.add(COLOR + " foregroundColor = null;");
		sc.add("if (colorManager != null) {");
		sc.add("foregroundColor = colorManager.getColor(new " + RGB + "(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));");
		sc.add("}");
		sc.add("int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();");
		sc.add(COLOR + " backgroundColor = null;");
		sc.add("if (backgroundColorArray != null) {");
		sc.add(RGB + " backgroundRGB = new " + RGB + "(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);");
		sc.add("if (colorManager != null) {");
		sc.add("backgroundColor = colorManager.getColor(backgroundRGB);");
		sc.add("}");
		sc.add("}");
		sc.add("int style = " + SWT + ".NORMAL;");
		sc.add("if (tokeStyle.isBold()) {");
		sc.add("style = style | " + SWT + ".BOLD;");
		sc.add("}");
		sc.add("if (tokeStyle.isItalic()) {");
		sc.add("style = style | " + SWT + ".ITALIC;");
		sc.add("}");
		sc.add("if (tokeStyle.isStrikethrough()) {");
		sc.add("style = style | " + TEXT_ATTRIBUTE + ".STRIKETHROUGH;");
		sc.add("}");
		sc.add("if (tokeStyle.isUnderline()) {");
		sc.add("style = style | " + TEXT_ATTRIBUTE + ".UNDERLINE;");
		sc.add("}");
		sc.add("return new " + TEXT_ATTRIBUTE + "(foregroundColor, backgroundColor, style);");
		sc.add("}");
		sc.addLineBreak();
	}
	private void addGetTokenOffsetMethod(StringComposite sc) {
		sc.add("public int getTokenOffset() {");
		sc.add("return offset + currentToken.getOffset();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenLengthMethod(StringComposite sc) {
		sc.add("public int getTokenLength() {");
		sc.add("return currentToken.getLength();");
		sc.add("}");
		sc.addLineBreak();
	}
}
