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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class TokenStyleGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iTokenStyleClassName + " {");
		sc.addLineBreak();
        addFields(sc);
        addConstructorMethod(sc);
        addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private int[] color;");
		sc.add("private int[] backgroundColor;");
        sc.add("private boolean bold;");
        sc.add("private boolean italic;");
        sc.add("private boolean strikethrough;");
        sc.add("private boolean underline;");
        sc.addLineBreak();
	}

	private void addConstructorMethod(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(int[] color, int[] backgroundColor, boolean bold, boolean italic, boolean striketrough, boolean underline) {");
        sc.add("super();");
        sc.add("this.color = color;");
        sc.add("this.backgroundColor = backgroundColor;");
        sc.add("this.bold = bold;");
        sc.add("this.italic = italic;");
        sc.add("this.strikethrough = striketrough;");
        sc.add("this.underline = underline;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetColorAsRGBMethod(sc);
		addGetBackgroundColorAsRGBMethod(sc);
        addIsBoldMethod(sc);
        addIsItalicMethod(sc);
        addIsStrikethroughMethod(sc);
        addIsUnderlineMethod(sc);
	}

	private void addGetColorAsRGBMethod(JavaComposite sc) {
		sc.add("public int[] getColorAsRGB() {");
        sc.add("return color;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetBackgroundColorAsRGBMethod(JavaComposite sc) {
		sc.add("public int[] getBackgroundColorAsRGB() {");
        sc.add("return backgroundColor;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addIsBoldMethod(JavaComposite sc) {
		sc.add("public boolean isBold() {");
        sc.add("return bold;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addIsItalicMethod(JavaComposite sc) {
		sc.add("public boolean isItalic() {");
        sc.add("return italic;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addIsStrikethroughMethod(JavaComposite sc) {
		sc.add("public boolean isStrikethrough() {");
        sc.add("return strikethrough;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addIsUnderlineMethod(JavaComposite sc) {
		sc.add("public boolean isUnderline() {");
        sc.add("return underline;");
        sc.add("}");
        sc.addLineBreak();
	}

}
