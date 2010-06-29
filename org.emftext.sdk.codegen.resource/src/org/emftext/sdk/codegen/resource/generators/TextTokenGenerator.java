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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TOKEN;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class TextTokenGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		
		sc.add("public class " + getResourceClassName() + " implements " + iTextTokenClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final " + iMetaInformationClassName + " metaInformation = new " +metaInformationClassName + "();");
		sc.add("private final " + TOKEN + " antlrToken;");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetNameMethod(sc);
		addGetOffsetMethod(sc);
		addGetLengthMethod(sc);
		addCanBeUsedForSyntaxHighlightingMethod(sc);
		addGetTextMethod(sc);
		addGetTokenNameMethod(sc);
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + TOKEN + " antlrToken) {");
		sc.add("super();");
		sc.add("this.antlrToken = antlrToken;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameMethod(JavaComposite sc) {
		sc.add("public " + STRING + " getName() {");
		sc.add("return getTokenName(metaInformation.getTokenNames(), antlrToken.getType());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetOffsetMethod(JavaComposite sc) {
		sc.add("public int getOffset() {");
		sc.add("return ((" + COMMON_TOKEN + ") antlrToken).getStartIndex();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLengthMethod(JavaComposite sc) {
		sc.add("public int getLength() {");
		sc.add("return ((" + COMMON_TOKEN + ") antlrToken).getStopIndex() - ((" + COMMON_TOKEN + ") antlrToken).getStartIndex() + 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanBeUsedForSyntaxHighlightingMethod(JavaComposite sc) {
		sc.add("public boolean canBeUsedForSyntaxHighlighting() {");
		sc.add("int tokenType = antlrToken.getType();");
		sc.add("if (tokenType == " + TOKEN + ".EOF) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".UP) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".DOWN) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".EOR_TOKEN_TYPE) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".INVALID_TOKEN_TYPE) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextMethod(JavaComposite sc) {
		sc.add("public " + STRING + " getText() {");
		sc.add("return antlrToken.getText();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(JavaComposite sc) {
		sc.add("public " + STRING + " getTokenName(" + STRING + "[] tokenNames, int index) {");
		sc.add("if (tokenNames == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(STRING + " tokenName = tokenNames[index];");
		sc.add("if (tokenName != null && tokenName.startsWith(\"'\")) {");
		sc.add("tokenName = tokenName.substring(1, tokenName.length() - 1).trim();");
		sc.add("}");
		sc.add("return tokenName;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
