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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.RUNTIME_EXCEPTION;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class TerminateParsingExceptionGenerator extends JavaBaseGenerator {

	public TerminateParsingExceptionGenerator() {
		super();
	}

	private TerminateParsingExceptionGenerator(GenerationContext context) {
		super(context, EArtifact.TERMINATE_PARSING_EXCEPTION);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new TerminateParsingExceptionGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// This exception is used to terminate generated parsers. Depending on");
		sc.add("// the state of a stop flag the parser throw this exception to break");
		sc.add("// the control flow and allow users of the parser to stop parsing.");
		sc.add("public class " + getResourceClassName() + " extends " + RUNTIME_EXCEPTION + " {");
		sc.addLineBreak();
		sc.add("private static final long serialVersionUID = 117529647036954724L;");
		sc.addLineBreak();
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
