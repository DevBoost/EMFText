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
package org.emftext.language.forms.resource.forms.analysis;

public class ItemDependentOfReferenceResolver implements org.emftext.language.forms.resource.forms.IFormsReferenceResolver<org.emftext.language.forms.Item, org.emftext.language.forms.Option> {

	private org.emftext.language.forms.resource.forms.analysis.FormsDefaultResolverDelegate<org.emftext.language.forms.Item, org.emftext.language.forms.Option> delegate = new org.emftext.language.forms.resource.forms.analysis.FormsDefaultResolverDelegate<org.emftext.language.forms.Item, org.emftext.language.forms.Option>();

	public void resolve(java.lang.String identifier, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.forms.resource.forms.IFormsReferenceResolveResult<org.emftext.language.forms.Option> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.forms.Option element, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}

}
