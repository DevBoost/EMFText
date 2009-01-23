package org.emftext.sdk.codegen;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.AbstractEMFTextPrinter;
import org.emftext.sdk.codegen.util.StringComponent;
import org.emftext.sdk.codegen.util.StringComposite;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.DerivedPlaceholder;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * A generator that creates the base class for the printer.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class TextPrinterBaseGenerator extends BaseGenerator {

	private static final String OBJECT_CLASS_NAME = Object.class.getName();
	private static final String STRING_CLASS_NAME = String.class.getName();
	private static final String INTEGER_CLASS_NAME = Integer.class.getName();

	private static final String COLLECTION_CLASS_NAME = Collection.class.getName();
	private static final String LIST_CLASS_NAME = List.class.getName();
	private static final String MAP_CLASS_NAME = Map.class.getName();
	private static final String HASH_MAP_CLASS_NAME = HashMap.class.getName();
	private static final String ARRAYS_CLASS_NAME = java.util.Arrays.class.getName();
	private static final String LIST_ITERATOR_CLASS_NAME = ListIterator.class.getName();
	
	private static final String NULL_POINTER_CLASS_NAME = NullPointerException.class.getName();
	
	private static final String EOBJECT_CLASS_NAME = EObject.class.getName();
	private static final String EREFERENCE_CLASS_NAME = EReference.class.getName();
	
	private static final String ITEXT_RESOURCE_CLASS_NAME = ITextResource.class.getName();
	private static final String ITOKEN_RESOLVER_FACTORY_CLASS_NAME = ITokenResolverFactory.class.getName();
	private static final String IREFERENCE_RESOLVER_SWITCH_CLASS_NAME = IReferenceResolverSwitch.class.getName();
	
	private static final String OUTPUT_STREAM_CLASS_NAME = OutputStream.class.getName();
	private static final String PRINTER_WRITER_CLASS_NAME = PrintWriter.class.getName();
	private static final String STRING_WRITER_CLASS_NAME = StringWriter.class.getName();
	
	private ConcreteSyntax concretSyntax;
	private String tokenResolverFactoryClassName;

	private int tokenSpace;
	/** maps all choices to a method name */
	private Map<Choice, String> choice2Name;
	/** maps all rules to choices nested somewhere, but not to the root choice! */
	private Map<Rule, Set<Choice>> rule2SubChoice;
	/** 
	 * maps all sequences in all choices to all features which HAVE to be printed in the sequence
	 */
	private Map<Sequence, Set<String>> sequence2NecessaryFeatures;
	private Map<Sequence, Set<String>> sequence2ReachableFeatures;
	private Map<DerivedPlaceholder, String> placeholder2TokenName;
	private String treeAnalyserClassName;

	public TextPrinterBaseGenerator(GenerationContext context, Map<DerivedPlaceholder, String> placeholder2TokenName) {
		
		super(context.getPackageName(), context.getPrinterBaseClassName());

		this.concretSyntax = context.getConcreteSyntax();
		this.tokenResolverFactoryClassName = context.getTokenResolverFactoryClassName();
		this.treeAnalyserClassName = context.getReferenceResolverSwitchClassName();
		this.placeholder2TokenName = placeholder2TokenName;
	}

	private void extractChoices(List<Rule> rules,
			Map<Rule, Set<Choice>> ruleMap, Map<Choice, String> choiceMap,
			Map<Sequence, Set<String>> necessaryMap,
			Map<Sequence, Set<String>> reachableMap) {
		for (Rule rule : rules) {
			choiceMap.put(rule.getDefinition(), getMethodName(rule));
			Set<Choice> choices = new HashSet<Choice>();
			ruleMap.put(rule, choices);
			extractChoices(rule.getDefinition(), choices, choiceMap,
					necessaryMap, reachableMap, null, getMethodName(rule) + "_", 0);
		}
	}

	private static void extractChoices(Choice choice, Set<Choice> choiceSet,
			Map<Choice, String> choiceMap,
			Map<Sequence, Set<String>> necessaryMap,
			Map<Sequence, Set<String>> reachableMap, Sequence parent,
			String namePrefix, int choiceIndex) {
		for (Sequence seq : choice.getOptions()) {
			Set<String> sequenceNecessaryFeatures = new HashSet<String>();
			Set<String> sequenceReachableFeatures = new HashSet<String>();
			necessaryMap.put(seq, sequenceNecessaryFeatures);
			reachableMap.put(seq, sequenceReachableFeatures);
			for (Definition def : seq.getParts()) {
				if (def instanceof CompoundDefinition) {
					String subChoiceName = namePrefix + choiceIndex++;
					Choice currentChoice = ((CompoundDefinition) def)
							.getDefinitions();
					choiceMap.put(currentChoice, subChoiceName);
					choiceSet.add(currentChoice);
					extractChoices(currentChoice, choiceSet, choiceMap,
							necessaryMap, reachableMap,
							(def.getCardinality() == null || def
									.getCardinality() instanceof PLUS) ? seq
									: null, subChoiceName + "_", 0);
				} else if (def instanceof Terminal) {
					if ((def.getCardinality() == null || def.getCardinality() instanceof PLUS))
						sequenceNecessaryFeatures.add(((Terminal) def)
								.getFeature().getName());
					sequenceReachableFeatures.add(((Terminal) def).getFeature()
							.getName());
				}
			}
			if (parent != null) {
				necessaryMap.get(parent).addAll(sequenceNecessaryFeatures);
				reachableMap.get(parent).addAll(sequenceReachableFeatures);
			}

		}
	}

	private List<Rule> prepare() {
		List<Rule> rules = concretSyntax.getAllRules();
		choice2Name = new HashMap<Choice, String>(rules.size());
		sequence2NecessaryFeatures = new HashMap<Sequence, Set<String>>(rules
				.size());
		sequence2ReachableFeatures = new HashMap<Sequence, Set<String>>(rules
				.size());
		rule2SubChoice = new HashMap<Rule, Set<Choice>>(rules.size());
		extractChoices(rules, rule2SubChoice, choice2Name,
				sequence2NecessaryFeatures, sequence2ReachableFeatures);
		
        tokenSpace = OptionManager.INSTANCE.getIntegerOptionValue(concretSyntax, ICodeGenOptions.CS_OPTION_TOKENSPACE, true, this);
		if (tokenSpace < 0) {
			tokenSpace = 0;
		}
		return rules;
	}

	@Override
	public boolean generate(PrintWriter writer) {
		List<Rule> rules = prepare();
		
		StringComposite out = new StringComposite();
		out.println("package " + getResourcePackageName() + ";");
		out.println();
		out.println("public abstract class " + getResourceClassName()
				+ " extends " + AbstractEMFTextPrinter.class.getName() + " {").tab();
		out.println();
		
		generateMembers(out);
		out.println();
		
		generateConstructor(out);
		out.println();
		
		printMatchRule(out);
		out.println();
		
		generateDoPrintMethod(out, rules);
		out.println();
		
		for (Rule rule : rules) {
			generatePrintRuleMethod(out, rule);
			out.println();
		}

		out.backTab().println("}");
		
		writer.write(out.toString());
		return true;
	}

	private void generateDoPrintMethod(StringComposite out, List<Rule> rules) {
		out.println("protected void doPrint(" + EOBJECT_CLASS_NAME + " element, " + PRINTER_WRITER_CLASS_NAME + " out, " + STRING_CLASS_NAME + " globaltab) {").tab();
		out.println("if (element == null || out == null) throw new " + NULL_POINTER_CLASS_NAME + "(\"Nothing to write or to write on.\");");
		out.println();
		Queue<Rule> ruleQueue = new LinkedList<Rule>(rules);
		while (!ruleQueue.isEmpty()) {
			Rule rule = ruleQueue.remove();
			// check whether all subclass calls have been printed
			if (GeneratorUtil.hasSubClassesWithCS(rule.getMetaclass(),
					ruleQueue)) {
				ruleQueue.add(rule);
			} else {
				out.println("if (element instanceof " + getMetaClassName(rule) + ") {").tab();
				out.println(getMethodName(rule) + "((" + getMetaClassName(rule)
						+ ") element, globaltab, out);");
				out.println("return;");
				out.backTab().println("}");
			}
		}
		out.println();
		out.println("resource.addWarning(\"The cs printer can not handle \" + element.eClass().getName() + \" elements\", element);");
		out.backTab().println("}");
	}

	private void generateConstructor(StringComposite out) {
		out.println("public " + super.getResourceClassName()
				+ "(" + OUTPUT_STREAM_CLASS_NAME + " o, " + ITEXT_RESOURCE_CLASS_NAME + " resource) {");
		out.tab();
		out.println("super(o, resource);");
		out.backTab();
		out.println("}");
	}

	private void generateMembers(StringComposite out) {
		out.println("protected " + ITOKEN_RESOLVER_FACTORY_CLASS_NAME + " tokenResolverFactory = new "
						+ tokenResolverFactoryClassName + "();");
		out.println("protected " + IREFERENCE_RESOLVER_SWITCH_CLASS_NAME + " referenceResolverSwitch = new "
				+ treeAnalyserClassName + "();");
	}

	private void generatePrintRuleMethod(StringComposite out, Rule rule) {
		
		List<EStructuralFeature> featureList = rule.getMetaclass().getEcoreClass().getEAllStructuralFeatures();
		StringComponent localTabDefinition = new StringComponent(STRING_CLASS_NAME + " localtab = outertab;");
		StringComponent mapDefinition = new StringComponent(MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> printCountingMap = new " + HASH_MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + ">("
				+ featureList.size() + ");");

		out.println("public void " + getMethodName(rule) + "("
				+ getMetaClassName(rule)
				+ " element, " + STRING_CLASS_NAME + " outertab, " + PRINTER_WRITER_CLASS_NAME + " out) {");
		out.tab();

		out.println(localTabDefinition);
		out.println(mapDefinition);
		
		if (featureList.size() > 0) {
			out.println(OBJECT_CLASS_NAME + " temp;");
		}
		for (EStructuralFeature feature : featureList) {
			out.println("temp = element." + generateAccessMethod(feature)
					+ ";");
			String featureSize = feature.getUpperBound() == -1 ? "((" + java.util.Collection.class.getName() + "<?>) temp).size()"
					: "1";
			out.println("printCountingMap.put(\"" + feature.getName()
					+ "\", temp == null ? 0 : " + featureSize + ");");
			mapDefinition.enable();
		}
		generatePrintCollectedTokensCode(out, rule);
		
		printChoice(rule.getDefinition(), out, rule.getMetaclass()
				.getEcoreClass(), localTabDefinition);
		out.backTab();
		out.println("}");
		printChoices(out, rule);
	}

	private void printChoices(StringComposite out, Rule rule) {
		for (Choice choice : rule2SubChoice.get(rule)) {
			out
					.println("public void "
							+ choice2Name.get(choice)
							+ "("
							+ getMetaClassName(rule)
							+ " element, " + STRING_CLASS_NAME + " outertab, " + PRINTER_WRITER_CLASS_NAME + " out, " + MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> printCountingMap){");
			out.tab();
			StringComponent localTabDefinition = new StringComponent(STRING_CLASS_NAME + " localtab = outertab;");
			out.println(localTabDefinition);
			printChoice(choice, out, rule.getMetaclass().getEcoreClass(), localTabDefinition);
			out.backTab();
			out.println("}");
		}
	}

	private String getMetaClassName(Rule rule) {
		return rule.getMetaclass().getQualifiedInterfaceName();
	}

	private String getMethodName(Rule rule) {
		String className = rule.getMetaclass().getQualifiedInterfaceName();
		// first escape underscore with their unicode value
		className = className.replace("_", "_005f");
		// then replace package separator with underscore
		className = className.replace(".", "_");
		return "print_" +  className;
	}

	private void generatePrintCollectedTokensCode(StringComposite out, Rule rule) {

		List<EStructuralFeature> featureList = rule.getMetaclass().getEcoreClass().getEAllStructuralFeatures();

		out.println("// print collected hidden tokens");
		for (EStructuralFeature feature : featureList) {
			if (isCollectInFeature(rule, feature)) {
				// TODO use feature id constant instead
				out.println("{");
				out.tab();
				out.println(EStructuralFeature.class.getName() + " feature = element.eClass().getEStructuralFeature(" + feature.getFeatureID() + ");");
				out.println(OBJECT_CLASS_NAME + " value = element.eGet(feature);");
				out.println("if (value instanceof " + LIST_CLASS_NAME + ") {");
				out.tab();
				out.println("for (" + OBJECT_CLASS_NAME + " next : (" + LIST_CLASS_NAME + "<?>) value) {");
				out.tab();
				out.println("out.print(tokenResolverFactory.createCollectInTokenResolver(\"" + feature.getName() + "\").deResolve(next, feature, element));");
				out.backTab();
				out.println("}");
				out.backTab();
				out.println("}");
				out.backTab();
				out.println("}");
			}
		}
	}

	private boolean isCollectInFeature(Rule rule, EStructuralFeature feature) {
		for (TokenDefinition tokenDefinition : rule.getSyntax().getTokens()) {
			final String attributeName = tokenDefinition.getAttributeName();
			final boolean isCollectToken = attributeName != null;
			if (!isCollectToken) {
				continue;
			}
			final boolean namesMatch = attributeName.equals(feature.getName());
			if (namesMatch) {
				return true;
			}
		}
		return false;
	}

	private void printChoice(Choice choice, StringComposite out, EClass metaClass, StringComponent localTabDefinition) {
		StringComponent countDefintion = new StringComponent("int count;");
		if (choice.getOptions().size() > 1) {
			out.println(countDefintion);
			out.println("int alt=-1;");
			Iterator<Sequence> seqIt = choice.getOptions().iterator();
			if (seqIt.hasNext()) {
				Sequence firstSeq = seqIt.next();
				int count = 0;
				StringComposite out1 = new StringComposite();
				out1.println("switch(alt){");
				out.println("alt=" + count++ + ";");
				out.print("int matches=");
				printMatchCall(firstSeq, out);
				out.println("int tempMatchCount;");
				while (seqIt.hasNext()) {
					Sequence seq = seqIt.next();
					out.print("tempMatchCount=");
					printMatchCall(seq, out);
					out.println("if (tempMatchCount > matches) {");
					out.tab();
					out.println("alt = " + count + ";");
					out.println("matches = tempMatchCount;");
					out.backTab();
					out.println("}");

					out1.println("\tcase " + count + ":");
					// extra scope for case begin
					out1.println("\t\t{");
					printSequence(seq, out1, metaClass, localTabDefinition, countDefintion);
					// extra scope for case end
					out1.println("\t\t}");
					out1.println("\tbreak;");
					count++;
				}

				out1.println("\t\t\tdefault:");
				printSequence(firstSeq, out1, metaClass, localTabDefinition, countDefintion);
				out1.println("\t\t}");
				out.print(out1.toString());
			}
		} else if (choice.getOptions().size() == 1) {
			out.println(countDefintion);
			printSequence(choice.getOptions().get(0), out, metaClass, localTabDefinition, countDefintion);
		}

	}

	private Set<String> getReachableFeatures(Choice choice) {
		Set<String> result = new LinkedHashSet<String>();
		for (Sequence seq : choice.getOptions()) {
			result.addAll(sequence2ReachableFeatures.get(seq));
		}
		return result;
	}

	private void printSequence(Sequence sequence, StringComposite out,
			EClass metaClass, StringComponent localTabDefinition, StringComponent countDefintion) {
		Set<String> neededFeatures = new LinkedHashSet<String>(
				sequence2NecessaryFeatures.get(sequence));

		StringComponent iterateDeclaration = new StringComponent("boolean iterate = true;");

		StringComposite compoundDeclaration = new StringComposite(false);
		compoundDeclaration.println(STRING_WRITER_CLASS_NAME + " sWriter = null;");
		compoundDeclaration.println(PRINTER_WRITER_CLASS_NAME + " out1 = null;");
		compoundDeclaration.println(HASH_MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> printCountingMap1 = null;");

		ListIterator<Definition> definitionIterator = sequence.getParts()
				.listIterator();
		
		out.println(iterateDeclaration);
		out.println(compoundDeclaration);
		while (definitionIterator.hasNext()) {
			Definition definition = definitionIterator.next();
			
			out.println("//////////////DEFINITION PART BEGINS ("
					+ definition.eClass().getName() + "):");
			String printPrefix = "out.print(";
			if (definition instanceof LineBreak) {
				int count = ((LineBreak) definition).getTab();
				if (count > 0) {
					String tab = getTabString(count);
					out.println("localtab += \"" + tab + "\";");
				}
				out.println("out.println();");
				out.println("out.print(localtab);");
				localTabDefinition.enable();
			} else {
				if (definition instanceof WhiteSpaces) {
					int count = ((WhiteSpaces) definition).getAmount();
					if (count > 0) {
						String spaces = getWhiteSpaceString(count);
						out.println(printPrefix + "\"" + spaces
								+ "\");");
					}
				} else if (definition instanceof CsString) {
					CsString terminal = (CsString) definition;
					out.println(printPrefix + "\""
							+ terminal.getValue().replaceAll("\"", "\\\\\"")
							+ "\");");

					// the given tokenSpace (>0) causes an additional
					// print statement to be printed
					if (tokenSpace > 0) {
						Definition lookahead = null;
						if (definitionIterator.hasNext()){
							lookahead = definitionIterator.next();
							definitionIterator.previous();
						}
							
						if (lookahead == null
								|| !(lookahead instanceof WhiteSpaces)) {
							String printSuffix = getWhiteSpaceString(tokenSpace);
							
							out.println(printPrefix + "\"" + printSuffix + "\");");
						}
							
					}

				} else {
					Cardinality cardinality = definition.getCardinality();
					if (definition instanceof CompoundDefinition) {
						CompoundDefinition compound = (CompoundDefinition) definition;
						String printStatement = 
								choice2Name.get(compound.getDefinitions())
								+ "(element, localtab, out, printCountingMap);";
						localTabDefinition.enable();
						// enter once
						if (cardinality == null || cardinality instanceof PLUS) {
							out.println(printStatement);
							// needed features in non optional choice are also
							// needed features in this sequence
							// note: this implementation might remove to much in
							// some cases!
							for (Sequence seq1 : compound.getDefinitions()
									.getOptions()) {
								neededFeatures
										.removeAll(sequence2NecessaryFeatures
												.get(seq1));
							}
						}
						// optional cases
						if (cardinality != null) {

							boolean isMany = !(cardinality instanceof QUESTIONMARK);
							// runtime: iterate as long as no fixpoint is
							// reached
							// make sure that NOT all elements of needed
							// features are printed in optional compounds!
							if (isMany) {
								out.println("iterate = true;");
								out.println("while (iterate) {").tab();
								iterateDeclaration.enable();
							}
							out.println("sWriter = new " + STRING_WRITER_CLASS_NAME + "();");
							out.println("out1 = new " + PRINTER_WRITER_CLASS_NAME + "(sWriter);");
							out.println("printCountingMap1 = new " + HASH_MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + ">(printCountingMap);");
							compoundDeclaration.enable();
							
							out.println(choice2Name.get(compound
													.getDefinitions())
											+ "(element, localtab, out1, printCountingMap1);");
							out.println("if (printCountingMap.equals(printCountingMap1)) {");
							out.tab();
							if (isMany) {
								out.println("iterate = false;");
							}
							out.println("out1.close();");
							out.backTab();
							out.println("} else {");
							out.tab();
							// check if printed features are needed by
							// subsequent features
							// at least one element has to be preserved in that
							// case!
							// this could be enhanced by a counter on needed
							// features
							Collection<String> reachableFeatures = getReachableFeatures(compound
									.getDefinitions());
							if (!neededFeatures.isEmpty()
									&& !Collections.disjoint(neededFeatures,
											reachableFeatures)) {
								out.print("if(");
								Iterator<String> it = neededFeatures.iterator();
								out.print("printCountingMap1.get(\""
										+ it.next() + "\")<1");
								while (it.hasNext()) {
									String feature = it.next();
									out.print("printCountingMap1.get(\""
											+ feature + "\")<1");
								}
								out.println(") {");
								out.tab();
								if (isMany) {
									out.println("iterate = false;");
								}
								out.println("out1.close();");
								out.backTab();
								out.println("} else {");
								out.tab();
								out.println("out1.flush();");
								out.println("out1.close();");
								out.println("out.print(sWriter.toString());");
								out.println("printCountingMap.putAll(printCountingMap1);");
								out.backTab();
								out.println("}");
							} else {
								out.println("out1.flush();");
								out.println("out1.close();");
								out.println("out.print(sWriter.toString());");
								out.println("printCountingMap.putAll(printCountingMap1);");
							}
							out.backTab();
							out.println("}");
							if (isMany) {
								out.backTab().println("}");
							}
						}
					}
					// next steps: references --> proxy uri --> tokenresolver!
					else if (definition instanceof Terminal) {
						Terminal terminal = (Terminal) definition;
						String featureName = terminal.getFeature().getName();
						out.println("count = printCountingMap.get(\""
								+ featureName + "\");");
						EStructuralFeature feature = terminal.getFeature()
								.getEcoreFeature();
						String printStatement = null;

						if (terminal instanceof Placeholder) {
							String tokenName;
							if (terminal instanceof DefinedPlaceholder)
								tokenName = ((DefinedPlaceholder) terminal)
										.getToken().getName();
							else {
								assert terminal instanceof DerivedPlaceholder;
								tokenName = placeholder2TokenName
										.get((DerivedPlaceholder) terminal);
							}

							if (feature instanceof EReference) {
								printStatement = 
										ITokenResolver.class.getName() + " resolver = tokenResolverFactory.createTokenResolver(\""
										+ tokenName
										+ "\");resolver.setOptions(getOptions());"
										+ printPrefix 
										+ "resolver.deResolve(referenceResolverSwitch.deResolve((" + EOBJECT_CLASS_NAME + ")o, element, (" + EREFERENCE_CLASS_NAME + ")element.eClass().getEStructuralFeature(\""
										+ featureName
										+ "\")),element.eClass().getEStructuralFeature(\""
										+ featureName + "\"),element));";
							} else {
								printStatement = 
										ITokenResolver.class.getName() + " resolver = tokenResolverFactory.createTokenResolver(\""
										+ tokenName
										+ "\");\n\t\t\t\t"
										+ "resolver.setOptions(getOptions());\n\t\t\t\t"
										+ printPrefix
										+ "resolver.deResolve((" + OBJECT_CLASS_NAME + ")o,element.eClass().getEStructuralFeature(\""
										+ featureName + "\"),element));\n\t\t\t\t";
							}


							// the given tokenSpace (>0) causes an additional
							// print statement to be printed
							if (tokenSpace > 0) {
								Definition lookahead = null;
								if (definitionIterator.hasNext()){
									lookahead = definitionIterator.next();
									definitionIterator.previous();
								}
									
								if (lookahead == null
										|| !(lookahead instanceof WhiteSpaces)) {
									String printSuffix = getWhiteSpaceString(tokenSpace);
									printStatement = printStatement
											+ "out.print(\"" + printSuffix + "\");";
								}
									
							}

						} else {
							assert terminal instanceof Containment;
							printStatement = "doPrint((" + EOBJECT_CLASS_NAME + ") o, out, localtab);";
							localTabDefinition.enable();
						}

						out.println("if (count > 0) {");
						countDefintion.enable();
						if (cardinality == null
								|| (cardinality instanceof QUESTIONMARK && !neededFeatures
										.contains(featureName))) {
							out.println("\tObject o =element."
									+ generateAccessMethod(feature) + ";");
							if (feature.getUpperBound() != 1) {
								out.println("\to = ((" + LIST_CLASS_NAME +"<?>)o).get(((" + LIST_CLASS_NAME +"<?>)o).size() - count);");
							}
							out.println("\t" + printStatement);
							out.println("\tprintCountingMap.put(\""
									+ featureName + "\",count-1);");
							neededFeatures.remove(featureName);
						} else if (cardinality instanceof PLUS
								|| cardinality instanceof STAR) {
							if (feature.getUpperBound() != 1) {
								out.println("\t" + LIST_ITERATOR_CLASS_NAME + "<?> it  = ((" + LIST_CLASS_NAME +"<?>) element."
												+ generateAccessMethod(feature)
												+ ").listIterator(((" + LIST_CLASS_NAME +"<?>)element."
												+ generateAccessMethod(feature)
												+ ").size()-count);");
								out.println("\twhile(it.hasNext()){");
								out.println("\t\t" + OBJECT_CLASS_NAME + " o = it.next();");
								if (cardinality instanceof STAR
										&& neededFeatures.contains(featureName)) {
									out.println("\t\tif(!it.hasNext())");
									out.println("\t\t\tbreak;");
								}
								out.println("\t\t" + printStatement);
								out.println("\t}");
								out.println("\tprintCountingMap.put(\""
										+ featureName + "\",0);");
							} else if (cardinality instanceof PLUS) {
								out.println("\t" + OBJECT_CLASS_NAME + " o =element."
										+ generateAccessMethod(feature) + ";");
								out.println("\t" + printStatement);
								out.println("\tprintCountingMap.put(\""
										+ featureName + "\",count-1);");
							}
							if (cardinality instanceof PLUS)
								neededFeatures.remove(featureName);
						}

						out.println("}"); // tab for if(count>0)
					}
				}
			}
		}
	}

	private void printMatchCall(Sequence seq, StringComposite out) {
		if (sequence2NecessaryFeatures.get(seq).isEmpty()) {
			out.println("0;");
			return;
		}
		out.print("matchCount(printCountingMap, " + ARRAYS_CLASS_NAME + ".asList(");
		boolean notFirst = false;
		for (String featureName : sequence2NecessaryFeatures.get(seq)) {
			if (notFirst) {
				out.print(",");
			} else {
				notFirst = true;
			}
			out.print("\"" + featureName + "\"");
		}
		out.println("));");
	}


	private void printMatchRule(StringComposite out) {
		out.println("protected static int matchCount(" + MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> featureCounter, " + COLLECTION_CLASS_NAME + "<" + STRING_CLASS_NAME+ "> needed){");
		out.tab();
		out.println("int pos = 0;");
		out.println("int neg = 0;");
		out.println();
		out.println("for(" + STRING_CLASS_NAME + " featureName:featureCounter.keySet()){");
		out.tab();
		out.println("if(needed.contains(featureName)){");
		out.tab();
		out.println("int value = featureCounter.get(featureName);");
		out.println("if (value == 0) {");
		out.tab();
		out.println("neg += 1;");
		out.backTab();
		out.println("} else {");
		out.tab();
		out.println("pos += 1;");
		out.backTab();
		out.println("}");
		out.backTab();
		out.println("}");
		out.backTab();
		out.println("}");
		out.println("return neg > 0 ? -neg : pos;");
		out.backTab();
		out.println("}");
	}

	protected static String generateAccessMethod(EStructuralFeature feature) {
		String method = "eGet(element.eClass().getEStructuralFeature(\"" + feature.getName() + "\"))";
		return method;
	}

	private String getTabString(int count) {
		return getRepeatingString(count, '\t');
	}

	private String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer spaces = new StringBuffer();
		for (int i = 0; i < count; i++) {
			spaces.append(character);
		}
		return spaces.toString();
	}
}
