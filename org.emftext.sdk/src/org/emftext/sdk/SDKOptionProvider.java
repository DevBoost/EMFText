package org.emftext.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.analysis.ConcreteSyntaxAnalyser;
import org.emftext.sdk.analysis.LeftRecursionDetector;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * The SDKOptionProvider adds a post-processor to the default 
 * load options for CS files. This post-processor checks
 * whether CS files contain potential problems. The current
 * implementation checks for a number of cases which might 
 * cause problems when parsed resources are printed.
 */
public class SDKOptionProvider implements IOptionProvider {

	private static final String OPTIONAL_KEYWORD_WARNING = 
		"The keyword might be used stand alone and will not be reprinted in such case: ";
	private static final String MULTIPLE_FEATURE_WARNING = 
		"The feature is used multiple times. Reprinting may fail for feature: ";
	private static final String EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS = 
		"Explicit syntax choices are not reflected in model instances and may thus cause problem when printing models.";
	private static final String RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO = "The rule is left recursive in relation to rule: ";
	private static final String NO_RULE_FOR_META_CLASS = "There is no rule for concrete meta class: ";
	
	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		LinkedList<IResourcePostProcessorProvider> postProcessors = new LinkedList<IResourcePostProcessorProvider>();
		
		postProcessors.add( new IResourcePostProcessorProvider() {

			public IResourcePostProcessor getResourcePostProcessor() {
				return new IResourcePostProcessor() {
					public void process(ITextResource resource) {
						checkReprintProblems(resource);
					}
				};
			}
			
		});
		postProcessors.add( new IResourcePostProcessorProvider() {

			public IResourcePostProcessor getResourcePostProcessor() {
				return new IResourcePostProcessor() {
					public void process(ITextResource resource) {
						checkLeftRecursion(resource);
					}
					
				};
			}
		});
		postProcessors.add( new IResourcePostProcessorProvider() {

			public IResourcePostProcessor getResourcePostProcessor() {
				return new IResourcePostProcessor() {
					public void process(ITextResource resource) {
						checkMissingRules(resource);
					}
				};
			}
		});
		postProcessors.add( new IResourcePostProcessorProvider() {

			public IResourcePostProcessor getResourcePostProcessor() {
				return new IResourcePostProcessor() {
					public void process(ITextResource resource) {
						checkCorrectUseOfAbstractModifier(resource);
					}
				};
			}
		});
		postProcessors.add( new IResourcePostProcessorProvider() {

			public IResourcePostProcessor getResourcePostProcessor() {
				return new IResourcePostProcessor() {
					public void process(ITextResource resource) {
						checkForDuplicateRules(resource);
					}
				};
			}
		});
		postProcessors.add( new IResourcePostProcessorProvider() {

			public IResourcePostProcessor getResourcePostProcessor() {
				return new IResourcePostProcessor() {
					public void process(ITextResource resource) {
						checkForUnusedFeatures(resource);
					}
				};
			}
		});
		
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		
		return options;
	}


	private void checkForDuplicateRules(ITextResource resource) {
		EList<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				checkForDuplicateRules(resource, (ConcreteSyntax) next);
			}
		}
	}

	private void checkForDuplicateRules(ITextResource resource,
			ConcreteSyntax syntax) {

		final EList<Rule> allRules = syntax.getAllRules();
		for (int i = 0; i < allRules.size(); i++) {
			Rule rule_i = allRules.get(i);
			GenClass genClass_i = rule_i.getMetaclass();
			if (genClass_i == null || genClass_i.eIsProxy()) {
				continue;
			}
			final String name_i = genClass_i.getQualifiedInterfaceName();
			if (name_i == null) {
				continue;
			}
			
			List<Rule> duplicates = new ArrayList<Rule>();
			for (int j = i + 1; j < allRules.size(); j++) {
				Rule rule_j = allRules.get(j);
				GenClass genClass_j = rule_j.getMetaclass();
				if (genClass_j == null) {
					continue;
				}
				final String name_j = genClass_j.getQualifiedInterfaceName();
				if (name_i.equals(name_j)) {
					duplicates.add(rule_j);
				}
			}
			if (duplicates.size() > 0) {
				final String message = "Found duplicate rule for meta class \"" + genClass_i.getName() + "\" (may be imported).";
				resource.addError(message, rule_i);
				for (Rule duplicate : duplicates) {
					resource.addError(message, duplicate);
				}
			}
		}
	}


	private void checkForUnusedFeatures(ITextResource resource) {
		EList<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				checkForUnusedFeatures(resource, (ConcreteSyntax) next);
			}
		}
	}
	
	private void checkForUnusedFeatures(ITextResource resource,
			ConcreteSyntax syntax) {
		
		// get collect-in feature to tag them as used

		Map<EStructuralFeature, Rule> unusedReferencesWithOpposite = new HashMap<EStructuralFeature, Rule>();

		final EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			GenClass genClass = rule.getMetaclass();
			if (genClass == null || genClass.eIsProxy()) {
				continue;
			}
			for (GenFeature genFeature : genClass.getAllGenFeatures()) {
				final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
				if (ecoreFeature == null) {
					continue;
				}
				if (ecoreFeature.isDerived()) {
					continue;
				}
				if (new ConcreteSyntaxAnalyser().isCollectInFeature(rule.getSyntax(), ecoreFeature)) {
					continue;
				}
				Choice choice = rule.getDefinition();
				final boolean isUsed = isUsed(choice, genFeature);
				final EReference opposite = getOpposite(ecoreFeature);
				if (!isUsed) {
					if (opposite != null) {
						unusedReferencesWithOpposite.put(ecoreFeature, rule);
					} else {
						resource.addWarning("Feature " + genFeature.getGenClass().getName() + "." + genFeature.getName() + " has no syntax.", rule);
					}
				}
			}
		}

		List<EStructuralFeature> handledFeatures = new ArrayList<EStructuralFeature>();
		for (EStructuralFeature feature : unusedReferencesWithOpposite.keySet()) {
			if (handledFeatures.contains(feature)) {
				continue;
			}
			final EReference opposite = getOpposite(feature);
			handledFeatures.add(opposite);
			if (unusedReferencesWithOpposite.containsKey(opposite)) {
				// both are not defined
				Rule rule1 = unusedReferencesWithOpposite.get(feature);
				Rule rule2 = unusedReferencesWithOpposite.get(opposite);

				resource.addWarning("Feature " + getFeatureString(feature) + " (Opposite is " + getFeatureString(opposite) + ") has no syntax.", rule1);
				resource.addWarning("Feature " + getFeatureString(opposite) + " (Opposite is " + getFeatureString(feature) + ") has no syntax.", rule2);
			}
		}
	}


	private String getFeatureString(EStructuralFeature f) {
		EClass containerClass = f.getEContainingClass();
		return containerClass.getName() + "." + f.getName();
	}


	private EReference getOpposite(EStructuralFeature ecoreFeature) {
		if (ecoreFeature instanceof EReference) {
			EReference ecoreReference = (EReference) ecoreFeature;
			return ecoreReference.getEOpposite();
		}
		return null;
	}


	private boolean isUsed(Choice choice, GenFeature genFeature) {
		for (Sequence sequence : choice.getOptions()) {
			for (Definition part : sequence.getParts()) {
				if (part instanceof Terminal) {
					Terminal terminal = (Terminal) part;
					GenFeature terminalGenFeature = terminal.getFeature();
					if(terminalGenFeature != null && !terminalGenFeature.eIsProxy()) {
						if (genFeature.getName().equals(terminalGenFeature.getName())) {
							return true;
						}
					}
				} else if (part instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) part;
					Choice subChoice = compound.getDefinitions();
					boolean isUsedInSubChoice = isUsed(subChoice, genFeature);
					if (isUsedInSubChoice) {
						return true;
					}
				}
			}
		}
		return false;
	}


	private void checkMissingRules(ITextResource resource) {
		EList<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				checkMissingRules(resource, (ConcreteSyntax) next);
			}
		}
	}
	
	private void checkMissingRules(ITextResource resource, ConcreteSyntax syntax) {
		GenClassFinder genClassFinder = new GenClassFinder();
		Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(syntax, false, false);
		EList<Rule> allRules = syntax.getAllRules();
		// this set ensures that we do not add warnings for a missing rule twice
		Set<String> namesOfCompletedGenClasses = new LinkedHashSet<String>();
		
		for (GenClass genClass : allGenClasses) {
			EClass ecoreClass = genClass.getEcoreClass();
			if (ecoreClass == null) {
				continue;
			}
			if (ecoreClass.isAbstract()) {
				continue;
			}
			String qualifiedName = genClass.getQualifiedInterfaceName();
			if (namesOfCompletedGenClasses.contains(qualifiedName)) {
				continue;
			}
			namesOfCompletedGenClasses.add(qualifiedName);
			boolean foundRuleForClass = false;
			for (Rule rule : allRules) {
				GenClass ruleClass = rule.getMetaclass();
				if (ruleClass != null && !ruleClass.eIsProxy() && ruleClass.getQualifiedInterfaceName().equals(qualifiedName)) {
					foundRuleForClass = true;
					break;
				}
			}
			if (!foundRuleForClass) {
				resource.addWarning(NO_RULE_FOR_META_CLASS + genClass.getName(), syntax);
			}
		}
	}

	private void checkLeftRecursion(ITextResource resource) {
		EList<EObject> grammars = resource.getContents();
		for (EObject next : grammars) {
			if (next instanceof ConcreteSyntax) {
				
				ConcreteSyntax cs = (ConcreteSyntax) next;
				GenClassFinder genClassFinder = new GenClassFinder();
				Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(cs, true, true);
				Map<String, Collection<String>> genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
				LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, cs);
				
				EList<Rule> allRules = cs.getAllRules();
				
				for (Rule rule : allRules) {
					Rule recursionRule = lrd.findLeftRecursion(rule);
					if (recursionRule != null) {
						resource.addWarning(RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO + recursionRule.getMetaclass().getName(), rule);
					}
				}

			}
		}
	}
	
	private void checkReprintProblems(ITextResource resource) {
		checkForOptionalKeywords(resource);
		checkForDuplicateReferences(resource);
		checkForChoices(resource);
	}
	
	private void checkForChoices(ITextResource resource) {
		Iterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Choice) {
				Choice choice = (Choice) next;
				if (choice.getOptions().size() > 1) {
					resource.addWarning(
							EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS,
							choice);
				}
			}
		}
	}
	
	private void checkCorrectUseOfAbstractModifier(ITextResource resource) {
		EList<EObject> contents = resource.getContents();
		if (contents == null) {
			return;
		}
		if (contents.size() == 0) {
			return;
		}
		EObject root = contents.get(0);
		if (!(root instanceof ConcreteSyntax)) {
			return;
		}
		ConcreteSyntax cs = (ConcreteSyntax) root;
		List<GenClass> symbols = cs.getActiveStartSymbols();
		Abstract modifier = cs.getModifier();
		boolean isDeclaredAbstract = modifier != null;
		if (isDeclaredAbstract) {
			// assert there is no start symbol (not a 
			// declared one and not an imported one)
			if (symbols.size() > 0) {
				resource.addError("Syntax has start symbols (" + getListOfNames(symbols) + "), but is declared abstract.", modifier);
			}
		} else {
			// assert the is at least one start symbol (either a 
			// declared one or an imported one)
			if (symbols.size() == 0) {
				resource.addError("Syntax has no start symbols, but is not declared abstract.", cs);
			}
		}
	}

	private String getListOfNames(List<GenClass> classes) {
		boolean isFirst = true;
		String listOfNames = "";
		for (GenClass symbol : classes) {
			if (!isFirst) {
				listOfNames += ", ";
			}
			isFirst = false;
			listOfNames += symbol.getName();
		}
		return listOfNames;
	}

	private void checkForOptionalKeywords(ITextResource resource) {
		for(Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof CompoundDefinition) {
				CompoundDefinition compoundDefinition = (CompoundDefinition) next;
				if (compoundDefinition.getCardinality() instanceof QUESTIONMARK ||
						compoundDefinition.getCardinality() instanceof STAR) {
					for (Sequence sequence : compoundDefinition.getDefinitions().getOptions()) {
						boolean containsKeyword = false;
						boolean restOptional = true;
						
						for (Definition definition : sequence.getParts()) {
							
							if (definition instanceof CsString) {
								containsKeyword = true;
							}
							else if (GeneratorUtil.hasNoOptionalPart(definition)) {
								restOptional = false;
							}
						}
						if(containsKeyword && restOptional) {
							for (Definition definition : sequence.getParts()) {
								if (definition instanceof CsString) {
									CsString csString = (CsString) definition;
									resource.addWarning(
											OPTIONAL_KEYWORD_WARNING + csString.getValue(),
											definition);
								}
							}
						}
					}
				}
			}
		}
	}

	private void checkForDuplicateReferences(ITextResource resource) {
		Iterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			final EObject next = iterator.next();
			if (next instanceof Rule) {
				final Rule rule = (Rule) next;
				final List<Terminal> terminals = collectAllTerminals(rule);
				for (Terminal terminal : terminals) {
					final GenFeature feature = terminal.getFeature();
					if (canCauseReprintProblem(rule.getDefinition(), feature)) {
						resource.addWarning(
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
		return countProblematicOccurrences(choice, feature, false) > 1;
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
	private int countProblematicOccurrences(Choice choice, GenFeature feature, boolean foundStarOrOptionalBefore) {
		int occurences = 0;
		
		List<Sequence> choices = choice.getOptions();
		for (Sequence sequence : choices) {
			List<Definition> definitions = sequence.getParts();
			for (Definition definition : definitions) {
				// incorporate cardinality of the definition
				Cardinality cardinality = null;
				if (definition instanceof CardinalityDefinition) {
					cardinality = ((CardinalityDefinition) definition).getCardinality();
				}
				if (definition instanceof Terminal) {
					Terminal terminal = (Terminal) definition;
					if (terminal.getFeature() == feature) {
						final boolean isStarOrOptional = cardinality instanceof STAR || cardinality instanceof QUESTIONMARK;
						if (isStarOrOptional || foundStarOrOptionalBefore) {
							occurences++;
						}
					}
				} else if (definition instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) definition;
					Choice subChoice = compound.getDefinitions();
					// recursive method call
					occurences += countProblematicOccurrences(subChoice, feature, occurences > 0);
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
					Choice subChoice = compound.getDefinitions();
					result.addAll(collectAllTerminals(subChoice));
				}
			}
		}
		return result;
	}
}
