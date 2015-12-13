/*******************************************************************************
 * Copyright (c) 2006-2015
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Dresden, Amtsgericht Dresden, HRB 34001
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class CsSyntaxElement {
	
	private CsSyntaxElement[] children;
	private CsSyntaxElement parent;
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality;
	
	public CsSyntaxElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality, CsSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (CsSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(CsSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public CsSyntaxElement getParent() {
		return parent;
	}
	
	/**
	 * Returns the rule of this syntax element. The rule is determined by the
	 * containment hierarchy in the CS model.
	 */
	public org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getRule() {
		if (this instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule) {
			return (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule) this;
		}
		return parent.getRule();
	}
	
	public CsSyntaxElement[] getChildren() {
		if (children == null) {
			return new CsSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality getCardinality() {
		return cardinality;
	}
	
	public boolean hasContainment(EClass metaclass) {
		org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement[] children = getChildren();
		for (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement child : children) {
			if (child.hasContainment(metaclass)) {
				return true;
			}
		}
		return false;
	}
	
}
