/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.test.bracket_handling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsAutoEditStrategy;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * The {@link AutoEditStrategyTest} verifies the correct behavior for entering
 * opening and closing brackets of different types.
 * 
 * TODO Add test case for removing opening instant-insert bracket (must remove
 *      automatically inserted closing bracket)
 */
@RunWith(Parameterized.class)
public class AutoEditStrategyTest {
	
	private static final String CURSOR = "<CURSOR>";

	// We must create a subclass of class DocumentCommand because
	// DocumentCommand does not have a public constructor.
	private class DocumentCommandStub extends DocumentCommand {
	}
	
	private String input;
	private String textToInsert;
	private String expected;
	
	private CsAutoEditStrategy stategy;

	public AutoEditStrategyTest(String input, String textToInsert, String expected) {
		super();
		System.out.println("------------------------------------------------");
		this.input = input;
		this.textToInsert = textToInsert;
		this.expected = expected;
	}
	
	@Parameters
	public static Collection<Object[]> getTestData() {
		Collection<Object[]> testData = new ArrayList<Object[]>();
		// simulate entering of line breaks
		testData.add(new Object[] {"abc <CURSOR>", "\n", "abc \n<CURSOR>"});
		testData.add(new Object[] {"abc {<CURSOR>", "\n", "abc {\n\t<CURSOR>\n}"});
		testData.add(new Object[] {"abc {  <CURSOR>", "\n", "abc {  \n\t<CURSOR>\n}"});

		testData.add(new Object[] {"abc (<CURSOR>", "\n", "abc (\n<CURSOR>"});

		// simulate entering of brackets
		testData.add(new Object[] {"abc <CURSOR>", "{", "abc {<CURSOR>"});
		testData.add(new Object[] {"abc <CURSOR>", "(", "abc (<CURSOR>)"});
		return testData;
	}

	@Before
	@SuppressWarnings("deprecation")
	public void setUp() {
		stategy = new CsAutoEditStrategy();
		
		CsBracketSet bracketSet = new CsBracketSet();
		bracketSet.addBracketPair("{", "}", false, true);
		bracketSet.addBracketPair("(", ")", false, false);
		stategy.setBracketSet(bracketSet);
	}

	@Test
	public void testBacketHandling() {

		IDocument document = new Document();
		document.set(input.replace(CURSOR, ""));
		DocumentCommand command = new DocumentCommandStub();
		command.text = textToInsert;
		// insert text at cursor position
		command.offset = input.indexOf(CURSOR);
		// position cursor at correct position in input text
		command.caretOffset = input.indexOf(CURSOR);
		command.shiftsCaret = true;
		stategy.customizeDocumentCommand(document, command);
		System.out.println("text = '" + command.text + "'");
		String expectedDocumentAfter = expected.replace(CURSOR, "");

		System.out.println("Cursor before " + command.caretOffset);
		executeCommand(document, command);
		System.out.println("Cursor after " + command.caretOffset);
		String documentAfter = document.get();
		System.out.println("Document after: '" + documentAfter + "'");
		assertEquals(expectedDocumentAfter, documentAfter);
		int expectedCursorOffset = expected.indexOf(CURSOR);
		assertEquals("Cursor at unexpected position", expectedCursorOffset, command.caretOffset);
	}

	// We must invoke the execute() method of class DocumentCommand using Java 
	// reflection because it is not public.
	private void executeCommand(IDocument document, DocumentCommand command) {
		Method executeMethod;
		try {
			executeMethod = DocumentCommand.class.getDeclaredMethod("execute", IDocument.class);
			executeMethod.setAccessible(true);
			executeMethod.invoke(command, document);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
