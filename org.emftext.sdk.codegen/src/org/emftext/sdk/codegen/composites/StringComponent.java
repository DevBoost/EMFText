/*******************************************************************************
 * Copyright (c) 2006-2011
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
		if (tabs == 0) {
			return textValue;
		} else {
			return StringComposite.getTabText(tabs) + textValue;
		}
	}

	public String getEnabler() {
		return enabler;
	}
}
