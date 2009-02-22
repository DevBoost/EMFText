package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EReference;

/**
 * A reference resolver that can resolve references that are 
 * contained in objects of a given class.
 *
 * @param <ContainerType> the type of the container that has the references
 * @param <ReferenceType> the type of the reference itself
 */
public interface ITypedReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Attempts to resolve a reference string.
	 *
	 * @param identifier The identifier for the reference.
	 * @param container The object that contains the reference.
	 * @param reference The reference that points to the target of the reference.
	 * @param resolveFuzzy return objects that do not match exactly
	 *
	 * @return an object that contains the result of the resolve operation.
	 */
	public void resolve(String identifier, ContainerType container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceType> result);

	/**
	 * Reverse of the resolve operation: constructs a representing String of the given
	 * object.
	 *
	 * @param element The referenced model element.
	 * @param container The object referencing the element.
	 * @param reference The reference that holds the element.
	 * 
	 * @return The identification string for the reference
	 */
	public String deResolve(ReferenceType element, ContainerType container, EReference reference);
}
