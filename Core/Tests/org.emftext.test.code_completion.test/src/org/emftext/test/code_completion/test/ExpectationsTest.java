package org.emftext.test.code_completion.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.emftext.test.code_completion.test.access.IExpectedTerminal;
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
