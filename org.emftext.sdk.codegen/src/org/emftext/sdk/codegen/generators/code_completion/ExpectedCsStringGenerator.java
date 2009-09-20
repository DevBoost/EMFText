package org.emftext.sdk.codegen.generators.code_completion;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ExpectedCsStringGenerator extends BaseGenerator {

	private String abstractExpectedElementClassName;

	public ExpectedCsStringGenerator() {
		super();
	}

	private ExpectedCsStringGenerator(GenerationContext context) {
		super(context, EArtifact.EXPECTED_CS_STRING);
		abstractExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.ABSTRACT_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ExpectedCsStringGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A representation for a range in a document where a CsString (e.g.,");
		sc.add("// a keyword) is expected.");
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.add("private String value;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(String value) {");
		sc.add("this(\"0\", value);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(String scopeID, String value) {");
		sc.add("super(scopeID, false);");
		sc.add("this.value = value;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(String scopeID, boolean discardFollowingExpectations, String value) {");
		sc.add("super(scopeID, discardFollowingExpectations);");
		sc.add("this.value = value;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getValue() {");
		sc.add("return value;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return super.toString() + \" CsString \\\"\" + value + \"\\\"\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean equals(Object o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return this.value.equals(((" + getResourceClassName() + ") o).value);");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
