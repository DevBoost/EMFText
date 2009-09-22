package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

// TODO check usages of this generator - may not set package correctly
public class EmptyClassGenerator implements IGenerator {

	private GenerationContext context;
	private String className;

	public EmptyClassGenerator() {
		super();
	}

	private EmptyClassGenerator(GenerationContext context) {
		super();
		this.context = context;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}

	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + context.getPackageName(EArtifact.PACKAGE_MOPP) + ";");
		sc.addLineBreak();
		
		sc.add("// this empty class was generated to overwrite exiting");
		sc.add("// classes");
		sc.add("public class " + className + " {");
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptySet();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptySet();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new EmptyClassGenerator(context);
	}
}
