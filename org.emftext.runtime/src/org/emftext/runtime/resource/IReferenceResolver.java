package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A reference resolver tries to resolve a reference to one or many model elements (EObjects).
 * It is called by the proxy resolution mechanism.
 *
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 *
 * TODO mseifert (future): this class should have a type parameter for the resolved types
 */
public interface IReferenceResolver extends IConfigurable {

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
	public String deResolve(EObject element, EObject container, EReference reference);
}
