/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsTokenStyleInformationProvider {
	
	public class TokenStyleImpl implements org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle {
		
		private int[] color;
		private boolean bold;
		private boolean italic;
		private boolean strikethrough;
		private boolean underline;
		
		public TokenStyleImpl(int[] color, boolean bold, boolean italic, boolean striketrough, boolean underline) {
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
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("HEXNUMBER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xD0, 0xFF}, false, false, false, false);
		}
		if ("TABNUMBER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xD0, 0xFF}, false, false, false, false);
		}
		if ("DEFINE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("REDEFINE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("AS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("FRAGMENT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("COLLECT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("IN".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("COLOR".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("PRIORITIZE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("COMMENTS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x80, 0x00}, false, false, false, false);
		}
		if ("ABSTRACT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("SYNTAXDEF".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("FOR".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("START".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("IMPORTS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("OPTIONS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("TOKENS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("TOKENSTYLES".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("RULES".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("STRING".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if ("QUOTED_39_39_92".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0x00}, false, false, false, false);
		}
		if ("WITH".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("SYNTAX".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("QUOTED_36_36".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		return null;
	}
	
}
