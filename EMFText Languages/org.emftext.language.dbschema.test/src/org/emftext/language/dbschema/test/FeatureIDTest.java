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
package org.emftext.language.dbschema.test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.dbschema.DbschemaPackage;

import junit.framework.TestCase;

public class FeatureIDTest extends TestCase {

	public void testFeatureID() {
		EClass attColumnClass = DbschemaPackage.eINSTANCE.getAttributeColumn();
		
		assertFeatureName(attColumnClass, "size", DbschemaPackage.ATTRIBUTE_COLUMN__SIZE);
		assertFeatureName(attColumnClass, "name", DbschemaPackage.ATTRIBUTE_COLUMN__NAME);
		assertFeatureName(attColumnClass, "primary", DbschemaPackage.ATTRIBUTE_COLUMN__PRIMARY);
		assertFeatureName(attColumnClass, "type", DbschemaPackage.ATTRIBUTE_COLUMN__TYPE);
	}

	private void assertFeatureName(EClass eClass, String expectedName, int featureID) {
		EStructuralFeature feature = eClass.getEStructuralFeature(featureID);
		assertEquals(expectedName, feature.getName());
	}
}
