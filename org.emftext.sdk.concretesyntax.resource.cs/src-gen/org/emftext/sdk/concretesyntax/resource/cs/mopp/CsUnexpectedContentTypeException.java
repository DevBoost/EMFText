package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// java.lang.Exception class to represent invalid content types for parser instances.
//
// @see org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.RESOURCE_CONTENT_TYPE
public class CsUnexpectedContentTypeException extends org.antlr.runtime.RecognitionException{
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  CsUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
}
