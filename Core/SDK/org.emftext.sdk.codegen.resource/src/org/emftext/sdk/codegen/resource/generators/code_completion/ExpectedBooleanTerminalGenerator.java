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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedBooleanTerminalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A representation for a range in a document where a boolean attribute is expected.");
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + booleanTerminalClassName + " booleanTerminal;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + booleanTerminalClassName + " booleanTerminal) {");
		sc.add("super(booleanTerminal.getMetaclass());");
		sc.add("this.booleanTerminal = booleanTerminal;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMethods(JavaComposite sc) {
		addGetBooleanTerminalMethod(sc);
		addGetSyntaxElementMethod(sc);
		addGetFeatureMethod(sc);
		addToStringMethod(sc);
		addEqualsMethod(sc);
		addHashCodeMethod(sc);
		addGetTokenNamesMethod(sc);
	}

	private void addHashCodeMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("return getFeature().hashCode();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return getFeature().equals(((" + getResourceClassName() + ") o).getFeature());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public String toString() {");
		sc.add("return \"EFeature \" + getFeature().getEContainingClass().getName() + \".\" + getFeature().getName();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFeatureMethod(StringComposite sc) {
		sc.add("private " + E_STRUCTURAL_FEATURE + " getFeature() {");
		sc.add("return booleanTerminal.getFeature();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBooleanTerminalMethod(StringComposite sc) {
		sc.add("public " + booleanTerminalClassName + " getBooleanTerminal() {");
		sc.add("return booleanTerminal;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSyntaxElementMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the expected boolean terminal.");
		sc.add("public " + syntaxElementClassName +" getSymtaxElement() {");
		sc.add("return booleanTerminal;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNamesMethod(JavaComposite sc) {
		sc.add("public " + SET + "<String> getTokenNames() {");
		sc.addComment("BooleanTerminals are associated with two or one token(s)");
		sc.add(SET + "<String> tokenNames = new " + LINKED_HASH_SET + "<String>(2);");
		sc.add("String trueLiteral = booleanTerminal.getTrueLiteral();");
		sc.add("if (!\"\".equals(trueLiteral)) {");
		// TODO using single quotes here is ANTLR specific
		sc.add("tokenNames.add(\"'\" + trueLiteral + \"'\");");
		sc.add("}");
		sc.add("String falseLiteral = booleanTerminal.getFalseLiteral();");
		sc.add("if (!\"\".equals(falseLiteral)) {");
		// TODO using single quotes here is ANTLR specific
		sc.add("tokenNames.add(\"'\" + falseLiteral + \"'\");");
		sc.add("}");
		sc.add("return tokenNames;");
		sc.add("}");
		sc.addLineBreak();
	}
}
