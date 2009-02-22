package org.emftext.runtime.resource;


/**
 * A mapping from an identifier to an EObject.
 */
public interface IElementMapping<ReferenceType> extends IReferenceMapping<ReferenceType> {

	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
