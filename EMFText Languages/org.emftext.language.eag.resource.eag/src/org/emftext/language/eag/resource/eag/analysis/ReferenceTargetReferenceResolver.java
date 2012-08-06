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
package org.emftext.language.eag.resource.eag.analysis;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.eag.Computation;
import org.emftext.language.eag.EagPackage;
import org.emftext.language.eag.Expression;
import org.emftext.language.eag.ExpressionChain;
import org.emftext.language.eag.Reference;
import org.emftext.language.eag.TypedElement;
import org.emftext.language.eag.Variable;
import org.emftext.language.eag.resource.eag.IEagReferenceResolveResult;
import org.emftext.language.eag.resource.eag.IEagReferenceResolver;
import org.emftext.language.eag.resource.eag.util.EagEObjectUtil;

public class ReferenceTargetReferenceResolver implements IEagReferenceResolver<Reference, EObject> {
	
	public void resolve(String identifier, Reference container, EReference reference, int position, boolean resolveFuzzy, final IEagReferenceResolveResult<EObject> result) {
		EObject parent = container.eContainer();
		if (parent instanceof ExpressionChain) {
			ExpressionChain chain = (ExpressionChain) parent;
			Expression previous = chain.getPrevious();
			Expression next = chain.getNext();
			if (next == container) {
				// this is a feature reference
				if (previous instanceof TypedElement) {
					TypedElement typedElement = (TypedElement) previous;
					EClass type = typedElement.getType();
					assert type != null;
					EList<EStructuralFeature> features = type.getEAllStructuralFeatures();
					for (EStructuralFeature feature : features) {
						String name = feature.getName();
						if (resolveFuzzy || identifier.equals(name)) {
							result.addMapping(name, feature);
							if (!resolveFuzzy) {
								return;
							}
						}
					}
				}
			}
		}
		// this is a variable reference
		Collection<Variable> variablesInScope = findVariables(container);
		for (Variable variable : variablesInScope) {
			String name = variable.getName();
			if (resolveFuzzy || identifier.equals(name)) {
				result.addMapping(name, variable);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}
	
	private Collection<Variable> findVariables(EObject node) {
		EObject parent = node;
		while (parent != null) {
			if (parent instanceof Computation) {
				break;
			}
			parent = parent.eContainer();
		}
		if (parent == null) {
			Collections.emptyList();
		}
		Collection<Variable> variables = EagEObjectUtil.getObjectsByType(parent.eAllContents(), EagPackage.eINSTANCE.getVariable());
		return variables;
	}

	public String deResolve(EObject element, Reference container, EReference reference) {
		if (element instanceof Variable) {
			Variable variable = (Variable) element;
			return variable.getName();
		} else if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) element;
			return feature.getName();
		}
		return null;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
