/*******************************************************************************
 * Copyright (c) 2006-2009 
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
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ExpectedStructuralFeatureGenerator extends JavaBaseGenerator {

	private String abstractExpectedElementClassName;

	public ExpectedStructuralFeatureGenerator() {
		super();
	}

	private ExpectedStructuralFeatureGenerator(GenerationContext context) {
		super(context, EArtifact.EXPECTED_STRUCTURAL_FEATURE);
		abstractExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.ABSTRACT_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ExpectedStructuralFeatureGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A representation for a range in a document where a structural feature (e.g.,");
		sc.add("// a reference) is expected.");
		
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.add("private " + E_STRUCTURAL_FEATURE + " feature;");
		sc.add("private String tokenName;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(int followSetID, " + E_STRUCTURAL_FEATURE + " feature, String tokenName) {");
		sc.add("super(followSetID);");
		sc.add("this.feature = feature;");
		sc.add("this.tokenName = tokenName;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {");
		sc.add("return feature;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getTokenName() {");
		sc.add("return tokenName;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + STRING + " toString() {");
		sc.add("return super.toString() + \" EFeature \" + feature.getEContainingClass().getName() + \".\" + feature.getName();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean equals(" + OBJECT + " o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return this.feature.equals(((" + getResourceClassName() + ") o).feature);");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		return true;
	}
}
