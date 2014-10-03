/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class Cct5BooleanTerminal extends org.emftext.test.cct5.resource.cct5.grammar.Cct5Terminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public Cct5BooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof EAttribute;
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	public String getTrueLiteral() {
		return trueLiteral;
	}
	
	public String getFalseLiteral() {
		return falseLiteral;
	}
	
	public EAttribute getAttribute() {
		return (EAttribute) getFeature();
	}
	
}
