/*******************************************************************************
 * Copyright (c) 2006-2011
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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class EProblemTypeGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public enum PROBLEM_TYPES {
		SYNTAX_ERROR, 
		PRINT_PROBLEM, 
		UNRESOLVED_REFERENCE, 
		ANALYSIS_PROBLEM, 
		BUILDER_ERROR, 
		UNKNOWN
	};
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public enum " + getResourceClassName() + " {");
		addEnumConstants(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addEnumConstants(JavaComposite sc) {
		String constants = "";
		for (PROBLEM_TYPES nextType : PROBLEM_TYPES.values()) {
			constants += nextType.name() + ", ";
		}
		sc.add(constants + ";");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetIDMethod(sc);
	}

	private void addGetIDMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the ID that is used for this type of problem when creating " +
			"markers for problems."
		);
		sc.add("public String getID() {");
		sc.add("if (this == " + PROBLEM_TYPES.UNKNOWN.name() + ") {");
		sc.add("return \"\";");
		sc.add("}");
		sc.add("return this.name().toLowerCase();");
		sc.add("}");
		sc.addLineBreak();
	}
}
