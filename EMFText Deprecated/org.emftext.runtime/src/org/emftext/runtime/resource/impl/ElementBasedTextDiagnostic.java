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
@Deprecated public class ElementBasedTextDiagnostic implements ITextDiagnostic {

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
