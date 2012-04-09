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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;

/**
 * An analyser that issues a warning for each non-containment reference that has
 * a non-containment opposite.
 */
public class OppositeReferenceAnalyser extends AbstractPostProcessor {

	private static final String NON_CONTAINMENT_OPPOSITE_WARNING = 
		"Feature %s has a non-containment opposite feature. The opposite is only established after reference resolving: %s";
	
	@Override
	public void analyse(ConcreteSyntax syntax) {
		// maps references that have syntax and a non-containment opposite to
		// the rule which defined the syntax for the reference
		Map<EReference, Set<Rule>> referencesWithSyntaxAndNCOpposite = new LinkedHashMap<EReference, Set<Rule>>();
		
		Iterator<EObject> iterator = syntax.eAllContents();
		while (iterator.hasNext()) {
			final EObject next = iterator.next();
			if (next instanceof Placeholder) {
				Placeholder placeholder = (Placeholder) next;
				if(placeholder.getFeature() != null &&
						placeholder.getFeature().getEcoreFeature() instanceof EReference) {
					EReference reference = (EReference) placeholder.getFeature().getEcoreFeature();
					EReference opposite = reference.getEOpposite();
					if (opposite != null) {
						if (!opposite.isContainment()) {
							if (!referencesWithSyntaxAndNCOpposite.containsKey(reference)) {
								referencesWithSyntaxAndNCOpposite.put(reference, new LinkedHashSet<Rule>());
							}
							referencesWithSyntaxAndNCOpposite.get(reference).add(placeholder.getContainingRule());
						}
					}
				}
			}
		}
		
		for (EReference reference : referencesWithSyntaxAndNCOpposite.keySet()) {
			
			EReference opposite = reference.getEOpposite();
			//it is ok, if the opposite itself has syntax through which a proxy is produced during parsing
			if (!referencesWithSyntaxAndNCOpposite.keySet().contains(opposite)) {
				Set<Rule> containingRules = referencesWithSyntaxAndNCOpposite.get(reference);
				String message = String.format(
						NON_CONTAINMENT_OPPOSITE_WARNING, 
						reference.getName(),
						opposite.getEContainingClass().getName() + "." + opposite.getName()
				);
				for (Rule containingRule : containingRules) {
					addProblem(
							CsAnalysisProblemType.NON_CONTAINMENT_OPPOSITE,
							message,
							containingRule);
				}
			}
		}
	}

}
