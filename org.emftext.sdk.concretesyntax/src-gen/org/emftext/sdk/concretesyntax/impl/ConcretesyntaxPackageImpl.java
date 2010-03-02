/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.concretesyntax.impl;

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
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.LineBreak;
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
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexOwner;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
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
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Imports() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(6);
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
	public EReference getConcreteSyntax_ActiveStartSymbols() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_ActiveTokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_AllStartSymbols() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Rules() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_AllRules() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_OperatorRules() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax_OperatorRuleSubsets() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(16);
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
	public EReference getConcreteSyntax_Tokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_TokenStyles() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_AllTokenStyles() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_AllTokenDirectives() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_SyntheticTokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Options() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(7);
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
	public EReference getRule_Definition() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Metaclass() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Syntax() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
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
	public EReference getChoice_Options() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(0);
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
	public EReference getSequence_Parts() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(0);
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
  public EClass getCardinalityDefinition()
  {
		return cardinalityDefinitionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCardinalityDefinition_Cardinality()
  {
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
	public EReference getCompoundDefinition_Definitions() {
		return (EReference)compoundDefinitionEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getAbstractTokenDefinition_Name() {
		return (EAttribute)abstractTokenDefinitionEClass.getEStructuralFeatures().get(0);
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
	public EReference getCompleteTokenDefinition_AttributeReferences() {
		return (EReference)completeTokenDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteTokenDefinition_AttributeName() {
		return (EAttribute)completeTokenDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteTokenDefinition_Hidden() {
		return (EAttribute)completeTokenDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteTokenDefinition_Used() {
		return (EAttribute)completeTokenDefinitionEClass.getEStructuralFeatures().get(3);
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
  public EReference getContainment_Types()
  {
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
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ACTIVE_START_SYMBOLS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ACTIVE_TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ALL_START_SYMBOLS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__IMPORTS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__OPTIONS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__SYNTHETIC_TOKENS);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TOKEN_STYLES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ALL_TOKEN_STYLES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__RULES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__ALL_RULES);
		createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULES);
		createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__PREFIX);
		createEReference(importEClass, IMPORT__CONCRETE_SYNTAX);
		createEAttribute(importEClass, IMPORT__CS_LOCATION_HINT);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__DEFINITION);
		createEReference(ruleEClass, RULE__METACLASS);
		createEReference(ruleEClass, RULE__SYNTAX);

		choiceEClass = createEClass(CHOICE);
		createEReference(choiceEClass, CHOICE__OPTIONS);

		sequenceEClass = createEClass(SEQUENCE);
		createEReference(sequenceEClass, SEQUENCE__PARTS);

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
		createEReference(compoundDefinitionEClass, COMPOUND_DEFINITION__DEFINITIONS);

		tokenDirectiveEClass = createEClass(TOKEN_DIRECTIVE);

		regexOwnerEClass = createEClass(REGEX_OWNER);
		createEAttribute(regexOwnerEClass, REGEX_OWNER__REGEX);

		regexPartEClass = createEClass(REGEX_PART);

		regexCompositeEClass = createEClass(REGEX_COMPOSITE);
		createEReference(regexCompositeEClass, REGEX_COMPOSITE__REGEX_PARTS);

		atomicRegexEClass = createEClass(ATOMIC_REGEX);
		createEAttribute(atomicRegexEClass, ATOMIC_REGEX__ATOMIC_EXPRESSION);

		regexReferenceEClass = createEClass(REGEX_REFERENCE);
		createEReference(regexReferenceEClass, REGEX_REFERENCE__TARGET);

		abstractTokenDefinitionEClass = createEClass(ABSTRACT_TOKEN_DEFINITION);
		createEAttribute(abstractTokenDefinitionEClass, ABSTRACT_TOKEN_DEFINITION__NAME);

		partialTokenDefinitionEClass = createEClass(PARTIAL_TOKEN_DEFINITION);

		completeTokenDefinitionEClass = createEClass(COMPLETE_TOKEN_DEFINITION);
		createEReference(completeTokenDefinitionEClass, COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES);
		createEAttribute(completeTokenDefinitionEClass, COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME);
		createEAttribute(completeTokenDefinitionEClass, COMPLETE_TOKEN_DEFINITION__HIDDEN);
		createEAttribute(completeTokenDefinitionEClass, COMPLETE_TOKEN_DEFINITION__USED);

		normalTokenDefinitionEClass = createEClass(NORMAL_TOKEN_DEFINITION);

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
		partialTokenDefinitionEClass.getESuperTypes().add(this.getAbstractTokenDefinition());
		partialTokenDefinitionEClass.getESuperTypes().add(this.getTokenDirective());
		partialTokenDefinitionEClass.getESuperTypes().add(this.getRegexComposite());
		completeTokenDefinitionEClass.getESuperTypes().add(this.getAbstractTokenDefinition());
		completeTokenDefinitionEClass.getESuperTypes().add(this.getTokenDirective());
		completeTokenDefinitionEClass.getESuperTypes().add(this.getRegexOwner());
		normalTokenDefinitionEClass.getESuperTypes().add(this.getCompleteTokenDefinition());
		normalTokenDefinitionEClass.getESuperTypes().add(this.getAnnotable());
		normalTokenDefinitionEClass.getESuperTypes().add(this.getRegexComposite());
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
		initEReference(getConcreteSyntax_ActiveStartSymbols(), theGenModelPackage.getGenClass(), null, "activeStartSymbols", null, 1, -1, ConcreteSyntax.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_ActiveTokens(), this.getCompleteTokenDefinition(), null, "activeTokens", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_AllStartSymbols(), theGenModelPackage.getGenClass(), null, "allStartSymbols", null, 1, -1, ConcreteSyntax.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Imports(), this.getImport(), null, "imports", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Options(), this.getOption(), null, "options", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Tokens(), this.getTokenDirective(), null, "tokens", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_SyntheticTokens(), this.getCompleteTokenDefinition(), null, "syntheticTokens", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_TokenStyles(), this.getTokenStyle(), null, "tokenStyles", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_AllTokenStyles(), this.getTokenStyle(), null, "allTokenStyles", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_AllTokenDirectives(), this.getTokenDirective(), null, "allTokenDirectives", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Rules(), this.getRule(), this.getRule_Syntax(), "rules", null, 1, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_AllRules(), this.getRule(), null, "allRules", null, 1, -1, ConcreteSyntax.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_OperatorRules(), this.getRule(), null, "operatorRules", null, 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax_OperatorRuleSubsets(), theEcorePackage.getEString(), "operatorRuleSubsets", "", 0, -1, ConcreteSyntax.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(concreteSyntaxEClass, this.getRule(), "getOperatorRuleSubset", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "identifier", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImport_ConcreteSyntax(), this.getConcreteSyntax(), null, "concreteSyntax", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImport_CsLocationHint(), theEcorePackage.getEString(), "csLocationHint", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Definition(), this.getChoice(), null, "definition", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Metaclass(), theGenModelPackage.getGenClass(), null, "metaclass", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Syntax(), this.getConcreteSyntax(), this.getConcreteSyntax_Rules(), "syntax", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(ruleEClass, this.getAnnotation(), "getOperatorAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(ruleEClass, theEcorePackage.getEInt(), "getOperatorWeight", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoice_Options(), this.getSequence(), null, "options", null, 1, -1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequence_Parts(), this.getDefinition(), null, "parts", null, 1, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definitionEClass, Definition.class, "Definition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityDefinitionEClass, CardinalityDefinition.class, "CardinalityDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCardinalityDefinition_Cardinality(), this.getCardinality(), null, "cardinality", null, 0, 1, CardinalityDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getCompoundDefinition_Definitions(), this.getChoice(), null, "definitions", null, 1, 1, CompoundDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tokenDirectiveEClass, TokenDirective.class, "TokenDirective", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regexOwnerEClass, RegexOwner.class, "RegexOwner", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegexOwner_Regex(), theEcorePackage.getEString(), "regex", null, 1, 1, RegexOwner.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(regexPartEClass, RegexPart.class, "RegexPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regexCompositeEClass, RegexComposite.class, "RegexComposite", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegexComposite_RegexParts(), this.getRegexPart(), null, "regexParts", null, 1, -1, RegexComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicRegexEClass, AtomicRegex.class, "AtomicRegex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAtomicRegex_AtomicExpression(), theEcorePackage.getEString(), "atomicExpression", null, 1, 1, AtomicRegex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regexReferenceEClass, RegexReference.class, "RegexReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegexReference_Target(), this.getAbstractTokenDefinition(), null, "target", null, 1, 1, RegexReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTokenDefinitionEClass, AbstractTokenDefinition.class, "AbstractTokenDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractTokenDefinition_Name(), theEcorePackage.getEString(), "name", null, 1, 1, AbstractTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partialTokenDefinitionEClass, PartialTokenDefinition.class, "PartialTokenDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(completeTokenDefinitionEClass, CompleteTokenDefinition.class, "CompleteTokenDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompleteTokenDefinition_AttributeReferences(), this.getPlaceholder(), this.getPlaceholder_Token(), "attributeReferences", null, 0, -1, CompleteTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompleteTokenDefinition_AttributeName(), theEcorePackage.getEString(), "attributeName", null, 0, 1, CompleteTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompleteTokenDefinition_Hidden(), theEcorePackage.getEBoolean(), "hidden", null, 0, 1, CompleteTokenDefinition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompleteTokenDefinition_Used(), theEcorePackage.getEBoolean(), "used", null, 0, 1, CompleteTokenDefinition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(normalTokenDefinitionEClass, NormalTokenDefinition.class, "NormalTokenDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quotedTokenDefinitionEClass, QuotedTokenDefinition.class, "QuotedTokenDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuotedTokenDefinition_Prefix(), theEcorePackage.getEString(), "prefix", "", 0, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedTokenDefinition_Suffix(), theEcorePackage.getEString(), "suffix", "", 0, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedTokenDefinition_EscapeCharacter(), theEcorePackage.getEString(), "escapeCharacter", null, 0, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQuotedTokenDefinition_SynthesizedRegex(), theEcorePackage.getEString(), "synthesizedRegex", null, 1, 1, QuotedTokenDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tokenPriorityDirectiveEClass, TokenPriorityDirective.class, "TokenPriorityDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTokenPriorityDirective_Token(), this.getCompleteTokenDefinition(), null, "token", null, 1, 1, TokenPriorityDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containmentEClass, Containment.class, "Containment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainment_Types(), theGenModelPackage.getGenClass(), null, "types", null, 0, -1, Containment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(placeholderEClass, Placeholder.class, "Placeholder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaceholder_Token(), this.getCompleteTokenDefinition(), this.getCompleteTokenDefinition_AttributeReferences(), "token", null, 1, 1, Placeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(placeholderUsingSpecifiedTokenEClass, PlaceholderUsingSpecifiedToken.class, "PlaceholderUsingSpecifiedToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeholderUsingDefaultTokenEClass, PlaceholderUsingDefaultToken.class, "PlaceholderUsingDefaultToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeholderInQuotesEClass, PlaceholderInQuotes.class, "PlaceholderInQuotes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlaceholderInQuotes_Prefix(), theEcorePackage.getEString(), "prefix", "", 1, 1, PlaceholderInQuotes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlaceholderInQuotes_Suffix(), theEcorePackage.getEString(), "suffix", "", 1, 1, PlaceholderInQuotes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlaceholderInQuotes_EscapeCharacter(), theEcorePackage.getEString(), "escapeCharacter", null, 0, 1, PlaceholderInQuotes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(placeholderInQuotesEClass, theEcorePackage.getEString(), "getNormalizedPrefix", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(placeholderInQuotesEClass, theEcorePackage.getEString(), "getNormalizedSuffix", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(placeholderInQuotesEClass, theEcorePackage.getEString(), "getNormalizedEscapeCharacter", 0, 1, IS_UNIQUE, IS_ORDERED);

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
		addEEnumLiteral(operatorAnnotationTypeEEnum, OperatorAnnotationType.UNARY);
		addEEnumLiteral(operatorAnnotationTypeEEnum, OperatorAnnotationType.PRIMITIVE);

		initEEnum(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.class, "OperatorAnnotationProperty");
		addEEnumLiteral(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.TYPE);
		addEEnumLiteral(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.IDENTIFIER);
		addEEnumLiteral(operatorAnnotationPropertyEEnum, OperatorAnnotationProperty.WEIGHT);

		// Create resource
		createResource(eNS_URI);
	}

} //ConcretesyntaxPackageImpl
