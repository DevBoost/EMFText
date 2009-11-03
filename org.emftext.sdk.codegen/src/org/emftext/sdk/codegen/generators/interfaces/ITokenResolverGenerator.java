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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ITokenResolverGenerator extends BaseGenerator {

	private String iConfigurableClassName;
	private String iTokenResolveResultClassName;

	public ITokenResolverGenerator() {
		super();
	}

	private ITokenResolverGenerator(GenerationContext context) {
		super(context, EArtifact.I_TOKEN_RESOLVER);
		iConfigurableClassName = getContext().getQualifiedClassName(EArtifact.I_CONFIGURABLE);
		iTokenResolveResultClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_RESOLVE_RESULT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITokenResolverGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Basic Interface to directly manipulate parsed tokens and convert them into the attribute type in the meta model.");
		sc.add("// All generated TokenResolvers per default delegate requests to an instance of JavaBasedTokenResolver which performs");
		sc.add("// a standard conversion to Java Types based on the type of the attribute.");
		sc.add("//");
		sc.add("// @see " + getClassNameHelper().getDEFAULT_TOKEN_RESOLVER());
		sc.add("// @see org.emftext.sdk.codegen.TokenResolverGenerator");
		sc.add("//");
		sc.add("public interface " + getResourceClassName() + " extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.add("// Converts a token into an " + OBJECT + " (the value of the attribute).");
		sc.add("//");
		sc.add("// @param lexem the parsed String");
		sc.add("// @param feature the corresponding feature in the meta model");
		sc.add("// @param result the result of resolving the lexem, can be used to add processing errors");
		sc.add("public void resolve(String lexem, " + E_STRUCTURAL_FEATURE + " feature, " + iTokenResolveResultClassName + " result);");
		sc.addLineBreak();
		
		sc.add("// Does the inverse mapping from an " + OBJECT + " (attribute value) to a lexem which can be printed.");
		sc.add("//");
		sc.add("// @param value the " + OBJECT + " to be printed as String");
		sc.add("// @param feature the corresponding feature (attribute)");
		sc.add("// @param container the container of the object");
		sc.add("//");
		sc.add("// @return the String representation or null if a problem occurred");
		sc.add("public String deResolve(" + OBJECT + " value, " + E_STRUCTURAL_FEATURE + " feature, " + E_OBJECT + " container);");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
