package org.emftext.test.code_completion.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.IExpectedElement;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.code_completion.CodeCompletionHelper;
import org.emftext.runtime.resource.impl.code_completion.ExpectedCsString;
import org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature;
import org.emftext.test.code_completion.Code_completionPackage;
import org.emftext.test.code_completion.resource.cct.CctMetaInformation;
import org.emftext.test.code_completion.resource.cct.CctParser;

public class CodeCompletionTest extends TestCase {

	private boolean accept(String filename) {
		return true ||
			"BracketExpected3.cct".equals(filename) ||
			"EnumVisibilityExpected1.cct".equals(filename)
			;
	}

	private static final Code_completionPackage CCT_PACKAGE = Code_completionPackage.eINSTANCE;
	private static final String INPUT_DIR = "input";
	private static final String CURSOR_MARKER = "<CURSOR>";

	public static Test suite() {
		TestSuite suite = new TestSuite("All tests");
		TestSuite suite1 = createExpectedElementsSuite();
		TestSuite suite2 = createExpectedInsertStringsSuite();
		
		suite.addTest(suite1);
		suite.addTest(suite2);
		return suite;
	}

	/**
	 * Creates a test suite that checks whether the parse returns the correct
	 * expected elements at the cursor position.
	 * 
	 * @return
	 */
	private static TestSuite createExpectedElementsSuite() {
		TestSuite suite = new TestSuite("Test expected elements");
		File inputFolder = new File(INPUT_DIR);
		for (final File file : inputFolder.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".cct");
			}
		})) {
			suite.addTest(new TestCase("Parse " + file.getName()) {
				public void runTest() {
					try {
						new CodeCompletionTest().parseToCursor(file);
					}
					catch (Exception e) {
						e.printStackTrace();
						fail(e.getClass() +  ": " + e.getMessage());
					}
				}
			});
		}
		return suite;
	}

	/**
	 * Creates a test suite that checks whether the CodeCompletionHelper 
	 * returns the correct string to insert at the cursor position.
	 * 
	 * @return
	 */
	private static TestSuite createExpectedInsertStringsSuite() {
		TestSuite suite = new TestSuite("Test insert strings");
		File inputFolder = new File(INPUT_DIR);
		for (final File file : inputFolder.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".cct");
			}
		})) {
			suite.addTest(new TestCase("Parse " + file.getName()) {
				public void runTest() {
					try {
						new CodeCompletionTest().checkInsertStrings(file);
					}
					catch (Exception e) {
						e.printStackTrace();
						fail(e.getClass() +  ": " + e.getMessage());
					}
				}
			});
		}
		return suite;
	}

	private Map<String, Object> expectedElementsMap;
	private Map<String, String[]> expectedInsertStringsMap;

	public CodeCompletionTest() {
		super();
		setUpExpectedElementsMap();
	}

	private void setUpExpectedElementsMap() {
		expectedElementsMap = new HashMap<String, Object>();
		expectedInsertStringsMap = new HashMap<String, String[]>();
		
		expectedElementsMap.put("BracketExpected2.cct", "}");
		expectedInsertStringsMap.put("BracketExpected2.cct", new String[] {"}"});

		expectedElementsMap.put("BracketExpected1.cct", "{");
		expectedInsertStringsMap.put("BracketExpected1.cct", new String[] {"{"});

		expectedElementsMap.put("BracketExpected3.cct", "}");
		expectedInsertStringsMap.put("BracketExpected3.cct", new String[] {"}"});

		expectedElementsMap.put("KeywordClassExpected1.cct", "class");
		expectedInsertStringsMap.put("KeywordClassExpected1.cct", new String[] {"class"});
		
		expectedElementsMap.put("KeywordClassExpected2.cct", "class");
		expectedInsertStringsMap.put("KeywordClassExpected2.cct", new String[] {"class"});

		expectedElementsMap.put("EnumVisibilityExpected1.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedInsertStringsMap.put("EnumVisibilityExpected1.cct", new String[] {"public", "private"});

		expectedElementsMap.put("NameExpected1.cct", CCT_PACKAGE.getNamedElement_Name());
		expectedInsertStringsMap.put("NameExpected1.cct", new String[] {"someName"});

		expectedElementsMap.put("NameExpected2.cct", CCT_PACKAGE.getNamedElement_Name());
		expectedInsertStringsMap.put("NameExpected2.cct", new String[] {"someName"});

		expectedElementsMap.put("TypeExpected.cct", CCT_PACKAGE.getTypedElement_Type());
		expectedInsertStringsMap.put("TypeExpected.cct", new String[] {"SomeName"});

		expectedElementsMap.put("EnumVisibilityExpected2.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedInsertStringsMap.put("EnumVisibilityExpected2.cct", new String[] {"public", "private"});

		expectedElementsMap.put("EnumVisibilityExpected3.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedInsertStringsMap.put("EnumVisibilityExpected3.cct", new String[] {"public", "private"});

		expectedElementsMap.put("NameExpected3.cct", CCT_PACKAGE.getNamedElement_Name());
		expectedInsertStringsMap.put("NameExpected3.cct", new String[] {"someName"});

		expectedElementsMap.put("EnumVisibilityExpected5.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedInsertStringsMap.put("EnumVisibilityExpected5.cct", new String[] {"public", "private"});

		// this one has an additional space after the cursor
		expectedElementsMap.put("KeywordClassExpected3.cct", "class");
		expectedInsertStringsMap.put("KeywordClassExpected3.cct", new String[] {"class"});

		expectedElementsMap.put("MembersExpected1.cct", CCT_PACKAGE.getClass_Members());
		expectedInsertStringsMap.put("MembersExpected1.cct", new String[] {"public", "private"});
	}
	
	private void checkInsertStrings(File file) {
		String filename = file.getName();
		if (!accept(filename)) {
			return;
		}
		String[] expectedInsertStrings = expectedInsertStringsMap.get(filename);
		assertNotNull("No expected insert strings given for file " + filename, expectedInsertStrings);
		checkInsertStrings(file, expectedInsertStrings);
	}
	
	private void parseToCursor(File file) {
		String filename = file.getName();
		if (!accept(filename)) {
			return;
		}
		Object expectedElement = expectedElementsMap.get(filename);
		assertNotNull("No expected element given for file " + filename, expectedElement);
		if (expectedElement instanceof String) {
			parseToCursor(file, new ExpectedCsString((String) expectedElement));
		} else if (expectedElement instanceof EStructuralFeature) {
			parseToCursor(file, new ExpectedStructuralFeature((EStructuralFeature) expectedElement, null, null));
		} else {
			fail("Unknown type of expected element given for file " + filename);
		}
	}
	
	private void checkInsertStrings(File file, String[] expectedInsertStrings) {
		String fileContent = getFileContent(file);
		int cursorIndex = getCursorMarkerIndex(fileContent);
		System.out.println("-------- " + file + " - CURSOR AT " + cursorIndex);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		CodeCompletionHelper helper = new CodeCompletionHelper();
		Collection<String> proposals = helper.computeCompletionProposals(new CctMetaInformation(), contentWithoutMarker, cursorIndex);
		assertNotNull("Proposal list should not be null", proposals);
		for (String expectedInsertString : expectedInsertStrings) {
			assertTrue("Proposal " + expectedInsertString + " expected.", proposals.contains(expectedInsertString));
		}
		assertEquals("Same number of proposals expected.", expectedInsertStrings.length, proposals.size());
	}

	private void parseToCursor(File file, IExpectedElement expectedCompletionElement) {
		String fileContent = getFileContent(file);
		int cursorIndex = getCursorMarkerIndex(fileContent);
		System.out.println("-------- " + file + " - CURSOR AT " + cursorIndex);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		InputStream inputStream = new ByteArrayInputStream(contentWithoutMarker.getBytes());
		CctParser factory = new CctParser();
		AbstractEMFTextParser parser = (AbstractEMFTextParser) factory.createInstance(inputStream, null);

		final List<IExpectedElement> actualElements = parser.parseToExpectedElements(null);
		if (actualElements == null) {
			fail("Parser must return an expected elements list.");
		}
		if (actualElements.size() == 0) {
			fail("Parser must return at least one expected element.");
		}
		IExpectedElement finalExpectedAtCursor = CodeCompletionHelper.getFinalExpectedElementAt(cursorIndex, actualElements);
		assertEquals(expectedCompletionElement, finalExpectedAtCursor);
	}

	private int getCursorMarkerIndex(String fileContent) {
		int cursorPosition = fileContent.indexOf(CURSOR_MARKER);
		assertTrue("Cursor position marker (" + CURSOR_MARKER + ") not found in input file.", cursorPosition >= 0);
		
		return cursorPosition;
	}

	private String removeCursorMarker(String fileContent) {
		// removed the marker
		return fileContent.replace(CURSOR_MARKER, "");
	}

	private String getFileContent(File file) {
		try {
			LineNumberReader reader = new LineNumberReader(new FileReader(file));
			StringBuffer contentBuffer = new StringBuffer();
			String line;
			boolean isFirst = true;
			while ((line = reader.readLine()) != null) {
				if (!isFirst) {
					contentBuffer.append("\n");
				}
				contentBuffer.append(line);
				isFirst = false;
			}
			return contentBuffer.toString();
		} catch (IOException e) {
			fail(e.getMessage());
			return null;
		}
	}
}
