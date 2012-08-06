/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.language.javaproperties.resource.properties.mopp;

public class PropertiesDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.emftext.language.javaproperties.resource.properties.IPropertiesTokenStyle getDynamicTokenStyle(org.emftext.language.javaproperties.resource.properties.IPropertiesTextResource resource, org.emftext.language.javaproperties.resource.properties.IPropertiesTextToken token, org.emftext.language.javaproperties.resource.properties.IPropertiesTokenStyle staticStyle) {
		String tokenName = token.getName();
		String tokenText = token.getText();
		boolean atBeginningOfLine = token.getColumn() == 0;
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		boolean hasTrailingWhitespace = tokenText.startsWith(" ") || tokenText.startsWith("\t") || tokenText.startsWith("\f");
		if ("VALUE".equals(tokenName) && hasTrailingWhitespace && atBeginningOfLine) {
			System.out.println("PropertiesDynamicTokenStyler.getDynamicTokenStyle() " + tokenText);
			return new PropertiesTokenStyle(
				new int [] {0x07, 0xa8, 0xec}, 
				null, 
				true, false, false, false);
		}
		return staticStyle;
	}
	
}
