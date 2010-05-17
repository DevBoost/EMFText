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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STRING;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TOKEN;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class AntlrTokenHelperGenerator extends UIJavaBaseGenerator {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new AntlrTokenHelperGenerator());

	private AntlrTokenHelperGenerator() {
		super();
	}

	private AntlrTokenHelperGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.ANTLR_TOKEN_HELPER);
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A helper class that decides which tokens can be used for custom syntax highlighting.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("public boolean canBeUsedForSyntaxColoring(" + TOKEN + " token) {");
		sc.add("return canBeUsedForSyntaxColoring(token.getType());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public boolean canBeUsedForSyntaxColoring(int tokenType) {");
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
		return new AntlrTokenHelperGenerator(parent, context);
	}
}
