/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface ICct5ResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.test.cct5.resource.cct5.ICct5ResourcePostProcessor getResourcePostProcessor();
	
}
