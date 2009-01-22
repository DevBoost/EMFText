package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;

/**
 * A mapping from an identifier to an EObject.
 */
public interface IElementMapping extends IReferenceMapping {

	/**
	 * Returns the EObject the identifier is mapped to.
	 */
	public EObject getTargetElement();
}
