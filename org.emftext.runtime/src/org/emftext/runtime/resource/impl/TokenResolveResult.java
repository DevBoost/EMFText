/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.ITokenResolveResult;

/**
 * A basic implementation of the ITokenResolveResult interface.
 * 
 * @deprecated This class will be removed for release 1.3 of EMFText
 */
public class TokenResolveResult implements ITokenResolveResult {

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
