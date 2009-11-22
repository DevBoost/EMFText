package org.emftext.sdk.codegen.generators.code_completion.helpers;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
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
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * The ExpectationComputer can be used to compute all possible
 * elements that can follow a given element in a syntax. If uses
 * the well-known construction of FIRST and FOLLOW sets from
 * context-free grammars.
 */
public class ExpectationComputer {

	// a constant used to represent the empty sentence
	public final static EObject EPSILON = new DynamicEObjectImpl();

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	/**
	 * Computes the list of elements that can follow 'syntaxElement'
	 * according to the given syntax definition.
	 * 
	 * @param syntax
	 * @param syntaxElement
	 * @return
	 */
	public Set<IExpectedElement> computeFollowExpectations(ConcreteSyntax syntax, EObject syntaxElement) {
		Set<EObject> followSet = computeFollowSet(syntax, syntaxElement);
		// convert 'followSet' to expectations
		Set<IExpectedElement> expectations = new LinkedHashSet<IExpectedElement>();
		for (EObject next : followSet) {
			expectations.add(createExpectedElement(next));
		}
		return expectations;
	}

	/**
	 * Computes the list of elements that 'syntaxElement' can start
	 * with according to the given syntax definition.
	 * 
	 * @param syntax
	 * @param syntaxElement
	 * @return
	 */
	public Set<IExpectedElement> computeFirstExpectations(ConcreteSyntax syntax, EObject syntaxElement) {
		Set<EObject> firstSet = computeFirstSet(syntax, syntaxElement);
		firstSet.remove(EPSILON);
		// convert 'firstSet' to expectations
		Set<IExpectedElement> expectations = new LinkedHashSet<IExpectedElement>();
		for (EObject next : firstSet) {
			expectations.add(createExpectedElement(next));
		}
		return expectations;
	}

	/**
	 * Converts the given syntax definition element to an instance of
	 * IExpectedElement. The element must be a terminal symbol (i.e.,
	 * either a CsString or a Placeholder).
	 * 
	 * @param syntaxElement the element to convert
	 * @return
	 */
	private IExpectedElement createExpectedElement(EObject syntaxElement) {
		if (syntaxElement instanceof CsString) {
			CsString keyword = (CsString) syntaxElement;
			return new ExpectedKeyword(keyword.getValue());
		} else if (syntaxElement instanceof Placeholder) {
			Placeholder placeholder = (Placeholder) syntaxElement;
			GenFeature genFeature = placeholder.getFeature();
			return new ExpectedFeature(genFeature, csUtil.findContainingRule(placeholder).getMetaclass(), placeholder.getToken().getName());
		} else {
			throw new IllegalArgumentException(syntaxElement.toString());
		}
	}

	public Set<EObject> computeFirstSet(ConcreteSyntax syntax, Set<EObject> syntaxElements) {
		return computeFirstSet(syntax, syntaxElements.toArray(new EObject[syntaxElements.size()]));
	}
	
	public Set<EObject> computeFirstSet(ConcreteSyntax syntax, EObject... syntaxElements) {
		Set<EObject> result = new LinkedHashSet<EObject>();
		for (EObject next : syntaxElements) {
			result.addAll(computeFirstSet(syntax, next));
		}
		return result;
	}

