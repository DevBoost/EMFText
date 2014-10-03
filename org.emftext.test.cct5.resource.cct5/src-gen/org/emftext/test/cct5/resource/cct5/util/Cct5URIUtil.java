/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.util;

import org.eclipse.emf.common.util.URI;

public class Cct5URIUtil {
	
	public boolean isInBinFolder(URI uri) {
		String[] segments = uri.segments();
		for (String segment : segments) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}
	
}
