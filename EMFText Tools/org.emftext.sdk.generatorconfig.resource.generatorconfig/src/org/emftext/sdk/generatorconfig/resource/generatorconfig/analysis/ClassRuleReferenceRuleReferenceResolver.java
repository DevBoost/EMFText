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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis;

public class ClassRuleReferenceRuleReferenceResolver implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolver<org.emftext.sdk.generatorconfig.ClassRuleReference, org.emftext.sdk.generatorconfig.GeneratorRule> {

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.GeneratorconfigDefaultResolverDelegate<org.emftext.sdk.generatorconfig.ClassRuleReference, org.emftext.sdk.generatorconfig.GeneratorRule> delegate = new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.GeneratorconfigDefaultResolverDelegate<org.emftext.sdk.generatorconfig.ClassRuleReference, org.emftext.sdk.generatorconfig.GeneratorRule>();

	public void resolve(java.lang.String identifier, org.emftext.sdk.generatorconfig.ClassRuleReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<org.emftext.sdk.generatorconfig.GeneratorRule> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.sdk.generatorconfig.GeneratorRule element, org.emftext.sdk.generatorconfig.ClassRuleReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
