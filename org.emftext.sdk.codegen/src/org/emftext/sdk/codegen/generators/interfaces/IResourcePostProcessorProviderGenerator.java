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

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IResourcePostProcessorProviderGenerator extends JavaBaseGenerator<Object> {

	public IResourcePostProcessorProviderGenerator() {
		super();
	}

	private IResourcePostProcessorProviderGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR_PROVIDER);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new IResourcePostProcessorProviderGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("Implementors of this interface can provide a post-processor for text resources.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the processor that shall be called after text resource are successfully parsed.");
		sc.add("public " + iResourcePostProcessorClassName + " getResourcePostProcessor();");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}
