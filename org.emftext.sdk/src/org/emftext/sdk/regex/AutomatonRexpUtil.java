package org.emftext.sdk.regex;

public class AutomatonRexpUtil {

	/**
	 * Escapes an ANTLR character expression (used in the regular expressions
	 * of ANTLR grammars) to the character expression syntax of the automaton
	 * library. Note that a character expression is not equal to a regular expression!
	 * Character expressions are a subset of the latter.
	 * 
	 * @param antlrRegexCharacterExpression
	 * @return the same expression in automaton syntax
	 */
	public final static String escapeToAutomatonSyntax(String antlrRegexCharacterExpression) {
		String test = antlrRegexCharacterExpression;
		// remove enclosing single quotes
		String subString = test.substring(1, test.length() - 1);

		String resultString = subString;
		// handle special characters
		resultString = resultString.replace("\\r", "\r");
		resultString = resultString.replace("\\n", "\n");
		resultString = resultString.replace("\\f", "\f");
		resultString = resultString.replace("\\t", "\t");
		resultString = resultString.replace("\\b", "\b");
		// TODO what about unicode sequences?

		resultString = resultString.replace("\\\\", "\\");
		resultString = resultString.replace("\\'", "'");
		resultString = resultString.replace("\\", "\\\\");
		resultString = resultString.replace("-", "\\-");
		resultString = resultString.replace("_", "\\_");

		resultString = resultString.replace("\"", "\\\"");
		if (!resultString.contains("\"")) {
			resultString = "\"" + resultString + "\"";
		}

		return resultString;
	}
}
