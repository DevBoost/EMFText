package org.emftext.sdk.concretesyntax.resource.cs;

// An interface used to access the result of parsing a
// document.
public interface ICsParseResult {
	
	public org.eclipse.emf.ecore.EObject getRoot();
	
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> getPostParseCommands();
}
