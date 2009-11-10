package org.emftext.sdk.concretesyntax.resource.cs;

// Implementations of this interface are used store the result of
// resolving a token.
public interface ICsTokenResolveResult {
	
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
