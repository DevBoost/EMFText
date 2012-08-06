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
package org.emftext.language.dot.resource.dot.analysis;

public class EdgeStatementSourceReferenceResolver implements org.emftext.language.dot.resource.dot.IDotReferenceResolver<org.emftext.language.dot.EdgeStatement, org.emftext.language.dot.Connectable> {
	
	private org.emftext.language.dot.resource.dot.analysis.DotDefaultResolverDelegate<org.emftext.language.dot.EdgeStatement, org.emftext.language.dot.Connectable> delegate = new org.emftext.language.dot.resource.dot.analysis.DotDefaultResolverDelegate<org.emftext.language.dot.EdgeStatement, org.emftext.language.dot.Connectable>();
	
	public void resolve(String identifier, org.emftext.language.dot.EdgeStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.dot.resource.dot.IDotReferenceResolveResult<org.emftext.language.dot.Connectable> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.dot.Connectable element, org.emftext.language.dot.EdgeStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
