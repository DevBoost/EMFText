package org.emftext.sdk.codegen.composites;

/**
 * A custom StringComposite that can be used to build grammars
 * for ANTLR.
 */
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
