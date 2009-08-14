package org.emftext.sdk.codegen.regex;

import java.util.List;

import org.emftext.sdk.concretesyntax.TokenDirective;

public class SorterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7500645730266413189L;
	private List<TokenDirective> errorTokens;

	public SorterException(String message, List<TokenDirective> errorTokens) {
		super(message);
		this.errorTokens = errorTokens;
	}

	public SorterException(String message) {
		super(message);
	}

	public SorterException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public List<TokenDirective> getErrorTokens() {
		return errorTokens;
	}
}
