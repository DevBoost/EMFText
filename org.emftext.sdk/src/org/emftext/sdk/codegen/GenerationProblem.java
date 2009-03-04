/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen;

import org.eclipse.emf.ecore.EObject;

/**
 * Eclipse independent Error/Problem representation for EMFText generators.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)  
 */
public class GenerationProblem {
	
	/**
	 * An enumeration of all available severity levels.
	 */
	public static enum Severity {WARNING, ERROR}
	
	private GenerationProblem.Severity severity ; 
	private String message ;
	private Exception exceptionThrown;
	private EObject cause;
	
	public GenerationProblem(String message, EObject cause, GenerationProblem.Severity severity, Exception e){
		this.message = message;
		this.cause = cause;
		this.severity = severity;
		this.exceptionThrown = e;
	}
	
	public GenerationProblem(String message, EObject cause, GenerationProblem.Severity severity){
		this(message, cause, severity, null);
	}
	
	public GenerationProblem(String message, EObject cause){
		this(message, cause, Severity.ERROR);
	}
	
	public GenerationProblem.Severity getSeverity() {
		return severity;
	}

	public String getMessage() {
		return message;
	}

	public Exception getExceptionThrown() {
		return exceptionThrown;
	}
	
	public EObject getCause(){
		return cause;
	}

}
