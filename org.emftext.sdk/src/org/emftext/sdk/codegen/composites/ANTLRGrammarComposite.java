package org.emftext.sdk.codegen.composites;

public class ANTLRGrammarComposite extends JavaComposite {

	public ANTLRGrammarComposite() {
		super();
		addLineBreaker(":");
		addLineBreaker("]");
		addLineBreaker("(");
		addLineBreaker(")");
		addIndentationStarter(":");
		addIndentationStopper(";");
		addIndentationStarter("(");
		addIndentationStopper(")");
	}
}
