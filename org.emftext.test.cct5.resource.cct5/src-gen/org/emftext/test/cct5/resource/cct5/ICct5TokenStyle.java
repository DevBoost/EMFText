/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;


/**
 * A common interface for token styles. Text resources must return style
 * information using classes that implement this interface.
 */
public interface ICct5TokenStyle {
	
	/**
	 * Returns the color of the token as array of length 3.
	 */
	public int[] getColorAsRGB();
	
	/**
	 * Returns the background color of the token as array of length 3. This method can
	 * return <code>null</code> if no background color is set.
	 */
	public int[] getBackgroundColorAsRGB();
	
	/**
	 * Returns true if the token must be displayed in bold face.
	 */
	public boolean isBold();
	
	/**
	 * Sets whether the token must be displayed in bold face.
	 */
	public void setBold(boolean bold);
	
	/**
	 * Returns true if the token must be displayed in italic face.
	 */
	public boolean isItalic();
	
	/**
	 * Returns true if the token must be displayed in strike through style.
	 */
	public boolean isStrikethrough();
	
	/**
	 * Returns true if the token must be displayed underlined.
	 */
	public boolean isUnderline();
	
}
