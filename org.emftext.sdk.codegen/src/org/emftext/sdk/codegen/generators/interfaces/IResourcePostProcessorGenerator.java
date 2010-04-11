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

public class IResourcePostProcessorGenerator extends JavaBaseGenerator {

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

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Implementors of this interface can be used to post-process " +
			"parsed text resources. This can be useful to validate or " +
			"modify the model that was instantiated for the text."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Processes the resource after it was parsed. This method is automatically called for registered post processors.",
			"@param resource the resource to validate of modify"
		);
		sc.add("public void process(" + textResourceClassName + " resource);");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}
