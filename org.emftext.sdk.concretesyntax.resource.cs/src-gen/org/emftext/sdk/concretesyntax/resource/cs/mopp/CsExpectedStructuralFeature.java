/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// A representation for a range in a document where a structural feature (e.g.,
// a reference) is expected.
public class CsExpectedStructuralFeature extends org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAbstractExpectedElement {
	
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder placeholder;
	
	public CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.lang.String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(java.lang.Object o) {
		if (o instanceof CsExpectedStructuralFeature) {
			return getFeature().equals(((CsExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
