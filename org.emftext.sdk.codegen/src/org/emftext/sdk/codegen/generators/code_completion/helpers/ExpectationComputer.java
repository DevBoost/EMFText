package org.emftext.sdk.codegen.generators.code_completion.helpers;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * The ExpectationComputer can be used to compute all possible
 * elements that can follow a given element in a syntax.
 */
// TODO the parameter 'scopeID' can probably be removed
public class ExpectationComputer {

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	/**
	 * Computes a list of expected elements that can follow 'syntaxElement'.
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

	public Set<IExpectedElement> computeFirstExpectations(ConcreteSyntax syntax, EObject syntaxElement) {
		Set<EObject> firstSet = computeFirstSet(syntax, syntaxElement);
		// convert 'firstSet' to expectations
		Set<IExpectedElement> expectations = new LinkedHashSet<IExpectedElement>();
		for (EObject next : firstSet) {
			expectations.add(createExpectedElement(next));
		}
		return expectations;
	}

	private IExpectedElement createExpectedElement(EObject nextFirst) {
		if (nextFirst instanceof CsString) {
			CsString keyword = (CsString) nextFirst;
			return new ExpectedKeyword(keyword.getValue(), csUtil.getScopeID(keyword), "");
		} else if (nextFirst instanceof Terminal) {
			Terminal terminal = (Terminal) nextFirst;
			GenFeature genFeature = terminal.getFeature();
			return new ExpectedFeature(genFeature, csUtil.findContainingRule(terminal).getMetaclass(), csUtil.getScopeID(terminal), "");
		} else {
			throw new IllegalArgumentException(nextFirst.toString());
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
			firstSet.addAll(computeFirstSetForDefinition(syntax, rule, (Definition) syntaxElement, "", ""));
		} else if (syntaxElement instanceof Choice) {
			firstSet.addAll(computeFirstSetForChoice(syntax, rule, (Choice) syntaxElement, "", ""));
		} else if (syntaxElement instanceof Sequence) {
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, (Sequence) syntaxElement, "", ""));
		} else if (syntaxElement instanceof Rule) {
 			firstSet.addAll(computeFirstSetForChoice(syntax, rule, rule.getDefinition(), "", ""));
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
		if (canBeEmpty(syntaxElement)) {
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

	private boolean canBeEmpty(EObject syntaxElement) {
		String cardinality = "";
		if (syntaxElement instanceof Definition) {
			cardinality = csUtil.computeCardinalityString((Definition) syntaxElement);
		}
		boolean canBeEmpty = "*".equals(cardinality) || "?".equals(cardinality);
		return canBeEmpty;
	}

	private Set<EObject> computeFirstSetForCompound(ConcreteSyntax syntax, Rule rule,
			CompoundDefinition compoundDef, String message, String scopeID) {
		Choice choice = compoundDef.getDefinitions();
		return computeFirstSetForChoice(syntax, rule, choice, message, scopeID);
	}

	private Set<EObject> computeFirstSetForChoice(ConcreteSyntax syntax, Rule rule, Choice choice,
			String message, String scopeID) {
		
		Set<EObject> firstSet = new LinkedHashSet<EObject>();

		List<Sequence> options = choice.getOptions();
		int i = 0;
		for (Sequence sequence : options) {
			// TODO mseifert: create new nested scope
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, sequence, message, scopeID + "." + i));
			i++;
		}
		return firstSet;
	}

	private Set<EObject> computeFirstSetForSequence(ConcreteSyntax syntax, Rule rule, Sequence sequence,
			String message, String scopeID) {

		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		for (Definition definition : sequence.getParts()) {
			firstSet.addAll(computeFirstSetForDefinition(syntax, rule, definition, message, scopeID));
			if (definition instanceof LineBreak || definition instanceof WhiteSpaces) {
				continue;
			}
			break;
		}
		return firstSet;
	}
	
	private Set<EObject> computeFirstSetForDefinition(ConcreteSyntax syntax, Rule rule, Definition definition,
			String message, String scopeID) {

		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		String cardinality = csUtil.computeCardinalityString(definition);

		if ("+".equals(cardinality)) {
			// expected element before STAR or QUESTIONMARK or PLUS
			// TODO
			//addExpectationCodeForDefinition(syntax, rule, definition, scopeID + ": Before * or + or ?", scopeID, expectations);
		}
		if (definition instanceof CompoundDefinition) {
			CompoundDefinition compoundDef = (CompoundDefinition) definition;
			// expected element is a Compound
			// TODO
			firstSet.addAll(computeFirstSetForCompound(syntax, rule, compoundDef, scopeID + ": Compound", scopeID + ".X"));
		} else if (definition instanceof CsString) {
			final CsString csString = (CsString) definition;
			// expected element is a CsString
			firstSet.addAll(computeFirstSetForKeyword(syntax, csString, scopeID + ": CsString", scopeID));
		} else {
			assert definition instanceof Terminal;
			final Terminal terminal = (Terminal) definition;
			// expected element is a Terminal
			firstSet.addAll(computeFirstSetForTerminal(syntax, rule, terminal, "Terminal", scopeID));
		}
		
		if ("*".equals(cardinality) || "?".equals(cardinality)) {
			// expected element after STAR or QUESTIONMARK
			//Set<EObject> followSet = computeFollowSet(syntax, definition);
			//firstSet.addAll(computeFirstSet(syntax, followSet));
		}
		if ("*".equals(cardinality) || "+".equals(cardinality)) {
			// expected element after STAR or PLUS
			// TODO
			//addExpectationCodeForDefinition(syntax, rule, definition, scopeID + ": After * or +", scopeID, expectations);
		}
		return firstSet;
	}

	private Set<EObject> computeFirstSetForKeyword(ConcreteSyntax syntax, CsString keyword,
			String message, String scopeID) {

		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		firstSet.add(keyword);
		return firstSet;
	}

	private Set<EObject> computeFirstSetForTerminal(ConcreteSyntax syntax, Rule rule, Terminal terminal, String message, String scopeID) {
		Set<EObject> firstSet = new LinkedHashSet<EObject>();
		//final GenClass genClass = rule.getMetaclass();
		final GenFeature genFeature = terminal.getFeature();
		// TODO use this code to convert syntax element to expected element
		//expectations.add(new ExpectedFeature(genFeature.getEcoreFeature(), csUtil.getScopeID(terminal), message));
		/*
		sc.add("addExpectedElement(new "
				+ expectedStructuralFeatureClassName + "(\""
				+ getScopeID(terminal) + "\", " 
				+ discardFollowingExpectations + ", "
				+ genClass.getGenPackage().getReflectionPackageName() + "."
				+ genClass.getGenPackage().getPackageInterfaceName()
				+ ".eINSTANCE.get" + genClass.getClassifierAccessorName()
				+ "()" + ".getEStructuralFeature("
				+ generatorUtil.getFeatureConstant(genClass, genFeature)
				+ "), element, \"" + message + "\"), \"" + scopeID + ": Terminal\");");
				*/

		final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
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
			// rules  for the concrete subclass will fill the 
			// firstSet
			firstSet.add(terminal);
			return firstSet;
		}
		// TODO we probably need to consider subclass restrictions that may
		// be set for the terminal
		Collection<Rule> featureTypeRules = csUtil.getRules(syntax, featureType);
		int i = 0;
		for (Iterator<Rule> iterator = featureTypeRules.iterator(); iterator.hasNext();) {
			Rule nextFeatureTypeRule = (Rule) iterator.next();
			String featurePath = genFeature.getName() + "->" + nextFeatureTypeRule.getMetaclass().getName();
			System.out.println("Handling subrule " + featurePath);
			Choice choice = nextFeatureTypeRule.getDefinition();
			firstSet.addAll(computeFirstSetForChoice(syntax, nextFeatureTypeRule, choice, "containment for " + featurePath, scopeID + "." + i));
			i++;
		}
		return firstSet;
	}
}
