package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUFFERED_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PRINTER_WRITER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator for a new experimental printing algorithm that tries
 * to preserve layout information that was gathered during parsing.
 */
public class Printer2Generator extends AbstractPrinterGenerator {

	private static ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	
	private ConcreteSyntax syntax;
	private String tokenResolverFactoryClassName;
	private String syntaxElementDecoratorClassName;
	private String syntaxElementClassName;
	private String grammarInformationProviderClassName;
	private String keywordClassName;
	private String placeholderClassName;
	private String cardinalityClassName;
	private String compoundClassName;
	private String choiceClassName;
	private String sequenceClassName;
	private String containmentClassName;
	private String formattingElementClassName;
	private String lineBreakClassName;
	private String whiteSpaceClassName;
	private String iTextPrinterClassName;
	private String iTextResourceClassName;
	private String iTokenResolverClassName;
	private String iReferenceResolverClassName;
	
	public Printer2Generator() {
		super();
	}

	private Printer2Generator(GenerationContext context) {
		super(context, EArtifact.PRINTER2);
		syntax = context.getConcreteSyntax();
		tokenResolverFactoryClassName = context.getQualifiedClassName(EArtifact.TOKEN_RESOLVER_FACTORY);
		iTextPrinterClassName = context.getQualifiedClassName(EArtifact.I_TEXT_PRINTER);
		iTokenResolverClassName = context.getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER);
		iTextResourceClassName = context.getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
		syntaxElementDecoratorClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT_DECORATOR);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		grammarInformationProviderClassName = context.getQualifiedClassName(EArtifact.GRAMMAR_INFORMATION_PROVIDER);
		keywordClassName = context.getQualifiedClassName(EArtifact.KEYWORD);
		placeholderClassName = context.getQualifiedClassName(EArtifact.PLACEHOLDER);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
		compoundClassName = context.getQualifiedClassName(EArtifact.COMPOUND);
		choiceClassName = context.getQualifiedClassName(EArtifact.CHOICE);
		sequenceClassName = context.getQualifiedClassName(EArtifact.SEQUENCE);
		containmentClassName = context.getQualifiedClassName(EArtifact.CONTAINMENT);
		formattingElementClassName = context.getQualifiedClassName(EArtifact.FORMATTING_ELEMENT);
		lineBreakClassName = context.getQualifiedClassName(EArtifact.LINE_BREAK);
		whiteSpaceClassName = context.getQualifiedClassName(EArtifact.WHITE_SPACE);
		iReferenceResolverClassName = context.getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new Printer2Generator(context);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iTextPrinterClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		
		return true;
	}

	private void addMethods(StringComposite sc) { 
		addPrintMethod(sc);
		addDoPrintMethod(sc, syntax.getAllRules());
		addPrintRuleMethods(sc);
		addGetDecoratorTreeMethod(sc);
		addDecorateTreeMethod(sc);
		addDecorateTreeBasicMethod(sc);
		addPrintTreeMethod(sc);
		addPrintKeywordMethod(sc);
		addPrintFeatureMethod(sc);
		addPrintAttributeMethod(sc);
		addPrintContainedObjectMethod(sc);
		addPrintFormattingElementsMethod(sc);
		addGetValueMethod(sc);
		addPrintReferenceMethod(sc);
		addInitializePrintCountingMapMethod(sc);
		addGetOptionsMethod(sc);
		addSetOptionsMethod(sc);
		addGetResourceMethod(sc);
		addGetReferenceResolverSwitchMethod(sc);
		addAddWarningToResourceMethod(sc);
	}

	private void addDoPrintMethod(StringComposite sc, List<Rule> rules) {
		sc.add("protected void doPrint(" + E_OBJECT + " element) {");
		sc.add("if (element == null) {");
		sc.add("throw new " + ILLEGAL_ARGUMENT_EXCEPTION + "(\"Nothing to write.\");");
		sc.add("}");
		sc.add("if (writer == null) {");
		sc.add("throw new " + ILLEGAL_ARGUMENT_EXCEPTION + "(\"Nothing to write on.\");");
		sc.add("}");
		sc.addLineBreak();
		sc.add("startedPrintingElement = true;");
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
						+ ") element);");
				sc.add("return;");
				sc.add("}");
			}
		}
		sc.addLineBreak();
		sc.add("addWarningToResource(\"The printer can not handle \" + element.eClass().getName() + \" elements\", element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDecoratorTreeMethod(StringComposite sc) {
		// TODO this trees can be reused
		sc.add("// creates a tree of decorator objects which reflects the syntax tree that is");
		sc.add("// attached to the given syntax element");
		sc.add("public " + syntaxElementDecoratorClassName + " getDecoratorTree(" + syntaxElementClassName + " syntaxElement) {");
		sc.add(syntaxElementClassName + "[] children = syntaxElement.getChildren();");
		sc.add("int childCount = children.length;");
		sc.add(syntaxElementDecoratorClassName + "[] childDecorators = new " + syntaxElementDecoratorClassName + "[childCount];");
		sc.add("for (int i = 0; i < childCount; i++) {");
		sc.add("childDecorators[i] = getDecoratorTree(children[i]);");
		sc.add("}");
		sc.add(syntaxElementDecoratorClassName + " decorator = new " + syntaxElementDecoratorClassName + "(syntaxElement, childDecorators);");
		sc.add("return decorator;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + OUTPUT_STREAM + " outputStream, " + iTextResourceClassName + " resource) {");
		sc.add("super();");
		sc.add("this.writer = new " + PRINTER_WRITER + "(new " + BUFFERED_OUTPUT_STREAM + "(outputStream));");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("public final static " + STRING + " NEW_LINE = java.lang.System.getProperties().getProperty(\"line.separator\");");
		// TODO we should probably wrap all these members in a context class
		sc.add("// Holds the resource that is associated with this printer. may be null if the printer is used stand alone.");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.add("private " + PRINTER_WRITER + " writer;");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + getClassNameHelper().getI_TOKEN_RESOLVER_FACTORY() + " tokenResolverFactory = new " + tokenResolverFactoryClassName + "();");
		sc.add("private boolean startedPrintingElement = false;");
		sc.add("private " + LIST + "<" + formattingElementClassName + "> foundFormattingElements = new " + ARRAY_LIST + "<" + formattingElementClassName + ">();");
		sc.addLineBreak();
	}

	private void addPrintRuleMethods(StringComposite sc) {
		List<Rule> allRules = syntax.getAllRules();
		for (Rule rule : allRules) {
			addPrintRuleMethod(sc, rule);
			//addPrintSyntaxElementMethod(sc, rule.getDefinition());
		}
	}

	private void addPrintSyntaxElementMethod(StringComposite sc, Choice definition) {
		addPrintSyntaxElementMethodBasic(sc, definition);
		List<Sequence> options = definition.getOptions();
		for (Sequence sequence : options) {
			addPrintSyntaxElementMethod(sc, sequence);
		}
	}

	private void addPrintSyntaxElementMethod(StringComposite sc, Sequence sequence) {
		addPrintSyntaxElementMethodBasic(sc, sequence);
		List<Definition> parts = sequence.getParts();
		for (Definition part : parts) {
			addPrintSyntaxElementMethod(sc, part);
		}
	}

	private void addPrintSyntaxElementMethod(StringComposite sc, Definition definition) {
		addPrintSyntaxElementMethodBasic(sc, definition);
		if (definition instanceof CompoundDefinition) {
			CompoundDefinition cd = (CompoundDefinition) definition;
			addPrintRuleMethod(sc, cd);
		}
	}

	private void addPrintRuleMethod(StringComposite sc, CompoundDefinition cd) {
		addPrintSyntaxElementMethodBasic(sc, cd);
		Choice definitions = cd.getDefinitions();
		addPrintSyntaxElementMethod(sc, definitions);
	}

	private void addPrintSyntaxElementMethodBasic(StringComposite sc, EObject syntaxElement) {
		if (syntaxElement instanceof CsString) {
			sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "() {");
			CsString csString = (CsString) syntaxElement;
			String value = csString.getValue();
			sc.add("writer.write(\"" + StringUtil.escapeToJavaString(value) + "\");");
			sc.add("}");
			sc.addLineBreak();
		} else if (syntaxElement instanceof WhiteSpaces) {
			sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "() {");
			WhiteSpaces whiteSpace = (WhiteSpaces) syntaxElement;
			int count = whiteSpace.getAmount();
			if (count > 0) {
				String spaces = getWhiteSpaceString(count);
				sc.add("writer.write(\"" + spaces + "\");");
			}
			sc.add("}");
			sc.addLineBreak();
		} else if (syntaxElement instanceof Placeholder) {
			Placeholder placeholder = (Placeholder) syntaxElement;
			GenClassCache genClassCache = syntax.getGenClassCache();
			Rule rule = placeholder.getContainingRule();
			GenClass genClass = rule.getMetaclass();
			GenFeature genFeature = placeholder.getFeature();
			EStructuralFeature feature = genFeature.getEcoreFeature();
			String tokenName = placeholder.getToken().getName();

			String featureConstant = generatorUtil.getFeatureConstant(genClass, genFeature);
			if (feature instanceof EReference) {
				sc.add("// eObject is the container of the attribute or reference value to be printed");
				sc.add("// value is the attribute or reference value to be printed");
				sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "(" + genClassCache.getQualifiedInterfaceName(genClass) + " eObject, " + OBJECT + " value) {");
				sc.add(getClassNameHelper().getI_TOKEN_RESOLVER() + " resolver = tokenResolverFactory.createTokenResolver(\""
						+ tokenName
						+ "\");");
				sc.add("resolver.setOptions(getOptions());");
				sc.add(STRING + " deResolveResult = resolver.deResolve(" 
						+ getContext().getReferenceResolverAccessor(genFeature)
						+ ".deResolve((" + genClassCache.getQualifiedInterfaceName(genFeature.getTypeGenClass()) + ") value, eObject, (" + E_REFERENCE + ") eObject.eClass().getEStructuralFeature("
						+ featureConstant
						+ ")), eObject.eClass().getEStructuralFeature("
						+ featureConstant
						+ "), eObject);");
			} else {
				sc.add("// eObject is the container of the attribute or reference value to be printed");
				sc.add("// value is the attribute or reference value to be printed");
				sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "(" + E_OBJECT + " eObject, " + OBJECT + " value) {");
				sc.add(getClassNameHelper().getI_TOKEN_RESOLVER() + " resolver = tokenResolverFactory.createTokenResolver(\""
						+ tokenName
						+ "\");");
				sc.add("resolver.setOptions(getOptions());");
				sc.add(STRING + " deResolveResult = resolver.deResolve(value, eObject.eClass().getEStructuralFeature("
						+ featureConstant
						+ "), eObject);");
			}
			sc.add("writer.write(deResolveResult);");
			sc.add("}");
			sc.addLineBreak();
		}
	}

	private void addPrintRuleMethod(StringComposite sc, Rule rule) {
		sc.add("public void " + getMethodName(rule) + "(" + getMetaClassName(rule) + " eObject) {");
		sc.add(syntaxElementDecoratorClassName + " decoratorTree = getDecoratorTree(" + grammarInformationProviderClassName + "." + csUtil.getFieldName(rule) + ");");
		sc.add("decorateTree(decoratorTree, eObject);");
		sc.add("printTree(decoratorTree, eObject);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDecorateTreeMethod(StringComposite sc) {
		sc.add("public void decorateTree(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject) {");
		sc.add(MAP + "<" + STRING + ", " + INTEGER + "> printCountingMap = initializePrintCountingMap(eObject);");
		sc.add(LIST + "<" + syntaxElementDecoratorClassName + "> keywordsToPrint = new " + ARRAY_LIST + "<" + syntaxElementDecoratorClassName + ">();");
		sc.add("decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);");
		sc.add("for (" + syntaxElementDecoratorClassName + " keywordToPrint : keywordsToPrint) {");
		sc.add("// for keywords the concrete index does not matter, but we must add one to indicate that");
		sc.add("// the keyword needs to be printed here");
		sc.add("keywordToPrint.addIndexToPrint(0);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addDecorateTreeBasicMethod(StringComposite sc) {
		sc.add("// tries to decorate the decorator with an attribute value, or reference holds by eObject");
		sc.add("// returns true if an attribute value or reference was found");
		sc.add("public boolean decorateTreeBasic(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject, " + MAP + "<" + STRING + ", " + INTEGER + "> printCountingMap, " + LIST + "<" + syntaxElementDecoratorClassName +"> keywordsToPrint) {");
		sc.add("boolean foundFeatureToPrint = false;");
		sc.add(syntaxElementClassName + " syntaxElement = decorator.getDecoratedElement();");
		sc.add(cardinalityClassName + " cardinality = syntaxElement.getCardinality();");
		sc.add("while (true) {");
		sc.add(LIST + "<" + syntaxElementDecoratorClassName + "> subKeywordsToPrint = new " + ARRAY_LIST + "<" + syntaxElementDecoratorClassName + ">();");
		sc.add("boolean keepDecorating = false;");
		sc.add("if (syntaxElement instanceof " + keywordClassName + ") {");
		sc.add("subKeywordsToPrint.add(decorator);");
		sc.add("} else if (syntaxElement instanceof " + placeholderClassName + ") {");
		sc.add(placeholderClassName + " placeholder = (" + placeholderClassName + ") syntaxElement;");
		addCodeToDecorateWithFeature(sc, "placeholder");
		sc.add("} else if (syntaxElement instanceof " + containmentClassName + ") {");
		sc.add(containmentClassName + " containment = (" + containmentClassName + ") syntaxElement;");
		addCodeToDecorateWithFeature(sc, "containment");
		sc.add("}");
		sc.add("for (" + syntaxElementDecoratorClassName + " childDecorator : decorator.getChildDecorators()) {");
		sc.add("keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);");
		sc.add("if (syntaxElement instanceof " + choiceClassName + ") {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("foundFeatureToPrint |= keepDecorating;");
		sc.add("// we only print keywords if a feature was printed or the syntax element in mandatory");
		sc.add("if (cardinality == " + cardinalityClassName + ".ONE || cardinality == " + cardinalityClassName + ".PLUS) {");
		sc.add("keywordsToPrint.addAll(subKeywordsToPrint);");
		sc.add("} else if (keepDecorating && (cardinality == " + cardinalityClassName + ".STAR || cardinality == " + cardinalityClassName + ".QUESTIONMARK)) {");
		sc.add("keywordsToPrint.addAll(subKeywordsToPrint);");
		sc.add("}");
		sc.add("if (cardinality == " + cardinalityClassName + ".ONE || cardinality == " + cardinalityClassName + ".QUESTIONMARK) {");
		sc.add("break;");
		sc.add("} else if (!keepDecorating) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("return foundFeatureToPrint;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCodeToDecorateWithFeature(StringComposite sc, String syntaxElementVarName) {
		sc.add(E_STRUCTURAL_FEATURE + " feature = " + syntaxElementVarName + ".getFeature();");
		sc.add("int countLeft = printCountingMap.get(feature.getName());");
		sc.add("if (countLeft > 0) {");
		sc.add("decorator.addIndexToPrint(countLeft);");
		sc.add("printCountingMap.put(feature.getName(), countLeft - 1);");
		sc.add("keepDecorating = true;");
		sc.add("}");
	}
	
	private void addPrintTreeMethod(StringComposite sc) {
		sc.add("public boolean printTree(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject) {");
		sc.add(syntaxElementClassName + " printElement = decorator.getDecoratedElement();");
		sc.add(cardinalityClassName + " cardinality = printElement.getCardinality();");
		sc.add("boolean foundSomethingToPrint;");
		sc.add("while (true) {");
		sc.add("foundSomethingToPrint = false;");
		sc.add(INTEGER + " indexToPrint = decorator.getNextIndexToPrint();");
		sc.add("if (indexToPrint != null) {");
		sc.add("if (printElement instanceof " + keywordClassName + ") {");
		sc.add("printKeyword((" + keywordClassName + ") printElement, foundFormattingElements);");
		sc.add("foundSomethingToPrint = true;");
		sc.add("} else if (printElement instanceof " + placeholderClassName + ") {");
		sc.add(placeholderClassName + " placeholder = (" + placeholderClassName + ") printElement;");
		sc.add(E_STRUCTURAL_FEATURE + " feature = placeholder.getFeature();");
		sc.add("printFeature(eObject, feature, placeholder.getTokenName(), indexToPrint, foundFormattingElements);");
		sc.add("foundSomethingToPrint = true;");
		sc.add("} else if (printElement instanceof " + containmentClassName + ") {");
		sc.add(containmentClassName + " containment = (" + containmentClassName + ") printElement;");
		sc.add(E_STRUCTURAL_FEATURE + " feature = containment.getFeature();");
		sc.add("printContainedObject(eObject, feature, indexToPrint, foundFormattingElements);");
		sc.add("foundSomethingToPrint = true;");
		sc.add("}");
		sc.add("}");
		sc.add("if (printElement instanceof " + whiteSpaceClassName + ") {");
		sc.add("foundFormattingElements.add((" + whiteSpaceClassName + ") printElement);");
		sc.add("}");
		sc.add("if (printElement instanceof " + lineBreakClassName + ") {");
		sc.add("foundFormattingElements.add((" + lineBreakClassName + ") printElement);");
		sc.add("}");
		sc.add("for (" + syntaxElementDecoratorClassName + " childDecorator : decorator.getChildDecorators()) {");
		sc.add("foundSomethingToPrint |= printTree(childDecorator, eObject);");
		sc.add("}");
		sc.add("if (cardinality == " + cardinalityClassName + ".ONE || cardinality == " + cardinalityClassName + ".QUESTIONMARK) {");
		sc.add("break;");
		sc.add("} else if (!foundSomethingToPrint) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("return foundSomethingToPrint;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializePrintCountingMapMethod(StringComposite sc) {
		sc.add("public " + MAP + "<" + STRING + ", " + INTEGER + "> initializePrintCountingMap(" + E_OBJECT + " eObject) {");
		sc.add("// the printCountingMap contains a mapping from feature names to");
		sc.add("// the number of remaining elements that still need to be printed.");
		sc.add("// the map is initialized with the number of elements stored in each structural");
		sc.add("// feature. for lists this is the list size. for non-multiple features it is either");
		sc.add("// 1 (if the feature is set) or 0 (if the feature is null).");
		sc.add(MAP + "<" + STRING + ", " + INTEGER + "> printCountingMap = new " + LINKED_HASH_MAP + "<" + STRING + ", " + INTEGER + ">();");
		sc.add(LIST + "<" + E_STRUCTURAL_FEATURE + "> features = eObject.eClass().getEAllStructuralFeatures();");
		sc.add("for (" + E_STRUCTURAL_FEATURE + " feature : features) {");
		sc.add("int count = 0;");
		sc.add(OBJECT + " featureValue = eObject.eGet(feature);");
		sc.add("if (featureValue != null) {");
		sc.add("if (featureValue instanceof " + LIST + "<?>) {");
		sc.add("count = ((" + LIST + "<?>) featureValue).size();");
		sc.add("} else {");
		sc.add("count = 1;");
		sc.add("}");
		sc.add("}");
		sc.add("printCountingMap.put(feature.getName(), count);");
		sc.add("}");
		sc.add("return printCountingMap;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintKeywordMethod(StringComposite sc) {
		sc.add("public void printKeyword(" + keywordClassName + " keyword, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements) {");
		sc.add("printFormattingElements(foundFormattingElements);");
		sc.add("writer.write(keyword.getValue());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintFeatureMethod(StringComposite sc) {
		sc.add("public void printFeature(" + E_OBJECT + " eObject, " + E_STRUCTURAL_FEATURE + " feature, " + STRING + " tokenName, int count, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements) {");
		sc.add("printFormattingElements(foundFormattingElements);");
		sc.add("if (feature instanceof " + E_ATTRIBUTE + ") {");
		sc.add("printAttribute(eObject, (" + E_ATTRIBUTE + ") feature, tokenName, count);");
		sc.add("} else {");
		sc.add("printReference(eObject, (" + E_REFERENCE + ") feature, tokenName, count);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintAttributeMethod(StringComposite sc) {
		sc.add("public void printAttribute(" + E_OBJECT + " eObject, " + E_ATTRIBUTE + " attribute, String tokenName, int count) {");
		sc.add(OBJECT + " o = getValue(eObject, attribute, count);");

		sc.add("// deresolve token");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add("String deResolvedValue = tokenResolver.deResolve((" + OBJECT + ") o, attribute, eObject);");
		sc.add("// write result");
		sc.add("writer.write(deResolvedValue);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintReferenceMethod(StringComposite sc) {
		sc.add("public void printReference(" + E_OBJECT + " eObject, " + E_REFERENCE + " reference, String tokenName, int count) {");
		sc.add(OBJECT + " o = getValue(eObject, reference, count);");

		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(iReferenceResolverClassName + " referenceResolver = getReferenceResolverSwitch().getResolver(reference);");
		sc.add("referenceResolver.setOptions(getOptions());");
		
		sc.add(STRING + " deresolvedReference = referenceResolver.deResolve((" + E_OBJECT + ") o, eObject, reference);");
		sc.add(STRING + " deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);");
		sc.add("// write result");
		sc.add("writer.write(deresolvedToken);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintContainedObjectMethod(StringComposite sc) {
		sc.add("public void printContainedObject(" + E_OBJECT + " eObject, " + E_STRUCTURAL_FEATURE + " reference, int count, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements) {");
		sc.add("printFormattingElements(foundFormattingElements);");
		sc.add(OBJECT + " o = getValue(eObject, reference, count);");
		sc.add("doPrint((" + E_OBJECT + ") o);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintFormattingElementsMethod(StringComposite sc) {
		sc.add("public void printFormattingElements(" + LIST + "<" + formattingElementClassName + "> foundFormattingElements) {");
		// TODO (a) if the element to print is at the correct printing spot (the
		// one it was parsed at, print whitespace collected while parsing
		// (b) if whitespace of linebreak elements were found, print those
		sc.add("if (foundFormattingElements.size() > 0) {");
		sc.add("for (" + formattingElementClassName + " foundFormattingElement : foundFormattingElements) {");
		sc.add("if (foundFormattingElement instanceof " + whiteSpaceClassName + ") {");
		sc.add("int amount = ((" + whiteSpaceClassName + ") foundFormattingElement).getAmount();");
		sc.add("for (int i = 0; i < amount; i++) {");
		sc.add("writer.write(\" \");");
		sc.add("}");
		sc.add("}");
		sc.add("if (foundFormattingElement instanceof " + lineBreakClassName + ") {");
		sc.add("int tabs = ((" + lineBreakClassName + ") foundFormattingElement).getTabs();");
		sc.add("writer.write(NEW_LINE);");
		sc.add("for (int i = 0; i < tabs; i++) {");
		sc.add("writer.write(\"\\t\");");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("foundFormattingElements.clear();");
		sc.add("} else {");
		// (c) if not, print default token space
		sc.add("if (startedPrintingElement) {");
		sc.add("startedPrintingElement = false;");
		sc.add("} else {");
		String tokenSpace = getWhiteSpaceString(getTokenSpace());
		sc.add("writer.write(\"" + tokenSpace + "\");");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetValueMethod(StringComposite sc) {
		sc.add("private Object getValue(" + E_OBJECT + " eObject, " + E_STRUCTURAL_FEATURE + " feature, int count) {");
		sc.add("// get value of reference");
		sc.add(OBJECT + " o = eObject.eGet(feature);");
		sc.add("if (o instanceof " + LIST + "<?>) {");
		sc.add(LIST +"<?> list = (" + LIST + "<?>) o;");
		sc.add("int index = list.size() - count;");
		sc.add("o = list.get(index);");
		sc.add("}");
		sc.add("return o;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintMethod(StringComposite sc) {
		sc.add("public void print(" + E_OBJECT + " element) throws " + IO_EXCEPTION + " {");
		sc.add("foundFormattingElements.clear();");
		sc.add("doPrint(element);");
		sc.add("writer.flush();");
		sc.add("}");
		sc.addLineBreak();
	}
}
