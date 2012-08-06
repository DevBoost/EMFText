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
package org.emftext.language.company.resource.company.analysis;

public class EmployeeMentorReferenceResolver implements org.emftext.language.company.resource.company.ICompanyReferenceResolver<org.emftext.language.company.Employee, org.emftext.language.company.Employee> {
	
	private org.emftext.language.company.resource.company.analysis.CompanyDefaultResolverDelegate<org.emftext.language.company.Employee, org.emftext.language.company.Employee> delegate = new org.emftext.language.company.resource.company.analysis.CompanyDefaultResolverDelegate<org.emftext.language.company.Employee, org.emftext.language.company.Employee>();
	
	public void resolve(String identifier, org.emftext.language.company.Employee container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.company.resource.company.ICompanyReferenceResolveResult<org.emftext.language.company.Employee> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.company.Employee element, org.emftext.language.company.Employee container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
