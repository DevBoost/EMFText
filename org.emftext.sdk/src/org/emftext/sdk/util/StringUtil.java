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
package org.emftext.sdk.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * A utility class that provides some common methods to work
 * with Strings.
 */
public class StringUtil {

	public final static String HEX_DIGIT_REGEXP = "[0-9a-fA-F]";
	public final static String UNICODE_SEQUENCE_REGEXP = "\\A\\\\u" + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP;

	/**
     * Capitalizes the first letter of the given string.
     * 
     * @param text a string.
     * @return the modified string.
     */
    public static String capitalize(String text) {
        String h = text.substring(0, 1).toUpperCase();
        String t = text.substring(1);      
        return h + t;
    }

    /**
     * Returns the part of 'tail' that is not present at the end of
     * 'text'. For example if text = 'abc' and tail = 'cd' this method
     * returns 'd'. If 'tail' can not be found at the end of 'text',
     * 'tail' is returned as is.
     * 
     * @param text
     * @param tail
     * @return
     */
    public static String getMissingTail(String text, String tail) {
		for (int i = 1; i < tail.length(); i++) {
			int endIndex = text.length();
			int end = Math.max(0, endIndex);
			int start = Math.max(0, end - i);
			String contentTail = text.substring(start, end);
			String proposalHead = tail.substring(0, i);
			if (contentTail.equals(proposalHead)) {
				return tail.substring(i);
			}
		}
		return tail;
	}

    /**
     * Converts a string that contains upper-case letter and
     * underscores (e.g., constant names) to a camel-case string.
     * For example, MY_CONSTANT is converted to myConstant.
     * 
     * @param text the string to convert
     * @return
     */
	public static String convertAllCapsToLowerCamelCase(String text) {
		String lowerCase = text.toLowerCase();
		while (true) {
			int i = lowerCase.indexOf('_');
			if (i < 0) {
				break;
			}
			String head = lowerCase.substring(0, i);
			if (i + 1 == lowerCase.length()) {
				lowerCase = head;
				break;
			} else {
				char charAfterUnderscore = lowerCase.charAt(i + 1);
				char upperCase = Character.toUpperCase(charAfterUnderscore);
				if (i + 2 < lowerCase.length()) {
					String tail = lowerCase.substring(i + 2, lowerCase.length());
					lowerCase = head + upperCase + tail;
				} else {
					lowerCase = head + upperCase;
					break;
				}
			}
		}
		return lowerCase;
	}

	/**
	 * Concatenates the given parts and puts 'glue' between them.
	 * 
	 * @param parts
	 * @param glue
	 * @return
	 */
	public static String explode(Collection<String> parts, String glue) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = parts.iterator();
		while (it.hasNext()) {
			String next = it.next();
			sb.append(next);
			if (it.hasNext()) {
				sb.append(glue);
			}
		}
		return sb.toString();
	}

	/**
	 * Removes single quotes at the start and end of tokenName.
	 * 
	 * @param tokenName
	 * @return
	 */
	public static String formatTokenName(String tokenName) {
		if (tokenName.length() > 0 && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length());
		}
		if (tokenName.length() > 0 && tokenName.endsWith("'")) {
			tokenName = tokenName.substring(0, tokenName.length() - 1);
		}
		return tokenName;
	}
	
	public static int getLine(String text, int offset) {
		return getLineAndCharPosition(text, offset)[0];
	}
	
	public static int getCharPositionInLine(String text, int offset) {
		return getLineAndCharPosition(text, offset)[1];
	}
	
	public static Integer[] getLineAndCharPosition(String text, int offset) {
		int index = 0;
		int line = 0;
		int positionInLine = 0;
		while (true) {
			line++;
			positionInLine = offset - index + 1;
			int nextN = text.indexOf("\n", index);
			int nextR = text.indexOf("\r", index);
			int nextNorR = Integer.MAX_VALUE;
			if (nextN >= 0) {
				nextNorR = nextN;
			} else if (nextR >= 0 && nextR < nextNorR) {
				nextNorR = nextR;
			} else {
				// found no EOL character
				break;
			}
			
			index = nextNorR + 1;
			if (index == nextN) {
				index++;
			}
			if (index == nextR) {
				index++;
			}
			if (index > offset) {
				break;
			}
		}
		return new Integer[] {line, positionInLine};
	}
	
	public static String escapeQuotes(String s) {
		s = s.replace("\\", "\\\\");
		s = s.replace("\"", "\\\"");
		
		return s;
	}

	public static String convertCamelCaseToAllCaps(String qualifiedClassName) {
		StringBuffer sb = new StringBuffer();
		final char[] charArray = qualifiedClassName.toCharArray();
		for (int c = 0; c < charArray.length; c++) {
			char character = charArray[c];
			final boolean isEnd = c + 1 == charArray.length;
			boolean nextIsUpper = !isEnd && Character.isUpperCase(charArray[c + 1]);
			boolean nextNextIsLower = c + 2 < (charArray.length) && Character.isLowerCase(charArray[c + 2]);

			sb.append(Character.toUpperCase(character));
			if (Character.isLowerCase(character) && nextIsUpper) {
				sb.append('_');
			} else {
				if (nextIsUpper && nextNextIsLower) {
					sb.append('_');
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Escapes the given text such that it can be safely embedded in a string
	 * literal in Java source code.
	 * 
	 * @param text the text to escape
	 * @return the escaped text
	 */
	public static String escapeToJavaString(String text) {
		//for javac: replace one backslash by two and escape double quotes
		return text.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
	}

	/**
	 * Escapes the given text such that it can be safely embedded in a string
	 * literal in the Java source code contained in an ANTLR grammar. This 
	 * method is similar to escapeToJavaString(), but does also convert the 
	 * percent character to its Unicode representation, because the percent
	 * character has special meaning in ANTLR grammars.
	 * 
	 * Also, single quotes are escaped. God knows why.
	 * 
	 * @param text the text to escape
	 * @return the escaped text
	 */
	public static String escapeToJavaStringInANTLRGrammar(String text) {
		// we must use the Unicode representation for the % character, because
		// StringTemplate does treat % special
		return StringUtil.escapeToJavaString(text.replaceAll("'", "\\\\'")).replace("%", "\\u0025");
	}

	/**
	 * Escapes the given text such that it can be safely embedded in an
	 * ANTLR grammar as keyword (i.e., an in-line token). Single quotes
	 * are escaped using a backslash. Backslashes are escaped using a 
	 * backslash.
	 * 
	 * @param text the text to escape
	 * @return the escaped text
	 */
	public static String escapeToANTLRKeyword(String value) {
		String result = value;
		int index = result.indexOf("\\");
		while (index >= 0) {
			String tail = result.substring(index);
			if (!tail.matches(UNICODE_SEQUENCE_REGEXP)) {
				// not Unicode - do escape backslash
				String head = "";
				if (index > 0) {
					head = result.substring(0, index - 1);
				}
				result = head + "\\" + tail;
			}
			index = result.indexOf("\\", index + 2);
		}
		result.replaceAll("'", "\\\\'");
		return result;
	}
	
	public static boolean isUnicodeSequence(String text) {
		return text.matches(UNICODE_SEQUENCE_REGEXP);
	}
}
