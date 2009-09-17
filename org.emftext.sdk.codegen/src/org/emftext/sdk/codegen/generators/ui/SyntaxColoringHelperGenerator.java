package org.emftext.sdk.codegen.generators.ui;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class SyntaxColoringHelperGenerator extends BaseGenerator {

	public SyntaxColoringHelperGenerator() {
		super();
	}

	private SyntaxColoringHelperGenerator(GenerationContext context) {
		super(context, EArtifact.SYNTAX_COLORING_HELPER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new SyntaxColoringHelperGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public static enum StyleProperty {");
		sc.addLineBreak();
		sc.add("BOLD(\"bold\"),");
		sc.add("ITALIC(\"italic\"),");
		sc.add("ENABLE(\"enable\"),");
		sc.add("UNDERLINE(\"underline\"),");
		sc.add("STRIKETHROUGH(\"strikethrough\"),");
		sc.add("COLOR(\"color\");");
		sc.addLineBreak();
		sc.add("private String suffix;");
		sc.addLineBreak();
		sc.add("private StyleProperty(String suffix) {");
		sc.add("this.suffix = suffix;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getSuffix() {");
		sc.add("return suffix;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static String getPreferenceKey(String languageID, String tokenName, StyleProperty styleProperty) {");
		sc.add("return languageID + \"$\" + tokenName + \"$\" + styleProperty.getSuffix();");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
