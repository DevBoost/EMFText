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

public class IBracketPairGenerator extends JavaBaseGenerator<Object> {

	public IBracketPairGenerator() {
		super();
	}

	private IBracketPairGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_BRACKET_PAIR);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new IBracketPairGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A simple interface to access information about matching brackets.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the opening bracket.");
		sc.add("public String getOpeningBracket();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the closing bracket.");
		sc.add("public String getClosingBracket();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns whether other bracket pairs shall be " +
			"automatically closed, when used inside of this " +
			"bracket pair."
		);
		sc.add("public boolean isClosingEnabledInside();");
		sc.add("}");
		return true;
	}
}
