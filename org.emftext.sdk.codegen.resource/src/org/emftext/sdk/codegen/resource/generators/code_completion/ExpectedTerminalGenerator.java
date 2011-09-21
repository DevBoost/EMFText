/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators.code_completion;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedTerminalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A representation for a range in a document where a terminal (i.e., " +
			"a placeholder or a keyword) is expected. " +
			"The range is expressed using two integers denoting the start of the range " +
			"including hidden tokens (e.g., whitespace) and excluding those token " +
			"(i.e., the part of the document containing the relevant characters)."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(StringComposite sc) {
		addGetFollowSetIDMethod(sc);
		addGetTerminalMethod(sc);
		addToStringMethod(sc);
		addEqualsMethod(sc);
		addSetPositionMethod(sc);
		addGetStartIncludingHiddenTokensMethod(sc);
		addGetStartExcludingHiddenTokensMethod(sc);
		addGetPrefixMethod(sc);
		addSetPrefixMethod(sc);
		addGetContainmentTraceMethod(sc);
	}

	private void addSetPrefixMethod(StringComposite sc) {
		sc.add("public void setPrefix(String prefix) {");
		sc.add("this.prefix = prefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPrefixMethod(StringComposite sc) {
		sc.add("public String getPrefix() {");
		sc.add("return prefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStartExcludingHiddenTokensMethod(StringComposite sc) {
		sc.add("public int getStartExcludingHiddenTokens() {");
		sc.add("return startExcludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStartIncludingHiddenTokensMethod(StringComposite sc) {
		sc.add("public int getStartIncludingHiddenTokens() {");
		sc.add("return startIncludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetPositionMethod(StringComposite sc) {
		sc.add("public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {");
		sc.add("assert startExcludingHiddenTokens <= startExcludingHiddenTokens;");
		sc.add("assert startIncludingHiddenTokens <= startExcludingHiddenTokens;");
		sc.add("this.startIncludingHiddenTokens = startIncludingHiddenTokens;");
		sc.add("this.startExcludingHiddenTokens = startExcludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object o) {");
		sc.add("return this.terminal.equals(((" + getResourceClassName() + ") o).terminal);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public String toString() {");
		sc.add("return terminal == null ? \"null\" : terminal.toString() + \" at \" + startIncludingHiddenTokens + \"/\" + startExcludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTerminalMethod(StringComposite sc) {
		sc.add("public " + iExpectedElementClassName + " getTerminal() {");
		sc.add("return terminal;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContainmentTraceMethod(StringComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE + "[] getContainmentTrace() {");
		sc.add("return containmentTrace;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFollowSetIDMethod(StringComposite sc) {
		sc.add("public int getFollowSetID() {");
		sc.add("return followSetID;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iExpectedElementClassName + " terminal, int followSetID, " + E_STRUCTURAL_FEATURE + "... containmentTrace) {");
		sc.add("super();");
		sc.add("this.terminal = terminal;");
		sc.add("this.followSetID = followSetID;");
		sc.add("this.containmentTrace = containmentTrace;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private int followSetID;");
		sc.add("private " + iExpectedElementClassName + " terminal;");
		sc.add("private int startIncludingHiddenTokens;");
		sc.add("private int startExcludingHiddenTokens;");
		sc.add("private String prefix;");
		sc.add("private " + E_STRUCTURAL_FEATURE + "[] containmentTrace;");
		sc.addLineBreak();
	}
}
