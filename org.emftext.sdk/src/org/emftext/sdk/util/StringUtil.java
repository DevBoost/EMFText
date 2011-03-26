/*******************************************************************************
 * Copyright (c) 2006-2011
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;


/**
 * A utility class that provides some common methods to work
 * with Strings.
 */
public class StringUtil {

	public final static String HEX_DIGIT_REGEXP = "[0-9a-fA-F]";
	public final static String UNICODE_SEQUENCE_REGEXP = "\\\\u" + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP;

	/*
	ESC	:	'\\'
			(	'n'
			|	'r'
			|	't'
			|	'b'
			|	'f'
			|	'"'
			|	'\''
			|	'\\'
			|	'>'
			|	'u' XDIGIT XDIGIT XDIGIT XDIGIT
			|	. // unknown, leave as it is
			)
		;
	*/
	public final static String ESC_OTHER = "\\\\(n|r|t|b|f|\"|'|>)";
	public final static String ESC_REGEXP = "\\A((" + UNICODE_SEQUENCE_REGEXP + ")|(" + ESC_OTHER + ")).*";
	public final static String UNICODE_SEQUENCE_START = "\\A(" + UNICODE_SEQUENCE_REGEXP + ")";

	private static String[] RESERVED_WORDS = new String[] {
		"abstract", 
		"assert", 
		"boolean", 
		"break", 
		"byte", 
		"case", 
		"catch", 
		"char", 
		"class", 
		"const", 
		"continue",  
		"default", 
		"do", 
		"double", 
		"else", 
		"enum", 
		"extends",
		"false", 
		"final", 
		"finally", 
		"float", 
		"for", 
		"goto", 
		"if", 
		"implements", 
		"import", 
		"instanceof", 
		"int", 
		"interface", 
		"long", 
		"native", 
		"new", 
		"null",
		"package", 
		"private", 
		"protected", 
		"public", 
		"return", 
		"short", 
		"static", 
		"strictfp", 
		"super", 
		"switch", 
		"synchronized", 
		"this", 
		"throw", 
		"throws", 
		"transient",
		"true",
		"try", 
		"void", 
		"volatile", 
		"while", 
	};
	
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
		return explode(parts, glue, new ToStringConverter<String>() {

			public String toString(String sourceObject) {
				return sourceObject;
			}
		});
	}
	
	/**
	 * Converts the given parts to strings using the converter and puts 
	 * 'glue' between them.
	 * 
	 * @param parts
	 * @param glue
	 * @return
	 */
	public static <T> String explode(Collection<T> parts, String glue, ToStringConverter<T> converter) {
		StringBuilder sb = new StringBuilder();
		Iterator<T> it = parts.iterator();
		while (it.hasNext()) {
			T next = it.next();
			sb.append(converter.toString(next));
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
		if (text == null) {
			return null;
		}
		//for javac: replace one backslash by two and escape double quotes
		String result = text.replaceAll("\\\\", "\\\\\\\\").
			replaceAll("\"", "\\\\\"").
			replace("\b", "\\b").
			replace("\f", "\\f").
			replace("\n", "\\n").
			replace("\r", "\\r").
			replace("\t", "\\t");
		
		StringBuffer complete = new StringBuffer();
		for (int i = 0; i < result.length(); i++) {
			int codePointI = result.codePointAt(i);
			if (codePointI >= 32 && codePointI <= 127) {
				complete.append(Character.toChars(codePointI));
			} else {
				// use Unicode representation
				complete.append("\\u");
				String hex = Integer.toHexString(codePointI);
				complete.append(getRepeatingString(4 - hex.length(), '0'));
				complete.append(hex);
			}
		}
		return complete.toString();
	}

	/**
	 * Unescapes the given Java string. It converts the string as
	 * it would be found in a Java file to its actual value that
	 * can, for example, be printed to System.out. The following 
	 * replacements are made:
	 * 
	 * <ul>
	 * <li>backslash double quote - double quote
	 * <li>backslash backslash - backslash
	 * <li>backslash ('n', 'r', 't', 'b', 'f') - line break, return, tab, bell or \f
	 * </ul>
	 * 
	 * The same behavior observed, when javac reads plain Java files 
	 * with String literals.
	 * 
	 * @param text the string to unescape
	 * @return
	 */
	public static String unescapeJavaString(String text) {
		String result = text;
		int index = result.indexOf("\\");
		while (index >= 0) {
			String tail = result.substring(index);
			if (tail.startsWith("\\n")) {
				result = result.substring(0, index) + "\n" + result.substring(index + 2);
			} else if (tail.startsWith("\\r")) {
				result = result.substring(0, index) + "\r" + result.substring(index + 2);
			} else if (tail.startsWith("\\t")) {
				result = result.substring(0, index) + "\t" + result.substring(index + 2);
			} else if (tail.startsWith("\\b")) {
				result = result.substring(0, index) + "\b" + result.substring(index + 2);
			} else if (tail.startsWith("\\f")) {
				result = result.substring(0, index) + "\f" + result.substring(index + 2);
			} else if (tail.startsWith("\\\\")) {
				result = result.substring(0, index) + "\\" + result.substring(index + 2);
			} else if (tail.startsWith("\\\"")) {
				result = result.substring(0, index) + "\"" + result.substring(index + 2);
			} else if (tail.startsWith("\\u")) {
				// unicode sequence
				assert tail.length() > 5;
				String unicodeCharacter = tail.substring(0, 6);
				UnicodeConverter converter = new UnicodeConverter(new ByteArrayInputStream(unicodeCharacter.getBytes()));
				try {
					byte[] bytes = new byte[8];
					int next = converter.read();
					int i = 0;
					while (next >= 0) {
						bytes[i] = (byte) next;
						i++;
						next = converter.read();
					}
					byte[] usedBytes = new byte[i];
					for (int j = 0; j < usedBytes.length; j++) {
						usedBytes[j] = bytes[j];
					}
					result = result.substring(0, index) + new String(usedBytes, "UTF-8") + result.substring(index + 6);
				} catch (IOException e) {
					e.printStackTrace();
					assert false;
				}
			}
			// continue searching for backslash characters
			index = result.indexOf("\\", index + 1);
		}
		return result;
	}
	
	/**
	 * Escapes the given text such that it can be safely embedded in an
	 * ANTLR grammar as keyword (i.e., an in-line token). Single quotes
	 * are escaped using a backslash. Backslashes are escaped using a 
	 * backslash.
	 * 
	 * @param value the text to escape
	 * @return the escaped text
	 */
	public static String escapeToANTLRKeyword(String value) {
		return escapeToJavaString(value).replace("'", "\\'").replace("%", "\\u0025");
	}

	public static boolean isUnicodeSequence(String text) {
		return text.matches(UNICODE_SEQUENCE_REGEXP);
	}

    /**
     * Converts the first letter of the given string to lower case.
     * 
     * @param s a string
     * @return the modified string.
     */
    public static String low(String s) {
        String h = s.substring(0, 1).toLowerCase();
        String t = s.substring(1);      
        return h + t ;
    }

	/**
	 * Returns a valid identifier using the list of <code>RESERVED_WORDS</code>. If the given
	 * identifier is a Java keywords it is prefixed with an underscore. Otherwise the identifier 
	 * itself is returned. The identifier is also converted to lower string.
	 * 
	 * @param identifier an identifier.
	 * @return an identifier that does not lead to conflicts.
	 */
    public static String getLowerCase(String identifier) {
    	identifier = identifier.toLowerCase();
    	if (isReserveredWord(identifier)) {
    		return "keyword" + identifier;
    	}
    	return identifier;
    }
    
    public static boolean isReserveredWord(String identifier) {
		for (String word : RESERVED_WORDS) {
			if (word.toLowerCase().equals(identifier)) {
				return true;
			}
		}
		return false;
	}

    public static String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}

	public static String firstToLower(String text) {
		if (text == null) {
			return text;
		}
		if (text.length() == 1) {
			return text.toLowerCase();
		}
		return text.substring(0,1).toLowerCase() + text.substring(1);
	}
}
