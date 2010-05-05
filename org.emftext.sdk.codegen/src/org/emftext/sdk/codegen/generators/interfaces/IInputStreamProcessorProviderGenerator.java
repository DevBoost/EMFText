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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IInputStreamProcessorProviderGenerator extends JavaBaseGenerator {

	public IInputStreamProcessorProviderGenerator() {
		super();
	}

	private IInputStreamProcessorProviderGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_INPUT_STREAM_PROCESSOR_PROVIDER);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new IInputStreamProcessorProviderGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Implementors of this interface can provide InputStreamProcessors. These " +
			"processors can be used to pre-process input stream before a text resource " +
			"is actually lexed and parsed. This can be for example useful to do an " +
			"encoding conversion."
		);
		// TODO use EMF's load option Resource.OPTION_CIPHER instead
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns a processor for the given input stream.",
			"@param inputStream the actual stream that provides the content of a resource",
			"@return a processor that pre-processes the input stream"
		);
		sc.add("public " + inputStreamProcessorClassName + " getInputStreamProcessor(" + INPUT_STREAM + " inputStream);");
		sc.add("}");
		return true;
	}
}
