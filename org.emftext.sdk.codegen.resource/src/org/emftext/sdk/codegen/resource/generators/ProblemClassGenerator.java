/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class ProblemClassGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
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

	private void addMethods(StringComposite sc) {
		addGetTypeMethod(sc);
		addGetMessageMethod(sc);
		addGetQuickFixMethod(sc);
	}

	private void addFields(StringComposite sc) {
		sc.add("private String message;");
		sc.add("private " + eProblemTypeClassName + " type;");
		sc.add("private " + COLLECTION + "<" + iQuickFixClassName + "> quickFixes;");
		sc.addLineBreak();
	}

	private void addConstructor1(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(String message, " + eProblemTypeClassName + " type) {");
		sc.add("this(message, type, " + COLLECTIONS + ".<" + iQuickFixClassName + ">emptySet());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(String message, " + eProblemTypeClassName + " type, " + iQuickFixClassName + " quickFix) {");
		sc.add("this(message, type, " + COLLECTIONS + ".singleton(quickFix));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor3(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(String message, " + eProblemTypeClassName + " type, " + COLLECTION + "<" + iQuickFixClassName + "> quickFixes) {");
		sc.add("super();");
		sc.add("this.message = message;");
		sc.add("this.type = type;");
		sc.add("this.quickFixes = new " + LINKED_HASH_SET + "<" + iQuickFixClassName + ">();");
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

	private void addGetQuickFixMethod(StringComposite sc) {
		sc.add("public " + COLLECTION + "<" + iQuickFixClassName + "> getQuickFixes() {");
		sc.add("return quickFixes;");
		sc.add("}");
		sc.addLineBreak();
	}
}
