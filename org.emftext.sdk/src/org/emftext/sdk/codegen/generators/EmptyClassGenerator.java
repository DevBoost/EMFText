package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class EmptyClassGenerator extends BaseGenerator {

	public EmptyClassGenerator(GenerationContext context, String className) {
		super(context.getPackageName(), className);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// this empty class was generated to overwrite exiting");
		sc.add("// classes");
		sc.add("public class " + getResourceClassName() + " {");
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}
}
