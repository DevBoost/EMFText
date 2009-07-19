package org.emftext.test.grammar_features.resource.grammar_features;

public class Grammar_featuresScannerlessScanner extends org.emftext.runtime.resource.impl.AbstractEMFTextLexer {
	
	private java.util.List<org.emftext.runtime.resource.ITextToken> tokens;
	
	public org.emftext.runtime.resource.ITextToken getNextToken() {
		if (tokens == null || tokens.isEmpty()) {
			return null;
		} else {
			return tokens.remove(0);
		}
	}
	public void setText(java.lang.String text) {
		Grammar_featuresScannerlessParser parser = new Grammar_featuresScannerlessParser(new java.io.ByteArrayInputStream(text.getBytes()), null);
		parser.setScanMode();
		parser.parse();
		tokens = parser.getTokens();
	}
}
