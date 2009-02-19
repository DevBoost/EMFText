package org.emftext.sdk.finders;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A basic implementation of the IConcreteSyntaxFinderResult interface.
 */
class ConcreteSyntaxFinderResult implements IConcreteSyntaxFinderResult {

	private ConcreteSyntax concreteSyntax;
	
	public ConcreteSyntaxFinderResult(ConcreteSyntax concreteSyntax) {
		super();
		this.concreteSyntax = concreteSyntax;
	}

	public ConcreteSyntax getConcreteSyntax() {
		return concreteSyntax;
	}
}