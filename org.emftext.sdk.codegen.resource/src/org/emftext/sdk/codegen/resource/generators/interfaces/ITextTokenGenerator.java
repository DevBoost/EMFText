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

public class ITextTokenGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ITextTokenGenerator());

	private ITextTokenGenerator() {
		super();
	}

	private ITextTokenGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.I_TEXT_TOKEN);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ITextTokenGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A token that is returned by ITextLexer instances. Each token " +
			"has a name, a length and is found at a certain offset in a document."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the name (i.e., the type) of this token.");
		sc.add("public String getName();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the offset at which the token was found in the document.");
		sc.add("public int getOffset();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the length of this token.");
		sc.add("public int getLength();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns false if the token is not usable for syntax highlighting. " +
			"The EOF (End of File) token is an example for such a token."
		);
		sc.add("public boolean canBeUsedForSyntaxHighlighting();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the text of this token");
		sc.add("public String getText();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
