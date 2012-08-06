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
package org.emftext.test;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsMinimalModelHelper;

/**
 * A test for the MinimalModelHelper class.
 */
public class MinimalModelHelperTest extends TestCase {

	public void testSimpleModelCreation() {
		EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName("Root Package");

		EClass rootClass = EcoreFactory.eINSTANCE.createEClass();
		rootClass.setName("Root");

		rootPackage.getEClassifiers().add(rootClass);

		EObject instance = new CsMinimalModelHelper().getMinimalModel(
			rootClass,
			new EClass[] {rootClass}
		);
		assertTrue(instance.eClass() == rootClass);
	}

	public void testSimpleReferenceCreation() {
		EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName("Root Package");

		EClass rootClass = EcoreFactory.eINSTANCE.createEClass();
		rootClass.setName("Root");

		EClass typeClass = EcoreFactory.eINSTANCE.createEClass();
		typeClass.setName("Type");

		EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName("referenceToType");
		reference.setContainment(true);
		reference.setLowerBound(2);
		reference.setUpperBound(-1);
		reference.setEType(typeClass);

		rootClass.getEStructuralFeatures().add(reference);

		rootPackage.getEClassifiers().add(rootClass);
		rootPackage.getEClassifiers().add(typeClass);

		EObject instance = new CsMinimalModelHelper().getMinimalModel(
				rootClass,
				new EClass[] {rootClass, typeClass}
			);
		assertTrue(instance.eClass() == rootClass);
		Object referenceValueObject = instance.eGet(reference);
		assertTrue(referenceValueObject instanceof List<?>);
		List<?> referenceValue = (List<?>) referenceValueObject;
		assertEquals(2, referenceValue.size());
	}

	public void testAttributeInitialization() {
		EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName("Root Package");

		EClass rootClass = EcoreFactory.eINSTANCE.createEClass();
		rootClass.setName("Root");

		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("a1");
		attribute.setEType(EcorePackage.eINSTANCE.getEString());

		rootClass.getEStructuralFeatures().add(attribute);

		rootPackage.getEClassifiers().add(rootClass);

		EObject instance = new CsMinimalModelHelper().getMinimalModel(
				rootClass,
				new EClass[] {rootClass}
			);
		assertTrue(instance.eClass() == rootClass);
		Object referenceValueObject = instance.eGet(attribute);
		assertTrue(referenceValueObject instanceof String);
		String referenceValue = (String) referenceValueObject;
		assertEquals("someA1", referenceValue);
	}

	public void testReferenceToAbstractType() {
		EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName("Root Package");

		EClass rootClass = EcoreFactory.eINSTANCE.createEClass();
		rootClass.setName("Root");

		EClass superClass = EcoreFactory.eINSTANCE.createEClass();
		superClass.setName("Super");
		superClass.setAbstract(true);

		EClass concreteClassA = EcoreFactory.eINSTANCE.createEClass();
		concreteClassA.setName("A");
		concreteClassA.getESuperTypes().add(superClass);

		EClass concreteClassB = EcoreFactory.eINSTANCE.createEClass();
		concreteClassB.setName("B");
		concreteClassB.getESuperTypes().add(superClass);

		EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName("referenceToType");
		reference.setContainment(true);
		reference.setLowerBound(1);
		reference.setUpperBound(-1);
		reference.setEType(superClass);

		rootClass.getEStructuralFeatures().add(reference);

		rootPackage.getEClassifiers().add(rootClass);
		rootPackage.getEClassifiers().add(superClass);
		rootPackage.getEClassifiers().add(concreteClassA);
		rootPackage.getEClassifiers().add(concreteClassB);

		EObject instance = new CsMinimalModelHelper().getMinimalModel(
				rootClass,
				new EClass[] {rootClass, superClass, concreteClassA, concreteClassB}
			);
		assertTrue(instance.eClass() == rootClass);
		Object referenceValueObject = instance.eGet(reference);
		assertTrue(referenceValueObject instanceof List<?>);
		List<?> referenceValue = (List<?>) referenceValueObject;
		assertEquals(1, referenceValue.size());
	}

	public void testRecursion() {
		EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName("Root Package");

		EClass rootClass = EcoreFactory.eINSTANCE.createEClass();
		rootClass.setName("RecursiveRoot");

		EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName("recursiveReference");
		reference.setContainment(true);
		reference.setLowerBound(2);
		reference.setUpperBound(-1);
		reference.setEType(rootClass);

		rootClass.getEStructuralFeatures().add(reference);

		rootPackage.getEClassifiers().add(rootClass);

		EObject instance = new CsMinimalModelHelper().getMinimalModel(
				rootClass,
				new EClass[] {rootClass}
			);
		assertTrue(instance.eClass() == rootClass);
		Object referenceValueObject = instance.eGet(reference);
		assertTrue(referenceValueObject instanceof List<?>);
		List<?> referenceValue = (List<?>) referenceValueObject;
		assertEquals(0, referenceValue.size());
	}

}
