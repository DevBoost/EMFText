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

public class TaskItemGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addFieldGet("keyword", "String");
		sc.addFieldGet("message", "String");
		sc.addFieldGet("line", "int");
		sc.addFieldGet("charStart", "int");
		sc.addFieldGet("charEnd", "int");

		sc.addFields();
		addConstructor(sc);
		sc.addGettersSetters();
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String keyword, String message, int line, int charStart, int charEnd) {");
		sc.add("super();");
		sc.add("this.keyword = keyword;");
		sc.add("this.message = message;");
		sc.add("this.line = line;");
		sc.add("this.charStart = charStart;");
		sc.add("this.charEnd = charEnd;");
		sc.add("}");
		sc.addLineBreak();
	}
}
