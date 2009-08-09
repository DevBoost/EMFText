package org.emftext.test.code_completion.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.IExpectedElement;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.impl.code_completion.CodeCompletionHelper;
import org.emftext.runtime.resource.impl.code_completion.ExpectedCsString;
import org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.CsMetaInformation;
import org.emftext.test.cct2.Cct2Package;
import org.emftext.test.cct2.resource.cct2.Cct2MetaInformation;
import org.emftext.test.code_completion.Code_completionPackage;
import org.emftext.test.code_completion.resource.cct.CctMetaInformation;

public class CodeCompletionTest extends TestCase {

	private static final class TestFileFilter implements FileFilter {
		public boolean accept(File file) {
			return file.isDirectory() || file.getName().endsWith(".cct2");
		}
	}

	private static final Code_completionPackage CCT_PACKAGE = Code_completionPackage.eINSTANCE;
	private static final Cct2Package CCT2_PACKAGE = Cct2Package.eINSTANCE;
	private static final ConcretesyntaxPackage CS_PACKAGE = ConcretesyntaxPackage.eINSTANCE;
	private static final String INPUT_DIR = "input";
	private static final String CURSOR_MARKER = "<CURSOR>";

	public static Test suite() {
		registerSyntaxes();
		
		TestSuite suite = new TestSuite("All tests");
		TestSuite suite1 = createExpectedElementsSuite();
		TestSuite suite2 = createExpectedInsertStringsSuite();
		
		suite.addTest(suite1);
		suite.addTest(suite2);
		return suite;
	}

