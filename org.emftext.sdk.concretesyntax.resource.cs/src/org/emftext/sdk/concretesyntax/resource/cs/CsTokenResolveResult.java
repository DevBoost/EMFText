package org.emftext.sdk.concretesyntax.resource.cs;

// A basic implementation of the ITokenResolveResult interface.
//
public class CsTokenResolveResult implements org.emftext.runtime.resource.ITokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public CsTokenResolveResult() {
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
