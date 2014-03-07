/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.generators.util;

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class EClassUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc("A utility class that provides methods to handle EClasses.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addIsSubClassMethod(sc);
		addGetSubClassMethod(sc);
		addNamesAndPackageURIsAreEqualMethod(sc);
		addPackageURIsAreEqualMethod(sc);
		addNamesAreEqualMethod(sc);
		addIsConcreteMethod(sc);
		addIsNotConcreteMethod(sc);
		addHasTypeMethod(sc);
	}

	private void addHasTypeMethod(JavaComposite sc) {
		sc.addJavadoc("Returns true if the given object is an instance of one of the EClasses.");
		sc.add("public boolean isInstance(Object object, " + E_CLASS(sc) + "[] allowedTypes) {");
		sc.add("for (" + E_CLASS(sc) + " allowedType : allowedTypes) {");
		sc.add("if (allowedType.isInstance(object)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsNotConcreteMethod(JavaComposite sc) {
		sc.add("public boolean isNotConcrete(" + E_CLASS(sc) + " eClass) {");
		sc.add("return !isConcrete(eClass);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsConcreteMethod(JavaComposite sc) {
		sc.add("public boolean isConcrete(" + E_CLASS(sc) + " eClass) {");
		sc.add("return !eClass.isAbstract() && !eClass.isInterface();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNamesAreEqualMethod(JavaComposite sc) {
		sc.add("public boolean namesAreEqual(" + E_CLASS(sc) + " classA, " + E_CLASS(sc) + " classB) {");
		sc.add("return classA.getName().equals(classB.getName());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPackageURIsAreEqualMethod(JavaComposite sc) {
		sc.add("public boolean packageURIsAreEqual(" + E_CLASS(sc) + " classA,");
		sc.add(E_CLASS(sc) + " classB) {");
		sc.add("String nsURI_A = classA.getEPackage().getNsURI();");
		sc.add("String nsURI_B = classB.getEPackage().getNsURI();");
		sc.add("if (nsURI_A == null && nsURI_B == null) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("if (nsURI_A != null) {");
		sc.add("return nsURI_A.equals(nsURI_B);");
		sc.add("} else {");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNamesAndPackageURIsAreEqualMethod(JavaComposite sc) {
		sc.add("public boolean namesAndPackageURIsAreEqual(" + E_CLASS(sc) + " classA,");
		sc.add(E_CLASS(sc) + " classB) {");
		sc.add("return namesAreEqual(classA, classB) &&");
		sc.add("packageURIsAreEqual(classA, classB);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSubClassMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns all subclasses of 'superClass' that are contained " +
			"in 'availableClasses'.",
			"@param superClass the superclass",
			"@param availableClasses the set of classes to search in",
			"@return a list of all subclasses of 'superClass'"
		);
		sc.add("public " + LIST(sc) + "<" + E_CLASS(sc) + "> getSubClasses(" + E_CLASS(sc) + " superClass, " + E_CLASS(sc) + "[] availableClasses) {");
		sc.addLineBreak();
		sc.add(LIST(sc) + "<" + E_CLASS(sc) + "> result = new " + ARRAY_LIST(sc) + "<" + E_CLASS(sc) + ">();");
		sc.add("for (" + E_CLASS(sc) + " next : availableClasses) {");
		sc.add("if (isSubClass(next, superClass) &&");
		sc.add("isConcrete(next)) {");
		sc.add("result.add(next);");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSubClassMethod(JavaComposite sc) {
		sc.add("public boolean isSubClass(" + E_CLASS(sc) + " subClassCandidate, " + E_CLASS(sc) + " superClass) {");
		sc.add("for (" + E_CLASS(sc) + " superClassCandidate : subClassCandidate.getEAllSuperTypes()) {");
		sc.addComment(
			"There seem to be multiple instances of meta classes when accessed " +
			"through the generator model. Therefore, we compare by name."
		);
		sc.add("if (namesAndPackageURIsAreEqual(superClassCandidate, superClass)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
