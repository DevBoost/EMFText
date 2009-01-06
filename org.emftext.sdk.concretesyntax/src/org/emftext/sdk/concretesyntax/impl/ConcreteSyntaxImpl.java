/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Syntax</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getStartSymbols <em>Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getAllRules <em>All Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteSyntaxImpl extends EObjectImpl implements ConcreteSyntax {
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
   * The cached value of the '{@link #getPackage() <em>Package</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
	protected GenPackage package_;

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
   * The cached value of the '{@link #getStartSymbols() <em>Start Symbols</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStartSymbols()
   * @generated
   * @ordered
   */
	protected EList<GenClass> startSymbols;

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
   * The cached value of the '{@link #getTokens() <em>Tokens</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTokens()
   * @generated
   * @ordered
   */
	protected EList<TokenDefinition> tokens;

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
	public GenPackage getPackage() {
    if (package_ != null && package_.eIsProxy())
    {
      InternalEObject oldPackage = (InternalEObject)package_;
      package_ = (GenPackage)eResolveProxy(oldPackage);
      if (package_ != oldPackage)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE, oldPackage, package_));
      }
    }
    return package_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public GenPackage basicGetPackage() {
    return package_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setPackage(GenPackage newPackage) {
    GenPackage oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE, oldPackage, package_));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Import> getImports() {
    if (imports == null)
    {
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
    if (startSymbols == null)
    {
      startSymbols = new EObjectResolvingEList<GenClass>(GenClass.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS);
    }
    return startSymbols;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Rule> getRules() {
    if (rules == null)
    {
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
		EList<Rule> l = new BasicEList<Rule>();
    	l.addAll(getRules());
    	
		for(Import aImport : getImports()) {
    		ConcreteSyntax importedCS = aImport.getConcreteSyntax();
    		if (importedCS != null) l.addAll(importedCS.getAllRules());
    	}
	
    	return new EcoreEList.UnmodifiableEList<Rule>(this, eFeature, l.size(), l.toArray());
 	}


	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<TokenDefinition> getTokens() {
    if (tokens == null)
    {
      tokens = new EObjectContainmentEList<TokenDefinition>(TokenDefinition.class, this, ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS);
    }
    return tokens;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Option> getOptions() {
    if (options == null)
    {
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
    switch (featureID)
    {
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
        return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
        return ((InternalEList<?>)getTokens()).basicRemove(otherEnd, msgs);
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
        return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
        return getName();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE:
        if (resolve) return getPackage();
        return basicGetPackage();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
        return getImports();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
        return getStartSymbols();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
        return getRules();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_RULES:
        return getAllRules();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
        return getTokens();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
        return getOptions();
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
        setName((String)newValue);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE:
        setPackage((GenPackage)newValue);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
        getStartSymbols().clear();
        getStartSymbols().addAll((Collection<? extends GenClass>)newValue);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
        getRules().clear();
        getRules().addAll((Collection<? extends Rule>)newValue);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
        getTokens().clear();
        getTokens().addAll((Collection<? extends TokenDefinition>)newValue);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
        getOptions().clear();
        getOptions().addAll((Collection<? extends Option>)newValue);
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE:
        setPackage((GenPackage)null);
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
        getImports().clear();
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
        getStartSymbols().clear();
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
        getRules().clear();
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
        getTokens().clear();
        return;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
        getOptions().clear();
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE:
        return package_ != null;
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
        return imports != null && !imports.isEmpty();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS:
        return startSymbols != null && !startSymbols.isEmpty();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
        return rules != null && !rules.isEmpty();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_RULES:
        return !getAllRules().isEmpty();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
        return tokens != null && !tokens.isEmpty();
      case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
        return options != null && !options.isEmpty();
    }
    return super.eIsSet(featureID);
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
    result.append(')');
    return result.toString();
  }

} //ConcreteSyntaxImpl
