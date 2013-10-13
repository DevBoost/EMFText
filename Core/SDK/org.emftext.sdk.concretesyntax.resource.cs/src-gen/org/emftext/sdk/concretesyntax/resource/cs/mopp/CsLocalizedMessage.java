/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;


public class CsLocalizedMessage {
	
	public CsLocalizedMessage(String message, int column, int line, int charStart, int charEnd) {
		super();
		this.message = message;
		this.column = column;
		this.line = line;
		this.charStart = charStart;
		this.charEnd = charEnd;
	}
	
	private String message;
	
	private int column;
	
	private int line;
	
	private int charStart;
	
	private int charEnd;
	
	public String getMessage() {
		return message;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCharStart() {
		return charStart;
	}
	
	public int getCharEnd() {
		return charEnd;
	}
	
}
