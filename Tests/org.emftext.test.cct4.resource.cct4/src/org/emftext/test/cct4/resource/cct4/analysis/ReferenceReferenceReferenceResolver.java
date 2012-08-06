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

public class ReferenceReferenceReferenceResolver implements org.emftext.test.cct4.resource.cct4.ICct4ReferenceResolver<org.emftext.test.cct4.Reference, org.emftext.test.cct4.Target> {
	
	private org.emftext.test.cct4.resource.cct4.analysis.Cct4DefaultResolverDelegate<org.emftext.test.cct4.Reference, org.emftext.test.cct4.Target> delegate = new org.emftext.test.cct4.resource.cct4.analysis.Cct4DefaultResolverDelegate<org.emftext.test.cct4.Reference, org.emftext.test.cct4.Target>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.cct4.Reference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.test.cct4.resource.cct4.ICct4ReferenceResolveResult<org.emftext.test.cct4.Target> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.test.cct4.Target element, org.emftext.test.cct4.Reference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
