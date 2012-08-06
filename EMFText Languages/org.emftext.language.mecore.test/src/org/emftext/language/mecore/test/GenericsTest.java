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
package org.emftext.language.mecore.test;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.resource.mecore.mopp.MecoreWrapper;
import org.emftext.language.mecore.resource.mecore.util.MecoreResourceUtil;

public class GenericsTest extends TestCase {

	public void testBuildingGenerics1() {
		// create test model in memory
		String exampleModel = 
			"test <http://www.test.org/>\n" +
			"ElementProperty<T> (value T)\n"+
			"IntegerProperty : ElementProperty<EIntegerObject>";

		EPackage ePackage = createAndWrapModel(exampleModel);
		
		EClassifier elementPropertyClassifier = ePackage.getEClassifier("ElementProperty");
		assertNotNull(elementPropertyClassifier);
		
		List<ETypeParameter> typeParameters = elementPropertyClassifier.getETypeParameters();
		assertNotNull(typeParameters);
		assertEquals("ElementProperty must have a type parameter.", 1, typeParameters.size());

		EClassifier integerPropertyClassifier = ePackage.getEClassifier("IntegerProperty");
		assertNotNull(integerPropertyClassifier);
		
		assertTrue(integerPropertyClassifier instanceof EClass);
		EClass integerPropertyClass = (EClass) integerPropertyClassifier;
		
		typeParameters = integerPropertyClassifier.getETypeParameters();
		assertNotNull(typeParameters);
		assertEquals("IntegerProperty must not have type parameters.", 0, typeParameters.size());
		
		List<EGenericType> genericSuperTypes = integerPropertyClass.getEGenericSuperTypes();
		assertEquals("IntegerProperty must have one generic super type.", 1, genericSuperTypes.size());
		
		EGenericType genericSuperType = genericSuperTypes.get(0);
		assertSame("Generic super type must be correct.", genericSuperType.getEClassifier(), elementPropertyClassifier);

		List<EGenericType> superTypeArguments = genericSuperType.getETypeArguments();
		assertEquals("Generic super type must have one type argument.", 1, superTypeArguments.size());
		
		assertEquals("Generic super type argument must be correct.", superTypeArguments.get(0).getEClassifier().getName(), "EIntegerObject");
		
		List<EGenericType> typeArguments = superTypeArguments;
		assertEquals("Super type of IntegerProperty must have one type argument.", 1, typeArguments.size());
	}
	
	public void testBuildingGenerics2() {
		
		String exampleModel = 
				"test <http://www.test.org/>\n" +
				"NamedElement\n" +
				"ClassA<T : NamedElement>";

		EPackage ePackage = createAndWrapModel(exampleModel);
		
		EClassifier classifierA = ePackage.getEClassifier("ClassA");
		assertNotNull(classifierA);

		EClassifier namedElementClassifier = ePackage.getEClassifier("NamedElement");
		assertNotNull(namedElementClassifier);
		
		assertTrue(classifierA instanceof EClass);
		EClass classA = (EClass) classifierA;
		
		List<ETypeParameter> typeParameters = classA.getETypeParameters();
		assertNotNull(typeParameters);
		assertEquals("Class A must have one type parameter.", 1, typeParameters.size());
		ETypeParameter typeParameter = typeParameters.get(0);
		assertEquals("T", typeParameter.getName());
		
		List<EGenericType> bounds = typeParameter.getEBounds();
		assertEquals("Type parameter T must have one bound.", 1, bounds.size());
		
		EGenericType bound = bounds.get(0);
		EClassifier lowerBound = bound.getEClassifier();
		assertNotNull(lowerBound);
		assertEquals(lowerBound, namedElementClassifier);
	}

	private EPackage createAndWrapModel(String exampleModel) {
		MPackage mPackage = MecoreResourceUtil.getResourceContent(exampleModel);
		EcoreUtil.resolveAll(mPackage);
		
		List<Diagnostic> errors = mPackage.eResource().getErrors();
		for (Diagnostic error : errors) {
			System.out.println("GenericsTest.testBuildingGenerics() " + error);
		}
		assertEquals("Test resource must not contain errors.", 0, errors.size());
		
		// check result
		EPackage ePackage = new MecoreWrapper().wrapMPackage(mPackage, null);
		assertNotNull(ePackage);
		return ePackage;
	}
}
