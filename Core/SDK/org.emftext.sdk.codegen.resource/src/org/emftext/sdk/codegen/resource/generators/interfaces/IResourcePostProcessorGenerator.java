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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IResourcePostProcessorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
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
		
		sc.addJavadoc(
			"This method is called to request the post processor to terminate. " +
			"It is called from a different thread than the one that called process(). " +
			"Terminating post processors is required when text resources are parsed in " +
			"the background. " +
			"Implementing this method is optional."
		);
		sc.add("public void terminate();");
		sc.addLineBreak();
		sc.add("}");
	}
}
