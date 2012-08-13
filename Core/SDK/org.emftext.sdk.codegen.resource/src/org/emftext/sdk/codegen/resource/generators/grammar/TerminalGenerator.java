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
package org.emftext.sdk.codegen.resource.generators.grammar;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class TerminalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetFeatureMethod(sc);
		addGetMandatoryOccurencesAfterMethod(sc);
		addToStringMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final " + E_STRUCTURAL_FEATURE + " feature;");
		sc.add("private final int mandatoryOccurencesAfter;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " feature, " + cardinalityClassName + " cardinality, int mandatoryOccurencesAfter) {"); 
		sc.add("super(cardinality, null);");
		sc.add("this.feature = feature;");
		sc.add("this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetFeatureMethod(JavaComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {"); 
		sc.add("return feature;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetMandatoryOccurencesAfterMethod(JavaComposite sc) {
		sc.add("public int getMandatoryOccurencesAfter() {"); 
		sc.add("return mandatoryOccurencesAfter;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {"); 
		sc.add("return feature.getName() + \"[]\";");
		sc.add("}"); 
		sc.addLineBreak();
	}
}
