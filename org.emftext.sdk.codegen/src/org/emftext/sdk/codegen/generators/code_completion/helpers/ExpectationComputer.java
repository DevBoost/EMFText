package org.emftext.sdk.codegen.generators.code_completion.helpers;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.util.EObjectUtil;

/**
 * The ExpectationComputer can be used to compute all possible
 * elements that can follow a given element in a syntax. It uses
 * the well-known construction of FIRST and FOLLOW sets from
 * context-free grammars.
 */
public class ExpectationComputer {

	// a constant used to represent the empty sentence
	public final static EObject EPSILON = new DynamicEObjectImpl() {
		public String toString() {
			return "EPSILON";
		}
	};

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	/**
	 * A cache for the set of rules that are applicable for a certain GenClass.
	 * This cache is needed because the lookup of the rules is performed very
	 * often and perform quite bad for large syntax definitions.
	 */
	private Map<GenClass, Collection<Rule>> ruleCache = new LinkedHashMap<GenClass, Collection<Rule>>();

	/**
	 * Computes the list of elements that 'syntaxElement' can start
	 * with according to the given syntax definition.
	 * 
	 * @param syntax
	 * @param syntaxElement
	 * @return
	 */
	public Set<EObject> computeFirstSet(ConcreteSyntax syntax, EObject syntaxElement) {
		return computeFirstSet(syntax,syntaxElement, new LinkedHashSet<GenClass>());
	}
	
	
	public Set<EObject> computeFollowSet(ConcreteSyntax syntax, EObject syntaxElement) {
		return computeFollowSet(syntax, syntaxElement, new LinkedHashSet<Rule>(), new LinkedHashSet<GenClass>());
	}
	
	private Set<EObject> computeFirstSet(ConcreteSyntax syntax, EObject syntaxElement, Set<GenClass> contributingNonterminals) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		if (syntaxElement instanceof STAR) {
			return firstSet;
		}
		if (syntaxElement instanceof QUESTIONMARK) {
			return firstSet;
		}
		if (syntaxElement instanceof PLUS) {
			return firstSet;
		}
		Rule rule = csUtil.findContainingRule(syntaxElement);
		
