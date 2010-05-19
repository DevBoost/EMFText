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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class ProblemClassGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();

		sc.add("public class " + getResourceClassName() + " implements " + iProblemClassName + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(StringComposite sc) {
		addGetTypeMethod(sc);
		addGetMessageMethod(sc);
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + STRING + " message;");
		sc.add("private " + eProblemTypeClassName + " type;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + STRING + " message, " + eProblemTypeClassName + " type) {");
		sc.add("super();");
		sc.add("this.message = message;");
		sc.add("this.type = type;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMessageMethod(StringComposite sc) {
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return message;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTypeMethod(StringComposite sc) {
		sc.add("public " + eProblemTypeClassName + " getType() {");
		sc.add("return type;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
