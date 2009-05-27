/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
