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
package org.emftext.sdk.codegen.generators.code_completion;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ExpectedCsStringGenerator extends JavaBaseGenerator {

	private String abstractExpectedElementClassName;

	public ExpectedCsStringGenerator() {
		super();
	}

	private ExpectedCsStringGenerator(GenerationContext context) {
		super(context, EArtifact.EXPECTED_CS_STRING);
		abstractExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.ABSTRACT_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ExpectedCsStringGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A representation for a range in a document where a keyword (i.e.,");
		sc.add("// a static string) is expected.");
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.add("private String value;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(String value) {");
		sc.add("super();");
		sc.add("this.value = value;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getValue() {");
		sc.add("return value;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return \"CsString \\\"\" + value + \"\\\"\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean equals(Object o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return this.value.equals(((" + getResourceClassName() + ") o).value);");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		return true;
	}
}
