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
package org.emftext.language.simplemath.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.emftext.language.simplemath.Additive;
import org.emftext.language.simplemath.Expression;
import org.emftext.language.simplemath.IntegerLiteralExp;

public class SimpleMathTest extends AbstractSimpleMathTestCase {
	
	public void testOnePlusTwo() {
		try {
			Expression expression = loadResource(new FileInputStream("input" + File.separator + "one_plus_two.sm"), "one_plus_two.sm");
			assert expression instanceof Additive;
			Additive additive = (Additive) expression;
			// check left
			Expression leftAtom = additive.getLeft();
			assertTrue(leftAtom instanceof IntegerLiteralExp);
			IntegerLiteralExp left = (IntegerLiteralExp) leftAtom;
			assertEquals(1, left.getIntValue());
			
			// check operator
			assertEquals("+", additive.getOperator());
			
			// check right
			Expression rightAtom = additive.getRight();
			assertTrue(rightAtom instanceof IntegerLiteralExp);
			IntegerLiteralExp right = (IntegerLiteralExp) rightAtom;
			assertEquals(2, right.getIntValue());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	public void testBrackets() {
		try {
			Expression expression = loadResource(new FileInputStream("input" + File.separator + "brackets.sm"), "brackets.sm");
			assertNotNull(expression);
			// TODO check left
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Override
	public Map<?, ?> getLoadOptions() {
		return Collections.emptyMap();
	}
}
