package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface ITypedReferenceResolver<ContainerType> {
	
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
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result);

	/**
	 * Reverse of the resolve operation: constructs a representing String of the given
	 * object.
	 *
	 * @param proxy The model element.
	 * @param container The object referencing the element.
	 * @param reference The reference that holds the element.
	 * @return The identification string for the proxy
	 */
	public String deResolve(EObject element, ContainerType container, EReference reference);
}
