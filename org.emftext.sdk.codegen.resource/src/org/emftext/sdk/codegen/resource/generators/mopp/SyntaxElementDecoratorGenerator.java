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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

/**
 * A generator for the class SyntaxElementDecorator. Instances of
 * SyntaxElementDecorator can be used to attach information to 
 * elements of syntax rules.
 */
public class SyntaxElementDecoratorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addAddIndexToPrintMethod(sc);
		addGetDecoratedElementMethod(sc);
		addGetChildDecoratatorsMethod(sc);
		addGetNextIndexToPrintMethod(sc);
		addToStringMethod(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("the syntax element to be decorated");
		sc.add("private " + syntaxElementClassName + " decoratedElement;");
		sc.addLineBreak();
		
		sc.addJavadoc("an array of child decorators (one decorator per child of the decorated syntax element");
		sc.add("private " + getResourceClassName() + "[] childDecorators;");
		sc.addLineBreak();
		
		sc.addJavadoc("a list of the indices that must be printed");
		sc.add("private " + LIST + "<Integer> indicesToPrint = new " + ARRAY_LIST + "<Integer>();");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + syntaxElementClassName + " decoratedElement, " + getResourceClassName() + "[] childDecorators) {");
		sc.add("super();"); 
		sc.add("this.decoratedElement = decoratedElement;"); 
		sc.add("this.childDecorators = childDecorators;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}


	private void addGetDecoratedElementMethod(StringComposite sc) {
		sc.add("public " + syntaxElementClassName + " getDecoratedElement() {");
		sc.add("return decoratedElement;"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetChildDecoratatorsMethod(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "[] getChildDecorators() {");
		sc.add("return childDecorators;"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNextIndexToPrintMethod(StringComposite sc) {
		sc.add("public Integer getNextIndexToPrint() {");
		sc.add("if (indicesToPrint.size() == 0) {");
		sc.add("return null;"); 
		sc.add("}");
		sc.add("return indicesToPrint.remove(0);"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddIndexToPrintMethod(StringComposite sc) {
		sc.add("public void addIndexToPrint(Integer index) {");
		sc.add("indicesToPrint.add(index);"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {"); 
		sc.add("return \"\" + getDecoratedElement();");
		sc.add("}"); 
		sc.addLineBreak();
	}
}
