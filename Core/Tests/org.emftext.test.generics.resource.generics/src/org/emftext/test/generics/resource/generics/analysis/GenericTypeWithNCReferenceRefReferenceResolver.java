/**
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
 *  
 */
package org.emftext.test.generics.resource.generics.analysis;

public class GenericTypeWithNCReferenceRefReferenceResolver implements org.emftext.test.generics.resource.generics.IGenericsReferenceResolver<org.emftext.test.generics.GenericTypeWithNCReference, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.test.generics.resource.generics.analysis.GenericsDefaultResolverDelegate<org.emftext.test.generics.GenericTypeWithNCReference, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.test.generics.resource.generics.analysis.GenericsDefaultResolverDelegate<org.emftext.test.generics.GenericTypeWithNCReference, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, org.emftext.test.generics.GenericTypeWithNCReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.test.generics.resource.generics.IGenericsReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.test.generics.GenericTypeWithNCReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
