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
package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ScannerlessScannerGenerator extends JavaBaseGenerator<Object> {

	public ScannerlessScannerGenerator() {
		super();
	}

	private ScannerlessScannerGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.SCANNERLESS_SCANNER);
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

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new ScannerlessScannerGenerator(context);
	}

}
