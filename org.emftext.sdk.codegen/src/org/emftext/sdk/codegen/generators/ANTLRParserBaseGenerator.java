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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ANTLR_PARSER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RECOGNIZER_SHARED_STATE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOKEN_STREAM;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ANTLRParserBaseGenerator extends JavaBaseGenerator {

	public ANTLRParserBaseGenerator() {
		super();
	}

	public ANTLRParserBaseGenerator(GenerationContext context) {
		super(context, EArtifact.ANTLR_PARSER_BASE);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public abstract class " + getResourceClassName() + " extends " + ANTLR_PARSER + " implements " + getClassNameHelper().getI_TEXT_PARSER() + " {");
		sc.addLineBreak();
		
		sc.add("public " + getResourceClassName() + "(" + TOKEN_STREAM +" input) {");
		sc.add("super(input);");
		sc.add("}");
		sc.addLineBreak();
	    
		sc.add("public " + getResourceClassName() + "(" + TOKEN_STREAM +" input, " + RECOGNIZER_SHARED_STATE + " state) {");
		sc.add("super(input, state);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ANTLRParserBaseGenerator(context);
	}
}
