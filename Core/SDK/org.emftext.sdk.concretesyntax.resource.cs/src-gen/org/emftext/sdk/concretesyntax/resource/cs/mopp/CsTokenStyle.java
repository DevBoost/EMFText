/*******************************************************************************
 * Copyright (c) 2006-2013
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsTokenStyle implements org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle {
	
	private int[] colorAsRGB;
	
	private int[] backgroundColorAsRGB;
	
	private boolean bold;
	
	private boolean italic;
	
	private boolean strikethrough;
	
	private boolean underline;
	
	public CsTokenStyle(int[] colorAsRGB, int[] backgroundColorAsRGB, boolean bold, boolean italic, boolean striketrough, boolean underline) {
		super();
		this.colorAsRGB = colorAsRGB;
		this.backgroundColorAsRGB = backgroundColorAsRGB;
		this.bold = bold;
		this.italic = italic;
		this.strikethrough = striketrough;
		this.underline = underline;
	}
	
	public CsTokenStyle(org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle styleToCopy) {
		this(styleToCopy.getColorAsRGB(), styleToCopy.getBackgroundColorAsRGB(), styleToCopy.isBold(), styleToCopy.isItalic(), styleToCopy.isStrikethrough(), styleToCopy.isUnderline());
	}
	
	public int[] getColorAsRGB() {
		return colorAsRGB;
	}
	
	public int[] getBackgroundColorAsRGB() {
		return backgroundColorAsRGB;
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
	
	public void setColorAsRGB(int[] colorAsRGB) {
		this.colorAsRGB = colorAsRGB;
	}
	
	public void setBackgroundColorAsRGB(int[] backgroundColorAsRGB) {
		this.backgroundColorAsRGB = backgroundColorAsRGB;
	}
	
	public void setBold(boolean bold) {
		this.bold = bold;
	}
	
	public void setItalic(boolean italic) {
		this.italic = italic;
	}
	
	public void setStrikethrough(boolean strikethrough) {
		this.strikethrough = strikethrough;
	}
	
	public void setUnderline(boolean underline) {
		this.underline = underline;
	}
	
}
