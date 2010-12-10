/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * A helper class that decides which tokens can be used for custom syntax
 * highlighting.
 */
public class CsAntlrTokenHelper {
	
	public boolean canBeUsedForSyntaxColoring(org.antlr.runtime3_3_0.Token token) {
		return canBeUsedForSyntaxColoring(token.getType());
	}
	
	public boolean canBeUsedForSyntaxColoring(int tokenType) {
		if (tokenType == org.antlr.runtime3_3_0.Token.EOF) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_3_0.Token.UP) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_3_0.Token.DOWN) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_3_0.Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_3_0.Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}
	
	public String getTokenName(String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
	
}
