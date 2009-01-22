package org.emftext.runtime.resource;

/**
 * A mapping from an identifier to something else. The
 * &quot;something else&quot; is defined by subclasses 
 * of this interface. Implementors of such subclasses
 * are used during the process of resolving references,
 * where identifiers need to be mapped to other object.
 */
public interface IReferenceMapping {
	
	/**
	 * Returns the identifier that is mapped.
	 */
	public String getIdentifier();
	
	/**
	 * TODO jjohannes: what was this used for again? 
	 */
	public String getWarning();
}
