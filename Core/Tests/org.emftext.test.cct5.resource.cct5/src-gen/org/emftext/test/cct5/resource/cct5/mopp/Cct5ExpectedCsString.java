/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class Cct5ExpectedCsString extends org.emftext.test.cct5.resource.cct5.mopp.Cct5AbstractExpectedElement {
	
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword keyword;
	
	public Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Cct5ExpectedCsString) {
			return getValue().equals(((Cct5ExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
