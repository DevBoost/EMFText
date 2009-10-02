package org.emftext.runtime.resource;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * An interface used to access the result of parsing a
 * document.
 */
public interface IParseResult {

	public EObject getRoot();
	
	public Collection<ICommand<ITextResource>> getPostParseCommands();
}
