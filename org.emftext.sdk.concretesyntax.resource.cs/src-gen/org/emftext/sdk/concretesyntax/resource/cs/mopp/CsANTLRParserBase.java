package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public abstract class CsANTLRParserBase extends org.antlr.runtime.Parser implements org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser {
	
	public CsANTLRParserBase(org.antlr.runtime.TokenStream input) {
		super(input);
	}
	
	public CsANTLRParserBase(org.antlr.runtime.TokenStream input, org.antlr.runtime.RecognizerSharedState state) {
		super(input, state);
	}
	
}
