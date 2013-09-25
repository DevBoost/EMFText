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

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class TokenStyleGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iTokenStyleClassName + " {");
		sc.addLineBreak();
        addFields(sc);
        addConstructor1(sc);
        addConstructor2(sc);
        sc.addGettersSetters();
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
}