	private static void registerSyntaxes() {
		EMFTextRuntimePlugin.getConcreteSyntaxRegistry().add(new CsMetaInformation());
		EMFTextRuntimePlugin.getConcreteSyntaxRegistry().add(new CctMetaInformation());
		EMFTextRuntimePlugin.getConcreteSyntaxRegistry().add(new Cct2MetaInformation());
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
		for (final File file : listFilesRecursivly(inputFolder, new TestFileFilter())) {
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

	private static List<File> listFilesRecursivly(File inputFolder,
			FileFilter filter) {
		List<File> result = new ArrayList<File>();
		for (File file : inputFolder.listFiles(filter)) {
			if (file.isDirectory()) {
				result.addAll(listFilesRecursivly(file, filter));
			} else {
				result.add(file);
			}
		}
		return result;
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
		for (final File file : listFilesRecursivly(inputFolder, new TestFileFilter())) {
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

		expectedElementsMap.put("EnumVisibilityExpected6.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedInsertStringsMap.put("EnumVisibilityExpected6.cct", new String[] {"private"});

		expectedElementsMap.put("EnumVisibilityExpected7.cct", CCT_PACKAGE.getModifiable_Visibility());
		expectedInsertStringsMap.put("EnumVisibilityExpected7.cct", new String[] {"public", "private"});

		// this one has an additional space after the cursor
		expectedElementsMap.put("KeywordClassExpected3.cct", "class");
		expectedInsertStringsMap.put("KeywordClassExpected3.cct", new String[] {"class"});

		expectedElementsMap.put("KeywordClassExpected4.cct", "class");
		expectedInsertStringsMap.put("KeywordClassExpected4.cct", new String[] {"class"});

		expectedElementsMap.put("MembersExpected1.cct", CCT_PACKAGE.getClass_Members());
		expectedInsertStringsMap.put("MembersExpected1.cct", new String[] {"public", "private"});

		// cs examples
		expectedElementsMap.put("OptionExpected1.cs", CS_PACKAGE.getConcreteSyntax_Options());
		expectedInsertStringsMap.put("OptionExpected1.cs", new String[] {"override"});

		// cct2 examples
		expectedElementsMap.put("ExpectedA1.cct2", CCT2_PACKAGE.getStarSequence());
		expectedInsertStringsMap.put("ExpectedA1.cct2", new String[] {"a"});

		expectedElementsMap.put("ExpectedA2.cct2", CCT2_PACKAGE.getStarSequence());
		expectedInsertStringsMap.put("ExpectedA2.cct2", new String[] {"a"});

		expectedElementsMap.put("ExpectedB1.cct2", CCT2_PACKAGE.getStarSequence());
		expectedInsertStringsMap.put("ExpectedB1.cct2", new String[] {"b"});

		expectedElementsMap.put("ExpectedB2.cct2", CCT2_PACKAGE.getStarSequence());
		expectedInsertStringsMap.put("ExpectedB2.cct2", new String[] {"b"});
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
		List<IExpectedElement> expectedElements = new ArrayList<IExpectedElement>();
		if (expectedElement instanceof String) {
			final ExpectedCsString expectedCsString = new ExpectedCsString((String) expectedElement);
			expectedElements.add(expectedCsString);
		} else if (expectedElement instanceof EStructuralFeature) {
			final ExpectedStructuralFeature expectedStructuralFeature = new ExpectedStructuralFeature((EStructuralFeature) expectedElement, null, null);
			expectedElements.add(expectedStructuralFeature);
		} else if (expectedElement instanceof List<?>) {
			expectedElements.addAll((List<? extends IExpectedElement>) expectedElement);
		} else {
			fail("Unknown type of expected element given for file " + filename);
		}
		parseToCursor(file, expectedElements);
	}
	
	private void checkInsertStrings(File file, String[] expectedInsertStrings) {
		String fileContent = getFileContent(file);
		int cursorIndex = getCursorMarkerIndex(fileContent);
		System.out.println("-------- " + file + " - CURSOR AT " + cursorIndex);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		CodeCompletionHelper helper = new CodeCompletionHelper();
		Collection<String> proposals = helper.computeCompletionProposals(getMetaInformation(file), contentWithoutMarker, cursorIndex);
		assertNotNull("Proposal list should not be null", proposals);
		for (String proposal : proposals) {
			System.out.println("Found proposal \"" + proposal + "\"");
		}
		for (String expectedInsertString : expectedInsertStrings) {
			assertTrue("Proposal " + expectedInsertString + " expected.", proposals.contains(expectedInsertString));
		}
		assertEquals("Same number of proposals expected.", expectedInsertStrings.length, proposals.size());
	}

	private ITextResourcePluginMetaInformation getMetaInformation(File file) {
		String fileExtension = getFileExtension(file);
		return getMetaInformation(fileExtension);
	}

	private void parseToCursor(File file, List<IExpectedElement> expectedCompletionElement) {
		String fileContent = getFileContent(file);
		int cursorIndex = getCursorMarkerIndex(fileContent);
		System.out.println("-------- " + file + " - CURSOR AT " + cursorIndex);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		InputStream inputStream = new ByteArrayInputStream(contentWithoutMarker.getBytes());
		
		String fileExtension = getFileExtension(file);
		ITextParser parser = createParser(fileExtension, inputStream);
		assertNotNull("Parser should be created.", parser);
		
		final List<IExpectedElement> actualElements = parser.parseToExpectedElements(null);
		if (actualElements == null) {
			fail("Parser must return an expected elements list.");
		}
		if (actualElements.size() == 0) {
			fail("Parser must return at least one expected element.");
		}
		List<IExpectedElement> finalExpectedAtCursor = new CodeCompletionHelper().getExpectedElementsAt(contentWithoutMarker, cursorIndex, actualElements);
		assertEquals(expectedCompletionElement, finalExpectedAtCursor);
	}

	private String getFileExtension(File file) {
		final String filename = file.getName();
		String fileExtension = filename.substring(filename.lastIndexOf(".") + 1);
		return fileExtension;
	}

	private ITextResourcePluginMetaInformation getMetaInformation(String fileExtension) {
		for (ITextResourcePluginMetaInformation metaInformation : EMFTextRuntimePlugin.getConcreteSyntaxRegistry()) {
			if (metaInformation.getSyntaxName().equals(fileExtension)) {
				return metaInformation;
			}
		}
		fail("Could not find meta information for extension " + fileExtension);
		return null;
	}

	private ITextParser createParser(String fileExtension, InputStream inputStream) {
		return getMetaInformation(fileExtension).createParser(inputStream, null);
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

	private boolean accept(String filename) {
		return true;
	}
}
