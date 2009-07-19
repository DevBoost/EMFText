package org.emftext.runtime.ui;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.ITextToken;
import org.emftext.runtime.resource.impl.AbstractEMFTextLexer;

// TODO generate this class
public class AntlrTextLexer extends AbstractEMFTextLexer {

	private final static AntlrTokenHelper tokenHelper = new AntlrTokenHelper();
    private String[] tokenNames;
	private Lexer antlrLexer;
	
	public AntlrTextLexer(ITextResourcePluginMetaInformation metaInformation, Lexer antlrLexer) {
        this.tokenNames = metaInformation.getTokenNames();
        this.antlrLexer = antlrLexer;
	}
    
	public ITextToken getNextToken() {
		final Token current = antlrLexer.nextToken();
		ITextToken result = new ITextToken() {
			
			public String getName() {
				return tokenHelper.getTokenName(tokenNames, current.getType());
			}
			
			public int getOffset() {
				return ((CommonToken)current).getStartIndex();
			}
			
			public int getLength() {
		        return ((CommonToken)current).getStopIndex() - ((CommonToken)current).getStartIndex() + 1;
			}

			public boolean canBeUsedForSyntaxHighlighting() {
				return tokenHelper.canBeUsedForSyntaxColoring(current);
			}
		};
		return result;
	}

	public void setText(String text) {
       	antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
}
