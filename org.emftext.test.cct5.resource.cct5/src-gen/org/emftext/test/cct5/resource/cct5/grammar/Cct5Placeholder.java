/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class Cct5Placeholder extends org.emftext.test.cct5.resource.cct5.grammar.Cct5Terminal {
	
	private final String tokenName;
	
	public Cct5Placeholder(EStructuralFeature feature, String tokenName, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
