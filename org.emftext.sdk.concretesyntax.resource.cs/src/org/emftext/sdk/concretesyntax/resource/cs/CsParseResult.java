package org.emftext.sdk.concretesyntax.resource.cs;

public class CsParseResult extends org.emftext.runtime.resource.impl.AbstractParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>> commands = new java.util.ArrayList<org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>>();
	
	public CsParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>> getPostParseCommands() {
		return commands;
	}
	
}
