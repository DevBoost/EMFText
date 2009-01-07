package org.emftext.sdk.codegen;

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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
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
		
		super(context.getPackageName(), context.getPrinterBaseName());

		ConcreteSyntax concretSyntax = context.getConcreteSyntax();
		String tokenResolverFactoryClassName = context.getTokenResolverFactoryName();
		String treeAnalyserClassName = context.getTreeAnalyserName();
		
		this.concretSyntax = concretSyntax;
		// this.csClassName = csClassName;
		this.tokenResolverFactoryClassName = tokenResolverFactoryClassName;
		this.placeholder2TokenName = placeholder2TokenName;
		this.treeAnalyserClassName = treeAnalyserClassName;
	}

	private static void extractChoices(List<Rule> rules,
			Map<Rule, Set<Choice>> ruleMap, Map<Choice, String> choiceMap,
			Map<Sequence, Set<String>> necessaryMap,
			Map<Sequence, Set<String>> reachableMap) {
		for (Rule rule : rules) {
			String elementName = rule.getMetaclass().getEcoreClass().getName();
			choiceMap.put(rule.getDefinition(), elementName);
			Set<Choice> choices = new HashSet<Choice>();
			ruleMap.put(rule, choices);
			extractChoices(rule.getDefinition(), choices, choiceMap,
					necessaryMap, reachableMap, null, elementName + "_", 0);
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
		out.println("package " + super.getResourcePackageName() + ";");
		out.println();
		out.println("import org.eclipse.emf.ecore.EObject;");
		out.println("import org.eclipse.emf.ecore.EReference;");
		for (Rule rule : rules) {
			GenPackage p = rule.getMetaclass().getGenPackage();
			String classImport = (p.getBasePackage() == null ? "" : p
					.getBasePackage()
					+ ".")
					+ p.getEcorePackage().getName()
					+ "."
					+ rule.getMetaclass().getName();
			out.println("import " + classImport + ";");
		}

		out.println();
		out.println("public abstract class " + super.getResourceClassName()
				+ " extends " + EMFTextPrinterImpl.class.getName() + " {");
		out.println();
		out
				.println("\tprotected " + ITokenResolverFactory.class.getName() + " tokenResolverFactory = new "
						+ tokenResolverFactoryClassName + "();");
		out.println("\tprotected " + IReferenceResolver.class.getName() + " treeAnalyser = new "
				+ treeAnalyserClassName + "();");
		out.println();
		out.println("\tpublic " + super.getResourceClassName()
				+ "(java.io.OutputStream o, " + ITextResource.class.getName() + " resource) {\n");
		out.println("\t\tsuper(o, resource);");
		out.println("\t}");
		out.println();
		printMatchRule(out);
		out.println();
		out
				.println("\tprotected void doPrint(EObject element, java.io.PrintWriter out, String globaltab) {");
		out
				.println("\t\tif (element == null||out == null) throw new NullPointerException(\"Nothing to write or to write on.\");");
		out.println();
		Queue<Rule> ruleQueue = new LinkedList<Rule>(rules);
		while (!ruleQueue.isEmpty()) {
			Rule rule = ruleQueue.remove();
			// check whether all subclass calls have been printed
			if (GeneratorUtil.hasSubClassesWithCS(rule.getMetaclass(),
					ruleQueue)) {
				ruleQueue.add(rule);
			} else {
				String elementName = rule.getMetaclass().getEcoreClass()
						.getName();
				out.println("\t\tif(element instanceof " + elementName + "){");
				out.println("\t\t\tprint" + elementName + "((" + elementName
						+ ") element,globaltab,out);");
				out.println("\t\t\treturn;");
				out.println("\t\t}");
			}
		}
		out.println();
		out
				.println("\t\tresource.addWarning(\"The cs printer can not handle \" + element.eClass().getName() + \" elements\", element);");
		out.println("\t}");
		out.println();
		for (Rule rule : rules) {
			generateRule(out, rule);
		}
		out.println("\t\t}");
		return true;
	}

	private void generateRule(PrintWriter out, Rule rule) {
		String elementClassName = rule.getMetaclass().getEcoreClass().getName();
		out.println("\t\tpublic void print" + elementClassName + "("
				+ elementClassName
				+ " element, String outertab, java.io.PrintWriter out){");
		out.println("\t\t\tString localtab = outertab;");
		List<EStructuralFeature> featureList = rule.getMetaclass()
				.getEcoreClass().getEAllStructuralFeatures();

		out
				.println("\t\t\tjava.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>("
						+ featureList.size() + ");");
		if (featureList.size() > 0) {
			out.println("\t\t\tObject temp;");
		}
		for (EStructuralFeature feature : featureList) {
			out.println("\t\t\ttemp = element." + generateAccessMethod(feature)
					+ ";");
			String featureSize = feature.getUpperBound() == -1 ? "((java.util.Collection<?>)temp).size()"
					: "1";
			out.println("\t\t\tprintCountingMap.put(\"" + feature.getName()
					+ "\", temp == null ? 0 : " + featureSize + ");");
		}
		// TODO mseifert print collected hidden tokens
		out.println("// TODO print collected hidden tokens");
		for (EStructuralFeature feature : featureList) {
			if (isCollectInFeature(rule, feature)) {
				// TODO use feature id constant instead
				out.println("\t\t\t{");
				out.println("\t\t\tObject value = element.eGet(element.eClass().getEStructuralFeature(" + feature.getFeatureID() + "));");
				out.println("\t\t\tif (value instanceof java.util.List) {");
				out.println("\t\t\t\tfor (Object next : (java.util.List) value) {");
				out.println("\t\t\t\t\tout.print(next);");
				out.println("\t\t\t\t}");
				out.println("\t\t\t}");
				out.println("\t\t\t}");
			}
		}
		
		printChoice(rule.getDefinition(), out, rule.getMetaclass()
				.getEcoreClass());
		out.println("\t\t}");
		for (Choice choice : rule2SubChoice.get(rule)) {
			out
					.println("\t\tpublic void print"
							+ choice2Name.get(choice)
							+ "("
							+ elementClassName
							+ " element, String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){");
			out.println("\t\t\tString localtab = outertab;");
			printChoice(choice, out, rule.getMetaclass().getEcoreClass());
			out.println("\t\t}");
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
			out.println("\t\t\tint count;");
			out.println("\t\t\tint alt=-1;");
			Iterator<Sequence> seqIt = choice.getOptions().iterator();
			if (seqIt.hasNext()) {
				Sequence firstSeq = seqIt.next();
				int count = 0;
				StringWriter switchString = new StringWriter();
				PrintWriter out1 = new PrintWriter(switchString);
				out1.println("\t\t\tswitch(alt){");
				out.println("\t\t\talt=" + count++ + ";");
				out.print("\t\t\tint matches=");
				printMatchCall(firstSeq, out);
				out.println("\t\t\tint tempMatchCount;");
				while (seqIt.hasNext()) {
					Sequence seq = seqIt.next();
					out.print("\t\t\ttempMatchCount=");
					printMatchCall(seq, out);
					out.println("\t\t\tif (tempMatchCount > matches) {");
					out.println("\t\t\t\talt = " + count + ";");
					out.println("\t\t\t\tmatches = tempMatchCount;");
					out.println("\t\t\t}");

					out1.println("\t\t\t\tcase " + count + ":");
					// extra scope for case begin
					out1.println("\t\t\t\t\t{");
					printSequence(seq, out1, metaClass, "\t\t\t\t\t\t");
					// extra scope for case end
					out1.println("\t\t\t\t\t}");
					out1.println("\t\t\t\tbreak;");
					count++;
				}

				out1.println("\t\t\t\tdefault:");
				printSequence(firstSeq, out1, metaClass, "\t\t\t\t\t");
				out1.println("\t\t\t}");
				out1.flush();
				out1.close();
				out.print(switchString.toString());
			}
		} else if (choice.getOptions().size() == 1) {
			out.println("\t\t\tint count;");
			printSequence(choice.getOptions().get(0), out, metaClass, "\t\t\t");
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
						String printStatement = "print"
								+ choice2Name.get(compound.getDefinitions())
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
											+ (needsCompoundDecl ? "java.io.StringWriter "
													: "")
											+ "sWriter = new java.io.StringWriter();");
							out.println(tab
									+ (needsCompoundDecl ? "java.io.PrintWriter " : "")
									+ "out1 = new java.io.PrintWriter(sWriter);");
							out
									.println(tab
											+ (needsCompoundDecl ? "java.util.HashMap<java.lang.String, java.lang.Integer> "
													: "")
											+ "printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);");
							if (!isMany)
								needsCompoundDecl = false;
							out
									.println(tab
											+ "print"
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
										+ "resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature(\""
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
										+ "resolver.deResolve((Object)o,element.eClass().getEStructuralFeature(\""
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
							printStatement = "doPrint((EObject)o,out,localtab);";
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
												+ "\to = ((java.util.List<Object>)o).get(((java.util.List<Object>)o).size()-count);");
							out.println(basetab + "\t" + printStatement);
							out.println(basetab + "\tprintCountingMap.put(\""
									+ featureName + "\",count-1);");
							neededFeatures.remove(featureName);
						} else if (cardinality instanceof PLUS
								|| cardinality instanceof STAR) {
							if (feature.getUpperBound() != 1) {
								out
										.println(basetab
												+ "\tjava.util.ListIterator it  = ((java.util.List)element."
												+ generateAccessMethod(feature)
												+ ").listIterator(((java.util.List)element."
												+ generateAccessMethod(feature)
												+ ").size()-count);");
								out.println(basetab + "\twhile(it.hasNext()){");
								out.println(basetab
										+ "\t\tObject o = it.next();");
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
								out.println(basetab + "\tObject o =element."
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
		out.print("matchCount(printCountingMap, java.util.Arrays.asList(");
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
				.println("\tprotected static int matchCount(java.util.Map<java.lang.String, java.lang.Integer> featureCounter, java.util.Collection<java.lang.String> needed){");
		out.println("\t\tint pos = 0;");
		out.println("\t\tint neg = 0;");
		out.println();
		out.println("\t\tfor(String featureName:featureCounter.keySet()){");
		out.println("\t\t\tif(needed.contains(featureName)){");
		out.println("\t\t\t\tint value = featureCounter.get(featureName);");

		out.println("\t\t\t\tif(value==0)");
		out.println("\t\t\t\t\tneg+=1;");
		out.println("\t\t\t\telse");
		out.println("\t\t\t\t\tpos+=1;");
		out.println("\t\t\t}");
		out.println("\t\t}");
		out.println("\t\treturn neg>0?-neg:pos;");
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
