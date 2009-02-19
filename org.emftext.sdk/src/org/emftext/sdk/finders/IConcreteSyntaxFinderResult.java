package org.emftext.sdk.finders;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * Implementations of this interface are used to return
 * the result of searching for a concrete syntax definition.
 */
public interface IConcreteSyntaxFinderResult {
	
	/**
	 * Returns the found concrete syntax definition of
	 * null if none was found.
	 */
	public ConcreteSyntax getConcreteSyntax();
}
