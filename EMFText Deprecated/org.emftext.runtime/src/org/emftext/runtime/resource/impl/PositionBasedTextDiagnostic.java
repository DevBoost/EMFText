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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextDiagnostic;

/**
 * An implementation of the ITextDiagnostic interface that attaches
 * a message to a designated part of the text specified using line 
 * and column information.
 */
@Deprecated public class PositionBasedTextDiagnostic implements ITextDiagnostic {

	private final URI uri;

	protected int column;
	protected int line;
	protected int charStart;
	protected int charEnd;
	protected String message;

	protected PositionBasedTextDiagnostic(URI uri, String message,
			int column, int line, int charStart, int charEnd) {
		
		super();
		this.uri = uri;
		this.column = column;
		this.line = line;
		this.charStart = charStart;
		this.charEnd = charEnd;
		this.message = message;
	}

	public int getCharStart() {
		return charStart;
	}

	public int getCharEnd() {
		return charEnd;
	}

	public int getColumn() {
		return column;
	}

	public int getLine() {
		return line;
	}

	public String getLocation() {
		return uri.toString();
	}

	public String getMessage() {
		return message;
	}

	public boolean wasCausedBy(EObject element) {
		return false;
	}
}
