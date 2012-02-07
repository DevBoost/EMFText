/**
 * Copyright (c) 2006-2011
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
 */
package org.emftext.sdk.concretesyntax.impl;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.emftext.sdk.concretesyntax.*;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.OperatorAnnotationType;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PartialTokenDefinition;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.concretesyntax.RegexComposer;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConcretesyntaxFactoryImpl extends EFactoryImpl implements ConcretesyntaxFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConcretesyntaxFactory init() {
		try {
			ConcretesyntaxFactory theConcretesyntaxFactory = (ConcretesyntaxFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/sdk/concretesyntax"); 
			if (theConcretesyntaxFactory != null) {
				return theConcretesyntaxFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConcretesyntaxFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcretesyntaxFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX: return createConcreteSyntax();
			case ConcretesyntaxPackage.IMPORT: return createImport();
			case ConcretesyntaxPackage.RULE: return createRule();
			case ConcretesyntaxPackage.CHOICE: return createChoice();
			case ConcretesyntaxPackage.SEQUENCE: return createSequence();
			case ConcretesyntaxPackage.CS_STRING: return createCsString();
			case ConcretesyntaxPackage.WHITE_SPACES: return createWhiteSpaces();
			case ConcretesyntaxPackage.LINE_BREAK: return createLineBreak();
			case ConcretesyntaxPackage.COMPOUND_DEFINITION: return createCompoundDefinition();
			case ConcretesyntaxPackage.REGEX_COMPOSER: return createRegexComposer();
			case ConcretesyntaxPackage.ATOMIC_REGEX: return createAtomicRegex();
			case ConcretesyntaxPackage.REGEX_REFERENCE: return createRegexReference();
			case ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION: return createPartialTokenDefinition();
			case ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION: return createNormalTokenDefinition();
			case ConcretesyntaxPackage.TOKEN_REDEFINITION: return createTokenRedefinition();
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION: return createQuotedTokenDefinition();
			case ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE: return createTokenPriorityDirective();
			case ConcretesyntaxPackage.CONTAINMENT: return createContainment();
			case ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN: return createPlaceholderUsingSpecifiedToken();
			case ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN: return createPlaceholderUsingDefaultToken();
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES: return createPlaceholderInQuotes();
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL: return createBooleanTerminal();
			case ConcretesyntaxPackage.ENUM_TERMINAL: return createEnumTerminal();
			case ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL: return createEnumLiteralTerminal();
			case ConcretesyntaxPackage.OPTION: return createOption();
			case ConcretesyntaxPackage.TOKEN_STYLE: return createTokenStyle();
			case ConcretesyntaxPackage.ANNOTATION: return createAnnotation();
			case ConcretesyntaxPackage.KEY_VALUE_PAIR: return createKeyValuePair();
			case ConcretesyntaxPackage.GEN_CLASS_CACHE: return createGenClassCache();
			case ConcretesyntaxPackage.GEN_CLASS_CACHE_ENTRY: return (EObject)createGenClassCacheEntry();
			case ConcretesyntaxPackage.ECLASS_UTIL: return createEClassUtil();
			case ConcretesyntaxPackage.DEFAULT_TOKEN_STYLE_ADDER: return createDefaultTokenStyleAdder();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ConcretesyntaxPackage.CARDINALITY:
				return createCardinalityFromString(eDataType, initialValue);
			case ConcretesyntaxPackage.OPTION_TYPES:
				return createOptionTypesFromString(eDataType, initialValue);
			case ConcretesyntaxPackage.FONT_STYLE:
				return createFontStyleFromString(eDataType, initialValue);
			case ConcretesyntaxPackage.ANNOTATION_TYPE:
				return createAnnotationTypeFromString(eDataType, initialValue);
			case ConcretesyntaxPackage.OPERATOR_ANNOTATION_TYPE:
				return createOperatorAnnotationTypeFromString(eDataType, initialValue);
			case ConcretesyntaxPackage.OPERATOR_ANNOTATION_PROPERTY:
				return createOperatorAnnotationPropertyFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ConcretesyntaxPackage.CARDINALITY:
				return convertCardinalityToString(eDataType, instanceValue);
			case ConcretesyntaxPackage.OPTION_TYPES:
				return convertOptionTypesToString(eDataType, instanceValue);
			case ConcretesyntaxPackage.FONT_STYLE:
				return convertFontStyleToString(eDataType, instanceValue);
			case ConcretesyntaxPackage.ANNOTATION_TYPE:
				return convertAnnotationTypeToString(eDataType, instanceValue);
			case ConcretesyntaxPackage.OPERATOR_ANNOTATION_TYPE:
				return convertOperatorAnnotationTypeToString(eDataType, instanceValue);
			case ConcretesyntaxPackage.OPERATOR_ANNOTATION_PROPERTY:
				return convertOperatorAnnotationPropertyToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntax createConcreteSyntax() {
		ConcreteSyntaxImpl concreteSyntax = new ConcreteSyntaxImpl();
		return concreteSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsString createCsString() {
		CsStringImpl csString = new CsStringImpl();
		return csString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhiteSpaces createWhiteSpaces() {
		WhiteSpacesImpl whiteSpaces = new WhiteSpacesImpl();
		return whiteSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineBreak createLineBreak() {
		LineBreakImpl lineBreak = new LineBreakImpl();
		return lineBreak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundDefinition createCompoundDefinition() {
		CompoundDefinitionImpl compoundDefinition = new CompoundDefinitionImpl();
		return compoundDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegexComposer createRegexComposer() {
		RegexComposerImpl regexComposer = new RegexComposerImpl();
		return regexComposer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicRegex createAtomicRegex() {
		AtomicRegexImpl atomicRegex = new AtomicRegexImpl();
		return atomicRegex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegexReference createRegexReference() {
		RegexReferenceImpl regexReference = new RegexReferenceImpl();
		return regexReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialTokenDefinition createPartialTokenDefinition() {
		PartialTokenDefinitionImpl partialTokenDefinition = new PartialTokenDefinitionImpl();
		return partialTokenDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NormalTokenDefinition createNormalTokenDefinition() {
		NormalTokenDefinitionImpl normalTokenDefinition = new NormalTokenDefinitionImpl();
		return normalTokenDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenRedefinition createTokenRedefinition() {
		TokenRedefinitionImpl tokenRedefinition = new TokenRedefinitionImpl();
		return tokenRedefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedTokenDefinition createQuotedTokenDefinition() {
		QuotedTokenDefinitionImpl quotedTokenDefinition = new QuotedTokenDefinitionImpl();
		return quotedTokenDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenPriorityDirective createTokenPriorityDirective() {
		TokenPriorityDirectiveImpl tokenPriorityDirective = new TokenPriorityDirectiveImpl();
		return tokenPriorityDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Containment createContainment() {
		ContainmentImpl containment = new ContainmentImpl();
		return containment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlaceholderUsingSpecifiedToken createPlaceholderUsingSpecifiedToken() {
		PlaceholderUsingSpecifiedTokenImpl placeholderUsingSpecifiedToken = new PlaceholderUsingSpecifiedTokenImpl();
		return placeholderUsingSpecifiedToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlaceholderUsingDefaultToken createPlaceholderUsingDefaultToken() {
		PlaceholderUsingDefaultTokenImpl placeholderUsingDefaultToken = new PlaceholderUsingDefaultTokenImpl();
		return placeholderUsingDefaultToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlaceholderInQuotes createPlaceholderInQuotes() {
		PlaceholderInQuotesImpl placeholderInQuotes = new PlaceholderInQuotesImpl();
		return placeholderInQuotes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanTerminal createBooleanTerminal() {
		BooleanTerminalImpl booleanTerminal = new BooleanTerminalImpl();
		return booleanTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumTerminal createEnumTerminal() {
		EnumTerminalImpl enumTerminal = new EnumTerminalImpl();
		return enumTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralTerminal createEnumLiteralTerminal() {
		EnumLiteralTerminalImpl enumLiteralTerminal = new EnumLiteralTerminalImpl();
		return enumLiteralTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Option createOption() {
		OptionImpl option = new OptionImpl();
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenStyle createTokenStyle() {
		TokenStyleImpl tokenStyle = new TokenStyleImpl();
		return tokenStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyValuePair createKeyValuePair() {
		KeyValuePairImpl keyValuePair = new KeyValuePairImpl();
		return keyValuePair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClassCache createGenClassCache() {
		GenClassCacheImpl genClassCache = new GenClassCacheImpl();
		return genClassCache;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<GenClass, String> createGenClassCacheEntry() {
		GenClassCacheEntryImpl genClassCacheEntry = new GenClassCacheEntryImpl();
		return genClassCacheEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassUtil createEClassUtil() {
		EClassUtilImpl eClassUtil = new EClassUtilImpl();
		return eClassUtil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultTokenStyleAdder createDefaultTokenStyleAdder() {
		DefaultTokenStyleAdderImpl defaultTokenStyleAdder = new DefaultTokenStyleAdderImpl();
		return defaultTokenStyleAdder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cardinality createCardinalityFromString(EDataType eDataType, String initialValue) {
		Cardinality result = Cardinality.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCardinalityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionTypes createOptionTypesFromString(EDataType eDataType, String initialValue) {
		OptionTypes result = OptionTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOptionTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontStyle createFontStyleFromString(EDataType eDataType, String initialValue) {
		FontStyle result = FontStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFontStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationType createAnnotationTypeFromString(EDataType eDataType, String initialValue) {
		AnnotationType result = AnnotationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAnnotationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorAnnotationType createOperatorAnnotationTypeFromString(EDataType eDataType, String initialValue) {
		OperatorAnnotationType result = OperatorAnnotationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorAnnotationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorAnnotationProperty createOperatorAnnotationPropertyFromString(EDataType eDataType, String initialValue) {
		OperatorAnnotationProperty result = OperatorAnnotationProperty.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorAnnotationPropertyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcretesyntaxPackage getConcretesyntaxPackage() {
		return (ConcretesyntaxPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConcretesyntaxPackage getPackage() {
		return ConcretesyntaxPackage.eINSTANCE;
	}

} //ConcretesyntaxFactoryImpl
