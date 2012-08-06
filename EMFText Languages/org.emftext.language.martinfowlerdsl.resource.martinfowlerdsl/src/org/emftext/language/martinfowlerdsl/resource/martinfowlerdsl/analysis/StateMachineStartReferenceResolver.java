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
package org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis;

public class StateMachineStartReferenceResolver implements org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolver<org.emftext.language.martinfowlerdsl.StateMachine, org.emftext.language.martinfowlerdsl.State> {

	private org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.StateMachine, org.emftext.language.martinfowlerdsl.State> delegate = new org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.StateMachine, org.emftext.language.martinfowlerdsl.State>();

	public void resolve(java.lang.String identifier, org.emftext.language.martinfowlerdsl.StateMachine container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolveResult<org.emftext.language.martinfowlerdsl.State> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.martinfowlerdsl.State element, org.emftext.language.martinfowlerdsl.StateMachine container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}

}
