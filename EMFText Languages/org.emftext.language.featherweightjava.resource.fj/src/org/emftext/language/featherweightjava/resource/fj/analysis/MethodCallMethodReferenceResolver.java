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
public class MethodCallMethodReferenceResolver implements org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolver<org.emftext.language.featherweightjava.MethodCall, org.emftext.language.featherweightjava.Method> {

	private org.emftext.language.featherweightjava.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweightjava.MethodCall, org.emftext.language.featherweightjava.Method> delegate = new org.emftext.language.featherweightjava.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweightjava.MethodCall, org.emftext.language.featherweightjava.Method>();

	public void resolve(java.lang.String identifier, org.emftext.language.featherweightjava.MethodCall container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweightjava.Method> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.featherweightjava.Method element, org.emftext.language.featherweightjava.MethodCall container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {

	}

}
