package org.emftext.sdk.concretesyntax.resource.cs;

// Implementors of this interface can be configured by a
// map of options (or parameters).
public interface ICsConfigurable {
	
	// Passed the options given by the map to the configurable
	// object.
	public void setOptions(java.util.Map<?,?> options);
}
