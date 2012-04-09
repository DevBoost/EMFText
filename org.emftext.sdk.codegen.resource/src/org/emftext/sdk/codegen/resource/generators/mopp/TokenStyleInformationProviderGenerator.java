/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.sdk.codegen.resource.generators.mopp;

import java.util.List;

import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.util.StringUtil;

/**
 * This generator composes a provider class that can be used to access the 
 * token styles of a syntax.
 */
@SyntaxDependent
public class TokenStyleInformationProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " {");
        sc.addLineBreak();
        sc.add("public static String TASK_ITEM_TOKEN_NAME = \"TASK_ITEM\";");
        sc.addLineBreak();
		addGetDefaultTokenStyleMethod(sc);
		sc.add("}");
	}

	private void addGetDefaultTokenStyleMethod(StringComposite sc) {
		List<TokenStyle> styles = getContext().getConcreteSyntax().getAllTokenStyles();
		
		sc.add("public " + iTokenStyleClassName + " getDefaultTokenStyle(String tokenName) {");
		for (TokenStyle nextStyle : styles) {
			for (String name : nextStyle.getTokenNames()) {
				sc.add("if (\"" + StringUtil.escapeToJavaString(StringUtil.escapeToANTLRKeyword(name)) + "\".equals(tokenName)) {");
				String rgb = nextStyle.getRgb();
				String color = "new int[] {0x" + rgb.substring(0, 2)+ ", 0x" + rgb.substring(2, 4) + ", 0x" + rgb.substring(4, 6) + "}";
				String bold = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.BOLD));
				String italic = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.ITALIC));
				String strikethrough = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.STRIKETHROUGH));
				String underline = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.UNDERLINE));
				sc.add("return new " + tokenStyleClassName + "(" + color + ", null, " + bold + ", " + italic + ", " + strikethrough + ", " + underline + ");");
				sc.add("}");
			}
		}
		sc.add("return null;");
		sc.add("}");
        sc.addLineBreak();
	}
}
