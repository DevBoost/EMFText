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
/**
 * 
 */
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextDiagnostic;

/**
 * An implementation of the ITextDiagnostic interface that attaches
 * a message to an EObject.
 */
public class ElementBasedTextDiagnostic implements ITextDiagnostic {

	private final ILocationMap locationMap;
	private final URI uri;
	private final EObject element;
	private final String message;

	protected ElementBasedTextDiagnostic(ILocationMap locationMap,
			URI uri,
			String message, EObject element) {
		super();
		this.uri = uri;
		this.locationMap = locationMap;
		this.element = element;
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
	
	public String getLocation() {
		return uri.toString();
	}

	public int getCharStart() {
		return Math.max(0, locationMap.getCharStart(element));
	}

	public int getCharEnd() {
		return Math.max(0, locationMap.getCharEnd(element));
	}

	public int getColumn() {
		return Math.max(0, locationMap.getColumn(element));
	}

	public int getLine() {
		return Math.max(0, locationMap.getLine(element));
	}
	
	public boolean wasCausedBy(EObject element) {
		return this.element.equals(element);
	}
}
