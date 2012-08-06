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
package org.emftext.language.lwc11.resource.lwc11.analysis;

public class EntityModelImportsReferenceResolver implements org.emftext.language.lwc11.resource.lwc11.ILwc11ReferenceResolver<org.emftext.language.lwc11.EntityModel, org.emftext.language.lwc11.EntityModel> {
	
	private org.emftext.language.lwc11.resource.lwc11.analysis.Lwc11DefaultResolverDelegate<org.emftext.language.lwc11.EntityModel, org.emftext.language.lwc11.EntityModel> delegate = new org.emftext.language.lwc11.resource.lwc11.analysis.Lwc11DefaultResolverDelegate<org.emftext.language.lwc11.EntityModel, org.emftext.language.lwc11.EntityModel>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.lwc11.EntityModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.lwc11.resource.lwc11.ILwc11ReferenceResolveResult<org.emftext.language.lwc11.EntityModel> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.lwc11.EntityModel element, org.emftext.language.lwc11.EntityModel container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
