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
/**
 *
 */
package org.emftext.language.templateconcepts.interpreter.exceptions;

/**
 * Thrown on user error in template
 * @author Marcel Boehme
 * Comment created on: 14.04.2009
 */
public class TemplateException extends InterpreterException{
	private static final long serialVersionUID = 8746948627637314078L;

	public TemplateException(Exception e) {
		super(e);
	}
	public TemplateException(String message) {
		super(message);
	}
	public TemplateException(String message, Exception e){
		super(message,e);
	}
}
