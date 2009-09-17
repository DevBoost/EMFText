package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_PROBLEM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_PROBLEM_TYPE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ProblemClassGenerator extends BaseGenerator {

	public ProblemClassGenerator() {
		super();
	}

	private ProblemClassGenerator(GenerationContext context) {
		super(context, EArtifact.PROBLEM);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();

		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_PROBLEM + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addGetTypeMethod(sc);
		addGetMessageMethod(sc);
		
		sc.add("}");
		out.write(sc.toString());
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + STRING + " message;");
		sc.add("private " + E_PROBLEM_TYPE + " type;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + STRING + " message, " + E_PROBLEM_TYPE + " type) {");
		sc.add("super();");
		sc.add("this.message = message;");
		sc.add("this.type = type;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMessageMethod(StringComposite sc) {
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return message;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTypeMethod(StringComposite sc) {
		sc.add("public " + E_PROBLEM_TYPE + " getType() {");
		sc.add("return type;");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ProblemClassGenerator(context);
	}
}
