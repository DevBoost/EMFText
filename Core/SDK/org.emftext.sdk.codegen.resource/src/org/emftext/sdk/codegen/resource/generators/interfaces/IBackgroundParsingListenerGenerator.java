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

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class IBackgroundParsingListenerGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A listener interface for classes that need notification " +
			"when a background parsing pass has completed.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Signals that the given resource has been changed and " +
			"the background parsing is completed.",
			"@param resource the resource that has changed"
		);
		sc.add("public void parsingCompleted(" + RESOURCE(sc) + " resource);");
		sc.add("}");
	}
}
