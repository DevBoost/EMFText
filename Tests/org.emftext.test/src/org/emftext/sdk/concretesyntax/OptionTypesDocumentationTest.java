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
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;

import junit.framework.TestCase;

/**
 * A test that checks whether all literals of the OptionTypes
 * enumeration are documented.
 */
public class OptionTypesDocumentationTest extends TestCase {

	public void testDocumentation() {
		EEnum optionTypes = ConcretesyntaxPackage.eINSTANCE.getOptionTypes();
		EList<EEnumLiteral> optionLiterals = optionTypes.getELiterals();
		for (EEnumLiteral optionLiteral : optionLiterals) {
			String documentation = EcoreUtil.getDocumentation(optionLiteral);
			assertNotNull("OptionType " + optionLiteral.getName() + " needs documentation.", documentation);
			assertTrue("OptionType " + optionLiteral.getName() + " has empty documentation.", documentation.trim().length() > 0);
		}
	}
}
