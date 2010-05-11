/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs;

/**
 * The result of a single attempt to resolve an identifier. The result can either
 * be successful (identifier was resolved to one or more objects) or failed
 * (identifier was not resolved). In the case of failure, the result provides an
 * error message.
 * This interface must not be implemented by clients.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public interface ICsReferenceResolveResult<ReferenceType> {
	
	/**
	 * Returns the error message that describes what went wrong while resolving a
	 * reference.
	 */
	public String getErrorMessage();
	
	/**
	 * Sets the error message that describes what went wrong while resolving a
	 * reference. If a mapping for the reference was already found (i.e., addMapping()
	 * was called before), the call to this method is ignored. If addMapping() is
	 * called afterwards, the error message is also discarded.
	 * 
	 * @param message the error that prevented resolving the reference
	 */
	public void setErrorMessage(java.lang.String message);
	
	/**
	 * Adds a mapping from the given identifier to the given object. Adding such a
	 * mapping means that the identifier was resolved to reference the target object.
	 * Previous errors as well as future ones will be discarded. Once a mapping is
	 * found, resolve errors have no meaning any more.
	 * The target object can be null if the resolution is fuzzy. Otherwise target must
	 * not be null and implementations of this method can throw an
	 * IllegalArgumentException if this rule is violated.
	 * Optionally a warning can be passed to this method if resolving the reference
	 * was successful, but not accurate.
	 */
	public void addMapping(java.lang.String identifier, ReferenceType target, java.lang.String warning);
	
	/**
	 * 
	 * @see addMapping(String, ReferenceType, String)
	 */
	public void addMapping(java.lang.String identifier, ReferenceType target);
	
	/**
	 * Adds a mapping from the given identifier to another identifier. This is useful
	 * for multilevel resolving where internal identifiers are replaced by external
	 * ones depending on the context. Usually the external identifiers are replaced by
	 * target object later on.
	 * Optionally a warning can be passed to this method if resolving reference was
	 * successful, but not accurate.
	 * 
	 * @param identifier
	 * @param newIdentifier
	 */
	public void addMapping(java.lang.String identifier, org.eclipse.emf.common.util.URI newIdentifier, java.lang.String warning);
	
	/**
	 * 
	 * @see addMapping(String, org.eclipse.emf.common.util.URI, String)
	 */
	public void addMapping(java.lang.String identifier, org.eclipse.emf.common.util.URI newIdentifier);
	
	/**
	 * Indicates the type of the result. Depending on the type of the result different
	 * information is available (e.g., the error message is only set if the resolve
	 * operation failed).
	 * 
	 * @return true if the reference was sucessfully resolved
	 */
	public boolean wasResolved();
	
	/**
	 * Indicates the type of the result. Depending on the type of the result different
	 * information is available (e.g., the unique mapping is only set if the resolve
	 * operation returned a unique result).
	 * 
	 * @return true if the reference was resolved to exactly one target object
	 */
	public boolean wasResolvedUniquely();
	
	/**
	 * Indicates the type of the result. Depending on the type of the result different
	 * information is available (e.g., the multiple mappings are only set if the
	 * resolve operation returned multiple result).
	 * 
	 * @return true the reference was resolved to more than one target object
	 */
	public boolean wasResolvedMultiple();
	
	/**
	 * Returns all mappings that were found while resolving an identifier.
	 */
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<ReferenceType>> getMappings();
	
}
