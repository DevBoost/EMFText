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
import org.emftext.sdk.codegen.composites.JavaComposite;
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
	
	public Printer2Generator() {
		super();
	}

	private Printer2Generator(GenerationContext context) {
		super(context, EArtifact.PRINTER2);
		syntax = context.getConcreteSyntax();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new Printer2Generator(context);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
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

	private void addMethods(JavaComposite sc) { 
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
		generatorUtil.addGetLayoutAdapterMethod(sc, layoutInformationAdapterClassName);
		addGetLayoutInformationMethod(sc);
		addGetHiddenTokenTextMethod(sc);
		addGetVisibleTokenTextMethod(sc);
	}

	private void addGetLayoutInformationMethod(StringComposite sc) {
		sc.add("private " + layoutInformationClassName + " getLayoutInformation(" + LIST + "<" + layoutInformationClassName + "> layoutInformations, " + syntaxElementClassName + " syntaxElement, " + OBJECT + " object, " + E_OBJECT + " container) {");
		sc.add("for (" + layoutInformationClassName + " layoutInformation : layoutInformations) {");
		sc.add("if (syntaxElement == layoutInformation.getSyntaxElement()) {");
		sc.add("if (object == null) {");
		sc.add("return layoutInformation;");
		sc.add("} else if (object == layoutInformation.getObject(container)) {");
		sc.add("return layoutInformation;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHiddenTokenTextMethod(StringComposite sc) {
		sc.add("private " + STRING + " getHiddenTokenText(" + layoutInformationClassName + " layoutInformation) {");
		sc.add("if (layoutInformation != null) {");
		sc.add("return layoutInformation.getHiddenTokenText();");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVisibleTokenTextMethod(StringComposite sc) {
		sc.add("private " + STRING + " getVisibleTokenText(" + layoutInformationClassName + " layoutInformation) {");
		sc.add("if (layoutInformation != null) {");
		sc.add("return layoutInformation.getVisibleTokenText();");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
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

	private void addGetDecoratorTreeMethod(JavaComposite sc) {
		// TODO this trees can be reused
		sc.addJavadoc(
			"creates a tree of decorator objects which reflects the syntax tree that is " +
			"attached to the given syntax element"
		);
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

	private void addFields(JavaComposite sc) {
		sc.add("public final static " + STRING + " NEW_LINE = java.lang.System.getProperties().getProperty(\"line.separator\");");
		// TODO we should probably wrap all these members in a context class
		sc.addJavadoc("Holds the resource that is associated with this printer. May be null if the printer is used stand alone.");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.add("private " + PRINTER_WRITER + " writer;");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + getClassNameHelper().getI_TOKEN_RESOLVER_FACTORY() + " tokenResolverFactory = new " + tokenResolverFactoryClassName + "();");
		sc.add("private boolean startedPrintingElement = false;");
		sc.addLineBreak();
	}

	private void addPrintRuleMethods(JavaComposite sc) {
		List<Rule> allRules = syntax.getAllRules();
		for (Rule rule : allRules) {
			addPrintRuleMethod(sc, rule);
			//addPrintSyntaxElementMethod(sc, rule.getDefinition());
		}
	}

	private void addPrintSyntaxElementMethod(JavaComposite sc, Choice definition) {
		addPrintSyntaxElementMethodBasic(sc, definition);
		List<Sequence> options = definition.getOptions();
		for (Sequence sequence : options) {
			addPrintSyntaxElementMethod(sc, sequence);
		}
	}

	private void addPrintSyntaxElementMethod(JavaComposite sc, Sequence sequence) {
		addPrintSyntaxElementMethodBasic(sc, sequence);
		List<Definition> parts = sequence.getParts();
		for (Definition part : parts) {
			addPrintSyntaxElementMethod(sc, part);
		}
	}

	private void addPrintSyntaxElementMethod(JavaComposite sc, Definition definition) {
		addPrintSyntaxElementMethodBasic(sc, definition);
		if (definition instanceof CompoundDefinition) {
			CompoundDefinition cd = (CompoundDefinition) definition;
			addPrintRuleMethod(sc, cd);
		}
	}

	private void addPrintRuleMethod(JavaComposite sc, CompoundDefinition cd) {
		addPrintSyntaxElementMethodBasic(sc, cd);
		Choice definitions = cd.getDefinition();
		addPrintSyntaxElementMethod(sc, definitions);
	}

	private void addPrintSyntaxElementMethodBasic(JavaComposite sc, EObject syntaxElement) {
		if (syntaxElement instanceof CsString) {
			CsString csString = (CsString) syntaxElement;
			sc.add("public void print_" + csUtil.getFieldName(csString) + "() {");
			String value = csString.getValue();
			sc.add("writer.write(\"" + StringUtil.escapeToJavaString(value) + "\");");
			sc.add("}");
			sc.addLineBreak();
		} else if (syntaxElement instanceof WhiteSpaces) {
			WhiteSpaces whiteSpace = (WhiteSpaces) syntaxElement;
			sc.add("public void print_" + csUtil.getFieldName(whiteSpace) + "() {");
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
				sc.addJavadoc(
					"Prints the given reference value. " + 
					"The parameter eObject is the container of the reference to be printed."
				);
				sc.add("public void print_" + csUtil.getFieldName(placeholder) + "(" + genClassCache.getQualifiedInterfaceName(genClass) + " eObject, " + OBJECT + " value) {");
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
				sc.addJavadoc(
						"Prints the given attribute value. " + 
						"The parameter eObject is the container of the attribute to be printed."
					);
				sc.add("public void print_" + csUtil.getFieldName(placeholder) + "(" + E_OBJECT + " eObject, " + OBJECT + " value) {");
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

	private void addPrintRuleMethod(JavaComposite sc, Rule rule) {
		sc.add("public void " + getMethodName(rule) + "(" + getMetaClassName(rule) + " eObject) {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(eObject);");
		sc.add(LIST + "<" + layoutInformationClassName + "> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();");
		sc.addComment(
			"create a copy of the original list of layout information object in order " +
			"to be able to remove used informations during printing"
		);
		sc.add(LIST + "<" + layoutInformationClassName + "> layoutInformations = new " + ARRAY_LIST + "<" + layoutInformationClassName+ ">(originalLayoutInformations.size());");
		sc.add("layoutInformations.addAll(originalLayoutInformations);");
		sc.add(syntaxElementDecoratorClassName + " decoratorTree = getDecoratorTree(" + grammarInformationProviderClassName + "." + csUtil.getFieldName(rule) + ");");
		sc.add("decorateTree(decoratorTree, eObject);");
		sc.add("printTree(decoratorTree, eObject, new " + ARRAY_LIST + "<" + formattingElementClassName + ">(), layoutInformations);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDecorateTreeMethod(JavaComposite sc) {
		sc.add("public void decorateTree(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject) {");
		sc.add(MAP + "<" + STRING + ", " + INTEGER + "> printCountingMap = initializePrintCountingMap(eObject);");
		sc.add(LIST + "<" + syntaxElementDecoratorClassName + "> keywordsToPrint = new " + ARRAY_LIST + "<" + syntaxElementDecoratorClassName + ">();");
		sc.add("decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);");
		sc.add("for (" + syntaxElementDecoratorClassName + " keywordToPrint : keywordsToPrint) {");
		sc.addComment(
			"for keywords the concrete index does not matter, but we must add one to indicate that " +
			"the keyword needs to be printed here. Thus, we use 0 as index."
		);
		sc.add("keywordToPrint.addIndexToPrint(0);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addDecorateTreeBasicMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Tries to decorate the decorator with an attribute value, or reference holded by eObject. " +
			"Returns true if an attribute value or reference was found."
		);
		sc.add("public boolean decorateTreeBasic(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject, " + MAP + "<" + STRING + ", " + INTEGER + "> printCountingMap, " + LIST + "<" + syntaxElementDecoratorClassName +"> keywordsToPrint) {");
		sc.add("boolean foundFeatureToPrint = false;");
		sc.add(syntaxElementClassName + " syntaxElement = decorator.getDecoratedElement();");
		sc.add(cardinalityClassName + " cardinality = syntaxElement.getCardinality();");
		sc.add("boolean isFirstIteration = true;");
		sc.add("while (true) {");
		sc.add(LIST + "<" + syntaxElementDecoratorClassName + "> subKeywordsToPrint = new " + ARRAY_LIST + "<" + syntaxElementDecoratorClassName + ">();");
		sc.add("boolean keepDecorating = false;");
		sc.add("if (syntaxElement instanceof " + keywordClassName + ") {");
		sc.add("subKeywordsToPrint.add(decorator);");
		sc.add("} else if (syntaxElement instanceof " + terminalClassName + ") {");
		sc.add(terminalClassName + " terminal = (" + terminalClassName + ") syntaxElement;");
		sc.add(E_STRUCTURAL_FEATURE + " feature = terminal.getFeature();");
		sc.add("int countLeft = printCountingMap.get(feature.getName());");
		sc.add("if (countLeft > terminal.getMandatoryOccurencesAfter()) {");
		sc.add("decorator.addIndexToPrint(countLeft);");
		sc.add("printCountingMap.put(feature.getName(), countLeft - 1);");
		sc.add("keepDecorating = true;");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + syntaxElementDecoratorClassName + " childDecorator : decorator.getChildDecorators()) {");
		sc.add("keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);");
		sc.add("if (syntaxElement instanceof " + choiceClassName + ") {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("foundFeatureToPrint |= keepDecorating;");
		sc.addComment("only print keywords if a feature was printed or the syntax element is mandatory");
		sc.add("if (cardinality == " + cardinalityClassName + ".ONE) {");
		sc.add("keywordsToPrint.addAll(subKeywordsToPrint);");
		sc.add("} else if (cardinality == " + cardinalityClassName + ".PLUS) {");
		sc.add("if (isFirstIteration) {");
		sc.add("keywordsToPrint.addAll(subKeywordsToPrint);");
		sc.add("} else {");
		sc.add("if (keepDecorating) {");
		sc.add("keywordsToPrint.addAll(subKeywordsToPrint);");
		sc.add("}");
		sc.add("}");
		sc.add("} else if (keepDecorating && (cardinality == " + cardinalityClassName + ".STAR || cardinality == " + cardinalityClassName + ".QUESTIONMARK)) {");
		sc.add("keywordsToPrint.addAll(subKeywordsToPrint);");
		sc.add("}");
		sc.add("if (cardinality == " + cardinalityClassName + ".ONE || cardinality == " + cardinalityClassName + ".QUESTIONMARK) {");
		sc.add("break;");
		sc.add("} else if (!keepDecorating) {");
		sc.add("break;");
		sc.add("}");
		sc.add("isFirstIteration = false;");
		sc.add("}");
		sc.add("return foundFeatureToPrint;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintTreeMethod(JavaComposite sc) {
		sc.add("public boolean printTree(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject, " + LIST + "<" + formattingElementClassName +"> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(syntaxElementClassName + " printElement = decorator.getDecoratedElement();");
		sc.add(cardinalityClassName + " cardinality = printElement.getCardinality();");
		sc.add(LIST + "<" + formattingElementClassName + "> cloned = new " + ARRAY_LIST + "<" + formattingElementClassName + ">();");
		sc.add("cloned.addAll(foundFormattingElements);");
		sc.add("boolean foundSomethingAtAll = false;");
		sc.add("boolean foundSomethingToPrint;");
		sc.add("while (true) {");
		sc.add("foundSomethingToPrint = false;");
		sc.add(INTEGER + " indexToPrint = decorator.getNextIndexToPrint();");
		sc.add("if (indexToPrint != null) {");
		sc.add("if (printElement instanceof " + keywordClassName + ") {");
		sc.add("printKeyword(eObject, (" + keywordClassName + ") printElement, foundFormattingElements, layoutInformations);");
		sc.add("foundSomethingToPrint = true;");
		sc.add("} else if (printElement instanceof " + placeholderClassName + ") {");
		sc.add(placeholderClassName + " placeholder = (" + placeholderClassName + ") printElement;");
		sc.add("printFeature(eObject, placeholder, indexToPrint, foundFormattingElements, layoutInformations);");
		sc.add("foundSomethingToPrint = true;");
		sc.add("} else if (printElement instanceof " + containmentClassName + ") {");
		sc.add(containmentClassName + " containment = (" + containmentClassName + ") printElement;");
		sc.add("printContainedObject(eObject, containment, indexToPrint, foundFormattingElements, layoutInformations);");
		sc.add("foundSomethingToPrint = true;");
		sc.add("}");
		sc.add("}");
		sc.add("if (foundSomethingToPrint) {");
		sc.add("foundSomethingAtAll = true;");
		sc.add("}");
		sc.add("if (printElement instanceof " + whiteSpaceClassName + ") {");
		sc.add("foundFormattingElements.add((" + whiteSpaceClassName + ") printElement);");
		sc.add("}");
		sc.add("if (printElement instanceof " + lineBreakClassName + ") {");
		sc.add("foundFormattingElements.add((" + lineBreakClassName + ") printElement);");
		sc.add("}");
		sc.add("for (" + syntaxElementDecoratorClassName + " childDecorator : decorator.getChildDecorators()) {");
		sc.add("foundSomethingToPrint |= printTree(childDecorator, eObject, foundFormattingElements, layoutInformations);");
		sc.add("}");
		sc.add("if (cardinality == " + cardinalityClassName + ".ONE || cardinality == " + cardinalityClassName + ".QUESTIONMARK) {");
		sc.add("break;");
		sc.add("} else if (!foundSomethingToPrint) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.addComment("only print formatting elements if a feature was printed or the syntax element is mandatory");
		sc.add("if (!foundSomethingAtAll && (cardinality == " + cardinalityClassName + ".STAR || cardinality == " + cardinalityClassName + ".QUESTIONMARK)) {");
		sc.add("foundFormattingElements.clear();");
		sc.add("foundFormattingElements.addAll(cloned);");
		sc.add("}");
		sc.add("return foundSomethingToPrint;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializePrintCountingMapMethod(JavaComposite sc) {
		sc.add("public " + MAP + "<" + STRING + ", " + INTEGER + "> initializePrintCountingMap(" + E_OBJECT + " eObject) {");
		sc.addComment(
			"The printCountingMap contains a mapping from feature names to " +
			"the number of remaining elements that still need to be printed. " +
			"The map is initialized with the number of elements stored in each structural " +
			"feature. For lists this is the list size. For non-multiple features it is either " +
			"1 (if the feature is set) or 0 (if the feature is null)."
		);
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
		sc.add("public void printKeyword(" + E_OBJECT + " eObject, " + keywordClassName + " keyword, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(layoutInformationClassName + " layoutInformation = getLayoutInformation(layoutInformations, keyword, null, eObject);");
		sc.add("printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);");
		sc.add("writer.write(keyword.getValue());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintFeatureMethod(StringComposite sc) {
		sc.add("public void printFeature(" + E_OBJECT + " eObject, " + placeholderClassName + " placeholder, int count, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(E_STRUCTURAL_FEATURE + " feature = placeholder.getFeature();");
		sc.add("if (feature instanceof " + E_ATTRIBUTE + ") {");
		sc.add("printAttribute(eObject, (" + E_ATTRIBUTE + ") feature, placeholder, count, foundFormattingElements, layoutInformations);");
		sc.add("} else {");
		sc.add("printReference(eObject, (" + E_REFERENCE + ") feature, placeholder, count, foundFormattingElements, layoutInformations);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintAttributeMethod(JavaComposite sc) {
		sc.add("public void printAttribute(" + E_OBJECT + " eObject, " + E_ATTRIBUTE + " attribute, " + placeholderClassName + " placeholder, int count, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(STRING + " result;");
		sc.add(OBJECT + " attributeValue = getValue(eObject, attribute, count);");
		sc.add(layoutInformationClassName + " layoutInformation = getLayoutInformation(layoutInformations, placeholder, attributeValue, eObject);");
		sc.add(STRING + " visibleTokenText = getVisibleTokenText(layoutInformation);");
		sc.addComment("if there is text for the attribute we use it");
		sc.add("if (visibleTokenText != null) {");
		sc.add("result = visibleTokenText;");
		sc.add("} else {");
		sc.addComment("if no text is available, the attribute is deresolved to obtain its textual representation");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(STRING + " deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);");
		sc.add("result = deResolvedValue;");
		sc.add("}");
		sc.add("if (result != null && !\"\".equals(result)) {");
		sc.add("printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);");
		sc.add("}");
		sc.addComment("write result to the output stream");
		sc.add("writer.write(result);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintReferenceMethod(JavaComposite sc) {
		sc.add("public void printReference(" + E_OBJECT + " eObject, " + E_REFERENCE + " reference, " + placeholderClassName + " placeholder, int count, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(OBJECT + " referencedObject = getValue(eObject, reference, count);");
		sc.add(layoutInformationClassName + " layoutInformation = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);");
		sc.add("printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);");
		sc.addComment(
			"NC-References must always be printed by deresolving the reference. " +
			"We cannot use the visible token information, because deresolving " +
			"usually depends on attribute values of the referenced object instead of the " +
			"object itself."
		);
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(iReferenceResolverClassName + " referenceResolver = getReferenceResolverSwitch().getResolver(reference);");
		sc.add("referenceResolver.setOptions(getOptions());");
		
		sc.add(STRING + " deresolvedReference = referenceResolver.deResolve((" + E_OBJECT + ") referencedObject, eObject, reference);");
		sc.add(STRING + " deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);");
		sc.addComment("write result to output stream");
		sc.add("writer.write(deresolvedToken);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintContainedObjectMethod(StringComposite sc) {
		sc.add("public void printContainedObject(" + E_OBJECT + " eObject, " + containmentClassName + " containment, int count, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(E_STRUCTURAL_FEATURE + " reference = containment.getFeature();");
		sc.add(OBJECT + " o = getValue(eObject, reference, count);");
		sc.add("doPrint((" + E_OBJECT + ") o);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintFormattingElementsMethod(JavaComposite sc) {
		sc.add("public void printFormattingElements(" + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations, " + layoutInformationClassName + " layoutInformation) {");
		// (a) if the element to print is at the correct printing spot (the
		// one it was parsed at, print whitespace collected while parsing
		sc.add(STRING + " hiddenTokenText = getHiddenTokenText(layoutInformation);");
		sc.add("if (hiddenTokenText != null) {");
		sc.addComment("removed used information");
		sc.add("layoutInformations.remove(layoutInformation);");
		sc.add("writer.write(hiddenTokenText);");
		sc.add("foundFormattingElements.clear();");
		sc.add("startedPrintingElement = false;");
		sc.add("return;");
		sc.add("}");
		// (b) if Whitespace of LineBreak elements were found, print those
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
		sc.add("startedPrintingElement = false;");
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

	private void addGetValueMethod(JavaComposite sc) {
		sc.add("private Object getValue(" + E_OBJECT + " eObject, " + E_STRUCTURAL_FEATURE + " feature, int count) {");
		sc.addComment("get value of feature");
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

	private void addPrintMethod(JavaComposite sc) {
		sc.addJavadoc("Prints the given elements to the output stream writer.");
		sc.add("public void print(" + E_OBJECT + " element) throws " + IO_EXCEPTION + " {");
		sc.add("doPrint(element);");
		sc.add("writer.flush();");
		sc.add("}");
		sc.addLineBreak();
	}
}
