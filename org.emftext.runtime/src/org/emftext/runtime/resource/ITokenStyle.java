package org.emftext.runtime.resource;

/**
 * A common interface for token styles. Text resources must
 * return style information using object implementing this
 * interface.
 */
public interface ITokenStyle {

	int[] getColorAsRGB();
	boolean isBold();
	boolean isItalic();
	boolean isStrikethrough();
	boolean isUnderline();
}
