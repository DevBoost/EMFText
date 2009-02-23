package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IElementMapping;

/**
 * A basic implementation of the IElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class ElementMapping<ReferenceType> extends AbstractReferenceMapping<ReferenceType> implements IElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	
	public ElementMapping(String identifier, ReferenceType target, String warning) {
		super(identifier, warning);
		this.target = target;
	}

	public ReferenceType getTargetElement() {
		return target;
	}
}