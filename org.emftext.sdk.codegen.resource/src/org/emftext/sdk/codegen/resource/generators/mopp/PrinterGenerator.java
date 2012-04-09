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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAYS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST_ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM_WRITER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PRINTER_WRITER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING_WRITER;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.CollectInFeatureHelper;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComponent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator that creates the class for the classic printer. This generator
 * has been replaced by the new printer generator (Printer2Generator). But,
 * for compatibility reasons, the old printer is still generated. By default,
 * the new printer implementation is used, but setting the syntax option
 * <code>useClassicPrinter</code> to <code>true</code> makes the classic
 * printer the default one.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
@SyntaxDependent
public class PrinterGenerator extends AbstractPrinterGenerator {

	private final static String localtabName = "localtab";

	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	private ConcreteSyntax concretSyntax;
	
	/** maps all choices to a method name */
	private Map<Choice, String> choice2Name;
	/** maps all rules to choices nested somewhere, but not to the root choice! */
	private Map<Rule, Set<Choice>> rule2SubChoice;
	/** 
	 * maps all sequences in all choices to all features which HAVE to be printed in the sequence
	 */
	private Map<Sequence, Set<String>> sequence2NecessaryFeatures;
	private Map<Sequence, Set<String>> sequence2ReachableFeatures;

	private GenClassCache genClassCache;

	private void extractChoices(List<Rule> rules,
			Map<Rule, Set<Choice>> ruleMap, Map<Choice, String> choiceMap,
			Map<Sequence, Set<String>> necessaryMap,
			Map<Sequence, Set<String>> reachableMap) {
		for (Rule rule : rules) {
			choiceMap.put(rule.getDefinition(), getMethodName(rule));
			Set<Choice> choices = new LinkedHashSet<Choice>();
			ruleMap.put(rule, choices);
			extractChoices(rule.getDefinition(), choices, choiceMap,
					necessaryMap, reachableMap, null, getMethodName(rule) + "_", 0);
		}
	}

	private void extractChoices(Choice choice, Set<Choice> choiceSet,
			Map<Choice, String> choiceMap,
			Map<Sequence, Set<String>> necessaryMap,
			Map<Sequence, Set<String>> reachableMap, Sequence parent,
			String namePrefix, int choiceIndex) {
		for (Sequence seq : choice.getOptions()) {
			Set<String> sequenceNecessaryFeatures = new LinkedHashSet<String>();
			Set<String> sequenceReachableFeatures = new LinkedHashSet<String>();
			necessaryMap.put(seq, sequenceNecessaryFeatures);
			reachableMap.put(seq, sequenceReachableFeatures);
			for (Definition def : seq.getParts()) {
				final boolean hasMinimalCardinalityOneOrHigher = def.hasMinimalCardinalityOneOrHigher();
				if (def instanceof CompoundDefinition) {
					String subChoiceName = namePrefix + choiceIndex++;
					Choice currentChoice = ((CompoundDefinition) def)
							.getDefinition();
					choiceMap.put(currentChoice, subChoiceName);
					choiceSet.add(currentChoice);
					extractChoices(currentChoice, choiceSet, choiceMap,
							necessaryMap, reachableMap,
							hasMinimalCardinalityOneOrHigher ? seq
									: null, subChoiceName + "_", 0);
				} else if (def instanceof Terminal) {
					Terminal terminal = (Terminal) def;
					GenFeature feature = terminal.getFeature();
					if (feature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
						continue;
					}
					String featureName = feature.getName();
					if (hasMinimalCardinalityOneOrHigher) {
						sequenceNecessaryFeatures.add(featureName);
					}
					sequenceReachableFeatures.add(featureName);
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
		int ruleCount = rules.size();
		choice2Name = new LinkedHashMap<Choice, String>(ruleCount);
		sequence2NecessaryFeatures = new LinkedHashMap<Sequence, Set<String>>(ruleCount);
		sequence2ReachableFeatures = new LinkedHashMap<Sequence, Set<String>>(ruleCount);
		rule2SubChoice = new LinkedHashMap<Rule, Set<Choice>>(ruleCount);
		extractChoices(rules, rule2SubChoice, choice2Name,
				sequence2NecessaryFeatures, sequence2ReachableFeatures);
		
		return rules;
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		super.generateJavaContents(sc);
		
		this.concretSyntax = getContext().getConcreteSyntax();
		this.genClassCache = concretSyntax.getGenClassCache();

		List<Rule> rules = prepare();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iTextPrinterClassName + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc, rules);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc, List<Rule> rules) {
		addMatchCountMethod(sc);
		addDoPrintMethod(sc, rules);
        addGetReferenceResolverSwitchMethod(sc);
		addAddWarningToResourceMethod(sc);
		addSetOptionsMethod(sc);
		addGetOptionsMethod(sc);
		addSetEncoding(sc);
		addGetEncoding(sc);
		addGetResourceMethod(sc);
		addPrintMethod(sc);
        for (Rule rule : rules) {
			addPrintRuleMethod(sc, rule);
		}
	}

	private void addPrintMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to the underlying output stream."
		);
		sc.add("public void print(" + E_OBJECT + " element) throws java.io.IOException {");
		sc.add(PRINTER_WRITER + " out = new " + PRINTER_WRITER + "(new " + OUTPUT_STREAM_WRITER + "(new " + BUFFERED_OUTPUT_STREAM + "(outputStream), encoding));");	
		sc.add("doPrint(element, out, \"\");");
		sc.add("out.flush();");
		sc.add("out.close();");
		sc.add("}");
		sc.addLineBreak();
	}

