package org.emftext.sdk.concretesyntax.resource.cs;

// Implementors of this interface can be used to post-process
// parsed text resources. This can be useful to validate or
// modify the model that was instantiated for the text.
public interface ICsResourcePostProcessor {
	
	// Processes the resource after it was parsed.
	//
	// @param resource the resource to validate of modify
	public void process(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource resource);
}
