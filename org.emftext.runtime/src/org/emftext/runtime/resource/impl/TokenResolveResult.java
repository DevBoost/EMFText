package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.ITokenResolveResult;

/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class TokenResolveResult implements ITokenResolveResult {

	private String errorMessage;
	private Object resolvedToken;

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
}
