/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.generators.code_completion;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAYS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASSIFIER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ENUM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ENUM_LITERAL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.HASH_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class CodeCompletionHelperGenerator extends JavaBaseGenerator {

	private String iExpectedElementClassName;
	private String iMetaInformationClassName;
	private String iTextParserClassName;
	private String iReferenceResolverSwitchClassName;
	private String iReferenceResolveResultClassName;
	private String iReferenceMappingClassName;
	private String iTokenResolverFactoryClassName;
	private String iTokenResolverClassName;
	private String stringUtilClassName;
	private String expectedCsStringClassName;
	private String expectedStructuralFeatureClassName;
	private String referenceResolveResultClassName;
	private String iTextResourceClassName;
	private String iLocationMapClassName;
	private String expectedTerminalClassName;
	private String completionProposalClassName;

	public CodeCompletionHelperGenerator() {
		super();
	}

	private CodeCompletionHelperGenerator(GenerationContext context) {
		super(context, EArtifact.CODE_COMPLETION_HELPER);
		iMetaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
		iTextParserClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_PARSER);
		iReferenceResolverSwitchClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVER_SWITCH);
		iReferenceResolveResultClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVE_RESULT);
		referenceResolveResultClassName = getContext().getQualifiedClassName(EArtifact.REFERENCE_RESOLVE_RESULT);
		iReferenceMappingClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_MAPPING);
		iTokenResolverFactoryClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER_FACTORY);
		iTokenResolverClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER);
		iTextResourceClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
		iLocationMapClassName = getContext().getQualifiedClassName(EArtifact.I_LOCATION_MAP);
		stringUtilClassName = getContext().getQualifiedClassName(EArtifact.STRING_UTIL);
		iExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
		expectedCsStringClassName = getContext().getQualifiedClassName(EArtifact.EXPECTED_CS_STRING);
		expectedStructuralFeatureClassName = getContext().getQualifiedClassName(EArtifact.EXPECTED_STRUCTURAL_FEATURE);
		expectedTerminalClassName = getContext().getQualifiedClassName(EArtifact.EXPECTED_TERMINAL);
		completionProposalClassName = getContext().getQualifiedClassName(EArtifact.COMPLETION_PROPOSAL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new CodeCompletionHelperGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A CodeCompletionHelper can be used to derive completion proposals for partial");
		sc.add("// documents. It runs the parser generated by EMFText in a special mode (i.e., the");
		sc.add("// rememberExpectedElements mode). Based on the elements that are expected by the");
		sc.add("// parser for different regions in the document, valid proposals are computed.");
	
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addComputeCompletionProposalsMethod(sc);
		addParseToExpectedElementsMethod(sc);
		addRemoveDuplicateEntriesMethod(sc);
		addRemoveInvalidEntriesAtEndMethod(sc);
		addShouldRemoveMethod(sc);
		addFindPrefixMethod(sc);
		addDeriveProposalsMethod1(sc);
		addDeriveProposalsMethod2(sc);
		addDeriveProposalsMethod4(sc);
		addHandleNCReferenceMethod(sc);
		addHandleAttributeMethod(sc);
		addGetDefaultValueMethod(sc);
		addDeriveProposalMethod1(sc);
		addSetPrefixesMethod(sc);
		addGetExpectedElementsAtMethod(sc);
		addGetEndMethod(sc);
	}

	private void addGetEndMethod(StringComposite sc) {
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
	}

	private void addSetPrefixesMethod(StringComposite sc) {
		sc.add("// for each given expected elements the prefix is calculated");
		sc.add("// the prefix depends on the current document content, the cursor position, and");
		sc.add("// the position where the element is expected");
		sc.add("private void setPrefixes(" + LIST + "<" + expectedTerminalClassName + "> expectedElements, String content, int cursorOffset) {");
		sc.add("if (cursorOffset < 0) {");
		sc.add("return;");
		sc.add("}");
		sc.add("for (" + expectedTerminalClassName + " expectedElement : expectedElements) {");
		sc.add(STRING + " prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);");
		sc.add("expectedElement.setPrefix(prefix);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeriveProposalMethod1(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> deriveProposal(" + expectedCsStringClassName + " csString, String content, String prefix, int cursorOffset) {");
		sc.add("String proposal = csString.getValue();");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> result = new " + HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("if (proposal.startsWith(prefix) && !proposal.equals(prefix)) {");
		sc.add("result.add(new " + completionProposalClassName + "(proposal, !\"\".equals(prefix), false));");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeriveProposalsMethod4(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> deriveProposals(" + expectedTerminalClassName + " expectedElement, " + E_ENUM + " enumType, String content, int cursorOffset) {");
		sc.add(COLLECTION + "<" + E_ENUM_LITERAL + "> enumLiterals = enumType.getELiterals();");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> result = new " + HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("for (" + E_ENUM_LITERAL + " literal : enumLiterals) {");
		sc.add("String proposal = literal.getLiteral();");
		sc.add("String prefix = expectedElement.getPrefix();");
		sc.add("if (proposal.startsWith(prefix) && !proposal.equals(prefix)) {");
		sc.add("result.add(new " + completionProposalClassName + "(proposal, !\"\".equals(prefix), true));");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDefaultValueMethod(StringComposite sc) {
		sc.add("private " + OBJECT + " getDefaultValue(" + E_ATTRIBUTE + " attribute) {");
		sc.add("String typeName = attribute.getEType().getName();");
		sc.add("if (\"EString\".equals(typeName)) {");
		sc.add("return \"some\" + " + stringUtilClassName + ".capitalize(attribute.getName());");
		sc.add("}");
		// TODO mseifert: add more default values for other types
		sc.add("System.out.println(\"CodeCompletionHelper.getDefaultValue() unknown type \" + typeName);");
		sc.add("return attribute.getDefaultValue();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleAttributeMethod(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleAttribute(" + iMetaInformationClassName + " metaInformation, " + expectedStructuralFeatureClassName + " expectedFeature, " + E_OBJECT + " container, " + E_ATTRIBUTE + " attribute, " + STRING + " prefix) {");
		sc.add(OBJECT + " defaultValue = getDefaultValue(attribute);");
		sc.add("if (defaultValue != null) {");
		sc.add(iTokenResolverFactoryClassName + " tokenResolverFactory = metaInformation.getTokenResolverFactory();");
		sc.add("String tokenName = expectedFeature.getTokenName();");
		sc.add("if (tokenName != null) {");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("if (tokenResolver != null) {");
		sc.add("String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> resultSet = new " + HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("if (defaultValueAsString.startsWith(prefix) && !defaultValueAsString.equals(prefix)) {");
		sc.add("resultSet.add(new " + completionProposalClassName + "(defaultValueAsString, !\"\".equals(prefix), true));");
		sc.add("}");
		sc.add("return resultSet;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return " + COLLECTIONS + ".emptyList();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleNCReferenceMethod(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> handleNCReference(" + iMetaInformationClassName + " metaInformation, " + E_OBJECT + " container, " + E_REFERENCE + " reference, " + STRING + " prefix) {");
		sc.add("// proposals for non-containment references are derived by calling the");
		sc.add("// reference resolver switch in fuzzy mode.");
		sc.add(iReferenceResolverSwitchClassName + " resolverSwitch = metaInformation.getReferenceResolverSwitch();");
		sc.add(iReferenceResolveResultClassName + "<" + E_OBJECT + "> result = new " + referenceResolveResultClassName + "<" + E_OBJECT + ">(true);");
		sc.add("resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);");
		sc.add(COLLECTION + "<" + iReferenceMappingClassName + "<" + E_OBJECT + ">> mappings = result.getMappings();");
		sc.add("if (mappings != null) {");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> resultSet = new " + HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add("for (" + iReferenceMappingClassName + "<" + E_OBJECT + "> mapping : mappings) {");
		sc.add("final String identifier = mapping.getIdentifier();");
		sc.add("// the proposal can be added without checking the prefix because this is");
		sc.add("// performed by the reference resolvers");
		sc.add("resultSet.add(new " + completionProposalClassName + "(identifier, true, true));");
		sc.add("}");
		sc.add("return resultSet;");
		sc.add("}");
		sc.add("return " + COLLECTIONS + ".emptyList();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeriveProposalsMethod2(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> deriveProposals(" + expectedTerminalClassName + " expectedTerminal, String content, " + iTextResourceClassName + " resource, int cursorOffset) {");
		sc.add(iMetaInformationClassName + " metaInformation = resource.getMetaInformation();");
		sc.add(iLocationMapClassName + " locationMap = resource.getLocationMap();");
		sc.add(iExpectedElementClassName + " expectedElement = (" + iExpectedElementClassName + ") expectedTerminal.getTerminal();");
		sc.add("if (expectedElement instanceof " + expectedCsStringClassName + ") {");
		sc.add(expectedCsStringClassName + " csString = (" + expectedCsStringClassName + ") expectedElement;");
		sc.add("return deriveProposal(csString, content, expectedTerminal.getPrefix(), cursorOffset);");
		sc.add("} else if (expectedElement instanceof " + expectedStructuralFeatureClassName + ") {");
		sc.add(expectedStructuralFeatureClassName + " expectedFeature = (" + expectedStructuralFeatureClassName + ") expectedElement;");
		sc.add(E_STRUCTURAL_FEATURE + " feature = expectedFeature.getFeature();");
		sc.add(E_CLASSIFIER + " featureType = feature.getEType();");
		sc.add(LIST + "<" + E_OBJECT + "> elementsAtCursor = locationMap.getElementsAt(cursorOffset);");
		sc.add(E_OBJECT + " container = null;");
		sc.add("// we need to skip the proxy elements at the cursor, because they are not the container for the reference we try to complete");
		sc.add("for (int i = 0; i < elementsAtCursor.size(); i++) {");
		sc.add("container = elementsAtCursor.get(i);");
		sc.add("if (!container.eIsProxy()) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		
		// creating a dummy container is not a solution either, because the container
		// is not part of the resource and not correctly inserted in the object tree
		/*
		sc.add("if (container == null) {");
		sc.add("// if no container was found we create a dummy container");
		sc.add(E_CLASS + " featureClass = feature.getEContainingClass();");
		sc.add("container = featureClass.getEPackage().getEFactoryInstance().create(featureClass);");
		sc.add("}");
		*/
		sc.add("if (feature instanceof " + E_REFERENCE + ") {");
		sc.add(E_REFERENCE + " reference = (" + E_REFERENCE + ") feature;");
		sc.add("if (featureType instanceof " + E_CLASS + ") {");
		sc.add("if (reference.isContainment()) {");
		sc.add("// the FOLLOW set should contain only non-containment references");
		sc.add("assert false;");
		sc.add("} else {");
		sc.add("return handleNCReference(metaInformation, container, reference, expectedTerminal.getPrefix());");
		sc.add("}");
		sc.add("}");
		sc.add("} else if (feature instanceof " + E_ATTRIBUTE + ") {");
		sc.add(E_ATTRIBUTE + " attribute = (" + E_ATTRIBUTE + ") feature;");
		sc.add("if (featureType instanceof " + E_ENUM + ") {");
		sc.add(E_ENUM + " enumType = (" + E_ENUM + ") featureType;");
		sc.add("return deriveProposals(expectedTerminal, enumType, content, cursorOffset);");
		sc.add("} else {");
		sc.add("// handle EAttributes (derive default value depending on");
		sc.add("// the type of the attribute, figure out token resolver, and");
		sc.add("// call deResolve())");
		sc.add("return handleAttribute(metaInformation, expectedFeature, container, attribute, expectedTerminal.getPrefix());");
		sc.add("}");
		sc.add("} else {");
		sc.add("// there should be no other subclass of EStructuralFeature");
		sc.add("assert false;");
		sc.add("}");
		sc.add("} else {");
		sc.add("// there should be no other class implementing IExpectedElement");
		sc.add("assert false;");
		sc.add("}");
		sc.add("return " + COLLECTIONS + ".emptyList();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeriveProposalsMethod1(StringComposite sc) {
		sc.add("private " + COLLECTION + "<" + completionProposalClassName + "> deriveProposals(" + LIST + "<" + expectedTerminalClassName + "> expectedElements, String content, " + iTextResourceClassName + " resource, int cursorOffset) {");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> resultSet = new " + HASH_SET + "<" + completionProposalClassName + ">();");
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
		// TODO remove this debug output
		sc.add("System.out.println(\"Found prefix '\" + prefix + \"'\");");
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
		sc.add("public boolean shouldRemove(int followSetID1, int followSetID2) {");
		sc.add("return followSetID1 != followSetID2;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addComputeCompletionProposalsMethod(StringComposite sc) {
		sc.add("// Computes a set of proposals for the given document assuming the cursor is");
		sc.add("// at 'cursorOffset'. The proposals are derived using the meta information, i.e.,");
		sc.add("// the generated language plug-in.");
		sc.add("//");
		sc.add("// @param metaInformation");
		sc.add("// @param content the documents content");
		sc.add("// @param cursorOffset");
		sc.add("// @return");
		
		sc.add("public " + COLLECTION + "<String> computeCompletionProposals(" + iTextResourceClassName + " originalResource, String content, int cursorOffset) {");
		sc.add(RESOURCE_SET + " resourceSet = new " + RESOURCE_SET_IMPL + "();");
		sc.add("// the shadow resource needs the same URI because reference resolvers may use the URI to resolve external references");
		sc.add(iTextResourceClassName + " resource = (" + iTextResourceClassName + ") resourceSet.createResource(originalResource.getURI());");
		sc.add(BYTE_ARRAY_INPUT_STREAM + " inputStream = new " + BYTE_ARRAY_INPUT_STREAM + "(content.getBytes());");
		sc.add(iMetaInformationClassName + " metaInformation = resource.getMetaInformation();");
		sc.add(iTextParserClassName + " parser = metaInformation.createParser(inputStream, null);");
		sc.add(expectedTerminalClassName + "[] expectedElements = parseToExpectedElements(parser, resource);");
		sc.add("if (expectedElements == null) {");
		sc.add("return " + COLLECTIONS + ".emptyList();");
		sc.add("}");
		sc.add("if (expectedElements.length == 0) {");
		sc.add("return " + COLLECTIONS + ".emptyList();");
		sc.add("}");

		sc.add(LIST + "<" + expectedTerminalClassName + "> expectedAfterCursor = " + ARRAYS + ".asList(getElementsExpectedAt(expectedElements, cursorOffset));");
		sc.add(LIST + "<" + expectedTerminalClassName + "> expectedBeforeCursor = " + ARRAYS + ".asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));");
		sc.add("System.out.println(\"parseToCursor(\" + cursorOffset + \") BEFORE CURSOR \" + expectedBeforeCursor);");
		sc.add("System.out.println(\"parseToCursor(\" + cursorOffset + \") AFTER CURSOR  \" + expectedAfterCursor);");
		
		sc.add("setPrefixes(expectedAfterCursor, content, cursorOffset);");
		sc.add("setPrefixes(expectedBeforeCursor, content, cursorOffset);");

		sc.add("// first we derive all possible proposals from the set of elements that are expected at the cursor position");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> allProposals = new " + LINKED_HASH_SET + "<" + completionProposalClassName + ">();");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);");
		sc.add(COLLECTION + "<" + completionProposalClassName + "> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset);");
		sc.add("// second, the set of left proposals (i.e., the ones before the cursor) is");
		sc.add("// checked for emptiness. if the set is empty, the right proposals (i.e., ");
		sc.add("// the ones after the cursor are removed, because it does not make sense to");
		sc.add("// propose them until the element before the cursor was completed");
		sc.add("allProposals.addAll(leftProposals);");
		sc.add("if (leftProposals.isEmpty()) {");
		sc.add("allProposals.addAll(rightProposals);");
		sc.add("}");
		sc.add("// third, the proposals are sorted according to their relevance");
		sc.add("// proposals that matched the prefix are preferred over ones that did not");
		sc.add("// afterward proposals are sorted alphabetically");
		sc.add("final " + LIST + "<" + completionProposalClassName + "> sortedProposals = new " + ARRAY_LIST + "<" + completionProposalClassName + ">(allProposals);");
		sc.add(COLLECTIONS + ".sort(sortedProposals);");
		sc.add("// finally the proposal objects are converted to strings");
		sc.add("final " + LIST + "<" + STRING + "> sortedStrings = new " + ARRAY_LIST + "<" + STRING + ">(sortedProposals.size());");
		sc.add("for (" + completionProposalClassName + " nextProposal : sortedProposals) {");
		sc.add("sortedStrings.add(nextProposal.getInsertString());");
		sc.add("}");
		sc.add("return sortedStrings;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(StringComposite sc) {
		sc.add("public " + expectedTerminalClassName + "[] parseToExpectedElements(" + iTextParserClassName + " parser, " + iTextResourceClassName + " resource) {");
		sc.add("final " + LIST + "<" + expectedTerminalClassName + "> expectedElements = parser.parseToExpectedElements(null, resource);");
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
