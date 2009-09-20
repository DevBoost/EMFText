package org.emftext.sdk.codegen.generators.util;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class CastUtilGenerator extends BaseGenerator {

	public CastUtilGenerator() {
		super();
	}

	private CastUtilGenerator(GenerationContext context) {
		super(context, EArtifact.CAST_UTIL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new CastUtilGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Utility class that provides a method to cast objects to");
		sc.add("// type parameterized classes without a warning.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public static <T> T cast(Object temp) {");
		sc.add("return (T) temp;");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
