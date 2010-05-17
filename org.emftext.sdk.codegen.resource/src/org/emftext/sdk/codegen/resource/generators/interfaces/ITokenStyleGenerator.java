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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ITokenStyleGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ITokenStyleGenerator());

	private ITokenStyleGenerator() {
		super();
	}

	private ITokenStyleGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.I_TOKEN_STYLE);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ITokenStyleGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A common interface for token styles. Text resources must " +
			"return style information using classes that implement this " +
			"interface."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the color of the token as array of length 3.");
		sc.add("public int[] getColorAsRGB();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed in bold face.");
		sc.add("public boolean isBold();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed in italic face.");
		sc.add("public boolean isItalic();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed in strike through style.");
		sc.add("public boolean isStrikethrough();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed underlined.");
		sc.add("public boolean isUnderline();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
