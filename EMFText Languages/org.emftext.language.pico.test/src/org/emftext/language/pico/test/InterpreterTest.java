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
package org.emftext.language.pico.test;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.pico.Program;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpretationContext;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpreter;
import org.emftext.language.pico.resource.pico.util.PicoResourceUtil;

import junit.framework.TestCase;

public class InterpreterTest extends TestCase {

	public void testInterpretationOfTest1() {
		PicoInterpretationContext context = interpret("test1.pico");
		assertEquals(5, context.getValue("var1"));
		assertEquals("abc", context.getValue("var2"));
	}

	public void testInterpretationOfTest2() {
		PicoInterpretationContext context = interpret("test2.pico");
		assertEquals(1, context.getValue("var1"));
	}

	public void testInterpretationOfTest3() {
		PicoInterpretationContext context = interpret("test3.pico");
		assertEquals(2, context.getValue("var1"));
	}

	public void testInterpretationOfTest4() {
		PicoInterpretationContext context = interpret("test4.pico");
		assertEquals(11, context.getValue("var1"));
	}

	public void testInterpretationOfTest5() {
		PicoInterpretationContext context = interpret("test5.pico");
		assertEquals(160, context.getValue("var1"));
	}

	private PicoInterpretationContext interpret(String fileName) {
		URI uri = URI.createFileURI("input/" + fileName);
		Program program = PicoResourceUtil.getResourceContent(uri);
		PicoInterpretationContext context = new PicoInterpretationContext();
		PicoInterpreter interpreter = new PicoInterpreter();
		interpreter.addObjectToInterprete(program);
		interpreter.interprete(context);
		return context;
	}
}
