package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class EProblemTypeGenerator extends BaseGenerator {

	public EProblemTypeGenerator() {
		super();
	}
	
	public EProblemTypeGenerator(GenerationContext context) {
		super(context, EArtifact.E_PROBLEM_TYPE);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public enum " + getResourceClassName() + " {");
		sc.add("WARNING,ERROR;");
		sc.add("}");

		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new EProblemTypeGenerator(context);
	}

}
