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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ScannerlessScannerGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ScannerlessScannerGenerator());

	private ScannerlessScannerGenerator() {
		super();
	}

	private ScannerlessScannerGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.SCANNERLESS_SCANNER);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + iTextScannerClassName + " {");
		sc.addLineBreak();
		sc.add("private " + LIST + "<" + iTextTokenClassName + "> tokens;");
		sc.addLineBreak();
		
		sc.add("public " + iTextTokenClassName + " getNextToken() {");
		sc.add("if (tokens == null || tokens.isEmpty()) {");
		sc.add("return null;");
		sc.add("} else {");
		sc.add("return tokens.remove(0);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public void setText(" + STRING + " text) {");
		String scannerlessParserName = getContext().getClassName(TextResourceArtifacts.SCANNERLESS_PARSER);
		sc.add(scannerlessParserName + " parser = new " + scannerlessParserName + "(new " + BYTE_ARRAY_INPUT_STREAM + "(text.getBytes()), null);");
		sc.add("parser.setScanMode();");
		sc.add("parser.parse();");
		sc.add("tokens = parser.getTokens();");
		sc.add("}");

		sc.add("}");
		return true;
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ScannerlessScannerGenerator(parent, context);
	}

}
