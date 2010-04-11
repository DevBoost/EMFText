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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ITextPrinterGenerator extends JavaBaseGenerator {

	private String iConfigurableClassName;

	public ITextPrinterGenerator() {
		super();
	}

	private ITextPrinterGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_PRINTER);
		iConfigurableClassName = getContext().getQualifiedClassName(EArtifact.I_CONFIGURABLE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextPrinterGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
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
		
		sc.add("}");
		return true;
	}
}
