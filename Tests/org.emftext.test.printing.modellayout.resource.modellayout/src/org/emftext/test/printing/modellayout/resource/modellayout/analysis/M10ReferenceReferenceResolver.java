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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.printing.modellayout.resource.modellayout.analysis;

public class M10ReferenceReferenceResolver implements org.emftext.test.printing.modellayout.resource.modellayout.IModellayoutReferenceResolver<org.emftext.test.printing.modellayout.M10, org.emftext.test.printing.modellayout.M10> {
	
	private org.emftext.test.printing.modellayout.resource.modellayout.analysis.ModellayoutDefaultResolverDelegate<org.emftext.test.printing.modellayout.M10, org.emftext.test.printing.modellayout.M10> delegate = new org.emftext.test.printing.modellayout.resource.modellayout.analysis.ModellayoutDefaultResolverDelegate<org.emftext.test.printing.modellayout.M10, org.emftext.test.printing.modellayout.M10>();
	
	public void resolve(String identifier, org.emftext.test.printing.modellayout.M10 container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.test.printing.modellayout.resource.modellayout.IModellayoutReferenceResolveResult<org.emftext.test.printing.modellayout.M10> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.test.printing.modellayout.M10 element, org.emftext.test.printing.modellayout.M10 container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
