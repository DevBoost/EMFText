package org.emftext.sdk.codegen.generators.code_completion.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
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
// TODO split into first and follow set computer
public class ExpectationComputer {

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	/**
	 * Computes a list of expected elements that can follow 'syntaxElement'.
	 * 
	 * @param syntax
	 * @param syntaxElement
	 * @return
	 */
	public List<IExpectedElement> computeExpectations(ConcreteSyntax syntax, EObject syntaxElement) {
		List<EObject> followSet = computeFollowSet(syntax, syntaxElement);

		List<EObject> firstSetOfFollowers = computeFirstSet(syntax, followSet);
		// convert 'firstSetOfFollowers' to expectations
		List<IExpectedElement> expectations = new ArrayList<IExpectedElement>();
		for (EObject nextFirst : firstSetOfFollowers) {
			expectations.add(createExpectedElement(nextFirst));
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
			return new ExpectedFeature(genFeature.getEcoreFeature(), csUtil.getScopeID(terminal), "");
		} else {
			throw new IllegalArgumentException();
		}
	}

	public List<EObject> computeFirstSet(ConcreteSyntax syntax, List<EObject> syntaxElements) {
		return computeFirstSet(syntax, syntaxElements.toArray(new EObject[syntaxElements.size()]));
	}
	
	public List<EObject> computeFirstSet(ConcreteSyntax syntax, EObject... syntaxElements) {
		List<EObject> result = new ArrayList<EObject>();
		for (EObject next : syntaxElements) {
			result.addAll(computeFirstSet(syntax, next));
		}
		return result;
	}

	public List<EObject> computeFirstSet(ConcreteSyntax syntax, EObject syntaxElement) {
		List<EObject> firstSet = new ArrayList<EObject>();
		Rule rule = csUtil.findContainingRule(syntaxElement);
		assert rule != null;
		if (syntaxElement instanceof Definition) {
			firstSet.addAll(computeFirstSetForDefinition(syntax, rule, (Definition) syntaxElement, "", ""));
		}
		if (syntaxElement instanceof Choice) {
			firstSet.addAll(computeFirstSetForChoice(syntax, rule, (Choice) syntaxElement, "", ""));
		}
		/*
		if (syntaxElement instanceof CompoundDefinition) {
			addExpectationCodeForCompound(syntax, rule, (CompoundDefinition) syntaxElement, "", "", expectations);
		}
		if (syntaxElement instanceof Terminal) {
			firstSet.addAll(computeFirstSetForTerminal(syntax, rule, (Terminal) syntaxElement, "", ""));
		}
		*/
		if (syntaxElement instanceof Sequence) {
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, (Sequence) syntaxElement, "", ""));
		}
		return firstSet;
	}

	public List<EObject> computeFollowSet(ConcreteSyntax syntax, EObject syntaxElement) {
		List<EObject> result = new ArrayList<EObject>();

		EReference reference = syntaxElement.eContainmentFeature();
		EObject container = syntaxElement.eContainer();
		Object children = container.eGet(reference);
		if (children instanceof List<?>) {
			List<?> childrenList = (List<?>) children;
			int index = childrenList.indexOf(syntaxElement);
			if (childrenList.size() > index + 1) {
				EObject nextInList = (EObject) childrenList.get(index + 1);
				if (!(nextInList instanceof Rule)) {
					// not reached top level
					if (nextInList instanceof Containment) {
						Containment containment = (Containment) nextInList;
						// for containments we must add all valid subclasses
						// to the follow set
						Collection<Rule> subRules = csUtil.getRules(syntax, containment.getFeature().getTypeGenClass());
						result.addAll(subRules);
					} else {
						result.add(nextInList);
					}
					String cardinality = "";
					if (nextInList instanceof Definition) {
						cardinality = csUtil.computeCardinalityString((Definition) nextInList);
					}
					if ("*".equals(cardinality) || "?".equals(cardinality)) {
						result.addAll(computeFollowSet(syntax, nextInList));
					}
				}
			} else {
				// object was the last in the list, we must
				// try one level higher
				result.addAll(computeFollowSet(syntax, syntaxElement.eContainer()));
			}
		}
		if (children instanceof EObject) {
			result.addAll(computeFollowSet(syntax, ((EObject) children).eContainer()));
		}
		return result;
	}

	private List<EObject> computeFirstSetForDefinition2(ConcreteSyntax syntax, Rule rule, Definition definition,
			String message, String scopeID) {

		List<EObject> firstSet = new ArrayList<EObject>();
		if (definition instanceof CompoundDefinition) {
			firstSet.addAll(computeFirstSetForCompound(syntax, rule, (CompoundDefinition) definition, message, scopeID));
		} else if (definition instanceof CsString) {
			firstSet.addAll(computeFirstSetForKeyword(syntax, (CsString) definition, message, scopeID));
		} else if (definition instanceof Terminal) {
			firstSet.addAll(computeFirstSetForTerminal(syntax, rule, (Terminal) definition, message, scopeID));
		} else {
			throw new IllegalArgumentException("unknown definition type " + definition.getClass().getName());
		}
		return firstSet;
	}

	private List<EObject> computeFirstSetForCompound(ConcreteSyntax syntax, Rule rule,
			CompoundDefinition compoundDef, String message, String scopeID) {
		Choice choice = compoundDef.getDefinitions();
		return computeFirstSetForChoice(syntax, rule, choice, message, scopeID);
	}

	private List<EObject> computeFirstSetForChoice(ConcreteSyntax syntax, Rule rule, Choice choice,
			String message, String scopeID) {
		
		List<EObject> firstSet = new ArrayList<EObject>();

		List<Sequence> options = choice.getOptions();
		int i = 0;
		for (Sequence sequence : options) {
			// TODO mseifert: create new nested scope
			firstSet.addAll(computeFirstSetForSequence(syntax, rule, sequence, message, scopeID + "." + i));
			i++;
		}
		return firstSet;
	}

	private List<EObject> computeFirstSetForSequence(ConcreteSyntax syntax, Rule rule, Sequence sequence,
			String message, String scopeID) {

		List<EObject> firstSet = new ArrayList<EObject>();
		for (Definition definition : sequence.getParts()) {
			firstSet.addAll(computeFirstSetForDefinition(syntax, rule, definition, message, scopeID));
			if (definition instanceof LineBreak || definition instanceof WhiteSpaces) {
				continue;
			}
			break;
		}
		return firstSet;
	}
	
	private List<EObject> computeFirstSetForDefinition(ConcreteSyntax syntax, Rule rule, Definition definition,
			String message, String scopeID) {

		List<EObject> firstSet = new ArrayList<EObject>();
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
			// expected element before STAR or QUESTIONMARK
			List<EObject> followSet = computeFollowSet(syntax, definition);
			firstSet.addAll(computeFirstSet(syntax, followSet));
		}
		if ("*".equals(cardinality) || "+".equals(cardinality)) {
			// expected element after STAR or PLUS
			// TODO
			//addExpectationCodeForDefinition(syntax, rule, definition, scopeID + ": After * or +", scopeID, expectations);
		}
		return firstSet;
	}

	private List<EObject> computeFirstSetForKeyword(ConcreteSyntax syntax, CsString keyword,
			String message, String scopeID) {

		List<EObject> firstSet = new ArrayList<EObject>();
		firstSet.add(keyword);
		return firstSet;
	}

	private List<EObject> computeFirstSetForTerminal(ConcreteSyntax syntax, Rule rule, Terminal terminal, String message, String scopeID) {
		List<EObject> firstSet = new ArrayList<EObject>();
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
		// TODO we probably need to consider subclass restriction that may
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
