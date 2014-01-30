/*******************************************************************************
 * Copyright (c) 2006-2013
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

import java.util.Arrays;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class TokenStyleGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iTokenStyleClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor1(sc);
		addConstructor2(sc);
        sc.addGettersSetters();
        addHashCodeMethod(sc);
        addEqualsMethod(sc);

        sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addFieldGetSet("colorAsRGB", "int[]");
		sc.addFieldGetSet("backgroundColorAsRGB", "int[]");
		sc.addFieldGetSet("bold", "boolean");
		sc.addFieldGetSet("italic", "boolean");
		sc.addFieldGetSet("strikethrough", "boolean");
		sc.addFieldGetSet("underline", "boolean");
		sc.addFields();
	}

	private void addConstructor1(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(int[] colorAsRGB, int[] backgroundColorAsRGB, boolean bold, boolean italic, boolean striketrough, boolean underline) {");
        sc.add("super();");
        sc.add("this.colorAsRGB = colorAsRGB;");
        sc.add("this.backgroundColorAsRGB = backgroundColorAsRGB;");
        sc.add("this.bold = bold;");
        sc.add("this.italic = italic;");
        sc.add("this.strikethrough = striketrough;");
        sc.add("this.underline = underline;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addConstructor2(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iTokenStyleClassName + " styleToCopy) {");
        sc.add("this(styleToCopy.getColorAsRGB(), styleToCopy.getBackgroundColorAsRGB(), styleToCopy.isBold(), styleToCopy.isItalic(), styleToCopy.isStrikethrough(), styleToCopy.isUnderline());");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addHashCodeMethod(JavaComposite sc) {
		sc.add("@Override");
        sc.add("public int hashCode() {");
        sc.add("final int prime = 31;");
        sc.add("int result = 1;");
        sc.add("result = prime * result + " + sc.getClassName(Arrays.class) + ".hashCode(backgroundColorAsRGB);");
        sc.add("result = prime * result + (bold ? 1231 : 1237);");
        sc.add("result = prime * result + " + sc.getClassName(Arrays.class) + ".hashCode(colorAsRGB);");
        sc.add("result = prime * result + (italic ? 1231 : 1237);");
        sc.add("result = prime * result + (strikethrough ? 1231 : 1237);");
        sc.add("result = prime * result + (underline ? 1231 : 1237);");
        sc.add("return result;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addEqualsMethod(JavaComposite sc) {
		sc.add("@Override");
        sc.add("public boolean equals(Object obj) {");
        sc.add("if (this == obj)");
        sc.add("return true;");
        sc.add("if (obj == null)");
        sc.add("return false;");
        sc.add("if (getClass() != obj.getClass())");
        sc.add("return false;");
        sc.add(tokenStyleClassName + " other = (" + tokenStyleClassName + ") obj;");
        sc.add("if (!" + sc.getClassName(Arrays.class) + ".equals(backgroundColorAsRGB, other.backgroundColorAsRGB))");
        sc.add("return false;");
        sc.add("if (bold != other.bold)");
        sc.add("return false;");
        sc.add("if (!" + sc.getClassName(Arrays.class) + ".equals(colorAsRGB, other.colorAsRGB))");
        sc.add("return false;");
        sc.add("if (italic != other.italic)");
        sc.add("return false;");
        sc.add("if (strikethrough != other.strikethrough)");
        sc.add("return false;");
        sc.add("if (underline != other.underline)");
        sc.add("return false;");
        sc.add("return true;");
        sc.add("}");
        sc.addLineBreak();
	}
}
