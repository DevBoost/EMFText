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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RGB;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class ColorManagerGenerator extends UIJavaBaseGenerator {

	public ColorManagerGenerator() {
		super();
	}

	private ColorManagerGenerator(GenerationContext context) {
		super(context, TextResourceUIArtifacts.COLOR_MANAGER);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc("A class for RGB-based color objects.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addMethods(sc);
		
		sc.add("}");
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addDisposeMethod(sc);
		addGetColorMethod(sc);
	}

	private void addGetColorMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Constructs and caches the given color.",
			"@param rgb The color as " + RGB,
			"@return The color (from cache or newly constructed)"
		);
		sc.add("public " + COLOR + " getColor(" + RGB + " rgb) {");
		sc.add(COLOR + " color = fColorTable.get(rgb);");
		sc.add("if (color == null) {");
		sc.add("color = new " + COLOR + "(" + DISPLAY + ".getCurrent(), rgb);");
		sc.add("fColorTable.put(rgb, color);");
		sc.add("}");
		sc.add("return color;");
		sc.add("}");
	}

	private void addDisposeMethod(JavaComposite sc) {
		sc.addJavadoc("Disposes all colors in the cache.");
		sc.add("public void dispose() {");
		sc.add(ITERATOR + "<" + COLOR + "> e = fColorTable.values().iterator();");
		sc.add("while (e.hasNext()) {");
		sc.add("e.next().dispose();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("protected " + MAP + "<" + RGB + ", " + COLOR + "> fColorTable = new " + LINKED_HASH_MAP + "<" + RGB + ", " + COLOR + ">(10);");
		sc.addLineBreak();
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new ColorManagerGenerator(context);
	}
}
