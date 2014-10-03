/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class Cct5TokenResolveResult implements org.emftext.test.cct5.resource.cct5.ICct5TokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public Cct5TokenResolveResult() {
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
