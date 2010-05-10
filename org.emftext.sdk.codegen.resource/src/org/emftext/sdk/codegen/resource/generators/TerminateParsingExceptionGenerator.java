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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RUNTIME_EXCEPTION;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;

public class TerminateParsingExceptionGenerator extends JavaBaseGenerator<Object> {

	public TerminateParsingExceptionGenerator() {
		super();
	}

	private TerminateParsingExceptionGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new TerminateParsingExceptionGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
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
		return true;
	}

	private void addFields(JavaComposite sc) {
		sc.add("private static final long serialVersionUID = 117529647036954724L;");
		sc.addLineBreak();
	}
}
