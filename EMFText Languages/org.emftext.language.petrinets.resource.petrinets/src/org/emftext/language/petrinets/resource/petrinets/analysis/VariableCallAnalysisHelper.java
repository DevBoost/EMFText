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
package org.emftext.language.petrinets.resource.petrinets.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.petrinets.ConsumingArc;
import org.emftext.language.petrinets.ProducingArc;
import org.emftext.language.petrinets.Statement;
import org.emftext.language.petrinets.Transition;
import org.emftext.language.petrinets.Variable;

public class VariableCallAnalysisHelper {

	private List<Variable> collectCandidates(EObject container,
			boolean resolveFuzzy) {
		List<Variable> candidates = new ArrayList<Variable>();
		EList<ConsumingArc> arc = getConsumingArcs(container);
		for (ConsumingArc consuming : arc) {
			candidates.add(consuming.getFreeVariable());
		}

		List<Statement> previousStatements = getPreviousStatements(container);
		for (Statement arcStatement : previousStatements) {
			if (arcStatement instanceof Variable) {
				candidates.add((Variable) arcStatement);
			}
		}

		return candidates;
	}

	private List<Statement> getPreviousStatements(EObject container) {
		List<Statement> previousStatements = new ArrayList<Statement>();
		EObject c = container.eContainer();
		EObject containingStatement = container;
		while (!(c instanceof Transition) && !(c instanceof ProducingArc)
				&& c != null) {
			containingStatement = c;
			c = c.eContainer();
		}
		if (c != null && c instanceof Transition) {
			Transition containing = (Transition) c;
			int indexOfContainingStatement = containing.getStatements()
					.indexOf(containingStatement);
			if (indexOfContainingStatement > 0)
				previousStatements = containing.getStatements().subList(0,
						indexOfContainingStatement);
		}
		if (c != null && c instanceof ProducingArc) {
			ProducingArc pa = (ProducingArc) c;
			Transition in = pa.getIn();
			previousStatements = in.getStatements();
		}
		return previousStatements;
	}

	private EList<ConsumingArc> getConsumingArcs(EObject container) {
		EObject c = container.eContainer();
		while (!(c instanceof ProducingArc) && !(c instanceof Transition)
				&& c != null) {
			c = c.eContainer();
		}
		if (c != null) {
			if (c instanceof Transition) {
				Transition t = (Transition) c;
				return t.getIncoming();
			}
			if (c instanceof ProducingArc) {
				ProducingArc producing = (ProducingArc) c;
				Transition t = producing.getIn();
				return t.getIncoming();
			}

		}
		return null;
	}

	public List<Variable> collectFilteredCandidates(EObject container,
			boolean resolveFuzzy, String identifier) {
		List<Variable> candidates = collectCandidates(container, resolveFuzzy);

		return FilterCandidates(candidates, identifier, resolveFuzzy, container);
	}

	private List<Variable> FilterCandidates(List<Variable> candidates,
			String identifier, boolean resolveFuzzy, EObject container) {
		List<Variable> filtered = new ArrayList<Variable>();
		for (Variable candidate : candidates) {
			if (resolveFuzzy) {
				filtered.add(candidate);
			} else {
				if (candidate.getName().equals(identifier)) {
					filtered.add(candidate);
					return filtered;
				}
			}
		}
		return filtered;
	}

}
