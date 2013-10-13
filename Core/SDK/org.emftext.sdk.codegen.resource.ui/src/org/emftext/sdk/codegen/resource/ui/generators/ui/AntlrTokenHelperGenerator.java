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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

/**
 * This generator is kept for backwards compatibility only. Originally (i.e.,
 * before EMFText 1.4.0), the AntlrTokenHelper class was part of the UI resource
 * plug-in. But, as of version 1.4.1 it has been move to the resource plug-in.
 * To make sure that we override existing generated classes, we use this 
 * generator that creates an empty class.
 */
public class AntlrTokenHelperGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"This class is only generated for backwards compatiblity. " +
			"The original contents of this class have been moved to class " +
			antlrTokenHelperClassName + "."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addComment("This class is intentionally left empty.");
		sc.add("}");
	}
}
