package org.emftext.runtime.ui;

import org.antlr.runtime.Token;

/**
 * A helper class that decides which tokens can be used for custom
 * syntax highlighting.
 */
public class TokenHelper {

	public boolean canBeUsedForSyntaxColoring(Token token) {
		return canBeUsedForSyntaxColoring(token.getType());
	}
	
	public boolean canBeUsedForSyntaxColoring(int tokenType) {
		if (tokenType == Token.EOF) {
			return false;
		}
		if (tokenType == Token.UP) {
			return false;
		}
		if (tokenType == Token.DOWN) {
			return false;
		}
		if (tokenType == Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}

	public String getTokenName(String[] tokenNames, int index) {
        String tokenName = tokenNames[index];
        if (tokenName.startsWith("'")) {
            tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
        }
		return tokenName;
	}
}
