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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ANTLR_STRING_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LEXER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TOKEN;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ANTLRScannerGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ANTLRScannerGenerator());
	
	private ANTLRScannerGenerator() {
		super();
	}
	
	private ANTLRScannerGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.ANTLR_SCANNER);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + iTextScannerClassName + " {");
		sc.addLineBreak();

		sc.add("private " + LEXER + " antlrLexer;");
		sc.addLineBreak();

		sc.add("public " + getResourceClassName() + "(" + LEXER + " antlrLexer) {");
		sc.add("this.antlrLexer = antlrLexer;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public " + iTextTokenClassName + " getNextToken() {");
		sc.add("if (antlrLexer.getCharStream() == null) {");
		sc.add("return null;");
		sc.add("}");
        sc.add("final " + TOKEN + " current = antlrLexer.nextToken();");
		sc.add(iTextTokenClassName + " result = new " + textTokenClassName + "(current);");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setText(" + STRING + " text) {");
		sc.add("antlrLexer.setCharStream(new " + ANTLR_STRING_STREAM + "(text));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		return true;
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object object) {
		return new ANTLRScannerGenerator(parent, context);
	}
}
