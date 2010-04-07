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
package org.emftext.sdk.codegen.generators.code_completion;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ExpectedStructuralFeatureGenerator extends JavaBaseGenerator {

	private String abstractExpectedElementClassName;
	private String placeholderClassName;

	public ExpectedStructuralFeatureGenerator() {
		super();
	}

	private ExpectedStructuralFeatureGenerator(GenerationContext context) {
		super(context, EArtifact.EXPECTED_STRUCTURAL_FEATURE);
		abstractExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.ABSTRACT_EXPECTED_ELEMENT);
		placeholderClassName = getContext().getQualifiedClassName(EArtifact.PLACEHOLDER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ExpectedStructuralFeatureGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A representation for a range in a document where a structural feature (e.g.,");
		sc.add("// a reference) is expected.");
		
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		return true;
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
	
	private void addMethods(StringComposite sc) {
		addGetFeatureMethod(sc);
		addGetTokenNameMethod(sc);
		addToStringMethod(sc);
		addEqualsMethod(sc);
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(" + OBJECT + " o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return getFeature().equals(((" + getResourceClassName() + ") o).getFeature());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public " + STRING + " toString() {");
		sc.add("return \"EFeature \" + getFeature().getEContainingClass().getName() + \".\" + getFeature().getName();");
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
}
