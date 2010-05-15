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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ANTLR_PARSER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RECOGNIZER_SHARED_STATE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TOKEN_STREAM;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ANTLRParserBaseGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ANTLRParserBaseGenerator());

	private ANTLRParserBaseGenerator() {
		super();
	}

	private ANTLRParserBaseGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.ANTLR_PARSER_BASE);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public abstract class " + getResourceClassName() + " extends " + ANTLR_PARSER + " implements " + iTextParserClassName + " {");
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
		return true;
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ANTLRParserBaseGenerator(parent, context);
	}
}
