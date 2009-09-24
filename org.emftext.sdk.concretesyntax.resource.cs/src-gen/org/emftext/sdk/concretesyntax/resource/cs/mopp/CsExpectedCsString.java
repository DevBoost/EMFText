package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// A representation for a range in a document where a CsString (e.g.,
// a keyword) is expected.
public class CsExpectedCsString extends org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAbstractExpectedElement {
	private String value;
	
	public CsExpectedCsString(String value) {
		this("0", value);
	}
	
	public CsExpectedCsString(String scopeID, String value) {
		super(scopeID, false);
		this.value = value;
	}
	
	public CsExpectedCsString(String scopeID, boolean discardFollowingExpectations, String value) {
		super(scopeID, discardFollowingExpectations);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return super.toString() + " CsString \"" + value + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof CsExpectedCsString) {
			return this.value.equals(((CsExpectedCsString) o).value);
		}
		return false;
	}
}
