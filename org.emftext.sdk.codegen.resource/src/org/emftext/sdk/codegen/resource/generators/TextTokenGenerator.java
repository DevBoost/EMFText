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

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;

public class TextTokenGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new TextTokenGenerator());

	private TextTokenGenerator() {
		super();
	}

	public TextTokenGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.TEXT_TOKEN);
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		
		sc.add("public class " + getResourceClassName() + " implements " + iTextTokenClassName + " {");
		sc.addLineBreak();
		sc.add("private final " + iMetaInformationClassName + " metaInformation = new " +metaInformationClassName + "();");
		sc.add("private final " + TOKEN + " antlrToken;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + TOKEN + " antlrToken) {");
		sc.add("super();");
		sc.add("this.antlrToken = antlrToken;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + STRING + " getName() {");
		sc.add("return getTokenName(metaInformation.getTokenNames(), antlrToken.getType());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getOffset() {");
		sc.add("return ((" + COMMON_TOKEN + ") antlrToken).getStartIndex();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getLength() {");
		sc.add("return ((" + COMMON_TOKEN + ") antlrToken).getStopIndex() - ((" + COMMON_TOKEN + ") antlrToken).getStartIndex() + 1;");
		sc.add("}");
		sc.addLineBreak();
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
		sc.add("public " + STRING + " getText() {");
		sc.add("return antlrToken.getText();");
		sc.add("}");
		sc.addLineBreak();
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
		sc.add("}");
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new TextTokenGenerator(parent, context);
	}
}
