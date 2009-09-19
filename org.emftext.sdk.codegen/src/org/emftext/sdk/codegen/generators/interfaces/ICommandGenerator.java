package org.emftext.sdk.codegen.generators.interfaces;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ICommandGenerator extends BaseGenerator {

	public ICommandGenerator() {
		super();
	}

	private ICommandGenerator(GenerationContext context) {
		super(context, EArtifact.I_COMMAND);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ICommandGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A simple interface for commands that can be executed");
		sc.add("// and that return information about the success of their");
		sc.add("// execution.");
		
		sc.add("public interface " + getResourceClassName() + "<ContextType> {");
		sc.addLineBreak();
		sc.add("public boolean execute(ContextType context);");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
