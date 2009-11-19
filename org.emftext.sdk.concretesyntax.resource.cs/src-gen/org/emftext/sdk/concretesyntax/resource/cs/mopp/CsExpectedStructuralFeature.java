/*******************************************************************************
 * Copyright (c) 2006-2009 
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
	private org.eclipse.emf.ecore.EStructuralFeature feature;
	private org.eclipse.emf.ecore.EObject container;
	private String tokenName;
	
	@Deprecated	public CsExpectedStructuralFeature(org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, String tokenName) {
		this("0", feature, container, tokenName);
	}
	
	@Deprecated	public CsExpectedStructuralFeature(String scopeID, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, String tokenName) {
		super(scopeID, false);
		this.feature = feature;
		this.container = container;
		this.tokenName = tokenName;
	}
	
	public CsExpectedStructuralFeature(String scopeID, boolean discardFollowingExpectations, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, String tokenName) {
		super(scopeID, discardFollowingExpectations);
		this.feature = feature;
		this.container = container;
		this.tokenName = tokenName;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public org.eclipse.emf.ecore.EObject getContainer() {
		return container;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
	public String toString() {
		return super.toString() + " EFeature \"" + feature.getName() + "\" in " + feature.getEContainingClass().getName();
	}
	
	public boolean equals(java.lang.Object o) {
		if (o instanceof CsExpectedStructuralFeature) {
			return this.feature.equals(((CsExpectedStructuralFeature) o).feature);
		}
		return false;
	}
}
