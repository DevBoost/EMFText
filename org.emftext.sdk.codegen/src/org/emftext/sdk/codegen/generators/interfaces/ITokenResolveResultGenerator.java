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

public class ITokenResolveResultGenerator extends JavaBaseGenerator {

	public ITokenResolveResultGenerator() {
		super();
	}

	private ITokenResolveResultGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new ITokenResolveResultGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("Implementations of this interface are used store the result of resolving a token.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the error message that describes what went wrong while resolving a token.");
		sc.add("public String getErrorMessage();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Sets the error message that describes what went wrong while " +
			"resolving a token. If a mapping for the token was already found " +
			"(i.e., setResult() was called before), the call to this method " +
			"is ignored. If setResult() is called afterwards, the error message " + 
			"is also discarded.",
			"@param message the error that prevented resolving the token"
		);
		sc.add("public void setErrorMessage(String message);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Sets the result of resolving a token.",
			"@param resolvedToken the object the token was resolved to"
		);
		sc.add("public void setResolvedToken(Object resolvedToken);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the result of resolving a token or null if it " +
			"could not be resolved correctly.",
			"@return the object the token was resolved to"
		);
		sc.add("public Object getResolvedToken();");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}
