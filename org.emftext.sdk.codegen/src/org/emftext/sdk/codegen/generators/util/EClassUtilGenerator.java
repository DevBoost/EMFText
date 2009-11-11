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
package org.emftext.sdk.codegen.generators.util;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class EClassUtilGenerator extends JavaBaseGenerator {

	public EClassUtilGenerator() {
		super();
	}

	private EClassUtilGenerator(GenerationContext context) {
		super(context, EArtifact.E_CLASS_UTIL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new EClassUtilGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A utility class that provides methods to handle EClasses.");
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public boolean isSubClass(" + E_CLASS + " subClassCandidate, " + E_CLASS + " superClass) {");
		sc.add("for (" + E_CLASS + " superClassCandidate : subClassCandidate.getEAllSuperTypes()) {");
		sc.add("// There seem to be multiple instances of meta classes when accessed");
		sc.add("// through the generator model. Therefore, we compare by name.");
		sc.add("if (namesAndPackageURIsAreEqual(superClassCandidate, superClass)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Returns all subclasses of 'superClass' that are contained");
		sc.add("// in 'availableClasses'.");
		sc.add("//");
		sc.add("// @param superClass the superclass");
		sc.add("// @param availableClasses the set of classes to search in");
		sc.add("// @return a list of all subclasses of 'superClass'");
		sc.add("public " + LIST + "<" + E_CLASS + "> getSubClasses(" + E_CLASS + " superClass,");
		sc.add(E_CLASS + "[] availableClasses) {");
		sc.addLineBreak();
		sc.add(LIST + "<" + E_CLASS + "> result = new " + ARRAY_LIST + "<" + E_CLASS + ">();");
		sc.add("for (" + E_CLASS + " next : availableClasses) {");
		sc.add("if (isSubClass(next, superClass) &&");
		sc.add("isConcrete(next)) {");
		sc.add("result.add(next);");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean namesAndPackageURIsAreEqual(" + E_CLASS + " classA,");
		sc.add(E_CLASS + " classB) {");
		sc.add("return namesAreEqual(classA, classB) &&");
		sc.add("packageURIsAreEqual(classA, classB);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean packageURIsAreEqual(" + E_CLASS + " classA,");
		sc.add(E_CLASS + " classB) {");
		sc.add("String nsURI_A = classA.getEPackage().getNsURI();");
		sc.add("String nsURI_B = classB.getEPackage().getNsURI();");
		sc.add("return (nsURI_A == null && nsURI_B == null) || nsURI_A.equals(nsURI_B);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean namesAreEqual(" + E_CLASS + " classA, " + E_CLASS + " classB) {");
		sc.add("return classA.getName().equals(classB.getName());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isConcrete(" + E_CLASS + " eClass) {");
		sc.add("return !eClass.isAbstract() && !eClass.isInterface();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isNotConcrete(" + E_CLASS + " eClass) {");
		sc.add("return !isConcrete(eClass);");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
