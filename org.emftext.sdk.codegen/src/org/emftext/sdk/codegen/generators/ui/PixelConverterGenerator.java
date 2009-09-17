package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FONT_METRICS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.JFACE_DIALOG;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class PixelConverterGenerator extends BaseGenerator {

	public PixelConverterGenerator() {
		super();
	}

	private PixelConverterGenerator(GenerationContext context) {
		super(context, EArtifact.PIXEL_CONVERTER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PixelConverterGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A utility class for pixel conversion.");
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
		out.print(sc.toString());
		return true;
	}
}
