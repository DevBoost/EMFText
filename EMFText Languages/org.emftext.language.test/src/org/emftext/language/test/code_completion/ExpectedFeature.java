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
package org.emftext.language.test.code_completion;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * ExpectedFeatures are used to denote that a follow set of
 * a syntax element contains a terminal (i.e., either an 
 * attribute or a non-containment reference) in the syntax 
 * definition.
 */
public class ExpectedFeature implements IExpectedElement {

	private GenFeature genFeature;
	private GenClass ruleMetaClass;
	private String tokenName;
	
	public ExpectedFeature(GenFeature genFeature, GenClass ruleMetaClass, String tokenName) {
		this.genFeature = genFeature;
		this.ruleMetaClass = ruleMetaClass;
		this.tokenName = tokenName;
	}
	
	public GenFeature getGenFeature() {
		return genFeature;
	}

	public GenClass getRuleMetaClass() {
		return ruleMetaClass;
	}

	public String getTokenName() {
		return tokenName;
	}

	public String toString() {
		EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		return ecoreFeature.getEContainingClass().getEPackage().getNsPrefix() + ":" +
			ecoreFeature.getEContainingClass().getName() + "." +
			ecoreFeature.getName();
	}
}
