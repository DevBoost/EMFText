package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsAntlrScanner implements org.emftext.sdk.concretesyntax.resource.cs.ICsTextScanner {
	
	private org.antlr.runtime.Lexer antlrLexer;
	
	public CsAntlrScanner(org.antlr.runtime.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime.Token current = antlrLexer.nextToken();
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken result = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTextToken(current);
		return result;
	}
	
	public void setText(java.lang.String text) {
		antlrLexer.setCharStream(new org.antlr.runtime.ANTLRStringStream(text));
	}
	
}
