package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RGB;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ColorManagerGenerator extends BaseGenerator {

	public ColorManagerGenerator() {
		super();
	}

	private ColorManagerGenerator(GenerationContext context) {
		super(context, EArtifact.COLOR_MANAGER);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A class for RGB-based color objects.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addMethods(sc);
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		addDisposeMethod(sc);
		addGetColorMethod(sc);
	}

	private void addGetColorMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Constructs and caches the given color.");
		sc.add("//");
		sc.add("// @param rgb The color as " + RGB + "");
		sc.add("// @return The color (from cache or newly constructed)");
		sc.add("//");
		sc.add("public " + COLOR + " getColor(" + RGB + " rgb) {");
		sc.add(COLOR + " color = fColorTable.get(rgb);");
		sc.add("if (color == null) {");
		sc.add("color = new " + COLOR + "(" + DISPLAY + ".getCurrent(), rgb);");
		sc.add("fColorTable.put(rgb, color);");
		sc.add("}");
		sc.add("return color;");
		sc.add("}");
	}

	private void addDisposeMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Disposes all colors in the cache.");
		sc.add("public void dispose() {");
		sc.add(ITERATOR + "<" + COLOR + "> e = fColorTable.values().iterator();");
		sc.add("while (e.hasNext()) {");
		sc.add("e.next().dispose();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("protected " + MAP + "<" + RGB + ", " + COLOR + "> fColorTable = new " + HASH_MAP + "<" + RGB + ", " + COLOR + ">(10);");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ColorManagerGenerator(context);
	}
}
