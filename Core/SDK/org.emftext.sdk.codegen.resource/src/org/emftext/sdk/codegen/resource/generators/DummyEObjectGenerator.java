/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.generators;

import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT_IMPL;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

import de.devboost.codecomposers.java.JavaComposite;

public class DummyEObjectGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"The DummyEObject is used to build a stack of dummy objects when descending " +
			"by tail recursion into left recursive rules. They cache the setting " +
			"information for initializing concrete EObject instances.",
			"When the tail descent is finished this stack is reduced in reverse order. The " +
			"EObjects are created using the setting informations and a containment hierarchy " +
			"is build using the left recursive EStructuralFeature."
		);
		sc.add("public class " + getResourceClassName() + " extends " + E_OBJECT_IMPL(sc) + "  {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addApplyToMethod(sc);
		addGetValueByNameMethod(sc);
		addEClassMethod(sc);
		addESetMethod(sc);
		addToStringMethod(sc);
	}

	private void addToStringMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("String keyValuePairs = recurseFeatureName + \": \";");
		sc.add("for (" + E_STRUCTURAL_FEATURE(sc) + " f : keyValueMap.keySet()) {");
		sc.add("keyValuePairs += f.getName() + \" = \" + keyValueMap.get(f) + \"\\n\";");
		sc.add("}");
		sc.add("return keyValuePairs;");
		sc.add("}");
	}

	private void addESetMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void eSet(" + E_STRUCTURAL_FEATURE(sc) + " structuralFeature, Object a0) {");
		sc.add("this.keyValueMap.put(structuralFeature, a0);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEClassMethod(JavaComposite sc) {
		sc.addJavadoc("proxy method");
		sc.add("public " + E_CLASS(sc) + " eClass() {");
		sc.add("return type;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetValueByNameMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public Object getValueByName(String name) {");
		sc.add("for (" + E_STRUCTURAL_FEATURE(sc) + " f : this.keyValueMap.keySet()) {");
		sc.add("if (f.getName().equals(name)) return this.keyValueMap.get(f);");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addApplyToMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " applyTo(" + E_OBJECT(sc) + " currentTarget) {");
		sc.add(E_STRUCTURAL_FEATURE(sc) + " recurseFeature = currentTarget.eClass().getEStructuralFeature(this.recurseFeatureName);");
		sc.add(E_OBJECT(sc) + " newObject = currentTarget.eClass().getEPackage().getEFactoryInstance().create(type);");
		sc.add("for (" + E_STRUCTURAL_FEATURE(sc) + " f : keyValueMap.keySet()) {");
		sc.add("" + E_STRUCTURAL_FEATURE(sc) + " structuralFeature = newObject.eClass().getEStructuralFeature(f.getName());");
		sc.add("newObject.eSet(structuralFeature, keyValueMap.get(f));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("newObject.eSet(recurseFeature, currentTarget);");
		sc.add("return newObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_CLASS(sc) + " type, String recurseFeatureName) {");
		sc.add("this.recurseFeatureName = recurseFeatureName;");
		sc.add("this.type = type;");
		sc.add("keyValueMap = new " + LINKED_HASH_MAP(sc) + "<" + E_STRUCTURAL_FEATURE(sc) + ", Object>();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("private " + MAP(sc) + "<" + E_STRUCTURAL_FEATURE(sc) + ", Object> keyValueMap;");
		sc.add("private String recurseFeatureName;");
		sc.add("private " + E_CLASS(sc) + " type;");
		sc.addLineBreak();
	}

	
}
