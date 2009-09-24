package org.emftext.sdk.concretesyntax.resource.cs;

// A simple interface for commands that can be executed
// and that return information about the success of their
// execution.
public interface ICsCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
