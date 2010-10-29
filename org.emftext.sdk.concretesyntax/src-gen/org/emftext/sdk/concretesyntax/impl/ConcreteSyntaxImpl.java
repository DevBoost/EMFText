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

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;
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
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getStartSymbols <em>Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getActiveTokens <em>Active Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getSyntheticTokens <em>Synthetic Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getTokenStyles <em>Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAllTokenStyles <em>All Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAllTokenDirectives <em>All Token Directives</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#get_operatorRules <em>operator Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#get_operatorRuleSubsets <em>operator Rule Subsets</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#is_operatorRulesInitialized <em>operator Rules Initialized</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#get_genClassCache <em>gen Class Cache</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#get_eClassUtil <em>eClass Util</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#isAbstract <em>Abstract</em>}</li>
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
	 * The cached value of the '{@link #get_operatorRules() <em>operator Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_operatorRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> _operatorRules;

	/**
	 * The cached value of the '{@link #get_operatorRuleSubsets() <em>operator Rule Subsets</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_operatorRuleSubsets()
	 * @generated
	 * @ordered
	 */
	protected EList<String> _operatorRuleSubsets;

	/**
	 * The default value of the '{@link #is_operatorRulesInitialized() <em>operator Rules Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #is_operatorRulesInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean _OPERATOR_RULES_INITIALIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #is_operatorRulesInitialized() <em>operator Rules Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #is_operatorRulesInitialized()
	 * @generated
	 * @ordered
	 */
	protected boolean _operatorRulesInitialized = _OPERATOR_RULES_INITIALIZED_EDEFAULT;

	/**
	 * The cached value of the '{@link #get_genClassCache() <em>gen Class Cache</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_genClassCache()
	 * @generated
	 * @ordered
	 */
	protected GenClassCache _genClassCache;

	/**
	 * The cached value of the '{@link #get_eClassUtil() <em>eClass Util</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_eClassUtil()
	 * @generated
	 * @ordered
	 */
	protected EClassUtil _eClassUtil;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

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
	public EList<GenClass> getStartSymbols() {
		if (startSymbols == null) {
			startSymbols = new EObjectResolvingEList<GenClass>(GenClass.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS);
		}
		return startSymbols;
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
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentWithInverseEList<Rule>(Rule.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, ConcretesyntaxPackage.RULE__SYNTAX);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> get_operatorRules() {
		if (_operatorRules == null) {
			_operatorRules = new EObjectEList<Rule>(Rule.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES);
		}
		return _operatorRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> get_operatorRuleSubsets() {
		if (_operatorRuleSubsets == null) {
			_operatorRuleSubsets = new EDataTypeUniqueEList<String>(String.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS);
		}
		return _operatorRuleSubsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean is_operatorRulesInitialized() {
		return _operatorRulesInitialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_operatorRulesInitialized(boolean new_operatorRulesInitialized) {
		boolean old_operatorRulesInitialized = _operatorRulesInitialized;
		_operatorRulesInitialized = new_operatorRulesInitialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED, old_operatorRulesInitialized, _operatorRulesInitialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClassCache get_genClassCache() {
		return _genClassCache;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSet_genClassCache(GenClassCache new_genClassCache, NotificationChain msgs) {
		GenClassCache old_genClassCache = _genClassCache;
		_genClassCache = new_genClassCache;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE, old_genClassCache, new_genClassCache);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_genClassCache(GenClassCache new_genClassCache) {
		if (new_genClassCache != _genClassCache) {
			NotificationChain msgs = null;
			if (_genClassCache != null)
				msgs = ((InternalEObject)_genClassCache).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE, null, msgs);
			if (new_genClassCache != null)
				msgs = ((InternalEObject)new_genClassCache).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE, null, msgs);
			msgs = basicSet_genClassCache(new_genClassCache, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE, new_genClassCache, new_genClassCache));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassUtil get_eClassUtil() {
		return _eClassUtil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSet_eClassUtil(EClassUtil new_eClassUtil, NotificationChain msgs) {
		EClassUtil old_eClassUtil = _eClassUtil;
		_eClassUtil = new_eClassUtil;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL, old_eClassUtil, new_eClassUtil);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_eClassUtil(EClassUtil new_eClassUtil) {
		if (new_eClassUtil != _eClassUtil) {
			NotificationChain msgs = null;
			if (_eClassUtil != null)
				msgs = ((InternalEObject)_eClassUtil).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL, null, msgs);
			if (new_eClassUtil != null)
				msgs = ((InternalEObject)new_eClassUtil).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL, null, msgs);
			msgs = basicSet_eClassUtil(new_eClassUtil, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL, new_eClassUtil, new_eClassUtil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getOperatorRuleSubset(String identifier) {
		
				 org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> subset = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>();
		
				if (identifier == null) {
					return subset;
				}
		
				for ( org.emftext.sdk.concretesyntax.Rule rule : getOperatorRules()) {
					 org.emftext.sdk.concretesyntax.Annotation annotation = rule.getOperatorAnnotation();
					 java.lang.String value = annotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());
					if (identifier.equals(value)) {
						subset.add(rule);
					}
				}
		
				return subset;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenClass> getActiveStartSymbols() {
		
				 org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> symbols = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();
		
				symbols.addAll(getStartSymbols());
		
				if (symbols.size() > 0) {
					return symbols;
				}
		
				
				 org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Import> imports = getImports();
		
				for ( org.emftext.sdk.concretesyntax.Import importedElement : imports) {
					final  org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();
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
	public EList<Rule> getAllRules() {
		
				//EStructuralFeature eFeature = ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES;
				 org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> l = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>(getRules().size());
		
				for ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {
					// don't add rules that are @override rules with remove=true
					if (!rule.isOverrideRemoveRule()) {
						l.add(rule);
					}
				}
		
				for ( org.emftext.sdk.concretesyntax.Import aImport : getImports()) {
					 org.emftext.sdk.concretesyntax.ConcreteSyntax importedCS = aImport.getConcreteSyntax();
					if (importedCS != null) {
						outer: for ( org.emftext.sdk.concretesyntax.Rule importedRule : importedCS.getAllRules()) {
							for ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {
								// don't add rules that have @override rules for same
								// meta-class
								if (rule.isOverrideRule(importedRule.getMetaclass())) {
									continue outer;
								}
							}
							l.add(importedRule);
						}
					}
				}
		
				return  org.eclipse.emf.common.util.ECollections.unmodifiableEList(l);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getOperatorRules() {
		
				initialiseAnnotatedOperatorRules();
		
				return get_operatorRules();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initialiseAnnotatedOperatorRules() {
		
				if (is_operatorRulesInitialized()) {
					return;
				}
		
				set_operatorRulesInitialized(true);
		
				 java.util.List< org.emftext.sdk.concretesyntax.Rule> operatorRules = getOperatorRules();
		
				 java.util.List< java.lang.String> operatorRuleSubsets = getOperatorRuleSubsets();
		
				for ( org.emftext.sdk.concretesyntax.Rule rule : getAllRules()) {
					 org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = rule.getOperatorAnnotation();
					if (operatorAnnotation != null) {
						boolean added = false;
						for ( java.util.ListIterator< org.emftext.sdk.concretesyntax.Rule> it = operatorRules.listIterator(); it.hasNext();) {
							 org.emftext.sdk.concretesyntax.Rule expressionRule = it.next(); 
							if (expressionRule.getOperatorWeight() > rule.getOperatorWeight()) {
								operatorRules.add(it.previousIndex(), rule);
								added = true;
								break;
							}			
						}
						if (!added) {
							operatorRules.add(rule);
						}
						 java.lang.String identifier = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());
						operatorRuleSubsets.add(identifier);
					}
				}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOperatorRuleSubsets() {
		
				initialiseAnnotatedOperatorRules();
		
				return get_operatorRuleSubsets();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClassCache getGenClassCache() {
		
				if (get_genClassCache() == null) {
					set_genClassCache( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createGenClassCache());
				}
		
				return get_genClassCache();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImportedRule(Rule rule) {
		
				return rule.getSyntax() != this;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassUtil getEClassUtil() {
		
				if (get_eClassUtil() == null) {
					set_eClassUtil( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEClassUtil());
				}
		
				return get_eClassUtil();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenClass> getClassesWithSyntax(boolean excludeOperatorRules) {
		
				 java.util.Collection< org.emftext.sdk.concretesyntax.Rule> rules = getAllRules();
		
				 org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> foundGenClasses = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();
		
		
				for ( org.emftext.sdk.concretesyntax.Rule rule : rules) {
					if (excludeOperatorRules && rule.getOperatorAnnotation() != null) {
						continue;
					}
					 org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand = rule.getMetaclass();
					foundGenClasses.add(subClassCand);
				}
		
				return foundGenClasses;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenClass> getSubClassesWithSyntax(GenClass superClass, boolean excludeOperatorRules) {
		
				 org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> subClasses = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();
		
		
				 org.eclipse.emf.ecore.EClass ecoreClass = superClass.getEcoreClass();
		
				 org.emftext.sdk.concretesyntax.EClassUtil eClassUtil = getEClassUtil();
		
				for ( org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand : getClassesWithSyntax(excludeOperatorRules)) {
					if (eClassUtil.isSubClass(subClassCand.getEcoreClass(), ecoreClass)) {
						subClasses.add(subClassCand);
					}
				}
		
				return subClasses;
		
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
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE:
				return basicSet_genClassCache(null, msgs);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL:
				return basicSet_eClassUtil(null, msgs);
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
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
				return getName();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
				return getStartSymbols();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_TOKENS:
				return getActiveTokens();
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
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES:
				return get_operatorRules();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				return get_operatorRuleSubsets();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED:
				return is_operatorRulesInitialized();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE:
				return get_genClassCache();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL:
				return get_eClassUtil();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT:
				return isAbstract();
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
				get_operatorRules().clear();
				get_operatorRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				get_operatorRuleSubsets().clear();
				get_operatorRuleSubsets().addAll((Collection<? extends String>)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED:
				set_operatorRulesInitialized((Boolean)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE:
				set_genClassCache((GenClassCache)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL:
				set_eClassUtil((EClassUtil)newValue);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT:
				setAbstract((Boolean)newValue);
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
				get_operatorRules().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				get_operatorRuleSubsets().clear();
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED:
				set_operatorRulesInitialized(_OPERATOR_RULES_INITIALIZED_EDEFAULT);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE:
				set_genClassCache((GenClassCache)null);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL:
				set_eClassUtil((EClassUtil)null);
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
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
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
				return startSymbols != null && !startSymbols.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_TOKENS:
				return activeTokens != null && !activeTokens.isEmpty();
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
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES:
				return _operatorRules != null && !_operatorRules.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
				return _operatorRuleSubsets != null && !_operatorRuleSubsets.isEmpty();
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED:
				return _operatorRulesInitialized != _OPERATOR_RULES_INITIALIZED_EDEFAULT;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE:
				return _genClassCache != null;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL:
				return _eClassUtil != null;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
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
		result.append(", _operatorRuleSubsets: ");
		result.append(_operatorRuleSubsets);
		result.append(", _operatorRulesInitialized: ");
		result.append(_operatorRulesInitialized);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //ConcreteSyntaxImpl
