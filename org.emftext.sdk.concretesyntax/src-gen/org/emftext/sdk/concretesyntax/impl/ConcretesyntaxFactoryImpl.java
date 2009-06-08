/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.QuotedToken;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
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
			case ConcretesyntaxPackage.PLUS: return createPLUS();
			case ConcretesyntaxPackage.STAR: return createSTAR();
			case ConcretesyntaxPackage.QUESTIONMARK: return createQUESTIONMARK();
			case ConcretesyntaxPackage.COMPOUND_DEFINITION: return createCompoundDefinition();
			case ConcretesyntaxPackage.NORMAL_TOKEN: return createNormalToken();
			case ConcretesyntaxPackage.QUOTED_TOKEN: return createQuotedToken();
			case ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE: return createTokenPriorityDirective();
			case ConcretesyntaxPackage.CONTAINMENT: return createContainment();
			case ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN: return createPlaceholderUsingSpecifiedToken();
			case ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN: return createPlaceholderUsingDefaultToken();
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES: return createPlaceholderInQuotes();
			case ConcretesyntaxPackage.OPTION: return createOption();
			case ConcretesyntaxPackage.ABSTRACT: return createAbstract();
			case ConcretesyntaxPackage.TOKEN_STYLE: return createTokenStyle();
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
			case ConcretesyntaxPackage.OPTION_TYPES:
				return createOptionTypesFromString(eDataType, initialValue);
			case ConcretesyntaxPackage.FONT_STYLE:
				return createFontStyleFromString(eDataType, initialValue);
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
			case ConcretesyntaxPackage.OPTION_TYPES:
				return convertOptionTypesToString(eDataType, instanceValue);
			case ConcretesyntaxPackage.FONT_STYLE:
				return convertFontStyleToString(eDataType, instanceValue);
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
	public PLUS createPLUS() {
		PLUSImpl plus = new PLUSImpl();
		return plus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STAR createSTAR() {
		STARImpl star = new STARImpl();
		return star;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QUESTIONMARK createQUESTIONMARK() {
		QUESTIONMARKImpl questionmark = new QUESTIONMARKImpl();
		return questionmark;
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
	public NormalToken createNormalToken() {
		NormalTokenImpl normalToken = new NormalTokenImpl();
		return normalToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedToken createQuotedToken() {
		QuotedTokenImpl quotedToken = new QuotedTokenImpl();
		return quotedToken;
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
	public Option createOption() {
		OptionImpl option = new OptionImpl();
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abstract createAbstract() {
		AbstractImpl abstract_ = new AbstractImpl();
		return abstract_;
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
