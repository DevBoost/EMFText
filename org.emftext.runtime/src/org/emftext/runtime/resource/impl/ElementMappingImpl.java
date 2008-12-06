package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ElementMapping;

public class ElementMappingImpl extends ReferenceMappingImpl implements ElementMapping {
	
	private final EObject target;
	
	public ElementMappingImpl(String identifier, EObject target, String warning) {
		super(identifier, warning);
		this.target = target;
	}

	public EObject getTargetElement() {
		return target;
	}
}