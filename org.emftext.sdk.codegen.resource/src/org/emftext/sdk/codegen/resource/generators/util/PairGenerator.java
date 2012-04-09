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
package org.emftext.sdk.codegen.resource.generators.util;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class PairGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A typed pair of objects.",
			"@param <T1> the type of the first (left) object",
			"@param <T2> the type of the second (right) object"
		);
		sc.add("public class " + getResourceClassName() + "<T1, T2> {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		
		sc.add("public T1 getLeft() {");
		sc.add("return left;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public T2 getRight() {");
		sc.add("return right;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("@Override").addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("final int prime = 31;");
		sc.add("int result = 1;");
		sc.add("result = prime * result + ((left == null) ? 0 : left.hashCode());");
		sc.add("result = prime * result + ((right == null) ? 0 : right.hashCode());");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("@Override").addLineBreak();
		sc.add("public boolean equals(Object obj) {");
		sc.add("if (this == obj) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("if (obj == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (getClass() != obj.getClass()) {");
		sc.add("return false;");
		sc.add("}");
		sc.add(getResourceClassName() + "<?,?> other = (" + getResourceClassName() + "<?,?>) obj;");
		sc.add("if (left == null) {");
		sc.add("if (other.left != null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("} else if (!left.equals(other.left)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (right == null) {");
		sc.add("if (other.right != null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("} else if (!right.equals(other.right)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("}");
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(T1 left, T2 right) {");
		sc.add("this.left = left;");
		sc.add("this.right = right;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private T1 left;");
		sc.add("private T2 right;");
		sc.addLineBreak();
	}
}
