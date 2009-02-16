package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;

/**
 * A reference resolver tries to resolve a reference to one or many model elements (EObjects).
 * It is called by the EMF proxy resolution mechanism.
 *
 * @param <ContainerType> the type of the container that contains
 * the reference that is resolved by this resolver
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public interface IReferenceResolver<ContainerType extends EObject> extends ITypedReferenceResolver<ContainerType>, IConfigurable {
}
