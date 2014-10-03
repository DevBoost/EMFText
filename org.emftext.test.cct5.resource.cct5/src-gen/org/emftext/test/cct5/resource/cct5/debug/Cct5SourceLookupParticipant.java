/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;

public class Cct5SourceLookupParticipant extends AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws CoreException {
		if (object instanceof org.emftext.test.cct5.resource.cct5.debug.Cct5StackFrame) {
			org.emftext.test.cct5.resource.cct5.debug.Cct5StackFrame frame = (org.emftext.test.cct5.resource.cct5.debug.Cct5StackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
