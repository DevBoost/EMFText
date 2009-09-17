package org.emftext.access.resource;

import org.eclipse.emf.ecore.EObject;

/**
 * An interface used to access the result of parsing a
 * document.
 */
public interface IParseResult {

	public EObject getRoot();
}
