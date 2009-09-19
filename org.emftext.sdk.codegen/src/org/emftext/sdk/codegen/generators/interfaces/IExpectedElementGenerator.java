package org.emftext.sdk.codegen.generators.interfaces;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IExpectedElementGenerator extends BaseGenerator {

	public IExpectedElementGenerator() {
		super();
	}

	private IExpectedElementGenerator(GenerationContext context) {
		super(context, EArtifact.I_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IExpectedElementGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// An element that is expected at a given position in a resource");
		sc.add("// stream.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("// TODO mseifert: figure out whether we really have to expose this interface");
		sc.add("// it does not contain any methods because the implementing classes");
		sc.add("// share no common functionality. They basically share the property");
		sc.add("// to be potentially expected.");
		sc.addLineBreak();
		sc.add("// TODO mseifert: remove this");
		sc.add("public void setPosition(");
		sc.add("int startIncludingHiddenTokens,");
		sc.add("int startExcludingHiddenTokens");
		sc.add("//int endIncludingHiddenTokens,");
		sc.add("//int endExcludingHiddenTokens");
		sc.add(");");
		sc.addLineBreak();
		sc.add("public int getStartExcludingHiddenTokens();");
		sc.add("public int getStartIncludingHiddenTokens();");
		sc.add("//");
		sc.add("public int getEndExcludingHiddenTokens();");
		sc.add("public int getEndIncludingHiddenTokens();");
		sc.add("public boolean isAt(int cursorIndex);");
		sc.add("public boolean isAfter(int cursorIndex);");
		sc.add("public boolean isUnknown(int cursorIndex);");
		
		sc.addLineBreak();
		sc.add("public String getPrefix();");
		sc.addLineBreak();
		sc.add("public void setPrefix(String prefix);");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.add("public String getScopeID();");
		sc.add("public boolean discardFollowingExpectations();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
