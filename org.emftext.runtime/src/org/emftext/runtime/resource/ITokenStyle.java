package org.emftext.runtime.resource;

/**
 * A common interface for token styles. Text resources must
 * return style information using object implementing this
 * interface.
 */
public interface ITokenStyle {

	/**
	 * Returns the color of the token as array of length 3.
	 */
	int[] getColorAsRGB();
	
	/**
	 * Returns true if the token must be displayed in bold face.
	 */
	boolean isBold();
	
	/**
	 * Returns true if the token must be displayed in italic face.
	 */
	boolean isItalic();
	
	/**
	 * Returns true if the token must be displayed in strike through style.
	 */
	boolean isStrikethrough();
	
	/**
	 * Returns true if the token must be displayed underline.
	 */
	boolean isUnderline();
}
