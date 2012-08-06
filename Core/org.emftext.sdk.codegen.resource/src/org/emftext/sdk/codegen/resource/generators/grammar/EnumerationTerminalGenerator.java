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
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class EnumerationTerminalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A class to represent an enumeration terminal in the grammar.");
		sc.add("public class " + getResourceClassName() + " extends " + terminalClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + sc.declareLinkedHashMap("mapping", "String", "String"));
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " attribute, String[] literalMappings, " + cardinalityClassName + " cardinality, int mandatoryOccurrencesAfter) {"); 
		sc.add("super(attribute, cardinality, mandatoryOccurrencesAfter);");
		sc.add("assert attribute instanceof " + E_ATTRIBUTE + ";");
		sc.add("assert literalMappings.length % 2 == 0;");
		sc.add("for (int i = 0; i < literalMappings.length; i += 2) {");
		sc.add("String literalName = literalMappings[i];");
		sc.add("String text = literalMappings[i + 1];");
		sc.add("this.mapping.put(literalName, text);");
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetLiteralMappingMethod(sc);
		addGetAttribute(sc);
		addGetText(sc);
	}

	private void addGetLiteralMappingMethod(StringComposite sc) {
		sc.add("public " + MAP + "<String, String> getLiteralMapping() {"); 
		sc.add("return this.mapping;");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetAttribute(StringComposite sc) {
		sc.add("public " + E_ATTRIBUTE + " getAttribute() {"); 
		sc.add("return (" + E_ATTRIBUTE + ") getFeature();");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetText(StringComposite sc) {
		sc.add("public String getText(String literalName) {"); 
		sc.add("return this.mapping.get(literalName);");
		sc.add("}");
		sc.addLineBreak();
	}
}
