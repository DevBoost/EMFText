/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.grammar;

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
	
	public void setParent(CsSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public CsSyntaxElement[] getChildren() {
		if (children == null) {
			return new CsSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality getCardinality() {
		return cardinality;
	}
	
}
