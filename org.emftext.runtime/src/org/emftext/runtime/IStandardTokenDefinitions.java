package org.emftext.runtime;

/**
 * A list of the tokens that are provided by default in all concrete syntax
 * specifications. The list contains both the names of the tokens and their
 * definition (i.e., a regular expression).
 */
public interface IStandardTokenDefinitions {

	/**
	 * The standard token type name (used when no user-defined token type is referenced 
	 * and no pre- and suffixes are given).
	 */
	public String STD_TOKEN_NAME = "TEXT";
	public String STD_TOKEN_DEF  = "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+";
	
	/**
	 * The whitespace token definition.
	 */
	public String WS_TOKEN_NAME = "WS";
	public String WS_TOKEN_DEF = "(' ' | '\\t' | '\\f')";
	
	/**
	 * The line break token definition.
	 */
	public String LB_TOKEN_NAME = "LB";
	public String LB_TOKEN_DEF = "('\\r\\n' | '\\r' | '\\n')";
}
