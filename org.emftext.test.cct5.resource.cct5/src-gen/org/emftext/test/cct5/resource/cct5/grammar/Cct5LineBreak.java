/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;


public class Cct5LineBreak extends org.emftext.test.cct5.resource.cct5.grammar.Cct5FormattingElement {
	
	private final int tabs;
	
	public Cct5LineBreak(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
