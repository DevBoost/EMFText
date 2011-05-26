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
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.impl;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NamedTokenDefinition;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.OperatorAnnotationType;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PartialTokenDefinition;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.RegexComposer;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexOwner;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.Rule;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConcretesyntaxPackageImpl extends EPackageImpl implements ConcretesyntaxPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genPackageDependentElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteSyntaxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syntaxElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass csStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whiteSpacesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineBreakEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regexComposerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regexOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regexPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regexCompositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicRegexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regexReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTokenDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedTokenDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencableTokenDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partialTokenDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeTokenDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass normalTokenDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenRedefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedTokenDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenPriorityDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderUsingSpecifiedTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderUsingDefaultTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderInQuotesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTerminalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumTerminalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralTerminalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyValuePairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genClassCacheEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genClassCacheEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassUtilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultTokenStyleAdderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cardinalityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum optionTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fontStyleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum annotationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatorAnnotationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatorAnnotationPropertyEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConcretesyntaxPackageImpl() {
		super(eNS_URI, ConcretesyntaxFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ConcretesyntaxPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConcretesyntaxPackage init() {
		if (isInited) return (ConcretesyntaxPackage)EPackage.Registry.INSTANCE.getEPackage(ConcretesyntaxPackage.eNS_URI);

		// Obtain or create and register package
		ConcretesyntaxPackageImpl theConcretesyntaxPackage = (ConcretesyntaxPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConcretesyntaxPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConcretesyntaxPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theConcretesyntaxPackage.createPackageContents();

		// Initialize created meta-data
		theConcretesyntaxPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConcretesyntaxPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConcretesyntaxPackage.eNS_URI, theConcretesyntaxPackage);
		return theConcretesyntaxPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenPackageDependentElement() {
		return genPackageDependentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenPackageDependentElement_Package() {
		return (EReference)genPackageDependentElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenPackageDependentElement_PackageLocationHint() {
		return (EAttribute)genPackageDependentElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteSyntax() {
		return concreteSyntaxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax_Name() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_StartSymbols() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_ActiveTokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Imports() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Options() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Tokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_SyntheticTokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_TokenStyles() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_AllTokenDirectives() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Rules() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax__operatorRules() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax__operatorRuleSubsets() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax__operatorRulesInitialized() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax__genClassCache() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax__eClassUtil() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax_Abstract() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Prefix() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImport_ConcreteSyntax() {
		return (EReference)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_CsLocationHint() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Metaclass() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Syntax() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyntaxElement() {
		return syntaxElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSyntaxElement_Children() {
		return (EReference)syntaxElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequence() {
		return sequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinition() {
		return definitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityDefinition() {
		return cardinalityDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCardinalityDefinition_Cardinality() {
		return (EAttribute)cardinalityDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminal() {
		return terminalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminal_Feature() {
		return (EReference)terminalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCsString() {
		return csStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCsString_Value() {
		return (EAttribute)csStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhiteSpaces() {
		return whiteSpacesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWhiteSpaces_Amount() {
		return (EAttribute)whiteSpacesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLineBreak() {
		return lineBreakEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineBreak_Tab() {
		return (EAttribute)lineBreakEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCardinality() {
		return cardinalityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundDefinition() {
		return compoundDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTokenDirective() {
		return tokenDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegexComposer() {
		return regexComposerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegexOwner() {
		return regexOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegexOwner_Regex() {
		return (EAttribute)regexOwnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegexPart() {
		return regexPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegexComposite() {
		return regexCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegexComposite_RegexParts() {
		return (EReference)regexCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicRegex() {
		return atomicRegexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtomicRegex_AtomicExpression() {
		return (EAttribute)atomicRegexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegexReference() {
		return regexReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegexReference_Target() {
		return (EReference)regexReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTokenDefinition() {
		return abstractTokenDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedTokenDefinition() {
		return namedTokenDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedTokenDefinition_Name() {
		return (EAttribute)namedTokenDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferencableTokenDefinition() {
		return referencableTokenDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferencableTokenDefinition_AttributeReferences() {
		return (EReference)referencableTokenDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartialTokenDefinition() {
		return partialTokenDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteTokenDefinition() {
		return completeTokenDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteTokenDefinition_AttributeName() {
		return (EAttribute)completeTokenDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNormalTokenDefinition() {
		return normalTokenDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTokenRedefinition() {
		return tokenRedefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTokenRedefinition_RedefinedToken() {
		return (EReference)tokenRedefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuotedTokenDefinition() {
		return quotedTokenDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuotedTokenDefinition_Prefix() {
		return (EAttribute)quotedTokenDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuotedTokenDefinition_Suffix() {
		return (EAttribute)quotedTokenDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuotedTokenDefinition_EscapeCharacter() {
		return (EAttribute)quotedTokenDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuotedTokenDefinition_SynthesizedRegex() {
		return (EAttribute)quotedTokenDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTokenPriorityDirective() {
		return tokenPriorityDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTokenPriorityDirective_Token() {
		return (EReference)tokenPriorityDirectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainment() {
		return containmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainment_Types() {
		return (EReference)containmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaceholder() {
		return placeholderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlaceholder_Token() {
		return (EReference)placeholderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaceholderUsingSpecifiedToken() {
		return placeholderUsingSpecifiedTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaceholderUsingDefaultToken() {
		return placeholderUsingDefaultTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaceholderInQuotes() {
		return placeholderInQuotesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlaceholderInQuotes_Prefix() {
		return (EAttribute)placeholderInQuotesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlaceholderInQuotes_Suffix() {
		return (EAttribute)placeholderInQuotesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlaceholderInQuotes_EscapeCharacter() {
		return (EAttribute)placeholderInQuotesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanTerminal() {
		return booleanTerminalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTerminal_TrueLiteral() {
		return (EAttribute)booleanTerminalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTerminal_FalseLiteral() {
		return (EAttribute)booleanTerminalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumTerminal() {
		return enumTerminalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumTerminal_Literals() {
		return (EReference)enumTerminalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteralTerminal() {
		return enumLiteralTerminalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteralTerminal_Literal() {
		return (EReference)enumLiteralTerminalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralTerminal_Text() {
		return (EAttribute)enumLiteralTerminalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOption() {
		return optionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Type() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOption_Value() {
		return (EAttribute)optionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTokenStyle() {
		return tokenStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTokenStyle_TokenNames() {
		return (EAttribute)tokenStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTokenStyle_Rgb() {
		return (EAttribute)tokenStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTokenStyle_FontStyles() {
		return (EAttribute)tokenStyleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Type() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Parameters() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotable() {
		return annotableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotable_Annotations() {
		return (EReference)annotableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyValuePair() {
		return keyValuePairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyValuePair_Key() {
		return (EAttribute)keyValuePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyValuePair_Value() {
		return (EAttribute)keyValuePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenClassCache() {
		return genClassCacheEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenClassCache__qualifiedInterfaceNameCache() {
		return (EReference)genClassCacheEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenClassCacheEntry() {
		return genClassCacheEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenClassCacheEntry_Key() {
		return (EReference)genClassCacheEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenClassCacheEntry_Value() {
		return (EAttribute)genClassCacheEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassUtil() {
		return eClassUtilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultTokenStyleAdder() {
		return defaultTokenStyleAdderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOptionTypes() {
		return optionTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFontStyle() {
		return fontStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAnnotationType() {
		return annotationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperatorAnnotationType() {
		return operatorAnnotationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperatorAnnotationProperty() {
		return operatorAnnotationPropertyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcretesyntaxFactory getConcretesyntaxFactory() {
		return (ConcretesyntaxFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		genPackageDependentElementEClass = createEClass(GEN_PACKAGE_DEPENDENT_ELEMENT);
		createEReference(genPackageDependentElementEClass, GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE);
		createEAttribute(genPackageDependentElementEClass, GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT);

		concreteSyntaxEClass = createEClass(CONCRETE_SYNTAX);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__NAME);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__START_SYMBOLS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ACTIVE_TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__IMPORTS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__OPTIONS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__SYNTHETIC_TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TOKEN_STYLES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__RULES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULES);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__GEN_CLASS_CACHE);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ECLASS_UTIL);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__ABSTRACT);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__PREFIX);
		createEReference(importEClass, IMPORT__CONCRETE_SYNTAX);
		createEAttribute(importEClass, IMPORT__CS_LOCATION_HINT);

		syntaxElementEClass = createEClass(SYNTAX_ELEMENT);
		createEReference(syntaxElementEClass, SYNTAX_ELEMENT__CHILDREN);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__METACLASS);
		createEReference(ruleEClass, RULE__SYNTAX);

		choiceEClass = createEClass(CHOICE);

		sequenceEClass = createEClass(SEQUENCE);

		definitionEClass = createEClass(DEFINITION);

		cardinalityDefinitionEClass = createEClass(CARDINALITY_DEFINITION);
		createEAttribute(cardinalityDefinitionEClass, CARDINALITY_DEFINITION__CARDINALITY);

		terminalEClass = createEClass(TERMINAL);
		createEReference(terminalEClass, TERMINAL__FEATURE);

		csStringEClass = createEClass(CS_STRING);
		createEAttribute(csStringEClass, CS_STRING__VALUE);

		whiteSpacesEClass = createEClass(WHITE_SPACES);
		createEAttribute(whiteSpacesEClass, WHITE_SPACES__AMOUNT);

		lineBreakEClass = createEClass(LINE_BREAK);
		createEAttribute(lineBreakEClass, LINE_BREAK__TAB);

		compoundDefinitionEClass = createEClass(COMPOUND_DEFINITION);

		regexComposerEClass = createEClass(REGEX_COMPOSER);

		regexOwnerEClass = createEClass(REGEX_OWNER);
		createEAttribute(regexOwnerEClass, REGEX_OWNER__REGEX);

		regexPartEClass = createEClass(REGEX_PART);

		regexCompositeEClass = createEClass(REGEX_COMPOSITE);
		createEReference(regexCompositeEClass, REGEX_COMPOSITE__REGEX_PARTS);

		atomicRegexEClass = createEClass(ATOMIC_REGEX);
		createEAttribute(atomicRegexEClass, ATOMIC_REGEX__ATOMIC_EXPRESSION);

		regexReferenceEClass = createEClass(REGEX_REFERENCE);
		createEReference(regexReferenceEClass, REGEX_REFERENCE__TARGET);

		tokenDirectiveEClass = createEClass(TOKEN_DIRECTIVE);

		abstractTokenDefinitionEClass = createEClass(ABSTRACT_TOKEN_DEFINITION);

		namedTokenDefinitionEClass = createEClass(NAMED_TOKEN_DEFINITION);
		createEAttribute(namedTokenDefinitionEClass, NAMED_TOKEN_DEFINITION__NAME);

		referencableTokenDefinitionEClass = createEClass(REFERENCABLE_TOKEN_DEFINITION);
		createEReference(referencableTokenDefinitionEClass, REFERENCABLE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES);

		partialTokenDefinitionEClass = createEClass(PARTIAL_TOKEN_DEFINITION);

		completeTokenDefinitionEClass = createEClass(COMPLETE_TOKEN_DEFINITION);
		createEAttribute(completeTokenDefinitionEClass, COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME);

		normalTokenDefinitionEClass = createEClass(NORMAL_TOKEN_DEFINITION);

		tokenRedefinitionEClass = createEClass(TOKEN_REDEFINITION);
		createEReference(tokenRedefinitionEClass, TOKEN_REDEFINITION__REDEFINED_TOKEN);

		quotedTokenDefinitionEClass = createEClass(QUOTED_TOKEN_DEFINITION);
		createEAttribute(quotedTokenDefinitionEClass, QUOTED_TOKEN_DEFINITION__PREFIX);
		createEAttribute(quotedTokenDefinitionEClass, QUOTED_TOKEN_DEFINITION__SUFFIX);
		createEAttribute(quotedTokenDefinitionEClass, QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER);
		createEAttribute(quotedTokenDefinitionEClass, QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX);

		tokenPriorityDirectiveEClass = createEClass(TOKEN_PRIORITY_DIRECTIVE);
		createEReference(tokenPriorityDirectiveEClass, TOKEN_PRIORITY_DIRECTIVE__TOKEN);

		containmentEClass = createEClass(CONTAINMENT);
		createEReference(containmentEClass, CONTAINMENT__TYPES);

		placeholderEClass = createEClass(PLACEHOLDER);
		createEReference(placeholderEClass, PLACEHOLDER__TOKEN);

		placeholderUsingSpecifiedTokenEClass = createEClass(PLACEHOLDER_USING_SPECIFIED_TOKEN);

		placeholderUsingDefaultTokenEClass = createEClass(PLACEHOLDER_USING_DEFAULT_TOKEN);

		placeholderInQuotesEClass = createEClass(PLACEHOLDER_IN_QUOTES);
		createEAttribute(placeholderInQuotesEClass, PLACEHOLDER_IN_QUOTES__PREFIX);
		createEAttribute(placeholderInQuotesEClass, PLACEHOLDER_IN_QUOTES__SUFFIX);
		createEAttribute(placeholderInQuotesEClass, PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER);

		booleanTerminalEClass = createEClass(BOOLEAN_TERMINAL);
		createEAttribute(booleanTerminalEClass, BOOLEAN_TERMINAL__TRUE_LITERAL);
		createEAttribute(booleanTerminalEClass, BOOLEAN_TERMINAL__FALSE_LITERAL);

		enumTerminalEClass = createEClass(ENUM_TERMINAL);
		createEReference(enumTerminalEClass, ENUM_TERMINAL__LITERALS);

		enumLiteralTerminalEClass = createEClass(ENUM_LITERAL_TERMINAL);
		createEReference(enumLiteralTerminalEClass, ENUM_LITERAL_TERMINAL__LITERAL);
		createEAttribute(enumLiteralTerminalEClass, ENUM_LITERAL_TERMINAL__TEXT);

		optionEClass = createEClass(OPTION);
		createEAttribute(optionEClass, OPTION__TYPE);
		createEAttribute(optionEClass, OPTION__VALUE);

		tokenStyleEClass = createEClass(TOKEN_STYLE);
		createEAttribute(tokenStyleEClass, TOKEN_STYLE__TOKEN_NAMES);
		createEAttribute(tokenStyleEClass, TOKEN_STYLE__RGB);
		createEAttribute(tokenStyleEClass, TOKEN_STYLE__FONT_STYLES);

		annotationEClass = createEClass(ANNOTATION);
		createEAttribute(annotationEClass, ANNOTATION__TYPE);
		createEReference(annotationEClass, ANNOTATION__PARAMETERS);

		annotableEClass = createEClass(ANNOTABLE);
		createEReference(annotableEClass, ANNOTABLE__ANNOTATIONS);

		keyValuePairEClass = createEClass(KEY_VALUE_PAIR);
		createEAttribute(keyValuePairEClass, KEY_VALUE_PAIR__KEY);
		createEAttribute(keyValuePairEClass, KEY_VALUE_PAIR__VALUE);

		genClassCacheEClass = createEClass(GEN_CLASS_CACHE);
		createEReference(genClassCacheEClass, GEN_CLASS_CACHE__QUALIFIED_INTERFACE_NAME_CACHE);

		genClassCacheEntryEClass = createEClass(GEN_CLASS_CACHE_ENTRY);
		createEReference(genClassCacheEntryEClass, GEN_CLASS_CACHE_ENTRY__KEY);
		createEAttribute(genClassCacheEntryEClass, GEN_CLASS_CACHE_ENTRY__VALUE);

		eClassUtilEClass = createEClass(ECLASS_UTIL);

		defaultTokenStyleAdderEClass = createEClass(DEFAULT_TOKEN_STYLE_ADDER);

		// Create enums
		cardinalityEEnum = createEEnum(CARDINALITY);
		optionTypesEEnum = createEEnum(OPTION_TYPES);
		fontStyleEEnum = createEEnum(FONT_STYLE);
		annotationTypeEEnum = createEEnum(ANNOTATION_TYPE);
		operatorAnnotationTypeEEnum = createEEnum(OPERATOR_ANNOTATION_TYPE);
		operatorAnnotationPropertyEEnum = createEEnum(OPERATOR_ANNOTATION_PROPERTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GenModelPackage theGenModelPackage = (GenModelPackage)EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		concreteSyntaxEClass.getESuperTypes().add(this.getGenPackageDependentElement());
		concreteSyntaxEClass.getESuperTypes().add(this.getAnnotable());
		importEClass.getESuperTypes().add(this.getGenPackageDependentElement());
		ruleEClass.getESuperTypes().add(this.getAnnotable());
		ruleEClass.getESuperTypes().add(this.getSyntaxElement());
		choiceEClass.getESuperTypes().add(this.getSyntaxElement());
		sequenceEClass.getESuperTypes().add(this.getSyntaxElement());
		definitionEClass.getESuperTypes().add(this.getSyntaxElement());
		cardinalityDefinitionEClass.getESuperTypes().add(this.getDefinition());
		terminalEClass.getESuperTypes().add(this.getCardinalityDefinition());
		csStringEClass.getESuperTypes().add(this.getDefinition());
		whiteSpacesEClass.getESuperTypes().add(this.getDefinition());
		lineBreakEClass.getESuperTypes().add(this.getDefinition());
		compoundDefinitionEClass.getESuperTypes().add(this.getCardinalityDefinition());
		regexPartEClass.getESuperTypes().add(this.getRegexOwner());
		regexCompositeEClass.getESuperTypes().add(this.getRegexOwner());
		atomicRegexEClass.getESuperTypes().add(this.getRegexPart());
		regexReferenceEClass.getESuperTypes().add(this.getRegexPart());
		namedTokenDefinitionEClass.getESuperTypes().add(this.getAbstractTokenDefinition());
		referencableTokenDefinitionEClass.getESuperTypes().add(this.getNamedTokenDefinition());
		referencableTokenDefinitionEClass.getESuperTypes().add(this.getRegexOwner());
		partialTokenDefinitionEClass.getESuperTypes().add(this.getNamedTokenDefinition());
		partialTokenDefinitionEClass.getESuperTypes().add(this.getTokenDirective());
		partialTokenDefinitionEClass.getESuperTypes().add(this.getRegexComposite());
		completeTokenDefinitionEClass.getESuperTypes().add(this.getTokenDirective());
		completeTokenDefinitionEClass.getESuperTypes().add(this.getRegexOwner());
		completeTokenDefinitionEClass.getESuperTypes().add(this.getReferencableTokenDefinition());
		normalTokenDefinitionEClass.getESuperTypes().add(this.getCompleteTokenDefinition());
		normalTokenDefinitionEClass.getESuperTypes().add(this.getAnnotable());
		normalTokenDefinitionEClass.getESuperTypes().add(this.getRegexComposite());
		tokenRedefinitionEClass.getESuperTypes().add(this.getAnnotable());
		tokenRedefinitionEClass.getESuperTypes().add(this.getRegexComposite());
		tokenRedefinitionEClass.getESuperTypes().add(this.getCompleteTokenDefinition());
		quotedTokenDefinitionEClass.getESuperTypes().add(this.getCompleteTokenDefinition());
		tokenPriorityDirectiveEClass.getESuperTypes().add(this.getTokenDirective());
		containmentEClass.getESuperTypes().add(this.getTerminal());
		placeholderEClass.getESuperTypes().add(this.getTerminal());
		placeholderUsingSpecifiedTokenEClass.getESuperTypes().add(this.getPlaceholder());
		placeholderUsingDefaultTokenEClass.getESuperTypes().add(this.getPlaceholder());
		placeholderInQuotesEClass.getESuperTypes().add(this.getPlaceholder());
		booleanTerminalEClass.getESuperTypes().add(this.getTerminal());
		enumTerminalEClass.getESuperTypes().add(this.getTerminal());
		enumLiteralTerminalEClass.getESuperTypes().add(this.getSyntaxElement());

		// Initialize classes and features; add operations and parameters
		initEClass(genPackageDependentElementEClass, GenPackageDependentElement.class, "GenPackageDependentElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPackageDependentElement_Package(), theGenModelPackage.getGenPackage(), null, "package", null, 1, 1, GenPackageDependentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenPackageDependentElement_PackageLocationHint(), theEcorePackage.getEString(), "packageLocationHint", null, 0, 1, GenPackageDependentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteSyntaxEClass, ConcreteSyntax.class, "ConcreteSyntax", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcreteSyntax_Name(), ecorePackage.getEString(), "name", null, 1, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_StartSymbols(), theGenModelPackage.getGenClass(), null, "startSymbols", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_ActiveTokens(), this.getCompleteTokenDefinition(), null, "activeTokens", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Imports(), this.getImport(), null, "imports", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Options(), this.getOption(), null, "options", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Tokens(), this.getTokenDirective(), null, "tokens", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_SyntheticTokens(), this.getCompleteTokenDefinition(), null, "syntheticTokens", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_TokenStyles(), this.getTokenStyle(), null, "tokenStyles", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_AllTokenDirectives(), this.getTokenDirective(), null, "allTokenDirectives", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Rules(), this.getRule(), this.getRule_Syntax(), "rules", null, 1, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax__operatorRules(), this.getRule(), null, "_operatorRules", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax__operatorRuleSubsets(), theEcorePackage.getEString(), "_operatorRuleSubsets", "", 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax__operatorRulesInitialized(), theEcorePackage.getEBoolean(), "_operatorRulesInitialized", null, 0, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax__genClassCache(), this.getGenClassCache(), null, "_genClassCache", null, 1, 1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax__eClassUtil(), this.getEClassUtil(), null, "_eClassUtil", null, 0, 1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax_Abstract(), theEcorePackage.getEBoolean(), "abstract", null, 0, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(concreteSyntaxEClass, this.getRule(), "getOperatorRuleSubset", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "identifier", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, theGenModelPackage.getGenClass(), "getActiveStartSymbols", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getRule(), "getAllRules", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getRule(), "getOperatorRules", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, null, "initialiseAnnotatedOperatorRules", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, theEcorePackage.getEString(), "getOperatorRuleSubsets", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getGenClassCache(), "getGenClassCache", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, theEcorePackage.getEBoolean(), "isImportedRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRule(), "rule", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getEClassUtil(), "getEClassUtil", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, theGenModelPackage.getGenClass(), "getClassesWithSyntax", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "excludeOperatorRules", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, theGenModelPackage.getGenClass(), "getSubClassesWithSyntax", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "superClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "excludeOperatorRules", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getTokenStyle(), "getAllTokenStyles", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, null, "addTokenStyle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "existingStyles", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "newStyle", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, theEcorePackage.getEBoolean(), "containsTokenStyle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "styles", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "tokenName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, null, "addImportedTokenStyles", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "allStyles", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImport_ConcreteSyntax(), this.getConcreteSyntax(), null, "concreteSyntax", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_CsLocationHint(), theEcorePackage.getEString(), "csLocationHint", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syntaxElementEClass, SyntaxElement.class, "SyntaxElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSyntaxElement_Children(), this.getSyntaxElement(), null, "children", null, 0, -1, SyntaxElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(syntaxElementEClass, this.getRule(), "getContainingRule", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Metaclass(), theGenModelPackage.getGenClass(), null, "metaclass", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Syntax(), this.getConcreteSyntax(), this.getConcreteSyntax_Rules(), "syntax", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(ruleEClass, this.getAnnotation(), "getOperatorAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(ruleEClass, theEcorePackage.getEInt(), "getOperatorWeight", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(ruleEClass, this.getChoice(), "getDefinition", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "hasAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnnotationType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "isOverrideRemoveRule", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(ruleEClass, theEcorePackage.getEBoolean(), "isOverrideRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "metaClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(choiceEClass, this.getSequence(), "getOptions", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(sequenceEClass, this.getDefinition(), "getParts", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(definitionEClass, Definition.class, "Definition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(definitionEClass, theEcorePackage.getEBoolean(), "hasMinimalCardinalityOneOrHigher", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(definitionEClass, theEcorePackage.getEBoolean(), "hasNoOptionalPart", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(definitionEClass, theEcorePackage.getEString(), "computeCardinalityString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(cardinalityDefinitionEClass, CardinalityDefinition.class, "CardinalityDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCardinalityDefinition_Cardinality(), this.getCardinality(), "cardinality", null, 0, 1, CardinalityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(cardinalityDefinitionEClass, theEcorePackage.getEBoolean(), "hasMinimalCardinalityOneOrHigher", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(cardinalityDefinitionEClass, theEcorePackage.getEBoolean(), "hasNoOptionalPart", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(terminalEClass, Terminal.class, "Terminal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminal_Feature(), theGenModelPackage.getGenFeature(), null, "feature", null, 1, 1, Terminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(csStringEClass, CsString.class, "CsString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCsString_Value(), ecorePackage.getEString(), "value", null, 1, 1, CsString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whiteSpacesEClass, WhiteSpaces.class, "WhiteSpaces", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWhiteSpaces_Amount(), ecorePackage.getEInt(), "amount", null, 1, 1, WhiteSpaces.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineBreakEClass, LineBreak.class, "LineBreak", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLineBreak_Tab(), ecorePackage.getEInt(), "tab", null, 1, 1, LineBreak.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundDefinitionEClass, CompoundDefinition.class, "CompoundDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(compoundDefinitionEClass, this.getChoice(), "getDefinition", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(regexComposerEClass, RegexComposer.class, "RegexComposer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(regexComposerEClass, theEcorePackage.getEString(), "getComposedRegex", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractTokenDefinition(), "token", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractTokenDefinition(), "visitedTokens", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(regexOwnerEClass, RegexOwner.class, "RegexOwner", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegexOwner_Regex(), theEcorePackage.getEString(), "regex", null, 1, 1, RegexOwner.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(regexPartEClass, RegexPart.class, "RegexPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regexCompositeEClass, RegexComposite.class, "RegexComposite", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegexComposite_RegexParts(), this.getRegexPart(), null, "regexParts", null, 1, -1, RegexComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(regexCompositeEClass, theEcorePackage.getEString(), "getRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(atomicRegexEClass, AtomicRegex.class, "AtomicRegex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtomicRegex_AtomicExpression(), theEcorePackage.getEString(), "atomicExpression", null, 1, 1, AtomicRegex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(atomicRegexEClass, theEcorePackage.getEString(), "getRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(regexReferenceEClass, RegexReference.class, "RegexReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegexReference_Target(), this.getNamedTokenDefinition(), null, "target", null, 1, 1, RegexReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(regexReferenceEClass, theEcorePackage.getEString(), "getRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tokenDirectiveEClass, TokenDirective.class, "TokenDirective", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractTokenDefinitionEClass, AbstractTokenDefinition.class, "AbstractTokenDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedTokenDefinitionEClass, NamedTokenDefinition.class, "NamedTokenDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedTokenDefinition_Name(), theEcorePackage.getEString(), "name", null, 1, 1, NamedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referencableTokenDefinitionEClass, ReferencableTokenDefinition.class, "ReferencableTokenDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferencableTokenDefinition_AttributeReferences(), this.getPlaceholder(), this.getPlaceholder_Token(), "attributeReferences", null, 0, -1, ReferencableTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partialTokenDefinitionEClass, PartialTokenDefinition.class, "PartialTokenDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(partialTokenDefinitionEClass, theEcorePackage.getEString(), "getRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(completeTokenDefinitionEClass, CompleteTokenDefinition.class, "CompleteTokenDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompleteTokenDefinition_AttributeName(), theEcorePackage.getEString(), "attributeName", null, 0, 1, CompleteTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(completeTokenDefinitionEClass, theEcorePackage.getEBoolean(), "isHidden", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(completeTokenDefinitionEClass, theEcorePackage.getEBoolean(), "isUsed", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(completeTokenDefinitionEClass, theEcorePackage.getEBoolean(), "isImported", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConcreteSyntax(), "syntax", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(completeTokenDefinitionEClass, this.getConcreteSyntax(), "getContainingSyntax", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConcreteSyntax(), "syntax", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(normalTokenDefinitionEClass, NormalTokenDefinition.class, "NormalTokenDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(normalTokenDefinitionEClass, theEcorePackage.getEString(), "getRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tokenRedefinitionEClass, TokenRedefinition.class, "TokenRedefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTokenRedefinition_RedefinedToken(), this.getCompleteTokenDefinition(), null, "redefinedToken", null, 1, 1, TokenRedefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(tokenRedefinitionEClass, theEcorePackage.getEString(), "getRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(quotedTokenDefinitionEClass, QuotedTokenDefinition.class, "QuotedTokenDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuotedTokenDefinition_Prefix(), theEcorePackage.getEString(), "prefix", "", 0, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedTokenDefinition_Suffix(), theEcorePackage.getEString(), "suffix", "", 0, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedTokenDefinition_EscapeCharacter(), theEcorePackage.getEString(), "escapeCharacter", null, 0, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedTokenDefinition_SynthesizedRegex(), theEcorePackage.getEString(), "synthesizedRegex", null, 1, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(quotedTokenDefinitionEClass, theEcorePackage.getEString(), "getRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tokenPriorityDirectiveEClass, TokenPriorityDirective.class, "TokenPriorityDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTokenPriorityDirective_Token(), this.getCompleteTokenDefinition(), null, "token", null, 1, 1, TokenPriorityDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containmentEClass, Containment.class, "Containment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainment_Types(), theGenModelPackage.getGenClass(), null, "types", null, 0, -1, Containment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(containmentEClass, theGenModelPackage.getGenClass(), "getAllowedSubTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(placeholderEClass, Placeholder.class, "Placeholder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaceholder_Token(), this.getReferencableTokenDefinition(), this.getReferencableTokenDefinition_AttributeReferences(), "token", null, 1, 1, Placeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(placeholderUsingSpecifiedTokenEClass, PlaceholderUsingSpecifiedToken.class, "PlaceholderUsingSpecifiedToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeholderUsingDefaultTokenEClass, PlaceholderUsingDefaultToken.class, "PlaceholderUsingDefaultToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeholderInQuotesEClass, PlaceholderInQuotes.class, "PlaceholderInQuotes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlaceholderInQuotes_Prefix(), theEcorePackage.getEString(), "prefix", "", 1, 1, PlaceholderInQuotes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlaceholderInQuotes_Suffix(), theEcorePackage.getEString(), "suffix", "", 1, 1, PlaceholderInQuotes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlaceholderInQuotes_EscapeCharacter(), theEcorePackage.getEString(), "escapeCharacter", null, 0, 1, PlaceholderInQuotes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(placeholderInQuotesEClass, theEcorePackage.getEString(), "getNormalizedPrefix", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(placeholderInQuotesEClass, theEcorePackage.getEString(), "getNormalizedSuffix", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(placeholderInQuotesEClass, theEcorePackage.getEString(), "getNormalizedEscapeCharacter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(placeholderInQuotesEClass, theEcorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(booleanTerminalEClass, BooleanTerminal.class, "BooleanTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanTerminal_TrueLiteral(), theEcorePackage.getEString(), "trueLiteral", null, 1, 1, BooleanTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBooleanTerminal_FalseLiteral(), theEcorePackage.getEString(), "falseLiteral", null, 1, 1, BooleanTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(booleanTerminalEClass, theEcorePackage.getEBoolean(), "containsEmptyLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(enumTerminalEClass, EnumTerminal.class, "EnumTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumTerminal_Literals(), this.getEnumLiteralTerminal(), null, "literals", null, 1, -1, EnumTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(enumTerminalEClass, theEcorePackage.getEBoolean(), "containsEmptyLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(enumTerminalEClass, this.getEnumLiteralTerminal(), "getNonEmptyLiterals", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(enumTerminalEClass, this.getEnumLiteralTerminal(), "getEmptyLiterals", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(enumLiteralTerminalEClass, EnumLiteralTerminal.class, "EnumLiteralTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumLiteralTerminal_Literal(), theEcorePackage.getEEnumLiteral(), null, "literal", null, 1, 1, EnumLiteralTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumLiteralTerminal_Text(), theEcorePackage.getEString(), "text", null, 1, 1, EnumLiteralTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOption_Type(), this.getOptionTypes(), "type", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOption_Value(), ecorePackage.getEString(), "value", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tokenStyleEClass, TokenStyle.class, "TokenStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTokenStyle_TokenNames(), theEcorePackage.getEString(), "tokenNames", null, 1, -1, TokenStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTokenStyle_Rgb(), theEcorePackage.getEString(), "rgb", null, 1, 1, TokenStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTokenStyle_FontStyles(), this.getFontStyle(), "fontStyles", null, 0, -1, TokenStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotation_Type(), this.getAnnotationType(), "type", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_Parameters(), this.getKeyValuePair(), null, "parameters", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(annotationEClass, theEcorePackage.getEString(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "key", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(annotableEClass, Annotable.class, "Annotable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotable_Annotations(), this.getAnnotation(), null, "annotations", null, 0, -1, Annotable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyValuePairEClass, KeyValuePair.class, "KeyValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKeyValuePair_Key(), theEcorePackage.getEString(), "key", null, 1, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKeyValuePair_Value(), theEcorePackage.getEString(), "value", null, 0, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genClassCacheEClass, GenClassCache.class, "GenClassCache", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenClassCache__qualifiedInterfaceNameCache(), this.getGenClassCacheEntry(), null, "_qualifiedInterfaceNameCache", null, 0, -1, GenClassCache.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(genClassCacheEClass, theEcorePackage.getEString(), "getQualifiedInterfaceName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "genClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genClassCacheEClass, theEcorePackage.getEString(), "getEscapedTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "genClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genClassCacheEClass, theEcorePackage.getEBoolean(), "hasMapType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "genClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genClassCacheEClass, theEcorePackage.getEBoolean(), "containsEqualByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "list", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "genClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(genClassCacheEntryEClass, Map.Entry.class, "GenClassCacheEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenClassCacheEntry_Key(), theGenModelPackage.getGenClass(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenClassCacheEntry_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eClassUtilEClass, EClassUtil.class, "EClassUtil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(eClassUtilEClass, theEcorePackage.getEBoolean(), "isSubClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "subClassCandidate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "superClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eClassUtilEClass, theEcorePackage.getEClass(), "getSubClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "superClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "availableClasses", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eClassUtilEClass, theEcorePackage.getEBoolean(), "namesAndPackageURIsAreEqual", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "classA", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "classB", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eClassUtilEClass, theEcorePackage.getEBoolean(), "packageURIsAreEqual", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "classA", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "classB", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eClassUtilEClass, theEcorePackage.getEBoolean(), "namesAreEqual", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "classA", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "classB", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eClassUtilEClass, theEcorePackage.getEBoolean(), "isConcrete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "eClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eClassUtilEClass, theEcorePackage.getEBoolean(), "isNotConcrete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "eClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(defaultTokenStyleAdderEClass, DefaultTokenStyleAdder.class, "DefaultTokenStyleAdder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(defaultTokenStyleAdderEClass, null, "addDefaultTokenStyles", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConcreteSyntax(), "syntax", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "allStyles", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(defaultTokenStyleAdderEClass, null, "addTokenStylesForKeywords", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConcreteSyntax(), "syntax", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "allStyles", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(defaultTokenStyleAdderEClass, null, "addTokenStylesForQuotedTokens", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConcreteSyntax(), "syntax", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "allStyles", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(defaultTokenStyleAdderEClass, theEcorePackage.getEBoolean(), "isCommentPattern", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "regex", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(defaultTokenStyleAdderEClass, null, "addTokenStylesForComments", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConcreteSyntax(), "syntax", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTokenStyle(), "allStyles", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(defaultTokenStyleAdderEClass, this.getCsString(), "getAllKeywords", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRule(), "rule", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(defaultTokenStyleAdderEClass, this.getPlaceholderInQuotes(), "getAllPlaceholdersInQuotes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRule(), "rule", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(defaultTokenStyleAdderEClass, theEcorePackage.getEString(), "getKeywordRegex", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(cardinalityEEnum, Cardinality.class, "Cardinality");
		addEEnumLiteral(cardinalityEEnum, Cardinality.NONE);
		addEEnumLiteral(cardinalityEEnum, Cardinality.PLUS);
		addEEnumLiteral(cardinalityEEnum, Cardinality.STAR);
		addEEnumLiteral(cardinalityEEnum, Cardinality.QUESTIONMARK);

		initEEnum(optionTypesEEnum, OptionTypes.class, "OptionTypes");
		addEEnumLiteral(optionTypesEEnum, OptionTypes.GENERATE_TEST_ACTION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PLUGIN_XML);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_MANIFEST);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PARSER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TOKEN_RESOLVERS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_REFERENCE_RESOLVERS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PRINTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.ANTLR_BACKTRACKING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.ANTLR_MEMOIZE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.FORCE_EOF);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.DEFAULT_TOKEN_NAME);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.USE_PREDEFINED_TOKENS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.TOKENSPACE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.RELOAD_GENERATOR_MODEL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DOT_CLASSPATH);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DOT_PROJECT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TEXT_RESOURCE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_RESOURCE_FACTORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_NEW_FILE_WIZARD);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.PARSER_GENERATOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.SOURCE_FOLDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.BASE_PACKAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.RESOURCE_PLUGIN_ID);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BUILD_PROPERTIES);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_META_INFORMATION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PROBLEM_CLASS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SCANNER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DUMMY_EOBJECT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ELEMENT_MAPPING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LOCATION_MAP);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_URI_MAPPING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PARSE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ANTLR_TOKEN_HELPER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BRACKET_SET);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CODE_FOLDING_MANAGER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_COLOR_MANAGER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_COMPLETION_PROCESSOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PARSING_STRATEGY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EDITOR_CONFIGURATION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EDITOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EOBJECT_SELECTION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_HIGHLIGHTING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_HTML_PRINTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_HYPERLINK);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_HYPERLINK_DETECTOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_MARKER_HELPER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_OCCURRENCE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_OUTLINE_PAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_POSITION_CATEGORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_POSITION_HELPER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PROPERTY_SHEET_PAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TEXT_HOVER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TOKEN_SCANNER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BRACKET_PREFERENCE_PAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PREFERENCE_CONSTANTS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_OCCURRENCE_PREFERENCE_PAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PIXEL_CONVERTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PREFERENCE_INITIALIZER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SYNTAX_COLORING_HELPER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_INPUT_STREAM_PROCESSOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IOPTION_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IOPTIONS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IBRACKET_PAIR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ICOMMAND);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ICONFIGURABLE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IELEMENT_MAPPING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IEXPECTED_ELEMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IHOVER_TEXT_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ILOCATION_MAP);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IPARSE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IPROBLEM);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IREFERENCE_MAPPING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IREFERENCE_RESOLVER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IREFERENCE_RESOLVE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IREFERENCE_RESOLVER_SWITCH);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITEXT_DIAGNOSTIC);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITEXT_PARSER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITEXT_PRINTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITEXT_RESOURCE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IMETA_INFORMATION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITEXT_SCANNER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITEXT_TOKEN);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITOKEN_RESOLVER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITOKEN_RESOLVE_RESULT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITOKEN_RESOLVER_FACTORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ITOKEN_STYLE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IURI_MAPPING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EPROBLEM_TYPE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CODE_COMPLETION_HELPER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EXPECTED_CS_STRING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EXPECTED_STRUCTURAL_FEATURE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CAST_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_COPIED_ELIST);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ECLASS_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EOBJECT_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LIST_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_MAP_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_MINIMAL_MODEL_HELPER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_RESOURCE_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_STREAM_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_STRING_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TEXT_RESOURCE_UTIL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UNICODE_CONVERTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ABSTRACT_EXPECTED_ELEMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_NEW_FILE_WIZARD_PAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IBACKGROUND_PARSING_LISTENER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TERMINATE_PARSING_EXCEPTION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TEXT_TOKEN);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.SOURCE_GEN_FOLDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_RESOURCE_FACTORY_DELEGATOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.BASE_RESOURCE_PLUGIN);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PREFERENCE_PAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.ANTLR_PLUGIN_ID);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ANTLR_PLUGIN);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_FOLDING_INFORMATION_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BRACKET_INFORMATION_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.SAVE_CHANGED_RESOURCES_ONLY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_NEW_FILE_CONTENT_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.LICENCE_HEADER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EXPECTED_TERMINAL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_COMPLETION_PROPOSAL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BUILDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BUILDER_ADAPTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IBUILDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_NATURE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.ADDITIONAL_DEPENDENCIES);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.DISABLE_BUILDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.ADDITIONAL_EXPORTS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PAIR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ABSTRACT_INTERPRETER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_GRAMMAR_INFORMATION_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ATTRIBUTE_VALUE_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_FOLLOW_SET_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SYNTAX_ELEMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_KEYWORD);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PLACEHOLDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CARDINALITY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PRINTER2);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CHOICE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_COMPOUND);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CONTAINMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LINE_BREAK);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SEQUENCE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_WHITE_SPACE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SYNTAX_ELEMENT_DECORATOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IREFERENCE_CACHE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_FORMATTING_ELEMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TERMINAL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LAYOUT_INFORMATION_ADAPTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LAYOUT_INFORMATION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.USE_CLASSIC_PRINTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.DISABLE_EVALIDATORS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.DISABLE_EMF_VALIDATION_CONSTRAINTS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UI_META_INFORMATION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.RESOURCE_UI_PLUGIN_ID);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UI_PLUGIN_ACTIVATOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.UI_BASE_PACKAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.ADDITIONAL_UI_DEPENDENCIES);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.ADDITIONAL_UI_EXPORTS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UI_MANIFEST);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UI_BUILD_PROPERTIES);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UI_DOT_CLASSPATH);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UI_DOT_PROJECT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.UI_SOURCE_FOLDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.UI_SOURCE_GEN_FOLDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.GENERATE_UI_PLUGIN);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IBRACKET_HANDLER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_UI_PLUGIN_XML);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PROPOSAL_POST_PROCESSOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.DISABLE_TOKEN_SORTING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IQUICK_FIX);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_QUICK_FIX);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ANNOTATION_MODEL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ANNOTATION_MODEL_FACTORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_MARKER_ANNOTATION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_MARKER_RESOLUTION_GENERATOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_QUICK_ASSIST_ASSISTANT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_QUICK_ASSIST_PROCESSOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IMAGE_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_TOKEN_STYLE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DYNAMIC_TOKEN_STYLER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.RESOLVE_PROXY_ELEMENTS_AFTER_PARSING);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EXPECTED_BOOLEAN_TERMINAL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_BOOLEAN_TERMINAL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ENUMERATION_TERMINAL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EXPECTED_ENUMERATION_TERMINAL);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_CHANGE_REFERENCE_QUICK_FIX);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EPROBLEM_SEVERITY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_RESOURCE_POST_PROCESSOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IRESOURCE_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IBRACKET_HANDLER_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IANNOTATION_MODEL_PROVIDER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LAUNCH_SHORTCUT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_PROPERTY_TESTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.DISABLE_LAUNCH_SUPPORT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_RULE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ABSTRACT_DEBUGGABLE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_EDEBUG_MESSAGE_TYPES);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IDEBUG_EVENT_LISTENER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_IINTERPRETER_LISTENER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_COMMUNICATION_HELPER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_ELEMENT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUGGABLE_INTERPRETER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUGGER_LISTENER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_MESSAGE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_PROCESS);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_PROXY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_TARGET);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_THREAD);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_VALUE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_VARIABLE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LINEBREAK_POINT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SOURCE_LOCATOR);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SOURCE_LOOKUP_PARTICIPANT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_STACK_FRAME);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.DISABLE_DEBUG_SUPPORT);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_DEBUG_MODEL_PRESENTATION);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LINE_BREAKPOINT_ADAPTER);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_ADAPTER_FACTORY);
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_HELPER);

		initEEnum(fontStyleEEnum, FontStyle.class, "FontStyle");
		addEEnumLiteral(fontStyleEEnum, FontStyle.BOLD);
		addEEnumLiteral(fontStyleEEnum, FontStyle.ITALIC);
		addEEnumLiteral(fontStyleEEnum, FontStyle.STRIKETHROUGH);
		addEEnumLiteral(fontStyleEEnum, FontStyle.UNDERLINE);

		initEEnum(annotationTypeEEnum, AnnotationType.class, "AnnotationType");
		addEEnumLiteral(annotationTypeEEnum, AnnotationType.OVERRIDE);
		addEEnumLiteral(annotationTypeEEnum, AnnotationType.SUPPRESS_WARNINGS);
		addEEnumLiteral(annotationTypeEEnum, AnnotationType.FOLDABLE);
		addEEnumLiteral(annotationTypeEEnum, AnnotationType.OPERATOR);

		initEEnum(operatorAnnotationTypeEEnum, OperatorAnnotationType.class, "OperatorAnnotationType");
		addEEnumLiteral(operatorAnnotationTypeEEnum, OperatorAnnotationType.BINARY_LEFT_ASSOCIATIVE);
		addEEnumLiteral(operatorAnnotationTypeEEnum, OperatorAnnotationType.BINARY_RIGHT_ASSOCIATIVE);
		addEEnumLiteral(operatorAnnotationTypeEEnum, OperatorAnnotationType.UNARY_PREFIX);
		addEEnumLiteral(operatorAnnotationTypeEEnum, OperatorAnnotationType.UNARY_POSTFIX);
		addEEnumLiteral(operatorAnnotationTypeEEnum, OperatorAnnotationType.PRIMITIVE);

		initEEnum(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.class, "OperatorAnnotationProperty");
		addEEnumLiteral(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.TYPE);
		addEEnumLiteral(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.SUPERCLASS);
		addEEnumLiteral(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.WEIGHT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";		
		addAnnotation
		  (concreteSyntaxEClass, 
		   source, 
		   new String[] {
			 "documentation", "A specification of the concrete syntax for an Ecore metamodel."
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> subset = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>();\r\n\r\n\t\tif (identifier == null) {\r\n\t\t\treturn subset;\r\n\t\t}\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getOperatorRules()) {\r\n\t\t\t org.emftext.sdk.concretesyntax.Annotation annotation = rule.getOperatorAnnotation();\r\n\t\t\t java.lang.String value = annotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());\r\n\t\t\tif (identifier.equals(value)) {\r\n\t\t\t\tsubset.add(rule);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn subset;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> symbols = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\r\n\t\tsymbols.addAll(getStartSymbols());\r\n\r\n\t\tif (symbols.size() > 0) {\r\n\t\t\treturn symbols;\r\n\t\t}\r\n\r\n\t\t\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Import> imports = getImports();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports) {\r\n\t\t\tfinal  org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();\r\n\t\t\tif (importedSyntax != null) {\r\n\t\t\t\tsymbols.addAll(importedSyntax.getActiveStartSymbols());\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn symbols;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t//EStructuralFeature eFeature = ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES;\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> l = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>(getRules().size());\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {\r\n\t\t\t// don\'t add rules that are @override rules with remove=true\r\n\t\t\tif (!rule.isOverrideRemoveRule()) {\r\n\t\t\t\tl.add(rule);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Import aImport : getImports()) {\r\n\t\t\t org.emftext.sdk.concretesyntax.ConcreteSyntax importedCS = aImport.getConcreteSyntax();\r\n\t\t\tif (importedCS != null) {\r\n\t\t\t\touter: for ( org.emftext.sdk.concretesyntax.Rule importedRule : importedCS.getAllRules()) {\r\n\t\t\t\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {\r\n\t\t\t\t\t\t// don\'t add rules that have @override rules for same\r\n\t\t\t\t\t\t// meta-class\r\n\t\t\t\t\t\tif (rule.isOverrideRule(importedRule.getMetaclass())) {\r\n\t\t\t\t\t\t\tcontinue outer;\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t\tl.add(importedRule);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn  org.eclipse.emf.common.util.ECollections.unmodifiableEList(l);\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tinitialiseAnnotatedOperatorRules();\r\n\r\n\t\treturn get_operatorRules();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tif (is_operatorRulesInitialized()) {\r\n\t\t\treturn;\r\n\t\t}\r\n\r\n\t\tset_operatorRulesInitialized(true);\r\n\r\n\t\t java.util.List< org.emftext.sdk.concretesyntax.Rule> operatorRules = getOperatorRules();\r\n\r\n\t\t java.util.List< java.lang.String> operatorRuleSubsets = getOperatorRuleSubsets();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getAllRules()) {\r\n\t\t\t org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = rule.getOperatorAnnotation();\r\n\t\t\tif (operatorAnnotation != null) {\r\n\t\t\t\tboolean added = false;\r\n\t\t\t\tfor ( java.util.ListIterator< org.emftext.sdk.concretesyntax.Rule> it = operatorRules.listIterator(); it.hasNext();) {\r\n\t\t\t\t\t org.emftext.sdk.concretesyntax.Rule expressionRule = it.next(); \r\n\t\t\t\t\tif (expressionRule.getOperatorWeight() > rule.getOperatorWeight()) {\r\n\t\t\t\t\t\toperatorRules.add(it.previousIndex(), rule);\r\n\t\t\t\t\t\tadded = true;\r\n\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t}\t\t\t\r\n\t\t\t\t}\r\n\t\t\t\tif (!added) {\r\n\t\t\t\t\toperatorRules.add(rule);\r\n\t\t\t\t}\r\n\t\t\t\t java.lang.String identifier = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());\r\n\t\t\t\toperatorRuleSubsets.add(identifier);\r\n\t\t\t}\r\n\t\t}\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tinitialiseAnnotatedOperatorRules();\r\n\r\n\t\treturn get_operatorRuleSubsets();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tif (get_genClassCache() == null) {\r\n\t\t\tset_genClassCache( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createGenClassCache());\r\n\t\t}\r\n\r\n\t\treturn get_genClassCache();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn rule.getSyntax() != this;\r\n",
			 "documentation", "Returns true if the given rule was defined in the given syntax.\r\nIf the rule is defined in an imported syntax, this method returns false.\r\n \r\n@param syntax the syntax that refers to the rule\r\n@param rule the rule to check\r\n@return true if the rule is contained, false if it is imported"
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tif (get_eClassUtil() == null) {\r\n\t\t\tset_eClassUtil( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEClassUtil());\r\n\t\t}\r\n\r\n\t\treturn get_eClassUtil();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.util.Collection< org.emftext.sdk.concretesyntax.Rule> rules = getAllRules();\r\n\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> foundGenClasses = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : rules) {\r\n\t\t\tif (excludeOperatorRules && rule.getOperatorAnnotation() != null) {\r\n\t\t\t\tcontinue;\r\n\t\t\t}\r\n\t\t\t org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand = rule.getMetaclass();\r\n\t\t\tfoundGenClasses.add(subClassCand);\r\n\t\t}\r\n\r\n\t\treturn foundGenClasses;\r\n",
			 "documentation", "Collects all the subclasses for which concrete syntax is defined."
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> subClasses = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\r\n\r\n\t\t org.eclipse.emf.ecore.EClass ecoreClass = superClass.getEcoreClass();\r\n\r\n\t\t org.emftext.sdk.concretesyntax.EClassUtil eClassUtil = getEClassUtil();\r\n\r\n\t\tfor ( org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand : getClassesWithSyntax(excludeOperatorRules)) {\r\n\t\t\tif (eClassUtil.isSubClass(subClassCand.getEcoreClass(), ecoreClass)) {\r\n\t\t\t\tsubClasses.add(subClassCand);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn subClasses;\r\n",
			 "documentation", "Collects all the subclasses for which concrete syntax is defined."
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(11), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.TokenStyle> allStyles = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.TokenStyle>();\r\n\r\n\t\tallStyles.addAll(getTokenStyles());\r\n\r\n\t\taddImportedTokenStyles(allStyles);\r\n\r\n\t\t org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder adder = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefaultTokenStyleAdder();\r\n\r\n\t\tadder.addDefaultTokenStyles(this, allStyles);\r\n\r\n\t\treturn allStyles;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(12), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfor ( java.lang.String tokenName : newStyle.getTokenNames()) {\r\n\t\t\tboolean exists = containsTokenStyle(existingStyles, tokenName);\r\n\t\t\tif (!exists) {\r\n\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newTokenStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\tnewTokenStyle.getTokenNames().add(tokenName);\r\n\t\t\t\tnewTokenStyle.setRgb(newStyle.getRgb());\r\n\t\t\t\tnewTokenStyle.getFontStyles().addAll(newStyle.getFontStyles());\r\n\t\t\t\texistingStyles.add(newTokenStyle);\r\n\t\t\t}\r\n\t\t}\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(13), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfor ( org.emftext.sdk.concretesyntax.TokenStyle existingStyle : styles) {\r\n\t\t\tfor ( java.lang.String existingName : existingStyle.getTokenNames()) {\r\n\t\t\t\tif (existingName.equals(tokenName)) {\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(14), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t// add the imported token styles\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Import> imports = getImports();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports) {\r\n\t\t\t org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();\r\n\t\t\tif (importedSyntax != null) {\r\n\t\t\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.TokenStyle> importedStyles = importedSyntax.getAllTokenStyles();\r\n\t\t\t\tfor ( org.emftext.sdk.concretesyntax.TokenStyle importedStyle : importedStyles) {\r\n\t\t\t\t\taddTokenStyle(allStyles, importedStyle);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n",
			 "documentation", "\r\n Reads all token styles from imported syntaxes and\r\n merges them with the styles defined in the current syntax. If a token\r\n styles exists both in an imported and in the current syntax the one from\r\n the current syntax overrides the imported one.\r\n"
		   });		
		addAnnotation
		  (getConcreteSyntax_SyntheticTokens(), 
		   source, 
		   new String[] {
			 "documentation", "Contains all synthesized tokens. This includes the quoted tokens and the predefined tokens."
		   });		
		addAnnotation
		  (getConcreteSyntax_Abstract(), 
		   source, 
		   new String[] {
			 "documentation", "A flag that is used to tag syntax definitions as abstract."
		   });		
		addAnnotation
		  (importEClass, 
		   source, 
		   new String[] {
			 "documentation", "Import statements allow to reuse existing metamodels and syntax definitions."
		   });		
		addAnnotation
		  (getImport_Prefix(), 
		   source, 
		   new String[] {
			 "documentation", "A short prefix that is used to reference the imported elements."
		   });		
		addAnnotation
		  (getImport_CsLocationHint(), 
		   source, 
		   new String[] {
			 "documentation", "A URI where the concrete syntax definition to import is located."
		   });		
		addAnnotation
		  (syntaxElementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.emftext.sdk.concretesyntax.Rule rule = null;\r\n\r\n\t\t org.eclipse.emf.ecore.EObject o = this;\r\n\r\n\t\tdo {\r\n\t\t\tif (o instanceof  org.emftext.sdk.concretesyntax.Rule) {\r\n\t\t\t\trule = ( org.emftext.sdk.concretesyntax.Rule) o;\r\n\t\t\t}\r\n\t\t\telse {\r\n\t\t\t\to = o.eContainer();\r\n\t\t\t}\r\n\t\t} while (rule == null && o != null);\r\n\r\n\t\treturn rule;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (ruleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Defines the concrete textual syntax for a metaclass."
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {\r\n\t\t\tif (annotation.getType() ==  org.emftext.sdk.concretesyntax.AnnotationType.OPERATOR) {\r\n\t\t\t\treturn annotation;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn null;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = this.getOperatorAnnotation();\r\n\r\n\t\tif (operatorAnnotation != null) {\r\n\t\t\t java.lang.String ruleWeightString = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.WEIGHT.toString());\r\n\t\t\tif (ruleWeightString != null) {\r\n\t\t\t\ttry {\r\n\t\t\t\t\treturn  java.lang.Integer.parseInt(ruleWeightString);\t\t\t\r\n\t\t\t\t} catch ( java.lang.NumberFormatException e) {\r\n\t\t\t\t\t// ignore exception. invalid numbers are signaled by\r\n\t\t\t\t\t// returning MIN_VALUE\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn  java.lang.Integer.MIN_VALUE;\r\n",
			 "documentation", "\r\n Returns the weight of this rule if it is an operator rule.\r\n If the rule is not an operator rule or the specified weight\r\n in the operator annotation is not a number, Integer.MIN_VALUE \r\n is returned.\r\n"
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.SyntaxElement> children = getChildren();\r\n\r\n\t\t// there should be at most one child\r\n\t\tassert children == null || children.size() == 1;\r\n\r\n\t\t\r\n\t\tif (children.size() > 0) {\r\n\t\t\t org.emftext.sdk.concretesyntax.SyntaxElement firstChild = children.get(0);\r\n\t\t\tif (firstChild instanceof  org.emftext.sdk.concretesyntax.Choice) {\r\n\t\t\t\treturn ( org.emftext.sdk.concretesyntax.Choice) firstChild;\r\n\t\t\t} else {\r\n\t\t\t\t// there should be no element other than Choice\r\n\t\t\t\tassert false;\r\n\t\t\t\treturn null;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn null;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {\r\n\t\t\tif (annotation.getType() == type) {\r\n\t\t\t\tif (key != null) {\r\n\t\t\t\t\tfor ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : annotation.getParameters()) {\r\n\t\t\t\t\t\tif (key.equals(parameter.getKey())\r\n\t\t\t\t\t\t\t\t&& parameter.getValue().equals(value)) {\r\n\t\t\t\t\t\t\treturn true;\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t} else {\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n",
			 "documentation", "\r\n Checks whether this rule is annotated with the given AnnotationType.\r\n If a key and a value is given it is further checked whether the\r\n annotation specifies this key and value. \r\n"
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t// TODO mseifert: use constant here\r\n\t\treturn hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, \"remove\", \"true\");\r\n",
			 "documentation", "\r\n Checks whether this rule is annotated with @Override(remove=\"true\").\r\n"
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t\t\tif (metaClass == null || getMetaclass() == metaClass) {\r\n\t\t\tif (hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, null, null)) {\r\n\t\t\t\treturn true;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n",
			 "documentation", "\r\n Checks whether this rule is annotated with @Override.\r\n"
		   });		
		addAnnotation
		  (choiceEClass, 
		   source, 
		   new String[] {
			 "documentation", "Defines alternative syntax for an element of parts of it."
		   });		
		addAnnotation
		  (choiceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Sequence> options = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Sequence>();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.SyntaxElement child : getChildren()) {\r\n\t\t\tif (child instanceof  org.emftext.sdk.concretesyntax.Sequence) {\r\n\t\t\t\toptions.add(( org.emftext.sdk.concretesyntax.Sequence) child);\r\n\t\t\t} else {\r\n\t\t\t\t// there should be no elements other than Sequence elements in the\r\n\t\t\t\t// list of children\r\n\t\t\t\tassert false;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn options;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (sequenceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Definition> parts = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Definition>();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.SyntaxElement child : getChildren()) {\r\n\t\t\tif (child instanceof  org.emftext.sdk.concretesyntax.Definition) {\r\n\t\t\t\tparts.add(( org.emftext.sdk.concretesyntax.Definition) child);\r\n\t\t\t} else {\r\n\t\t\t\t// there should be no elements other than Definition elements in the\r\n\t\t\t\t// list of children\r\n\t\t\t\tassert false;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn parts;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (definitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn true;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (definitionEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn false;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (definitionEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.emftext.sdk.concretesyntax.Cardinality cardinality =  org.emftext.sdk.concretesyntax.Cardinality.NONE;\r\n\r\n\t\tif (this instanceof  org.emftext.sdk.concretesyntax.CardinalityDefinition) {\r\n\t\t\tcardinality = (( org.emftext.sdk.concretesyntax.CardinalityDefinition) this).getCardinality();\r\n\t\t}\r\n\r\n\t\tif (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.NONE) {\r\n\t\t\treturn \"\";\r\n\t\t} else if (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.PLUS) {\r\n\t\t\treturn \"+\";\r\n\t\t} else if (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK) {\r\n\t\t\treturn \"?\";\r\n\t\t} else {\r\n\t\t\treturn \"*\";\r\n\t\t}\r\n",
			 "documentation", "\r\n Returns a string representation of the cardinality of the\r\n\' or the\r\n empty string.\r\n \r\n @param definition\r\n @return\r\n"
		   });		
		addAnnotation
		  (cardinalityDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.NONE || getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.PLUS;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (cardinalityDefinitionEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn !\r\n\t\t\t(getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK ||\r\n\t\t\t getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.STAR);\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (csStringEClass, 
		   source, 
		   new String[] {
			 "documentation", "A keyword that is used to represent instances of a metaclass."
		   });		
		addAnnotation
		  (cardinalityEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Allows to repeat the preceding syntax element multiple times."
		   });		
		addAnnotation
		  (cardinalityEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Allows to repeat the preceding syntax element multiple times (including zero times)."
		   });		
		addAnnotation
		  (cardinalityEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Tags the preceding syntax element as optional."
		   });		
		addAnnotation
		  (compoundDefinitionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A group of syntax elements that must appear together."
		   });		
		addAnnotation
		  (compoundDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.SyntaxElement> children = getChildren();\r\n\r\n\t\t// there should be at most one child\r\n\t\tassert children == null || children.size() == 1;\r\n\r\n\t\t\r\n\t\tif (children.size() > 0) {\r\n\t\t\t org.emftext.sdk.concretesyntax.SyntaxElement firstChild = children.get(0);\r\n\t\t\tif (firstChild instanceof  org.emftext.sdk.concretesyntax.Choice) {\r\n\t\t\t\treturn ( org.emftext.sdk.concretesyntax.Choice) firstChild;\r\n\t\t\t} else {\r\n\t\t\t\t// there should be no element other than Choice\r\n\t\t\t\tassert false;\r\n\t\t\t\treturn null;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn null;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (regexComposerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tvisitedTokens.add(token);\r\n\r\n\r\n\t\t java.lang.StringBuilder result = new  java.lang.StringBuilder();\r\n\r\n\t\tif (token instanceof  org.emftext.sdk.concretesyntax.RegexComposite) {\r\n\t\t\t org.emftext.sdk.concretesyntax.RegexComposite composite = ( org.emftext.sdk.concretesyntax.RegexComposite) token;\r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.RegexPart part : composite.getRegexParts()) {\r\n\t\t\t\tif (part instanceof  org.emftext.sdk.concretesyntax.AtomicRegex) {\r\n\t\t\t\t\tresult.append(part.getRegex());\r\n\t\t\t\t} else if (part instanceof  org.emftext.sdk.concretesyntax.RegexReference) {\r\n\t\t\t\t\t org.emftext.sdk.concretesyntax.RegexReference reference = ( org.emftext.sdk.concretesyntax.RegexReference) part;\r\n\t\t\t\t\t org.emftext.sdk.concretesyntax.AbstractTokenDefinition target = reference.getTarget();\r\n\t\t\t\t\tif (target == null) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\t\t\t\t\tif (target.eIsProxy()) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\t\t\t\t\tif (visitedTokens.contains(target)) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\t\t\t\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.AbstractTokenDefinition> subVisitedTokens = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.AbstractTokenDefinition>();\r\n\t\t\t\t\tsubVisitedTokens.addAll(visitedTokens);\r\n\t\t\t\t\tresult.append(getComposedRegex(target, subVisitedTokens));\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t} else if (token instanceof  org.emftext.sdk.concretesyntax.RegexOwner) {\r\n\t\t\t org.emftext.sdk.concretesyntax.RegexOwner owner = ( org.emftext.sdk.concretesyntax.RegexOwner) token;\r\n\t\t\tresult.append(owner.getRegex());\r\n\t\t}\r\n\r\n\t\treturn result.toString();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (regexCompositeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.lang.StringBuilder result = new  java.lang.StringBuilder();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.RegexPart part : getRegexParts()) {\r\n\t\t\tresult.append(part.getRegex());\r\n\t\t}\r\n\r\n\t\treturn result.toString();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (atomicRegexEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn getAtomicExpression();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (regexReferenceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.emftext.sdk.concretesyntax.AbstractTokenDefinition target = getTarget();\r\n\r\n\t\tif (target == null || target.eIsProxy()) {\r\n\t\t\treturn \"\";\r\n\t\t} else {\r\n\t\t\tassert target instanceof  org.emftext.sdk.concretesyntax.RegexOwner;\r\n\t\t\treturn (( org.emftext.sdk.concretesyntax.RegexOwner) target).getRegex();\r\n\t\t}\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (partialTokenDefinitionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A fragment of a token definition. Can be used in other token definitions to avoid duplication."
		   });		
		addAnnotation
		  (partialTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.emftext.sdk.concretesyntax.RegexComposer composer = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexComposer();\r\n\r\n\t\treturn composer.getComposedRegex(this, new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.AbstractTokenDefinition>());\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tboolean isReferenced = !getAttributeReferences().isEmpty();\r\n\r\n\t\tboolean isCollectInToken = getAttributeName() != null;\r\n\r\n\t\treturn !isReferenced || isCollectInToken;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tboolean isReferenced = !getAttributeReferences().isEmpty();\r\n\r\n\t\tboolean isCollectInToken = getAttributeName() != null;\r\n\r\n\t\treturn isReferenced || isCollectInToken;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn !syntax.equals(getContainingSyntax(syntax));\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.ecore.EObject container = this.eContainer();\r\n\r\n\t\tif (container instanceof  org.emftext.sdk.concretesyntax.ConcreteSyntax) {\r\n\t\t\treturn ( org.emftext.sdk.concretesyntax.ConcreteSyntax) container;\r\n\t\t}\r\n\r\n\t\treturn syntax;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (normalTokenDefinitionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Defines a token with a name and a regular expression."
		   });		
		addAnnotation
		  (normalTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.emftext.sdk.concretesyntax.RegexComposer composer = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexComposer();\r\n\r\n\t\treturn composer.getComposedRegex(this, new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.AbstractTokenDefinition>());\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (tokenRedefinitionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Redefines the regular expression of an imported token. Also, a new name is assigned to the token."
		   });		
		addAnnotation
		  (tokenRedefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.emftext.sdk.concretesyntax.RegexComposer composer = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexComposer();\r\n\r\n\t\treturn composer.getComposedRegex(this, new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.AbstractTokenDefinition>());\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (quotedTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn getSynthesizedRegex();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (tokenPriorityDirectiveEClass, 
		   source, 
		   new String[] {
			 "documentation", "Prioritizes a token over the subsequent tokens."
		   });		
		addAnnotation
		  (containmentEClass, 
		   source, 
		   new String[] {
			 "documentation", "Calls the syntax rules of the type of the containment reference."
		   });		
		addAnnotation
		  (containmentEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> types = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\r\n\t\t// is there an explicit type defined?\r\n\t\tif (!getTypes().isEmpty()) {\r\n\t\t\ttypes = getTypes();\r\n\t\t} else {\r\n\t\t\ttypes = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\t\t\ttypes.add(getFeature().getTypeGenClass());\r\n\t\t}\r\n\r\n\t\treturn types;\r\n",
			 "documentation", "\r\n Returns all types that are allowed for the given containment.\r\n If type restrictions are specified in the syntax rule, this\r\n list contains the allowed types. If no restriction are present\r\n the type of the feature references by the containment is \r\n returned.\r\n \r\n @param containment\r\n @return\r\n"
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.lang.String prefix = getPrefix();\r\n\r\n\t\tif (prefix == null) return prefix;\r\n\r\n\t\tif (prefix.length() == 0) return null;\r\n\r\n\t\treturn prefix;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.lang.String suffix = getSuffix();\r\n\r\n\t\tif (suffix == null) return suffix;\r\n\r\n\t\tif (suffix.length() == 0) return null;\r\n\r\n\t\treturn suffix;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.lang.String escapeCharacter = getEscapeCharacter();\r\n\r\n\t\tif (escapeCharacter == null) return escapeCharacter;\r\n\r\n\t\tif (escapeCharacter.length() == 0) return null;\r\n\r\n\t\treturn escapeCharacter;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tif (eIsProxy()) return super.toString();\r\n\r\n\r\n\t\t java.lang.StringBuffer result = new  java.lang.StringBuffer();\r\n\r\n\t\t org.eclipse.emf.codegen.ecore.genmodel.GenFeature feature = getFeature();\r\n\r\n\t\tif (feature != null && feature.getEcoreFeature() != null) {\r\n\t\t\tresult.append(feature.getName());\r\n\t\t}\r\n\r\n\t\tresult.append(\"[\'\");\r\n\r\n\t\tresult.append(getPrefix());\r\n\r\n\t\tresult.append(\"\', \'\");\r\n\r\n\t\tresult.append(getSuffix());\r\n\r\n\t\tresult.append(\"\']\");\r\n\r\n\t\treturn result.toString();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (booleanTerminalEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn \"\".equals(getTrueLiteral()) || \"\".equals(getFalseLiteral());\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (enumTerminalEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn !getEmptyLiterals().isEmpty();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (enumTerminalEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal> nonEmptyLiterals = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal>();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : getLiterals()) {\r\n\t\t\t java.lang.String text = literal.getText();\r\n\t\t\tif (text != null && !\"\".equals(text)) {\r\n\t\t\t\tnonEmptyLiterals.add(literal);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn nonEmptyLiterals;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (enumTerminalEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal> emptyLiterals = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal>();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : getLiterals()) {\r\n\t\t\t java.lang.String text = literal.getText();\r\n\t\t\tif (\"\".equals(text)) {\r\n\t\t\t\temptyLiterals.add(literal);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn emptyLiterals;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (optionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A configuration option that parameterizes the code generation process."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, EMFText generates a UI action that can be used to test parsing and printing of files containing textual syntax. The default value for this option is <code>false</code>. This is a non-standard option, which might be removed in future releases of EMFText."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, EMFText automatically generates the model code using the generator model referenced in the CS specification. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, the plugin.xml file will be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the manifest of the resource plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Parser class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, the token resolver classes will be overridden. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(6), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, the reference resolver classes will be overridden. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(7), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the reference resolver switch will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(8), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the token resolver factory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(9), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the printer will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(10), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ANTLR-backtracking is deactivated for parser generation. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(11), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ANTLR-memoize is deactivated for parser generation. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(12), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, EMFText will try to fix rules that contain simple left recursion. The default value for this option is <code>false</code>. This is a non-standard option, which might be removed in future releases of EMFText."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(13), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, EMFText will generate a parser that does not expect an EOF signal at the end of the input stream. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(14), 
		   source, 
		   new String[] {
			 "documentation", "This option can be used to specify the name of the token that is used when no token is given for attributes or non-containment references in syntax rules. Declarations like <code>featureX[]</code> in CS rules will automatically be expanded to <code>featureX[TOKEN_Y]</code> if the value of this option is <code>TOKEN_Y</code>. The default value for this option is <code>TEXT</code>, which makes the predefined token <code>TEXT</code> the default token."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(15), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, EMFText does not automatically provide predefined tokens (TEXT, WHITESPACE, LINEBREAK). The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(16), 
		   source, 
		   new String[] {
			 "documentation", "The (numerical) value of this option defines how many whitespace should be printed between tokens if no whitespace information is given in CS rules. This option should only be used with the classic printer. The default value of this option is <code>1</code> if the classic printer is used (see option <code>useClassicPrinter</code>) and <code>automatic</code> otherwise."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(17), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, EMFText reloads the generator model before loading it. This is particular useful, when the meta model (i.e., the Ecore file) is changing a lot during language development. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(18), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the .classpath file of the resource plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(19), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the .project file of the resource plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(20), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the text resource class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(21), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the resource factory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(22), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the new file wizard class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(23), 
		   source, 
		   new String[] {
			 "documentation", "The name of the parser generator to use. The default value for this option is <code>antlr</code>, which is also the only valid value. This is a non-standard option, which might be removed in future releases of EMFText."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(24), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder where EMFText shall store the customizable classes of the resource plug-in in. All classes for which the <code>override</code> option is set to <code>false</code> will be stored in this folder."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(25), 
		   source, 
		   new String[] {
			 "documentation", "The name of the base package EMFText shall store the generated classes or the resource plug-in in. If this option is not set, the default value is determined by adding the suffix <code>resource.FILE_EXTENSION</code> to the base package of the generator model."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(26), 
		   source, 
		   new String[] {
			 "documentation", "The ID of the generated resource plug-in. The resource plug-in is stored in a folder that is equal to this ID."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(27), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the build.properties file will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(28), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the MetaInformation class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(29), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the default resolver class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(30), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the problem class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(31), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Scanner class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(32), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ContextDependentUriFragment class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(33), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ContextDependentUriFragmentFactory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(34), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DelegatingResolveResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(35), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DummyEObject class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(36), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ElementMapping class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(37), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the FuzzyResolveResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(38), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DefaultTokenResolver class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(39), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LocationMap class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(40), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ReferenceResolveResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(41), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TokenResolveResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(42), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the UriMapping class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(43), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the HoverTextProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(44), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ParseResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(45), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the AntlrTokenHelper class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(46), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the BracketSet class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(47), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the BrowserInformationControl class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(48), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the CodeFoldingManager class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(49), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ColorManager class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(50), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the CompletionProcessor class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(51), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ParsingStrategy class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(52), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DocBrowserInformationControlInput class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(53), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EditorConfiguration class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(54), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Editor class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(55), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EObjectSelection class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(56), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Highlighting class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(57), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the HtmlPrinter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(58), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Hyperlink class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(59), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the HyperlinkDetector class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(60), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the MarkerHelper class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(61), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Occurrence class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(62), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the OutlinePage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(63), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the OutlinePageTreeViewer class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(64), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PluginActivator class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(65), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PositionCategory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(66), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PositionHelper class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(67), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PropertySheetPage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(68), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TextHover class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(69), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TokenScanner class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(70), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the BracketPreferencePage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(71), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PreferenceConstants class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(72), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the OccurrencePreferencePage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(73), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PixelConverter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(74), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PreferenceInitializer class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(75), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SyntaxColoringHelper class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(76), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SyntaxColoringPreferencePage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(77), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IInputStreamProcessorProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(78), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the InputStreamProcessor class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(79), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IOptionProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(80), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IOptions class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(81), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IResourcePostProcessor class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(82), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IResourcePostProcessorProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(83), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IBracketPair class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(84), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ICommand class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(85), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IConfigurable class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(86), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IContextDependentUriFragment class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(87), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IContextDependentUriFragmentFactory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(88), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IElementMapping class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(89), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IExpectedElement class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(90), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IHoverTextProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(91), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ILocationMap class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(92), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IParseResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(93), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IProblem class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(94), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IReferenceMapping class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(95), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IReferenceResolver class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(96), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IReferenceResolveResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(97), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IReferenceResolverSwitch class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(98), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITextDiagnostic class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(99), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITextParser class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(100), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITextPrinter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(101), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITextResource class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(102), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IMetaInformation class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(103), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITextResourcePluginPart class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(104), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITextScanner class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(105), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITextToken class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(106), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITokenResolver class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(107), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITokenResolveResult class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(108), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITokenResolverFactory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(109), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ITokenStyle class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(110), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IUriMapping class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(111), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EProblemType class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(112), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the CodeCompletionHelper class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(113), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ExpectedCsString class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(114), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ExpectedStructuralFeature class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(115), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the CastUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(116), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the CopiedEList class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(117), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the CopiedEObjectInternalEList class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(118), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EClassUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(119), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EObjectUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(120), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ListUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(121), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the MapUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(122), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the MinimalModelHelper class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(123), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ResourceUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(124), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the StreamUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(125), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the StringUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(126), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TextResourceUtil class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(127), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the UnicodeConverter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(128), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the AbstractExpectedElement class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(129), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the NewFileWizardPage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(130), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IBackgroundParsingListener class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(131), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TerminateParsingException class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(132), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the UnexpectedContentTypeException class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(133), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TextToken class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(134), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder where EMFText shall store the generated classes of the resource plug-in in. All classes for which the <code>override</code> option is set to <code>true</code> will be stored in this folder."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(135), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the extension point schema for default load options is not overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(136), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the extension point schema for additional parsers is not overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(137), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ResourceFactoryDelegator class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(138), 
		   source, 
		   new String[] {
			 "documentation", "The plug-in containing the resource implementation for the DSL (if different from the generated resource plug-in). By default this option is not set, which means that the generated resource plug-in provides the resource implementation."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(139), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PreferencePage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(140), 
		   source, 
		   new String[] {
			 "documentation", "Sets the ID for the generated common ANTLR runtime plug-in. The default value for this option is <code>org.emftext.commons.antlr3_3_0</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(141), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, no ANTLR common runtime plug-in is generated. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(142), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TokenStyleInformationProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(143), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the FoldingInformationProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(144), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the BracketInformationProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(145), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SyntaxCoverageInformationProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(146), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, the generated EMF resource will save only resource when their content (text) has actually changed. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(147), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the NewFileContentProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(148), 
		   source, 
		   new String[] {
			 "documentation", "A URI pointing to a text file that contains a header which shall be added to all generated Java files. This option is useful to include copyright statements in the generated classes. If this option is not set, a default (empty) header is added to all generated Java classes."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(149), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ExpectedTerminal class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(150), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the CompletionProposal class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(151), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Builder class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(152), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the BuilderAdapter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(153), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IBuilder class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(154), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Nature class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(155), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated plug-in IDs, which will be added to the manifest of the generated resource plug-in. The default value for this option is an empty list."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(156), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, the builder that is generated and registered by default will not be registered anymore. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(157), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated packages, which will be added as exports to the manifest of the generated resource plug-in. The default value for this option is an empty list."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(158), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Pair class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(159), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the AbstractInterpreter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(160), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the GrammarInformationProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(161), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the AttributeValueProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(162), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the FollowSetProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(163), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SyntaxElement class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(164), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Keyword class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(165), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Placeholder class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(166), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Cardinality class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(167), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Printer2 class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(168), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Choice class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(169), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Compound class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(170), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Containment class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(171), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LineBreak class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(172), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Sequence class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(173), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the WhiteSpace class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(174), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SyntaxElementDecorator class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(175), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IReferenceCache class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(176), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DefaultHoverTextProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(177), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the FormattingElement class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(178), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Terminal class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(179), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LayoutInformationAdapter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(180), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LayoutInformation class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(181), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the classic printer (i.e., the one used before EMFText 1.3.0) will be used. Otherwise the new printer implementation is used. In any case both printers are generated, but only one is used. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(182), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, constraint validation using registered EValidators will be enabled. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(183), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, constraint validation using the EMF Validation Framework is disabled. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(184), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the MetaInformation class of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(185), 
		   source, 
		   new String[] {
			 "documentation", "The ID of the generated resource UI plug-in. The resource UI plug-in is stored in a folder that is equal to this ID."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(186), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the plug-in activator class of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(187), 
		   source, 
		   new String[] {
			 "documentation", "The package where to store all classes of the resource UI plug-in in. If this option is not set, the default value is determined by adding the suffix <code>resource.FILE_EXTENSION.ui</code> to the base package of the generator model."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(188), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated plug-in IDs, which will be added to the manifest of the generated resource UI plug-in. The default value for this option is an empty list."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(189), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated packages, which will be added as exports to the manifest of the generated resource UI plug-in. The default value for this option is an empty list."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(190), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the manifest of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(191), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the build.properties file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(192), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the .classpath file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(193), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the .project file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(194), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder where EMFText shall store the customizable classes of the resource UI plug-in in. All classes for which the <code>override</code> option is set to <code>false</code> will be stored in this folder."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(195), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder EMFText shall store the generated classes of the resource UI plug-in in. All classes for which the <code>override</code> option is set to <code>true</code> will be stored in this folder."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(196), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, EMFText will not generate the resource UI plug-in. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(197), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IBracketHandler class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(198), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the plugin.xml file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(199), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ProposalPostProcessor class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(200), 
		   source, 
		   new String[] {
			 "documentation", "Disables the automatic sorting of tokens. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(201), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IQuickFix class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(202), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the QuickFix class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(203), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the AnnotationModel class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(204), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, AnnotationModelFactory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(205), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the MarkerAnnotation class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(206), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the MarkerResolutionGenerator class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(207), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the QuickAssistAssistant class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(208), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the QuickAssistProcessor class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(209), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ImageProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(210), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the TokenStyle class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(211), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DynamicTokenStyler class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(212), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the generated resource class will not resolve references after parsing. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(213), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ExpectedBooleanTerminal class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(214), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the BooleanTerminal class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(215), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EnumerationTerminal class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(216), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ExpectedEnumerationTerminal class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(217), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ChangeReferenceQuickFix class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(218), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EProblemSeverity class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(219), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the ResourcePostProcessor class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(220), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IResourceProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(221), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IBracketHandlerProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(222), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IAnnotationModelProvider class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(223), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LaunchConfigurationDelegate class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(224), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LaunchConfigurationTabGroup class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(225), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LaunchConfigurationMainTab class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(226), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LaunchShortcurt class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(227), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the PropertyTester class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(228), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, code that is required to support launching of DSL models is not generated. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(229), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the Rule class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(230), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the AbstractDebuggable class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(231), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the EDebugMessage enumeration will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(232), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IDebugEventListener interface will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(233), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the IInterpreterListener interface will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(234), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugCommunicationHandler class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(235), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugElement class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(236), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebuggableInterpreter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(237), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebuggerListener class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(238), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugMessage class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(239), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugProcess class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(240), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugProxy class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(241), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugTarget class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(242), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugThread class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(243), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugValue class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(244), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugVariable class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(245), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LinebreakPoint class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(246), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SourceLocator class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(247), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SourceLookupParticipant class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(248), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the SourcePathComputerDelegate class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(249), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the StackFrame class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(250), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>true</code>, code that is required to support debugging of DSL models is not generated. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(251), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the DebugModelPresentation class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(252), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the LineBreakpointAdapter class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(253), 
		   source, 
		   new String[] {
			 "documentation", "If set to <code>false</code>, the AdapterFactory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (tokenStyleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Defines syntax highlighting for tokens or keywords."
		   });		
		addAnnotation
		  (getTokenStyle_TokenNames(), 
		   source, 
		   new String[] {
			 "documentation", "The names of the tokens or the keywords this style is applied to."
		   });		
		addAnnotation
		  (getTokenStyle_Rgb(), 
		   source, 
		   new String[] {
			 "documentation", "The color to show the tokens and keywords in."
		   });		
		addAnnotation
		  (getTokenStyle_FontStyles(), 
		   source, 
		   new String[] {
			 "documentation", "The font styles to use for the tokens and keywords."
		   });		
		addAnnotation
		  (annotationEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfor ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : getParameters()) {\r\n\t\t\tif (key.equals(parameter.getKey())){\r\n\t\t\t\t java.lang.String value = parameter.getValue();\r\n\t\t\t\treturn value;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn null;\r\n",
			 "documentation", "Returns the annotation value for the given key."
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tif (!get_qualifiedInterfaceNameCache().containsKey(genClass)) {\r\n\t\t\t java.lang.String qualifiedInterfaceName = genClass.getQualifiedInterfaceName();\r\n\t\t\tget_qualifiedInterfaceNameCache().put(genClass, qualifiedInterfaceName);\r\n\t\t}\r\n\r\n\t\treturn get_qualifiedInterfaceNameCache().get(genClass);\r\n",
			 "documentation", "Return the qualified name of the interface for the given GenClass."
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.lang.String interfaceName = getQualifiedInterfaceName(genClass);\r\n\r\n\t\t java.lang.String escapedName = interfaceName.replace(\"_\", \"_005f\");\r\n\r\n\t\tescapedName = escapedName.replace(\".\", \"_\");\r\n\r\n\t\treturn escapedName;\r\n",
			 "documentation", "\r\n Return an esacped version of the qualified name of the interface for \r\n the given GenClass. Underscores and dots are replaced to be able to use \r\n the returned name, for example, as method name.\r\n"
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn java.util.Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName());\r\n",
			 "documentation", "Checks whether the given GenClass has a map type."
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfor ( org.eclipse.emf.codegen.ecore.genmodel.GenClass entry : list) {\r\n\t\t\t org.eclipse.emf.ecore.EClass entryClass = entry.getEcoreClass();\r\n\t\t\t org.eclipse.emf.ecore.EClass oClass = genClass.getEcoreClass();\r\n\t\t\tif (entryClass.getName().equals(oClass.getName())\r\n\t\t\t\t\t&& entryClass.getEPackage().getNsURI().equals(\r\n\t\t\t\t\t\t\toClass.getEPackage().getNsURI())) {\r\n\t\t\t\treturn true;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n",
			 "documentation", "Checks whether the given list of GenClasses contains a GenClass\r\nwith the same name and namespace URI as the given GenClass."
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfor ( org.eclipse.emf.ecore.EClass superClassCandidate : subClassCandidate.getEAllSuperTypes()) {\r\n\t\t\t// There seem to be multiple instances of meta classes when accessed\r\n\t\t\t// through the generator model. Therefore, we compare by name.\r\n\t\t\tif (namesAndPackageURIsAreEqual(superClassCandidate, superClass)) {\r\n\t\t\t\treturn true;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.ecore.EClass> result = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.ecore.EClass>();\r\n\r\n\t\tfor ( org.eclipse.emf.ecore.EClass next : availableClasses) {\r\n\t\t\tif (isSubClass(next, superClass) &&\r\n\t\t\t\tisConcrete(next)) {\r\n\t\t\t\tresult.add(next);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn result;\r\n",
			 "documentation", "\r\n Returns all subclasses of \'superClass\' that are contained\r\n in \'availableClasses\'.\r\n \r\n @param superClass the superclass\r\n @param availableClasses the set of classes to search in\r\n @return a list of all subclasses of \'superClass\'\r\n"
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn namesAreEqual(classA, classB) && \r\n\t\t\tpackageURIsAreEqual(classA, classB);\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.lang.String nsURI_A = classA.getEPackage().getNsURI();\r\n\r\n\t\t java.lang.String nsURI_B = classB.getEPackage().getNsURI();\r\n\r\n\t\treturn (nsURI_A == null && nsURI_B == null) || nsURI_A.equals(nsURI_B);\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn classA.getName().equals(classB.getName());\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn !eClass.isAbstract() && !eClass.isInterface();\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\treturn !isConcrete(eClass);\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t// add default styles\r\n\t\taddTokenStylesForKeywords(syntax, allStyles);\r\n\r\n\t\taddTokenStylesForQuotedTokens(syntax, allStyles);\r\n\r\n\t\taddTokenStylesForComments(syntax, allStyles);\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t/**\r\n\t\t * All CsStrings that match this regular expression will be recognized\r\n\t\t * as keywords and a default token style (purple and bold face font) \r\n\t\t * will be assigned.\r\n\t\t */\r\n\t\tfinal  java.util.regex.Pattern KEYWORD_PATTERN =  java.util.regex.Pattern.compile(getKeywordRegex());\r\n\r\n\t\tfinal  java.lang.String KEYWORD_COLOR = \"800055\";\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {\r\n\t\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.CsString> csStrings = getAllKeywords(rule);\r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.CsString csString : csStrings) {\r\n\t\t\t\tif (KEYWORD_PATTERN.matcher(csString.getValue()).matches()) {\r\n\t\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\t\tnewStyle.setRgb(KEYWORD_COLOR);\r\n\t\t\t\t\tnewStyle.getTokenNames().add(csString.getValue());\r\n\t\t\t\t\tnewStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle.BOLD);\r\n\t\t\t\t\tsyntax.addTokenStyle(allStyles, newStyle);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t java.lang.String QUOTED_TOKEN_COLOR = \"2A00FF\";\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {\r\n\t\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> placeholders = getAllPlaceholdersInQuotes(rule);\r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.PlaceholderInQuotes placeholder : placeholders) {\r\n\t\t\t\t org.emftext.sdk.concretesyntax.ReferencableTokenDefinition token = placeholder.getToken();\r\n\t\t\t\tif (token == null) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\t\t\t\t java.lang.String tokenName = token.getName();\r\n\r\n\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\tnewStyle.setRgb(QUOTED_TOKEN_COLOR);\r\n\t\t\t\tnewStyle.getTokenNames().add(tokenName);\r\n\t\t\t\tsyntax.addTokenStyle(allStyles, newStyle);\r\n\t\t\t}\r\n\t\t}\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfinal  java.lang.String SL_COMMENT = \"\'//\'(~(\'\\n\'|\'\\r\'|\'\\uffff\'))*\";\r\n\r\n\t\tfinal  java.lang.String ML_COMMENT = \"\'/*\'.*\'*/\'\";\r\n\r\n\t\treturn SL_COMMENT.equals(regex) || ML_COMMENT.equals(regex);\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfinal  java.lang.String COMMENT_COLOR = \"3F805D\";\r\n\r\n\t\t java.util.Collection< org.emftext.sdk.concretesyntax.CompleteTokenDefinition> tokens = syntax.getActiveTokens();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.CompleteTokenDefinition tokenDefinition : tokens) {\r\n\t\t\t java.lang.String regex = tokenDefinition.getRegex();\r\n\t\t\tif (isCommentPattern(regex)) {\r\n\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\tnewStyle.setRgb(COMMENT_COLOR);\r\n\t\t\t\tnewStyle.getTokenNames().add(tokenDefinition.getName());\r\n\t\t\t\tsyntax.addTokenStyle(allStyles, newStyle);\r\n\t\t\t}\r\n\t\t}\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.CsString> allKeywords = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.CsString>();\r\n\r\n\t\t org.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();\r\n\r\n\t\twhile (iterator.hasNext()) {\r\n\t\t\t org.eclipse.emf.ecore.EObject next = iterator.next();\r\n\t\t\tif (next instanceof  org.emftext.sdk.concretesyntax.CsString) {\r\n\t\t\t\tallKeywords.add(( org.emftext.sdk.concretesyntax.CsString) next);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn allKeywords;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> allPlaceholders = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes>();\r\n\r\n\t\t org.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();\r\n\r\n\t\twhile (iterator.hasNext()) {\r\n\t\t\t org.eclipse.emf.ecore.EObject next = iterator.next();\r\n\t\t\tif (next instanceof  org.emftext.sdk.concretesyntax.PlaceholderInQuotes) {\r\n\t\t\t\tallPlaceholders.add(( org.emftext.sdk.concretesyntax.PlaceholderInQuotes) next);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn allPlaceholders;\r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (defaultTokenStyleAdderEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "body", "\r\n\t\tfinal  java.lang.String KEYWORD_REGEX = \"([a-z]|[A-Z])|(([a-z]|[A-Z]|[_])([a-z]|[A-Z]|[:]|[-]|[_])+)\";\r\n\r\n\t\treturn KEYWORD_REGEX;\r\n",
			 "documentation", ""
		   });
	}

} //ConcretesyntaxPackageImpl
