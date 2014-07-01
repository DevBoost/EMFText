package org.emftext.test.code_completion.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.emftext.test.code_completion.test.access.IExpectedTerminal;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExpectedBeforeAndAfterTest extends AbstractCodeCompletionTestCase {
	
	private final File file;
	
	public ExpectedBeforeAndAfterTest(File file) {
		super();
		this.file = file;
	}

	@Test
	@Ignore("Must be ingored until test data has been adjusted")
	public void checkExpectedBeforeAndAfter() {
		String filename = file.getName();
		if (!accept(filename)) {
			return;
		}
		List<IExpectedTerminal> expectedBefore = getExpectations(file, ".expected_before");
		List<IExpectedTerminal> expectedAfter = getExpectations(file, ".expected_after");
		assertExpectedElementsAtCursor(file, expectedBefore, expectedAfter);
	}

	/**
	 * Creates a test suite that checks whether the parse returns the correct
	 * expected elements at the cursor position.
	 *
	 * @return
	 */
	@Parameters(name = "Check expected before and after: {0}")
	public static Collection<Object[]> getTestData() {
		Collection<Object[]> testData = new ArrayList<Object[]>();
		File inputFolder = new File(INPUT_DIR);
		for (File file : listFilesRecursivly(inputFolder, new TestFileFilter(".cct1", ".cs"))) {
			testData.add(new Object[] {file});
		}
		return testData;
	}
}
