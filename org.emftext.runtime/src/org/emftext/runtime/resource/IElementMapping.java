package org.emftext.runtime.resource;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IElementMapping<ReferenceType> extends IReferenceMapping<ReferenceType> {

	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
