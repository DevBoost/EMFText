/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class Cct5SyntaxElement {
	
	private Cct5SyntaxElement[] children;
	private Cct5SyntaxElement parent;
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality;
	
	public Cct5SyntaxElement(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality, Cct5SyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (Cct5SyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(Cct5SyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public Cct5SyntaxElement getParent() {
		return parent;
	}
	
	/**
	 * Returns the rule of this syntax element. The rule is determined by the
	 * containment hierarchy in the CS model.
	 */
	public org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule getRule() {
		if (this instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule) {
			return (org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule) this;
		}
		return parent.getRule();
	}
	
	public Cct5SyntaxElement[] getChildren() {
		if (children == null) {
			return new Cct5SyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality getCardinality() {
		return cardinality;
	}
	
	public boolean hasContainment(EClass metaclass) {
		org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement[] children = getChildren();
		for (org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement child : children) {
			if (child.hasContainment(metaclass)) {
				return true;
			}
		}
		return false;
	}
	
}
