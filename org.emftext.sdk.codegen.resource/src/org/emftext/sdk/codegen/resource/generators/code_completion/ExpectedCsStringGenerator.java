/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.generators.code_completion;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedCsStringGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ExpectedCsStringGenerator());

	private ExpectedCsStringGenerator() {
		super();
	}

	private ExpectedCsStringGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.EXPECTED_CS_STRING);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ExpectedCsStringGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A representation for a range in a document where a keyword (i.e., a static string) is expected.");
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + keywordClassName + " keyword;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + keywordClassName + " keyword) {");
		sc.add("super(keyword.getMetaclass());");
		sc.add("this.keyword = keyword;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMethods(StringComposite sc) {
		addGetValueMethod(sc);
		addGetTokenNameMethod(sc);
		addToStringMethod(sc);
		addEqualsMethod(sc);
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object o) {");
		sc.add("if (o instanceof " + getResourceClassName() + ") {");
		sc.add("return getValue().equals(((" + getResourceClassName() + ") o).getValue());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public String toString() {");
		sc.add("return \"CsString \\\"\" + getValue() + \"\\\"\";");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetValueMethod(StringComposite sc) {
		sc.add("public String getValue() {");
		sc.add("return keyword.getValue();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(StringComposite sc) {
		sc.add("public String getTokenName() {");
		sc.add("return \"'\" + getValue() + \"'\";");
		sc.add("}");
		sc.addLineBreak();
	}
}
