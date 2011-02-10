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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TOKEN;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class AntlrTokenHelperGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private GeneratorUtil generatorUtil = new GeneratorUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A helper class that decides which tokens can be used for custom syntax highlighting."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addCanBeUsedForSyntaxColoringMethod(sc);
		generatorUtil.addCanBeUsedForSyntaxHighlightingMethod(sc);
		addGetTokenNameMethod(sc);
	}

	private void addCanBeUsedForSyntaxColoringMethod(JavaComposite sc) {
		sc.add("public boolean canBeUsedForSyntaxColoring(" + TOKEN + " token) {");
		sc.add("return canBeUsedForSyntaxHighlighting(token.getType());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(JavaComposite sc) {
		sc.add("public String getTokenName(String[] tokenNames, int index) {");
		sc.add("if (tokenNames == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("String tokenName = tokenNames[index];");
		sc.add("if (tokenName != null && tokenName.startsWith(\"'\")) {");
		sc.add("tokenName = tokenName.substring(1, tokenName.length() - 1).trim();");
		sc.add("}");
		sc.add("return tokenName;");
		sc.add("}");
		sc.addLineBreak();
	}
}
