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
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedStructuralFeatureGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A representation for a range in a document where a structural feature (e.g., a reference) is expected.");
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + placeholderClassName + " placeholder;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + placeholderClassName + " placeholder) {");
		sc.add("super(placeholder.getMetaclass());");
		sc.add("this.placeholder = placeholder;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMethods(JavaComposite sc) {
		addGetFeatureMethod(sc);
		addGetSyntaxElementMethod(sc);
		addGetTokenNameMethod(sc);
		addGetTokenNamesMethod(sc);
		addToStringMethod(sc);
		addEqualsMethod(sc);
		addHashCodeMethod(sc);
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return getFeature().equals(((" + getResourceClassName() + ") o).getFeature());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
	}

	private void addHashCodeMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("return getFeature().hashCode();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public String toString() {");
		sc.add("return \"EFeature \" + getFeature().getEContainingClass().getName() + \".\" + getFeature().getName();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNamesMethod(StringComposite sc) {
		sc.add("public " + SET + "<String> getTokenNames() {");
		sc.add("return " + COLLECTIONS + ".singleton(getTokenName());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(StringComposite sc) {
		sc.add("public String getTokenName() {");
		sc.add("return placeholder.getTokenName();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFeatureMethod(StringComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {");
		sc.add("return placeholder.getFeature();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSyntaxElementMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the expected placeholder.");
		sc.add("public " + syntaxElementClassName +" getSymtaxElement() {");
		sc.add("return placeholder;");
		sc.add("}");
		sc.addLineBreak();
	}
}
