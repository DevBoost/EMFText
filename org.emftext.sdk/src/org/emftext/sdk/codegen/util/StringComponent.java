package org.emftext.sdk.codegen.util;

/**
 * A StringComponent is a part of a StringComposite. By
 * default all StringComponens are disabled and do thus 
 * not appear when the containing StringComposite is 
 * converted to a String.
 */
public class StringComponent implements Component {

	private final String text;
	private boolean enabled = false;
	
	public StringComponent(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}
	
	@Override
	public String toString() {
		return toString(0);
	}
	
	public String toString(int tabs) {
		String textValue = getText();
		if (textValue.endsWith(StringComposite.LINE_BREAK)) {
			return StringComposite.getTabText(tabs) + textValue;
		} else {
			return textValue;
		}
	}
}
