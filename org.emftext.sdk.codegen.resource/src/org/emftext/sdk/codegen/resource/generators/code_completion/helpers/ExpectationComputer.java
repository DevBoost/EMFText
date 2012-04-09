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
package org.emftext.sdk.codegen.resource.generators.code_completion.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.EObjectUtil;

/**
 * The ExpectationComputer can be used to compute all possible elements that can 
 * follow a given element in a syntax. It uses the well-known construction of 
 * FIRST and FOLLOW sets from context-free grammars.
 * 
 * Instances of this class can be reused for multiple computations of FIRST and 
 * FOLLOW sets if the concrete syntax did not change. If the syntax has changed, 
 * a fresh instance must be used, because the ExpectationComputer does hold 
 * internal caches, which can yield invalid results.
 */
public class ExpectationComputer {

	// a constant used to represent the empty sentence
	public final static EObject EPSILON_OBJECT = new DynamicEObjectImpl() {
		public String toString() {
			return "EPSILON";
		}
	};
	public final static Expectation EPSILON = new Expectation(EPSILON_OBJECT) {
		
		public void setMetaClass(GenClass metaClass) {
			// ignore this, the EPSILON does not start at a specific class
		}
		
		public List<ContainmentLink> getContainmentTrace() {
			// we do not save the containment trace for epsilon
			return new ArrayList<ContainmentLink>();
		}
	};

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	/**
	 * A cache for the set of rules that are applicable for a certain GenClass.
	 * This cache is needed because the lookup of the rules is performed very
	 * often and performs quite bad for large syntax definitions.
	 */
	private Map<GenClass, Collection<Rule>> ruleCache = new LinkedHashMap<GenClass, Collection<Rule>>();

	/**
	 * A cache for the rules of the concrete syntax. This avoids repeating (expensive) calls to
	 * ConcreteSyntax.getAllRules(). 
	 */
	private Map<ConcreteSyntax, List<Rule>> rulesMap = new LinkedHashMap<ConcreteSyntax, List<Rule>>();
	
	/**
	 * A cache for the containment elements of the syntax rules. This avoids repeating (expensive) 
	 * searches for these elements. 
	 */
	private Map<Rule, Collection<Containment>> ruleToContainmentsMap = new LinkedHashMap<Rule, Collection<Containment>>();

	/**
	 * Computes the list of elements that 'syntaxElement' can start
	 * with according to the given syntax definition.
	 *
	 * @param syntax
	 * @param syntaxElement
	 * @return
	 */
	public Set<Expectation> computeFirstSet(ConcreteSyntax syntax, SyntaxElement syntaxElement) {
		return computeFirstSet(syntax, syntaxElement, new LinkedHashSet<GenClass>());
	}

	/**
	 * Computes the list of elements that can follow after 'syntaxElement' 
	 * with according to the given syntax definition.
	 *
	 * @param syntax
	 * @param syntaxElement
	 * @return
	 */
	public Set<Expectation> computeFollowSet(ConcreteSyntax syntax, SyntaxElement syntaxElement) {
		Set<Expectation> result = computeFollowSet(syntax, syntaxElement, new LinkedHashSet<Rule>(), new LinkedHashSet<GenClass>());
		return result;
	}

	private Set<Expectation> computeFirstSet(ConcreteSyntax syntax, SyntaxElement syntaxElement, Set<GenClass> contributingNonterminals) {
		Rule rule = syntaxElement.getContainingRule();

		Set<Expectation> firstSet;
		assert rule != null;
		if (syntaxElement instanceof Definition) {
			firstSet = computeFirstSetForDefinition(syntax, rule, (Definition) syntaxElement, contributingNonterminals);
		} else if (syntaxElement instanceof Choice) {
			firstSet = computeFirstSetForChoice(syntax, rule, (Choice) syntaxElement, contributingNonterminals);
		} else if (syntaxElement instanceof Sequence) {
			firstSet = computeFirstSetForSequence(syntax, rule, (Sequence) syntaxElement, contributingNonterminals);
		} else if (syntaxElement instanceof Rule) {
 			firstSet = computeFirstSetForChoice(syntax, rule, rule.getDefinition(), contributingNonterminals);
		} else if (syntaxElement instanceof EnumLiteralTerminal) {
 			firstSet = computeFirstSetForEnumLiteralTerminal((EnumLiteralTerminal) syntaxElement);
		} else {
			throw new IllegalArgumentException(syntaxElement.toString());
		}
		return firstSet;
	}

	private Set<Expectation> computeFirstSetForEnumLiteralTerminal(EnumLiteralTerminal enumTerminal) {
		return Collections.singleton(new Expectation(enumTerminal));
	}

