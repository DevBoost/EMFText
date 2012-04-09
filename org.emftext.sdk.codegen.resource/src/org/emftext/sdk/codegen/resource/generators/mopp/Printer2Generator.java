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

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ENUMERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM_WRITER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PRINTER_WRITER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * A generator for a new experimental printing algorithm that tries
 * to preserve layout information that was gathered during parsing.
 * 
 * TODO use two separate classes to store layout information. One class for
 *      keywords and NC-references, another one for attributes. The former
 *      do not need the field 'object' and 'visibleTokenText' as these are
 *      never used. The latter can use the current generator for the class
 *      LayoutInformation.
 */
@SyntaxDependent
public class Printer2Generator extends AbstractPrinterGenerator {

	private static ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final static NameUtil nameUtil = new NameUtil();
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		super.generateJavaContents(sc);

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iTextPrinterClassName + " {");
		sc.addLineBreak();
		addInnerClassPrintToken(sc);
		addInnerClassPrintCountingMap(sc);
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addInnerClassPrintToken(JavaComposite sc) {
		sc.add("protected class PrintToken {");
		sc.addLineBreak();
		sc.add("private String text;");
		sc.add("private String tokenName;");
		sc.add("private " + E_OBJECT + " container;");
		sc.addLineBreak();
		sc.add("public PrintToken(String text, String tokenName, " + E_OBJECT + " container) {");
		sc.add("this.text = text;");
		sc.add("this.tokenName = tokenName;");
		sc.add("this.container = container;");
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
		sc.add("public " + E_OBJECT + " getContainer() {");
		sc.add("return container;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return \"'\" + text + \"' [\" + tokenName + \"]\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClassPrintCountingMap(JavaComposite sc) {
		ConcreteSyntax concreteSyntax = getContext().getConcreteSyntax();
		boolean ignoreTypeRestrictions = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING);

		sc.addJavadoc(
			"The PrintCountingMap keeps tracks of the values that must be printed for each " +
			"feature of an EObject. It is also used to store the indices of all values that have been " +
			"printed. This knowledge is used to avoid printing values twice. We must store the concrete " +
			"indices of the printed values instead of basically counting them, because values may be printed " +
			"in an order that differs from the order in which they are stored in the EObject's feature."
		);
		sc.add("protected class PrintCountingMap {");
		sc.addLineBreak();
		sc.add("private " + MAP + "<String, " + LIST + "<Object>> featureToValuesMap = new " + LINKED_HASH_MAP +"<String, " + LIST + "<Object>>();");
		sc.add("private " + MAP + "<String, " + SET + "<Integer>> featureToPrintedIndicesMap = new " + LINKED_HASH_MAP + "<String, " + SET +"<Integer>>();");
		sc.addLineBreak();
		sc.add("public void setFeatureValues(String featureName, " + LIST + "<Object> values) {");
		sc.add("featureToValuesMap.put(featureName, values);");
		sc.addComment("If the feature does not have values it won't be printed. An entry in 'featureToPrintedIndicesMap' is therefore not needed in this case.");
		sc.add("if (values != null) {");
		sc.add("featureToPrintedIndicesMap.put(featureName, new " + LINKED_HASH_SET + "<Integer>());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + SET + "<Integer> getIndicesToPrint(String featureName) {");
		sc.add("return featureToPrintedIndicesMap.get(featureName);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addIndexToPrint(String featureName, int index) {");
		sc.add("featureToPrintedIndicesMap.get(featureName).add(index);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int getCountLeft(" + terminalClassName + " terminal) {");
		sc.add(E_STRUCTURAL_FEATURE + " feature = terminal.getFeature();");
		sc.add("String featureName = feature.getName();");
		sc.add(LIST + "<Object> totalValuesToPrint = featureToValuesMap.get(featureName);");
		sc.add(SET + "<Integer> printedIndices = featureToPrintedIndicesMap.get(featureName);");
		sc.add("if (totalValuesToPrint == null) {");
		sc.add("return 0;");
		sc.add("}");
		if (ignoreTypeRestrictions) {
			sc.add("return totalValuesToPrint.size() - printedIndices.size();");
		} else {
			sc.add("if (feature instanceof " + E_ATTRIBUTE + ") {");
			sc.addComment(
				"for attributes we do not need to check the type, since the CS languages does not " +
				"allow type restrictions for attributes."
			);
			sc.add("return totalValuesToPrint.size() - printedIndices.size();");
			sc.add("} else if (feature instanceof " + E_REFERENCE + ") {");
			sc.add(E_REFERENCE + " reference = (" + E_REFERENCE + ") feature;");
			sc.add("if (!reference.isContainment()) {");
			sc.addComment(
				"for non-containment references we also do not need to check the type, since the CS languages does not " +
				"allow type restrictions for these either."
			);
			sc.add("return totalValuesToPrint.size() - printedIndices.size();");
			sc.add("}");
			sc.add("}");
			sc.addComment("now we're left with containment references for which we check the type of the objects to print");
			sc.add(LIST + "<Class<?>> allowedTypes = getAllowedTypes(terminal);");
			sc.add(SET + "<Integer> indicesWithCorrectType = new " + LINKED_HASH_SET + "<Integer>();");
			sc.add("int index = 0;");
			sc.add("for (Object valueToPrint : totalValuesToPrint) {");
			sc.add("for (Class<?> allowedType : allowedTypes) {");
			sc.add("if (allowedType.isInstance(valueToPrint)) {");
			sc.add("indicesWithCorrectType.add(index);");
			sc.add("}");
			sc.add("}");
			sc.add("index++;");
			sc.add("}");
			sc.add("indicesWithCorrectType.removeAll(printedIndices);");
			sc.add("return indicesWithCorrectType.size();");
		}
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int getNextIndexToPrint(String featureName) {");
		sc.add("int printedValues = featureToPrintedIndicesMap.get(featureName).size();");
		sc.add("return printedValues;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();

		addPrintMethod(sc);
		addDoPrintMethod(sc, syntax.getAllRules());
		addPrintInternalMethod(sc);
		addGetDecoratorTreeMethod(sc);
		addDecorateTreeMethod(sc);
		addDecorateTreeBasicMethod(sc);
		addFindElementWithCorrectTypeMethod(sc);
		addDoesPrintFeatureMethod(sc);
		addPrintTreeMethod(sc);
		addPrintKeywordMethod(sc);
		addPrintFeatureMethod(sc);
		addPrintAttributeMethod(sc);
		addPrintBooleanTerminalMethod(sc);
		addPrintEnumerationTerminalMethod(sc);
		addPrintContainedObjectMethod(sc);
		addPrintFormattingElementsMethod(sc);
		addSetTabsBeforeCurrentObjectMethod(sc);
		addPrintReferenceMethod(sc);
		addInitializePrintCountingMapMethod(sc);
		addGetOptionsMethod(sc);
		addSetOptionsMethod(sc);
		addGetEncoding(sc);
		addSetEncoding(sc);
		addGetResourceMethod(sc);
		addGetReferenceResolverSwitchMethod(sc);
		addAddWarningToResourceMethod(sc);
		generatorUtil.addGetLayoutInformationAdapterMethod(sc, layoutInformationAdapterClassName);
		addGetLayoutInformationMethod(sc);
		addGetCopyOfLayoutInformationMethod(sc);
		addGetHiddenTokenTextMethod(sc);
		addGetVisibleTokenTextMethod(sc);
		addGetWhiteSpaceStringMethod(sc);
		addGetRepeatingStringMethod(sc);
		addSetAutomaticTokenSpaceHandlingMethod(sc);
		addSetTokenSpaceMethod(sc);
		addPrintBasicMethod(sc);
		addPrintSmartMethod(sc);
		addIsSameMethod(sc);
		addGetAllowedTypesMethod(sc);
		addCreateSpaceTokenMethod(sc);
		addCreateTabTokenMethod(sc);
		addCreateNewLineTokenMethod(sc);
	}

	private void addCreateSpaceTokenMethod(JavaComposite sc) {
		sc.add("protected PrintToken createSpaceToken(" + E_OBJECT + " container) {");
		sc.add("return new PrintToken(\" \", null, container);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateTabTokenMethod(JavaComposite sc) {
		sc.add("protected PrintToken createTabToken(" + E_OBJECT + " container) {");
		sc.add("return new PrintToken(\"\\t\", null, container);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateNewLineTokenMethod(JavaComposite sc) {
		sc.add("protected PrintToken createNewLineToken(" + E_OBJECT + " container) {");
		sc.add("return new PrintToken(NEW_LINE, null, container);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAllowedTypesMethod(JavaComposite sc) {
		sc.add("protected " + LIST + "<Class<?>> getAllowedTypes(" + terminalClassName + " terminal) {");
		sc.add(LIST + "<Class<?>> allowedTypes = new " + ARRAY_LIST + "<Class<?>>();");
		sc.add("allowedTypes.add(terminal.getFeature().getEType().getInstanceClass());");
			
		sc.add("if (terminal instanceof " + containmentClassName + ") {");
		sc.add(containmentClassName + " printingContainment = (" + containmentClassName + ") terminal;");
		sc.add(E_CLASS + "[] typeRestrictions = printingContainment.getAllowedTypes();");
		sc.add("if (typeRestrictions != null && typeRestrictions.length > 0) {");
		sc.add("allowedTypes.clear();");
		sc.add("for (" + E_CLASS + " eClass : typeRestrictions) {");
		sc.add("allowedTypes.add(eClass.getInstanceClass());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return allowedTypes;");
		sc.add("}");
		sc.addLineBreak();
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

	private void addGetLayoutInformationMethod(JavaComposite sc) {
		sc.add("private " + layoutInformationClassName + " getLayoutInformation(" + LIST + "<" + layoutInformationClassName + "> layoutInformations, " + syntaxElementClassName + " syntaxElement, Object object, " + E_OBJECT + " container) {");
		sc.add("for (" + layoutInformationClassName + " layoutInformation : layoutInformations) {");
		sc.add("if (syntaxElement == layoutInformation.getSyntaxElement()) {");
		sc.add("if (object == null) {");
		sc.add("return layoutInformation;");
		sc.add("}");
		sc.addComment(
			"The layout information adapter must only try to resolve the object " +
			"it refers to, if we compare with a non-proxy object. If we're printing " +
			"a resource that contains proxy objects, resolving must not be triggered."
		);
		sc.add("boolean isNoProxy = true;");
		sc.add("if (object instanceof " + E_OBJECT + ") {");
		sc.add(E_OBJECT + " eObject = (" + E_OBJECT + ") object;");
		sc.add("isNoProxy = !eObject.eIsProxy();");
		sc.add("}");
		sc.add("if (isSame(object, layoutInformation.getObject(container, isNoProxy))) {");
		sc.add("return layoutInformation;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSameMethod(StringComposite sc) {
		sc.add("private boolean isSame(Object o1, Object o2) {");
		sc.add("if (o1 instanceof String || o1 instanceof Integer || o1 instanceof Long || o1 instanceof Byte || o1 instanceof Short || o1 instanceof Float || o2 instanceof Double) {");
		sc.add("return o1.equals(o2);");
		sc.add("}");
		sc.add("return o1 == o2;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHiddenTokenTextMethod(StringComposite sc) {
		sc.add("private String getHiddenTokenText(" + layoutInformationClassName + " layoutInformation) {");
		sc.add("if (layoutInformation != null) {");
		sc.add("return layoutInformation.getHiddenTokenText();");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVisibleTokenTextMethod(StringComposite sc) {
		sc.add("private String getVisibleTokenText(" + layoutInformationClassName + " layoutInformation) {");
		sc.add("if (layoutInformation != null) {");
		sc.add("return layoutInformation.getVisibleTokenText();");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoPrintMethod(StringComposite sc, List<Rule> rules) {
		sc.add("protected void doPrint(" + E_OBJECT + " element, " + LIST + "<" + formattingElementClassName +"> foundFormattingElements) {");
		sc.add("if (element == null) {");
		sc.add("throw new " + ILLEGAL_ARGUMENT_EXCEPTION + "(\"Nothing to write.\");");
		sc.add("}");
		sc.add("if (outputStream == null) {");
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
				sc.add("printInternal(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(rule) + ", foundFormattingElements);");
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
		
		sc.add("public final static String NEW_LINE = java.lang.System.getProperties().getProperty(\"line.separator\");");
		sc.addLineBreak();
		
		sc.add("private final " + eClassUtilClassName + " eClassUtil = new " + eClassUtilClassName + "();");
		sc.addLineBreak();
		
		// TODO we should probably wrap all these members in a context class
		sc.addJavadoc("Holds the resource that is associated with this printer. May be null if the printer is used stand alone.");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.addLineBreak();
		
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + OUTPUT_STREAM + " outputStream;");
		sc.add("private String encoding = System.getProperty(\"file.encoding\");");
		sc.add("protected " + LIST + "<PrintToken> tokenOutputStream;");
		sc.add("private " + iTokenResolverFactoryClassName + " tokenResolverFactory = new " + tokenResolverFactoryClassName + "();");
		sc.add("private boolean handleTokenSpaceAutomatically = " + handleTokenSpaceAutomatically + ";");
		sc.add("private int tokenSpace = " + getTokenSpace() + ";");
		sc.addJavadoc(
			"A flag that indicates whether tokens have already been printed for " +
			"some object. The flag is set to false whenever printing of " +
			"an EObject tree is started. The status of the flag " +
			"is used to avoid printing default token space in front of the root object."
		);
		sc.add("private boolean startedPrintingObject = false;");
		sc.addJavadoc(
			"The number of tab characters that were printed before the current line. " +
			"This number is used to calculate the relative indentation when printing " +
			"contained objects, because all contained objects must start with this " +
			"indentation (tabsBeforeCurrentObject + currentTabs)."
		);
		sc.add("private int currentTabs;");
		sc.addJavadoc(
			"The number of tab characters that must be printed before the current object. " +
			"This number is used to calculate the indentation of new lines, when line breaks " +
			"are printed within one object."
		);
		sc.add("private int tabsBeforeCurrentObject;");
		sc.addJavadoc(
			"This flag is used to indicate whether the number of tabs before the current " +
			"object has been set for the current object. The flag is needed, because setting " +
			"the number of tabs must be performed when the first token of the contained element " +
			"is printed."
		);
		sc.add("private boolean startedPrintingContainedObject;");
		sc.addLineBreak();
	}

	private void addPrintInternalMethod(JavaComposite sc) {
		sc.add("public void printInternal(" + E_OBJECT + " eObject, " + syntaxElementClassName + " ruleElement, " + LIST + "<" + formattingElementClassName +"> foundFormattingElements) {");
		sc.add(LIST + "<" + layoutInformationClassName + "> layoutInformations = getCopyOfLayoutInformation(eObject);");
		sc.add(syntaxElementDecoratorClassName + " decoratorTree = getDecoratorTree(ruleElement);");
		sc.add("decorateTree(decoratorTree, eObject);");
		sc.add("printTree(decoratorTree, eObject, foundFormattingElements, layoutInformations);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCopyOfLayoutInformationMethod(JavaComposite sc) {
		sc.add("public " + LIST + "<" + layoutInformationClassName + "> getCopyOfLayoutInformation(" + E_OBJECT + " eObject) {");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(eObject);");
		sc.add(LIST + "<" + layoutInformationClassName + "> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();");
		sc.addComment(
			"create a copy of the original list of layout information object in order " +
			"to be able to remove used informations during printing"
		);
		sc.add(LIST + "<" + layoutInformationClassName + "> layoutInformations = new " + ARRAY_LIST + "<" + layoutInformationClassName+ ">(originalLayoutInformations.size());");
		sc.add("layoutInformations.addAll(originalLayoutInformations);");
		sc.add("return layoutInformations;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDecorateTreeMethod(JavaComposite sc) {
		sc.add("public void decorateTree(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject) {");
		sc.add("PrintCountingMap printCountingMap = initializePrintCountingMap(eObject);");
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
			"Tries to decorate the decorator with an attribute value, or reference held by the given EObject. " +
			"Returns true if an attribute value or reference was found."
		);
		sc.add("public boolean decorateTreeBasic(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject, PrintCountingMap printCountingMap, " + LIST + "<" + syntaxElementDecoratorClassName +"> keywordsToPrint) {");
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
		sc.add("if (feature == " + grammarInformationProviderClassName + ".ANONYMOUS_FEATURE) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("String featureName = feature.getName();");
		sc.add("int countLeft = printCountingMap.getCountLeft(terminal);");
		// TODO mseifert: this condition should be modified to include a check whether
		// the current syntax element (or the subtree that contains it) is mandatory.
		// currently the decorator is only decorated if there is enough values left to
		// fill the mandatory occurrences after this element. But, if the current 
		// element is mandatory too, we should use a value for decoration even though
		// there might not be enough values left for the subsequent elements. it is better 
		// to fill the first mandatory elements rather then the later ones.
		//
		// In any case this situation should only occur if models have not been created
		// from text, but stem from some other source. Probably it would be good to
		// emit some kind of warning if we're facing this situation. The question is
		// where is the most reasonable place to put such warnings.
		sc.add("if (countLeft > terminal.getMandatoryOccurencesAfter()) {");
		sc.addComment("normally we print the element at the next index");
		sc.add("int indexToPrint = printCountingMap.getNextIndexToPrint(featureName);");
		sc.addComment(
			"But, if there are type restrictions for containments, we must choose an " +
			"index of an element that fits (i.e., which has the correct type)"
		);
		sc.add("if (terminal instanceof " + containmentClassName + ") {");
		sc.add(containmentClassName + " containment = (" + containmentClassName + ") terminal;");
		sc.add("indexToPrint = findElementWithCorrectType(eObject, feature, printCountingMap.getIndicesToPrint(featureName), containment);");
		sc.add("}");
		sc.add("if (indexToPrint >= 0) {");
		sc.add("decorator.addIndexToPrint(indexToPrint);");
		sc.add("printCountingMap.addIndexToPrint(featureName, indexToPrint);");
		sc.add("keepDecorating = true;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("if (syntaxElement instanceof " + choiceClassName + ") {");
		sc.addComment("for choices we do print only the choice which does print at least one feature");
		sc.add(syntaxElementDecoratorClassName + " childToPrint = null;");
		sc.add("for (" + syntaxElementDecoratorClassName + " childDecorator : decorator.getChildDecorators()) {");
		sc.addComment("pick first choice as default, will be overridden if a choice that prints a feature is found");
		sc.add("if (childToPrint == null) {");
		sc.add("childToPrint = childDecorator;");
		sc.add("}");
		sc.add("if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {");
		sc.add("childToPrint = childDecorator;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("keepDecorating |= decorateTreeBasic(childToPrint, eObject, printCountingMap, subKeywordsToPrint);");
		sc.add("} else {");
		sc.addComment("for all other syntax element we do print all children");
		sc.add("for (" + syntaxElementDecoratorClassName + " childDecorator : decorator.getChildDecorators()) {");
		sc.add("keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);");
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

	private void addFindElementWithCorrectTypeMethod(JavaComposite sc) {
		ConcreteSyntax concreteSyntax = getContext().getConcreteSyntax();
		boolean ignoreTypeRestrictions = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING);
		
		sc.add("private int findElementWithCorrectType(" + E_OBJECT + " eObject, " + E_STRUCTURAL_FEATURE + " feature, " + SET + "<Integer> indicesToPrint, " + containmentClassName + " containment) {");
		if (ignoreTypeRestrictions) {
			sc.addComment(
					"Since the '" + OptionTypes.IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING.getLiteral() + "' option is set to true, " +
					"the type restrictions are not considered when printing models.");
			sc.add("boolean ignoreTypeRestrictions = true;");
		} else {
			sc.addComment(
					"By default the type restrictions that are defined in the CS definition are considered when printing models. " +
					"You can change this behavior by setting the '" + OptionTypes.IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING.getLiteral() + "' option to true.");
			sc.add("boolean ignoreTypeRestrictions = false;");
		}
		sc.add(E_CLASS + "[] allowedTypes = containment.getAllowedTypes();");
		sc.add("Object value = eObject.eGet(feature);");
		sc.add("if (value instanceof " + LIST + "<?>) {");
		sc.add(LIST + "<?> valueList = (" + LIST + "<?>) value;");
		sc.add("int listSize = valueList.size();");
		sc.add("for (int index = 0; index < listSize; index++) {");
		sc.add("if (indicesToPrint.contains(index)) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("Object valueAtIndex = valueList.get(index);");
		sc.add("if (eClassUtil.isInstance(valueAtIndex, allowedTypes) || ignoreTypeRestrictions) {");
		sc.add("return index;");
		sc.add("}");
		sc.add("}");
		sc.add("} else {");
		sc.add("if (eClassUtil.isInstance(value, allowedTypes) || ignoreTypeRestrictions) {");
		sc.add("return 0;");
		sc.add("}");
		sc.add("}");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoesPrintFeatureMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Checks whether decorating the given node will use at least one attribute value, or reference held by eObject. " +
			"Returns true if a printable attribute value or reference was found. " +
			"This method is used to decide which choice to pick, when multiple choices are available. " +
			"We pick the choice that prints at least one attribute or reference."
		);
		sc.add("public boolean doesPrintFeature(" + syntaxElementDecoratorClassName + " decorator, " + E_OBJECT + " eObject, PrintCountingMap printCountingMap) {");
		sc.add(syntaxElementClassName + " syntaxElement = decorator.getDecoratedElement();");
		sc.add("if (syntaxElement instanceof " + terminalClassName + ") {");
		sc.add(terminalClassName + " terminal = (" + terminalClassName + ") syntaxElement;");
		sc.add(E_STRUCTURAL_FEATURE + " feature = terminal.getFeature();");
		sc.add("if (feature == " + grammarInformationProviderClassName + ".ANONYMOUS_FEATURE) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("int countLeft = printCountingMap.getCountLeft(terminal);");
		sc.add("if (countLeft > terminal.getMandatoryOccurencesAfter()) {");
		sc.addComment("found a feature to print");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + syntaxElementDecoratorClassName + " childDecorator : decorator.getChildDecorators()) {");
		sc.add("if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
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
		sc.add("Integer indexToPrint = decorator.getNextIndexToPrint();");
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
		sc.add("} else if (printElement instanceof " + booleanTerminalClassName + ") {");
		sc.add(booleanTerminalClassName + " booleanTerminal = (" + booleanTerminalClassName + ") printElement;");
		sc.add("printBooleanTerminal(eObject, booleanTerminal, indexToPrint, foundFormattingElements, layoutInformations);");
		sc.add("foundSomethingToPrint = true;");
		sc.add("} else if (printElement instanceof " + enumerationTerminalClassName + ") {");
		sc.add(enumerationTerminalClassName + " enumTerminal = (" + enumerationTerminalClassName + ") printElement;");
		sc.add("printEnumerationTerminal(eObject, enumTerminal, indexToPrint, foundFormattingElements, layoutInformations);");
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
		sc.add(syntaxElementClassName + " decoratedElement = decorator.getDecoratedElement();");
		sc.add("if (foundSomethingToPrint && decoratedElement instanceof " + choiceClassName + ") {");
		sc.add("break;");
		sc.add("}");
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
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public PrintCountingMap initializePrintCountingMap(" + E_OBJECT + " eObject) {");
		sc.addComment(
			"The PrintCountingMap contains a mapping from feature names to " +
			"the number of remaining elements that still need to be printed. " +
			"The map is initialized with the number of elements stored in each structural " +
			"feature. For lists this is the list size. For non-multiple features it is either " +
			"1 (if the feature is set) or 0 (if the feature is null)."
		);
		sc.add("PrintCountingMap printCountingMap = new PrintCountingMap();");
		sc.add(LIST + "<" + E_STRUCTURAL_FEATURE + "> features = eObject.eClass().getEAllStructuralFeatures();");
		sc.add("for (" + E_STRUCTURAL_FEATURE + " feature : features) {");
		sc.addComment(
			"We get the feature value without resolving it, because resolving " +
			"is not required to count the number of elements that are referenced " + 
			"by the feature. Moreover, triggering reference resolving is not desired " +
			"here, because we'd also like to print models that contain unresolved " +
			"references."
		);
		sc.add("Object featureValue = eObject.eGet(feature, false);");
		sc.add("if (featureValue != null) {");
		sc.add("if (featureValue instanceof " + LIST + "<?>) {");
		sc.add("printCountingMap.setFeatureValues(feature.getName(), (" + LIST + "<Object>) featureValue);");
		sc.add("} else {");
		sc.add("printCountingMap.setFeatureValues(feature.getName(), " + COLLECTIONS + ".singletonList(featureValue));");
		sc.add("}");
		sc.add("} else {");
		sc.add("printCountingMap.setFeatureValues(feature.getName(), null);");
		sc.add("}");
		sc.add("}");
		sc.add("return printCountingMap;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintKeywordMethod(StringComposite sc) {
		sc.add("public void printKeyword(" + E_OBJECT + " eObject, " + keywordClassName + " keyword, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(layoutInformationClassName + " keywordLayout = getLayoutInformation(layoutInformations, keyword, null, eObject);");
		sc.add("printFormattingElements(eObject, foundFormattingElements, layoutInformations, keywordLayout);");
		sc.add("String value = keyword.getValue();");
		// TODO using single quotes and escapeToANTLRKeyword() to obtain the token name here is ANTLR specific
		sc.add("tokenOutputStream.add(new PrintToken(value, \"'\" + " + stringUtilClassName + ".escapeToANTLRKeyword(value) + \"'\", eObject));");
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
		sc.add("public void printAttribute(" + E_OBJECT + " eObject, " + E_ATTRIBUTE + " attribute, " + placeholderClassName + " placeholder, int index, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");

		JavaComposite deResolveCode = new JavaComposite();
		deResolveCode.addComment("if no text is available, the attribute is deresolved to obtain its textual representation");
		deResolveCode.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());");
		deResolveCode.add("tokenResolver.setOptions(getOptions());");
		deResolveCode.add("String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);");
		deResolveCode.add("result = deResolvedValue;");

		addPrintAttributeCode(sc, "placeholder", "placeholder.getTokenName()", deResolveCode);
		
		sc.addLineBreak();
	}

	private void addPrintBooleanTerminalMethod(JavaComposite sc) {
		sc.add("public void printBooleanTerminal(" + E_OBJECT + " eObject, " + booleanTerminalClassName + " booleanTerminal, int index, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(E_ATTRIBUTE + " attribute = booleanTerminal.getAttribute();");

		JavaComposite deResolveCode = new JavaComposite();
		deResolveCode.addComment("if no text is available, the boolean attribute is converted to its textual representation using the literals of the boolean terminal");
		deResolveCode.add("if (Boolean.TRUE.equals(attributeValue)) {");
		deResolveCode.add("result = booleanTerminal.getTrueLiteral();");
		deResolveCode.add("} else {");
		deResolveCode.add("result = booleanTerminal.getFalseLiteral();");
		deResolveCode.add("}");
		// TODO using single quotes and escapeToANTLRKeyword() to obtain the token name here is ANTLR specific
		addPrintAttributeCode(sc, "booleanTerminal", "\"'\" + " + stringUtilClassName + ".escapeToANTLRKeyword(result) + \"'\"", deResolveCode);

		sc.addLineBreak();
	}

	private void addPrintEnumerationTerminalMethod(JavaComposite sc) {
		sc.add("public void printEnumerationTerminal(" + E_OBJECT + " eObject, " + enumerationTerminalClassName + " enumTerminal, int index, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(E_ATTRIBUTE + " attribute = enumTerminal.getAttribute();");

		JavaComposite deResolveCode = new JavaComposite();
		deResolveCode.addComment("if no text is available, the enumeration attribute is converted to its textual representation using the literals of the enumeration terminal");
		deResolveCode.add("assert attributeValue instanceof " + ENUMERATOR + ";");
		deResolveCode.add("result = enumTerminal.getText(((" + ENUMERATOR + ") attributeValue).getName());");
		// TODO using single quotes and escapeToANTLRKeyword() to obtain the token name here is ANTLR specific
		addPrintAttributeCode(sc, "enumTerminal", "\"'\" + " + stringUtilClassName + ".escapeToANTLRKeyword(result) + \"'\"", deResolveCode);

		sc.addLineBreak();
	}

	private void addPrintAttributeCode(JavaComposite sc, String terminalParameter, String tokenName, StringComposite deResolveCode) {
		sc.add("String result = null;");
		sc.add("Object attributeValue = " + eObjectUtilClassName + ".getFeatureValue(eObject, attribute, index);");
		sc.add(layoutInformationClassName + " attributeLayout = getLayoutInformation(layoutInformations, " + terminalParameter + ", attributeValue, eObject);");
		//sc.add("for (" + layoutInformationClassName + " attributeLayout : attributeLayouts) {");
		sc.add("String visibleTokenText = getVisibleTokenText(attributeLayout);");
		sc.addComment("if there is text for the attribute we use it");
		sc.add("if (visibleTokenText != null) {");
		sc.add("result = visibleTokenText;");
		//sc.add("break;");
		sc.add("}");
		//sc.add("}");
		sc.addLineBreak();
		sc.add("if (result == null) {");
		sc.add(deResolveCode);
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (result != null && !\"\".equals(result)) {");
		sc.add("printFormattingElements(eObject, foundFormattingElements, layoutInformations, attributeLayout);");
		sc.addComment("write result to the output stream");
		sc.add("tokenOutputStream.add(new PrintToken(result, " + tokenName + ", eObject));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintReferenceMethod(JavaComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public void printReference(" + E_OBJECT + " eObject, " + E_REFERENCE + " reference, " + placeholderClassName + " placeholder, int index, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add("String tokenName = placeholder.getTokenName();");
		sc.add("Object referencedObject = " + eObjectUtilClassName + ".getFeatureValue(eObject, reference, index, false);");
		sc.addComment("first add layout before the reference");
		sc.add(layoutInformationClassName + " referenceLayout = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);");
		sc.add("printFormattingElements(eObject, foundFormattingElements, layoutInformations, referenceLayout);");
		sc.addComment("proxy objects must be printed differently");
		generatorUtil.addCodeToDeresolveProxyObject(sc, iContextDependentUriFragmentClassName, "referencedObject");
		sc.add("if (deresolvedReference == null) {");
		sc.addComment(
			"NC-References must always be printed by deresolving the reference. " +
			"We cannot use the visible token information, because deresolving " +
			"usually depends on attribute values of the referenced object instead of the " +
			"object itself."
		);
		sc.add("@SuppressWarnings(\"rawtypes\")").addLineBreak();
		sc.add(iReferenceResolverClassName + " referenceResolver = getReferenceResolverSwitch().getResolver(reference);");
		sc.add("referenceResolver.setOptions(getOptions());");
		
		sc.add("deresolvedReference = referenceResolver.deResolve((" + E_OBJECT + ") referencedObject, eObject, reference);");
		sc.add("}");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add("String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);");
		sc.addComment("write result to output stream");
		sc.add("tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName, eObject));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintContainedObjectMethod(JavaComposite sc) {
		sc.add("public void printContainedObject(" + E_OBJECT + " eObject, " + containmentClassName + " containment, int index, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations) {");
		sc.add(E_STRUCTURAL_FEATURE + " reference = containment.getFeature();");
		sc.add("Object o = " + eObjectUtilClassName + ".getFeatureValue(eObject, reference, index);");
		sc.addComment(
				"save current number of tabs to restore them after printing the contained object"
		);
		sc.add("int oldTabsBeforeCurrentObject = tabsBeforeCurrentObject;");
		sc.add("int oldCurrentTabs = currentTabs;");
		sc.addComment(
				"use current number of tabs to indent contained object. " +
				"we do not directly set 'tabsBeforeCurrentObject' because the first " +
				"element of the new object must be printed with the old number of tabs.");
		sc.add("startedPrintingContainedObject = false;");
		sc.add("currentTabs = 0;");
		sc.add("doPrint((" + E_OBJECT + ") o, foundFormattingElements);");
		sc.addComment("restore number of tabs after printing the contained object");
		sc.add("tabsBeforeCurrentObject = oldTabsBeforeCurrentObject;");
		sc.add("currentTabs = oldCurrentTabs;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintFormattingElementsMethod(JavaComposite sc) {
		sc.add("public void printFormattingElements(" + E_OBJECT + " eObject, " + LIST + "<" + formattingElementClassName + "> foundFormattingElements, " + LIST + "<" + layoutInformationClassName + "> layoutInformations, " + layoutInformationClassName + " layoutInformation) {");
		// (a) if the element to print is at the correct printing spot (the
		// one it was parsed at, print whitespace collected while parsing
		sc.add("String hiddenTokenText = getHiddenTokenText(layoutInformation);");
		sc.add("if (hiddenTokenText != null) {");
		sc.addComment("removed used information");
		sc.add("if (layoutInformations != null) {");
		sc.add("layoutInformations.remove(layoutInformation);");
		sc.add("}");
		sc.add("tokenOutputStream.add(new PrintToken(hiddenTokenText, null, eObject));");
		sc.add("foundFormattingElements.clear();");
		sc.add("startedPrintingObject = false;");
		sc.add("setTabsBeforeCurrentObject(0);");
		sc.add("return;");
		sc.add("}");
		sc.add("int printedTabs = 0;");
		// (b) if Whitespace or LineBreak elements were found, print those
		sc.add("if (foundFormattingElements.size() > 0) {");
		sc.add("for (" + formattingElementClassName + " foundFormattingElement : foundFormattingElements) {");
		sc.add("if (foundFormattingElement instanceof " + whiteSpaceClassName + ") {");
		sc.add("int amount = ((" + whiteSpaceClassName + ") foundFormattingElement).getAmount();");
		sc.add("for (int i = 0; i < amount; i++) {");
		sc.add("tokenOutputStream.add(createSpaceToken(eObject));");
		sc.add("}");
		sc.add("}");
		sc.add("if (foundFormattingElement instanceof " + lineBreakClassName + ") {");
		sc.add("currentTabs = ((" + lineBreakClassName + ") foundFormattingElement).getTabs();");
		sc.add("printedTabs += currentTabs;");
		sc.add("tokenOutputStream.add(createNewLineToken(eObject));");
		sc.add("for (int i = 0; i < tabsBeforeCurrentObject + currentTabs; i++) {");
		sc.add("tokenOutputStream.add(createTabToken(eObject));");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("foundFormattingElements.clear();");
		sc.add("startedPrintingObject = false;");
		sc.add("} else {");
		// (c) if not, print default token space, but only if automatic token
		//     space handling is disabled
		sc.add("if (startedPrintingObject) {");
		sc.addComment(
			"if no elements have been printed yet, we do not add the default token space, " +
			"because spaces before the first element are not desired.");
		sc.add("startedPrintingObject = false;");
		sc.add("} else {");
		sc.add("if (!handleTokenSpaceAutomatically) {");
		sc.add("tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null, eObject));");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addComment(
				"after printing the first element, we can use the new number of tabs."
		);
		sc.add("setTabsBeforeCurrentObject(printedTabs);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetTabsBeforeCurrentObjectMethod(JavaComposite sc) {
		sc.add("private void setTabsBeforeCurrentObject(int tabs) {");
		sc.add("if (startedPrintingContainedObject) {");
		sc.add("return;");
		sc.add("}");
		sc.add("tabsBeforeCurrentObject = tabsBeforeCurrentObject + tabs;");
		sc.add("startedPrintingContainedObject = true;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addPrintMethod(JavaComposite sc) {
		sc.add("public void print(" + E_OBJECT + " element) throws " + IO_EXCEPTION + " {");
		sc.add("tokenOutputStream = new " + ARRAY_LIST + "<PrintToken>();");
		sc.add("currentTabs = 0;");
		sc.add("tabsBeforeCurrentObject = 0;");
		sc.add("startedPrintingObject = true;");
		sc.add("startedPrintingContainedObject = false;");
		sc.add(LIST + "<" + formattingElementClassName + ">  formattingElements = new " + ARRAY_LIST + "<" + formattingElementClassName + ">();");
		sc.add("doPrint(element, formattingElements);");
		sc.addComment("print all remaining formatting elements");
		sc.add(LIST + "<" + layoutInformationClassName + "> layoutInformations = getCopyOfLayoutInformation(element);");
		sc.add(layoutInformationClassName + " eofLayoutInformation = getLayoutInformation(layoutInformations, null, null, null);");
		sc.add("printFormattingElements(element, formattingElements, layoutInformations, eofLayoutInformation);");
		sc.add(PRINTER_WRITER + " writer = new " + PRINTER_WRITER + "(new " + OUTPUT_STREAM_WRITER + "(new " + BUFFERED_OUTPUT_STREAM + "(outputStream), encoding));");
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
		
		sc.add("char lastCharWritten = ' ';");

		sc.add("for (int i = 0; i < tokenOutputStream.size(); i++) {");
		
		sc.add("PrintToken tokenI = tokenOutputStream.get(i);");
		sc.add("currentBlock.append(tokenI.getText());");
		
		sc.addComment("if declared or preserved whitespace is found - print block");
		sc.add("if (tokenI.getTokenName() == null) {");
		sc.add("char[] charArray = currentBlock.toString().toCharArray();");
		sc.add("writer.write(charArray);");
		sc.add("if (charArray.length > 0) {");
		sc.add("lastCharWritten = charArray[charArray.length - 1];");
		sc.add("}");
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
		sc.add("while (nextToken != null && nextToken.getText() != null) {");
		sc.add("tempTokens.add(nextToken);");
		sc.add("nextToken = scanner.getNextToken();");
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
		// TODO this is a hack to remove the single quotes used by ANTLR for keyword tokens
		sc.add("String printTokenName = printTokenT.getTokenName();");
		sc.add("if (printTokenName.length() > 2 && printTokenName.startsWith(\"'\") && printTokenName.endsWith(\"'\")) {");
		sc.add("printTokenName = printTokenName.substring(1, printTokenName.length() - 1);");
		sc.add("}");
		sc.add("if (!commonTokenName.equals(printTokenName)) {");
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
		sc.add("char[] charArray = validBlock.toString().toCharArray();");
		sc.add("writer.write(charArray);");
		sc.add("if (charArray.length > 0) {");
		sc.add("lastCharWritten = charArray[charArray.length - 1];");
		sc.add("}");
		sc.addComment("print separating whitespace");
		sc.addComment("if no whitespace (or tab or linebreak) is already there");
		// TODO we need some way to specify the string that is used for
		// automatic whitespace handling. probably another code generation
		// option is required.
		//
		// The situation, that we end up here with a whitespace as lastCharWritten may occur 
		// if a reference resolver de-resolves to a non-existing token.
		// This is currently the case in JaMoPP when the option 
		// OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES is turned on.
		sc.add("if (lastCharWritten != ' ' && lastCharWritten != '\\t' && lastCharWritten != '\\n' && lastCharWritten != '\\r') {");
		sc.add("lastCharWritten = ' ';");
		sc.add("writer.write(lastCharWritten);");
		sc.add("}");
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
