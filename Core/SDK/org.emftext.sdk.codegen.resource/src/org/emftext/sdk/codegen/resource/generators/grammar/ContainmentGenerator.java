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

import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class ContainmentGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + terminalClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final " + E_CLASS(sc) + "[] allowedTypes;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE(sc) + " feature, " + cardinalityClassName + " cardinality, " + E_CLASS(sc) + "[] allowedTypes, int mandatoryOccurencesAfter) {"); 
		sc.add("super(feature, cardinality, mandatoryOccurencesAfter);"); 
		sc.add("this.allowedTypes = allowedTypes;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetAllowedTypesMethod(sc);
		addHasContainmentMethod(sc);
		addToStringMethod(sc);
	}
	
	private void addHasContainmentMethod(JavaComposite sc) {
		sc.add("@Override"); 
		sc.add("public boolean hasContainment(" + E_CLASS(sc) + " metaclass) {"); 
		sc.add("for (" + E_CLASS(sc) + " allowedType : allowedTypes) {"); 
		sc.add("if (allowedType == metaclass) {"); 
		sc.add("return true;"); 
		sc.add("}"); 
		sc.add("}");
		sc.add("return false;"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAllowedTypesMethod(JavaComposite sc) {
		sc.add("public " + E_CLASS(sc) + "[] getAllowedTypes() {"); 
		sc.add("return allowedTypes;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("String typeRestrictions = null;");
		sc.add("if (allowedTypes != null && allowedTypes.length > 0) {"); 
		sc.add("typeRestrictions = " + stringUtilClassName + ".explode(allowedTypes, \", \", new " + iFunction1ClassName + "<String, " + E_CLASS(sc) +">() {");
		sc.add("public String execute(" + E_CLASS(sc) + " eClass) {");
		sc.add("return eClass.getName();");
		sc.add("}");
		sc.add("});");
		sc.add("}"); 
		sc.add("return getFeature().getName() + (typeRestrictions == null ? \"\" : \"[\" + typeRestrictions + \"]\");");
		sc.add("}"); 
		sc.addLineBreak();
	}
}
