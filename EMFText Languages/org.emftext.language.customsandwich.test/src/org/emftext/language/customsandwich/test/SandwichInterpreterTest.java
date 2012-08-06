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
package org.emftext.language.customsandwich.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.customsandwich.resource.customsandwich.mopp.CustomsandwichResourceFactory;
import org.emftext.language.customer.resource.customer.mopp.CustomerResourceFactory;
import org.emftext.language.sandwich.resource.sandwich.mopp.SandwichResourceFactory;
import org.emftext.language.templateconcepts.interpreter.test.AbstractInterpreterTestCase;

public class SandwichInterpreterTest extends AbstractInterpreterTestCase {

	public void testSandwichInterpretation() {
		// basic test (input model is not used)
		testInterpretation("template1.customsandwich", "customer1.customer", "RECIPE myRecipe bread butter");
		// basic test for FOREACH loop and placeholder inside of the loop
		testInterpretation("template2.customsandwich", "customer2.customer", "RECIPE myRecipe bread i1 i2 i3 TOAST bread");
		// test loop variable
		testInterpretation("template3.customsandwich", "customer3.customer", "RECIPE myRecipe bread i1 i2 i3 TOAST bread");
	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"sandwich",
				new SandwichResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"customsandwich",
				new CustomsandwichResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"customer",
				new CustomerResourceFactory());
	}

	@Override
	protected String getInputFolder() {
		return "input";
	}

	@Override
	protected String getOutputFileExtension() {
		return "sandwich";
	}
}
