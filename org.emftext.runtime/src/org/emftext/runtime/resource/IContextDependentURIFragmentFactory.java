package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An interface for factories to create instances of IContextDependentURIFragment.
 *
 * @param <ContainerType> the type of the class containing the reference to be resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject> {

	public IContextDependentURIFragment<?> create(
			String identifier, ContainerType container,
			EReference reference, int positionInReference, EObject proxy);
}
