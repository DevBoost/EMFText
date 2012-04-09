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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedCsStringGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A representation for a range in a document where a keyword (i.e., a static string) is expected.");
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + keywordClassName + " keyword;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + keywordClassName + " keyword) {");
		sc.add("super(keyword.getMetaclass());");
		sc.add("this.keyword = keyword;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMethods(JavaComposite sc) {
		addGetValueMethod(sc);
		addGetSyntaxElementMethod(sc);
		addGetTokenNameMethod(sc);
		addToStringMethod(sc);
		addEqualsMethod(sc);
		addHashCodeMethod(sc);
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return getValue().equals(((" + getResourceClassName() + ") o).getValue());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHashCodeMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("return getValue().hashCode();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public String toString() {");
		sc.add("return \"CsString \\\"\" + getValue() + \"\\\"\";");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetValueMethod(StringComposite sc) {
		sc.add("public String getValue() {");
		sc.add("return keyword.getValue();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSyntaxElementMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the expected keyword.");
		sc.add("public " + syntaxElementClassName +" getSymtaxElement() {");
		sc.add("return keyword;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(StringComposite sc) {
		sc.add("public " + SET + "<String> getTokenNames() {");
		// TODO using single quotes here is ANTLR specific
		sc.add("return " + COLLECTIONS + ".singleton(\"'\" + getValue() + \"'\");");
		sc.add("}");
		sc.addLineBreak();
	}
}
