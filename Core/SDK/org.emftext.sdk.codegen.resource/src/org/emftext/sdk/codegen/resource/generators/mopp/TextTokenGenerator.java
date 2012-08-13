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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class TextTokenGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + iTextTokenClassName + " {");
		sc.addLineBreak();
		
		sc.addFieldGet("name", "String");
		sc.addFieldGet("text", "String");
		sc.addFieldGet("offset", "int");
		sc.addFieldGet("length", "int");
		sc.addFieldGet("line", "int");
		sc.addFieldGet("column", "int");
		
		sc.addFields();
		sc.add("private boolean canBeUsedForSyntaxHighlighting;");
		sc.addLineBreak();
		
		addConstructor(sc);
		sc.addGettersSetters();
		addCanBeUsedForSyntaxHighlightingMethod(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String name, String text, int offset, int length, int line, int column, boolean canBeUsedForSyntaxHighlighting) {");
		sc.add("super();");
		sc.add("this.name = name;");
		sc.add("this.text = text;");
		sc.add("this.offset = offset;");
		sc.add("this.length = length;");
		sc.add("this.line = line;");
		sc.add("this.column = column;");
		sc.add("this.canBeUsedForSyntaxHighlighting = canBeUsedForSyntaxHighlighting;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addCanBeUsedForSyntaxHighlightingMethod(JavaComposite sc) {
		sc.add("public boolean canBeUsedForSyntaxHighlighting() {");
		sc.add("return canBeUsedForSyntaxHighlighting;");
		sc.add("}");
		sc.addLineBreak();
	}
}
