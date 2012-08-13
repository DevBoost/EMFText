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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RUNTIME_EXCEPTION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class TerminateParsingExceptionGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"This exception is used to terminate generated parsers. Depending on " +
			"the state of a stop flag the parser throws this exception to break " +
			"the control flow and allow users of the parser to stop parsing."
		);
		sc.add("public class " + getResourceClassName() + " extends " + RUNTIME_EXCEPTION + " {");
		sc.addLineBreak();
		addFields(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private static final long serialVersionUID = 117529647036954724L;");
		sc.addLineBreak();
	}
}
