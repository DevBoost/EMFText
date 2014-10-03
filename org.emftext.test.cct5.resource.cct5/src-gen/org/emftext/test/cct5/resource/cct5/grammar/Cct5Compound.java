/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;


public class Cct5Compound extends org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement {
	
	public Cct5Compound(org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice choice, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality) {
		super(cardinality, new org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
