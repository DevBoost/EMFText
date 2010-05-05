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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN_SCANNER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.J_FACE_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PREFERENCE_CONVERTER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TEXT_ATTRIBUTE;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class TokenScannerGenerator extends JavaBaseGenerator {

	public TokenScannerGenerator() {
		super();
	}

	private TokenScannerGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.TOKEN_SCANNER);
	}

	public boolean generateJavaContents(JavaComposite sc) {
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
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addGetTokenLengthMethod(sc);
		addGetTokenOffsetMethod(sc);
		addNextTokenMethod(sc);
		addSetRangeMethod(sc);
		addGetTokenTextMethod(sc);
	}

	private void addGetTokenTextMethod(StringComposite sc) {
		sc.add("public String getTokenText() {");
		sc.add("return currentToken.getText();");
		sc.add("}");
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

	private void addNextTokenMethod(StringComposite sc) {
		String styleProperty = syntaxColoringHelperClassName + ".StyleProperty";

		sc.add("public " + I_TOKEN + " nextToken() {");
		sc.add("currentToken = lexer.getNextToken();");
		sc.add("if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {");
		sc.add("return " + J_FACE_TOKEN + ".EOF;");
		sc.add("}");
		sc.add(TEXT_ATTRIBUTE + " ta = null;");
		sc.add("String tokenName = currentToken.getName();");
		sc.add("if (tokenName != null) {");
		sc.add("String enableKey = " + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".ENABLE);");
		sc.add("if (store.getBoolean(enableKey)) {");
		sc.add("String colorKey = " + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".COLOR);");
		sc.add(COLOR + " color = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(store, colorKey));");
		sc.add("int style = " + SWT + ".NORMAL;");
		sc.add("if (store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".BOLD))) {");
		sc.add("style = style | " + SWT + ".BOLD;");
		sc.add("}");
		sc.add("if (store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".ITALIC))) {");
		sc.add("style = style | " + SWT + ".ITALIC;");
		sc.add("}");
		sc.add("if (store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".STRIKETHROUGH))) {");
		sc.add("style = style | " + TEXT_ATTRIBUTE + ".STRIKETHROUGH;");
		sc.add("}");
		sc.add("if (store.getBoolean(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageId, tokenName, " + styleProperty + ".UNDERLINE))) {");
		sc.add("style = style | " + TEXT_ATTRIBUTE + ".UNDERLINE;");
		sc.add("}");
		sc.add("ta = new " + TEXT_ATTRIBUTE + "(color, null, style);");
		sc.add("}");
		sc.add("}");
		// potential performance improvement for large files in the future:
		// build a map of tokens and reuse them instead of creating new ones
		sc.add("return new " + J_FACE_TOKEN + "(ta);");
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

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc("@param colorManager A manager to obtain color objects");
		sc.add("public " + getResourceClassName() + "(" + colorManagerClassName + " colorManager) {");
		sc.add("this.lexer = new " + metaInformationClassName + "().createLexer();");
		sc.add("this.languageId = new " + metaInformationClassName + "().getSyntaxName();");
		sc.add("this.store = " + pluginActivatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("this.colorManager = colorManager;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + iTextScannerClassName + " lexer;");
		sc.add("private " + iTextTokenClassName + " currentToken;");
		sc.add("private int offset;");
		sc.add("private String languageId;");
		sc.add("private " + I_PREFERENCE_STORE + " store;");
		sc.add("private " + colorManagerClassName + " colorManager;");
		sc.addLineBreak();
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new TokenScannerGenerator(context);
	}
}
