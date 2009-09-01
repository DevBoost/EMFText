package org.emftext.sdk.codegen.regex;

import java.util.List;

import org.emftext.sdk.concretesyntax.TokenDefinition;

public class SorterException extends Exception {

	private static final long serialVersionUID = 7500645730266413189L;
	private List<TokenDefinition> errorTokens;

	public SorterException(String message, List<TokenDefinition> errorTokens) {
		super(message);
		this.errorTokens = errorTokens;
	}

	public SorterException(String message) {
		super(message);
	}

	public SorterException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public List<TokenDefinition> getErrorTokens() {
		return errorTokens;
	}
}
