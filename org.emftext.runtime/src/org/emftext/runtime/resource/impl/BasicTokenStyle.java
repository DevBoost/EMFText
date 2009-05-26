package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.ITokenStyle;

/**
 * A basic implementation of the ITokenStyle interface. This class
 * is instantiated by generated text resources. Modifications made
 * to the constructor must therefore be reflected in the text resource
 * code generator.
 */
public class BasicTokenStyle implements ITokenStyle {

	private int[] color;
	private boolean bold;
	private boolean italic;
	private boolean strikethrough;
	private boolean underline;
	
	public BasicTokenStyle(int[] color, boolean bold, boolean italic,
			boolean striketrough, boolean underline) {
		super();
		this.color = color;
		this.bold = bold;
		this.italic = italic;
		this.strikethrough = striketrough;
		this.underline = underline;
	}

	public int[] getColorAsRGB() {
		return color;
	}

	public boolean isBold() {
		return bold;
	}

	public boolean isItalic() {
		return italic;
	}

	public boolean isStrikethrough() {
		return strikethrough;
	}

	public boolean isUnderline() {
		return underline;
	}
}
