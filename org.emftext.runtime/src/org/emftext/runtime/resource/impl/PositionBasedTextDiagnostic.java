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
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextDiagnostic;

/**
 * An implementation of the ITextDiagnostic interface that attaches
 * a message to a designated part of the text specified using line 
 * and column information.
 */
public class PositionBasedTextDiagnostic implements ITextDiagnostic {

	private final URI uri;

	protected int column;
	protected int line;
	protected int charStart;
	protected int charEnd;
	protected String message;

	public PositionBasedTextDiagnostic(URI uri, String message,
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
