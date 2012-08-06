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

import org.antlr.runtime.RecognitionException;

/**
 * Exception class to represent invalid content types for parser instances.
 * 
 * @see org.emftext.runtime.util.IOptions.RESOURCE_CONTENT_TYPE
 */
@Deprecated public class UnexpectedContentTypeException extends RecognitionException{
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public UnexpectedContentTypeException(Object contentType){
		this.contentType = contentType;
	}
	
	public Object getContentType(){
		return contentType;
	}
}
