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
package org.emftext.sdk.generatorconfig.resource.generatorconfig;

// Basic Interface to directly manipulate parsed tokens and convert them into the attribute type in the meta model.
// All generated TokenResolvers per default delegate requests to an instance of JavaBasedTokenResolver which performs
// a standard conversion to Java Types based on the type of the attribute.
//
// @see org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.GeneratorconfigDefaultTokenResolver
// @see org.emftext.sdk.codegen.TokenResolverGenerator
//
public interface IGeneratorconfigTokenResolver extends org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigConfigurable {

	// Converts a token into an java.lang.Object (the value of the attribute).
	//
	// @param lexem the parsed String
	// @param feature the corresponding feature in the meta model
	// @param result the result of resolving the lexem, can be used to add processing errors
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result);

	// Does the inverse mapping from an java.lang.Object (attribute value) to a lexem which can be printed.
	//
	// @param value the java.lang.Object to be printed as String
	// @param feature the corresponding feature (attribute)
	// @param container the container of the object
	//
	// @return the String representation or null if a problem occurred
	public String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container);
}