		assert rule != null;
		if (syntaxElement instanceof Definition) {
			firstSet.addAll(computeFirstSetForDefinition(syntax, rule, (Definition) syntaxElement, contributingNonterminals));
		} else if (syntaxElement instanceof Choice) {
			firstSet.addAll(computeFirstSetForChoice(syntax, rule, (Choice) syntaxElement, contributingNonterminals));
		} else if (syntaxElement instanceof Sequence) {
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, (Sequence) syntaxElement, contributingNonterminals));
		} else if (syntaxElement instanceof Rule) {
 			firstSet.addAll(computeFirstSetForChoice(syntax, rule, rule.getDefinition(), contributingNonterminals));
		} else {
			throw new IllegalArgumentException(syntaxElement.toString());
		}
		return firstSet;
	}
		
	private Set<EObject> computeFollowSet(ConcreteSyntax syntax, EObject syntaxElement, Collection<Rule> usedRules, Set<GenClass> contributingNonterminals) {
		Set<EObject> result = new LinkedHashSet<EObject>();
		result.addAll(computeFirstSetIfObjectCanBeRepeated(syntax, syntaxElement, contributingNonterminals));
		if (syntaxElement instanceof STAR) {
			return result;
		}
		if (syntaxElement instanceof QUESTIONMARK) {
			return result;
		}
		if (syntaxElement instanceof PLUS) {
			return result;
		}
		
		EReference reference = syntaxElement.eContainmentFeature();
		EObject container = syntaxElement.eContainer();
		if (container == null) {
			return result;
		}
		if (container instanceof Rule) {
			// find all containments that refer to this rule and
			// compute follow set for these containments. finally add them
			List<Rule> allRules = syntax.getAllRules();
			for (Rule rule : allRules) {
				Collection<Containment> containments = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getContainment());
				for (Containment containment : containments) {
					EList<GenClass> allowedSubTypes = csUtil.getAllowedSubTypes(containment);
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
			result.addAll(computeFollowSet(syntax, container, usedRules, contributingNonterminals));
		} else {
			Object children = container.eGet(reference);
			// search the next element to the right in the syntax rule tree
			if (children instanceof List<?>) {
				List<?> childrenList = (List<?>) children;
				int index = childrenList.indexOf(syntaxElement);
				if (childrenList.size() > index + 1) {
					// found an element next right
					EObject nextInList = (EObject) childrenList.get(index + 1);
					Set<EObject> firstSetOfNext = computeFirstSet(syntax, nextInList, contributingNonterminals);
					result.addAll(firstSetOfNext);
					if (firstSetOfNext.contains(EPSILON)) {
						result.addAll(computeFollowSet(syntax, nextInList, usedRules, contributingNonterminals));
					}
				} else {
					// object was the last one in the list, 
					// we must try one level higher
					result.addAll(computeFollowSet(syntax, syntaxElement.eContainer(), usedRules, contributingNonterminals));
				}
			} else if (children instanceof EObject) {
				assert syntaxElement == children;
				// object was the only one stored in the reference, 
				// we must try one level higher
				result.addAll(computeFollowSet(syntax, syntaxElement.eContainer(), usedRules, contributingNonterminals));
			}
		}
		result.remove(EPSILON);
		return result;
	}

	private Collection<EObject> computeFirstSetIfObjectCanBeRepeated(ConcreteSyntax syntax, EObject syntaxElement, Set<GenClass> contributingNonterminals) {
		if (canBeRepeated(syntaxElement)) {
			return computeFirstSet(syntax, syntaxElement, contributingNonterminals);
		} else {
			return Collections.emptySet();
		}
	}

	private boolean canBeRepeated(EObject syntaxElement) {
		String cardinality = "";
		if (syntaxElement instanceof Definition) {
			cardinality = csUtil.computeCardinalityString((Definition) syntaxElement);
		}
		boolean canBeEmpty = "*".equals(cardinality) || "+".equals(cardinality);
		return canBeEmpty;
	}

	private Set<EObject> computeFirstSetForCompound(ConcreteSyntax syntax, Rule rule,
			CompoundDefinition compound,Set<GenClass> contributingNonterminals) {
		Choice choice = compound.getDefinitions();
		Set<EObject> firstSet = computeFirstSetForChoice(syntax, rule, choice, contributingNonterminals);
		return firstSet;
	}

	private Set<EObject> computeFirstSetForChoice(ConcreteSyntax syntax, Rule rule, Choice choice, Set<GenClass> contributingNonterminals) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();

		List<Sequence> options = choice.getOptions();
		int i = 0;
		for (Sequence sequence : options) {
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, sequence, contributingNonterminals));
			i++;
		}
		return firstSet;
	}

	private Set<EObject> computeFirstSetForSequence(ConcreteSyntax syntax, Rule rule, Sequence sequence,Set<GenClass> contributingNonterminals) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		for (Definition definition : sequence.getParts()) {
			Set<EObject> firstSetForDefinition = computeFirstSetForDefinition(syntax, rule, definition, contributingNonterminals);
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
	
	private Set<EObject> computeFirstSetForDefinition(ConcreteSyntax syntax, Rule rule, Definition definition, Set<GenClass> contributingNonterminals) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		if (definition instanceof CardinalityDefinition) {
			firstSet.addAll(computeFirstSetForCardinalityDefinition(syntax, rule, (CardinalityDefinition) definition, contributingNonterminals));
		} else if (definition instanceof CsString) {
			firstSet.addAll(computeFirstSetForKeyword(syntax, (CsString) definition, contributingNonterminals));
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

	private Set<EObject> computeFirstSetForCardinalityDefinition(ConcreteSyntax syntax, Rule rule, CardinalityDefinition definition,Set<GenClass> contributingNonterminals) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		String cardinality = csUtil.computeCardinalityString(definition);
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
	
	private Set<EObject> computeFirstSetForKeyword(ConcreteSyntax syntax, CsString keyword, Set<GenClass> contributingNonterminals) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>(1);
		firstSet.add(keyword);
		return firstSet;
	}

	private Set<EObject> computeFirstSetForTerminal(ConcreteSyntax syntax, Rule rule, Terminal terminal, Set<GenClass> contributingNonterminals) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		final GenFeature genFeature = terminal.getFeature();
		if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
			firstSet.add(EPSILON);
			return firstSet;
		}

		final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		if (ecoreFeature instanceof EAttribute) {
			firstSet.add(terminal);
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
			firstSet.add(terminal);
			return firstSet;
		}
		assert terminal instanceof Containment;
		Containment containment = (Containment) terminal;
		
		// we need to consider subclass restrictions that may
		// be set for the terminal
		List<GenClass> subTypes = csUtil.getAllowedSubTypes(containment);
		for (GenClass subType : subTypes) {
			if(contributingNonterminals.contains(subType))
				continue;
			Collection<Rule> featureTypeRules = csUtil.getRules(syntax, subType);
			for (Iterator<Rule> iterator = featureTypeRules.iterator(); iterator.hasNext();) {
				Rule nextFeatureTypeRule = (Rule) iterator.next();
				if(contributingNonterminals.contains(nextFeatureTypeRule.getMetaclass()))
					continue;
				contributingNonterminals.add(nextFeatureTypeRule.getMetaclass());
				firstSet.addAll(computeFirstSet(syntax, nextFeatureTypeRule, contributingNonterminals));
			}
		}
		return firstSet;
	}
}
