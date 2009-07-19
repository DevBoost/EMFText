package org.emftext.runtime.resource;

/**
 * A common interface for scanners to be used by EMFText.
 * A scanner is initialized with a text and delivers a 
 * sequence of tokens.
 */
//TODO mseifert: rename this class to ITextScanner
public interface ITextLexer {

	/**
	 * Sets the text that must be scanned.
	 */
	public void setText(String text);
	
	/**
	 * Returns the next token found in the text.
	 */
	public ITextToken getNextToken();
}
