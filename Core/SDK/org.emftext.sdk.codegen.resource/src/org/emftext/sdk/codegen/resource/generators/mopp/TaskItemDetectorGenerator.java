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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class TaskItemDetectorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"The " + getResourceClassName() + " is used to find task items in " +
			"text documents. The current implementation searches for specific keywords " +
			"to detect task items. The " + getResourceClassName() + " is used " +
			"both by the TaskItemBuilder and the editor."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addConstants(sc);
        addMethods(sc);
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.add("public static String[] TASK_ITEM_KEYWORDS = new String[] {\"TODO\", \"FIXME\", \"XXX\"};");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addFindTaskInTextMethods(sc);
	}

	private void addFindTaskInTextMethods(JavaComposite sc) {
		sc.add("public " + LIST + "<" + taskItemClassName + "> findTaskItems(String text, int line, int charStart) {");
		sc.add(sc.declareArrayList("foundItems", taskItemClassName));
		sc.add("String remainingText = text;");
		sc.add("boolean continueSearch = true;");
		sc.add("int localCharStart = charStart;");
		sc.add("while (remainingText != null && continueSearch) {");
		sc.add("continueSearch = false;");
		sc.add("for (String keyword : TASK_ITEM_KEYWORDS) {");
		sc.add("int index = remainingText.indexOf(keyword);");
		sc.add("if (index >= 0) {");
		sc.add("continueSearch = true;");
		sc.add("String message = remainingText.substring(index);");
		sc.addComment("stop at end of line and check whether the next lines do also contain task items");
		sc.add("int eolIndex = remainingText.indexOf(\"\\n\", index);");
		sc.add("if (eolIndex < 0) {");
		sc.add("eolIndex = remainingText.indexOf(\"\\r\", index);");
		sc.add("}");
		sc.add("if (eolIndex > 0) {");
		sc.add("message = remainingText.substring(index, eolIndex);");
		sc.add("if (message.startsWith(\"\\r\")) {");
		sc.add("message = message.substring(1);");
		sc.add("}");
		sc.add("if (message.startsWith(\"\\n\")) {");
		sc.add("message = message.substring(1);");
		sc.add("}");
		sc.add("message = message.trim();");
		sc.add("remainingText = remainingText.substring(eolIndex);");
		sc.add("} else {");
		sc.add("remainingText = null;");
		sc.add("}");
		sc.addComment(
			"This is a somewhat arbitrary heuristics to remove the end delimiters " +
			"from multi-line comments. Since comments are usually implemented using " +
			"hidden (unused) tokens, there are no token resolvers that could be used " +
			"to strip delimiters. Thus, this is a reasonable default which reflects " +
			"the fact that many languages use Java-style multi-line comments."
		);
		sc.add("if (message.endsWith(\"*/\")) {");
		sc.add("message = message.substring(0, message.length() - 2);");
		sc.add("}");
		sc.add("message = message.trim();");
		sc.addLineBreak();
		sc.add("int offset = index + localCharStart;");
		sc.add("int end = offset + keyword.length();");
		sc.add("int localLine = line + text.substring(0, offset - charStart).split(\"(\\r\\n|\\r|\\n)\").length - 1;");
		sc.add("foundItems.add(new " + taskItemClassName + "(keyword, message, localLine, offset, end));");
		sc.add("localCharStart += eolIndex;");
		sc.addComment("stop looping over the keywords, we've found one");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return foundItems;");
		sc.add("}");
		sc.addLineBreak();
	}
}
