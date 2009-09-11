package org.emftext.sdk.concretesyntax.resource.cs;

public class CsAntlrScanner extends org.emftext.runtime.resource.impl.AbstractEMFTextScanner {
	
	private java.lang.String[] tokenNames;
	private org.antlr.runtime.Lexer antlrLexer;
	
	public CsAntlrScanner(org.emftext.runtime.resource.ITextResourcePluginMetaInformation metaInformation, org.antlr.runtime.Lexer antlrLexer) {
		this.tokenNames = metaInformation.getTokenNames();
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.runtime.resource.ITextToken getNextToken() {
		final org.antlr.runtime.Token current = antlrLexer.nextToken();
		org.emftext.runtime.resource.ITextToken result = new org.emftext.runtime.resource.ITextToken() {
			
			public java.lang.String getName() {
				return getTokenName(tokenNames, current.getType());
			}
			
			public int getOffset() {
				return ((org.antlr.runtime.CommonToken) current).getStartIndex();
			}
			
			public int getLength() {
				return ((org.antlr.runtime.CommonToken) current).getStopIndex() - ((org.antlr.runtime.CommonToken) current).getStartIndex() + 1;
			}
			
			public boolean canBeUsedForSyntaxHighlighting() {
				int tokenType = current.getType();
				if (tokenType == org.antlr.runtime.Token.EOF) {
					return false;
				}
				if (tokenType == org.antlr.runtime.Token.UP) {
					return false;
				}
				if (tokenType == org.antlr.runtime.Token.DOWN) {
					return false;
				}
				if (tokenType == org.antlr.runtime.Token.EOR_TOKEN_TYPE) {
					return false;
				}
				if (tokenType == org.antlr.runtime.Token.INVALID_TOKEN_TYPE) {
					return false;
				}
				return true;
			}
			public java.lang.String getText() {
				return current.getText();
			}
		};
		return result;
	}
	
	public void setText(java.lang.String text) {
		antlrLexer.setCharStream(new org.antlr.runtime.ANTLRStringStream(text));
	}
	
	public java.lang.String getTokenName(java.lang.String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		java.lang.String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
}
