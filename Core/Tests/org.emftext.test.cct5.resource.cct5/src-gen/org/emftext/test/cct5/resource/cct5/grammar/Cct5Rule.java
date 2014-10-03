/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class Cct5Rule extends org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement {
	
	private final EClass metaclass;
	
	public Cct5Rule(EClass metaclass, org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice choice, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality) {
		super(cardinality, new org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getDefinition() {
		return (org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice) getChildren()[0];
	}
	
	@Deprecated
	public String toString() {
		return metaclass == null ? "null" : metaclass.getName() + " ::= " + getDefinition().toString();
	}
	
}