	private Set<Expectation> computeFollowSet(ConcreteSyntax syntax, SyntaxElement syntaxElement, Collection<Rule> usedRules, Set<GenClass> contributingNonterminals) {
		
		Set<Expectation> result = computeFirstSetIfObjectCanBeRepeated(syntax, syntaxElement, contributingNonterminals);

		EObject container = syntaxElement.eContainer();
		if (container == null) {
			return result;
		}
		if (container instanceof ConcreteSyntax) {
			return result;
		}
		if (container instanceof Rule) {
			// find all containments that refer to this rule and
			// compute follow set for these containments. finally add them
			List<Rule> allRules = getAllRules(syntax);
			for (Rule rule : allRules) {
				Collection<Containment> containments = getContainments(rule);
				for (Containment containment : containments) {
					EList<GenClass> allowedSubTypes = containment.getAllowedSubTypes();
					for (GenClass subType : allowedSubTypes) {
						Collection<Rule> subRules;
						if (ruleCache.containsKey(subType)) {
							subRules = ruleCache.get(subType);
						} else {
							subRules = csUtil.getRules(syntax, subType);
							ruleCache.put(subType, subRules);
						}
						// ignore used rules
						if (usedRules.contains(rule)) {
							continue;
						}
						if (subRules.contains(container)) {
							usedRules.add(rule);
							result.addAll(computeFollowSet(syntax, containment, usedRules, contributingNonterminals));
						}
					}
				}
			}
			return result;
		} else if (container instanceof Choice) {
			// we need to skip choices because the other alternatives in
			// a choice must not be included in the FOLLOW set
			result.addAll(computeFollowSet(syntax, (Choice) container, usedRules, contributingNonterminals));
		} else {
			EReference reference = syntaxElement.eContainmentFeature();
			Object children = container.eGet(reference);
			// search the next element to the right in the syntax rule tree
			if (children instanceof List<?>) {
				List<?> childrenList = (List<?>) children;
				int index = childrenList.indexOf(syntaxElement);
				if (childrenList.size() > index + 1) {
					// found an element next right
					SyntaxElement nextInList = (SyntaxElement) childrenList.get(index + 1);
					Set<Expectation> firstSetOfNext = computeFirstSet(syntax, nextInList, contributingNonterminals);
					result.addAll(firstSetOfNext);
					if (firstSetOfNext.contains(EPSILON)) {
						result.addAll(computeFollowSet(syntax, nextInList, usedRules, contributingNonterminals));
					}
				} else {
					// object was the last one in the list,
					// we must try one level higher
					result.addAll(computeFollowSet(syntax, (SyntaxElement) syntaxElement.eContainer(), usedRules, contributingNonterminals));
				}
			} else if (children instanceof EObject) {
				assert syntaxElement == children;
				// object was the only one stored in the reference,
				// we must try one level higher
				result.addAll(computeFollowSet(syntax, (SyntaxElement) syntaxElement.eContainer(), usedRules, contributingNonterminals));
			}
		}
		result.remove(EPSILON);
		return result;
	}


