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

// Implementations of this interface are used store the result of
// resolving a token.
public interface IGeneratorconfigTokenResolveResult {

	// Returns the error message that describes what went wrong while
	// resolving a token.
	public String getErrorMessage();

	// Sets the error message that describes what went wrong while
	// resolving a token. If a mapping for the token was
	// already found (i.e., setResult() was called before), the
	// call to this method is ignored. If setResult() is called
	// afterwards, the error message is also discarded.
	//
	// @param message the error that prevented resolving the token
	public void setErrorMessage(String message);

	// Sets the result of resolving a token.
	//
	// @param resolvedToken
	public void setResolvedToken(Object resolvedToken);

	// Returns the result of resolving a token or null if it
	// could not be resolved correctly.
	//
	// @param resolvedToken
	public Object getResolvedToken();
}
