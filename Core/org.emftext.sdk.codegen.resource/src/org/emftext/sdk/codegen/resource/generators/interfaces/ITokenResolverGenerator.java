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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ITokenResolverGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A basic interface to convert parsed tokens to the attribute type in the meta model. " +
			"All generated TokenResolvers per default delegate requests to an instance of " + getContext().getClassName(TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER) + " which performs " +
			"a standard conversion based on the EMF type conversion. This includes conversion of registered EDataTypes.",
			"@see " + defaultTokenResolverClassName
		);
		sc.add("public interface " + getResourceClassName() + " extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Converts a token into an Object (the value of the attribute).",
			"@param lexem the text of the parsed token",
			"@param feature the corresponding feature in the meta model",
			"@param result the result of resolving the lexem, can be used to add processing errors"
		);
		sc.add("public void resolve(String lexem, " + E_STRUCTURAL_FEATURE + " feature, " + iTokenResolveResultClassName + " result);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Converts an Object (the value of an attribute) to a string which can be printed. " +
			"This is the inverse of resolving a token with a call to resolve().",
			"@param value the Object to be printed as String",
			"@param feature the corresponding feature (EAttribute)",
			"@param container the container of the object",
			"@return the String representation or null if a problem occurred");
		sc.add("public String deResolve(Object value, " + E_STRUCTURAL_FEATURE + " feature, " + E_OBJECT + " container);");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
