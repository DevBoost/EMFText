package org.emftext.sdk;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A basic implementation of the IConcreteSyntaxFinderResult interface.
 */
class ConcreteSyntaxFinderResult implements IConcreteSyntaxFinderResult {

	private ConcreteSyntax concreteSyntax;
	private boolean foundMultiple;
	
	public ConcreteSyntaxFinderResult(
			ConcreteSyntax concreteSyntax, boolean foundMultiple) {
		super();
		this.concreteSyntax = concreteSyntax;
		this.foundMultiple = foundMultiple;
	}

	public boolean foundMultiple() {
		return foundMultiple;
	}

	public ConcreteSyntax getConcreteSyntax() {
		return concreteSyntax;
	}
}