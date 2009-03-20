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
package org.emftext.sdk.codegen.generators;

import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;

/**
 * The AntlrTokenDerivator is used to derive implicit Antrl Tokens for
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
     * @param prefix
     * @param suffix
     * @return
     */
	public String deriveTokenExpression(PlaceholderInQuotes placeholder) {
		String prefix = placeholder.getNormalizedPrefix();
		String suffix = placeholder.getNormalizedSuffix();

		boolean prefixIsSet = prefix != null && prefix.length() > 0;
		boolean suffixIsSet = suffix != null && suffix.length() > 0;
		
		assert prefixIsSet;
		assert suffixIsSet;

		String derivedExpression = "('" + escapeLiteralChars(prefix) + "')";
		
		derivedExpression += "(~('" + escapeLiteralChars(suffix)
				+ "')|('\\\\''" + escapeLiteralChars(suffix) + "'))*";
		
		derivedExpression += "('" + escapeLiteralChars(suffix) + "')";

		return derivedExpression;
	}
	
    public String deriveTokenName(PlaceholderInQuotes placeholder) {
		String prefix = placeholder.getNormalizedPrefix();
		String suffix = placeholder.getNormalizedSuffix();

    	boolean suffixIsSet = suffix!=null && suffix.length() > 0;
		boolean prefixIsSet = prefix!=null && prefix.length() > 0;
		
		assert prefixIsSet;
		assert suffixIsSet;

 		return DERIVED_TOKEN_NAME + "_" + deriveCodeSequence(prefix) + "_" + deriveCodeSequence(suffix);
	}

    private String deriveCodeSequence(String original) {
    	char[] chars = original.toCharArray();
    	String result = "";
    	for(int i=0;i<chars.length;i++){
    		if(chars[i]<10)
    			result += "0";
    		result += (int) chars[i];
    	}
    	return result;
    }
}
