/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public abstract class Cct5DebugElement extends DebugElement {
	
	/**
	 * Constructs a new debug element in the given target.
	 */
	public Cct5DebugElement(IDebugTarget target) {
		super(target);
	}
	
	public String getModelIdentifier() {
		return org.emftext.test.cct5.resource.cct5.mopp.Cct5Plugin.DEBUG_MODEL_ID;
	}
	
	/**
	 * <p>
	 * Returns the breakpoint manager.
	 * </p>
	 * 
	 * @return the breakpoint manager
	 */
	protected IBreakpointManager getBreakpointManager() {
		return DebugPlugin.getDefault().getBreakpointManager();
	}
	
}
