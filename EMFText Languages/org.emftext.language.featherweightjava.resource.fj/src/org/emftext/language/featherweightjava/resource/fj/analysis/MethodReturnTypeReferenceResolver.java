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
package org.emftext.language.featherweightjava.resource.fj.analysis;

import org.emftext.language.featherweightjava.resource.fj.analysis.helper.ClassResolver;

public class MethodReturnTypeReferenceResolver implements org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolver<org.emftext.language.featherweightjava.Method, org.emftext.language.featherweightjava.Class> {

	private ClassResolver delegate = new ClassResolver();

	public void resolve(java.lang.String identifier, org.emftext.language.featherweightjava.Method container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweightjava.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.featherweightjava.Class element, org.emftext.language.featherweightjava.Method container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {

	}

}
