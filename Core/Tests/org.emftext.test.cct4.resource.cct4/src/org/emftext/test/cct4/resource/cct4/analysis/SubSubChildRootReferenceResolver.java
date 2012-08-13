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
package org.emftext.test.cct4.resource.cct4.analysis;

public class SubSubChildRootReferenceResolver implements org.emftext.test.cct4.resource.cct4.ICct4ReferenceResolver<org.emftext.test.cct4.SubSubChild, org.emftext.test.cct4.Root1> {
	
	private org.emftext.test.cct4.resource.cct4.analysis.Cct4DefaultResolverDelegate<org.emftext.test.cct4.SubSubChild, org.emftext.test.cct4.Root1> delegate = new org.emftext.test.cct4.resource.cct4.analysis.Cct4DefaultResolverDelegate<org.emftext.test.cct4.SubSubChild, org.emftext.test.cct4.Root1>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.cct4.SubSubChild container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.test.cct4.resource.cct4.ICct4ReferenceResolveResult<org.emftext.test.cct4.Root1> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.test.cct4.Root1 element, org.emftext.test.cct4.SubSubChild container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
