package org.emftext.sdk;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.Import;

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
	public IConcreteSyntaxFinderResult findConcreteSyntax(String csURI, String locationHint,  Import container, ITextResource resource);
}