	private Collection<Containment> getContainments(Rule rule) {
		if (ruleToContainmentsMap.containsKey(rule)) {
			return ruleToContainmentsMap.get(rule);
		}
		Collection<Containment> containments = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getContainment());
		ruleToContainmentsMap.put(rule, containments);
		return containments;
	}

	private List<Rule> getAllRules(ConcreteSyntax syntax) {
		if (rulesMap.containsKey(syntax)) {
			return rulesMap.get(syntax);
		}
		EList<Rule> allRules = syntax.getAllRules();
		rulesMap.put(syntax, allRules);
		return allRules;
	}

	private Set<Expectation> computeFirstSetIfObjectCanBeRepeated(ConcreteSyntax syntax, SyntaxElement syntaxElement, Set<GenClass> contributingNonterminals) {
		if (canBeRepeated(syntaxElement)) {
			return computeFirstSet(syntax, syntaxElement, contributingNonterminals);
		} else {
			return new LinkedHashSet<Expectation>();
		}
	}

	private boolean canBeRepeated(EObject syntaxElement) {
		boolean canBeRepeated = false;
		if (syntaxElement instanceof Definition) {
			Definition definition = (Definition) syntaxElement;
			String cardinality = definition.computeCardinalityString();
			canBeRepeated = "*".equals(cardinality) || "+".equals(cardinality);
		}
		return canBeRepeated;
	}

	private Set<Expectation> computeFirstSetForCompound(ConcreteSyntax syntax, Rule rule,
			CompoundDefinition compound, Set<GenClass> contributingNonterminals) {
		Choice choice = compound.getDefinition();
		Set<Expectation> firstSet = computeFirstSetForChoice(syntax, rule, choice, contributingNonterminals);
		return firstSet;
	}

	private Set<Expectation> computeFirstSetForChoice(ConcreteSyntax syntax, Rule rule, Choice choice, Set<GenClass> contributingNonterminals) {
		Set<Expectation> firstSet = new LinkedHashSet<Expectation>();

		List<Sequence> options = choice.getOptions();
		for (Sequence sequence : options) {
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, sequence, contributingNonterminals));
		}
		return firstSet;
	}

	private Set<Expectation> computeFirstSetForSequence(ConcreteSyntax syntax, Rule rule, Sequence sequence, Set<GenClass> contributingNonterminals) {
		Set<Expectation> firstSet = new LinkedHashSet<Expectation>();
		for (Definition definition : sequence.getParts()) {
			Set<Expectation> firstSetForDefinition = computeFirstSetForDefinition(syntax, rule, definition, contributingNonterminals);
			// when the previous part contains EPSILON and the current does not
			// we need to remove it
			if (firstSet.contains(EPSILON) && !firstSetForDefinition.contains(EPSILON)) {
				firstSet.remove(EPSILON);
			}
			firstSet.addAll(firstSetForDefinition);
			if (firstSetForDefinition.contains(EPSILON)) {
				continue;
			}
			break;
		}
		return firstSet;
	}

	private Set<Expectation> computeFirstSetForDefinition(ConcreteSyntax syntax, Rule rule, Definition definition, Set<GenClass> contributingNonterminals) {
		Set<Expectation> firstSet = new LinkedHashSet<Expectation>();
		if (definition instanceof CardinalityDefinition) {
			firstSet.addAll(computeFirstSetForCardinalityDefinition(syntax, rule, (CardinalityDefinition) definition, contributingNonterminals));
		} else if (definition instanceof CsString) {
			firstSet.add(computeFirstSetForKeyword(syntax, (CsString) definition, contributingNonterminals));
		} else if (definition instanceof WhiteSpaces) {
			firstSet.add(EPSILON);
		} else if (definition instanceof LineBreak) {
			firstSet.add(EPSILON);
		} else {
			// there should be no other subclasses
			assert false;
		}
		return firstSet;
	}

	private Set<Expectation> computeFirstSetForCardinalityDefinition(ConcreteSyntax syntax, Rule rule, CardinalityDefinition definition, Set<GenClass> contributingNonterminals) {
		Set<Expectation> firstSet = new LinkedHashSet<Expectation>();
		String cardinality = definition.computeCardinalityString();
		if ("?".equals(cardinality) || "*".equals(cardinality)) {
			firstSet.add(EPSILON);
		}
		if (definition instanceof CompoundDefinition) {
			firstSet.addAll(computeFirstSetForCompound(syntax, rule, (CompoundDefinition) definition, contributingNonterminals));
		} else {
			assert definition instanceof Terminal;
			firstSet.addAll(computeFirstSetForTerminal(syntax, rule, (Terminal) definition, contributingNonterminals));
		}
		return firstSet;
	}

	private Expectation computeFirstSetForKeyword(ConcreteSyntax syntax, CsString keyword, Set<GenClass> contributingNonterminals) {
		return new Expectation(keyword);
	}

	private Set<Expectation> computeFirstSetForTerminal(ConcreteSyntax syntax, Rule rule, Terminal terminal, Set<GenClass> contributingNonterminals) {
		Set<Expectation> firstSet = new LinkedHashSet<Expectation>();
		final GenFeature genFeature = terminal.getFeature();
		if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
			firstSet.add(EPSILON);
			return firstSet;
		}

		final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		if (ecoreFeature instanceof EAttribute) {
			boolean canBeEmpty = false;
			if (terminal instanceof BooleanTerminal) {
				BooleanTerminal booleanTerminal = (BooleanTerminal) terminal;
				canBeEmpty = booleanTerminal.containsEmptyLiteral();
			}
			if (canBeEmpty) {
				firstSet.add(EPSILON);
			}
			firstSet.add(new Expectation(terminal));
			return firstSet;
		}
		if (!(ecoreFeature instanceof EReference)) {
			return firstSet;
		}
		EReference ecoreReference = (EReference) ecoreFeature;
		GenClass featureType = genFeature.getTypeGenClass();
		if (featureType == null) {
			return firstSet;
		}
		if (!ecoreReference.isContainment()) {
			// for non-containments we add the terminal, but
			// we do not add it for containments, because the
			// rules for the concrete subclasses will fill the
			// firstSet
			firstSet.add(new Expectation(terminal));
			return firstSet;
		}
		assert terminal instanceof Containment;
		Containment containment = (Containment) terminal;

		// we need to consider subclass restrictions that may
		// be set for the terminal
		List<GenClass> subTypes = containment.getAllowedSubTypes();
		for (GenClass subType : subTypes) {
			if (contributingNonterminals.contains(subType)) {
				continue;
			}
			Collection<Rule> featureTypeRules = csUtil.getRules(syntax, subType);
			for (Rule nextFeatureTypeRule : featureTypeRules) {
				GenClass metaclass = nextFeatureTypeRule.getMetaclass();
				if (contributingNonterminals.contains(metaclass)) {
					continue;
				}
				contributingNonterminals.add(metaclass);
				Set<Expectation> firstSetOfSubRule = computeFirstSet(syntax, nextFeatureTypeRule, contributingNonterminals);
				// for every expectation that results from a contained rule, 
				// we extend the rule trace. this way, we know the types of the 
				// containers that may potentially be created if they do not 
				// exist.
				for (Expectation expectation : firstSetOfSubRule) {
					ContainmentLink link = new ContainmentLink(metaclass, containment.getFeature());
					expectation.getContainmentTrace().add(link);
					expectation.setMetaClass(rule.getMetaclass());
				}
				firstSet.addAll(firstSetOfSubRule);
			}
		}
		return firstSet;
	}
}
