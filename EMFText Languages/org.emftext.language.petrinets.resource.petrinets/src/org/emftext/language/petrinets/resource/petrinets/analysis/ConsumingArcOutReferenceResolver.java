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
package org.emftext.language.petrinets.resource.petrinets.analysis;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.petrinets.Component;
import org.emftext.language.petrinets.PetriNet;
import org.emftext.language.petrinets.Transition;

public class ConsumingArcOutReferenceResolver
		implements
		org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolver<org.emftext.language.petrinets.ConsumingArc, org.emftext.language.petrinets.Transition> {

	private org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.ConsumingArc, org.emftext.language.petrinets.Transition> delegate = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.ConsumingArc, org.emftext.language.petrinets.Transition>();

	public void resolve(
			String identifier,
			org.emftext.language.petrinets.ConsumingArc container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<org.emftext.language.petrinets.Transition> result) {
		PetriNet pn = (PetriNet) container.eContainer();
		EList<Component> components = pn.getComponents();
		for (Component component : components) {
			if (component instanceof Transition) {
				if (resolveFuzzy) {
					result.addMapping(component.getName(),
							(Transition) component);
				} else if (component.getName().equals(identifier)) {
					result.addMapping(component.getName(),
							(Transition) component);
					return;
				}
			}
		}
	}

	public String deResolve(org.emftext.language.petrinets.Transition element,
			org.emftext.language.petrinets.ConsumingArc container,
			org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend
		// on any option
	}

}
