package org.emftext.runtime.resource.impl;

import org.antlr.runtime.RecognitionException;

/**
 * Exception class to represent invalid content types for parser instances.
 * 
 * @see org.emftext.runtime.util.IOptions.RESOURCE_CONTENT_TYPE
 */
public class UnexpectedContentTypeException extends RecognitionException{
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public UnexpectedContentTypeException(Object contentType){
		this.contentType = contentType;
	}
	
	public Object getContentType(){
		return contentType;
	}
}
