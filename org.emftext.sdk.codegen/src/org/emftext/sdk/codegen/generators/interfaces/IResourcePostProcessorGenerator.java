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

public class IResourcePostProcessorGenerator extends BaseGenerator {

	private String textResourceClassName;

	public IResourcePostProcessorGenerator() {
		super();
	}

	private IResourcePostProcessorGenerator(GenerationContext context) {
		super(context, EArtifact.I_RESOURCE_POST_PROCESSOR);
		textResourceClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IResourcePostProcessorGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Implementors of this interface can be used to post-process");
		sc.add("// parsed text resources. This can be useful to validate or");
		sc.add("// modify the model that was instantiated for the text.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Processes the resource after it was parsed.");
		sc.add("//");
		sc.add("// @param resource the resource to validate of modify");
		sc.add("public void process(" + textResourceClassName + " resource);");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
