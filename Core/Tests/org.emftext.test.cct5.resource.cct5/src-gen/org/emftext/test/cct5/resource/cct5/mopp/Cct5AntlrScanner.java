/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class Cct5AntlrScanner implements org.emftext.test.cct5.resource.cct5.ICct5TextScanner {
	
	private Lexer antlrLexer;
	
	public Cct5AntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.emftext.test.cct5.resource.cct5.ICct5TextToken result = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
