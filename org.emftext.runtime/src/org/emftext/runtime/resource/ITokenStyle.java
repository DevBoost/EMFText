package org.emftext.runtime.resource;

public interface ITokenStyle {

	int[] getColorAsRGB();
	boolean isBold();
	boolean isItalic();
	boolean isStrikethrough();
	boolean isUnderline();
}
