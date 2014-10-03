/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class Cct5BracketInformationProvider {
	
	public Collection<org.emftext.test.cct5.resource.cct5.ICct5BracketPair> getBracketPairs() {
		Collection<org.emftext.test.cct5.resource.cct5.ICct5BracketPair> result = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5BracketPair>();
		result.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5BracketPair("{", "}", true, true));
		result.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5BracketPair("\"", "\"", false, false));
		return result;
	}
	
}
