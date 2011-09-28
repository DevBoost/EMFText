/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAYS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASSIFIER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ENUM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ENUM_LITERAL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ADAPTER_FACTORY_LABEL_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIGeneratorUtil;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class CodeCompletionHelperGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	/**
	 * This is a temporary flag which can be used to enable the
	 * generation of debug output. This flag must be removed once
	 * all code completion issues have been resolved.
	 */
	public static final boolean INSERT_DEBUG_OUTPUT_CODE = false;

	private final UIGeneratorUtil generatorUtil = new UIGeneratorUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A CodeCompletionHelper can be used to derive completion proposals for partial " +
			"documents. It runs the parser generated by EMFText in a special mode (i.e., the " +
			"rememberExpectedElements mode). Based on the elements that are expected by the " +
			"parser for different regions in the document, valid proposals are computed."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + attributeValueProviderClassName + " attributeValueProvider = new " + attributeValueProviderClassName + "();");
		sc.addLineBreak();
		sc.add("private " + iMetaInformationClassName + " metaInformation = new " + metaInformationClassName + "();");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addComputeCompletionProposalsMethod(sc);
		addParseToExpectedElementsMethod(sc);
		addRemoveDuplicateEntriesMethod(sc);
		addRemoveInvalidEntriesAtEndMethod(sc);
		addShouldRemoveMethod(sc);
		addRemoveKeywordsEndingBeforeIndexMethod(sc);
		addFindPrefixMethod(sc);
		addDeriveProposalsMethod1(sc);
		addDeriveProposalsMethod2(sc);
		addHandleEnumAttributeMethod(sc);
		addHandleNCReferenceMethod(sc);
		addHandleAttributeMethod(sc);
		addHandleKeywordMethod(sc);
		addHandleBooleanTerminalMethod(sc);
		addHandleEnumerationTerminalMethod(sc);
		addHandleLiteralMethod(sc);
		addSetPrefixesMethod(sc);
		addGetExpectedElementsAtMethod(sc);
		addGetEndMethod(sc);
		addMatchesMethod(sc);
		addGetImageMethod(sc);
		addFindCorrectContainerMethod(sc);
	}

	private void addRemoveKeywordsEndingBeforeIndexMethod(JavaComposite sc) {
		sc.addJavadoc("Removes all proposals for keywords that end before the given index.");
		sc.add("private void removeKeywordsEndingBeforeIndex(" + COLLECTION + "<" + completionProposalClassName + "> proposals, int index) {");
		sc.add(sc.declareArrayList("toRemove", completionProposalClassName));
		sc.add("for (" + completionProposalClassName + " proposal : proposals) {");
		sc.add(expectedTerminalClassName + " expectedTerminal = proposal.getExpectedTerminal();");
		sc.add(iExpectedElementClassName + " terminal = expectedTerminal.getTerminal();");
		sc.add("if (terminal instanceof " + expectedCsStringClassName + ") {");
		sc.add(expectedCsStringClassName + " csString = (" + expectedCsStringClassName + ") terminal;");
		sc.add("int startExcludingHiddenTokens = expectedTerminal.getStartExcludingHiddenTokens();");
		sc.add("if (startExcludingHiddenTokens + csString.getValue().length() - 1 < index) {");
		sc.add("toRemove.add(proposal);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("proposals.removeAll(toRemove);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetImageMethod(StringComposite sc) {
		// TODO attach images for keywords and attributes
		sc.add("private " + IMAGE + " getImage(" + E_OBJECT + " element) {");
		sc.add("if (!" + PLATFORM + ".isRunning()) {");
		sc.add("return null;");
		sc.add("}");
		generatorUtil.addCreateAdapterFactoryCode(sc);
		sc.add(ADAPTER_FACTORY_LABEL_PROVIDER + " labelProvider = new " + ADAPTER_FACTORY_LABEL_PROVIDER + "(adapterFactory);");
		sc.add("return labelProvider.getImage(element);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEndMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Calculates the end index of the expected element at allExpectedElements[index]. " +
			"To determine the end, the subsequent expected elements from the array of all " +
			"expected elements are used. An element is considered to end one character " +
			"before the next elements starts."
		);
		sc.add("private int getEnd(" + expectedTerminalClassName + "[] allExpectedElements, int indexInList) {");
		sc.add(expectedTerminalClassName + " elementAtIndex = allExpectedElements[indexInList];");
		sc.add("int startIncludingHidden = elementAtIndex.getStartIncludingHiddenTokens();");
		sc.add("int startExcludingHidden = elementAtIndex.getStartExcludingHiddenTokens();");
		sc.add("for (int i = indexInList + 1; i < allExpectedElements.length; i++) {");
		sc.add(expectedTerminalClassName + " elementAtI = allExpectedElements[i];");
		sc.add("int startIncludingHiddenForI = elementAtI.getStartIncludingHiddenTokens();");
		sc.add("int startExcludingHiddenForI = elementAtI.getStartExcludingHiddenTokens();");
		sc.add("if (startIncludingHidden != startIncludingHiddenForI || startExcludingHidden != startExcludingHiddenForI) {");
		sc.add("return startIncludingHiddenForI - 1;");
		sc.add("}");
		sc.add("}");
		sc.add("return Integer.MAX_VALUE;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetPrefixesMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Calculates the prefix for each given expected element. " +
			"The prefix depends on the current document content, the cursor position, and " +
			"the position where the element is expected."
		);
		sc.add("private void setPrefixes(" + LIST + "<" + expectedTerminalClassName + "> expectedElements, String content, int cursorOffset) {");
		sc.add("if (cursorOffset < 0) {");
		sc.add("return;");
		sc.add("}");
		sc.add("for (" + expectedTerminalClassName + " expectedElement : expectedElements) {");
		sc.add("String prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);");
		sc.add("expectedElement.setPrefix(prefix);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleKeywordMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a set of completion proposals from the given keyword."
		);
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleKeyword(" + expectedTerminalClassName + " expectedTerminal, " + expectedCsStringClassName + " csString, String prefix) {");
		sc.add("String proposal = csString.getValue();");
		sc.add("boolean matchesPrefix = matches(proposal, prefix);");
		sc.add("return " + COLLECTIONS + ".singleton(new " + completionProposalClassName + "(expectedTerminal, proposal, prefix, matchesPrefix, null, null));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleBooleanTerminalMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a set of (two) completion proposals from the given boolean terminal."
		);
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleBooleanTerminal(" + expectedTerminalClassName + " expectedTerminal, " + expectedBooleanTerminalClassName + " expectedBooleanTerminal, String prefix) {");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> result = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">(2);");
		sc.add(booleanTerminalClassName + " booleanTerminal = expectedBooleanTerminal.getBooleanTerminal();");
		sc.add("result.addAll(handleLiteral(expectedTerminal, booleanTerminal.getAttribute(), prefix, booleanTerminal.getTrueLiteral()));");
		sc.add("result.addAll(handleLiteral(expectedTerminal, booleanTerminal.getAttribute(), prefix, booleanTerminal.getFalseLiteral()));");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleLiteralMethod(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleLiteral(" + expectedTerminalClassName + " expectedTerminal, " + E_ATTRIBUTE + " attribute, String prefix, String literal) {");
		sc.add("if (\"\".equals(literal)) {");
		sc.add("return " + COLLECTIONS + ".emptySet();");
		sc.add("}");
		sc.add("boolean matchesPrefix = matches(literal, prefix);");
		sc.add("return " + COLLECTIONS + ".singleton(new " + completionProposalClassName + "(expectedTerminal, literal, prefix, matchesPrefix, null, null));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleEnumerationTerminalMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a set of completion proposals from the given enumeration terminal. " +
			"For each enumeration literal one proposal is created."
		);
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleEnumerationTerminal(" + expectedTerminalClassName + " expectedTerminal, " + expectedEnumerationTerminalClassName + " expectedEnumerationTerminal, String prefix) {");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> result = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">(2);");
		sc.add(enumerationTerminalClassName + " enumerationTerminal = expectedEnumerationTerminal.getEnumerationTerminal();");
		sc.add(MAP + "<String, String> literalMapping = enumerationTerminal.getLiteralMapping();");
		sc.add("for (String literalName : literalMapping.keySet()) {");
		sc.add("result.addAll(handleLiteral(expectedTerminal, enumerationTerminal.getAttribute(), prefix, literalMapping.get(literalName)));");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Checks whether the given proposed string matches the prefix. " +
			"The two strings are compared ignoring the case. The prefix is " +
			"also considered to match if is a camel case representation of " +
			"the proposal."
		);
		sc.add("private boolean matches(String proposal, String prefix) {");
		sc.add("if (proposal == null || prefix == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return (proposal.toLowerCase().startsWith(prefix.toLowerCase()) || " + stringUtilClassName + ".matchCamelCase(prefix, proposal) != null) && !proposal.equals(prefix);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleEnumAttributeMethod(JavaComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleEnumAttribute(" + expectedTerminalClassName + " expectedTerminal, " + expectedStructuralFeatureClassName + " expectedFeature, " + E_ENUM + " enumType, String prefix, " + E_OBJECT + " container) {");
		sc.add(COLLECTION + "<" + E_ENUM_LITERAL + "> enumLiterals = enumType.getELiterals();");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> result = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("for (" + E_ENUM_LITERAL + " literal : enumLiterals) {");
		sc.add("String unResolvedLiteral = literal.getLiteral();");
		sc.addComment("use token resolver to get de-resolved value of the literal");
		sc.add(iTokenResolverFactoryClassName + " tokenResolverFactory = metaInformation.getTokenResolverFactory();");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(expectedFeature.getTokenName());");
		sc.add("String resolvedLiteral = tokenResolver.deResolve(unResolvedLiteral, expectedFeature.getFeature(), container);");
		sc.add("boolean matchesPrefix = matches(resolvedLiteral, prefix);");
		sc.add("result.add(new " + completionProposalClassName + "(expectedTerminal, resolvedLiteral, prefix, matchesPrefix, expectedFeature.getFeature(), container));");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleAttributeMethod(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleAttribute(" + expectedTerminalClassName + " expectedTerminal, " + expectedStructuralFeatureClassName + " expectedFeature, " + E_OBJECT + " container, " + E_ATTRIBUTE + " attribute, String prefix) {");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> resultSet = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("Object[] defaultValues = attributeValueProvider.getDefaultValues(attribute);");
		sc.add("if (defaultValues != null) {");
		sc.add("for (Object defaultValue : defaultValues) {");
		sc.add("if (defaultValue != null) {");
		sc.add(iTokenResolverFactoryClassName + " tokenResolverFactory = metaInformation.getTokenResolverFactory();");
		sc.add("String tokenName = expectedFeature.getTokenName();");
		sc.add("if (tokenName != null) {");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("if (tokenResolver != null) {");
		sc.add("String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);");
		sc.add("boolean matchesPrefix = matches(defaultValueAsString, prefix);");
		sc.add("resultSet.add(new " + completionProposalClassName + "(expectedTerminal, defaultValueAsString, prefix, matchesPrefix, expectedFeature.getFeature(), container));");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return resultSet;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleNCReferenceMethod(JavaComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleNCReference(" + expectedTerminalClassName + " expectedTerminal, " + E_OBJECT + " container, " + E_REFERENCE + " reference, String prefix, String tokenName) {");
		sc.addComment(
			"proposals for non-containment references are derived by calling the " + 
			"reference resolver switch in fuzzy mode."
		);
		sc.add(iReferenceResolverSwitchClassName + " resolverSwitch = metaInformation.getReferenceResolverSwitch();");
		sc.add(iTokenResolverFactoryClassName + " tokenResolverFactory = metaInformation.getTokenResolverFactory();");
		sc.add(iReferenceResolveResultClassName + "<" + E_OBJECT + "> result = new " + referenceResolveResultClassName + "<" + E_OBJECT + ">(true);");
		sc.add("resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);");
		sc.add(COLLECTION + "<" + iReferenceMappingClassName + "<" + E_OBJECT + ">> mappings = result.getMappings();");
		sc.add("if (mappings != null) {");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> resultSet = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("for (" + iReferenceMappingClassName + "<" + E_OBJECT + "> mapping : mappings) {");
		sc.add(IMAGE + " image = null;");
		sc.add("if (mapping instanceof " + elementMappingClassName + "<?>) {");
		sc.add(elementMappingClassName + "<?> elementMapping = (" + elementMappingClassName + "<?>) mapping;");
		sc.add("Object target = elementMapping.getTargetElement();");
		sc.addComment("de-resolve reference to obtain correct identifier");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("final String identifier = tokenResolver.deResolve(elementMapping.getIdentifier(), reference, container);");
		sc.add("if (target instanceof " + E_OBJECT + ") {");
		sc.add("image = getImage((" + E_OBJECT + ") target);");
		sc.add("}");
		sc.add("boolean matchesPrefix = matches(identifier, prefix);");
		sc.add("resultSet.add(new " + completionProposalClassName + "(expectedTerminal, identifier, prefix, matchesPrefix, reference, container, image));");
		sc.add("}");
		sc.add("}");
		sc.add("return resultSet;");
		sc.add("}");
		sc.add("return " + COLLECTIONS + ".emptyList();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindCorrectContainerMethod(JavaComposite sc) {
		sc.add("private " + E_OBJECT + " findCorrectContainer(" + expectedTerminalClassName + " expectedTerminal) {");
		sc.add(E_OBJECT + " container = expectedTerminal.getContainer();");
		sc.add(E_CLASS + " ruleMetaclass = expectedTerminal.getTerminal().getRuleMetaclass();");
		sc.add("if (ruleMetaclass.isInstance(container)) {");
		sc.addComment("container is correct for expectedTerminal");
		sc.add("return container;");
		sc.add("}");
		sc.addComment("the container is wrong");
		sc.add("boolean attachedArtificialContainer = false;");
		sc.add(E_OBJECT + " parent = null;");
		sc.add(E_OBJECT + " previousParent = null;");
		sc.add(E_OBJECT + " correctContainer = container;");
		sc.add(containedFeatureClassName + " currentLink = null;");
		sc.add(containedFeatureClassName + " previousLink = null;");
		sc.add(containedFeatureClassName + "[] containmentTrace = expectedTerminal.getContainmentTrace();");
		sc.add("for (int i = 0; i < containmentTrace.length; i++) {");
		sc.add("currentLink = containmentTrace[i];");
		sc.add("if (i > 0) {");
		sc.add("previousLink = containmentTrace[i - 1];");
		sc.add("}");
		sc.add("if (attachedArtificialContainer) {");
		sc.add("break;");
		sc.add("}");
		sc.add(E_CLASS + " containerClass = currentLink.getContainerClass();");
		sc.add("if (containerClass.equals(container.eClass())) {");
		sc.addComment("we found the correct parent");
		sc.add("parent = container;");
		sc.add("break;");
		sc.add("} else {");
		sc.add("previousParent = parent;");
		sc.add("parent = containerClass.getEPackage().getEFactoryInstance().create(containerClass);");
		sc.add("if (previousParent == null) {");
		sc.addComment("Replacing container for expectedTerminal with correctContainer");
		sc.add("correctContainer = parent;");
		sc.add("} else {");
		sc.add(eObjectUtilClassName + ".setFeature(parent, previousLink.getFeature(), previousParent, false);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		/*
		sc.add("if (previousParent != null) {");
		sc.add(eObjectUtilClassName + ".setFeature(parent, previousLink.getFeature(), previousParent, false);");
		sc.add("}");
		*/
		sc.addLineBreak();
		sc.add("final " + E_OBJECT + " finalContainer = container;");
		sc.add("final " + E_STRUCTURAL_FEATURE + " finalFeature = currentLink.getFeature();");
		sc.add("final " + E_OBJECT + " finalParent = parent;");
		sc.add("if (parent != null) {");
		sc.add("expectedTerminal.setAttachmentCode(new Runnable() {");
		sc.addLineBreak();
		sc.add("public void run() {");
		sc.add(eObjectUtilClassName + ".setFeature(finalContainer, finalFeature, finalParent, false);");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.add("return correctContainer;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addDeriveProposalsMethod2(JavaComposite sc) {
		// TODO mseifert: remove parameter 'resource'?
		// TODO mseifert: all method that are called by this method and that
		// take a parameter 'expectedTerminal' do not need the parameter 'prefix'
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> deriveProposals(" + expectedTerminalClassName + " expectedTerminal, String content, " + iTextResourceClassName + " resource, int cursorOffset) {");
		//sc.add(iLocationMapClassName + " locationMap = resource.getLocationMap();");
		sc.add(iExpectedElementClassName + " expectedElement = (" + iExpectedElementClassName + ") expectedTerminal.getTerminal();");
		sc.add("if (expectedElement instanceof " + expectedCsStringClassName + ") {");
		sc.add(expectedCsStringClassName + " csString = (" + expectedCsStringClassName + ") expectedElement;");
		sc.add("return handleKeyword(expectedTerminal, csString, expectedTerminal.getPrefix());");
		sc.add("} else if (expectedElement instanceof " + expectedBooleanTerminalClassName + ") {");
		sc.add(expectedBooleanTerminalClassName + " expectedBooleanTerminal = (" + expectedBooleanTerminalClassName + ") expectedElement;");
		sc.add("return handleBooleanTerminal(expectedTerminal, expectedBooleanTerminal, expectedTerminal.getPrefix());");
		sc.add("} else if (expectedElement instanceof " + expectedEnumerationTerminalClassName + ") {");
		sc.add(expectedEnumerationTerminalClassName + " expectedEnumerationTerminal = (" + expectedEnumerationTerminalClassName + ") expectedElement;");
		sc.add("return handleEnumerationTerminal(expectedTerminal, expectedEnumerationTerminal, expectedTerminal.getPrefix());");
		sc.add("} else if (expectedElement instanceof " + expectedStructuralFeatureClassName + ") {");
		sc.add(expectedStructuralFeatureClassName + " expectedFeature = (" + expectedStructuralFeatureClassName + ") expectedElement;");
		sc.add(E_STRUCTURAL_FEATURE + " feature = expectedFeature.getFeature();");
		sc.add(E_CLASSIFIER + " featureType = feature.getEType();");
		//sc.add(LIST + "<" + E_OBJECT + "> elementsAtCursor = locationMap.getElementsAt(cursorOffset);");
		sc.add(E_OBJECT + " container = findCorrectContainer(expectedTerminal);");
		/*
		sc.addComment("we need to skip the proxy elements at the cursor, because they are not the container for the reference we try to complete");
		sc.add("for (int i = 0; i < elementsAtCursor.size(); i++) {");
		sc.add("container = elementsAtCursor.get(i);");
		sc.add("if (!container.eIsProxy()) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		
		sc.addComment(
			"if no container can be found, the cursor is probably at the " +
			"end of the document. we need to create artificial containers."
		);
		sc.add("if (container == null) {");
		sc.add("boolean attachedArtificialContainer = false;");
		sc.add(E_CLASS + " containerClass = expectedTerminal.getTerminal().getRuleMetaclass();");
		sc.add(containedFeatureClassName + "[] containmentTrace = expectedTerminal.getContainmentTrace();");
		sc.add(LIST + "<" + E_OBJECT + "> contentList = null;");
		sc.add("for (" + containedFeatureClassName + " link : containmentTrace) {");
		sc.add("if (attachedArtificialContainer) {");
		sc.add("break;");
		sc.add("}");
		sc.add(E_CLASS + " neededClass = eStructuralFeature.getEContainingClass();");
		sc.addComment("fill the content list during the first iteration of the loop");
		sc.add("if (contentList == null) {");
		sc.add("contentList = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.add(ITERATOR + "<" + E_OBJECT + "> allContents = resource.getAllContents();");
		sc.add("while (allContents.hasNext()) {");
		sc.add(E_OBJECT + " next = allContents.next();");
		sc.add("contentList.add(next);");
		sc.add("}");
		sc.add("}");
		sc.addComment("find object to attach artificial container to");
		sc.add("for (int i = contentList.size() - 1; i >= 0; i--) {");
		sc.add(E_OBJECT + " object = contentList.get(i);");
		sc.add("if (neededClass.isInstance(object)) {");
		if (INSERT_DEBUG_OUTPUT_CODE) {
			sc.add("System.out.println(\"Found \" + object);");
		}
		sc.add(E_OBJECT + " newContainer = containerClass.getEPackage().getEFactoryInstance().create(containerClass);");
		sc.add("if (eStructuralFeature.getEType().isInstance(newContainer)) {");
		sc.add(eObjectUtilClassName + ".setFeature(object, eStructuralFeature, newContainer, false);");
		if (INSERT_DEBUG_OUTPUT_CODE) {
			sc.add("System.out.println(\"Attached \" + newContainer);");
		}
		sc.add("container = newContainer;");
		sc.add("attachedArtificialContainer = true;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		*/
		sc.addLineBreak();
		sc.add("if (feature instanceof " + E_REFERENCE + ") {");
		sc.add(E_REFERENCE + " reference = (" + E_REFERENCE + ") feature;");
		sc.add("if (featureType instanceof " + E_CLASS + ") {");
		sc.add("if (reference.isContainment()) {");
		sc.addComment("the FOLLOW set should contain only non-containment references");
		sc.add("assert false;");
		sc.add("} else {");
		sc.add("return handleNCReference(expectedTerminal, container, reference, expectedTerminal.getPrefix(), expectedFeature.getTokenName());");
		sc.add("}");
		sc.add("}");
		sc.add("} else if (feature instanceof " + E_ATTRIBUTE + ") {");
		sc.add(E_ATTRIBUTE + " attribute = (" + E_ATTRIBUTE + ") feature;");
		sc.add("if (featureType instanceof " + E_ENUM + ") {");
		sc.add(E_ENUM + " enumType = (" + E_ENUM + ") featureType;");
		sc.add("return handleEnumAttribute(expectedTerminal, expectedFeature, enumType, expectedTerminal.getPrefix(), container);");
		sc.add("} else {");
		sc.addComment(
			"handle EAttributes (derive default value depending on " +
			"the type of the attribute, figure out token resolver, and " + 
			"call deResolve())"
		);
		sc.add("return handleAttribute(expectedTerminal, expectedFeature, container, attribute, expectedTerminal.getPrefix());");
		sc.add("}");
		sc.add("} else {");
		sc.addComment("there should be no other subclass of EStructuralFeature");
		sc.add("assert false;");
		sc.add("}");
		sc.add("} else {");
		sc.addComment("there should be no other class implementing IExpectedElement");
		sc.add("assert false;");
		sc.add("}");
		sc.add("return " + COLLECTIONS + ".emptyList();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeriveProposalsMethod1(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> deriveProposals(" + LIST + "<" + expectedTerminalClassName + "> expectedElements, String content, " + iTextResourceClassName + " resource, int cursorOffset) {");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> resultSet = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("for (" + expectedTerminalClassName + " expectedElement : expectedElements) {");
		sc.add("resultSet.addAll(deriveProposals(expectedElement, content, resource, cursorOffset));");
		sc.add("}");
		sc.add("return resultSet;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindPrefixMethod(StringComposite sc) {
		sc.add("private String findPrefix(" + LIST + "<" + expectedTerminalClassName + "> expectedElements, " + expectedTerminalClassName + " expectedAtCursor, String content, int cursorOffset) {");
		sc.add("if (cursorOffset < 0) {");
		sc.add("return \"\";");
		sc.add("}");
		sc.add("int end = 0;");
		sc.add("for (" + expectedTerminalClassName + " expectedElement : expectedElements) {");
		sc.add("if (expectedElement == expectedAtCursor) {");
		sc.add("final int start = expectedElement.getStartExcludingHiddenTokens();");
		sc.add("if (start >= 0  && start < Integer.MAX_VALUE) {");
		sc.add("end = start;");
		sc.add("}");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("end = Math.min(end, cursorOffset);");
		sc.add("final String prefix = content.substring(end, Math.min(content.length(), cursorOffset));");
		if (INSERT_DEBUG_OUTPUT_CODE) {
			sc.add("System.out.println(\"Found prefix '\" + prefix + \"'\");");
		}
		sc.add("return prefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveInvalidEntriesAtEndMethod(StringComposite sc) {
		sc.add("private void removeInvalidEntriesAtEnd(" + LIST + "<" + expectedTerminalClassName + "> expectedElements) {");
		sc.add("for (int i = 0; i < expectedElements.size() - 1;) {");
		sc.add(expectedTerminalClassName + " elementAtIndex = expectedElements.get(i);");
		sc.add(expectedTerminalClassName + " elementAtNext = expectedElements.get(i + 1);");
		sc.add("if (elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens() && shouldRemove(elementAtIndex.getFollowSetID(), elementAtNext.getFollowSetID())) {");
		sc.add("expectedElements.remove(i + 1);");
		sc.add("} else {");
		sc.add("i++;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveDuplicateEntriesMethod(StringComposite sc) {
		sc.add("private void removeDuplicateEntries(" + LIST + "<" + expectedTerminalClassName + "> expectedElements) {");
		sc.add("for (int i = 0; i < expectedElements.size() - 1; i++) {");
		sc.add(expectedTerminalClassName + " elementAtIndex = expectedElements.get(i);");
		sc.add("for (int j = i + 1; j < expectedElements.size();) {");
		sc.add(expectedTerminalClassName + " elementAtNext = expectedElements.get(j);");
		sc.add("if (elementAtIndex.equals(elementAtNext) && elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens()) {");
		sc.add("expectedElements.remove(j);");
		sc.add("} else {");
		sc.add("j++;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addShouldRemoveMethod(StringComposite sc) {
		sc.add("private boolean shouldRemove(int followSetID1, int followSetID2) {");
		sc.add("return followSetID1 != followSetID2;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addComputeCompletionProposalsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Computes a set of proposals for the given document assuming the cursor is " +
			"at 'cursorOffset'. The proposals are derived using the meta information, i.e., " +
			"the generated language plug-in.",
			"@param originalResource",
			"@param content the documents content",
			"@param cursorOffset",
			"@return"
		);
		
		sc.add("public " + completionProposalClassName + "[] computeCompletionProposals(" + iTextResourceClassName + " originalResource, String content, int cursorOffset) {");
		sc.add(RESOURCE_SET + " resourceSet = new " + RESOURCE_SET_IMPL + "();");
		sc.addComment("the shadow resource needs the same URI because reference resolvers may use the URI to resolve external references");
		sc.add(iTextResourceClassName + " resource = (" + iTextResourceClassName + ") resourceSet.createResource(originalResource.getURI());");
		sc.add(BYTE_ARRAY_INPUT_STREAM + " inputStream = new " + BYTE_ARRAY_INPUT_STREAM + "(content.getBytes());");
		sc.add(iMetaInformationClassName + " metaInformation = resource.getMetaInformation();");
		sc.add(iTextParserClassName + " parser = metaInformation.createParser(inputStream, null);");
		sc.add(expectedTerminalClassName + "[] expectedElements = parseToExpectedElements(parser, resource, cursorOffset);");
		sc.add("if (expectedElements == null) {");
		sc.add("return new " + completionProposalClassName + "[0];");
		sc.add("}");
		sc.add("if (expectedElements.length == 0) {");
		sc.add("return new " + completionProposalClassName + "[0];");
		sc.add("}");

		sc.add(LIST + "<" + expectedTerminalClassName + "> expectedAfterCursor = " + ARRAYS + ".asList(getElementsExpectedAt(expectedElements, cursorOffset));");
		sc.add(LIST + "<" + expectedTerminalClassName + "> expectedBeforeCursor = " + ARRAYS + ".asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));");
		if (INSERT_DEBUG_OUTPUT_CODE) {
			sc.add("System.out.println(\"parseToCursor(\" + cursorOffset + \") BEFORE CURSOR \" + expectedBeforeCursor);");
			sc.add("System.out.println(\"parseToCursor(\" + cursorOffset + \") AFTER CURSOR  \" + expectedAfterCursor);");
		}
		
		sc.add("setPrefixes(expectedAfterCursor, content, cursorOffset);");
		sc.add("setPrefixes(expectedBeforeCursor, content, cursorOffset);");

		sc.addComment("First, we derive all possible proposals from the set of elements that are expected at the cursor position.");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> allProposals = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset - 1);");
		sc.add("removeKeywordsEndingBeforeIndex(leftProposals, cursorOffset);");
		sc.addComment(
			"Second, the set of left proposals (i.e., the ones before the cursor) is " +
			"checked for emptiness. If the set is empty, the right proposals (i.e., " +
			"the ones after the cursor) are also considered. If the set is not empty, " + 
			"the right proposal are discarded, because it does not make sense to " +
			"propose them until the element before the cursor was completed."
		);
		sc.add("allProposals.addAll(leftProposals);");
		sc.add("if (leftProposals.isEmpty()) {");
		sc.add("allProposals.addAll(rightProposals);");
		sc.add("}");
		sc.addComment(
			"Third, the proposals are sorted according to their relevance. " +
			"Proposals that matched the prefix are preferred over ones that did not. " +
			"Finally, proposals are sorted alphabetically."
		);
		sc.add("final " + LIST + "<" + completionProposalClassName + "> sortedProposals = new " + ARRAY_LIST + "<" + completionProposalClassName + ">(allProposals);");
		sc.add(COLLECTIONS + ".sort(sortedProposals);");

		sc.add(E_OBJECT + " root = null;");
		sc.add("if (!resource.getContents().isEmpty()) {");
		sc.add("root = resource.getContents().get(0);");
		sc.add("}");
		sc.add("for (" + completionProposalClassName + " proposal : sortedProposals) {");
		sc.add("proposal.setRoot(root);");
		sc.add("}");
		
		sc.add("return sortedProposals.toArray(new " + completionProposalClassName + "[sortedProposals.size()]);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(StringComposite sc) {
		sc.add("public " + expectedTerminalClassName + "[] parseToExpectedElements(" + iTextParserClassName + " parser, " + iTextResourceClassName + " resource, int cursorOffset) {");
		sc.add("final " + LIST + "<" + expectedTerminalClassName + "> expectedElements = parser.parseToExpectedElements(null, resource, cursorOffset);");
		sc.add("if (expectedElements == null) {");
		sc.add("return new " + expectedTerminalClassName + "[0];");
		sc.add("}");
		sc.add("removeDuplicateEntries(expectedElements);");
		sc.add("removeInvalidEntriesAtEnd(expectedElements);");
		sc.add("return expectedElements.toArray(new " + expectedTerminalClassName + "[expectedElements.size()]);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExpectedElementsAtMethod(StringComposite sc) {
		sc.add("public " + expectedTerminalClassName + "[] getElementsExpectedAt(" + expectedTerminalClassName + "[] allExpectedElements, int cursorOffset) {");
		sc.add(LIST + "<" + expectedTerminalClassName + "> expectedAtCursor = new " + ARRAY_LIST + "<" + expectedTerminalClassName + ">();");
		sc.add("for (int i = 0; i < allExpectedElements.length; i++) {");
		sc.add(expectedTerminalClassName + " expectedElement = allExpectedElements[i];");
		sc.add("int startIncludingHidden = expectedElement.getStartIncludingHiddenTokens();");
		sc.add("int end = getEnd(allExpectedElements, i);");
		sc.add("if (cursorOffset >= startIncludingHidden && cursorOffset <= end) {");
		sc.add("expectedAtCursor.add(expectedElement);");
		sc.add("}");
		sc.add("}");
		sc.add("return expectedAtCursor.toArray(new " + expectedTerminalClassName + "[expectedAtCursor.size()]);");
		sc.add("}");
		sc.addLineBreak();
	}
}
