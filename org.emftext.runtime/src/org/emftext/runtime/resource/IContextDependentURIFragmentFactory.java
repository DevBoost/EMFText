package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface IContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject> {

	public IContextDependentURIFragment<?> create(
			String identifier, ContainerType container,
			EReference reference, int positionInReference, EObject proxy);
}
