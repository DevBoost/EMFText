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
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ITextPrinterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("Converts a tree of <code>" + E_OBJECT + "</code>s into a plain text.");
		sc.add("public interface " + getResourceClassName() + " extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Prints the given <code>" + E_OBJECT + "</code> and its content to the " +
			"underlying output stream that was passed to this printer upon creation.",
			"@param element The element to print.",
			"@throws " + IO_EXCEPTION + " if printing to the underlying stream or device fails."
		);
		sc.add("public void print(" + E_OBJECT + " element) throws " + IO_EXCEPTION + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
				"Sets the encoding used for printing."
			);
			sc.add("public void setEncoding(String encoding);");
			sc.addLineBreak();
		
		sc.add("}");
	}
}