	public Set<EObject> computeFirstSet(ConcreteSyntax syntax, EObject syntaxElement) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		Rule rule = csUtil.findContainingRule(syntaxElement);
		assert rule != null;
		if (syntaxElement instanceof Definition) {
			firstSet.addAll(computeFirstSetForDefinition(syntax, rule, (Definition) syntaxElement));
		} else if (syntaxElement instanceof Choice) {
			firstSet.addAll(computeFirstSetForChoice(syntax, rule, (Choice) syntaxElement));
		} else if (syntaxElement instanceof Sequence) {
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, (Sequence) syntaxElement));
		} else if (syntaxElement instanceof Rule) {
 			firstSet.addAll(computeFirstSetForChoice(syntax, rule, rule.getDefinition()));
		} else {
			throw new IllegalArgumentException(syntaxElement.toString());
		}
		return firstSet;
	}

	public Set<EObject> computeFollowSet(ConcreteSyntax syntax, EObject syntaxElement) {
		Set<EObject> result = new LinkedHashSet<EObject>();
		
		// while climbing up the tree to find an element to the right,
		// we must consider that * and ? compounds are their right element
		// on their own, because they can be empty

		EReference reference = syntaxElement.eContainmentFeature();
		EObject container = syntaxElement.eContainer();
		if (container == null) {
			return result;
		}
		if (container instanceof Rule) {
			return result;
		}
		Object children = container.eGet(reference);
		// search the next element to the right in the syntax rule tree
		if (children instanceof List<?>) {
			List<?> childrenList = (List<?>) children;
			int index = childrenList.indexOf(syntaxElement);
			if (childrenList.size() > index + 1) {
				// found an element next right
				EObject nextInList = (EObject) childrenList.get(index + 1);
				result.addAll(computeFirstSet(syntax, nextInList));
				result.addAll(computeFollowSetIfObjectCanBeEmpty(syntax, nextInList));
			} else {
				// object was the last one in the list, 
				// we must try one level higher
				result.addAll(computeFollowSet(syntax, syntaxElement.eContainer()));
			}
		} else if (children instanceof EObject) {
			assert syntaxElement == children;
			// object was the only one stored in the reference, 
			// we must try one level higher
			result.addAll(computeFirstSetIfObjectCanBeRepeated(syntax, syntaxElement.eContainer()));
			result.addAll(computeFollowSet(syntax, syntaxElement.eContainer()));
		}
		result.remove(EPSILON);
		return result;
	}

	private Collection<EObject> computeFirstSetIfObjectCanBeRepeated(ConcreteSyntax syntax, EObject syntaxElement) {
		Set<EObject> result = new LinkedHashSet<EObject>();
		if (canBeRepeated(syntaxElement)) {
			result.addAll(computeFirstSet(syntax, syntaxElement));
		}
		return result;
	}

	private Set<EObject> computeFollowSetIfObjectCanBeEmpty(ConcreteSyntax syntax, EObject syntaxElement) {
		Set<EObject> result = new LinkedHashSet<EObject>();
		if (canBeEmpty(syntax, syntaxElement)) {
			result.addAll(computeFollowSet(syntax, syntaxElement));
		}
		return result;
	}

	private boolean canBeRepeated(EObject syntaxElement) {
		String cardinality = "";
		if (syntaxElement instanceof Definition) {
			cardinality = csUtil.computeCardinalityString((Definition) syntaxElement);
		}
		boolean canBeEmpty = "*".equals(cardinality) || "+".equals(cardinality);
		return canBeEmpty;
	}

	private boolean canBeEmpty(ConcreteSyntax syntax, EObject syntaxElement) {
		// the check for emptiness works recursively by computing the
		// first set. if the first set contains the empty sentence (epsilon)
		// the syntax for the subtree induced by the given syntax element
		// can potentially be empty
		Set<EObject> firstSet = computeFirstSet(syntax, syntaxElement);
		return firstSet.contains(EPSILON);
	}

	private Set<EObject> computeFirstSetForCompound(ConcreteSyntax syntax, Rule rule,
			CompoundDefinition compound) {
		Choice choice = compound.getDefinitions();
		return computeFirstSetForChoice(syntax, rule, choice);
	}

	private Set<EObject> computeFirstSetForChoice(ConcreteSyntax syntax, Rule rule, Choice choice) {
		
		Set<EObject> firstSet = new LinkedHashSet<EObject>();

		List<Sequence> options = choice.getOptions();
		int i = 0;
		for (Sequence sequence : options) {
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, sequence));
			i++;
		}
		return firstSet;
	}

	private Set<EObject> computeFirstSetForSequence(ConcreteSyntax syntax, Rule rule, Sequence sequence) {

		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		for (Definition definition : sequence.getParts()) {
			firstSet.addAll(computeFirstSetForDefinition(syntax, rule, definition));
			if (definition instanceof LineBreak || definition instanceof WhiteSpaces) {
				continue;
			}
			if (canBeEmpty(syntax, definition)) {
				continue;
			}
			break;
		}
		return firstSet;
	}
	
	private Set<EObject> computeFirstSetForDefinition(ConcreteSyntax syntax, Rule rule, Definition definition) {

		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		if (definition instanceof CardinalityDefinition) {
			firstSet.addAll(computeFirstSetForCardinalityDefinition(syntax, rule, (CardinalityDefinition) definition));
		} else if (definition instanceof CsString) {
			firstSet.addAll(computeFirstSetForKeyword(syntax, (CsString) definition));
		} else if (definition instanceof WhiteSpaces) {
			// ignore
		} else if (definition instanceof LineBreak) {
			// ignore
		} else {
			// there should be not other subclasses
			assert false;
		}
		return firstSet;
	}

	private Set<EObject> computeFirstSetForCardinalityDefinition(ConcreteSyntax syntax, Rule rule, CardinalityDefinition definition) {

		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		String cardinality = csUtil.computeCardinalityString(definition);
		if ("?".equals(cardinality) || "*".equals(cardinality)) {
			firstSet.add(EPSILON);
		}
		if (definition instanceof CompoundDefinition) {
			firstSet.addAll(computeFirstSetForCompound(syntax, rule, (CompoundDefinition) definition));
		} else {
			assert definition instanceof Terminal;
			firstSet.addAll(computeFirstSetForTerminal(syntax, rule, (Terminal) definition));
		}
		return firstSet;
	}
	
	private Set<EObject> computeFirstSetForKeyword(ConcreteSyntax syntax, CsString keyword) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		firstSet.add(keyword);
		return firstSet;
	}

	private Set<EObject> computeFirstSetForTerminal(ConcreteSyntax syntax, Rule rule, Terminal terminal) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		final GenFeature genFeature = terminal.getFeature();

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
			Collection<Rule> featureTypeRules = csUtil.getRules(syntax, subType);
			int i = 0;
			for (Iterator<Rule> iterator = featureTypeRules.iterator(); iterator.hasNext();) {
				Rule nextFeatureTypeRule = (Rule) iterator.next();
				Choice choice = nextFeatureTypeRule.getDefinition();
				firstSet.addAll(computeFirstSetForChoice(syntax, nextFeatureTypeRule, choice));
				i++;
			}
		}
		return firstSet;
	}
}
