package org.emftext.sdk.codegen.generators.code_completion;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class AbstractExpectedElementGenerator extends BaseGenerator {

	private String iExpectedElementClassName;

	public AbstractExpectedElementGenerator() {
		super();
	}

	private AbstractExpectedElementGenerator(GenerationContext context) {
		super(context, EArtifact.ABSTRACT_EXPECTED_ELEMENT);
		iExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new AbstractExpectedElementGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addLineBreak();
		
		sc.add("// Abstract super class for all expected elements. Provides methods to");
		sc.add("// set and retrieve the document range, where the element is expected.");
		sc.add("// This range is expressed using four integers - two denoting the range");
		sc.add("// including hidden tokens (e.g., whitespace) and two denoting the range");
		sc.add("// excluding those token (i.e., the part of the document containing the");
		sc.add("// relevant characters).");
		sc.add("public abstract class " + getResourceClassName() + " implements " + iExpectedElementClassName + " {");
		sc.addLineBreak();
		sc.add("private int startIncludingHiddenTokens;");
		sc.add("private int startExcludingHiddenTokens;");
		sc.add("private String prefix;");
		sc.add("private String scopeID;");
		sc.add("private boolean discardFollowingExpectations;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(String scopeID, boolean discardFollowingExpectations) {");
		sc.add("this.scopeID = scopeID;");
		sc.add("this.discardFollowingExpectations = discardFollowingExpectations;");
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
		sc.add("public String getScopeID() {");
		sc.add("return scopeID;");
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
		sc.add("public String toString() {");
		sc.add("return");
		sc.add("toString(startIncludingHiddenTokens) + \"(\" + toString(startExcludingHiddenTokens) + \")\" +");
		sc.add("\" scope = \" + scopeID + \"\" +");
		sc.add("\" discardFollowing = \" + discardFollowingExpectations;");
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
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
