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
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.AtomicRegex;
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
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EClassUtil;
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
	private EClass cardinalityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass starEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass questionmarkEClass = null;

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
	private EClass optionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractEClass = null;

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
	public EReference getConcreteSyntax_Modifier() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax_Name() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_StartSymbols() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_ActiveTokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Imports() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Options() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Tokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_SyntheticTokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_TokenStyles() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_AllTokenStyles() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_AllTokenDirectives() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Rules() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax__operatorRules() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax__operatorRuleSubsets() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax__operatorRulesInitialized() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax__genClassCache() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax__eClassUtil() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(16);
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
	public EReference getCardinalityDefinition_Cardinality() {
		return (EReference)cardinalityDefinitionEClass.getEStructuralFeatures().get(0);
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
	public EClass getCardinality() {
		return cardinalityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPLUS() {
		return plusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTAR() {
		return starEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQUESTIONMARK() {
		return questionmarkEClass;
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
	public EClass getAbstract() {
		return abstractEClass;
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
	public EAttribute getTokenStyle_TokenName() {
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
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__MODIFIER);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__NAME);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__START_SYMBOLS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ACTIVE_TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__IMPORTS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__OPTIONS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__SYNTHETIC_TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TOKEN_STYLES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ALL_TOKEN_STYLES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__RULES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULES);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__GEN_CLASS_CACHE);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ECLASS_UTIL);

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
		createEReference(cardinalityDefinitionEClass, CARDINALITY_DEFINITION__CARDINALITY);

		terminalEClass = createEClass(TERMINAL);
		createEReference(terminalEClass, TERMINAL__FEATURE);

		csStringEClass = createEClass(CS_STRING);
		createEAttribute(csStringEClass, CS_STRING__VALUE);

		whiteSpacesEClass = createEClass(WHITE_SPACES);
		createEAttribute(whiteSpacesEClass, WHITE_SPACES__AMOUNT);

		lineBreakEClass = createEClass(LINE_BREAK);
		createEAttribute(lineBreakEClass, LINE_BREAK__TAB);

		cardinalityEClass = createEClass(CARDINALITY);

		plusEClass = createEClass(PLUS);

		starEClass = createEClass(STAR);

		questionmarkEClass = createEClass(QUESTIONMARK);

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

		optionEClass = createEClass(OPTION);
		createEAttribute(optionEClass, OPTION__TYPE);
		createEAttribute(optionEClass, OPTION__VALUE);

		abstractEClass = createEClass(ABSTRACT);

		tokenStyleEClass = createEClass(TOKEN_STYLE);
		createEAttribute(tokenStyleEClass, TOKEN_STYLE__TOKEN_NAME);
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

		// Create enums
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
		plusEClass.getESuperTypes().add(this.getCardinality());
		starEClass.getESuperTypes().add(this.getCardinality());
		questionmarkEClass.getESuperTypes().add(this.getCardinality());
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
		tokenRedefinitionEClass.getESuperTypes().add(this.getReferencableTokenDefinition());
		tokenRedefinitionEClass.getESuperTypes().add(this.getTokenDirective());
		quotedTokenDefinitionEClass.getESuperTypes().add(this.getCompleteTokenDefinition());
		tokenPriorityDirectiveEClass.getESuperTypes().add(this.getTokenDirective());
		containmentEClass.getESuperTypes().add(this.getTerminal());
		placeholderEClass.getESuperTypes().add(this.getTerminal());
		placeholderUsingSpecifiedTokenEClass.getESuperTypes().add(this.getPlaceholder());
		placeholderUsingDefaultTokenEClass.getESuperTypes().add(this.getPlaceholder());
		placeholderInQuotesEClass.getESuperTypes().add(this.getPlaceholder());

		// Initialize classes and features; add operations and parameters
		initEClass(genPackageDependentElementEClass, GenPackageDependentElement.class, "GenPackageDependentElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenPackageDependentElement_Package(), theGenModelPackage.getGenPackage(), null, "package", null, 1, 1, GenPackageDependentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenPackageDependentElement_PackageLocationHint(), theEcorePackage.getEString(), "packageLocationHint", null, 0, 1, GenPackageDependentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteSyntaxEClass, ConcreteSyntax.class, "ConcreteSyntax", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcreteSyntax_Modifier(), this.getAbstract(), null, "modifier", null, 0, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax_Name(), ecorePackage.getEString(), "name", null, 1, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_StartSymbols(), theGenModelPackage.getGenClass(), null, "startSymbols", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_ActiveTokens(), this.getCompleteTokenDefinition(), null, "activeTokens", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Imports(), this.getImport(), null, "imports", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Options(), this.getOption(), null, "options", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Tokens(), this.getTokenDirective(), null, "tokens", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_SyntheticTokens(), this.getCompleteTokenDefinition(), null, "syntheticTokens", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_TokenStyles(), this.getTokenStyle(), null, "tokenStyles", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_AllTokenStyles(), this.getTokenStyle(), null, "allTokenStyles", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_AllTokenDirectives(), this.getTokenDirective(), null, "allTokenDirectives", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Rules(), this.getRule(), this.getRule_Syntax(), "rules", null, 1, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax__operatorRules(), this.getRule(), null, "_operatorRules", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax__operatorRuleSubsets(), theEcorePackage.getEString(), "_operatorRuleSubsets", "", 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax__operatorRulesInitialized(), theEcorePackage.getEBoolean(), "_operatorRulesInitialized", null, 0, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax__genClassCache(), this.getGenClassCache(), null, "_genClassCache", null, 1, 1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax__eClassUtil(), this.getEClassUtil(), null, "_eClassUtil", null, 0, 1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(concreteSyntaxEClass, this.getRule(), "getOperatorRuleSubset", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "identifier", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, theGenModelPackage.getGenClass(), "getActiveStartSymbols", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getRule(), "getAllRules", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getRule(), "getOperatorRules", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, null, "initialiseAnnotatedOperatorRules", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, theEcorePackage.getEString(), "getOperatorRuleSubsets", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getGenClassCache(), "getGenClassCache", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, theEcorePackage.getEBoolean(), "isAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, theEcorePackage.getEBoolean(), "isImportedRule", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRule(), "rule", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(concreteSyntaxEClass, this.getEClassUtil(), "getEClassUtil", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, theGenModelPackage.getGenClass(), "getClassesWithSyntax", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "excludeOperatorRules", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(concreteSyntaxEClass, theGenModelPackage.getGenClass(), "getSubClassesWithSyntax", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "superClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEBoolean(), "excludeOperatorRules", 0, 1, IS_UNIQUE, IS_ORDERED);

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
		initEReference(getCardinalityDefinition_Cardinality(), this.getCardinality(), null, "cardinality", null, 0, 1, CardinalityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(cardinalityEClass, Cardinality.class, "Cardinality", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(plusEClass, org.emftext.sdk.concretesyntax.PLUS.class, "PLUS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(starEClass, org.emftext.sdk.concretesyntax.STAR.class, "STAR", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(questionmarkEClass, org.emftext.sdk.concretesyntax.QUESTIONMARK.class, "QUESTIONMARK", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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

		initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOption_Type(), this.getOptionTypes(), "type", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOption_Value(), ecorePackage.getEString(), "value", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractEClass, Abstract.class, "Abstract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tokenStyleEClass, TokenStyle.class, "TokenStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTokenStyle_TokenName(), theEcorePackage.getEString(), "tokenName", null, 1, 1, TokenStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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

		// Initialize enums and add enum literals
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
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_OCCURENCE);
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
		addEEnumLiteral(optionTypesEEnum, OptionTypes.OVERRIDE_OCCURENCE_PREFERENCE_PAGE);
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
		  (concreteSyntaxEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Rule > subset = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.Rule > ( ) ; \r\nif ( identifier == null ) { \r\n\treturn subset ; \r\n} \r\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getOperatorRules ( ) ) { \r\n\torg.emftext.sdk.concretesyntax.Annotation annotation = rule .getOperatorAnnotation ( ) ; \r\n\tjava.lang.String value = annotation .getValue ( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty .SUPERCLASS .toString ( ) ) ; \r\n\tif ( identifier .equals ( value ) ) { \r\n\t\tsubset .add ( rule ) ; \r\n\t} \r\n} \r\nreturn subset ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > symbols = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > ( ) ; \r\nsymbols .addAll ( getStartSymbols ( ) ) ; \r\nif ( symbols .size ( ) > 0 ) { \r\n\treturn symbols ; \r\n} \r\norg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Import > imports = getImports ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports ) { \r\n\tfinal org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement .getConcreteSyntax ( ) ; \r\n\tif ( importedSyntax != null ) { \r\n\t\tsymbols .addAll ( importedSyntax .getActiveStartSymbols ( ) ) ; \r\n\t} \r\n} \r\nreturn symbols ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "//EStructuralFeature eFeature = ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES;\norg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Rule > l = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.Rule > ( getRules ( ) .size ( ) ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules ( ) ) { \r\n\t// don\'t add rules that are @override rules with remove=true\nif ( ! rule .isOverrideRemoveRule ( ) ) { \r\n\t\tl .add ( rule ) ; \r\n\t} \r\n} \r\nfor ( org.emftext.sdk.concretesyntax.Import aImport : getImports ( ) ) { \r\n\torg.emftext.sdk.concretesyntax.ConcreteSyntax importedCS = aImport .getConcreteSyntax ( ) ; \r\n\tif ( importedCS != null ) { \r\n\t\touter : for ( org.emftext.sdk.concretesyntax.Rule importedRule : importedCS .getAllRules ( ) ) { \r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules ( ) ) { \r\n\t\t\t\t// don\'t add rules that have @override rules for same\n// meta-class\nif ( rule .isOverrideRule ( importedRule .getMetaclass ( ) ) ) { \r\n\t\t\t\t\tcontinue outer ; \r\n\t\t\t\t} \r\n\t\t\t} \r\n\t\t\tl .add ( importedRule ) ; \r\n\t\t} \r\n\t} \r\n} \r\nreturn org.eclipse.emf.common.util.ECollections .unmodifiableEList ( l ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "initialiseAnnotatedOperatorRules ( ) ; \r\nreturn get_operatorRules ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "if ( is_operatorRulesInitialized ( ) ) { \r\n\treturn ; \r\n} \r\nset_operatorRulesInitialized ( true ) ; \r\njava.util.List < org.emftext.sdk.concretesyntax.Rule > operatorRules = getOperatorRules ( ) ; \r\njava.util.List < java.lang.String > operatorRuleSubsets = getOperatorRuleSubsets ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getAllRules ( ) ) { \r\n\torg.emftext.sdk.concretesyntax.Annotation operatorAnnotation = rule .getOperatorAnnotation ( ) ; \r\n\tif ( operatorAnnotation != null ) { \r\n\t\tboolean added = false ; \r\n\t\tfor ( java.util.ListIterator < org.emftext.sdk.concretesyntax.Rule > it = operatorRules .listIterator ( ) ; it .hasNext ( ) ; ) { \r\n\t\t\torg.emftext.sdk.concretesyntax.Rule expressionRule = it .next ( ) ; \r\n\t\t\tif ( expressionRule .getOperatorWeight ( ) > rule .getOperatorWeight ( ) ) { \r\n\t\t\t\toperatorRules .add ( it .previousIndex ( ) , rule ) ; \r\n\t\t\t\tadded = true ; \r\n\t\t\t\tbreak ; \r\n\t\t\t} \r\n\t\t} \r\n\t\tif ( ! added ) { \r\n\t\t\toperatorRules .add ( rule ) ; \r\n\t\t} \r\n\t\tjava.lang.String identifier = operatorAnnotation .getValue ( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty .SUPERCLASS .toString ( ) ) ; \r\n\t\toperatorRuleSubsets .add ( identifier ) ; \r\n\t} \r\n} \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "initialiseAnnotatedOperatorRules ( ) ; \r\nreturn get_operatorRuleSubsets ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "if ( get_genClassCache ( ) == null ) { \r\n\tset_genClassCache ( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createGenClassCache()) ; \r\n} \r\nreturn get_genClassCache ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "body", "if ( getModifier ( ) != null ) { \r\n\treturn true ; \r\n} \r\nreturn false ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "body", "return rule .getSyntax ( ) != this ; \r\n",
			 "documentation", "\r\n Returns true if the given rule was defined in the given syntax.\r\n If the rule is defined in an imported syntax, this method returns\r\n false.\r\n \r\n @param syntax the syntax that refers to the rule\r\n @param rule the rule to check\r\n @return true if the rule is contained, false if it is imported\r\n"
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "body", "if ( get_eClassUtil ( ) == null ) { \r\n\tset_eClassUtil ( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEClassUtil()) ; \r\n} \r\nreturn get_eClassUtil ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "body", "java.util.Collection < org.emftext.sdk.concretesyntax.Rule > rules = getAllRules ( ) ; \r\norg.eclipse.emf.common.util.EList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > foundGenClasses = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Rule rule : rules ) { \r\n\tif ( excludeOperatorRules && rule .getOperatorAnnotation ( ) != null ) { \r\n\t\tcontinue ; \r\n\t} \r\n\torg.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand = rule .getMetaclass ( ) ; \r\n\tfoundGenClasses .add ( subClassCand ) ; \r\n} \r\nreturn foundGenClasses ; \r\n",
			 "documentation", "\r\n Collects all the subclasses for which concrete syntax is defined.\r\n"
		   });		
		addAnnotation
		  (concreteSyntaxEClass.getEOperations().get(11), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > subClasses = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > ( ) ; \r\norg.eclipse.emf.ecore.EClass ecoreClass = superClass .getEcoreClass ( ) ; \r\norg.emftext.sdk.concretesyntax.EClassUtil eClassUtil = getEClassUtil ( ) ; \r\nfor ( org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand : getClassesWithSyntax ( excludeOperatorRules ) ) { \r\n\tif ( eClassUtil .isSubClass ( subClassCand .getEcoreClass ( ) , ecoreClass ) ) { \r\n\t\tsubClasses .add ( subClassCand ) ; \r\n\t} \r\n} \r\nreturn subClasses ; \r\n",
			 "documentation", "\r\n Collects all the subclasses for which concrete syntax is defined.\r\n"
		   });		
		addAnnotation
		  (syntaxElementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.emftext.sdk.concretesyntax.Rule rule = null ; \r\norg.eclipse.emf.ecore.EObject o = this ; \r\ndo { \r\n\tif ( o instanceof org.emftext.sdk.concretesyntax.Rule ) { \r\n\t\trule = ( org.emftext.sdk.concretesyntax.Rule ) o ; \r\n\t} else { \r\n\t\to = o .eContainer ( ) ; \r\n\t} \r\n} while ( rule == null && o != null ) ; \r\nreturn rule ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "for ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations ( ) ) { \r\n\tif ( annotation .getType ( ) == org.emftext.sdk.concretesyntax.AnnotationType .OPERATOR ) { \r\n\t\treturn annotation ; \r\n\t} \r\n} \r\nreturn null ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = this .getOperatorAnnotation ( ) ; \r\nif ( operatorAnnotation != null ) { \r\n\tjava.lang.String ruleWeightString = operatorAnnotation .getValue ( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty .WEIGHT .toString ( ) ) ; \r\n\tif ( ruleWeightString != null ) { \r\n\t\ttry { \r\n\t\t\treturn java.lang.Integer .parseInt ( ruleWeightString ) ; \r\n\t\t} // ignore exception. invalid numbers are signaled by\n// returning MIN_VALUE\ncatch ( java.lang.NumberFormatException e ) { \r\n\t\t} \r\n\t} \r\n} \r\nreturn java.lang.Integer .MIN_VALUE ; \r\n",
			 "documentation", "\r\n Returns the weight of this rule if it is an operator rule.\r\n If the rule is not an operator rule or the specified weight\r\n in the operator annotation is not a number, Integer.MIN_VALUE \r\n is returned.\r\n"
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.SyntaxElement > children = getChildren ( ) ; \r\n// there should be at most one child\nassert children == null || children .size ( ) == 1 ; \r\nif ( children .size ( ) > 0 ) { \r\n\torg.emftext.sdk.concretesyntax.SyntaxElement firstChild = children .get ( 0 ) ; \r\n\tif ( firstChild instanceof org.emftext.sdk.concretesyntax.Choice ) { \r\n\t\treturn ( org.emftext.sdk.concretesyntax.Choice ) firstChild ; \r\n\t} else { \r\n\t\t// there should be no element other than Choice\nassert false ; \r\n\t\treturn null ; \r\n\t} \r\n} \r\nreturn null ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "for ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations ( ) ) { \r\n\tif ( annotation .getType ( ) == type ) { \r\n\t\tif ( key != null ) { \r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : annotation .getParameters ( ) ) { \r\n\t\t\t\tif ( key .equals ( parameter .getKey ( ) ) && parameter .getValue ( ) .equals ( value ) ) { \r\n\t\t\t\t\treturn true ; \r\n\t\t\t\t} \r\n\t\t\t} \r\n\t\t} else { \r\n\t\t\treturn true ; \r\n\t\t} \r\n\t} \r\n} \r\nreturn false ; \r\n",
			 "documentation", "\r\n Checks whether this rule is annotated with the given AnnotationType.\r\n If a key and a value is given it is further checked whether the\r\n annotation specifies this key and value. \r\n"
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "// TODO mseifert: use constant here\nreturn hasAnnotation ( org.emftext.sdk.concretesyntax.AnnotationType .OVERRIDE , \"remove\" , \"true\" ) ; \r\n",
			 "documentation", "\r\n Checks whether this rule is annotated with @Override(remove=\"true\").\r\n"
		   });		
		addAnnotation
		  (ruleEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "// TODO figure out why \'metaClass == null\' is needed\nif ( metaClass == null || getMetaclass ( ) == metaClass ) { \r\n\tif ( hasAnnotation ( org.emftext.sdk.concretesyntax.AnnotationType .OVERRIDE , null , null ) ) { \r\n\t\treturn true ; \r\n\t} \r\n} \r\nreturn false ; \r\n",
			 "documentation", "\r\n Checks whether this rule is annotated with @Override.\r\n"
		   });		
		addAnnotation
		  (choiceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Sequence > options = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.Sequence > ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.SyntaxElement child : getChildren ( ) ) { \r\n\tif ( child instanceof org.emftext.sdk.concretesyntax.Sequence ) { \r\n\t\toptions .add ( ( org.emftext.sdk.concretesyntax.Sequence ) child ) ; \r\n\t} else { \r\n\t\t// there should be no elements other than Sequence elements in the\n// list of children\nassert false ; \r\n\t} \r\n} \r\nreturn options ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (sequenceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Definition > parts = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.Definition > ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.SyntaxElement child : getChildren ( ) ) { \r\n\tif ( child instanceof org.emftext.sdk.concretesyntax.Definition ) { \r\n\t\tparts .add ( ( org.emftext.sdk.concretesyntax.Definition ) child ) ; \r\n\t} else { \r\n\t\t// there should be no elements other than Definition elements in the\n// list of children\nassert false ; \r\n\t} \r\n} \r\nreturn parts ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (definitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "return true ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (definitionEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "return false ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (definitionEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "org.emftext.sdk.concretesyntax.Cardinality cardinality = null ; \r\nif ( this instanceof org.emftext.sdk.concretesyntax.CardinalityDefinition ) { \r\n\tcardinality = ( ( org.emftext.sdk.concretesyntax.CardinalityDefinition ) this ) .getCardinality ( ) ; \r\n} \r\nif ( cardinality == null ) { \r\n\treturn \"\" ; \r\n} else if ( cardinality instanceof org.emftext.sdk.concretesyntax.PLUS ) { \r\n\treturn \"+\" ; \r\n} else if ( cardinality instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK ) { \r\n\treturn \"?\" ; \r\n} else { \r\n\treturn \"*\" ; \r\n} \r\n",
			 "documentation", "\r\n Returns a string representation of the cardinality of the\r\n\' or the\r\n empty string.\r\n \r\n @param definition\r\n @return\r\n"
		   });		
		addAnnotation
		  (cardinalityDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "return getCardinality ( ) == null || getCardinality ( ) instanceof org.emftext.sdk.concretesyntax.PLUS ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (cardinalityDefinitionEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "return ! ( getCardinality ( ) instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK || getCardinality ( ) instanceof org.emftext.sdk.concretesyntax.STAR ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (compoundDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.SyntaxElement > children = getChildren ( ) ; \r\n// there should be at most one child\nassert children == null || children .size ( ) == 1 ; \r\nif ( children .size ( ) > 0 ) { \r\n\torg.emftext.sdk.concretesyntax.SyntaxElement firstChild = children .get ( 0 ) ; \r\n\tif ( firstChild instanceof org.emftext.sdk.concretesyntax.Choice ) { \r\n\t\treturn ( org.emftext.sdk.concretesyntax.Choice ) firstChild ; \r\n\t} else { \r\n\t\t// there should be no element other than Choice\nassert false ; \r\n\t\treturn null ; \r\n\t} \r\n} \r\nreturn null ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (regexComposerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "visitedTokens .add ( token ) ; \r\njava.lang.StringBuilder result = new java.lang.StringBuilder ( ) ; \r\nif ( token instanceof org.emftext.sdk.concretesyntax.RegexComposite ) { \r\n\torg.emftext.sdk.concretesyntax.RegexComposite composite = ( org.emftext.sdk.concretesyntax.RegexComposite ) token ; \r\n\tfor ( org.emftext.sdk.concretesyntax.RegexPart part : composite .getRegexParts ( ) ) { \r\n\t\tif ( part instanceof org.emftext.sdk.concretesyntax.AtomicRegex ) { \r\n\t\t\tresult .append ( part .getRegex ( ) ) ; \r\n\t\t} else if ( part instanceof org.emftext.sdk.concretesyntax.RegexReference ) { \r\n\t\t\torg.emftext.sdk.concretesyntax.RegexReference reference = ( org.emftext.sdk.concretesyntax.RegexReference ) part ; \r\n\t\t\torg.emftext.sdk.concretesyntax.AbstractTokenDefinition target = reference .getTarget ( ) ; \r\n\t\t\tif ( target == null ) { \r\n\t\t\t\tcontinue ; \r\n\t\t\t} \r\n\t\t\tif ( target .eIsProxy ( ) ) { \r\n\t\t\t\tcontinue ; \r\n\t\t\t} \r\n\t\t\tif ( visitedTokens .contains ( target ) ) { \r\n\t\t\t\tcontinue ; \r\n\t\t\t} \r\n\t\t\torg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > subVisitedTokens = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > ( ) ; \r\n\t\t\tsubVisitedTokens .addAll ( visitedTokens ) ; \r\n\t\t\tresult .append ( getComposedRegex ( target , subVisitedTokens ) ) ; \r\n\t\t} \r\n\t} \r\n} else if ( token instanceof org.emftext.sdk.concretesyntax.RegexOwner ) { \r\n\torg.emftext.sdk.concretesyntax.RegexOwner owner = ( org.emftext.sdk.concretesyntax.RegexOwner ) token ; \r\n\tresult .append ( owner .getRegex ( ) ) ; \r\n} \r\nreturn result .toString ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (regexCompositeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "java.lang.StringBuilder result = new java.lang.StringBuilder ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.RegexPart part : getRegexParts ( ) ) { \r\n\tresult .append ( part .getRegex ( ) ) ; \r\n} \r\nreturn result .toString ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (atomicRegexEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "return getAtomicExpression ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (regexReferenceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.emftext.sdk.concretesyntax.AbstractTokenDefinition target = getTarget ( ) ; \r\nif ( target == null || target .eIsProxy ( ) ) { \r\n\treturn \"\" ; \r\n} else { \r\n\tassert target instanceof org.emftext.sdk.concretesyntax.RegexOwner ; \r\n\treturn ( ( org.emftext.sdk.concretesyntax.RegexOwner ) target ) .getRegex ( ) ; \r\n} \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (partialTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.emftext.sdk.concretesyntax.RegexComposer composer = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexComposer(); \r\nreturn composer .getComposedRegex ( this , new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > ( ) ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "boolean isReferenced = ! getAttributeReferences ( ) .isEmpty ( ) ; \r\nboolean isCollectInToken = getAttributeName ( ) != null ; \r\nreturn ! isReferenced || isCollectInToken ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "boolean isReferenced = ! getAttributeReferences ( ) .isEmpty ( ) ; \r\nboolean isCollectInToken = getAttributeName ( ) != null ; \r\nreturn isReferenced || isCollectInToken ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "return ! syntax .equals ( getContainingSyntax ( syntax ) ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (completeTokenDefinitionEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.ecore.EObject container = this .eContainer ( ) ; \r\nif ( container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax ) { \r\n\treturn ( org.emftext.sdk.concretesyntax.ConcreteSyntax ) container ; \r\n} \r\nreturn syntax ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (normalTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.emftext.sdk.concretesyntax.RegexComposer composer = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexComposer(); \r\nreturn composer .getComposedRegex ( this , new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > ( ) ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (tokenRedefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.emftext.sdk.concretesyntax.RegexComposer composer = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexComposer(); \r\nreturn composer .getComposedRegex ( this , new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > ( ) ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (quotedTokenDefinitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "return getSynthesizedRegex ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (containmentEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > types = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > ( ) ; \r\n// is there an explicit type defined?\nif ( ! getTypes ( ) .isEmpty ( ) ) { \r\n\ttypes = getTypes ( ) ; \r\n} else { \r\n\ttypes = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > ( ) ; \r\n\ttypes .add ( getFeature ( ) .getTypeGenClass ( ) ) ; \r\n} \r\nreturn types ; \r\n",
			 "documentation", "\r\n Returns all types that are allowed for the given containment.\r\n If type restrictions are specified in the syntax rule, this\r\n list contains the allowed types. If no restriction are present\r\n the type of the feature references by the containment is \r\n returned.\r\n \r\n @param containment\r\n @return\r\n"
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "java.lang.String prefix = getPrefix ( ) ; \r\nif ( prefix == null ) return prefix ; \r\nif ( prefix .length ( ) == 0 ) return null ; \r\nreturn prefix ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "java.lang.String suffix = getSuffix ( ) ; \r\nif ( suffix == null ) return suffix ; \r\nif ( suffix .length ( ) == 0 ) return null ; \r\nreturn suffix ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "java.lang.String escapeCharacter = getEscapeCharacter ( ) ; \r\nif ( escapeCharacter == null ) return escapeCharacter ; \r\nif ( escapeCharacter .length ( ) == 0 ) return null ; \r\nreturn escapeCharacter ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (placeholderInQuotesEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "if ( eIsProxy ( ) ) return super .toString ( ) ; \r\njava.lang.StringBuffer result = new java.lang.StringBuffer ( ) ; \r\norg.eclipse.emf.codegen.ecore.genmodel.GenFeature feature = getFeature ( ) ; \r\nif ( feature != null && feature .getEcoreFeature ( ) != null ) { \r\n\tresult .append ( feature .getName ( ) ) ; \r\n} \r\nresult .append ( \"[\\\'\" ) ; \r\nresult .append ( getPrefix ( ) ) ; \r\nresult .append ( \"\\\', \\\'\" ) ; \r\nresult .append ( getSuffix ( ) ) ; \r\nresult .append ( \"\\\']\" ) ; \r\nreturn result .toString ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, EMFText generate a UI action that can be used to test parsing and printing of files containing textual syntax. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, EMFText automatically generates the model code using the generator model referenced in the CS specification. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the plugin.xml file will be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the manifest of the resource plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Parser class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the token resolver classes will be overridden. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(6), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the reference resolver classes will be overridden. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(7), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the reference resolver switch will be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(8), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the token resolver factory class will be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(9), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the printer will be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(10), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Antlr-backtracking is activated for parser generation. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(11), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Antlr-memoize is activated for parser generation. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(12), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, EMFText will try to fix rules that contain simple left recursion. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(13), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, EMFText will generate a parser that expects an EOF signal at the end of the input stream. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(14), 
		   source, 
		   new String[] {
			 "documentation", "This option can be used to specify the name of the token that is used for non-containment references. A declaration like <code>featureX[]</code> in a CS rule with be replaced by <code>featureX[TOKEN_Y]</code> if the value of this option is <code>TOKEN_Y</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(15), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, EMFText does not automatically provide predefined tokens (TEXT, WHITESPACE, LINEBREAK). The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(16), 
		   source, 
		   new String[] {
			 "documentation", "The (numerical) value of this option defined how many whitespace should be printed between tokens if no whitespace information is given in CS rules."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(17), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, EMFText reloads the generator model before loading it. This is particular useful, when the meta model (i.e., the Ecore file) is changing a lot during language development. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(18), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the .classpath file of the resource plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(19), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the .project file of the resource plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(20), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the text resource class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(21), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the resource factory class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(22), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the new file wizard class will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(23), 
		   source, 
		   new String[] {
			 "documentation", "The name of the parser generator to use."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(24), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder EMFText shall store the overridable classes of the resource plug-in in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(25), 
		   source, 
		   new String[] {
			 "documentation", "The name of the base package EMFText shall store the generated classes or the resource plug-in in."
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
			 "documentation", "If set to false, the build.properties file will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(28), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the MetaInformation class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(29), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the default resolver class will be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(30), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ProblemClass class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(31), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Scanner class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(32), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ContextDependentUriFragment class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(33), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ContextDependentUriFragmentFactory class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(34), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the DelegatingResolveResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(35), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the DummyEObject class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(36), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ElementMapping class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(37), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the FuzzyResolveResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(38), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the DefaultTokenResolver class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(39), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the LocationMap class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(40), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ReferenceResolveResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(41), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the TokenResolveResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(42), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the UriMapping class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(43), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the HoverTextProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(44), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ParseResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(45), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the AntlrTokenHelper class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(46), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the BracketSet class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(47), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the BrowserInformationControl class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(48), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the CodeFoldingManager class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(49), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ColorManager class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(50), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the CompletionProcessor class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(51), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ParsingStrategy class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(52), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the DocBrowserInformationControlInput class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(53), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the EditorConfiguration class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(54), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Editor class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(55), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the EObjectSelection class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(56), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Highlighting class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(57), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the HtmlPrinter class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(58), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Hyperlink class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(59), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the HyperlinkDetector class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(60), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the MarkerHelper class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(61), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Occurence class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(62), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the OutlinePage class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(63), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the OutlinePageTreeViewer class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(64), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PluginActivator class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(65), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PositionCategory class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(66), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PositionHelper class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(67), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PropertySheetPage class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(68), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the TextHover class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(69), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the TokenScanner class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(70), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the BracketPreferencePage class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(71), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PreferenceConstants class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(72), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the OccurencePreferencePage class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(73), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PixelConverter class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(74), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PreferenceInitializer class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(75), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the SyntaxColoringHelper class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(76), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the SyntaxColoringPreferencePage class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(77), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IInputStreamProcessorProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(78), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the InputStreamProcessor class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(79), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IOptionProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(80), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IOptions class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(81), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IResourcePostProcessor class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(82), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IResourcePostProcessorProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(83), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IBracketPair class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(84), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ICommand class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(85), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IConfigurable class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(86), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IContextDependentUriFragment class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(87), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IContextDependentUriFragmentFactory class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(88), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IElementMapping class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(89), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IExpectedElement class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(90), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IHoverTextProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(91), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ILocationMap class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(92), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IParseResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(93), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IProblem class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(94), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IReferenceMapping class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(95), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IReferenceResolver class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(96), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IReferenceResolveResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(97), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IReferenceResolverSwitch class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(98), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITextDiagnostic class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(99), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITextParser class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(100), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITextPrinter class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(101), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITextResource class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(102), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IMetaInformation class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(103), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITextResourcePluginPart class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(104), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITextScanner class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(105), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITextToken class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(106), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITokenResolver class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(107), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITokenResolveResult class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(108), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITokenResolverFactory class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(109), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ITokenStyle class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(110), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IUriMapping class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(111), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the EProblemType class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(112), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the CodeCompletionHelper class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(113), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ExpectedCsString class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(114), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ExpectedStructuralFeature class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(115), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the CastUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(116), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the CopiedEList class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(117), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the CopiedEObjectInternalEList class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(118), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the EClassUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(119), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the EObjectUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(120), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ListUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(121), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the MapUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(122), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the MinimalModelHelper class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(123), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ResourceUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(124), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the StreamUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(125), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the StringUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(126), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the TextResourceUtil class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(127), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the UnicodeConverter class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(128), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the AbstractExpectedElement class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(129), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the NewFileWizardPage class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(130), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IBackgroundParsingListener class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(131), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the TerminateParsingException class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(132), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the UnexpectedContentTypeException class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(133), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the TextToken class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(134), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder EMFText shall store the generated classes of the resource plug-in in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(135), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the extension point schema for default load options is not overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(136), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the extension point schema for additional parsers is not overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(137), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ResourceFactoryDelegator class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(138), 
		   source, 
		   new String[] {
			 "documentation", "The plug-in containing the resource implementation for the DSL (if different from the generated resource plug-in)."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(139), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the PreferencePage class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(140), 
		   source, 
		   new String[] {
			 "documentation", "Sets the ID for the generated common ANTLR runtime plug-in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(141), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, no ANTLR common runtime plug-in is generated. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(142), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the TokenStyleInformationProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(143), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the FoldingInformationProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(144), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the BracketInformationProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(145), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the SyntaxCoverageInformationProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(146), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the generated EMF resource will save only resource when their content (text) has actually changed. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(147), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the NewFileContentProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(148), 
		   source, 
		   new String[] {
			 "documentation", "A URI pointing to a text file that contains a header which shall be added to all generated Java files."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(149), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the ExpectedTerminal class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(150), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the CompletionProposal class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(151), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Builder class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(152), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the BuilderAdapter class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(153), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IBuilder class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(154), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Nature class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(155), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated plug-in IDs, which will be added to the manifest of the generated resource plug-in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(156), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the builder that is generated and registed by default will not be registed anymore. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(157), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated packages, which will be added as exports to the manifest of the generated resource plug-in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(158), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Pair class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(159), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the AbstractInterpreter class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(160), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the GrammarInformationProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(161), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the AttributeValueProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(162), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the FollowSetProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(163), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the SyntaxElement class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(164), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Keyword class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(165), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Placeholder class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(166), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Cardinality class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(167), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Printer2 class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(168), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Choice class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(169), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Compound class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(170), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Containment class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(171), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the LineBreak class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(172), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Sequence class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(173), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the WhiteSpace class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(174), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the SyntaxElementDecorator class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(175), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IReferenceCache class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(176), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the DefaultHoverTextProvider class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(177), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the FormattingElement class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(178), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the Terminal class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(179), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the LayoutInformationAdapter class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(180), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the LayoutInformation class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(181), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the classic printer (i.e., the used before EMFText 1.3.0) will be used. Otherwise the new printer implementation is used. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(182), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, constraint validation using registered EValidators is disabled. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(183), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, constraint validation using the EMF Validation Framework is disabled. The default value for this option is <code>false</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(184), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the MetaInformation class of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
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
			 "documentation", "If set to false, the plug-in activator class of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(187), 
		   source, 
		   new String[] {
			 "documentation", "The package where to store all clasess of the resource UI plug-in in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(188), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated plug-in IDs, which will be added to the manifest of the generated resource UI plug-in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(189), 
		   source, 
		   new String[] {
			 "documentation", "A list of comma separated packages, which will be added as exports to the manifest of the generated resource UI plug-in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(190), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the manifest of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(191), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the build.properties file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(192), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the .classpath file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(193), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the .project file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(194), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder EMFText shall store the overridable classes of the resource UI plug-in in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(195), 
		   source, 
		   new String[] {
			 "documentation", "The name of the folder EMFText shall store the generated classes of the resource UI plug-in in."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(196), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, EMFText will not generate the resource UI plug-in. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(197), 
		   source, 
		   new String[] {
			 "documentation", "If set to true, the IBracketHandler class will not be overriden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (optionTypesEEnum.getELiterals().get(198), 
		   source, 
		   new String[] {
			 "documentation", "If set to false, the plugin.xml file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>."
		   });		
		addAnnotation
		  (annotationEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "for ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : getParameters ( ) ) { \r\n\tif ( key .equals ( parameter .getKey ( ) ) ) { \r\n\t\tjava.lang.String value = parameter .getValue ( ) ; \r\n\t\treturn value ; \r\n\t} \r\n} \r\nreturn null ; \r\n",
			 "documentation", "\r\n Returns the annotation value for the given key.\r\n"
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "if ( ! get_qualifiedInterfaceNameCache ( ) .containsKey ( genClass ) ) { \r\n\tjava.lang.String qualifiedInterfaceName = genClass .getQualifiedInterfaceName ( ) ; \r\n\tget_qualifiedInterfaceNameCache ( ) .put ( genClass , qualifiedInterfaceName ) ; \r\n} \r\nreturn get_qualifiedInterfaceNameCache ( ) .get ( genClass ) ; \r\n",
			 "documentation", "\r\n Return the qualified name of the interface for the given GenClass.\r\n"
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "java.lang.String interfaceName = getQualifiedInterfaceName ( genClass ) ; \r\njava.lang.String escapedName = interfaceName .replace ( \"_\" , \"_005f\" ) ; \r\nescapedName = escapedName .replace ( \".\" , \"_\" ) ; \r\nreturn escapedName ; \r\n",
			 "documentation", "\r\n Return an esacped version of the qualified name of the interface for \r\n the given GenClass. Underscores and dots are replaced to be able to use \r\n the returned name, for example, as method name.\r\n"
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "return java .util .Map .Entry .class .getName ( ) .equals ( genClass .getEcoreClass ( ) .getInstanceClassName ( ) ) ; \r\n",
			 "documentation", "\r\n Checks whether the given GenClass has a map type.\r\n"
		   });		
		addAnnotation
		  (genClassCacheEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "for ( org.eclipse.emf.codegen.ecore.genmodel.GenClass entry : list ) { \r\n\torg.eclipse.emf.ecore.EClass entryClass = entry .getEcoreClass ( ) ; \r\n\torg.eclipse.emf.ecore.EClass oClass = genClass .getEcoreClass ( ) ; \r\n\tif ( entryClass .getName ( ) .equals ( oClass .getName ( ) ) && entryClass .getEPackage ( ) .getNsURI ( ) .equals ( oClass .getEPackage ( ) .getNsURI ( ) ) ) { \r\n\t\treturn true ; \r\n\t} \r\n} \r\nreturn false ; \r\n",
			 "documentation", "\r\n Checks whether the given list of GenClasses contains a GenClass\r\n with the same name and namespace URI as the given GenClass. \r\n"
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "for ( org.eclipse.emf.ecore.EClass superClassCandidate : subClassCandidate .getEAllSuperTypes ( ) ) { \r\n\t// There seem to be multiple instances of meta classes when accessed\n// through the generator model. Therefore, we compare by name.\nif ( namesAndPackageURIsAreEqual ( superClassCandidate , superClass ) ) { \r\n\t\treturn true ; \r\n\t} \r\n} \r\nreturn false ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "body", "org.eclipse.emf.common.util.EList < org.eclipse.emf.ecore.EClass > result = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.ecore.EClass > ( ) ; \r\nfor ( org.eclipse.emf.ecore.EClass next : availableClasses ) { \r\n\tif ( isSubClass ( next , superClass ) && isConcrete ( next ) ) { \r\n\t\tresult .add ( next ) ; \r\n\t} \r\n} \r\nreturn result ; \r\n",
			 "documentation", "\r\n Returns all subclasses of \'superClass\' that are contained\r\n in \'availableClasses\'.\r\n \r\n @param superClass the superclass\r\n @param availableClasses the set of classes to search in\r\n @return a list of all subclasses of \'superClass\'\r\n"
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "body", "return namesAreEqual ( classA , classB ) && packageURIsAreEqual ( classA , classB ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "body", "java.lang.String nsURI_A = classA .getEPackage ( ) .getNsURI ( ) ; \r\njava.lang.String nsURI_B = classB .getEPackage ( ) .getNsURI ( ) ; \r\nreturn ( nsURI_A == null && nsURI_B == null ) || nsURI_A .equals ( nsURI_B ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "body", "return classA .getName ( ) .equals ( classB .getName ( ) ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "body", "return ! eClass .isAbstract ( ) && ! eClass .isInterface ( ) ; \r\n",
			 "documentation", ""
		   });		
		addAnnotation
		  (eClassUtilEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "body", "return ! isConcrete ( eClass ) ; \r\n",
			 "documentation", ""
		   });
	}

} //ConcretesyntaxPackageImpl
