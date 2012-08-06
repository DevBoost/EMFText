package org.emftext.importers.xtext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.XtextStandaloneSetupGenerated;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.TokenDirective;

/**
 * This is an experimental importer for Xtext grammars. It translates the 
 * grammar structure to CS rules. Unfortunately there are some severe
 * limitations to this translation, because there are no equivalents in 
 * EMFText:
 * 
 * <ul>
 * <li>Pure syntax rules (i.e., rules which do not create EObjects) cannot be
 *     translated. In EMFText all rules must create EObjects. This problem
 *     can be resolved be replacing attributes in the metamodel with 
 *     containment references to composite objects.
 * <li>Enumeration rules cannot be translated. EMFText uses dedicated token
 *     definitions for enumerations, which is semantically different from the
 *     way enumeration rules are handled in Xtext. This cannot be resolved 
 *     until EMFText supports EnumerationTerminals (similar to 
 *     BooleanTerminals).
 * <li>Assignments of keywords to attributes (e.g., <code>Metaclass : 
 *     value='keyword1' | value='keyword2';</code>) cannot be handled.
 * </ul>
 * 
 * Also the translation is incomplete with regard to the following points:
 * 
 * <ul>
 * <li>The semantics of operators in Xtext assignments is not considered. All
 *     operators are translated equally.
 * <li>Actions are not translated.
 * <li>The translator assumes that the metamodel is derived from the Xtext 
 *     grammar. If this is not the case, the translation might be incorrect
 *     or incomplete.
 * </ul>
 */
public class XtextImporter {

	private final ConcretesyntaxFactory CS_FACTORY = ConcretesyntaxFactory.eINSTANCE;

	private ConcreteSyntax syntax;

	private String attributeChanges = "";
	
	/**
	 * Translates an Xtext grammar (named 'grammerName' and located in directory
	 * 'grammarDir') to a .cs specification.
	 * 
	 * @param grammarDir the directory where the .xtext file is located
	 * @param grammarName the name of the .xtext file
	 * @param syntaxName the name of the target .cs file
	 * @param fileExtension the file extension to set in the .cs file
	 * @param packageLocationHint the path to the .genmodel file
	 * @param startSymbols the names of the metaclasses to be used as start symbols
	 */
	public void doImport(String grammarDir, String grammarName, String syntaxName, String fileExtension, String packageLocationHint, String[] startSymbols) {
		registerResourceFactories();
		
		ResourceSet rs = new ResourceSetImpl();
		String syntaxPath = grammarDir + syntaxName;
		URI syntaxURI = URI.createFileURI(new File(syntaxPath).getAbsolutePath());
		Resource resource = rs.getResource(URI.createURI(grammarDir + grammarName), true);
		if (resource == null) {
			System.err.println("Can't load xtext resource.");
		}
		EList<EObject> contents = resource.getContents();
		Grammar grammar = (Grammar) contents.get(0);
		createSyntax(grammar, fileExtension, packageLocationHint, startSymbols);
		importTokens(grammar);
		importRules(grammar);
		saveSyntax(rs, syntaxURI);
		System.out.println("Required attribute changes:\n" + attributeChanges);
	}

	private void importTokens(Grammar grammar) {
		List<AbstractRule> rules = getAllRules(grammar);
		for (AbstractRule rule : rules) {
			if (rule instanceof TerminalRule) {
				TerminalRule terminalRule = (TerminalRule) rule;
				AbstractElement alternatives = terminalRule.getAlternatives();
				String tokenName = terminalRule.getName();
				importToken(tokenName, alternatives);
			}
		}
	}

	private void importToken(String tokenName, AbstractElement alternatives) {
		//System.out.println("XTextImporter.importToken(" + tokenName + ")");
		NormalTokenDefinition token = CS_FACTORY.createNormalTokenDefinition();
		token.setName(tokenName);
		AtomicRegex regexPart = CS_FACTORY.createAtomicRegex();
		regexPart.setAtomicExpression(getRegex(alternatives));
		token.getRegexParts().add(regexPart);
		syntax.getTokens().add(token);
	}

