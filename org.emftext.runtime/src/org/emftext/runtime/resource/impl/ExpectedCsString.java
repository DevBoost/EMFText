/**
 * 
 */
package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IExpectedElement;

public class ExpectedCsString implements IExpectedElement {
	private String value;

	public ExpectedCsString(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public String toString() {
		return "CsString \"" + value + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof ExpectedCsString) {
			return this.value.equals(((ExpectedCsString) o).value);
		}
		return false;
	}
}