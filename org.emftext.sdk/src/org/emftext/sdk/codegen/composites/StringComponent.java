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
package org.emftext.sdk.codegen.composites;

/**
 * A StringComponent is a part of a StringComposite. By
 * default all StringComponens are disabled and do thus 
 * not appear when the containing StringComposite is 
 * converted to a String.
 */
public class StringComponent implements Component {

	private final String text;
	private boolean enabled = false;
	private String enabler;
	
	public StringComponent(String text, String enabler) {
		this.text = text;
		this.enabler = enabler;
		if (enabler == null) {
			enabled = true;
		}
	}

	public String getText() {
		return text;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable(String text) {
		if (enabler != null && text != null && text.contains(enabler)) {
			enabled = true;
		}
	}
	
	@Override
	public String toString() {
		return toString(0);
	}
	
	public String toString(int tabs) {
		String textValue = getText();
		return StringComposite.getTabText(tabs) + textValue;
	}

	public String getEnabler() {
		return enabler;
	}
}
