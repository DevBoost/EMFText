/**
 * 
 */
package org.reuseware.emftextedit.runtime.resource.impl;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.runtime.resource.TextDiagnostic;

public class ElementBasedTextDiagnosticImpl implements TextDiagnostic {

	private final TextResourceImpl textResource;
	protected EObject element;
	protected String message;

	protected ElementBasedTextDiagnosticImpl(TextResourceImpl textResource,
			String message, EObject element) {
		this.textResource = textResource;
		this.element = element;
		this.message = message;
	}

	public int getCharStart() {
		return getMapValue(textResource.charStartInfo);
	}

	public int getCharEnd() {
		return getMapValue(textResource.charEndInfo);
	}

	public int getColumn() {
		return getMapValue(textResource.columnInfo);
	}

	public int getLine() {
		return getMapValue(textResource.lineInfo);
	}

	public String getLocation() {
		return this.textResource.getURI().toString();
	}

	public String getMessage() {
		return message;
	}

	private int getMapValue(EMap<EObject, Integer> map) {
		if (!map.containsKey(element)) {
			return 0;
		}
		return map.get(element);
	}
}