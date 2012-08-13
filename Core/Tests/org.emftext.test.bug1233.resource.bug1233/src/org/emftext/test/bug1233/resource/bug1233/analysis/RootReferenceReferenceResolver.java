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
package org.emftext.test.bug1233.resource.bug1233.analysis;

import org.emftext.test.bug1233ext.Bug1233extFactory;
import org.emftext.test.bug1233ext.ConcreteType;

public class RootReferenceReferenceResolver implements org.emftext.test.bug1233.resource.bug1233.IBug1233ReferenceResolver<org.emftext.test.bug1233.Root, org.emftext.test.bug1233.AbstractType> {
	
	public static boolean doResolve = false;
	
	private org.emftext.test.bug1233.resource.bug1233.analysis.Bug1233DefaultResolverDelegate<org.emftext.test.bug1233.Root, org.emftext.test.bug1233.AbstractType> delegate = new org.emftext.test.bug1233.resource.bug1233.analysis.Bug1233DefaultResolverDelegate<org.emftext.test.bug1233.Root, org.emftext.test.bug1233.AbstractType>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.bug1233.Root container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.test.bug1233.resource.bug1233.IBug1233ReferenceResolveResult<org.emftext.test.bug1233.AbstractType> result) {
		if (doResolve) {
			ConcreteType target = Bug1233extFactory.eINSTANCE.createConcreteType();
			result.addMapping(identifier, target);
		}
	}
	
	public java.lang.String deResolve(org.emftext.test.bug1233.AbstractType element, org.emftext.test.bug1233.Root container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
