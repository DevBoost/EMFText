package org.emftext.sdk.codegen.generators.code_completion;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ExpectedTerminalGenerator extends JavaBaseGenerator {

	private String iExpectedElementClassName;

	public ExpectedTerminalGenerator() {
		super();
	}

	private ExpectedTerminalGenerator(GenerationContext context) {
		super(context, EArtifact.EXPECTED_TERMINAL);
		iExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ExpectedTerminalGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A representation for a range in a document where a keyword (i.e.,");
		sc.add("// a static string) is expected.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.add("private int followSetID;");
		sc.add("private " + iExpectedElementClassName + " terminal;");
		sc.add("private int startIncludingHiddenTokens;");
		sc.add("private int startExcludingHiddenTokens;");
		sc.add("private String prefix;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + iExpectedElementClassName + " terminal, int followSetID) {");
		sc.add("super();");
		sc.add("this.terminal = terminal;");
		sc.add("this.followSetID = followSetID;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getFollowSetID() {");
		sc.add("return followSetID;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + iExpectedElementClassName + " getTerminal() {");
		sc.add("return terminal;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return terminal == null ? \"null\" : terminal.toString();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean equals(Object o) {");
		sc.add("return this.terminal.equals(((" + getResourceClassName() + ") o).terminal);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {");
		sc.add("assert startExcludingHiddenTokens <= startExcludingHiddenTokens;");
		sc.add("assert startIncludingHiddenTokens <= startExcludingHiddenTokens;");
		sc.addLineBreak();
		sc.add("this.startIncludingHiddenTokens = startIncludingHiddenTokens;");
		sc.add("this.startExcludingHiddenTokens = startExcludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getStartIncludingHiddenTokens() {");
		sc.add("return startIncludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getStartExcludingHiddenTokens() {");
		sc.add("return startExcludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getPrefix() {");
		sc.add("return prefix;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setPrefix(String prefix) {");
		sc.add("this.prefix = prefix;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		return true;
	}
}
