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
package org.emftext.language.hedl.resource.hedl.mopp;

import org.emftext.language.hedl.resource.hedl.IHedlTextResource;
import org.emftext.language.hedl.resource.hedl.IHedlTextToken;
import org.emftext.language.hedl.resource.hedl.IHedlTokenStyle;

/**
 * This class customizes the syntax highlighting to show fully qualified class
 * names in bold font.
 */
public class HedlDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public IHedlTokenStyle getDynamicTokenStyle(IHedlTextResource resource, IHedlTextToken token, IHedlTokenStyle staticStyle) {
		if (staticStyle == null) {
			staticStyle = new HedlTokenStyle(new int[] {0,0,0}, new int[] {255,255,255}, false, false, false, false);
		}
		if ("LOWER".equals(token.getName()) && token.getText().contains(".")) {
			// make fully qualified class names bold
			int[] color = staticStyle.getColorAsRGB();
			int[] backgroundColor = staticStyle.getBackgroundColorAsRGB();
			boolean italic = staticStyle.isItalic();
			boolean striketrough = staticStyle.isStrikethrough();
			boolean underline = staticStyle.isUnderline();
			IHedlTokenStyle dynamicStyle = new HedlTokenStyle(color, backgroundColor, true, italic, striketrough, underline);
			return dynamicStyle;
		} else {
			return staticStyle;
		}
	}
}
