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

import java.util.List;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.util.StringUtil;

/**
 * This generator composes a provider class that can be used to access the 
 * token styles of a syntax.
 */
public class TokenStyleInformationProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " {");
        sc.addLineBreak();
		addTokenStyleImplClass(sc);
		addGetDefaultStyleMethod(sc);
		sc.add("}");
	}

	private void addGetDefaultStyleMethod(StringComposite sc) {
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
				sc.add("return new TokenStyleImpl(" + color + ", " + bold + ", " + italic + ", " + strikethrough + ", " + underline + ");");
				sc.add("}");
			}
		}
		sc.add("return null;");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addTokenStyleImplClass(StringComposite sc) {
		sc.add("public class TokenStyleImpl implements " + iTokenStyleClassName + " {");
        sc.addLineBreak();
        sc.add("private int[] color;");
        sc.add("private boolean bold;");
        sc.add("private boolean italic;");
        sc.add("private boolean strikethrough;");
        sc.add("private boolean underline;");
        sc.addLineBreak();
        sc.add("public TokenStyleImpl(int[] color, boolean bold, boolean italic, boolean striketrough, boolean underline) {");
        sc.add("super();");
        sc.add("this.color = color;");
        sc.add("this.bold = bold;");
        sc.add("this.italic = italic;");
        sc.add("this.strikethrough = striketrough;");
        sc.add("this.underline = underline;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public int[] getColorAsRGB() {");
        sc.add("return color;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isBold() {");
        sc.add("return bold;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isItalic() {");
        sc.add("return italic;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isStrikethrough() {");
        sc.add("return strikethrough;");
        sc.add("}");
        sc.addLineBreak();
        sc.add("public boolean isUnderline() {");
        sc.add("return underline;");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
	}

	
}
