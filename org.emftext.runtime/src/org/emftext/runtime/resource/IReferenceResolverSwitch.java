package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;

/**
 * An IReferenceResolverSwitch is a object that holds references to multiple
 * other reference resolvers and delegates requests to the appropriate resolver.
 */
public interface IReferenceResolverSwitch extends ITypedReferenceResolver<EObject, EObject>, IConfigurable {

}
