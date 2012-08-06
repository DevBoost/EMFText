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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class BooleanTerminalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A class to represent boolean terminals in a grammar.");
		sc.add("public class " + getResourceClassName() + " extends " + terminalClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private String trueLiteral;");
		sc.add("private String falseLiteral;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " attribute, String trueLiteral, String falseLiteral, " + cardinalityClassName + " cardinality, int mandatoryOccurrencesAfter) {"); 
		sc.add("super(attribute, cardinality, mandatoryOccurrencesAfter);");
		sc.add("assert attribute instanceof " + E_ATTRIBUTE + ";");
		sc.add("this.trueLiteral = trueLiteral;");
		sc.add("this.falseLiteral = falseLiteral;");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetTrueLiteral(sc);
		addGetFalseLiteral(sc);
		addGetAttribute(sc);
	}

	private void addGetTrueLiteral(StringComposite sc) {
		sc.add("public String getTrueLiteral() {"); 
		sc.add("return trueLiteral;");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetFalseLiteral(StringComposite sc) {
		sc.add("public String getFalseLiteral() {"); 
		sc.add("return falseLiteral;");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetAttribute(StringComposite sc) {
		sc.add("public " + E_ATTRIBUTE + " getAttribute() {"); 
		sc.add("return (" + E_ATTRIBUTE + ") getFeature();");
		sc.add("}"); 
		sc.addLineBreak();
	}
}
