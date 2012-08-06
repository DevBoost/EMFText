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
package org.emftext.language.templateconcepts.interpreter.exceptions;

/**
 * @author Marcel Boehme
 * Comment created on: 14.04.2009
 */
public class InterpreterException extends Exception{
	private static final long serialVersionUID = -5115362185634310688L;

	public InterpreterException(String message){
		super(message);
	}
	public InterpreterException(Exception e){
		super(e);
	}
	public InterpreterException(String message, Exception e){
		super(message,e);
	}
}
