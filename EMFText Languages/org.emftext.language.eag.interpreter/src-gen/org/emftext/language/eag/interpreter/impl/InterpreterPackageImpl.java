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
package org.emftext.language.eag.interpreter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.emftext.language.eag.EagPackage;
import org.emftext.language.eag.interpreter.Interpreter;
import org.emftext.language.eag.interpreter.InterpreterFactory;
import org.emftext.language.eag.interpreter.InterpreterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InterpreterPackageImpl extends EPackageImpl implements InterpreterPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interpreterEClass = null;

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
	 * @see org.emftext.language.eag.interpreter.InterpreterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InterpreterPackageImpl() {
		super(eNS_URI, InterpreterFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InterpreterPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InterpreterPackage init() {
		if (isInited) return (InterpreterPackage)EPackage.Registry.INSTANCE.getEPackage(InterpreterPackage.eNS_URI);

		// Obtain or create and register package
		InterpreterPackageImpl theInterpreterPackage = (InterpreterPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InterpreterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InterpreterPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EagPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInterpreterPackage.createPackageContents();

		// Initialize created meta-data
		theInterpreterPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInterpreterPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InterpreterPackage.eNS_URI, theInterpreterPackage);
		return theInterpreterPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterpreter() {
		return interpreterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterpreterFactory getInterpreterFactory() {
		return (InterpreterFactory)getEFactoryInstance();
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
		interpreterEClass = createEClass(INTERPRETER);
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
		EagPackage theEagPackage = (EagPackage)EPackage.Registry.INSTANCE.getEPackage(EagPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(interpreterEClass, Interpreter.class, "Interpreter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(interpreterEClass, ecorePackage.getEJavaObject(), "interpret", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEagPackage.getAttributeGrammar(), "grammar", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEagPackage.getAttribute(), "attribute", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InterpreterPackageImpl
