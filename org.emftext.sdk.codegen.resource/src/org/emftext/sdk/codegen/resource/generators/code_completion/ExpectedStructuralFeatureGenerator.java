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
package org.emftext.sdk.codegen.resource.generators.code_completion;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedStructuralFeatureGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ExpectedStructuralFeatureGenerator());

	private ExpectedStructuralFeatureGenerator() {
		super();
	}

	private ExpectedStructuralFeatureGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ExpectedStructuralFeatureGenerator(parent, context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A representation for a range in a document where a structural feature (e.g., a reference) is expected.");
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
