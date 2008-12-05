package org.reuseware.emftextedit.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.runtime.resource.ElementMapping;

public class ElementMappingImpl implements ElementMapping {
	
	private final String identifier;
	private final EObject target;
	
	public ElementMappingImpl(String identifier, EObject target) {
		super();
		this.identifier = identifier;
		this.target = target;
	}

	public String getIdentifier() {
		return identifier;
	}

	public EObject getTargetElement() {
		return target;
	}
}