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
	WHITESPACE("WS", "(' ' | '\\t' | '\\f')"),

	/**
	 * The line break token definition.
	 */
	LINEBREAK("LB", "('\\r\\n' | '\\r' | '\\n')");

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