	protected void addDoPrintMethod(StringComposite sc, List<Rule> rules) {
		sc.add("protected void doPrint(" + E_OBJECT + " element, " + PRINTER_WRITER + " out, String globaltab) {");
		sc.add("if (element == null) {");
		sc.add("throw new " + ILLEGAL_ARGUMENT_EXCEPTION + "(\"Nothing to write.\");");
		sc.add("}");
		sc.add("if (out == null) {");
		sc.add("throw new " + ILLEGAL_ARGUMENT_EXCEPTION + "(\"Nothing to write on.\");");
		sc.add("}");
		sc.addLineBreak();
		Queue<Rule> ruleQueue = new LinkedList<Rule>(rules);
		while (!ruleQueue.isEmpty()) {
			Rule rule = ruleQueue.remove();
			// check whether all subclass calls have been printed
			if (csUtil.hasSubClassesWithCS(rule.getMetaclass(),
					ruleQueue)) {
				ruleQueue.add(rule);
			} else {
				sc.add("if (element instanceof " + getMetaClassName(rule) + ") {");
				sc.add(getMethodName(rule) + "((" + getMetaClassName(rule)
						+ ") element, globaltab, out);");
				sc.add("return;");
				sc.add("}");
			}
		}
		sc.addLineBreak();
		sc.add("addWarningToResource(\"The printer can not handle \" + element.eClass().getName() + \" elements\", element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + super.getResourceClassName()
				+ "(" + OUTPUT_STREAM + " outputStream, " + iTextResourceClassName + " resource) {");
		sc.add("super();");
		sc.add("this.outputStream = outputStream;");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("protected " + iTokenResolverFactoryClassName + " tokenResolverFactory = new "
						+ tokenResolverFactoryClassName + "();");
		sc.addLineBreak();
		
		sc.add("protected " +  OUTPUT_STREAM + " outputStream;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Holds the resource that is associated with this printer. This may be null if the printer is used stand alone."
		);
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.addLineBreak();

		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private String encoding = System.getProperty(\"file.encoding\");");
		sc.addLineBreak();
	}

	private void addPrintRuleMethod(JavaComposite sc, Rule rule) {
		
		final GenClass genClass = rule.getMetaclass();

		sc.add("public void " + getMethodName(rule) + "(" +
				getMetaClassName(rule) + " element, " + 
				"String outertab, " + 
				PRINTER_WRITER + " out) {");

		sc.add(new StringComponent("String " + localtabName + " = outertab;", localtabName));

		printCountingMapIntialization(sc, genClass);
		addPrintCollectedTokensCode(sc, rule);
		
		printChoice(rule.getDefinition(), sc, genClass);
		sc.add("}");
		sc.addLineBreak();
		
		printChoices(sc, rule);
		sc.addLineBreak();
	}

	private void printChoices(JavaComposite sc, Rule rule) {
		for (Choice choice : rule2SubChoice.get(rule)) {
			sc.add("public void " +
					choice2Name.get(choice) +
					"(" +
						getMetaClassName(rule) + " element, " + 
						"String outertab, " + 
						PRINTER_WRITER + " out, " + 
						MAP + "<String, Integer> printCountingMap) {"
			);

			sc.add(new StringComponent("String " + localtabName + " = outertab;", localtabName));
			printChoice(choice, sc, rule.getMetaclass());
			sc.add("}");
			sc.addLineBreak();
		}
	}

