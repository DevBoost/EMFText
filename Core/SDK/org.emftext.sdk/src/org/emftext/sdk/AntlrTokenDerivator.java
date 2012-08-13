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

	/**
	 * Used to escape a single character to conform the ANTLR syntax for regular
	 * expressions. Single quotes are replaced by a backslash followed by a
	 * single quote. Backslashes are escaped by adding a second backslash.
	 */
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
     * Derives a regular expression from the given prefix and suffix. This 
     * regular expression matches anything that is enclosed by the prefix and
     * the suffix. If an escaped character sequence was specified, the suffix
     * can appear between prefix and suffix if it is prepended by the escaped
     * sequence. The escape sequences itself must then be represented by two
     * occurrences of itself.
     * 
     * @param placeholder the Placeholder to derive an expression for
     * @return a regular expression
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
		
		StringBuilder derivedExpression = new StringBuilder(); 
		
		derivedExpression.append("('");
		derivedExpression.append(escapedPrefix);
		derivedExpression.append("')");
		
		if (escapeCharacter != null) {
			String escapedEscapeCharacter = escapeLiteralChars(escapeCharacter);
			// this derived regular expression with escaping has the following meaning:
			// start with prefix
			//   arbitrary many characters except the suffix and the escape character 
			//   (notSuffixNotEscapeCharacter) OR
			//   the suffix prepended by the escape character (escaped suffix) OR
			//   two escape characters (escaped escape character)
			// end with suffix

			String escapeCharacterAndSuffix = 
				"('" + escapedEscapeCharacter + "''" + escapedSuffix + "')";
			
			String escapeCharacterTwice = 
				"('" + escapedEscapeCharacter + "''" + escapedEscapeCharacter + "')";

			String notSuffixNotEscapeCharacter = 
				"(" + getOrNegation(suffix, escapeCharacter) + ")";

			derivedExpression.append("(" + escapeCharacterAndSuffix + "|" + escapeCharacterTwice + "|" + notSuffixNotEscapeCharacter + ")*");
		} else {
			// this derived regular expression without escaping has the following meaning:
			// start with prefix
			//   arbitrary many characters except the suffix
			// end with suffix
			String notSuffix = getNegation(suffix);
			derivedExpression.append("(" + notSuffix + ")*");
		}
		derivedExpression.append("('" + escapedSuffix + "')");

		return derivedExpression.toString();
	}

	/**
	 * Returns a regular expression that matches anything except text1 and 
	 * text2 (in pseudo regular expression syntax: ~(text1|text2)). Constructing
	 * this expression is quite complex, since the basic composition of the
	 * strings to form a regular expression does only work if both texts contain 
	 * a single character.
	 */
	public String getOrNegation(String text1, String text2) {
		
		int length1 = text1.length();
		int length2 = text2.length();
		
		int commonLength = Math.min(length1, length2);
		int maxLength = Math.max(length1, length2);
		
		StringBuilder negation = new StringBuilder();
		StringBuilder previous = new StringBuilder();
		// first process the characters up to the length of the shorter text
		for (int i = 0; i < commonLength; i++) {
			char char1AtI = text1.charAt(i);
			char char2AtI = text2.charAt(i);
			boolean isLast = (i == maxLength - 1);
			negation.append(previous.toString() + "~('" + escapeLiteralChar(char1AtI) + "'|'" + escapeLiteralChar(char2AtI) + "')");
			if (!isLast) {
				negation.append("|");
			}
			previous.append("('" + escapeLiteralChar(char1AtI) + "'|'" + escapeLiteralChar(char2AtI) + "')");
		}
		
		// the process remaining characters
		negation.append(getRegexToMatchHeadNotTail(text1, commonLength));
		negation.append(getRegexToMatchHeadNotTail(text2, commonLength));
		
		return negation.toString();
	}

	private StringBuilder getRegexToMatchHeadNotTail(String text, int startOfTail) {
		StringBuilder expression = new StringBuilder();

		String head = text.substring(0, startOfTail);
		String tail = text.substring(startOfTail);
		String notTail = getNegation(tail);
		
		String escapedHead = escapeLiteralChars(head);
		if (notTail.length() > 0) {
			if (escapedHead.length() > 0) {
				expression.append("'" + escapedHead + "'");
			}
			expression.append(notTail);
		}
		return expression;
	}

	/**
	 * Returns a regular expression that matches anything except the given text.
	 * Note that this expression is not trivial, because matching the negation
	 * of a text requires to NOT match the first character OR to match the first
	 * character and NOT to match the second character and so on.
	 * 
	 * This method is not applicable to negate regular expressions! It can 
	 * only be applied to negate plain texts.
	 */
	private String getNegation(String text) {
		// this variable holds the constructed regular expression
		StringBuilder negation = new StringBuilder();
		// this variable holds an expression that matches the prefix of 'text'
		// up to the character at position 'i'
		StringBuilder previous = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char charAtI = text.charAt(i);
			boolean isLast = (i == text.length() - 1);
			
			negation.append(previous);
			negation.append("~('");
			negation.append(escapeLiteralChar(charAtI));
			negation.append("')");
			
			if (!isLast) {
				negation.append("|");
			}
			
			previous.append("'");
			previous.append(escapeLiteralChar(charAtI));
			previous.append("'");
		}
		return negation.toString();
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
