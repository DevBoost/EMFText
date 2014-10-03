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

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.test.code_completion.test.util.TestFileFilter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExpectedInsertStringsTest extends AbstractCodeCompletionTestCase {

	private final File file;

	public ExpectedInsertStringsTest(File file) {
		super();
		this.file = file;
	}

	@Test
	@Ignore("Must be ingored until test data has been adjusted")
	public void checkInsertStrings() {
		String filename = file.getName();
		if (!accept(filename)) {
			return;
		}
		String[] expectedInsertStrings = getExpectedInsertStrings(file);
		assertNotNull("No expected insert strings given for file " + filename,
				expectedInsertStrings);
		checkInsertStrings(file, expectedInsertStrings);
	}

	/**
	 * Creates a test suite that checks whether the CodeCompletionHelper returns
	 * the correct string to insert at the cursor position.
	 *
	 * @return
	 */
	@Parameters(name = "Check expected insert strings: {0}")
	public static Collection<Object[]> getTestData() {
		Collection<Object[]> testData = new ArrayList<Object[]>();
		File inputFolder = new File(INPUT_DIR);

		// FIXME: temporarily disabled all cct tests, except cct5 test.
		//
		// TestFileFilter filter = new TestFileFilter(".cct1", ".cct3", ".cct4",
		// ".cct5", ".cs", ".customer");
		TestFileFilter filter = new TestFileFilter(".cct5");

		for (File file : listFilesRecursivly(inputFolder, filter)) {
			testData.add(new Object[] { file });
		}
		return testData;
	}
}
