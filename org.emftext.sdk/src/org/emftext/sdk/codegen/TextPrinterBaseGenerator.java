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
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.EMFTextPrinterImpl;
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
	private static final String IREFERENCE_RESOLVER_CLASS_NAME = IReferenceResolver.class.getName();
	
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
		this.treeAnalyserClassName = context.getTreeAnalyserClassName();
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
		
        tokenSpace = OptionManager.INSTANCE.getIntegerOption(concretSyntax, ICodeGenOptions.CS_OPTION_TOKENSPACE, true, this);
		if (tokenSpace < 0) {
			tokenSpace = 0;
		}
		return rules;
	}

	@Override
	public boolean generate(PrintWriter out) {
		List<Rule> rules = prepare();
		
		out.println("package " + getResourcePackageName() + ";");
		out.println();
		out.println("public abstract class " + getResourceClassName()
				+ " extends " + EMFTextPrinterImpl.class.getName() + " {");
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
		
		out.println("}");
		return true;
	}

	private void generateDoPrintMethod(PrintWriter out, List<Rule> rules) {
		out
				.println("\tprotected void doPrint(" + EOBJECT_CLASS_NAME + " element, " + PRINTER_WRITER_CLASS_NAME + " out, " + STRING_CLASS_NAME + " globaltab) {");
		out
				.println("\t\tif (element == null || out == null) throw new " + NULL_POINTER_CLASS_NAME + "(\"Nothing to write or to write on.\");");
		out.println();
		Queue<Rule> ruleQueue = new LinkedList<Rule>(rules);
		while (!ruleQueue.isEmpty()) {
			Rule rule = ruleQueue.remove();
			// check whether all subclass calls have been printed
			if (GeneratorUtil.hasSubClassesWithCS(rule.getMetaclass(),
					ruleQueue)) {
				ruleQueue.add(rule);
			} else {
				out.println("\t\tif(element instanceof " + getMetaClassName(rule) + "){");
				out.println("\t\t\t" + getMethodName(rule) + "((" + getMetaClassName(rule)
						+ ") element, globaltab, out);");
				out.println("\t\t\treturn;");
				out.println("\t\t}");
			}
		}
		out.println();
		out
				.println("\t\tresource.addWarning(\"The cs printer can not handle \" + element.eClass().getName() + \" elements\", element);");
		out.println("\t}");
	}

	private void generateConstructor(PrintWriter out) {
		out.println("\tpublic " + super.getResourceClassName()
				+ "(" + OUTPUT_STREAM_CLASS_NAME + " o, " + ITEXT_RESOURCE_CLASS_NAME + " resource) {");
		out.println("\t\tsuper(o, resource);");
		out.println("\t}");
	}

	private void generateMembers(PrintWriter out) {
		out
				.println("\tprotected " + ITOKEN_RESOLVER_FACTORY_CLASS_NAME + " tokenResolverFactory = new "
						+ tokenResolverFactoryClassName + "();");
		out.println("\tprotected " + IREFERENCE_RESOLVER_CLASS_NAME + " treeAnalyser = new "
				+ treeAnalyserClassName + "();");
	}

	private void generatePrintRuleMethod(PrintWriter out, Rule rule) {
		
		out.println("\tpublic void " + getMethodName(rule) + "("
				+ getMetaClassName(rule)
				+ " element, " + STRING_CLASS_NAME + " outertab, " + PRINTER_WRITER_CLASS_NAME + " out){");
		out.println("\t\t" + STRING_CLASS_NAME+ " localtab = outertab;");
		List<EStructuralFeature> featureList = rule.getMetaclass()
				.getEcoreClass().getEAllStructuralFeatures();

		out.println("\t\t" + MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> printCountingMap = new " + HASH_MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + ">("
						+ featureList.size() + ");");
		if (featureList.size() > 0) {
			out.println("\t\t" + OBJECT_CLASS_NAME + " temp;");
		}
		for (EStructuralFeature feature : featureList) {
			out.println("\t\ttemp = element." + generateAccessMethod(feature)
					+ ";");
			String featureSize = feature.getUpperBound() == -1 ? "((" + java.util.Collection.class.getName() + "<?>) temp).size()"
					: "1";
			out.println("\t\tprintCountingMap.put(\"" + feature.getName()
					+ "\", temp == null ? 0 : " + featureSize + ");");
		}
		generatePrintCollectedTokensCode(out, rule);
		
		printChoice(rule.getDefinition(), out, rule.getMetaclass()
				.getEcoreClass());
		out.println("\t}");
		for (Choice choice : rule2SubChoice.get(rule)) {
			out
					.println("\tpublic void "
							+ choice2Name.get(choice)
							+ "("
							+ getMetaClassName(rule)
							+ " element, " + STRING_CLASS_NAME + " outertab, " + PRINTER_WRITER_CLASS_NAME + " out, " + MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> printCountingMap){");
			out.println("\t\t" + STRING_CLASS_NAME + " localtab = outertab;");
			printChoice(choice, out, rule.getMetaclass().getEcoreClass());
			out.println("\t}");
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

	private void generatePrintCollectedTokensCode(PrintWriter out, Rule rule) {

		List<EStructuralFeature> featureList = rule.getMetaclass().getEcoreClass().getEAllStructuralFeatures();

		out.println("// TODO print collected hidden tokens");
		for (EStructuralFeature feature : featureList) {
			if (isCollectInFeature(rule, feature)) {
				// TODO use feature id constant instead
				out.println("\t\t{");
				out.println("\t\t\t" + OBJECT_CLASS_NAME + " value = element.eGet(element.eClass().getEStructuralFeature(" + feature.getFeatureID() + "));");
				out.println("\t\t\tif (value instanceof java.util.List) {");
				out.println("\t\t\t\tfor (" + OBJECT_CLASS_NAME + " next : (" + LIST_CLASS_NAME + ") value) {");
				out.println("\t\t\t\t\tout.print(next);");
				out.println("\t\t\t\t}");
				out.println("\t\t\t}");
				out.println("\t\t}");
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

	private void printChoice(Choice choice, PrintWriter out, EClass metaClass) {
		if (choice.getOptions().size() > 1) {
			out.println("\t\tint count;");
			out.println("\t\tint alt=-1;");
			Iterator<Sequence> seqIt = choice.getOptions().iterator();
			if (seqIt.hasNext()) {
				Sequence firstSeq = seqIt.next();
				int count = 0;
				StringWriter switchString = new StringWriter();
				PrintWriter out1 = new PrintWriter(switchString);
				out1.println("\t\tswitch(alt){");
				out.println("\t\talt=" + count++ + ";");
				out.print("\t\tint matches=");
				printMatchCall(firstSeq, out);
				out.println("\t\tint tempMatchCount;");
				while (seqIt.hasNext()) {
					Sequence seq = seqIt.next();
					out.print("\t\ttempMatchCount=");
					printMatchCall(seq, out);
					out.println("\t\tif (tempMatchCount > matches) {");
					out.println("\t\t\talt = " + count + ";");
					out.println("\t\t\tmatches = tempMatchCount;");
					out.println("\t\t}");

					out1.println("\t\t\tcase " + count + ":");
					// extra scope for case begin
					out1.println("\t\t\t\t{");
					printSequence(seq, out1, metaClass, "\t\t\t\t\t");
					// extra scope for case end
					out1.println("\t\t\t\t}");
					out1.println("\t\t\tbreak;");
					count++;
				}

				out1.println("\t\t\tdefault:");
				printSequence(firstSeq, out1, metaClass, "\t\t\t\t");
				out1.println("\t\t}");
				out1.flush();
				out1.close();
				out.print(switchString.toString());
			}
		} else if (choice.getOptions().size() == 1) {
			out.println("\t\tint count;");
			printSequence(choice.getOptions().get(0), out, metaClass, "\t\t");
		}

	}

	private Set<String> getReachableFeatures(Choice choice) {
		Set<String> result = new LinkedHashSet<String>();
		for (Sequence seq : choice.getOptions()) {
			result.addAll(sequence2ReachableFeatures.get(seq));
		}
		return result;
	}

	private void printSequence(Sequence sequence, PrintWriter out,
			EClass metaClass, String basetab) {
		Set<String> neededFeatures = new LinkedHashSet<String>(
				sequence2NecessaryFeatures.get(sequence));
		boolean needsCompoundDecl = true;
		boolean needsIterateDecl = true;
		ListIterator<Definition> definitionIterator = sequence.getParts()
				.listIterator();
		while (definitionIterator.hasNext()) {
			Definition definition = definitionIterator.next();
			
			out.println(basetab + "//////////////DEFINITION PART BEGINS ("
					+ definition.eClass().getName() + "):");
			String printPrefix = "out.print(";
			if (definition instanceof LineBreak) {
				int count = ((LineBreak) definition).getTab();
				if (count > 0) {
					String tab = getTabString(count);
					out.println(basetab + "localtab += \"" + tab + "\";");
				}
				out.println(basetab + "out.println();");
				out.println(basetab + "out.print(localtab);");
			} else {
				if (definition instanceof WhiteSpaces) {
					int count = ((WhiteSpaces) definition).getAmount();
					if (count > 0) {
						String spaces = getWhiteSpaceString(count);
						out.println(basetab + printPrefix + "\"" + spaces
								+ "\");");
					}
				} else if (definition instanceof CsString) {
					CsString terminal = (CsString) definition;
					out.println(basetab + printPrefix + "\""
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
							
							out.println(basetab + printPrefix + "\"" + printSuffix + "\");");
						}
							
					}

				} else {
					Cardinality cardinality = definition.getCardinality();
					if (definition instanceof CompoundDefinition) {
						CompoundDefinition compound = (CompoundDefinition) definition;
						String printStatement = 
								choice2Name.get(compound.getDefinitions())
								+ "(element,localtab,out,printCountingMap);";
						// enter once
						if (cardinality == null || cardinality instanceof PLUS) {
							out.println(basetab + printStatement);
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
							String tab = basetab;

							boolean isMany = !(cardinality instanceof QUESTIONMARK);
							// runtime: iterate as long as no fixpoint is
							// reached
							// make sure that NOT all elements of needed
							// features are printed in optional compounds!
							if (isMany) {
								out.println(basetab
										+ (needsIterateDecl ? "boolean" : "")
										+ " iterate = true;");
								needsIterateDecl = false;
								out.println(basetab + "while(iterate){");
								tab += "\t";
							}
							out
									.println(tab
											+ (needsCompoundDecl ? STRING_WRITER_CLASS_NAME + " "
													: "")
											+ "sWriter = new " + STRING_WRITER_CLASS_NAME + "();");
							out.println(tab
									+ (needsCompoundDecl ? PRINTER_WRITER_CLASS_NAME + " " : "")
									+ "out1 = new " + PRINTER_WRITER_CLASS_NAME + "(sWriter);");
							out
									.println(tab
											+ (needsCompoundDecl ? HASH_MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> "
													: "")
											+ "printCountingMap1 = new " + HASH_MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + ">(printCountingMap);");
							if (!isMany)
								needsCompoundDecl = false;
							out
									.println(tab
											+ choice2Name.get(compound
													.getDefinitions())
											+ "(element,localtab,out1,printCountingMap1);");
							out
									.println(tab
											+ "if(printCountingMap.equals(printCountingMap1)){");
							if (isMany)
								out.println(tab + "\titerate = false;");
							out.println(tab + "\tout1.close();");
							out.println(tab + "}");
							out.println(tab + "else{");
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
								out.print(basetab + "\t\tif(");
								Iterator<String> it = neededFeatures.iterator();
								out.print("printCountingMap1.get(\""
										+ it.next() + "\")<1");
								while (it.hasNext()) {
									String feature = it.next();
									out.print("printCountingMap1.get(\""
											+ feature + "\")<1");
								}
								out.println("){");
								if (isMany)
									out.println(tab + "\t\t\titerate = false;");
								out.println(tab + "\t\tout1.close();");
								out.println(tab + "\t}");
								out.println(tab + "\telse{");
								out.println(tab + "\t\tout1.flush();");
								out.println(tab + "\t\tout1.close();");
								out.println(tab
										+ "\t\tout.print(sWriter.toString());");
								out
										.println(tab
												+ "\t\tprintCountingMap.putAll(printCountingMap1);");
								out.println(tab + "\t}");
							} else {
								out.println(tab + "\tout1.flush();");
								out.println(tab + "\tout1.close();");
								out.println(tab
										+ "\tout.print(sWriter.toString());");
								out
										.println(tab
												+ "\tprintCountingMap.putAll(printCountingMap1);");
							}
							out.println(tab + "}");
							if (isMany)
								out.println(basetab + "}");
						}
					}
					// next steps: references --> proxy uri --> tokenresolver!
					else if (definition instanceof Terminal) {
						Terminal terminal = (Terminal) definition;
						String featureName = terminal.getFeature().getName();
						out.println(basetab + "count = printCountingMap.get(\""
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
										+ "resolver.deResolve(treeAnalyser.deResolve((" + EOBJECT_CLASS_NAME + ")o, element, (" + EREFERENCE_CLASS_NAME + ")element.eClass().getEStructuralFeature(\""
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
						}

						out.println(basetab + "if(count>0){");
						if (cardinality == null
								|| (cardinality instanceof QUESTIONMARK && !neededFeatures
										.contains(featureName))) {
							out.println(basetab + "\tObject o =element."
									+ generateAccessMethod(feature) + ";");
							if (feature.getUpperBound() != 1)
								out
										.println(basetab
												+ "\to = ((" + LIST_CLASS_NAME +"<?>)o).get(((" + LIST_CLASS_NAME +"<?>)o).size() - count);");
							out.println(basetab + "\t" + printStatement);
							out.println(basetab + "\tprintCountingMap.put(\""
									+ featureName + "\",count-1);");
							neededFeatures.remove(featureName);
						} else if (cardinality instanceof PLUS
								|| cardinality instanceof STAR) {
							if (feature.getUpperBound() != 1) {
								out
										.println(basetab
												+ "\t" + LIST_ITERATOR_CLASS_NAME + "<?> it  = ((" + LIST_CLASS_NAME +"<?>) element."
												+ generateAccessMethod(feature)
												+ ").listIterator(((" + LIST_CLASS_NAME +"<?>)element."
												+ generateAccessMethod(feature)
												+ ").size()-count);");
								out.println(basetab + "\twhile(it.hasNext()){");
								out.println(basetab
										+ "\t\t" + OBJECT_CLASS_NAME + " o = it.next();");
								if (cardinality instanceof STAR
										&& neededFeatures.contains(featureName)) {
									out.println(basetab
											+ "\t\tif(!it.hasNext())");
									out.println(basetab + "\t\t\tbreak;");
								}
								out.println(basetab + "\t\t" + printStatement);
								out.println(basetab + "\t}");
								out.println(basetab
										+ "\tprintCountingMap.put(\""
										+ featureName + "\",0);");
							} else if (cardinality instanceof PLUS) {
								out.println(basetab + "\t" + OBJECT_CLASS_NAME + " o =element."
										+ generateAccessMethod(feature) + ";");
								out.println(basetab + "\t" + printStatement);
								out.println(basetab
										+ "\tprintCountingMap.put(\""
										+ featureName + "\",count-1);");
							}
							if (cardinality instanceof PLUS)
								neededFeatures.remove(featureName);
						}

						out.println(basetab + "}"); // tab for if(count>0)
					}
				}
			}
		}
	}

	private void printMatchCall(Sequence seq, PrintWriter out) {
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


	private void printMatchRule(PrintWriter out) {
		out
				.println("\tprotected static int matchCount(" + MAP_CLASS_NAME + "<" + STRING_CLASS_NAME + ", " + INTEGER_CLASS_NAME + "> featureCounter, " + COLLECTION_CLASS_NAME + "<" + STRING_CLASS_NAME+ "> needed){");
		out.println("\t\tint pos = 0;");
		out.println("\t\tint neg = 0;");
		out.println();
		out.println("\t\tfor(" + STRING_CLASS_NAME + " featureName:featureCounter.keySet()){");
		out.println("\t\t\tif(needed.contains(featureName)){");
		out.println("\t\t\t\tint value = featureCounter.get(featureName);");

		out.println("\t\t\t\tif (value == 0) {");
		out.println("\t\t\t\t\tneg += 1;");
		out.println("\t\t\t\t} else {");
		out.println("\t\t\t\t\tpos += 1;");
		out.println("\t\t\t\t}");
		out.println("\t\t\t}");
		out.println("\t\t}");
		out.println("\t\treturn neg > 0 ? -neg : pos;");
		out.println("\t}");
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
