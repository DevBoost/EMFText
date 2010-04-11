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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IBackgroundParsingListenerGenerator extends JavaBaseGenerator {

	public IBackgroundParsingListenerGenerator() {
		super();
	}

	private IBackgroundParsingListenerGenerator(GenerationContext context) {
		super(context, EArtifact.I_BACKGROUND_PARSING_LISTENER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IBackgroundParsingListenerGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
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
		sc.add("public void parsingCompleted(" + RESOURCE + " resource);");
		sc.add("}");
		return true;
	}
}
