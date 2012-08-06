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
package org.emftext.language.emfdoc.resource.emfdoc.analysis;

public class DocumentationDocumentedPackageReferenceResolver implements org.emftext.language.emfdoc.resource.emfdoc.IEmfdocReferenceResolver<org.emftext.language.emfdoc.Documentation, org.eclipse.emf.ecore.EPackage> {
	
	private org.emftext.language.emfdoc.resource.emfdoc.analysis.EmfdocDefaultResolverDelegate<org.emftext.language.emfdoc.Documentation, org.eclipse.emf.ecore.EPackage> delegate = new org.emftext.language.emfdoc.resource.emfdoc.analysis.EmfdocDefaultResolverDelegate<org.emftext.language.emfdoc.Documentation, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.emfdoc.Documentation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.emfdoc.resource.emfdoc.IEmfdocReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EPackage element, org.emftext.language.emfdoc.Documentation container, org.eclipse.emf.ecore.EReference reference) {
		return element.eResource().getURI().toString();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
