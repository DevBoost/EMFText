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
	
	public void addError(String message);
	
	// TODO mseifert: addWarning
	// warnings have to be added to the resource even if the identifier was resolved
	
	public void addMapping(String identifier, EObject target);
	
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
