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
package org.emftext.language.simplec.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.emftext.language.simplec.CPackage;
import org.emftext.language.simplec.CompilationUnit;
import org.emftext.language.simplec.Definition;
import org.emftext.language.simplec.Method;
import org.emftext.language.simplec.Statement;
import org.emftext.language.simplec.Variable;

public class CTest extends AbstractCTestCase {

	public void testVariables() {
		try {
			CompilationUnit unit = (CompilationUnit)loadResource(new FileInputStream("input" + File.separator + "variables.c"), "variables.c", null);
			List<Definition> defs = unit.getDefinitions();
			assertEquals(1, defs.size());
			Definition firstDef = defs.get(0);
			assertTrue(firstDef instanceof Variable);
			Variable v1 = (Variable) firstDef;
			assertEquals("a", v1.getName());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	public void testMethodFragment() {
		try {
			Method method = (Method)loadResource(new FileInputStream("input" + File.separator + "method.c"), "method.c", CPackage.eINSTANCE.getMethod());
			List<Statement> statements = method.getStatements();
			assertEquals(1, statements.size());
		} catch (IOException e) {
			fail(e.getMessage());
		}

	}
}
