/*******************************************************************************
 * Copyright (c) 2006-2014
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators.code_completion;

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

// FIXME Check which methods are not used
public class FollowSetGroupGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite jc) {
		
		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		
		jc.addJavadoc("This class is used when computing code completion proposals to group a set of expected elements which belong to the same follow set.");
		jc.add("public class " + getResourceClassName() + " {");
		jc.addLineBreak();
		addFields(jc);
		addMethods(jc);
		jc.add("}");
	}

	private void addFields(JavaComposite jc) {
		jc.add("private " + LIST(jc) + "<" + expectedTerminalClassName + "> expectedTerminals = new " + ARRAY_LIST(jc) + "<" + expectedTerminalClassName + ">();");
		jc.addLineBreak();
	}

	private void addMethods(JavaComposite jc) {
		addAddMethod(jc);
		addGetExpectedTerminalsMethod(jc);
		addGetStartExcludingHiddenTokensMethod(jc);
		addGetRuleMethod(jc);
		addHasSameStartExcludingHiddenTokensMethod(jc);
		addHasDifferentRuleMethod(jc);
		addGetContainerMethod(jc);
		addToStringMethod(jc);
	}

	private void addAddMethod(JavaComposite jc) {
		jc.add("public void add(" + expectedTerminalClassName + " expectedTerminal) {");
		jc.add("expectedTerminals.add(expectedTerminal);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetExpectedTerminalsMethod(JavaComposite jc) {
		jc.add("public " + LIST(jc) + "<" + expectedTerminalClassName + "> getExpectedTerminals() {");
		jc.add("return expectedTerminals;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetStartExcludingHiddenTokensMethod(JavaComposite jc) {
		jc.add("public int getStartExcludingHiddenTokens() {");
		jc.add("int lastStart = -1;");
		jc.add("for (" + expectedTerminalClassName + " expectedTerminal : expectedTerminals) {");
		jc.add("int nextStart = expectedTerminal.getStartExcludingHiddenTokens();");
		jc.add("if (lastStart < 0) {");
		jc.add("lastStart = nextStart;");
		jc.add("} else if (lastStart != nextStart) {");
		jc.add("System.err.println(\"Found terminals in same follow set with different start.\");");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return lastStart;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetRuleMethod(JavaComposite jc) {
		jc.add("public " + E_CLASS(jc) + " getRule() {");
		jc.add(E_CLASS(jc) + " lastRule = null;");
		jc.add("for (" + expectedTerminalClassName + " expectedTerminal : expectedTerminals) {");
		jc.add(E_CLASS(jc) + " nextRule = expectedTerminal.getTerminal().getRuleMetaclass();");
		jc.add("if (lastRule == null) {");
		jc.add("lastRule = nextRule;");
		jc.add("} else if (lastRule != nextRule) {");
		jc.add("System.err.println(\"Found terminals in same follow set with different rule.\");");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return lastRule;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addHasSameStartExcludingHiddenTokensMethod(JavaComposite jc) {
		jc.add("public boolean hasSameStartExcludingHiddenTokens(int lastStartExcludingHiddenTokens) {");
		jc.add("if (lastStartExcludingHiddenTokens < 0) {");
		jc.add("return false;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return lastStartExcludingHiddenTokens == getStartExcludingHiddenTokens();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addHasDifferentRuleMethod(JavaComposite jc) {
		jc.add("public boolean hasDifferentRule(" + E_CLASS(jc) + " lastRule) {");
		jc.add("if (lastRule == null) {");
		jc.add("return true;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return lastRule != getRule();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetContainerMethod(JavaComposite jc) {
		jc.add("public " + E_OBJECT(jc) + " getContainer() {");
		jc.add(E_OBJECT(jc) + " lastContainer = null;");
		jc.add("for (" + expectedTerminalClassName + " expectedTerminal : expectedTerminals) {");
		jc.add(E_OBJECT(jc) + " nextContainer = expectedTerminal.getContainer();");
		jc.add("if (lastContainer == null) {");
		jc.add("lastContainer = nextContainer;");
		jc.add("} else if (lastContainer != nextContainer) {");
		jc.add("System.err.println(\"Found terminals in same follow set with different container.\");");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return lastContainer;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite jc) {
		jc.add("@" + jc.getClassName(Override.class));
		jc.add("public String toString() {");
		jc.add("return \"" +  getResourceClassName() + "\" + expectedTerminals;");
		jc.add("}");
		jc.addLineBreak();
	}
}
