package org.emftext.sdk.concretesyntax.resource.cs;

// Implementors of this interface can provide a post-processor
// for text resources.
public interface ICsResourcePostProcessorProvider {
	
	// Returns the processor that shall be called after text
	// resource are successfully parsed.
	public org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor getResourcePostProcessor();
}
