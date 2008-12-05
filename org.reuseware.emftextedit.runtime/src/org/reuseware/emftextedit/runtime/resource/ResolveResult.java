package org.reuseware.emftextedit.runtime.resource;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * The result of a single attempt to resolve an identifier. The 
 * result can either be successful (identifier was resolved to one
 * or more objects) or failed (identifier was not resolved). In
 * the case of failure, the result provides an error message.
 */
public interface ResolveResult {
	
	/**
	 * Sets the error message that describes what went wrong while
	 * resolving a reference. If a mapping for the reference was 
	 * already found (i.e., addMapping() was called before), the 
	 * call to this method is ignored. If addMapping() is called
	 * afterwards, the error message is also discarded.
	 * 
	 * @param message the error that prevented resolving the reference
	 */
	public void setErrorMessage(String message);
	
	// TODO mseifert: addWarning
	// warnings have to be added to the resource even if the identifier was resolved
	
	/**
	 * Adds a mapping from the given identifier to the given object.
	 * Adding such a mapping means that the identifier was resolved
	 * to reference the target object.
	 * Previous errors as well as future ones will be discarded. Once
	 * a mapping is found, resolve errors have no meaning any more.
	 */
	public void addMapping(String identifier, EObject target);
	
	/**
	 * Adds a mapping from the given identifier to another identifier.
	 * This is useful for multilevel resolving where internal identifiers
	 * are replace by external ones depending on the context. Usually
	 * the external identifiers are replaced by target object later on.
	 * 
	 * @param identifier
	 * @param newIdentifier
	 */
	public void addMapping(String identifier, String newIdentifier);

	/**
	 * Indicates the type of the result. Depending on the type of
	 * the result different information is available (e.g., the
	 * error message is only set if the resolve operation failed).
	 * 
	 * @return
	 */
	public boolean wasResolved();
	
	/**
	 * Indicates the type of the result. Depending on the type of
	 * the result different information is available (e.g., the
	 * unique mapping is only set if the resolve operation returned
	 * a unique result).
	 * 
	 * @return
	 */
	public boolean wasResolvedUniquely();

	/**
	 * Indicates the type of the result. Depending on the type of
	 * the result different information is available (e.g., the
	 * multiple mappings are only set if the resolve operation returned
	 * multiple result).
	 * 
	 * @return
	 */
	public boolean wasResolvedMultiple();
	
	public String getErrorMessage();
	
	public Collection<ReferenceMapping> getMappings();
}
