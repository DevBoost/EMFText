/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.CardinalityComputer;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.MinMax;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.EObjectUtil;

/**
 * An analyser that looks for features that are multiply used in 
 * syntax rules. The mapping of elements to one occurrence of the other
 * is not reflected in the models after parsing and can thus cause a 
 * result different from the original text after printing.
 * 
 * TODO once the printer does handle type restrictions for containments
 * correctly, this analyzer should take the restrictions into account
 * when detecting problems of duplicate features.
 */
public class DuplicateFeatureAnalyser extends AbstractPostProcessor {

	private static final String MULTIPLE_FEATURE_WARNING = 
		"The feature is used multiple times. Reprinting may fail for feature: ";
	
	@Override
	public void analyse(ConcreteSyntax syntax) {
		for (Rule rule : syntax.getRules()) {
			Collection<Terminal> allTerminals = collectAllTerminals(rule);
			Map<GenFeature, Set<Terminal>> featureToTerminalsMap = groupTerminalsByFeature(allTerminals);
			for (GenFeature feature : featureToTerminalsMap.keySet()) {
				if (ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE.equals(feature)) {
					// do not analyse the anonymous features as they are not
					// printed anyway
					continue;
				}
				Set<Terminal> terminals = featureToTerminalsMap.get(feature);
				if (terminals.size() < 2) {
					// if there is only one terminal that refers to 'feature'
					// we can skip the analysis for this terminal as there can
					// not be any conflicts
					continue;
				}
				if (canCauseReprintProblem(rule.getDefinition(), feature)) {
					for (Terminal terminal : terminals) {
						addProblem(
								CsAnalysisProblemType.MULTIPLE_FEATURE_USE,
								MULTIPLE_FEATURE_WARNING + feature.getName(),
								terminal);
					}
				}
			}
		}
	}

	/**
	 * A feature causes a reprint problem if it appears multiple times in the
	 * definition of a rule and if a star, plus or question mark appearance is 
	 * followed by another appearance. This problem is due to the fact, that
	 * the printer does know from which syntax element the feature values stem
	 * from. Thus, during printing the values of feature may be printer to 
	 * different position in the text than the one they were parsed at.
	 * 
	 * Valid sequences of cardinalities are: 1-*, 1-1-?, 1-1-1-+.
	 * Invalid sequences of cardinalities are: ?-*, +-*, *-?, *-1.
	 * 
	 * @param choice the root of the syntax tree to analyse
	 * @param feature the feature to analyse
	 * @return true if the given feature is problematic wrt. the given syntax tree
	 */
	private boolean canCauseReprintProblem(Choice choice, GenFeature feature) {
		return countProblematicOccurrences(choice, feature, false) > 1;
	}
	
	/**
	 * Counts the problematic occurrences of the given feature in a depth first
	 * manner. Occurrences are problematic if they either have a cardinality of 
	 * star or question mark or if a star or question mark occurrence was found 
	 * before (i.e., earlier in the traversal process).
	 * 
	 * @param choice the root of the syntax tree to analyse
	 * @param feature the feature to analyse
	 * @param foundStarOrOptionalOrPlusBefore indicates whether an occurrence of
	 *        the feature with a cardinality +,* or ? was found before while 
	 *        traversing the syntax tree
	 * @return the number of problematic occurrences
	 */
	private int countProblematicOccurrences(Choice choice, GenFeature feature, boolean foundStarOrOptionalOrPlusBefore) {
		int occurences = 0;
		
		List<Sequence> choices = choice.getOptions();
		for (Sequence sequence : choices) {
			List<Definition> definitions = sequence.getParts();
			for (Definition definition : definitions) {
				// incorporate cardinality of the definition
				Cardinality cardinality = Cardinality.NONE;
				
				MinMax totalCardinality = null;
				if (definition instanceof Terminal) {
					Terminal terminal = (Terminal) definition;
					Set<Terminal> thisAndNextTerminal = new LinkedHashSet<Terminal>();
					thisAndNextTerminal.add(terminal);
					thisAndNextTerminal.add(findNextTerminal(terminal));
					Choice root = findCommonRoot(thisAndNextTerminal);
					totalCardinality = new CardinalityComputer().getTotalCardinality(definition, root);
				}
				boolean isStarOrOptional = false;
				if (totalCardinality != null) {
					isStarOrOptional = totalCardinality.getMin() == 0 || totalCardinality.getMax() < 0;
				}
				if (definition instanceof CardinalityDefinition) {
					cardinality = ((CardinalityDefinition) definition).getCardinality();
					isStarOrOptional |= cardinality == Cardinality.STAR || cardinality == Cardinality.QUESTIONMARK;
				}
				if (definition instanceof Terminal) {
					Terminal terminal = (Terminal) definition;
					if (terminal.getFeature() == feature) {
						if (isStarOrOptional || foundStarOrOptionalOrPlusBefore) {
							occurences++;
						}
					}
				} else if (definition instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) definition;
					Choice subChoice = compound.getDefinition();
					// recursive method call
					occurences += countProblematicOccurrences(subChoice, feature, occurences > 0);
				}
			}
		}
		return occurences;
	}

	/**
	 * Traverses the syntax the given terminal is part of and
	 * returns the next terminal that refers to the same feature
	 * as 'terminal'.
	 * 
	 * @param terminal
	 * @return
	 */
	private Terminal findNextTerminal(Terminal terminal) {
		Rule rule = terminal.getContainingRule();
		TreeIterator<EObject> iterator = rule.eAllContents();
		boolean foundDefinition = false;
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (foundDefinition && next instanceof Terminal) {
				Terminal candidate = (Terminal) next;
				if (candidate.getFeature() == terminal.getFeature()) {
					return candidate;
				}
			}
			if (next == terminal) {
				foundDefinition = true;
			}
		}
		return null;
	}

	/**
	 * Returns all terminals in rule.
	 * 
	 * @param rule the rule to search in
	 * @return
	 */
	private Collection<Terminal> collectAllTerminals(Rule rule) {
		Choice definition = rule.getDefinition();
		Collection<Terminal> result = EObjectUtil.getObjectsByType(definition.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		return result;
	}
	
	/**
	 * Finds the most specific node in the syntax tree, which contains
	 * all terminals in the given set.
	 * 
	 * @param terminals
	 * @return
	 */
	private Choice findCommonRoot(Set<Terminal> terminals) {
		EObject ancestor = null;
		for (Terminal terminal : terminals) {
			if (ancestor == null) {
				ancestor = terminal;
			}
			while (ancestor != null) {
				if (EcoreUtil.isAncestor(ancestor, terminal) && ancestor instanceof Choice) {
					break;
				}
				ancestor = ancestor.eContainer();
			}
		}
		if (ancestor instanceof Choice) {
			return (Choice) ancestor;
		}
		return null;
	}

	private Map<GenFeature, Set<Terminal>> groupTerminalsByFeature(
			Collection<Terminal> allTerminals) {
		
		Map<GenFeature, Set<Terminal>> groupedTerminals = new LinkedHashMap<GenFeature, Set<Terminal>>();
		for (Terminal terminal : allTerminals) {
			GenFeature feature = terminal.getFeature();
			if (!groupedTerminals.containsKey(feature)) {
				groupedTerminals.put(feature, new LinkedHashSet<Terminal>());
			}
			groupedTerminals.get(feature).add(terminal);
		}
		return groupedTerminals;
	}
}
