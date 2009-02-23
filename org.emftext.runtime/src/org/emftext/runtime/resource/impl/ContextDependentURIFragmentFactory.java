package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IContextDependentURIFragmentFactory;
import org.emftext.runtime.resource.IReferenceResolver;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference resolver,
 * the factory returns a matching fragment that used the resolver to resolver proxy
 * objects.
 *
 * @param <ContainerType> the type of the class containing the reference to be resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class ContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements IContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final IReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public ContextDependentURIFragmentFactory(IReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}

	public IContextDependentURIFragment<?> create(
			String identifier,
			ContainerType container, EReference reference, int positionInReference,
			EObject proxy) {

		return new ContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {

			@Override
			public IReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
