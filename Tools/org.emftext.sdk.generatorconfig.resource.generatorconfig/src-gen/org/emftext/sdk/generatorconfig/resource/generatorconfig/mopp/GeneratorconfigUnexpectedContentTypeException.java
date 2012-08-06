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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

// java.lang.Exception class to represent invalid content types for parser instances.
//
// @see org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigOptions.RESOURCE_CONTENT_TYPE
public class GeneratorconfigUnexpectedContentTypeException extends org.antlr.runtime3_2_0.RecognitionException{

	private static final long serialVersionUID = 4791359811519433999L;

	private Object contentType = null;

	public  GeneratorconfigUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}

	public Object getContentType() {
		return contentType;
	}
}
