/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;


public class Cct5Choice extends org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement {
	
	public Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality, org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.explode(getChildren(), "|");
	}
	
}
