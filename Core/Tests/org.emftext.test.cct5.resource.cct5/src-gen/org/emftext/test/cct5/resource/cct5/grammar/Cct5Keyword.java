/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class Cct5Keyword extends org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement {
	
	private final String value;
	
	public Cct5Keyword(String value, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
