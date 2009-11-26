package org.emftext.sdk.codegen.generators.code_completion;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

// TODO remove unused code
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
		//sc.add("return \" Expected Terminal \\\"\" + terminal + \"\\\"\" + toString(startIncludingHiddenTokens) + \"(\" + toString(startExcludingHiddenTokens) + \")\";");
		sc.add("return terminal.toString();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String toString(int index) {");
		sc.add("if (index == -1) {");
		sc.add("return \"MIN\";");
		sc.add("} else if (index == Integer.MAX_VALUE) {");
		sc.add("return \"*\";");
		sc.add("} else {");
		sc.add("return \"\" + index;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean equals(Object o) {");
		sc.add("return this.terminal.equals(((" + getResourceClassName() + ") o).terminal);");
		sc.add("}");
		sc.add("private int startIncludingHiddenTokens;");
		sc.add("private int startExcludingHiddenTokens;");
		sc.add("private String prefix;");
		sc.add("private boolean discardFollowingExpectations;");
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
		
		sc.add("// Checks whether the cursor index is inside the range of");
		sc.add("// relevant characters, not considering hidden tokens");
		sc.add("// (e.g., whitespace).");
		
		sc.add("public boolean isAt(int cursorIndex) {");
		sc.add("if (startExcludingHiddenTokens <= cursorIndex && true) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isAfter(int cursorIndex) {");
		sc.add("return startIncludingHiddenTokens > cursorIndex;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isUnknown(int cursorIndex) {");
		sc.add("return startIncludingHiddenTokens > cursorIndex && true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean discardFollowingExpectations() {");
		sc.add("return discardFollowingExpectations;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		return true;
	}
}
