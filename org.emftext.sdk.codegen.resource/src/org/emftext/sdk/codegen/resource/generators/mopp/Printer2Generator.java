package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PRINTER_WRITER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * A generator for a new experimental printing algorithm that tries
 * to preserve layout information that was gathered during parsing.
 * 
 * TODO use two separate classes to store layout information. One class for
 *      keywords and NC-reference, another one for attributes. The former
 *      do not need the field 'object' and 'visibleTokenText' as these are
 *      never used. The latter can use the current generator for the class
 *      LayoutInformation.
 */
public class Printer2Generator extends AbstractPrinterGenerator {

	private static ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final static NameUtil nameUtil = new NameUtil();
	
	private ConcreteSyntax syntax;
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		super.generateJavaContents(sc);

		syntax = getContext().getConcreteSyntax();

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iTextPrinterClassName + " {");
		sc.addLineBreak();
		addInnerClassPrintToken(sc);
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addInnerClassPrintToken(JavaComposite sc) {
		sc.add("private class PrintToken {");
		sc.addLineBreak();
		sc.add("private String text;");
		sc.add("private String tokenName;");
		sc.addLineBreak();
		sc.add("public PrintToken(String text, String tokenName) {");
		sc.add("this.text = text;");
		sc.add("this.tokenName = tokenName;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getText() {");
		sc.add("return text;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getTokenName() {");
		sc.add("return tokenName;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) { 
		addPrintMethod(sc);
		addDoPrintMethod(sc, syntax.getAllRules());
		addPrintInternalMethod(sc);
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
		addGetWhiteSpaceStringMethod(sc);
		addGetRepeatingStringMethod(sc);
		addSetAutomaticTokenSpaceHandlingMethod(sc);
		addSetTokenSpaceMethod(sc);
		addPrintBasicMethod(sc);
		addPrintSmartMethod(sc);
	}

	private void addSetTokenSpaceMethod(JavaComposite sc) {
		sc.add("public void setTokenSpace(int tokenSpace) {");
		sc.add("this.tokenSpace = tokenSpace;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetAutomaticTokenSpaceHandlingMethod(JavaComposite sc) {
		sc.add("public void setHandleTokenSpaceAutomatically(boolean handleTokenSpaceAutomatically) {");
		sc.add("this.handleTokenSpaceAutomatically = handleTokenSpaceAutomatically;");
		sc.add("}");
		sc.addLineBreak();
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
		sc.add("if (outputStream == null) {");
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
				sc.add("printInternal(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(rule) + ");");
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
		// these trees could be reused, but unless there are not serious
		// performance problems with the new printers I'd not change the
		// code that is currently generated
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
		sc.add("this.outputStream = outputStream;");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		boolean handleTokenSpaceAutomatically = OptionManager.INSTANCE.handleTokenSpaceAutomatically(getContext().getConcreteSyntax());
		
		sc.add("public final static " + STRING + " NEW_LINE = java.lang.System.getProperties().getProperty(\"line.separator\");");
		sc.addLineBreak();
		// TODO we should probably wrap all these members in a context class
		sc.addJavadoc("Holds the resource that is associated with this printer. May be null if the printer is used stand alone.");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.addLineBreak();
		
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + OUTPUT_STREAM + " outputStream;");
		sc.add("private " + LIST + "<PrintToken> tokenOutputStream;");
		sc.add("private " + iTokenResolverFactoryClassName + " tokenResolverFactory = new " + tokenResolverFactoryClassName + "();");
		sc.add("private boolean handleTokenSpaceAutomatically = " + handleTokenSpaceAutomatically + ";");
		sc.add("private int tokenSpace = " + getTokenSpace() + ";");
		sc.add("private boolean startedPrintingElement = false;");
		sc.addLineBreak();
	}

	private void addPrintInternalMethod(JavaComposite sc) {
		sc.add("public void printInternal(" + E_OBJECT + " eObject, " + syntaxElementClassName + " ruleElement) {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(eObject);");
		sc.add(LIST + "<" + layoutInformationClassName + "> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();");
		sc.addComment(
			"create a copy of the original list of layout information object in order " +
			"to be able to remove used informations during printing"
		);
		sc.add(LIST + "<" + layoutInformationClassName + "> layoutInformations = new " + ARRAY_LIST + "<" + layoutInformationClassName+ ">(originalLayoutInformations.size());");
		sc.add("layoutInformations.addAll(originalLayoutInformations);");
		sc.add(syntaxElementDecoratorClassName + " decoratorTree = getDecoratorTree(ruleElement);");
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
		sc.add("String value = keyword.getValue();");
		// using single quotes to obtain the token name here is ANTLR specific
		sc.add("tokenOutputStream.add(new PrintToken(value, \"'\" + value + \"'\"));");
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
		sc.add("tokenOutputStream.add(new PrintToken(result, placeholder.getTokenName()));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintReferenceMethod(JavaComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
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
		sc.add("String tokenName = placeholder.getTokenName();");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(iReferenceResolverClassName + " referenceResolver = getReferenceResolverSwitch().getResolver(reference);");
		sc.add("referenceResolver.setOptions(getOptions());");
		
		sc.add(STRING + " deresolvedReference = referenceResolver.deResolve((" + E_OBJECT + ") referencedObject, eObject, reference);");
		sc.add(STRING + " deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);");
		sc.addComment("write result to output stream");
		sc.add("tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName));");
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
		sc.add("tokenOutputStream.add(new PrintToken(hiddenTokenText, null));");
		sc.add("foundFormattingElements.clear();");
		sc.add("startedPrintingElement = false;");
		sc.add("return;");
		sc.add("}");
		// (b) if Whitespace or LineBreak elements were found, print those
		sc.add("if (foundFormattingElements.size() > 0) {");
		sc.add("for (" + formattingElementClassName + " foundFormattingElement : foundFormattingElements) {");
		sc.add("if (foundFormattingElement instanceof " + whiteSpaceClassName + ") {");
		sc.add("int amount = ((" + whiteSpaceClassName + ") foundFormattingElement).getAmount();");
		sc.add("for (int i = 0; i < amount; i++) {");
		sc.add("tokenOutputStream.add(new PrintToken(\" \", null));");
		sc.add("}");
		sc.add("}");
		sc.add("if (foundFormattingElement instanceof " + lineBreakClassName + ") {");
		sc.add("int tabs = ((" + lineBreakClassName + ") foundFormattingElement).getTabs();");
		sc.add("tokenOutputStream.add(new PrintToken(NEW_LINE, null));");
		sc.add("for (int i = 0; i < tabs; i++) {");
		sc.add("tokenOutputStream.add(new PrintToken(\"\\t\", null));");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("foundFormattingElements.clear();");
		sc.add("startedPrintingElement = false;");
		sc.add("} else {");
		// (c) if not, print default token space, but only if automatic token
		//     space handling is disabled
		sc.add("if (startedPrintingElement) {");
		sc.add("startedPrintingElement = false;");
		sc.add("} else {");
		sc.add("if (!handleTokenSpaceAutomatically) {");
		sc.add("tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null));");
		sc.add("}");
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
		sc.add("public void print(" + E_OBJECT + " element) throws " + IO_EXCEPTION + " {");
		sc.add("tokenOutputStream = new " + ARRAY_LIST + "<PrintToken>();");
		sc.add("doPrint(element);");
		sc.add(PRINTER_WRITER + " writer = new " + PRINTER_WRITER + "(new " + BUFFERED_OUTPUT_STREAM + "(outputStream));");
		sc.add("if (handleTokenSpaceAutomatically) {");
		sc.add("printSmart(writer);");
		sc.add("} else {");
		sc.add("printBasic(writer);");
		sc.add("}");
		sc.add("writer.flush();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintBasicMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Prints the current tokenOutputStream to the given writer (as it is)."
		);
		sc.add("public void printBasic(" + PRINTER_WRITER + " writer) throws " + IO_EXCEPTION + " {");
		sc.add("for (PrintToken nextToken : tokenOutputStream) {");
		sc.add("writer.write(nextToken.getText());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintSmartMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Prints the current tokenOutputStream to the given writer.",
			"",
			"This methods implements smart whitespace printing. It does so by " +
			"writing output to a token stream instead of printing the raw token " +
			"text to a PrintWriter. Tokens in this stream hold both the text " +
			"and the type of the token (i.e., its name).",
			"",
			"To decide where whitespace is needed, sequences of successive tokens " +
			"are searched that can be printed without separating whitespace. " +
			"To determine such groups we start with two successive non-whitespace tokens, " +
			"concatenate their text and use the generated ANTLR lexer to split the text. " +
			"If the resulting token sequence of the concatenated text is exactly the same as " + 
			"the one that is to be printed, no whitespace is needed. The tokens " + 
			"in the sequence are checked both regarding their type and their " + 
			"text. If two tokens successfully form a group a third one is " + 
			"added and so on."
		);
		sc.add("public void printSmart(" + PRINTER_WRITER + " writer) throws " + IO_EXCEPTION + " {");
		sc.addComment(
			"stores the text of the current group of tokens. " +
			"this text is given to the lexer to check whether it can be correctly scanned."
		);
		sc.add("StringBuilder currentBlock = new StringBuilder();");
		sc.addComment(
			"stores the index of the first token of the current group."
		);
		sc.add("int currentBlockStart = 0;");
		sc.addComment(
			"stores the text that was already successfully checked (i.e., is can be scanned correctly and can thus be printed)."
		);
		sc.add("String validBlock = \"\";");

		sc.add("for (int i = 0; i < tokenOutputStream.size(); i++) {");
		
		sc.add("PrintToken tokenI = tokenOutputStream.get(i);");
		sc.add("currentBlock.append(tokenI.getText());");
		
		sc.addComment("if declared or preserved whitespace is found - print block");
		sc.add("if (tokenI.getTokenName() == null) {");
		sc.add("writer.write(currentBlock.toString());");
		sc.addComment("reset all values");
		sc.add("currentBlock = new StringBuilder();");
		sc.add("currentBlockStart = i + 1;");
		sc.add("validBlock = \"\";");
		sc.add("continue;");
		sc.add("}");
		
		sc.addComment("now check whether the current block can be scanned");
		
		sc.add(iTextScannerClassName + " scanner = new " + metaInformationClassName + "().createLexer();");
		sc.add("scanner.setText(currentBlock.toString());");
		
		sc.addComment("retrieve all tokens from scanner and add them to list 'tempTokens'");
		sc.add(LIST + "<" + iTextTokenClassName + "> tempTokens = new " + ARRAY_LIST + "<" + iTextTokenClassName + ">();");
		sc.add(iTextTokenClassName  + " nextToken = scanner.getNextToken();");
		sc.add("while (nextToken != null) {");
		sc.add("tempTokens.add(nextToken);");
		sc.add("}");
		
		sc.add("boolean sequenceIsValid = true;");
		sc.addComment("check whether the current block was scanned to the same token sequence");
		sc.add("for (int t = 0; t < tempTokens.size(); t++) {");
		sc.add("PrintToken printTokenT = tokenOutputStream.get(currentBlockStart + t);");
		sc.add(iTextTokenClassName + " tempToken = tempTokens.get(t);");
		sc.add("if (!tempToken.getText().equals(printTokenT.getText())) {");
		sc.add("sequenceIsValid = false;");
		sc.add("break;");
		sc.add("}");
		sc.add("String commonTokenName = tempToken.getName();");
		sc.add("if (!commonTokenName.equals(printTokenT.getTokenName())) {");
		sc.add("sequenceIsValid = false;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("if (sequenceIsValid) {");
		sc.addComment("sequence is still valid, try adding one more token in the next iteration of the loop");
		sc.add("validBlock += tokenI.getText();");
		sc.add("} else {");
		sc.addComment("sequence is not valid, must print whitespace to separate tokens");
		sc.addComment("print text that is valid so far");
		sc.add("writer.write(validBlock);");
		sc.addComment("print separating whitespace");
		// TODO we need some way to specify the string that is used for
		// automatic whitespace handling
		sc.add("writer.write(\" \");");
		sc.addComment("add current token as initial value for next iteration");
		sc.add("currentBlock = new StringBuilder(tokenI.getText());");
		sc.add("currentBlockStart = i;");
		sc.add("validBlock = tokenI.getText();");
		sc.add("}");
		
		sc.add("}");
		sc.addComment("flush remaining valid text to writer");
		sc.add("writer.write(validBlock);");
		sc.add("}");
		sc.addLineBreak();
	}
}
