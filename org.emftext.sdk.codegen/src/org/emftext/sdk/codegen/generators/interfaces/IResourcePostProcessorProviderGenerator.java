/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IResourcePostProcessorProviderGenerator extends BaseGenerator {

	private String iResourcePostProcessorClassName;

	public IResourcePostProcessorProviderGenerator() {
		super();
	}

	private IResourcePostProcessorProviderGenerator(GenerationContext context) {
		super(context, EArtifact.I_RESOURCE_POST_PROCESSOR_PROVIDER);
		iResourcePostProcessorClassName = getContext().getQualifiedClassName(EArtifact.I_RESOURCE_POST_PROCESSOR);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IResourcePostProcessorProviderGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Implementors of this interface can provide a post-processor");
		sc.add("// for text resources.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Returns the processor that shall be called after text");
		sc.add("// resource are successfully parsed.");
		sc.add("public " + iResourcePostProcessorClassName + " getResourcePostProcessor();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
