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
package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.ITokenResolveResult;

/**
 * A basic implementation of the ITokenResolveResult interface.
 */
@Deprecated public class TokenResolveResult implements ITokenResolveResult {

	private String errorMessage;
	private Object resolvedToken;
	
	public TokenResolveResult() {
		super();
		clear();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getResolvedToken() {
		return resolvedToken;
	}

	public void setErrorMessage(String message) {
		errorMessage = message;
	}

	public void setResolvedToken(Object resolvedToken) {
		this.resolvedToken = resolvedToken;
	}
	
	public void clear() {
		errorMessage = "Can't resolve token.";
		resolvedToken = null;
	}
}
