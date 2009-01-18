package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;

/**
 * A reference resolver tries to resolve a reference to one or many model elements (EObjects).
 * It is called by the proxy resolution mechanism.
 *
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 *
 * TODO mseifert (future): this class should have a type parameter for the resolved types
 */
public interface IReferenceResolver<ContainerType extends EObject> extends ITypedReferenceResolver<ContainerType>, IConfigurable {
}
