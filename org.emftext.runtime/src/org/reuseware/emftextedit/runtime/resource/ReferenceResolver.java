package org.reuseware.emftextedit.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A proxy resolver tries to resolve a proxy by replacing it with another non-proxy object
 * in the same tree.
 *
 * @author Jendrik Johannes (jj2)
 *
 * TODO mseifert (future): this class should have a type parameter for the resolved types
 */
public interface ReferenceResolver extends Configurable {

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
	public void resolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, ResolveResult result);

	/**
	 * Reverse of the resolve operation: constructs a representing String of the given
	 * object.
	 *
	 * @param proxy The model element.
	 * @param container The object referencing the element.
	 * @param reference The reference that holds the element.
	 * @return The identification string for the proxy
	 */
	public String deResolve(EObject element, EObject container, EReference reference);
}
