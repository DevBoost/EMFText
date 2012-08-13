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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ITextDiagnosticGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"An extended diagnostic that gives access to the exact position of the problem " +
			"in a character stream."
		);
		sc.add("public interface " + getResourceClassName() + " extends " + RESOURCE + ".Diagnostic {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the position of the first character of the problem area.");
		sc.add("public int getCharStart();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the position of the last character of the problem area.");
		sc.add("public int getCharEnd();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the column of the problem area.");
		sc.add("public int getColumn();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the line that contains the problem area.");
		sc.add("public int getLine();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the problem that was found.");
		sc.add("public " + iProblemClassName + " getProblem();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Checks whether the problem was caused by the given element.",
			"@return true if the problem was caused by <code>element</code>"
		);
		sc.add("public boolean wasCausedBy(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
