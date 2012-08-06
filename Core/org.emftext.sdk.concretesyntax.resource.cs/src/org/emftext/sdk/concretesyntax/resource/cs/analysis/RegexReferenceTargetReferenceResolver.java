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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.NamedTokenDefinition;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class RegexReferenceTargetReferenceResolver implements ICsReferenceResolver<RegexReference, NamedTokenDefinition> {
	
	public void resolve(String identifier, RegexReference container, EReference reference, int position, boolean resolveFuzzy, final ICsReferenceResolveResult<NamedTokenDefinition> result) {
		ConcreteSyntax syntax = findRoot(container);
		if (syntax == null) {
			return;
		}
		Collection<NamedTokenDefinition> tokenDefinitions = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getNamedTokenDefinition());
		for (NamedTokenDefinition tokenDefinition : tokenDefinitions) {
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
		EList<Import> imports = syntax.getImports();
		for (Import i : imports) {
			ConcreteSyntax imported = i.getConcreteSyntax();
			if (imported == null) {
				continue;
			}
			Collection<NamedTokenDefinition> tokenDefs = CsEObjectUtil.getObjectsByType(imported.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getNamedTokenDefinition());
			for (NamedTokenDefinition namedTokenDefinition : tokenDefs) {
				String prefixedTokenName = i.getPrefix() +"." + namedTokenDefinition.getName();
				if (resolveFuzzy) {
					result.addMapping(prefixedTokenName, namedTokenDefinition);
				} else {
					if (prefixedTokenName.equals(identifier)) {
						result.addMapping(prefixedTokenName, namedTokenDefinition);
						return;
					}
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

	public String deResolve(NamedTokenDefinition element, RegexReference container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
	}
}
