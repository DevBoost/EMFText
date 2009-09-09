package org.emftext.sdk.concretesyntax.resource.cs;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ICommand;
import org.emftext.runtime.resource.IParseResult;
import org.emftext.runtime.resource.ITextResource;

public class CsParseResult implements IParseResult {
	
	private EObject root;
	
	public CsParseResult(EObject root) {
		super();
		this.root = root;
	}

	public Collection<ICommand<ITextResource>> getPostParseCommands() {
		return null;
	}

	public EObject getRoot() {
		return root;
	}
}
