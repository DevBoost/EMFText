/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;


public interface ICct5DebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message);
}
