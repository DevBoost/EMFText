package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.IElementMapping;

public class ElementMapping extends ReferenceMapping implements IElementMapping {
	
	private final EObject target;
	
	public ElementMapping(String identifier, EObject target, String warning) {
		super(identifier, warning);
		this.target = target;
	}

	public EObject getTargetElement() {
		return target;
	}
}