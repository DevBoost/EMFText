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
		assertNotNull("No expected insert strings given for file " + filename, expectedInsertStrings);
		checkInsertStrings(file, expectedInsertStrings);
	}

	/**
	 * Creates a test suite that checks whether the CodeCompletionHelper
	 * returns the correct string to insert at the cursor position.
	 *
	 * @return
	 */
	@Parameters(name = "Check expected insert strings: {0}")
	public static Collection<Object[]> getTestData() {
		Collection<Object[]> testData = new ArrayList<Object[]>();
		File inputFolder = new File(INPUT_DIR);
		for (File file : listFilesRecursivly(inputFolder, new TestFileFilter(".cct1", ".cct3", ".cct4", ".cs", ".customer"))) {
			testData.add(new Object[] {file});
		}
		return testData;
	}
}
