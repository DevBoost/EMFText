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
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class RegexReferenceTargetReferenceResolver implements ICsReferenceResolver<RegexReference, AbstractTokenDefinition> {
	
	public void resolve(String identifier, RegexReference container, EReference reference, int position, boolean resolveFuzzy, final ICsReferenceResolveResult<AbstractTokenDefinition> result) {
		ConcreteSyntax syntax = findRoot(container);
		if (syntax == null) {
			return;
		}
		Collection<AbstractTokenDefinition> tokenDefinitions = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getAbstractTokenDefinition());
		for (AbstractTokenDefinition tokenDefinition : tokenDefinitions) {
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

	public String deResolve(AbstractTokenDefinition element, RegexReference container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
	}
}
