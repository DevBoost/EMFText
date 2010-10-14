/**
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany 
 *       - initial API and implementation
 * 
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.*;
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NamedTokenDefinition;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.PartialTokenDefinition;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.RegexComposer;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexOwner;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage
 * @generated
 */
public class ConcretesyntaxSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConcretesyntaxPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcretesyntaxSwitch() {
		if (modelPackage == null) {
			modelPackage = ConcretesyntaxPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT: {
				GenPackageDependentElement genPackageDependentElement = (GenPackageDependentElement)theEObject;
				T result = caseGenPackageDependentElement(genPackageDependentElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.CONCRETE_SYNTAX: {
				ConcreteSyntax concreteSyntax = (ConcreteSyntax)theEObject;
				T result = caseConcreteSyntax(concreteSyntax);
				if (result == null) result = caseGenPackageDependentElement(concreteSyntax);
				if (result == null) result = caseAnnotable(concreteSyntax);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = caseGenPackageDependentElement(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.SYNTAX_ELEMENT: {
				SyntaxElement syntaxElement = (SyntaxElement)theEObject;
				T result = caseSyntaxElement(syntaxElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseAnnotable(rule);
				if (result == null) result = caseSyntaxElement(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = caseSyntaxElement(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = caseSyntaxElement(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.DEFINITION: {
				Definition definition = (Definition)theEObject;
				T result = caseDefinition(definition);
				if (result == null) result = caseSyntaxElement(definition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.CARDINALITY_DEFINITION: {
				CardinalityDefinition cardinalityDefinition = (CardinalityDefinition)theEObject;
				T result = caseCardinalityDefinition(cardinalityDefinition);
				if (result == null) result = caseDefinition(cardinalityDefinition);
				if (result == null) result = caseSyntaxElement(cardinalityDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.TERMINAL: {
				Terminal terminal = (Terminal)theEObject;
				T result = caseTerminal(terminal);
				if (result == null) result = caseCardinalityDefinition(terminal);
				if (result == null) result = caseDefinition(terminal);
				if (result == null) result = caseSyntaxElement(terminal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.CS_STRING: {
				CsString csString = (CsString)theEObject;
				T result = caseCsString(csString);
				if (result == null) result = caseDefinition(csString);
				if (result == null) result = caseSyntaxElement(csString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.WHITE_SPACES: {
				WhiteSpaces whiteSpaces = (WhiteSpaces)theEObject;
				T result = caseWhiteSpaces(whiteSpaces);
				if (result == null) result = caseDefinition(whiteSpaces);
				if (result == null) result = caseSyntaxElement(whiteSpaces);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.LINE_BREAK: {
				LineBreak lineBreak = (LineBreak)theEObject;
				T result = caseLineBreak(lineBreak);
				if (result == null) result = caseDefinition(lineBreak);
				if (result == null) result = caseSyntaxElement(lineBreak);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.CARDINALITY: {
				Cardinality cardinality = (Cardinality)theEObject;
				T result = caseCardinality(cardinality);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.PLUS: {
				PLUS plus = (PLUS)theEObject;
				T result = casePLUS(plus);
				if (result == null) result = caseCardinality(plus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.STAR: {
				STAR star = (STAR)theEObject;
				T result = caseSTAR(star);
				if (result == null) result = caseCardinality(star);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.QUESTIONMARK: {
				QUESTIONMARK questionmark = (QUESTIONMARK)theEObject;
				T result = caseQUESTIONMARK(questionmark);
				if (result == null) result = caseCardinality(questionmark);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.COMPOUND_DEFINITION: {
				CompoundDefinition compoundDefinition = (CompoundDefinition)theEObject;
				T result = caseCompoundDefinition(compoundDefinition);
				if (result == null) result = caseCardinalityDefinition(compoundDefinition);
				if (result == null) result = caseDefinition(compoundDefinition);
				if (result == null) result = caseSyntaxElement(compoundDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.REGEX_COMPOSER: {
				RegexComposer regexComposer = (RegexComposer)theEObject;
				T result = caseRegexComposer(regexComposer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.REGEX_OWNER: {
				RegexOwner regexOwner = (RegexOwner)theEObject;
				T result = caseRegexOwner(regexOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.REGEX_PART: {
				RegexPart regexPart = (RegexPart)theEObject;
				T result = caseRegexPart(regexPart);
				if (result == null) result = caseRegexOwner(regexPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.REGEX_COMPOSITE: {
				RegexComposite regexComposite = (RegexComposite)theEObject;
				T result = caseRegexComposite(regexComposite);
				if (result == null) result = caseRegexOwner(regexComposite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ATOMIC_REGEX: {
				AtomicRegex atomicRegex = (AtomicRegex)theEObject;
				T result = caseAtomicRegex(atomicRegex);
				if (result == null) result = caseRegexPart(atomicRegex);
				if (result == null) result = caseRegexOwner(atomicRegex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.REGEX_REFERENCE: {
				RegexReference regexReference = (RegexReference)theEObject;
				T result = caseRegexReference(regexReference);
				if (result == null) result = caseRegexPart(regexReference);
				if (result == null) result = caseRegexOwner(regexReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.TOKEN_DIRECTIVE: {
				TokenDirective tokenDirective = (TokenDirective)theEObject;
				T result = caseTokenDirective(tokenDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ABSTRACT_TOKEN_DEFINITION: {
				AbstractTokenDefinition abstractTokenDefinition = (AbstractTokenDefinition)theEObject;
				T result = caseAbstractTokenDefinition(abstractTokenDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.NAMED_TOKEN_DEFINITION: {
				NamedTokenDefinition namedTokenDefinition = (NamedTokenDefinition)theEObject;
				T result = caseNamedTokenDefinition(namedTokenDefinition);
				if (result == null) result = caseAbstractTokenDefinition(namedTokenDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.REFERENCABLE_TOKEN_DEFINITION: {
				ReferencableTokenDefinition referencableTokenDefinition = (ReferencableTokenDefinition)theEObject;
				T result = caseReferencableTokenDefinition(referencableTokenDefinition);
				if (result == null) result = caseNamedTokenDefinition(referencableTokenDefinition);
				if (result == null) result = caseRegexOwner(referencableTokenDefinition);
				if (result == null) result = caseAbstractTokenDefinition(referencableTokenDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION: {
				PartialTokenDefinition partialTokenDefinition = (PartialTokenDefinition)theEObject;
				T result = casePartialTokenDefinition(partialTokenDefinition);
				if (result == null) result = caseNamedTokenDefinition(partialTokenDefinition);
				if (result == null) result = caseTokenDirective(partialTokenDefinition);
				if (result == null) result = caseRegexComposite(partialTokenDefinition);
				if (result == null) result = caseAbstractTokenDefinition(partialTokenDefinition);
				if (result == null) result = caseRegexOwner(partialTokenDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION: {
				CompleteTokenDefinition completeTokenDefinition = (CompleteTokenDefinition)theEObject;
				T result = caseCompleteTokenDefinition(completeTokenDefinition);
				if (result == null) result = caseTokenDirective(completeTokenDefinition);
				if (result == null) result = caseReferencableTokenDefinition(completeTokenDefinition);
				if (result == null) result = caseRegexOwner(completeTokenDefinition);
				if (result == null) result = caseNamedTokenDefinition(completeTokenDefinition);
				if (result == null) result = caseAbstractTokenDefinition(completeTokenDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION: {
				NormalTokenDefinition normalTokenDefinition = (NormalTokenDefinition)theEObject;
				T result = caseNormalTokenDefinition(normalTokenDefinition);
				if (result == null) result = caseCompleteTokenDefinition(normalTokenDefinition);
				if (result == null) result = caseAnnotable(normalTokenDefinition);
				if (result == null) result = caseRegexComposite(normalTokenDefinition);
				if (result == null) result = caseTokenDirective(normalTokenDefinition);
				if (result == null) result = caseReferencableTokenDefinition(normalTokenDefinition);
				if (result == null) result = caseRegexOwner(normalTokenDefinition);
				if (result == null) result = caseNamedTokenDefinition(normalTokenDefinition);
				if (result == null) result = caseAbstractTokenDefinition(normalTokenDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.TOKEN_REDEFINITION: {
				TokenRedefinition tokenRedefinition = (TokenRedefinition)theEObject;
				T result = caseTokenRedefinition(tokenRedefinition);
				if (result == null) result = caseAnnotable(tokenRedefinition);
				if (result == null) result = caseRegexComposite(tokenRedefinition);
				if (result == null) result = caseCompleteTokenDefinition(tokenRedefinition);
				if (result == null) result = caseTokenDirective(tokenRedefinition);
				if (result == null) result = caseReferencableTokenDefinition(tokenRedefinition);
				if (result == null) result = caseRegexOwner(tokenRedefinition);
				if (result == null) result = caseNamedTokenDefinition(tokenRedefinition);
				if (result == null) result = caseAbstractTokenDefinition(tokenRedefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION: {
				QuotedTokenDefinition quotedTokenDefinition = (QuotedTokenDefinition)theEObject;
				T result = caseQuotedTokenDefinition(quotedTokenDefinition);
				if (result == null) result = caseCompleteTokenDefinition(quotedTokenDefinition);
				if (result == null) result = caseTokenDirective(quotedTokenDefinition);
				if (result == null) result = caseReferencableTokenDefinition(quotedTokenDefinition);
				if (result == null) result = caseRegexOwner(quotedTokenDefinition);
				if (result == null) result = caseNamedTokenDefinition(quotedTokenDefinition);
				if (result == null) result = caseAbstractTokenDefinition(quotedTokenDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE: {
				TokenPriorityDirective tokenPriorityDirective = (TokenPriorityDirective)theEObject;
				T result = caseTokenPriorityDirective(tokenPriorityDirective);
				if (result == null) result = caseTokenDirective(tokenPriorityDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.CONTAINMENT: {
				Containment containment = (Containment)theEObject;
				T result = caseContainment(containment);
				if (result == null) result = caseTerminal(containment);
				if (result == null) result = caseCardinalityDefinition(containment);
				if (result == null) result = caseDefinition(containment);
				if (result == null) result = caseSyntaxElement(containment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.PLACEHOLDER: {
				Placeholder placeholder = (Placeholder)theEObject;
				T result = casePlaceholder(placeholder);
				if (result == null) result = caseTerminal(placeholder);
				if (result == null) result = caseCardinalityDefinition(placeholder);
				if (result == null) result = caseDefinition(placeholder);
				if (result == null) result = caseSyntaxElement(placeholder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN: {
				PlaceholderUsingSpecifiedToken placeholderUsingSpecifiedToken = (PlaceholderUsingSpecifiedToken)theEObject;
				T result = casePlaceholderUsingSpecifiedToken(placeholderUsingSpecifiedToken);
				if (result == null) result = casePlaceholder(placeholderUsingSpecifiedToken);
				if (result == null) result = caseTerminal(placeholderUsingSpecifiedToken);
				if (result == null) result = caseCardinalityDefinition(placeholderUsingSpecifiedToken);
				if (result == null) result = caseDefinition(placeholderUsingSpecifiedToken);
				if (result == null) result = caseSyntaxElement(placeholderUsingSpecifiedToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN: {
				PlaceholderUsingDefaultToken placeholderUsingDefaultToken = (PlaceholderUsingDefaultToken)theEObject;
				T result = casePlaceholderUsingDefaultToken(placeholderUsingDefaultToken);
				if (result == null) result = casePlaceholder(placeholderUsingDefaultToken);
				if (result == null) result = caseTerminal(placeholderUsingDefaultToken);
				if (result == null) result = caseCardinalityDefinition(placeholderUsingDefaultToken);
				if (result == null) result = caseDefinition(placeholderUsingDefaultToken);
				if (result == null) result = caseSyntaxElement(placeholderUsingDefaultToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES: {
				PlaceholderInQuotes placeholderInQuotes = (PlaceholderInQuotes)theEObject;
				T result = casePlaceholderInQuotes(placeholderInQuotes);
				if (result == null) result = casePlaceholder(placeholderInQuotes);
				if (result == null) result = caseTerminal(placeholderInQuotes);
				if (result == null) result = caseCardinalityDefinition(placeholderInQuotes);
				if (result == null) result = caseDefinition(placeholderInQuotes);
				if (result == null) result = caseSyntaxElement(placeholderInQuotes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL: {
				BooleanTerminal booleanTerminal = (BooleanTerminal)theEObject;
				T result = caseBooleanTerminal(booleanTerminal);
				if (result == null) result = caseTerminal(booleanTerminal);
				if (result == null) result = caseCardinalityDefinition(booleanTerminal);
				if (result == null) result = caseDefinition(booleanTerminal);
				if (result == null) result = caseSyntaxElement(booleanTerminal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ENUM_TERMINAL: {
				EnumTerminal enumTerminal = (EnumTerminal)theEObject;
				T result = caseEnumTerminal(enumTerminal);
				if (result == null) result = caseTerminal(enumTerminal);
				if (result == null) result = caseCardinalityDefinition(enumTerminal);
				if (result == null) result = caseDefinition(enumTerminal);
				if (result == null) result = caseSyntaxElement(enumTerminal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL: {
				EnumLiteralTerminal enumLiteralTerminal = (EnumLiteralTerminal)theEObject;
				T result = caseEnumLiteralTerminal(enumLiteralTerminal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.OPTION: {
				Option option = (Option)theEObject;
				T result = caseOption(option);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ABSTRACT: {
				Abstract abstract_ = (Abstract)theEObject;
				T result = caseAbstract(abstract_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.TOKEN_STYLE: {
				TokenStyle tokenStyle = (TokenStyle)theEObject;
				T result = caseTokenStyle(tokenStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ANNOTABLE: {
				Annotable annotable = (Annotable)theEObject;
				T result = caseAnnotable(annotable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.KEY_VALUE_PAIR: {
				KeyValuePair keyValuePair = (KeyValuePair)theEObject;
				T result = caseKeyValuePair(keyValuePair);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.GEN_CLASS_CACHE: {
				GenClassCache genClassCache = (GenClassCache)theEObject;
				T result = caseGenClassCache(genClassCache);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.GEN_CLASS_CACHE_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<GenClass, String> genClassCacheEntry = (Map.Entry<GenClass, String>)theEObject;
				T result = caseGenClassCacheEntry(genClassCacheEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConcretesyntaxPackage.ECLASS_UTIL: {
				EClassUtil eClassUtil = (EClassUtil)theEObject;
				T result = caseEClassUtil(eClassUtil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Package Dependent Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Package Dependent Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenPackageDependentElement(GenPackageDependentElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Syntax</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Syntax</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcreteSyntax(ConcreteSyntax object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Syntax Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Syntax Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSyntaxElement(SyntaxElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinition(Definition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityDefinition(CardinalityDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminal(Terminal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cs String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cs String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCsString(CsString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>White Spaces</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>White Spaces</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhiteSpaces(WhiteSpaces object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Break</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Break</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineBreak(LineBreak object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinality(Cardinality object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PLUS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PLUS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePLUS(PLUS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STAR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STAR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTAR(STAR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QUESTIONMARK</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QUESTIONMARK</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQUESTIONMARK(QUESTIONMARK object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundDefinition(CompoundDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Token Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTokenDirective(TokenDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regex Composer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regex Composer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexComposer(RegexComposer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regex Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regex Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexOwner(RegexOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regex Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regex Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexPart(RegexPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regex Composite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regex Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexComposite(RegexComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Regex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Regex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicRegex(AtomicRegex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regex Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regex Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexReference(RegexReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Token Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTokenDefinition(AbstractTokenDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Token Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedTokenDefinition(NamedTokenDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referencable Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referencable Token Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencableTokenDefinition(ReferencableTokenDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partial Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partial Token Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartialTokenDefinition(PartialTokenDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Token Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteTokenDefinition(CompleteTokenDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Normal Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Normal Token Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNormalTokenDefinition(NormalTokenDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Token Redefinition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token Redefinition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTokenRedefinition(TokenRedefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quoted Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quoted Token Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuotedTokenDefinition(QuotedTokenDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Token Priority Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token Priority Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTokenPriorityDirective(TokenPriorityDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainment(Containment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholder(Placeholder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder Using Specified Token</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder Using Specified Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholderUsingSpecifiedToken(PlaceholderUsingSpecifiedToken object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder Using Default Token</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder Using Default Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholderUsingDefaultToken(PlaceholderUsingDefaultToken object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder In Quotes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder In Quotes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholderInQuotes(PlaceholderInQuotes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanTerminal(BooleanTerminal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumTerminal(EnumTerminal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralTerminal(EnumLiteralTerminal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOption(Option object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstract(Abstract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Token Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTokenStyle(TokenStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotable(Annotable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Value Pair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyValuePair(KeyValuePair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Class Cache</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Class Cache</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenClassCache(GenClassCache object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gen Class Cache Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gen Class Cache Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenClassCacheEntry(Map.Entry<GenClass, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClass Util</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClass Util</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEClassUtil(EClassUtil object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ConcretesyntaxSwitch
