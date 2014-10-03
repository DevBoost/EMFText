/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;


/**
 * <p>
 * A mapping from an identifier to something else. The &quot;something else&quot;
 * is defined by subclasses of this interface. Implementors of such subclasses are
 * used during the process of resolving references, where identifiers need to be
 * mapped to other objects.
 * </p>
 * <p>
 * This interface must not be implemented by clients.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface ICct5ReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the identifier that is mapped.
	 */
	public String getIdentifier();
	
	/**
	 * A mapping can have a warning attached that contains additional information
	 * (e.g., when the mapping might be wrong under specific conditions). The warning
	 * is meant to be presented to the user together with the mapping result.
	 */
	public String getWarning();
}
