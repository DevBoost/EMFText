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
package org.emftext.language.statemachine.resource.statemachine.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.emftext.language.statemachine.resource.statemachine.IStatemachineReferenceResolveResult;
import org.emftext.language.statemachine.resource.statemachine.IStatemachineReferenceResolver;

public class TransitionSourceReferenceResolver implements
	IStatemachineReferenceResolver<Transition, Vertex> {

	public java.lang.String deResolve(Vertex element, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void resolve(String identifier, Transition container, EReference reference, int position, boolean resolveFuzzy, IStatemachineReferenceResolveResult<Vertex> result) {

		for (Vertex sourceCand : container.getContainer().getSubvertices()) {
			if (sourceCand.getName().equals(identifier) || resolveFuzzy) {
				result.addMapping(sourceCand.getName(), sourceCand);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
