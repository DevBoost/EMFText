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
package org.emftext.sdk.codegen.resource.generators;

import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.COLLECTIONS;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class ProblemGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();

		sc.add("public class " + getResourceClassName() + " implements " + iProblemClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
		addConstructor3(sc);
	}

	private void addMethods(JavaComposite sc) {
		addGetTypeMethod(sc);
		addGetSeverityMethod(sc);
		addGetMessageMethod(sc);
		addGetQuickFixMethod(sc);
	}

	private void addFields(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("private String message;");
		sc.add("private " + eProblemTypeClassName + " type;");
		sc.add("private " + eProblemSeverityClassName + " severity;");
		sc.add("private " + COLLECTION(sc) + "<" + iQuickFixClassName + "> quickFixes;");
		sc.addLineBreak();
	}

	private void addConstructor1(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String message, " + eProblemTypeClassName + " type, " + eProblemSeverityClassName + " severity) {");
		sc.add("this(message, type, severity, " + COLLECTIONS(sc) + ".<" + iQuickFixClassName + ">emptySet());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String message, " + eProblemTypeClassName + " type, " + eProblemSeverityClassName + " severity, " + iQuickFixClassName + " quickFix) {");
		sc.add("this(message, type, severity, " + COLLECTIONS(sc) + ".singleton(quickFix));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor3(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String message, " + eProblemTypeClassName + " type, " + eProblemSeverityClassName + " severity, " + COLLECTION(sc) + "<" + iQuickFixClassName + "> quickFixes) {");
		sc.add("super();");
		sc.add("this.message = message;");
		sc.add("this.type = type;");
		sc.add("this.severity = severity;");
		sc.add("this.quickFixes = new " + LINKED_HASH_SET(sc) + "<" + iQuickFixClassName + ">();");
		sc.add("this.quickFixes.addAll(quickFixes);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMessageMethod(StringComposite sc) {
		sc.add("public String getMessage() {");
		sc.add("return message;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTypeMethod(StringComposite sc) {
		sc.add("public " + eProblemTypeClassName + " getType() {");
		sc.add("return type;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSeverityMethod(StringComposite sc) {
		sc.add("public " + eProblemSeverityClassName + " getSeverity() {");
		sc.add("return severity;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + COLLECTION(sc) + "<" + iQuickFixClassName + "> getQuickFixes() {");
		sc.add("return quickFixes;");
		sc.add("}");
		sc.addLineBreak();
	}
}
