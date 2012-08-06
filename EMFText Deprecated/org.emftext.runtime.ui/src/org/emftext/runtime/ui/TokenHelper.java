/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui;

import org.antlr.runtime.Token;

/**
 * A helper class that decides which tokens can be used for custom
 * syntax highlighting.
 */
@Deprecated public class TokenHelper {

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
