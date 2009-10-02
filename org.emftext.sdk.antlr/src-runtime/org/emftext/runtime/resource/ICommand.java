package org.emftext.runtime.resource;

/**
 * A simple interface for commands that can be executed
 * and that return information about the success of their
 * execution.
 */
public interface ICommand<ContextType> {

	public boolean execute(ContextType context);
}
