/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.emftext.test.cct5.resource.cct5.default_load_options' with the difference
 * that the options defined in this class are used even if no Eclipse platform is
 * running.
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.Collections;
import java.util.Map;

public class Cct5OptionProvider implements org.emftext.test.cct5.resource.cct5.ICct5OptionProvider {
	
	public Map<?,?> getOptions() {
		// create a map with static option providers here
		return Collections.emptyMap();
	}
	
}
