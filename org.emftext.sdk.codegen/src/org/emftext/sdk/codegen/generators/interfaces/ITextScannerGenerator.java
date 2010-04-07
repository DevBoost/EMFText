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
package org.emftext.sdk.codegen.generators.interfaces;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ITextScannerGenerator extends JavaBaseGenerator {

	private String iTextTokenClassName;

	public ITextScannerGenerator() {
		super();
	}

	private ITextScannerGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_SCANNER);
		iTextTokenClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_TOKEN);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextScannerGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A common interface for scanners to be used by EMFText.");
		sc.add("// A scanner is initialized with a text and delivers a");
		sc.add("// sequence of tokens.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Sets the text that must be scanned.");
		sc.add("public void setText(String text);");
		sc.addLineBreak();
		
		sc.add("// Returns the next token found in the text.");
		sc.add("public " + iTextTokenClassName + " getNextToken();");
		sc.add("}");
		return true;
	}
}
