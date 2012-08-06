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
package org.emftext.language.featherweightjava.resource.fj.analysis;

//TODO this resolver needs customization
public class FieldInitialisiationFieldReferenceResolver implements org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolver<org.emftext.language.featherweightjava.FieldInitialisiation, org.emftext.language.featherweightjava.Field> {

	private org.emftext.language.featherweightjava.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweightjava.FieldInitialisiation, org.emftext.language.featherweightjava.Field> delegate = new org.emftext.language.featherweightjava.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweightjava.FieldInitialisiation, org.emftext.language.featherweightjava.Field>();

	public void resolve(java.lang.String identifier, org.emftext.language.featherweightjava.FieldInitialisiation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweightjava.Field> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.featherweightjava.Field element, org.emftext.language.featherweightjava.FieldInitialisiation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {

	}

}
