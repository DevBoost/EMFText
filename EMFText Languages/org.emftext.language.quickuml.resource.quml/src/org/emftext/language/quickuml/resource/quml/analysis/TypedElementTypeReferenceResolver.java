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
package org.emftext.language.quickuml.resource.quml.analysis;

import org.emftext.language.quickuml.resource.quml.IQumlReferenceResolveResult;
import org.emftext.language.quickuml.resource.quml.IQumlReferenceResolver;

public class TypedElementTypeReferenceResolver implements IQumlReferenceResolver<org.eclipse.uml2.uml.TypedElement, org.eclipse.uml2.uml.Type> {

	private org.emftext.language.quickuml.resource.quml.analysis.QumlDefaultResolverDelegate<org.eclipse.uml2.uml.TypedElement, org.eclipse.uml2.uml.Type> delegate = new org.emftext.language.quickuml.resource.quml.analysis.QumlDefaultResolverDelegate<org.eclipse.uml2.uml.TypedElement, org.eclipse.uml2.uml.Type>();

	public void resolve(java.lang.String identifier, org.eclipse.uml2.uml.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IQumlReferenceResolveResult<org.eclipse.uml2.uml.Type> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.eclipse.uml2.uml.Type element, org.eclipse.uml2.uml.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}

}
