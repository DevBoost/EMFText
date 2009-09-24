package org.emftext.sdk.concretesyntax.resource.cs;

// This interface is extended by all other EMFText runtime
// API interfaces for generated components. It provides
// access to the plug-in meta information.
public interface ICsTextResourcePluginPart {
	
	// Returns a meta information object for the language plug-in
	// that contains this part.
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation getMetaInformation();
}
