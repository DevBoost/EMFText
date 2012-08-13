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
package org.emftext.test.cct1.resource.cct1.analysis;

import org.emftext.test.cct1.resource.cct1.ICct1ReferenceResolveResult;
import org.emftext.test.cct1.resource.cct1.ICct1ReferenceResolver;

public class TypedElementTypeReferenceResolver implements ICct1ReferenceResolver<org.emftext.test.cct1.TypedElement, org.emftext.test.cct1.Class> {

	private org.emftext.test.cct1.resource.cct1.analysis.Cct1DefaultResolverDelegate<org.emftext.test.cct1.TypedElement, org.emftext.test.cct1.Class> delegate = new org.emftext.test.cct1.resource.cct1.analysis.Cct1DefaultResolverDelegate<org.emftext.test.cct1.TypedElement, org.emftext.test.cct1.Class>();

	public void resolve(java.lang.String identifier, org.emftext.test.cct1.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ICct1ReferenceResolveResult<org.emftext.test.cct1.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.test.cct1.Class element, org.emftext.test.cct1.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}

}