	private void addPrintCollectedTokensCode(JavaComposite sc, Rule rule) {

		final GenClass genClass = rule.getMetaclass();
		List<GenFeature> featureList = genClass.getAllGenFeatures();

		sc.addComment("print collected hidden tokens");
		for (GenFeature genFeature : featureList) {
			EStructuralFeature feature = genFeature.getEcoreFeature();
			if (new CollectInFeatureHelper().isCollectInFeature(rule.getSyntax(), feature)) {
				sc.add("{");
				sc.add(E_STRUCTURAL_FEATURE + " feature = element.eClass()." + generatorUtil.createGetFeatureCall(genClass, genFeature) + ";");
				sc.add("Object value = element.eGet(feature);");
				sc.add("if (value instanceof " + LIST + ") {");
				sc.add("for (Object next : (" + LIST + "<?>) value) {");
				sc.add("out.print(tokenResolverFactory.createCollectInTokenResolver(\"" + feature.getName() + "\").deResolve(next, feature, element));");
				sc.add("}");
				sc.add("}");
				sc.add("}");
			}
		}
	}

	private void printChoice(Choice choice, JavaComposite sc, GenClass genClass) {
		String countName = "count";
		sc.add(new StringComponent("int " + countName + ";", countName));
		
		if (choice.getOptions().size() > 1) {
			sc.add("int alt = -1;");
			Iterator<Sequence> seqIt = choice.getOptions().iterator();
			if (seqIt.hasNext()) {
				Sequence firstSeq = seqIt.next();
				int count = 0;
				JavaComposite sc1 = new JavaComposite();
				sc1.add("switch(alt) {");
				sc.add("alt = " + (count++) + ";");
				sc.add("int matches = ");
				printMatchCall(firstSeq, sc);
				sc.add("int tempMatchCount;");
				while (seqIt.hasNext()) {
					Sequence seq = seqIt.next();
					sc.add("tempMatchCount = ");
					printMatchCall(seq, sc);
					sc.add("if (tempMatchCount > matches) {");
					sc.add("alt = " + count + ";");
					sc.add("matches = tempMatchCount;");
					sc.add("}");

					sc1.add("case " + count + ":");
					// extra scope for case begin
					sc1.add("{");
					printSequence(seq, sc1, genClass);
					// extra scope for case end
					sc1.add("}");
					sc1.add("break;");
					count++;
				}

				sc1.add("default:");
				printSequence(firstSeq, sc1, genClass);
				sc1.add("}");
				sc.add(sc1);
			}
		} else if (choice.getOptions().size() == 1) {
			printSequence(choice.getOptions().get(0), sc, genClass);
		}
	}

	private Set<String> getReachableFeatures(Choice choice) {
		Set<String> result = new LinkedHashSet<String>();
		for (Sequence seq : choice.getOptions()) {
			result.addAll(sequence2ReachableFeatures.get(seq));
		}
		return result;
	}

	private void printSequence(Sequence sequence, JavaComposite sc,
			GenClass genClass) {
		Set<String> neededFeatures = new LinkedHashSet<String>(
				sequence2NecessaryFeatures.get(sequence));

		//EClass metaClass = genClass.getEcoreClass();
		ListIterator<Definition> definitionIterator = sequence.getParts()
				.listIterator();
		
		String iterateName = "iterate";
		sc.add(new StringComponent("boolean " + iterateName + " = true;", iterateName));
		String sWriteName = "sWriter";
		sc.add(new StringComponent(STRING_WRITER + " " + sWriteName + " = null;", sWriteName));
		String out1Name = "out1";
		sc.add(new StringComponent(PRINTER_WRITER + " " + out1Name + " = null;", out1Name));
		String printCountingMap1Name = "printCountingMap1";
		sc.add(new StringComponent(MAP + "<String, Integer> " + printCountingMap1Name + " = null;", printCountingMap1Name));
		
		while (definitionIterator.hasNext()) {
			Definition definition = definitionIterator.next();
			printDefinition(sc, genClass, neededFeatures, definitionIterator,
					definition);
		}
	}

