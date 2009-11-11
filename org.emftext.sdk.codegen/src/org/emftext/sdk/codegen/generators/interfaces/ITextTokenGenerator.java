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
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ITextTokenGenerator extends JavaBaseGenerator {

	public ITextTokenGenerator() {
		super();
	}

	private ITextTokenGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_TOKEN);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextTokenGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A token that is returned by ITextLexer instances. Each token");
		sc.add("// has a name, a length and is found at a certain offset in a");
		sc.add("// document.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Returns the name of this token.");
		sc.add("public String getName();");
		sc.addLineBreak();
		
		sc.add("// Returns the offset at which the token was found in the document.");
		sc.add("public int getOffset();");
		sc.addLineBreak();
		
		sc.add("// Returns the length of this token.");
		sc.add("public int getLength();");
		sc.addLineBreak();
		
		sc.add("// Returns false if the token is not usable for syntax highlighting.");
		sc.add("public boolean canBeUsedForSyntaxHighlighting();");
		sc.addLineBreak();
		
		sc.add("public String getText();");
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}
}
