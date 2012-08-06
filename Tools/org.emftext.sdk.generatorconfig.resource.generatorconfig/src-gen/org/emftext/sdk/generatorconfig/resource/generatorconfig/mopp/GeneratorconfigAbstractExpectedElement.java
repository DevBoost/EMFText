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

// Abstract super class for all expected elements. Provides methods to
// add followers
public abstract class GeneratorconfigAbstractExpectedElement implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement {

	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();

	public GeneratorconfigAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}

	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}

	public void addFollower(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}

	public java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}

}
