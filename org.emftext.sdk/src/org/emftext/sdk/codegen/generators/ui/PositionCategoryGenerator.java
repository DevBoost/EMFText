package org.emftext.sdk.codegen.generators.ui;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class PositionCategoryGenerator extends BaseGenerator {

	public PositionCategoryGenerator(GenerationContext context) {
		super(context, EArtifact.POSITION_CATEGORY);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// An enumeration of all position categories.");
		sc.add("public enum " + getResourceClassName() + " {");
		sc.add("BRACKET, DEFINTION, PROXY;");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
