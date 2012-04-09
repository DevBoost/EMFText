/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk;

import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;

/**
 * The AntlrTokenDerivator is used to derive implicit ANTLR Tokens for
 * quoted placeholders.
 * 
 * @author Christian Wende
 */
public class AntlrTokenDerivator {

	/**
	 * The name prefix of derived token definitions. 
	 * The full name later is constructed by DERIVED_TOKEN_NAME+_+PREFIXCODE+_+SUFFIXCODE.
	 */
	public static final String DERIVED_TOKEN_NAME= "QUOTED";
	
	/**
	 * Used to escape prefix/suffix strings (surrounded by "'" in ANTLR).
	 */
	private String escapeLiteralChars(String candidate) {
		StringBuffer escaped = new StringBuffer();
		char[] chars = candidate.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			escaped.append(escapeLiteralChar(chars[i]));
		}

		return escaped.toString();
	}

	private String escapeLiteralChar(char candidate) {
		String result = "";
		switch (candidate) {
		case '\'':
		case '\\':
			result += "\\";
		default:
			result += candidate;
		}
		return result;
	}

	/**
     * <p>Derives a TokenDefinition from the given prefix and suffix char. If the suffix is valued -1,
     * a standard Definition using the static values STD_TOKEN_NAME and STD_TOKEN_DEF will be created and registered 
     * (if not yet been done) and returned. If additionally a prefix is given, the tokens name will be the conjunction
     * of the value STD_TOKEN_NAME, "_", "prefix", "_". The resulting regular expression is constructed by prepending
     * the prefix to the value STD_TOKEN_DEF.  </p>
     * <p>
     * If suffix is given a TokenDefinition, matching the given prefix (if there) first and than matching all characters,
     * excepting the suffix, is created and returned. The name of this definition is the conjunction of the value 
     * in DERIVED_TOKEN_NAME, "_", prefix, "_" and suffix. </p>
     * 
     * @param placeholder the Placeholder to derive an expression for
     * @return
     */
	public String deriveTokenExpression(PlaceholderInQuotes placeholder) {
		String prefix = placeholder.getNormalizedPrefix();
		String suffix = placeholder.getNormalizedSuffix();
		String escapeCharacter = placeholder.getNormalizedEscapeCharacter();

		boolean prefixIsSet = prefix != null && prefix.length() > 0;
		boolean suffixIsSet = suffix != null && suffix.length() > 0;
		
		assert prefixIsSet;
		assert suffixIsSet;

		String escapedSuffix = escapeLiteralChars(suffix);
		String escapedPrefix = escapeLiteralChars(prefix);
		
		String derivedExpression = "('" + escapedPrefix + "')";
		if (escapeCharacter != null) {
			String escapedEscapeCharacter = escapeLiteralChars(escapeCharacter);
			// this derived regular expression with escaping has the following meaning:
			// start with prefix
			//   arbitrary many characters except the suffix and the escape character OR
			//   the suffix prepended by the escape character (escaped suffix) OR
			//   two escape characters (escaped escape character)
			// end with suffix

			String notSuffixNotEscapeCharacter = 
				"~('" + escapedSuffix + "'|'" + escapedEscapeCharacter + "')";

			String escapeCharacterAndSuffix = 
				"('" + escapedEscapeCharacter + "''" + escapedSuffix + "')";
			
			String escapeCharacterTwice = 
				"('" + escapedEscapeCharacter + "''" + escapedEscapeCharacter + "')";

			derivedExpression += "(" + escapeCharacterAndSuffix + "|" + escapeCharacterTwice + "|" + notSuffixNotEscapeCharacter + ")*";
		} else {
			// this derived regular expression without escaping has the following meaning:
			// start with prefix
			//   arbitrary many characters except the suffix
			// end with suffix

			String notSuffix = 
				"~('" + escapedSuffix + "')";

			derivedExpression += "(" + notSuffix + ")*";
		}
		derivedExpression += "('" + escapedSuffix + "')";

		return derivedExpression;
	}
	
    public String deriveTokenName(PlaceholderInQuotes placeholder) {
		String prefix = placeholder.getNormalizedPrefix();
		String suffix = placeholder.getNormalizedSuffix();
		String escapeCharacter = placeholder.getNormalizedEscapeCharacter();

    	boolean suffixIsSet = suffix != null && suffix.length() > 0;
		boolean prefixIsSet = prefix != null && prefix.length() > 0;
		
		assert prefixIsSet;
		assert suffixIsSet;

 		String name = DERIVED_TOKEN_NAME + "_" + deriveCodeSequence(prefix) + "_" + deriveCodeSequence(suffix);
 		if (escapeCharacter != null) {
 			name += "_" + deriveCodeSequence(escapeCharacter);
 		}
		return name;
	}

    private String deriveCodeSequence(String original) {
    	// TODO this conversion is only invertible for characters < 100.
    	// we need some way to have a conversion which is both compatible
    	// with this one, but does also work for characters >= 100. One
    	// solution is to use a hex representation and add the prefix '0x'.
    	// Alternatively, we can add delimiting characters between the 
    	// decimal representation of the characters. The inverse conversion
    	// is needed to show quoted tokens correctly in the syntax highlighting
    	// preference pages
    	char[] chars = original.toCharArray();
    	String result = "";
    	for (int i = 0; i < chars.length; i++) {
    		if (chars[i] < 10) {
    			result += "0";
    		}
    		result += (int) chars[i];
    	}
    	return result;
    }
}