	private void printDefinition(JavaComposite sc, GenClass genClass,
			Set<String> neededFeatures,
			ListIterator<Definition> definitionIterator, Definition definition) {
		sc.addComment("DEFINITION PART BEGINS (" + definition.eClass().getName() + ")");
		String printPrefix = "out.print(";
		if (definition instanceof LineBreak) {
			LineBreak lineBreak = (LineBreak) definition;
			printLineBreak(sc, lineBreak);
		} else {
			if (definition instanceof WhiteSpaces) {
				WhiteSpaces whiteSpace = (WhiteSpaces) definition;
				printWhiteSpace(sc, printPrefix, whiteSpace);
			} else if (definition instanceof CsString) {
				CsString keyword = (CsString) definition;
				printCsString(sc, definitionIterator, printPrefix, keyword);
			} else {
				Cardinality cardinality = getCardinality(definition);
				
				if (definition instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) definition;
					printCompound(sc, neededFeatures, cardinality, compound);
				}
				// next steps: references --> proxy uri --> tokenresolver!
				else if (definition instanceof Terminal) {
					Terminal terminal = (Terminal) definition;
					final GenFeature genFeature = terminal.getFeature();
					final String featureName = genFeature.getName();
					EStructuralFeature feature = genFeature.getEcoreFeature();
					StringComposite printStatements = new JavaComposite();
					if (genFeature != ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
						sc.add("count = printCountingMap.get(\""
								+ featureName + "\");");

						if (terminal instanceof Placeholder) {
							String tokenName = ((Placeholder) terminal).getToken().getName();

							String featureConstant = generatorUtil.getFeatureConstant(genClass, genFeature);
							if (feature instanceof EReference) {
								printStatements.add(iTokenResolverClassName + " resolver = tokenResolverFactory.createTokenResolver(\""
										+ tokenName
										+ "\");");
								printStatements.add("resolver.setOptions(getOptions());");
								printStatements.add(printPrefix + "resolver.deResolve(" 
										+ getContext().getReferenceResolverAccessor(genFeature)
										+ ".deResolve((" + genClassCache.getQualifiedInterfaceName(genFeature.getTypeGenClass()) + ") o, element, (" + E_REFERENCE + ") element.eClass().getEStructuralFeature("
										+ featureConstant
										+ ")), element.eClass().getEStructuralFeature("
										+ featureConstant
										+ "), element));");
							} else {
								printStatements.add(iTokenResolverClassName + " resolver = tokenResolverFactory.createTokenResolver(\""
										+ tokenName
										+ "\");");
								printStatements.add("resolver.setOptions(getOptions());");
								printStatements.add(printPrefix
										+ "resolver.deResolve((Object) o, element.eClass().getEStructuralFeature("
										+ featureConstant
										+ "), element));");
							}


							// the given tokenSpace (>0) causes an additional
							// print statement to be printed
							if (getTokenSpace() > 0) {
								Definition lookahead = null;
								if (definitionIterator.hasNext()){
									lookahead = definitionIterator.next();
									definitionIterator.previous();
								}
									
								if (lookahead == null
										|| !(lookahead instanceof WhiteSpaces)) {
									String printSuffix = getWhiteSpaceString(getTokenSpace());
									printStatements.add("out.print(\"" + printSuffix + "\");");
								}
							}
						} else if (terminal instanceof BooleanTerminal) {
							// TODO implement printing of BooleanTerminals
						} else if (terminal instanceof EnumTerminal) {
							// TODO implement printing of EnumTerminal
						} else {
							assert terminal instanceof Containment;
							printStatements.add("doPrint((" + E_OBJECT + ") o, out, localtab);");
						}

						sc.add("if (count > 0) {");
						if (cardinality == Cardinality.NONE
								|| (cardinality == Cardinality.QUESTIONMARK && !neededFeatures
										.contains(featureName))) {
							sc.add("Object o = element."
									+ getAccessMethod(genClassCache, genClass, genFeature) + ";");
							if (feature.getUpperBound() != 1) {
								sc.add(LIST +"<?> list = (" + LIST + "<?>) o;");
								sc.add("int index = list.size() - count;");
								// we must check the index, because the list in the model
								// may contain less elements than expected.
								//
								// this is for example the case, for a CS definitions like:
								//
								// feature ("," feature)*
								//
								// where the first element is mandatory in the CS rule, but
								// the meta model defines a cardinality of 0..* for 'feature'.
								sc.add("if (index >= 0) {");
								sc.add("o = list.get(index);");
								sc.add("} else {");
								sc.add("o = null;");
								sc.add("}");
							}
							sc.add("if (o != null) {");
							sc.add(printStatements);
							sc.add("}");
							sc.add("printCountingMap.put(\"" + featureName + "\", count - 1);");
							neededFeatures.remove(featureName);
						} else if (cardinality == Cardinality.PLUS
								|| cardinality == Cardinality.STAR) {
							if (feature.getUpperBound() != 1) {
								sc.add(LIST + "<?> list = (" + LIST +"<?>)element."
										+ getAccessMethod(genClassCache, genClass, genFeature)
										+ ";");
								sc.add("int index  = list.size() - count;");
								sc.add("if (index < 0) {");
								sc.add("index = 0;");
								sc.add("}");
								sc.add(LIST_ITERATOR + "<?> it  = list.listIterator(index);");
								sc.add("while (it.hasNext()) {");
								sc.add("Object o = it.next();");
								if (cardinality == Cardinality.STAR
										&& neededFeatures.contains(featureName)) {
									sc.add("if (!it.hasNext()) {");
									sc.add("break;");
									sc.add("}");
								}
								sc.add(printStatements);
								sc.add("}");
								sc.add("printCountingMap.put(\""
										+ featureName + "\", 0);");
							} else if (cardinality == Cardinality.PLUS) {
								sc.add("Object o = element."
										+ getAccessMethod(genClassCache, genClass, genFeature) + ";");
								sc.add(printStatements);
								sc.add("printCountingMap.put(\""
										+ featureName + "\", count - 1);");
							}
							if (cardinality == Cardinality.PLUS) {
								neededFeatures.remove(featureName);
							}
						}
						sc.add("}"); // closing bracket for: if (count > 0)
					}
				}
			}
		}
	}

	private Cardinality getCardinality(Definition definition) {
		Cardinality cardinality = Cardinality.NONE;
		if (definition instanceof CardinalityDefinition) {
			cardinality = ((CardinalityDefinition) definition).getCardinality();
		}
		return cardinality;
	}

	private void printCompound(StringComposite sc, Set<String> neededFeatures,
			Cardinality cardinality, CompoundDefinition compound) {
		String printStatement = 
				choice2Name.get(compound.getDefinition())
				+ "(element, localtab, out, printCountingMap);";
		// enter once
		if (cardinality == Cardinality.NONE || cardinality == Cardinality.PLUS) {
			sc.add(printStatement);
			// needed features in non optional choice are also
			// needed features in this sequence
			// note: this implementation might remove to much in
			// some cases!
			for (Sequence seq1 : compound.getDefinition()
					.getOptions()) {
				neededFeatures
						.removeAll(sequence2NecessaryFeatures
								.get(seq1));
			}
		}
		// optional cases
		if (cardinality != Cardinality.NONE) {

			boolean isMany = !(cardinality == Cardinality.QUESTIONMARK);
			// runtime: iterate as long as no fixpoint is
			// reached
			// make sure that NOT all elements of needed
			// features are printed in optional compounds!
			if (isMany) {
				sc.add("iterate = true;");
				sc.add("while (iterate) {");
			}
			sc.add("sWriter = new " + STRING_WRITER + "();");
			sc.add("out1 = new " + PRINTER_WRITER + "(sWriter);");
			sc.add("printCountingMap1 = new " + LINKED_HASH_MAP + "<String, Integer>(printCountingMap);");
			
			sc.add(choice2Name.get(compound.getDefinition()) + "(element, localtab, out1, printCountingMap1);");
			sc.add("if (printCountingMap.equals(printCountingMap1)) {");
			if (isMany) {
				sc.add("iterate = false;");
			}
			sc.add("out1.close();");
			sc.add("} else {");
			// check if printed features are needed by
			// subsequent features
			// at least one element has to be preserved in that
			// case!
			// this could be enhanced by a counter on needed
			// features
			Collection<String> reachableFeatures = getReachableFeatures(compound.getDefinition());
			if (!neededFeatures.isEmpty() && 
				!Collections.disjoint(neededFeatures, reachableFeatures)) {
				sc.add("if (");
				Iterator<String> it = neededFeatures.iterator();
				sc.add("printCountingMap1.get(\""
						+ it.next() + "\")<1");
				while (it.hasNext()) {
					String feature = it.next();
					sc.add("||printCountingMap1.get(\""
							+ feature + "\")<1");
				}
				sc.add(") {");
				if (isMany) {
					sc.add("iterate = false;");
				}
				sc.add("out1.close();");
				sc.add("} else {");
				sc.add("out1.flush();");
				sc.add("out1.close();");
				sc.add("out.print(sWriter.toString());");
				sc.add("printCountingMap.putAll(printCountingMap1);");
				sc.add("}");
			} else {
				sc.add("out1.flush();");
				sc.add("out1.close();");
				sc.add("out.print(sWriter.toString());");
				sc.add("printCountingMap.putAll(printCountingMap1);");
			}
			sc.add("}");
			if (isMany) {
				sc.add("}");
			}
		}
	}

	private void printCsString(StringComposite sc,
			ListIterator<Definition> definitionIterator, String printPrefix,
			CsString keyword) {
		sc.add(printPrefix + "\""
				+ StringUtil.escapeToJavaString(keyword.getValue())
				+ "\");");

		// the given tokenSpace (>0) causes an additional
		// print statement to be printed
		if (getTokenSpace() > 0) {
			Definition lookahead = null;
			if (definitionIterator.hasNext()){
				lookahead = definitionIterator.next();
				definitionIterator.previous();
			}
				
			if (lookahead == null
					|| !(lookahead instanceof WhiteSpaces)) {
				String printSuffix = getWhiteSpaceString(getTokenSpace());
				
				sc.add(printPrefix + "\"" + printSuffix + "\");");
			}
		}
	}

	private void printWhiteSpace(StringComposite sc, String printPrefix,
			WhiteSpaces whiteSpace) {
		int count = whiteSpace.getAmount();
		if (count > 0) {
			String spaces = getWhiteSpaceString(count);
			sc.add(printPrefix + "\"" + spaces + "\");");
		}
	}

	private void printLineBreak(StringComposite sc, LineBreak lineBreak) {
		int count = lineBreak.getTab();
		if (count > 0) {
			String tab = getTabString(count);
			sc.add("localtab += \"" + tab + "\";");
		}
		sc.add("out.println();");
		sc.add("out.print(localtab);");
	}

	private void printMatchCall(Sequence seq, StringComposite sc) {
		if (sequence2NecessaryFeatures.get(seq).isEmpty()) {
			sc.add("0;");
			return;
		}
		sc.add("matchCount(printCountingMap, " + ARRAYS + ".asList(");
		boolean notFirst = false;
		for (String featureName : sequence2NecessaryFeatures.get(seq)) {
			if (notFirst) {
				sc.add(",");
			} else {
				notFirst = true;
			}
			sc.add("\"" + featureName + "\"");
		}
		sc.add("));");
	}


	private void addMatchCountMethod(StringComposite sc) {
		sc.add("protected int matchCount(" + MAP + "<String, Integer> featureCounter, " + COLLECTION + "<String> needed) {");
		sc.add("int pos = 0;");
		sc.add("int neg = 0;");
		sc.addLineBreak();
		sc.add("for (String featureName : featureCounter.keySet()) {");
		sc.add("if (needed.contains(featureName)) {");
		sc.add("int value = featureCounter.get(featureName);");
		sc.add("if (value == 0) {");
		sc.add("neg += 1;");
		sc.add("} else {");
		sc.add("pos += 1;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return neg > 0 ? -neg : pos;");
		sc.add("}");
		sc.addLineBreak();
	}

	/**
	 * Prints the code needed to initialize the printCountingMap.
	 * 
	 * @param sc
	 * @param genClass
	 */
	private void printCountingMapIntialization(JavaComposite sc, GenClass genClass) {
		List<GenFeature> featureList = genClass.getAllGenFeatures();
		String printCountingMapName = "printCountingMap";
		sc.addComment(
			"The " + printCountingMapName + " contains a mapping from feature names to " +
			"the number of remaining elements that still need to be printed. " +
			"The map is initialized with the number of elements stored in each structural " +
			"feature. For lists this is the list size. For non-multiple features it is either " +
			"1 (if the feature is set) or 0 (if the feature is null)."
		);
		sc.add(new StringComponent(MAP + "<String, Integer> " + printCountingMapName + " = new " + LINKED_HASH_MAP + "<String, Integer>("
				+ featureList.size() + ");", printCountingMapName));
		
		if (featureList.size() > 0) {
			sc.add("Object temp;");
		}
		for (GenFeature genFeature : featureList) {
			EStructuralFeature feature = genFeature.getEcoreFeature();
			// do not print derived features
			if (feature.isDerived()) {
				continue;
			}
			sc.add("temp = element." + getAccessMethod(genClassCache, genClass, genFeature) + ";");

			boolean isMultiple = feature.getUpperBound() > 1 || feature.getUpperBound() == -1;
			String featureSize = isMultiple ? "((" + COLLECTION + "<?>) temp).size()" : "1";
			sc.add("printCountingMap.put(\"" + feature.getName() + "\", temp == null ? 0 : " + featureSize + ");");
		}
	}
}
