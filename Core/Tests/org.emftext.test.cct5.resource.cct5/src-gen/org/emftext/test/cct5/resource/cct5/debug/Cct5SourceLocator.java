/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant;

public class Cct5SourceLocator extends AbstractSourceLookupDirector {
	
	public void initializeParticipants() {
		addParticipants(new ISourceLookupParticipant[]{new org.emftext.test.cct5.resource.cct5.debug.Cct5SourceLookupParticipant()});
	}
	
}
