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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.prolog.Clause;
import org.emftext.language.prolog.Variable;
import org.emftext.language.prolog.VariableReference;

public class VariableReferenceVariableReferenceResolver implements org.emftext.language.prolog.resource.pl.IPlReferenceResolver<org.emftext.language.prolog.VariableReference, org.emftext.language.prolog.Variable> {
	
	private org.emftext.language.prolog.resource.pl.analysis.PlDefaultResolverDelegate<org.emftext.language.prolog.VariableReference, org.emftext.language.prolog.Variable> delegate = new org.emftext.language.prolog.resource.pl.analysis.PlDefaultResolverDelegate<org.emftext.language.prolog.VariableReference, org.emftext.language.prolog.Variable>();
	
	public void resolve(String identifier, org.emftext.language.prolog.VariableReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.prolog.resource.pl.IPlReferenceResolveResult<org.emftext.language.prolog.Variable> result) {
		Clause clause = getClause(container);
		if(clause != null){
			List<Variable> variables = getChildrenInHierarchy(clause, Variable.class);
			for (Variable variable : variables) {
				if(resolveFuzzy){
					result.addMapping(variable.getName(), variable);
				} else {
					if(variable.getName().equals(identifier)){
						result.addMapping(identifier, variable);
						return;
					}
				}
			}
		} else {
			result.setErrorMessage(identifier + " is not a variable in this clause");
		}
	}
	
	private <T> List<T> getChildrenInHierarchy(EObject parent, Class<T> clazz){
		List<T> children = new ArrayList<T>();
		Iterator<EObject> iterator = parent.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = (EObject) iterator.next();
			if(clazz.isInstance(eObject)){
				children.add(clazz.cast(eObject));
			}
		}
		return children;
	}
	
	private Clause getClause(VariableReference container) {
		EObject parent = container.eContainer();
		while (parent != null && !(parent instanceof Clause)) {
			parent = parent.eContainer();
		}
		return (Clause) parent;
	}

	public String deResolve(org.emftext.language.prolog.Variable element, org.emftext.language.prolog.VariableReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