	private String getRegex(AbstractElement element) {
		String card = element.getCardinality();
		if (element instanceof Group) {
			Group group = (Group) element;
			List<AbstractElement> elements = group.getElements();
			String regex = "(";
			for (AbstractElement subElement : elements) {
				regex += getRegex(subElement);
			}
			regex += ")";
			return wrap(regex, card);
		} else if (element instanceof Keyword) {
			String value = ((Keyword) element).getValue();
			String escaped = escapeToRegexString(value);
			return wrap("'" + escaped + "'", card);
		} else if (element instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) element;
			AbstractRule rule = ruleCall.getRule();
			String regex = getRegex(rule.getAlternatives());
			return wrap(regex, card);
		} else if (element instanceof Wildcard) {
			return wrap(".", card);
		} else if (element instanceof UntilToken) {
			UntilToken untilToken = (UntilToken) element;
			String regex = getRegex(untilToken.getTerminal());
			return wrap("(~(" + regex + "))*" + regex, card);
		} else if (element instanceof CharacterRange) {
			CharacterRange characterRange = (CharacterRange) element;
			return wrap(
				getRegex(characterRange.getLeft()) +
				".." +
				getRegex(characterRange.getRight()), card);
		} else if (element instanceof Alternatives) {
			Alternatives alternatives = (Alternatives) element;
			EList<AbstractElement> elements = alternatives.getElements();
			String regex = "(";
			for (int i = 0; i < elements.size(); i++) {
				regex += getRegex(elements.get(i));
				if (i < elements.size() - 1) {
					regex += "|";
				}
			}
			return wrap(regex + ")", card);
		} else if (element instanceof NegatedToken) {
			return wrap("~(" + getRegex(((NegatedToken) element).getTerminal()) + ")", card);
		} else {
			System.err.println("Can't compute regex for " + element);
			return "";
		}
	}

	private String wrap(String regex, String card) {
		if (card == null || "".equals(card)) {
			return regex;
		}
		return "(" + regex + ")" + card;
	}

	private List<AbstractRule> getAllRules(Grammar grammar) {
		List<Grammar> usedGrammars = grammar.getUsedGrammars();
		List<AbstractRule> allRules = new ArrayList<AbstractRule>();
		allRules.addAll(grammar.getRules());
		for (Grammar usedGrammar : usedGrammars) {
			allRules.addAll(getAllRules(usedGrammar));
		}
		return allRules;
	}

	private void createSyntax(Grammar grammar, String fileExtension, String packageLocationHint, String... startSymbols) {
		syntax = CS_FACTORY.createConcreteSyntax();
		GenPackage genPackage = getGenPackages(grammar.eResource()).get(0);
		syntax.setPackage(genPackage);
		syntax.setPackageLocationHint(packageLocationHint);
		for (String startSymbol : startSymbols) {
			syntax.getStartSymbols().add(findGenClass(grammar.eResource(), startSymbol));
		}
		syntax.setName(fileExtension);
		
		Option option1 = CS_FACTORY.createOption();
		option1.setType(OptionTypes.USE_PREDEFINED_TOKENS);
		option1.setValue("false");
		syntax.getOptions().add(option1);
	}

	private void saveSyntax(ResourceSet rs, URI syntaxURI) {
		Resource csResource = rs.createResource(syntaxURI);
		csResource.getContents().add(syntax);
		try {
			csResource.save(null);
		} catch (IOException e) {
			System.err.println("Can't save .cs file.");
		}
	}

	private void importRules(Grammar grammar) {
		List<AbstractRule> rules = grammar.getRules();
		for (AbstractRule rule : rules) {
			if (rule instanceof TerminalRule) {
				continue;
			}
			org.emftext.sdk.concretesyntax.Rule csRule = importRule(rule);
			add(syntax.getRules(), csRule);
		}
	}

	private org.emftext.sdk.concretesyntax.Rule importRule(AbstractRule rule) {
		String ruleName = rule.getName();
		GenClassifier genClassifier = findGenClassifier(rule.eResource(), ruleName);
		if (genClassifier == null) {
			System.err.println("Ignoring rule (metaclass not found): " + ruleName);
			return null;
		}
		EClassifier metaClassifier = genClassifier.getEcoreClassifier();
		//System.out.println("Importing rule: " + rule.getName() + " EClass = " + metaClassifier.getName());
		if (rule.getType().getClassifier() instanceof EEnum) {
			System.err.println("Ignoring rule (metaclass is enum): " + ruleName);
			return null;
		}
		if (metaClassifier instanceof EClass) {
			EClass metaclass = (EClass) metaClassifier;
			if (metaclass.isAbstract() || metaclass.isInterface()) {
				// we do not import rules for abstract classes
				System.out.println("Ignoring rule (metaclass is abstract or interface): " + ruleName);
				return null;
			}
		}
		
		org.emftext.sdk.concretesyntax.Rule csRule = CS_FACTORY.createRule();
		csRule.setMetaclass((GenClass) genClassifier);
		
		AbstractElement alternative = rule.getAlternatives();
		SyntaxElement body = importElement(alternative);
		add(csRule.getChildren(), body);
		return csRule;
	}

	private <T> void add(EList<T> list, T element) {
		if (element == null) {
			return;
		}
		list.add(element);
	}

	private GenClassifier findGenClassifier(Resource syntaxResource, String name) {
		EList<GenPackage> genPackages = getGenPackages(syntaxResource);
		for (GenPackage genPackage : genPackages) {
			List<GenClassifier> genClasses = genPackage.getGenClassifiers();
			for (GenClassifier genClass : genClasses) {
				if (name.equals(genClass.getEcoreClassifier().getName())) {
					return genClass;
				}
			}
		}
		System.err.println("Can't find GenClassifier " + name);
		return null;
	}

	private GenClass findGenClass(Resource syntaxResource, String name) {
		GenClassifier genClassifier = findGenClassifier(syntaxResource, name);
		if (genClassifier instanceof GenClass) {
			return (GenClass) genClassifier;
		} else {
			return null;
		}
	}

	private GenFeature findGenFeature(Assignment assignment, String feature) {
		AbstractRule rule = findContaingRule(assignment);
		GenClass metaclass = findGenClass(assignment.eResource(), rule.getType().getClassifier().getName());
		List<GenFeature> genFeatures = metaclass.getAllGenFeatures();
		for (GenFeature genFeature : genFeatures) {
			if (feature.equals(genFeature.getName())) {
				return genFeature;
			}
		}
		System.err.println("Can't find GenFeature " + feature);
		return null;
	}

	private EList<GenPackage> getGenPackages(Resource syntaxResource) {
		URI syntaxURI = syntaxResource.getURI();
		URI genModelURI = syntaxURI.trimFileExtension().appendFileExtension("genmodel");
		genModelURI = URI.createURI(genModelURI.toString().replace("/src/", "/src-gen/"));
		ResourceSet resourceSet = syntaxResource.getResourceSet();
		//System.out.println("Loading generator model from " + genModelURI);
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		if (genModelResource == null) {
			System.err.println("Can't find generator model at " + genModelURI);
			return null;
		}
		EcoreUtil.resolveAll(genModelResource);
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		EList<GenPackage> genPackages = genModel.getGenPackages();
		return genPackages;
	}

	private SyntaxElement importElement(AbstractElement element) {
		if (element instanceof Keyword) {
			Keyword keyword = (Keyword) element;
			return importKeyword(keyword);
		} else if (element instanceof Assignment) {
			Assignment assignment = (Assignment) element;
			return importAssignment(assignment);
		} else if (element instanceof Action) {
			Action action = (Action) element;
			return importAction(action);
		} else if (element instanceof Group) {
			Group group = (Group) element;
			return importGroup(group);
		} else if (element instanceof Alternatives) {
			Alternatives alternatives = (Alternatives) element;
			return importAlternative(alternatives);
		} else if (element instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) element;
			return importRuleCall(ruleCall);
		} else {
			System.err.println("Found unknown element to import: " + element.eClass().getName());
			return null;
		}
	}

	private SyntaxElement importRuleCall(RuleCall ruleCall) {
		AbstractRule targetRule = ruleCall.getRule();
		EClassifier targetClassifier = targetRule.getType().getClassifier();
		AbstractRule containgRule = findContaingRule(ruleCall);
		// check that the called rule is a subclass of the current rule
		EClassifier ruleClassifier = containgRule.getType().getClassifier();
		if (targetClassifier instanceof EClass && ruleClassifier instanceof EClass) {
			EClass ruleClass = (EClass) ruleClassifier;
			EClass targetClass = (EClass) targetClassifier;
			if (targetClass.getEAllSuperTypes().contains(ruleClass)) {
				//System.out.println("Ignoring rule call to: " + rule.getName() + " (will be automatically added because of subclass relation)");
			} else {
				System.err.println("Can't handle rule call in rule " + containgRule.getName());
			}
		} else {
			System.err.println("Can't handle rule call in rule " + containgRule.getName());
		}
		return null;
	}

	private SyntaxElement importAlternative(Alternatives alternatives) {
		Choice choice = CS_FACTORY.createChoice();
		for (AbstractElement element : alternatives.getElements()) {
			add(choice.getChildren(), importElement(element));
		}
		return wrap(choice, alternatives.getCardinality());
	}

	private SyntaxElement importAction(Action action) {
		String feature = action.getFeature();
		String operator = action.getOperator();
		TypeRef type = action.getType();
		System.err.println("Unsupported action in rule " + findContaingRule(action).getName() + ": feature=" + feature + " operator=" + operator + " type=" + type);
		// TODO handle actions
		return null;
	}

	private SyntaxElement importGroup(Group group) {
		CompoundDefinition compound = CS_FACTORY.createCompoundDefinition();
		Sequence sequence = CS_FACTORY.createSequence();
		compound.getChildren().add(sequence);
		
		List<AbstractElement> elements = group.getElements();
		for (AbstractElement element : elements) {
			SyntaxElement subElement = importElement(element);
			add(sequence.getChildren(), subElement);
		}
		return wrap(compound, group.getCardinality());
	}

	private SyntaxElement importKeyword(Keyword keyword) {
		String cardinality = keyword.getCardinality();
		//System.out.println("Importing keyword: " + keyword.getValue());
		CsString csString = CS_FACTORY.createCsString();
		csString.setValue(keyword.getValue());
		return wrap(csString, cardinality);
	}

	private SyntaxElement importAssignment(Assignment assignment) {
		String cardinality = assignment.getCardinality();
		String feature = assignment.getFeature();
		String operator = assignment.getOperator();
		AbstractElement terminal = assignment.getTerminal();
		//System.out.println("Importing assignment: " + feature + " " + operator + " " + terminal);
		GenFeature genFeature = findGenFeature(assignment, feature);
		EStructuralFeature eFeature = genFeature.getEcoreFeature();
		if (eFeature == null) {
			System.err.println("Can't find feature " + feature);
			return null;
		}
		
		String qualifiedFeatureName = findContaingRule(terminal).getName() + "." + genFeature.getName();
		boolean isBooleanFeature = genFeature.getEcoreFeature().getEType().equals(EcorePackage.eINSTANCE.getEBoolean());
		boolean isStringFeature = genFeature.getEcoreFeature().getEType().equals(EcorePackage.eINSTANCE.getEString());
		if (eFeature instanceof EReference) {
			EReference eReference = (EReference) eFeature;
			if (eReference.isContainment()) {
				Containment containment = CS_FACTORY.createContainment();
				containment.setFeature(genFeature);
				return wrap(containment, cardinality);
			} else {
				if (terminal instanceof TerminalRule) {
					TerminalRule terminalRule = (TerminalRule) terminal;
					PlaceholderUsingSpecifiedToken placeholder = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
					placeholder.setFeature(genFeature);
					placeholder.setToken(getTokenDefinition(placeholder, terminalRule.getName(), true));
					return wrap(placeholder, cardinality);
				} else if (terminal instanceof CrossReference) {
					CrossReference crossReference = (CrossReference) terminal;
					AbstractElement crossTerminal = crossReference.getTerminal();

					if (crossTerminal instanceof RuleCall) {
						RuleCall crossTerminalRule = (RuleCall) crossTerminal;
						PlaceholderUsingSpecifiedToken placeholder = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
						placeholder.setFeature(genFeature);
						String targetRuleName = getTargetRuleName(crossTerminalRule);
						ReferencableTokenDefinition tokenDefinition = getTokenDefinition(placeholder, targetRuleName, false);
						if (tokenDefinition == null) {
							System.err.println("Non-containment feature " + qualifiedFeatureName + " refers to token " + targetRuleName);
						}
						placeholder.setToken(tokenDefinition);
						return wrap(placeholder, cardinality);
					} else {
						System.err.println("Can't handle crossTerminal " + crossTerminal);
						return null;
					}
				} else {
					System.err.println("Can't handle terminal " + terminal);
					return null;
				}
			}
		} else {
			// eFeature is EAttribute
			if (terminal instanceof RuleCall) {
				RuleCall attributeRuleCall = (RuleCall) terminal;
				PlaceholderUsingSpecifiedToken placeholder = CS_FACTORY.createPlaceholderUsingSpecifiedToken();
				placeholder.setFeature(genFeature);
				String targetRuleName = getTargetRuleName(attributeRuleCall);
				ReferencableTokenDefinition tokenDefinition = getTokenDefinition(placeholder, targetRuleName, false);
				if (tokenDefinition != null) {
					placeholder.setToken(tokenDefinition);
					return wrap(placeholder, cardinality);
				} else {
					if (isStringFeature) {
						String message = "Change attribute " + qualifiedFeatureName + " to containment reference";
						//System.err.println(message);
						convertAttributeToContainmentReference(genFeature, terminal.eResource(), targetRuleName);
						attributeChanges += message + "\n";
						return null;
					} else {
						// is probably enum attribute
						System.err.println("Can't handle enum attribute " + qualifiedFeatureName);
						return null;
					}
				}
			} else if (terminal instanceof Keyword && isBooleanFeature) {
				Keyword keyword = (Keyword) terminal;

				BooleanTerminal booleanTerminal = CS_FACTORY.createBooleanTerminal();
				booleanTerminal.setFeature(genFeature);
				booleanTerminal.setTrueLiteral(keyword.getValue());
				booleanTerminal.setFalseLiteral("");
				return wrap(booleanTerminal, cardinality);
			} else if (terminal instanceof Keyword) {
				System.err.println("Unsupported keyword terminal for attribute " + terminal);
				return null;
			} else {
				System.err.println("Can't handle terminal " + terminal);
				return null;
			}
		}
	}

	private void convertAttributeToContainmentReference(GenFeature genFeature, Resource syntaxResource, String typeName) {
		EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		EClass eContainingClass = ecoreFeature.getEContainingClass();
		String name = ecoreFeature.getName();
		EcoreUtil.remove(genFeature);
		EcoreUtil.remove(ecoreFeature);
		
		EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName(name);
		reference.setContainment(true);
		
		GenClass typeGenClass = findGenClass(syntaxResource, typeName);
		EClassifier type = typeGenClass.getEcoreClass();
		reference.setEType(type);
		eContainingClass.getEStructuralFeatures().add(reference);
	}

	private ReferencableTokenDefinition getTokenDefinition(
			PlaceholderUsingSpecifiedToken placeholder, String name, boolean showError) {
		List<TokenDirective> tokens = syntax.getTokens();
		for (TokenDirective token : tokens) {
			if (token instanceof NormalTokenDefinition) {
				NormalTokenDefinition definition = (NormalTokenDefinition) token;
				if (definition.getName().equals(name)) {
					return definition;
				}
			}
		}
		if (showError) {
			System.err.println("Can't find token definition " + name);
		}
		return null;
	}

	private SyntaxElement wrap(SyntaxElement element, String cardinality) {
		if (cardinality == null || "".equals(cardinality)) {
			return element;
		}
		if (element instanceof CardinalityDefinition) {
			CardinalityDefinition definition = (CardinalityDefinition) element;
			definition.setCardinality(convert(cardinality));
			return definition;
		}
		CompoundDefinition compound = CS_FACTORY.createCompoundDefinition();
		compound.getChildren().add(element);
		return wrap(compound, cardinality);
	}

	private Cardinality convert(String cardinality) {
		if ("?".equals(cardinality)) {
			return CS_FACTORY.createQUESTIONMARK();
		} else if ("*".equals(cardinality)) {
			return CS_FACTORY.createSTAR();
		} else if ("+".equals(cardinality)) {
			return CS_FACTORY.createPLUS();
		}
		System.err.println("Found unknown cardinality: " + cardinality);
		return null;
	}

	private void registerResourceFactories() {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/emf/2002/GenModel", GenModelPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());

		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory csResourceFactoryImpl = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cs",
				csResourceFactoryImpl);
		
		new XtextStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
	}

	private AbstractRule findContaingRule(AbstractElement object) {
		if (object == null) {
			System.err.println("Can't find rule for " + object);
			return null;
		}
		if (object instanceof AbstractRule) {
			return (AbstractRule) object;
		}
		EObject eContainer = object.eContainer();
		if (eContainer instanceof AbstractElement) {
			return findContaingRule((AbstractElement) eContainer);
		} else if (eContainer instanceof AbstractRule) {
			return (AbstractRule) eContainer;
		} else {
			System.err.println("Can't find rule for " + object + " (eContainer is " + eContainer + ")");
			return null;
		}
	}

	private String getTargetRuleName(RuleCall ruleCall) {
		if (ruleCall.getRule() != null) {
			return ruleCall.getRule().getName();
		}
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(ruleCall);
		String ruleName = "UNKNOWN";
		if (nodeAdapter != null) {
			List<LeafNode> leafs = nodeAdapter.getParserNode().getLeafNodes();
			for (LeafNode leaf : leafs) {
				if (!leaf.isHidden()) {
					ruleName = leaf.getText();
					break;
				}
			}
		}
		return ruleName;
	}

	private String escapeToRegexString(String text) {
		if (text == null) {
			return null;
		}
		//for ANTLR regex syntax: replace one backslash by two and escape single quotes
		String result = text.replaceAll("\\\\", "\\\\\\\\").
			replaceAll("\'", "\\\\\'").
			replace("\b", "\\b").
			replace("\f", "\\f").
			replace("\n", "\\n").
			replace("\r", "\\r").
			replace("\t", "\\t");
		
		StringBuffer complete = new StringBuffer();
		for (int i = 0; i < result.length(); i++) {
			int codePointI = result.codePointAt(i);
			if (codePointI >= 32 && codePointI <= 127) {
				complete.append(Character.toChars(codePointI));
			} else {
				// use Unicode representation
				complete.append("\\u");
				String hex = Integer.toHexString(codePointI);
				complete.append(getRepeatingString(4 - hex.length(), '0'));
				complete.append(hex);
			}
		}
		return complete.toString();
	}

    private String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}
}
