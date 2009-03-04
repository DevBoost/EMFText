/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
