/**
 * 
 */
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.LocationMap;

public class ElementBasedTextDiagnosticImpl extends AbstractTextDiagnostic {

	private final LocationMap locationMap;
	private final URI uri;
	private final EObject element;
	private final String message;

	protected ElementBasedTextDiagnosticImpl(LocationMap locationMap,
			URI uri,
			String message, EObject element, TextDiagnosticType type) {
		super(type);
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
}