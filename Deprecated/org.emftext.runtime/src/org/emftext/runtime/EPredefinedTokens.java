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
package org.emftext.runtime;

/**
 * A list of the tokens that are provided by default in all concrete syntax
 * specifications. The list contains both the names of the tokens and their
 * definition (i.e., a regular expression).
 */
public enum EPredefinedTokens {
	
	/**
	 * The standard token type name (used when no user-defined token type is referenced 
	 * and no pre- and suffixes are given).
	 */
	STANDARD("TEXT", "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"),
	
	/**
	 * The whitespace token definition.
	 */
	WHITESPACE("WHITESPACE", "(' ' | '\\t' | '\\f')"),

	/**
	 * The line break token definition.
	 */
	LINEBREAK("LINEBREAK", "('\\r\\n' | '\\r' | '\\n')");

	private String tokenName;
	private String expression;
	
	private EPredefinedTokens(String tokenName, String expression) {
		this.tokenName = tokenName;
		this.expression = expression;
	}

	public String getTokenName() {
		return tokenName;
	}

	public String getExpression() {
		return expression;
	}
}
