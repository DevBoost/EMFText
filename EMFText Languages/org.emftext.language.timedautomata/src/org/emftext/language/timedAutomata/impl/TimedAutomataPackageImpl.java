/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.timedAutomata.impl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.emftext.language.simpleGraph.SimpleGraphPackage;
import org.emftext.language.timedAutomata.TimedAutomataFactory;
import org.emftext.language.timedAutomata.TimedAutomataPackage;
import org.emftext.language.timedAutomata.base.BasePackage;
import org.emftext.language.timedAutomata.base.impl.BasePackageImpl;
import org.emftext.language.timedAutomata.bnf.BnfPackage;
import org.emftext.language.timedAutomata.bnf.declarations.DeclarationsPackage;
import org.emftext.language.timedAutomata.bnf.declarations.impl.DeclarationsPackageImpl;
import org.emftext.language.timedAutomata.bnf.expressions.ExpressionsPackage;
import org.emftext.language.timedAutomata.bnf.expressions.impl.ExpressionsPackageImpl;
import org.emftext.language.timedAutomata.bnf.impl.BnfPackageImpl;
import org.emftext.language.timedAutomata.bnf.types.TypesPackage;
import org.emftext.language.timedAutomata.bnf.types.impl.TypesPackageImpl;
import org.emftext.language.timedAutomata.core.CorePackage;
import org.emftext.language.timedAutomata.core.impl.CorePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimedAutomataPackageImpl extends EPackageImpl implements TimedAutomataPackage {

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
	 * @see org.emftext.language.timedAutomata.TimedAutomataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TimedAutomataPackageImpl() {
		super(eNS_URI, TimedAutomataFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TimedAutomataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TimedAutomataPackage init() {
		if (isInited) return (TimedAutomataPackage)EPackage.Registry.INSTANCE.getEPackage(TimedAutomataPackage.eNS_URI);

		// Obtain or create and register package
		TimedAutomataPackageImpl theTimedAutomataPackage = (TimedAutomataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TimedAutomataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TimedAutomataPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SimpleGraphPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI) : BasePackage.eINSTANCE);
		BnfPackageImpl theBnfPackage = (BnfPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BnfPackage.eNS_URI) instanceof BnfPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BnfPackage.eNS_URI) : BnfPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		DeclarationsPackageImpl theDeclarationsPackage = (DeclarationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) instanceof DeclarationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) : DeclarationsPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);

		// Create package meta-data objects
		theTimedAutomataPackage.createPackageContents();
		theBasePackage.createPackageContents();
		theBnfPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theDeclarationsPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theCorePackage.createPackageContents();

		// Initialize created meta-data
		theTimedAutomataPackage.initializePackageContents();
		theBasePackage.initializePackageContents();
		theBnfPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theDeclarationsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theCorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTimedAutomataPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TimedAutomataPackage.eNS_URI, theTimedAutomataPackage);
		return theTimedAutomataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimedAutomataFactory getTimedAutomataFactory() {
		return (TimedAutomataFactory)getEFactoryInstance();
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
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
		BnfPackage theBnfPackage = (BnfPackage)EPackage.Registry.INSTANCE.getEPackage(BnfPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theBasePackage);
		getESubpackages().add(theBnfPackage);
		getESubpackages().add(theCorePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters

		// Create resource
		createResource(eNS_URI);
	}

} //TimedAutomataPackageImpl
