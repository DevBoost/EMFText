package org.emftext.runtime.resource.impl;


/**
 * This exception is internally used by generated ANTLR parsers to
 * terminate parsing in parse-to-index mode. It is not intended to
 * be instantiated or catched by clients.
 */
//TODO mseifert: delete this class once the CS syntax is regenerated
public class ReachedCursorIndexException extends RuntimeException {

	private static final long serialVersionUID = 395796587666918437L;

	private IExpectedElement expectedElement;

	public ReachedCursorIndexException(IExpectedElement expectedElement) {
		this.expectedElement = expectedElement;
	}

	public IExpectedElement getExpectedElement() {
		return expectedElement;
	}
}
