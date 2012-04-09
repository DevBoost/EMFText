/*******************************************************************************
 * Copyright (c) 2006-2012
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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedTerminalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public static final String JAVADOC_MATERIALIZE_METHOD = 
			"This method creates a model that reflects the state that " +
			"would be obtained if this proposal was accepted. This model can " +
			"differ from the current model, because different proposals can " +
			"result in different models. The code that is passed as argument " +
			"is executed once the (changed) model was created. After executing " +
			"the given code, all changes are reverted.";

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

		sc.addFieldGetSet(
			"attachmentCode", "Runnable",
			"Run the attachment code to create a model the reflects the state " +
			"that would be reached if the completion was executed. " +
			"This is required, because different completions can yield " +
			"different models."
		);
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		sc.addGettersSetters();
		
		addGetFollowSetIDMethod(sc);
		addGetTerminalMethod(sc);
		addToStringMethod(sc);
		addEqualsMethod(sc);
		addHashCodeMethod(sc);
		addSetPositionMethod(sc);
		addGetStartIncludingHiddenTokensMethod(sc);
		addGetStartExcludingHiddenTokensMethod(sc);
		addGetPrefixMethod(sc);
		addSetPrefixMethod(sc);
		addGetContainmentTraceMethod(sc);
		addGetContainerMethod(sc);
		addMaterializeMethod(sc);
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
		sc.add("assert this.startExcludingHiddenTokens <= startExcludingHiddenTokens;");
		sc.add("assert this.startIncludingHiddenTokens <= startExcludingHiddenTokens;");
		sc.add("this.startIncludingHiddenTokens = startIncludingHiddenTokens;");
		sc.add("this.startExcludingHiddenTokens = startExcludingHiddenTokens;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object o) {");
		sc.add("if (o == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add(getResourceClassName() + " otherExpectedTerminal = (" + getResourceClassName() + ") o;");
		sc.add("if (this.container == null && otherExpectedTerminal.container != null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("boolean containersBothNull = this.container == null && otherExpectedTerminal.container == null;");
		sc.add("return this.terminal.equals((otherExpectedTerminal).terminal) && (containersBothNull || this.container.equals(otherExpectedTerminal.container));");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addHashCodeMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("final int prime = 31;");
		sc.add("int result = 1;");
		sc.add("result = prime * result + ((container == null) ? 0 : container.hashCode());");
		sc.add("result = prime * result + ((terminal == null) ? 0 : terminal.hashCode());");
		sc.add("return result;");
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
		sc.add("public " + containmentTraceClassName + " getContainmentTrace() {");
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

	private void addGetContainerMethod(StringComposite sc) {
		sc.add("public " + E_OBJECT + " getContainer() {");
		sc.add("return container;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_OBJECT + " container, " + iExpectedElementClassName + " terminal, int followSetID, " + containmentTraceClassName + " containmentTrace) {");
		sc.add("super();");
		sc.add("this.container = container;");
		sc.add("this.terminal = terminal;");
		sc.add("this.followSetID = followSetID;");
		sc.add("this.containmentTrace = containmentTrace;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.addFields();
		
		sc.add("private int followSetID;");
		sc.add("private " + E_OBJECT + " container;");
		sc.add("private " + iExpectedElementClassName + " terminal;");
		sc.add("private int startIncludingHiddenTokens;");
		sc.add("private int startExcludingHiddenTokens;");
		sc.add("private String prefix;");
		sc.add("private " + containmentTraceClassName + " containmentTrace;");
		sc.addLineBreak();
	}

	private void addMaterializeMethod(JavaComposite sc) {
		sc.addJavadoc(JAVADOC_MATERIALIZE_METHOD);
		sc.add("public void materialize(Runnable code) {");
		sc.add(E_OBJECT + " root = " + ECORE_UTIL + ".getRootContainer(getContainer());");
		sc.add("if (root == null) {");
		sc.add("code.run();");
		sc.add("return;");
		sc.add("}");
		sc.add(CHANGE_RECORDER + " recorder = new " + CHANGE_RECORDER + "();");
		sc.add("recorder.beginRecording(" + COLLECTIONS + ".singleton(root));");
		sc.addLineBreak();
		sc.addComment("attach proposal model fragment to main model");
		sc.add("Runnable attachmentCode = getAttachmentCode();");
		sc.add("if (attachmentCode != null) {");
		sc.addComment("Applying attachment code");
		sc.add("attachmentCode.run();");
		sc.add("}");
		sc.addLineBreak();
		sc.add(CHANGE_DESCRIPTION + " changes = recorder.endRecording();");
		sc.add("code.run();");
		sc.addComment("revert changes");
		sc.add("changes.apply();");
		sc.add("}");
		sc.addLineBreak();
	}
}
