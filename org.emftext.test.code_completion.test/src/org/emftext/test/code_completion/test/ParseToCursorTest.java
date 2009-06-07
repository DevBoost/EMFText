package org.emftext.test.code_completion.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.ExpectedCsString;
import org.emftext.runtime.resource.impl.ExpectedStructuralFeature;
import org.emftext.runtime.resource.impl.IExpectedElement;
import org.emftext.test.code_completion.Code_completionPackage;
import org.emftext.test.code_completion.resource.cct.CctParser;

public class ParseToCursorTest extends TestCase {

	private static final Code_completionPackage CCT_PACKAGE = Code_completionPackage.eINSTANCE;
	private static final String INPUT_DIR = "input";
	private static final String CURSOR_MARKER = "<CURSOR>";

	public static Test suite() {
		TestSuite suite = new TestSuite("Test code completion");
		File inputFolder = new File(INPUT_DIR);
		for (final File file : inputFolder.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".cct");
			}
		})) {
			suite.addTest(new TestCase("Parse " + file.getName()) {
				public void runTest() {
					try {
						new ParseToCursorTest().parseToCursor(file);
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

	public ParseToCursorTest() {
		super();
		setUpExpectedElementsMap();
	}

	private void setUpExpectedElementsMap() {
		expectedElementsMap = new HashMap<String, Object>();
		expectedElementsMap.put("KeywordClassExpected1.cct", "class");
		expectedElementsMap.put("KeywordClassExpected2.cct", "class");
		// this one has an additional space after the cursor
		expectedElementsMap.put("KeywordClassExpected3.cct", "class");
		expectedElementsMap.put("EnumVisibilityExpected1.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedElementsMap.put("NameExpected1.cct", CCT_PACKAGE.getNamedElement_Name());
		expectedElementsMap.put("NameExpected2.cct", CCT_PACKAGE.getNamedElement_Name());
		expectedElementsMap.put("BracketExpected.cct", "{");
		expectedElementsMap.put("TypeExpected.cct", CCT_PACKAGE.getTypedElement_Type());
		expectedElementsMap.put("EnumVisibilityExpected2.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedElementsMap.put("EnumVisibilityExpected3.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedElementsMap.put("NameExpected3.cct", CCT_PACKAGE.getNamedElement_Name());
		expectedElementsMap.put("EnumVisibilityExpected5.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedElementsMap.put("EnumVisibilityExpected4.cct", CCT_PACKAGE.getModifiable_Visibility());
	}
	
	private void parseToCursor(File file) {
		String filename = file.getName();
		Object expectedElement = expectedElementsMap.get(filename);
		assertNotNull("No expected element given for file " + filename, expectedElement);
		if (expectedElement instanceof String) {
			parseToCursor(file, new ExpectedCsString((String) expectedElement));
		} else if (expectedElement instanceof EStructuralFeature) {
			parseToCursor(file, new ExpectedStructuralFeature((EStructuralFeature) expectedElement));
		} else {
			fail("Unknown type of expected element given for file " + filename);
		}
	}
	
	private void parseToCursor(File file, IExpectedElement expectedCompletionElement) {
		System.out.println("-------- " + file);
		String fileContent = getFileContent(file);
		int cursorIndex = getCursorMarkerIndex(fileContent);
		System.out.println("-------- CURSOR AT " + cursorIndex);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		InputStream inputStream = new ByteArrayInputStream(contentWithoutMarker.getBytes());
		CctParser factory = new CctParser();
		AbstractEMFTextParser parser = (AbstractEMFTextParser) factory.createInstance(inputStream, null);

		final IExpectedElement actualElement = parser.parseToIndex(cursorIndex, null);
		if (actualElement == null) {
			fail("Parser must return an expected elemet.");
		}
		assertEquals(expectedCompletionElement, actualElement);
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
