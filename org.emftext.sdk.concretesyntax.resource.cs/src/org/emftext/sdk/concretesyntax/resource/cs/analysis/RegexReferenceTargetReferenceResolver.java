/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class RegexReferenceTargetReferenceResolver implements org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.TokenDefinition> {
	
	public void resolve(java.lang.String identifier, org.emftext.sdk.concretesyntax.RegexReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<org.emftext.sdk.concretesyntax.TokenDefinition> result) {
		ConcreteSyntax syntax = findRoot(container);
		if (syntax == null) {
			return;
		}
		Collection<TokenDefinition> tokenDefinitions = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTokenDefinition());
		for (TokenDefinition tokenDefinition : tokenDefinitions) {
			String name = tokenDefinition.getName();
			if (resolveFuzzy) {
				result.addMapping(name, tokenDefinition);
			} else {
				if (name != null && name.equals(identifier)) {
					result.addMapping(identifier, tokenDefinition);
					return;
				}
			}
		}
	}
	
	private ConcreteSyntax findRoot(EObject object) {
		if (object instanceof ConcreteSyntax) {
			return (ConcreteSyntax) object;
		} else {
			EObject parent = object.eContainer();
			if (parent == null) {
				return null;
			} else {
				return findRoot(parent);
			}
		}
	}

	public java.lang.String deResolve(org.emftext.sdk.concretesyntax.TokenDefinition element, org.emftext.sdk.concretesyntax.RegexReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
