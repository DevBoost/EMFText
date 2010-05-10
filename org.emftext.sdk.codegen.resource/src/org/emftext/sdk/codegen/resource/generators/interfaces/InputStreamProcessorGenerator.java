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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class InputStreamProcessorGenerator extends JavaBaseGenerator<Object> {

	public InputStreamProcessorGenerator() {
		super();
	}

	private InputStreamProcessorGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.INPUT_STREAM_PROCESSOR);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new InputStreamProcessorGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A InputStreamProcessor can be used like a normal " + INPUT_STREAM + ", " +
			"but provides information about the encoding that is used to " +
			"represent characters as bytes."
		);
		sc.add("public abstract class " + getResourceClassName() + " extends " + INPUT_STREAM + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the encoding of the characters that can be read " +
			"from this InputStreamProcessor. This encoding is passed " +
			"to subsequent streams (e.g., the ANTLRInputStream)."
		);
		sc.add("public abstract String getOutputEncoding();");
		
		sc.add("}");
		
		return true;
	}
}
