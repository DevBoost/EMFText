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
package org.emftext.test.grammar_features.resource.grammar_features.analysis;

import org.emftext.test.grammar_features.resource.grammar_features.IGrammar_featuresReferenceResolveResult;
import org.emftext.test.grammar_features.resource.grammar_features.IGrammar_featuresReferenceResolver;

public class OptionalNonContainmentReferenceReferenceResolver implements IGrammar_featuresReferenceResolver<org.emftext.test.grammar_features.OptionalNonContainment, org.emftext.test.grammar_features.X> {
	
	private org.emftext.test.grammar_features.resource.grammar_features.analysis.Grammar_featuresDefaultResolverDelegate<org.emftext.test.grammar_features.OptionalNonContainment, org.emftext.test.grammar_features.X> delegate = new org.emftext.test.grammar_features.resource.grammar_features.analysis.Grammar_featuresDefaultResolverDelegate<org.emftext.test.grammar_features.OptionalNonContainment, org.emftext.test.grammar_features.X>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.grammar_features.OptionalNonContainment container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IGrammar_featuresReferenceResolveResult<org.emftext.test.grammar_features.X> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.test.grammar_features.X element, org.emftext.test.grammar_features.OptionalNonContainment container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
