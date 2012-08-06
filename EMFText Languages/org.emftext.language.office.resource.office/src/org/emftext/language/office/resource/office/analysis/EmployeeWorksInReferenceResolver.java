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
package org.emftext.language.office.resource.office.analysis;

import org.emftext.language.office.resource.office.IOfficeReferenceResolveResult;
import org.emftext.language.office.resource.office.IOfficeReferenceResolver;

public class EmployeeWorksInReferenceResolver implements IOfficeReferenceResolver<org.emftext.language.office.Employee, org.emftext.language.office.Office> {

	private org.emftext.language.office.resource.office.analysis.OfficeDefaultResolverDelegate<org.emftext.language.office.Employee, org.emftext.language.office.Office> delegate = new org.emftext.language.office.resource.office.analysis.OfficeDefaultResolverDelegate<org.emftext.language.office.Employee, org.emftext.language.office.Office>();

	public void resolve(java.lang.String identifier, org.emftext.language.office.Employee container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IOfficeReferenceResolveResult<org.emftext.language.office.Office> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.office.Office element, org.emftext.language.office.Employee container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
	}
}
