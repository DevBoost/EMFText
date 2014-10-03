/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;

import java.util.Map;

/**
 * Implementors of this interface can provide options that are used when resources
 * are loaded.
 */
public interface ICct5OptionProvider {
	
	/**
	 * Returns a map of options. The keys are the names of the options, the values are
	 * arbitrary objects that provide additional information or logic for the option.
	 */
	public Map<?,?> getOptions();
	
}
