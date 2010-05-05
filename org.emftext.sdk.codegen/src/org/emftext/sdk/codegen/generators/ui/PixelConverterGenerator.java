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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FONT_METRICS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.JFACE_DIALOG;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class PixelConverterGenerator extends JavaBaseGenerator {

	public PixelConverterGenerator() {
		super();
	}

	private PixelConverterGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.PIXEL_CONVERTER);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new PixelConverterGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A utility class for pixel conversion.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("private " + FONT_METRICS + " fFontMetrics;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + CONTROL + " control) {");
		sc.add(GC + " gc = new " + GC + "(control);");
		sc.add("gc.setFont(control.getFont());");
		sc.add("fFontMetrics= gc.getFontMetrics();");
		sc.add("gc.dispose();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int convertHeightInCharsToPixels(int chars) {");
		sc.add("return " + JFACE_DIALOG + ".convertHeightInCharsToPixels(fFontMetrics, chars);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int convertHorizontalDLUsToPixels(int dlus) {");
		sc.add("return " + JFACE_DIALOG + ".convertHorizontalDLUsToPixels(fFontMetrics, dlus);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int convertVerticalDLUsToPixels(int dlus) {");
		sc.add("return " + JFACE_DIALOG + ".convertVerticalDLUsToPixels(fFontMetrics, dlus);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int convertWidthInCharsToPixels(int chars) {");
		sc.add("return " + JFACE_DIALOG + ".convertWidthInCharsToPixels(fFontMetrics, chars);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}
