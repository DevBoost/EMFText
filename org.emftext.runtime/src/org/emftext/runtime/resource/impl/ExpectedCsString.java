package org.emftext.runtime.resource.impl;

/**
 * A representation for a range in a document where a CsString (e.g.,
 * a keyword) is expected.
 */
public class ExpectedCsString extends AbstractExpectedElement {
	private String value;

	public ExpectedCsString(String value) {
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