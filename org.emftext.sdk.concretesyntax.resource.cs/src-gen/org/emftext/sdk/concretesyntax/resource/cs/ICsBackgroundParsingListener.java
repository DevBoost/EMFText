package org.emftext.sdk.concretesyntax.resource.cs;

// A listener interface for classes that need notification
// when a background parsing pass has completed.
public interface ICsBackgroundParsingListener {
	
	// Signals that the given resource has been changed and
	// the background parsing is completed.
	//
	// @param resource the resource that has changed
	public void parsingCompleted(org.eclipse.emf.ecore.resource.Resource resource);
}
