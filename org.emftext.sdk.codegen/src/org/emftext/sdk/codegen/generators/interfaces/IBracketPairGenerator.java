package org.emftext.sdk.codegen.generators.interfaces;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IBracketPairGenerator extends BaseGenerator {

	public IBracketPairGenerator() {
		super();
	}

	private IBracketPairGenerator(GenerationContext context) {
		super(context, EArtifact.I_BRACKET_PAIR);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IBracketPairGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A simple interface to access information about matching");
		sc.add("// brackets.");
		
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Returns the opening bracket.");
		sc.add("//");
		sc.add("// @return");
		
		sc.add("public String getOpeningBracket();");
		sc.addLineBreak();
		
		sc.add("// Returns the closing bracket.");
		sc.add("//");
		sc.add("// @return");
		
		sc.add("public String getClosingBracket();");
		sc.addLineBreak();
		
		sc.add("// Returns whether other bracket pairs shall be");
		sc.add("// automatically closed, when used inside of this");
		sc.add("// bracket pair.");
		sc.add("//");
		sc.add("// @return");
		
		sc.add("public boolean isClosingEnabledInside();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
