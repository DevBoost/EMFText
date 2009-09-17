package org.emftext.access.resource;

/**
 * A common interface for scanners to be used by EMFText.
 * A scanner is initialized with a text and delivers a 
 * sequence of tokens.
 */
// TODO add empty class AbstractTextScanner and let generated
// implementations inherit instead of implementing the interface
// directly
public interface ITextScanner {

	/**
	 * Sets the text that must be scanned.
	 */
	public void setText(String text);
	
	/**
	 * Returns the next token found in the text.
	 */
	public ITextToken getNextToken();
}
