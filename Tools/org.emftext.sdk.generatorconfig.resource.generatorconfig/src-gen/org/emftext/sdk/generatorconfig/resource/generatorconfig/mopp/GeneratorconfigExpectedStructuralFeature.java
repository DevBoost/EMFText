/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

// A representation for a range in a document where a structural feature (e.g.,
// a reference) is expected.
public class GeneratorconfigExpectedStructuralFeature extends org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigAbstractExpectedElement {
	private org.eclipse.emf.ecore.EStructuralFeature feature;
	private String tokenName;

	public GeneratorconfigExpectedStructuralFeature(org.eclipse.emf.ecore.EClass ruleMetaclass, org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName) {
		super(ruleMetaclass);
		this.feature = feature;
		this.tokenName = tokenName;
	}

	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}

	public String getTokenName() {
		return tokenName;
	}

	public java.lang.String toString() {
		return "EFeature " + feature.getEContainingClass().getName() + "." + feature.getName();
	}

	public boolean equals(java.lang.Object o) {
		if (o instanceof GeneratorconfigExpectedStructuralFeature) {
			return this.feature.equals(((GeneratorconfigExpectedStructuralFeature) o).feature);
		}
		return false;
	}
}
