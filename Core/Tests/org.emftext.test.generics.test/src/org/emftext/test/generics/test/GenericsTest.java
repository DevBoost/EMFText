/**
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
 *  
 */
package org.emftext.test.generics.test;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.test.generics.ConcreteTypeWithAttribute1;
import org.emftext.test.generics.ConcreteTypeWithAttribute2;
import org.emftext.test.generics.GenericsTestModel;
import org.emftext.test.generics.Type;
import org.emftext.test.generics.resource.generics.util.GenericsResourceUtil;

public class GenericsTest extends TestCase {

	public void testParsing() {
		GenericsTestModel model = GenericsResourceUtil.getResourceContent("ctype1 a ctype2 2");
		assertNotNull(model);
		
		Resource resource = model.eResource();
		List<Diagnostic> errors = resource.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println("GenericsTest.testParsing() " + diagnostic);
		}
		
		List<Type> types = model.getTypes();
		assertNotNull(types);
		assertEquals(2, types.size());

		Type type1 = types.get(0);
		assertTrue(type1 instanceof ConcreteTypeWithAttribute1);
		ConcreteTypeWithAttribute1 cType1 = (ConcreteTypeWithAttribute1) type1;
		assertEquals("a", cType1.getName());

		Type type2 = types.get(1);
		assertTrue(type2 instanceof ConcreteTypeWithAttribute2);
		ConcreteTypeWithAttribute2 cType2 = (ConcreteTypeWithAttribute2) type2;
		assertEquals(new Integer(2), cType2.getName());
	}
}
