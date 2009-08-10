package org.emftext.runtime.resource.impl.code_completion;

import org.emftext.runtime.resource.impl.AbstractExpectedElement;

/**
 * A representation for a range in a document where a CsString (e.g.,
 * a keyword) is expected.
 */
public class ExpectedCsString extends AbstractExpectedElement {
	private String value;

	@Deprecated
	public ExpectedCsString(String value) {
		this(0, value);
	}
	
	public ExpectedCsString(int nestingLevel, String value) {
		super(nestingLevel);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public String toString() {
		return super.toString() + " CsString \"" + value + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof ExpectedCsString) {
			return this.value.equals(((ExpectedCsString) o).value);
		}
		return false;
	}
}