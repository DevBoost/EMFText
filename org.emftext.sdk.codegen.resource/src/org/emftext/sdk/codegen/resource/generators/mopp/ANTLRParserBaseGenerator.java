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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ANTLR_PARSER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RECOGNIZER_SHARED_STATE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TOKEN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TOKEN_STREAM;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ANTLRParserBaseGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public abstract class " + getResourceClassName() + " extends " + ANTLR_PARSER + " implements " + iTextParserClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("the index of the last token that was handled by retrieveLayoutInformation()");
		sc.add("private int lastPosition2;");
		sc.addLineBreak();
		
		sc.addJavadoc("a collection to store all anonymous tokens");
		sc.add("protected " + LIST + "<" + COMMON_TOKEN
				+ "> anonymousTokens = new " + ARRAY_LIST + "<"
				+ COMMON_TOKEN + ">();");
		sc.addLineBreak();
	}

	private void addConstructors(JavaComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
	}

	private void addMethods(JavaComposite sc) {
		addRetrieveLayoutInformationMethod(sc);
		generatorUtil.addGetLayoutAdapterMethod(sc, layoutInformationAdapterClassName);
	}

	private void addConstructor1(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + TOKEN_STREAM +" input) {");
		sc.add("super(input);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + TOKEN_STREAM +" input, " + RECOGNIZER_SHARED_STATE + " state) {");
		sc.add("super(input, state);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRetrieveLayoutInformationMethod(StringComposite sc) {
		sc.add("protected void retrieveLayoutInformation(" + E_OBJECT + " element, " + syntaxElementClassName + " syntaxElement, Object object) {");
		sc.add("if (!(syntaxElement instanceof " + placeholderClassName + ") && !(syntaxElement instanceof " + keywordClassName + ")) {");
		sc.add("return;");
		sc.add("}");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(element);");
		sc.add("for (" + COMMON_TOKEN + " anonymousToken : anonymousTokens) {");
		sc.add("layoutInformationAdapter.addLayoutInformation(new " + layoutInformationClassName + "(syntaxElement, object, anonymousToken.getStartIndex(), anonymousToken.getText(), null));");
		sc.add("}");
		sc.add("anonymousTokens.clear();");
		sc.add("int currentPos = getTokenStream().index();");
		sc.add("if (currentPos == 0) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int endPos = currentPos - 1;");
		sc.add("for (; endPos >= this.lastPosition2; endPos--) {");
		sc.add(TOKEN + " token = getTokenStream().get(endPos);");
		sc.add("int _channel = token.getChannel();");
		sc.add("if (_channel != 99) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("StringBuilder hiddenTokenText = new StringBuilder();");
		sc.add("StringBuilder visibleTokenText = new StringBuilder();");
		sc.add(COMMON_TOKEN + " firstToken = null;");
		sc.add("for (int pos = this.lastPosition2; pos <= endPos; pos++) {");
		sc.add(TOKEN + " token = getTokenStream().get(pos);");
		sc.add("if (firstToken == null) {");
		sc.add("firstToken = (" + COMMON_TOKEN + ") token;");
		sc.add("}");
		sc.add("int _channel = token.getChannel();");
		sc.add("if (_channel == 99) {");
		sc.add("hiddenTokenText.append(token.getText());");
		sc.add("} else {");
		sc.add("visibleTokenText.append(token.getText());");
		sc.add("}");
		sc.add("}");
		sc.add("int offset = -1;");
		sc.add("if (firstToken != null) {");
		sc.add("offset = firstToken.getStartIndex();");
		sc.add("}");
		sc.add("layoutInformationAdapter.addLayoutInformation(new " + layoutInformationClassName + "(syntaxElement, object, offset, hiddenTokenText.toString(), visibleTokenText.toString()));");
		sc.add("this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);");
		sc.add("}");
		sc.addLineBreak();
	}
}
