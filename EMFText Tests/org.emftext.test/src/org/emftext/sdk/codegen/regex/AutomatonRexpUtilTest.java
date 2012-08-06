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
package org.emftext.sdk.codegen.regex;

import junit.framework.TestCase;

import org.emftext.sdk.regex.AutomatonRexpUtil;
import org.junit.Test;

/**
 * A test case for the conversion of ANTLR regular expression character 
 * expressions to the character expression syntax of the automaton library.
 */
public class AutomatonRexpUtilTest extends TestCase {

	@Test
	public void testANTLRToAutomatonEscaping() {
		// '\r' -> "<CR>"
		assertAutomatonCharExpression("\"\r\"", "'\\r'");
		// '\n' -> "<LF>"
		assertAutomatonCharExpression("\"\n\"", "'\\n'");
		// '\r\n' -> "<CR><LF>"
		assertAutomatonCharExpression("\"\r\n\"", "'\\r\\n'");

		// ' ' -> " "
		assertAutomatonCharExpression("\" \"", "' '");

		// '\\' -> "\\"
		assertAutomatonCharExpression("\"\\\\\"", "'\\\\'");
	}

	private void assertAutomatonCharExpression(
			String expectedAutomatonCharExpression,
			String antlrCharExpression) {
		String automatonCharExpression = AutomatonRexpUtil.escapeToAutomatonSyntax(antlrCharExpression);
		assertEquals(expectedAutomatonCharExpression, automatonCharExpression);
	}

}
