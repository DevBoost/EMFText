/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RGB;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class ColorManagerGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc("A class for RGB-based color objects.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addDisposeMethod(sc);
		addGetColorMethod(sc);
	}

	private void addGetColorMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Constructs and caches the given color.",
			"@param rgb The color as " + RGB(sc),
			"@return The color (from cache or newly constructed)"
		);
		sc.add("public " + COLOR(sc) + " getColor(" + RGB(sc) + " rgb) {");
		sc.add(COLOR(sc) + " color = fColorTable.get(rgb);");
		sc.add("if (color == null) {");
		sc.add("color = new " + COLOR(sc) + "(" + DISPLAY(sc) + ".getCurrent(), rgb);");
		sc.add("fColorTable.put(rgb, color);");
		sc.add("}");
		sc.add("return color;");
		sc.add("}");
	}

	private void addDisposeMethod(JavaComposite sc) {
		sc.addJavadoc("Disposes all colors in the cache.");
		sc.add("public void dispose() {");
		sc.add(ITERATOR(sc) + "<" + COLOR(sc) + "> e = fColorTable.values().iterator();");
		sc.add("while (e.hasNext()) {");
		sc.add("e.next().dispose();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("protected " + MAP(sc) + "<" + RGB(sc) + ", " + COLOR(sc) + "> fColorTable = new " + LINKED_HASH_MAP(sc) + "<" + RGB(sc) + ", " + COLOR(sc) + ">(10);");
		sc.addLineBreak();
	}

	
}
