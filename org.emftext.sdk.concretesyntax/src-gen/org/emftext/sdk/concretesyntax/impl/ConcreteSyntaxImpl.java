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

import java.util.Collection;
import java.util.ListIterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenStyle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Syntax</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getStartSymbols <em>Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getActiveStartSymbols <em>Active Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getActiveTokens <em>Active Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAllStartSymbols <em>All Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getSyntheticTokens <em>Synthetic Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getTokenStyles <em>Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAllTokenStyles <em>All Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAllTokenDirectives <em>All Token Directives</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAllRules <em>All Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getOperatorRules <em>Operator Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getOperatorRuleSubsets <em>Operator Rule Subsets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteSyntaxImpl extends GenPackageDependentElementImpl implements ConcreteSyntax {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected Abstract modifier;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStartSymbols() <em>Start Symbols</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartSymbols()
	 * @generated
	 * @ordered
	 */
	protected EList<GenClass> startSymbols;

	/**
	 * The cached value of the '{@link #getActiveTokens() <em>Active Tokens</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteTokenDefinition> activeTokens;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> options;

	/**
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<TokenDirective> tokens;

	/**
	 * The cached value of the '{@link #getSyntheticTokens() <em>Synthetic Tokens</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntheticTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteTokenDefinition> syntheticTokens;

	/**
	 * The cached value of the '{@link #getTokenStyles() <em>Token Styles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokenStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<TokenStyle> tokenStyles;

	/**
	 * The cached value of the '{@link #getAllTokenStyles() <em>All Token Styles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllTokenStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<TokenStyle> allTokenStyles;

	/**
	 * The cached value of the '{@link #getAllTokenDirectives() <em>All Token Directives</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllTokenDirectives()
	 * @generated
	 * @ordered
	 */
	protected EList<TokenDirective> allTokenDirectives;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	/**
	 * The cached value of the '{@link #getOperatorRules() <em>Operator Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> operatorRules;

	/**
	 * The cached value of the '{@link #getOperatorRuleSubsets() <em>Operator Rule Subsets</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorRuleSubsets()
	 * @generated
	 * @ordered
	 */
	protected EList<String> operatorRuleSubsets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteSyntaxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenClass> getStartSymbols() {
		if (startSymbols == null) {
			startSymbols = new EObjectResolvingEList<GenClass>(GenClass.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS);
		}
		return startSymbols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns all active start symbols. A symbol is active if it is 
	 * either declared in this syntax of if it is part of an imported
	 * syntax.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<GenClass> getActiveStartSymbols() {
		EList<GenClass> symbols = new BasicEList<GenClass>();
		symbols.addAll(getStartSymbols());
		if (symbols.size() > 0) {
			return symbols;
		}
		
		EList<Import> imports = getImports();
		for (Import importedElement : imports) {
			final ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();
			if (importedSyntax != null) {
				symbols.addAll(importedSyntax.getActiveStartSymbols());
			}
		}
		return symbols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteTokenDefinition> getActiveTokens() {
		if (activeTokens == null) {
			activeTokens = new EObjectResolvingEList<CompleteTokenDefinition>(CompleteTokenDefinition.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_TOKENS);
		}
		return activeTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns all start symbols. This includes both the symbols declared 
	 * in this syntax and the symbols from imported syntaxes.
	 * syntax.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<GenClass> getAllStartSymbols() {
		EList<GenClass> symbols = new BasicEList<GenClass>();
		symbols.addAll(getStartSymbols());
		
		EList<Import> imports = getImports();
		for (Import importedElement : imports) {
			final ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();
			if (importedSyntax != null) {
				symbols.addAll(importedSyntax.getAllStartSymbols());
			}
		}
		return symbols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentWithInverseEList<Rule>(Rule.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, ConcretesyntaxPackage.RULE__SYNTAX);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Rule> getAllRules() {
		EStructuralFeature eFeature = ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES;
		EList<Rule> l = new BasicEList<Rule>(getRules().size());
		for (Rule rule : getRules()) {
			// don't add rules that are @override rules with remove=true
			if (!isOverrideRemoveRule(rule)) {
				l.add(rule);
			}
		}
		for (Import aImport : getImports()) {
			ConcreteSyntax importedCS = aImport.getConcreteSyntax();
			if (importedCS != null) {
				outer: for (Rule importedRule : importedCS.getAllRules()) {
					for (Rule rule : getRules()) {
						// don't add rules that have @override rules for same
						// meta-class
						if (isOverrideRule(rule, importedRule.getMetaclass())) {
							continue outer;
						}
					}
					l.add(importedRule);
				}
			}
		}
		return new EcoreEList.UnmodifiableEList<Rule>(this, eFeature, l.size(),
				l.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Rule> getOperatorRules() {
		if (operatorRules == null) {
			initialiseAnnotatedOperatorRules();	
		}
		return operatorRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<String> getOperatorRuleSubsets() {
		if (operatorRuleSubsets == null) {
			initialiseAnnotatedOperatorRules();
		}
		return operatorRuleSubsets;
	}
	
	/**
	 * @generated NOT
	 */
	private void initialiseAnnotatedOperatorRules(){
		operatorRules = new EObjectEList<Rule>(Rule.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES);
		operatorRuleSubsets = new EDataTypeUniqueEList<String>(String.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS);
		for (Rule rule : getAllRules()) {
			Annotation operatorAnnotation = rule.getOperatorAnnotation();
			if (operatorAnnotation != null) {
				boolean added = false;
				for (ListIterator<Rule> it = operatorRules.listIterator(); it.hasNext();) {
					Rule expressionRule = it.next(); 
					if (expressionRule.getOperatorWeight() > rule.getOperatorWeight()) {
						operatorRules.add(it.previousIndex(), rule);
						added = true;
						break;
					}			
				}
				if (!added) {
					operatorRules.add(rule);
				}
				// TODO mseifert: use constant here
				String identifier = operatorAnnotation.getValue("identifier");
				this.operatorRuleSubsets.add(identifier);	
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Rule> getOperatorRuleSubset(String identifier) {
		EList<Rule> subset = new BasicEList<Rule>();
		for(Rule rule : this.getOperatorRules()) {
			Annotation annotation = rule.getOperatorAnnotation();
			// TODO mseifert: use constant here
			String value = annotation.getValue("identifier");
			if (identifier.equals(value)) {
				subset.add(rule);
			}
		}
		return subset;
	}

	/**
	 * @generated NOT
	 */
	private boolean isOverrideRemoveRule(Rule rule) {
		// TODO mseifert: use constant here
		return hasAnnotation(rule, AnnotationType.OVERRIDE, "remove", "true");
	}

	/**
	 * @generated NOT
	 */
	private boolean isOverrideRule(Rule rule, GenClass metaClass) {
		// TODO figure out why 'metaClass == null' is needed
		if (metaClass == null || rule.getMetaclass() == metaClass) {
			if (hasAnnotation(rule, AnnotationType.OVERRIDE, null, null)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	private boolean hasAnnotation(Rule rule, AnnotationType type, String key,
			String value) {
		for (Annotation annotation : rule.getAnnotations()) {
			if (annotation.getType() == type) {
				if (key != null) {
					for (KeyValuePair parameter : annotation.getParameters()) {
						if (key.equals(parameter.getKey())
								&& parameter.getValue().equals(value)) {
							return true;
						}
					}
				} else {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abstract getModifier() {
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModifier(Abstract newModifier, NotificationChain msgs) {
		Abstract oldModifier = modifier;
		modifier = newModifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER, oldModifier, newModifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifier(Abstract newModifier) {
		if (newModifier != modifier) {
			NotificationChain msgs = null;
			if (modifier != null)
				msgs = ((InternalEObject)modifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER, null, msgs);
			if (newModifier != null)
				msgs = ((InternalEObject)newModifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER, null, msgs);
			msgs = basicSetModifier(newModifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER, newModifier, newModifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TokenDirective> getTokens() {
		if (tokens == null) {
			tokens = new EObjectContainmentEList<TokenDirective>(TokenDirective.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TokenStyle> getTokenStyles() {
		if (tokenStyles == null) {
			tokenStyles = new EObjectContainmentEList<TokenStyle>(TokenStyle.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES);
		}
		return tokenStyles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TokenStyle> getAllTokenStyles() {
		if (allTokenStyles == null) {
			allTokenStyles = new EObjectResolvingEList<TokenStyle>(TokenStyle.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_STYLES);
		}
		return allTokenStyles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TokenDirective> getAllTokenDirectives() {
		if (allTokenDirectives == null) {
			allTokenDirectives = new EObjectResolvingEList<TokenDirective>(TokenDirective.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES);
		}
		return allTokenDirectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteTokenDefinition> getSyntheticTokens() {
		if (syntheticTokens == null) {
			syntheticTokens = new EObjectContainmentEList<CompleteTokenDefinition>(CompleteTokenDefinition.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS);
		}
		return syntheticTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList<Option>(Option.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRules()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER:
				return basicSetModifier(null, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
				return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
				return ((InternalEList<?>)getTokens()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS:
				return ((InternalEList<?>)getSyntheticTokens()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES:
				return ((InternalEList<?>)getTokenStyles()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS:
				return getAnnotations();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER:
				return getModifier();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
				return getName();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
				return getStartSymbols();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_START_SYMBOLS:
				return getActiveStartSymbols();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_TOKENS:
				return getActiveTokens();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_START_SYMBOLS:
				return getAllStartSymbols();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
				return getImports();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
				return getOptions();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
				return getTokens();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS:
				return getSyntheticTokens();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES:
				return getTokenStyles();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_STYLES:
				return getAllTokenStyles();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES:
				return getAllTokenDirectives();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
				return getRules();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_RULES:
				return getAllRules();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES:
				return getOperatorRules();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				return getOperatorRuleSubsets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER:
				setModifier((Abstract)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
				setName((String)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
				getStartSymbols().clear();
				getStartSymbols().addAll((Collection<? extends GenClass>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_TOKENS:
				getActiveTokens().clear();
				getActiveTokens().addAll((Collection<? extends CompleteTokenDefinition>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends Option>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends TokenDirective>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS:
				getSyntheticTokens().clear();
				getSyntheticTokens().addAll((Collection<? extends CompleteTokenDefinition>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES:
				getTokenStyles().clear();
				getTokenStyles().addAll((Collection<? extends TokenStyle>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_STYLES:
				getAllTokenStyles().clear();
				getAllTokenStyles().addAll((Collection<? extends TokenStyle>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES:
				getAllTokenDirectives().clear();
				getAllTokenDirectives().addAll((Collection<? extends TokenDirective>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES:
				getOperatorRules().clear();
				getOperatorRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				getOperatorRuleSubsets().clear();
				getOperatorRuleSubsets().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER:
				setModifier((Abstract)null);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
				getStartSymbols().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_TOKENS:
				getActiveTokens().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
				getImports().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
				getOptions().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
				getTokens().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS:
				getSyntheticTokens().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES:
				getTokenStyles().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_STYLES:
				getAllTokenStyles().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES:
				getAllTokenDirectives().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
				getRules().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES:
				getOperatorRules().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				getOperatorRuleSubsets().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER:
				return modifier != null;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
				return startSymbols != null && !startSymbols.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_START_SYMBOLS:
				return !getActiveStartSymbols().isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_TOKENS:
				return activeTokens != null && !activeTokens.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_START_SYMBOLS:
				return !getAllStartSymbols().isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
				return imports != null && !imports.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
				return options != null && !options.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
				return tokens != null && !tokens.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS:
				return syntheticTokens != null && !syntheticTokens.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES:
				return tokenStyles != null && !tokenStyles.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_STYLES:
				return allTokenStyles != null && !allTokenStyles.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES:
				return allTokenDirectives != null && !allTokenDirectives.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
				return rules != null && !rules.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_RULES:
				return !getAllRules().isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES:
				return operatorRules != null && !operatorRules.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				return operatorRuleSubsets != null && !operatorRuleSubsets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Annotable.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS: return ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Annotable.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS: return ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", operatorRuleSubsets: ");
		result.append(operatorRuleSubsets);
		result.append(')');
		return result.toString();
	}

} //ConcreteSyntaxImpl
