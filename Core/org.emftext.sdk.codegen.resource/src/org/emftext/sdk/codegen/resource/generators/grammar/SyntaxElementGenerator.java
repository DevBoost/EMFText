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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class SyntaxElementGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The abstract super class for all elements of a grammar. " + 
			"This class provides methods to traverse the grammar rules."
		);
		sc.add("public abstract class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + getResourceClassName() + "[] children;");
		sc.add("private " + getResourceClassName() + " parent;");
		sc.add("private " + cardinalityClassName + " cardinality;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality, " + getResourceClassName() + "[] children) {");
		sc.add("this.cardinality = cardinality;"); 
		sc.add("this.children = children;"); 
		sc.add("if (this.children != null) {"); 
		sc.add("for (" + getResourceClassName() + " child : this.children) {"); 
		sc.add("child.setParent(this);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addSetParentMethod(sc);
		addGetParentMethod(sc);
		addGetChildrenMethod(sc);
		addGetMetaClassMethod(sc);
		addGetCardinalityMethod(sc);
	}

	private void addGetParentMethod(JavaComposite sc) {
		sc.addJavadoc(
				"Returns the parent of this syntax element. This parent " +
				"is determined by the containment hierarchy in the CS model."
		);
		sc.add("public " + getResourceClassName() + " getParent() {");
		sc.add("return parent;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetParentMethod(JavaComposite sc) {
		sc.addJavadoc("Sets the parent of this syntax element. This method must be invoked at most once.");
		sc.add("public void setParent(" + getResourceClassName() + " parent) {");
		sc.add("assert this.parent == null;");
		sc.add("this.parent = parent;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetChildrenMethod(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "[] getChildren() {");
		sc.add("if (children == null) {");
		sc.add("return new " + getResourceClassName() + "[0];");
		sc.add("}");
		sc.add("return children;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMetaClassMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + " getMetaclass() {");
		sc.add("return parent.getMetaclass();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCardinalityMethod(StringComposite sc) {
		sc.add("public " + cardinalityClassName + " getCardinality() {");
		sc.add("return cardinality;");
		sc.add("}");
		sc.addLineBreak();
	}
}
