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
package org.emftext.language.office2.resource.office2.analysis;

public class EmployeeWorksInReferenceResolver implements org.emftext.language.office2.resource.office2.IOffice2ReferenceResolver<org.emftext.language.office2.Employee, org.emftext.language.office2.Office> {

	private org.emftext.language.office2.resource.office2.analysis.Office2DefaultResolverDelegate<org.emftext.language.office2.Employee, org.emftext.language.office2.Office> delegate = new org.emftext.language.office2.resource.office2.analysis.Office2DefaultResolverDelegate<org.emftext.language.office2.Employee, org.emftext.language.office2.Office>();

	public void resolve(java.lang.String identifier, org.emftext.language.office2.Employee container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.office2.resource.office2.IOffice2ReferenceResolveResult<org.emftext.language.office2.Office> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.office2.Office element, org.emftext.language.office2.Employee container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
