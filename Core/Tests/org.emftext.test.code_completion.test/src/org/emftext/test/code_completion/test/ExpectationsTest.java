/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.test.code_completion.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.emftext.test.code_completion.test.access.IExpectedTerminal;
import org.emftext.test.code_completion.test.util.TestFileFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExpectationsTest extends AbstractCodeCompletionTestCase {
	
	private final File file;
	
	public ExpectationsTest(File file) {
		super();
		this.file = file;
	}

	@Test
	public void checkExpectations() {
		System.out.println("-- checkExpectations(" + file.getName() + ")");
		String filename = file.getName();
		if (!accept(filename)) {
			return;
		}
		List<IExpectedTerminal> expectedElements = getExpectations(file, ".expectations");
		//System.out.println("- Actual       from " + file.getName() + "");
		for (IExpectedTerminal expectedElement : expectedElements) {
			System.out.println("EXPECTED ELEMENT: " + expectedElement);
		}
		assertExpectedElementsList(file, expectedElements);
	}

	@Parameters(name = "Check expectations: {0}")
	public static Collection<Object[]> getTestData() {
		Collection<Object[]> testData = new ArrayList<Object[]>();
		File inputFolder = new File(INPUT_DIR);
		for (File file : listFilesRecursivly(inputFolder, new TestFileFilter("BracketExpected.cct1", ".cct2"))) {
			testData.add(new Object[] {file});
		}
		return testData;
	}
}
