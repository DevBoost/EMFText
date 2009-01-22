package org.emftext.sdk;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * IConcreteSyntaxFinder is an interface for finders that can locate concrete
 * syntax definitions.
 */
public interface IConcreteSyntaxFinder {
	
	/**
	 * Searches for a syntax definition with the given URI.
	 * 
	 * @param csURI the URI to look for
	 * @param resource the resource that triggered the search
	 * @return
	 */
	public ConcreteSyntax findConcreteSyntax(String csURI, Resource resource);
}
