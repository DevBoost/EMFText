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
package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that looks for features that are multiply used in 
 * syntax rules. The mapping of elements to one occurrence of the other
 * is not reflected in the models after parsing and can thus cause a 
 * result different from the original text after printing.
 */
public class DuplicateReferenceAnalyser extends AbstractPostProcessor {

	private static final String MULTIPLE_FEATURE_WARNING = 
		"The feature is used multiple times. Reprinting may fail for feature: ";
	
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		Iterator<EObject> iterator = syntax.eAllContents();
		while (iterator.hasNext()) {
			final EObject next = iterator.next();
			if (next instanceof Rule) {
				final Rule rule = (Rule) next;
				final List<Terminal> terminals = collectAllTerminals(rule);
				for (Terminal terminal : terminals) {
					final GenFeature feature = terminal.getFeature();
					if (canCauseReprintProblem(rule.getDefinition(), feature)) {
						addProblem(
								resource,
								ECsProblemType.MULTIPLE_FEATURE_USE,
								MULTIPLE_FEATURE_WARNING + feature.getName(),
								terminal);
					}
				}
			}
		}
	}

	/**
	 * A feature causes a reprint problem if it appears multiple times in the
	 * definition of a rule and if a star or question mark appearance is followed
	 * by another appearance.
	 * 
	 * Valid sequences of cardinalities are: 1-*, 1-1-*, 1-1-1-*.
	 * Invalid sequences of cardinalities are: ?-*, *-*, *-?, *-1.
	 * 
	 * @param definition
	 * @param feature
	 * @return
	 */
	private boolean canCauseReprintProblem(Choice choice, GenFeature feature) {
		return countProblematicOccurrences(choice, feature, false, false) > 1;
	}
	
	/**
	 * Counts the problematic occurrences of the given feature in a depth first
	 * manner. Occurrences are problematic if they either have a cardinality of 
	 * star or question mark or if a star or question mark occurrence was found 
	 * before (i.e., earlier in the traversal process).
	 * 
	 * @param choice
	 * @param feature
	 * @param foundStarOrOptionalBefore
	 * @return
	 */
	private int countProblematicOccurrences(Choice choice, GenFeature feature, boolean foundStarOrOptionalBefore, boolean hasOptionalParent) {
		int occurences = 0;
		
		List<Sequence> choices = choice.getOptions();
		for (Sequence sequence : choices) {
			List<Definition> definitions = sequence.getParts();
			for (Definition definition : definitions) {
				// incorporate cardinality of the definition
				Cardinality cardinality = null;
				
				boolean isStarOrOptional = hasOptionalParent;
				if (definition instanceof CardinalityDefinition) {
					cardinality = ((CardinalityDefinition) definition).getCardinality();
					isStarOrOptional |= cardinality instanceof STAR || cardinality instanceof QUESTIONMARK;
				}
				if (definition instanceof Terminal) {
					Terminal terminal = (Terminal) definition;
					if (terminal.getFeature() == feature) {
						if (isStarOrOptional || foundStarOrOptionalBefore) {
							occurences++;
						}
					}
				} else if (definition instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) definition;
					Choice subChoice = compound.getDefinition();
					// recursive method call
					occurences += countProblematicOccurrences(subChoice, feature, occurences > 0, isStarOrOptional);
				}
			}
		}
		return occurences;
	}

	private List<Terminal> collectAllTerminals(Rule rule) {
		return collectAllTerminals(rule.getDefinition());
	}
	
	private List<Terminal> collectAllTerminals(Choice choice) {
		List<Terminal> result = new ArrayList<Terminal>();
		List<Sequence> choices = choice.getOptions();
		for (Sequence sequence : choices) {
			List<Definition> definitions = sequence.getParts();
			for (Definition definition : definitions) {
				if (definition instanceof Terminal) {
					Terminal terminal = (Terminal) definition;
					result.add(terminal);
				} else if (definition instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) definition;
					Choice subChoice = compound.getDefinition();
					result.addAll(collectAllTerminals(subChoice));
				}
			}
		}
		return result;
	}
}
