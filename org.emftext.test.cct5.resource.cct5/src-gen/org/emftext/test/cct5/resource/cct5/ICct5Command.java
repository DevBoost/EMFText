/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface ICct5Command<ContextType> {
	
	public boolean execute(ContextType context);
}
