/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;


public class Cct5DynamicTokenStyler {
	
	/**
	 * The offset in the text where the lexer started.
	 */
	private int offset;
	
	/**
	 * <p>
	 * This method is called to dynamically style tokens.
	 * </p>
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.emftext.test.cct5.resource.cct5.ICct5TokenStyle getDynamicTokenStyle(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource, org.emftext.test.cct5.resource.cct5.ICct5TextToken token, org.emftext.test.cct5.resource.cct5.ICct5TokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
