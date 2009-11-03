/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that issues a warning for each non-containment reference that has
 * a non-containment opposite.
 */
public class OppositeReferenceAnalyser extends AbstractPostProcessor {

	private static final String NON_CONTAINMENT_OPPOSITE_WARNING = 
		"Feature has a non-containment opposite feature. The opposite is only established after reference resolving: ";
	
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		List<EReference> referencesWithSyntaxAndNCOpposite = new ArrayList<EReference>();
		
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
							referencesWithSyntaxAndNCOpposite.add(reference);
						}
					}
				}
			}
		}
		
		for(EReference reference : referencesWithSyntaxAndNCOpposite) {
			
			EReference opposite = reference.getEOpposite();
			//it is ok, if the opposite itself has syntax through which a proxy is produced during parsing
			if(!referencesWithSyntaxAndNCOpposite.contains(opposite)) {
				addProblem(
						resource,
						ECsProblemType.NON_CONTAINMENT_OPPOSITE,
						NON_CONTAINMENT_OPPOSITE_WARNING + 
						opposite.getEContainingClass().getName() +
						"." +
						opposite.getName(),
						reference);	
			}
		}
	}

}
