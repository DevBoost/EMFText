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

public class IProblemGenerator extends JavaBaseGenerator {

	public IProblemGenerator() {
		super();
	}

	private IProblemGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_PROBLEM);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new IProblemGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.add("public String getMessage();");
		sc.add("public " + eProblemTypeClassName + " getType();");
		sc.add("}");
		return true;
	}
}
