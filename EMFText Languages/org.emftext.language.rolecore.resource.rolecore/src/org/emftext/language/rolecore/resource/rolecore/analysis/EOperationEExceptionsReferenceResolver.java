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
package org.emftext.language.rolecore.resource.rolecore.analysis;

public class EOperationEExceptionsReferenceResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolver<org.eclipse.emf.ecore.EOperation, org.eclipse.emf.ecore.EClassifier> {

	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.eclipse.emf.ecore.EOperation, org.eclipse.emf.ecore.EClassifier> delegate = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.eclipse.emf.ecore.EOperation, org.eclipse.emf.ecore.EClassifier>();

	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EOperation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClassifier element, org.eclipse.emf.ecore.EOperation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}

}
