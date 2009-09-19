package org.emftext.sdk.codegen.generators.interfaces;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ITokenResolveResultGenerator extends BaseGenerator {

	public ITokenResolveResultGenerator() {
		super();
	}

	private ITokenResolveResultGenerator(GenerationContext context) {
		super(context, EArtifact.I_TOKEN_RESOLVE_RESULT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITokenResolveResultGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Implementations of this interface are used store the result of");
		sc.add("// resolving a token.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Returns the error message that describes what went wrong while");
		sc.add("// resolving a token.");
		sc.add("public String getErrorMessage();");
		sc.addLineBreak();
		
		sc.add("// Sets the error message that describes what went wrong while");
		sc.add("// resolving a token. If a mapping for the token was");
		sc.add("// already found (i.e., setResult() was called before), the");
		sc.add("// call to this method is ignored. If setResult() is called");
		sc.add("// afterwards, the error message is also discarded.");
		sc.add("//");
		sc.add("// @param message the error that prevented resolving the token");
		sc.add("public void setErrorMessage(String message);");
		sc.addLineBreak();
		
		sc.add("// Sets the result of resolving a token.");
		sc.add("//");
		sc.add("// @param resolvedToken");
		sc.add("public void setResolvedToken(Object resolvedToken);");
		sc.addLineBreak();
		
		sc.add("// Returns the result of resolving a token or null if it");
		sc.add("// could not be resolved correctly.");
		sc.add("//");
		sc.add("// @param resolvedToken");
		sc.add("public Object getResolvedToken();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
