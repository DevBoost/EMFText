/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;


public class Cct5WhiteSpace extends org.emftext.test.cct5.resource.cct5.grammar.Cct5FormattingElement {
	
	private final int amount;
	
	public Cct5WhiteSpace(int amount, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
