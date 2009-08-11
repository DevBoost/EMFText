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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
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
		//TestSuite suite1 = createExpectedElementsSuite();
		//TestSuite suite2 = createExpectedInsertStringsSuite();
		TestSuite suite3 = createExpectationsSuite();
		
		//suite.addTest(suite1);
		//suite.addTest(suite2);
		suite.addTest(suite3);
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
		TestSuite suite = new TestSuite("Test expected element at cursor position");
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

	private static TestSuite createExpectationsSuite() {
		TestSuite suite = new TestSuite("Test list of expected elements");
		File inputFolder = new File(INPUT_DIR);
		for (final File file : listFilesRecursivly(inputFolder, new TestFileFilter())) {
			suite.addTest(new TestCase("Parse " + file.getName()) {
				public void runTest() {
					try {
						new CodeCompletionTest().checkExpectations(file);
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
			final ExpectedCsString expectedCsString = new ExpectedCsString(0, false, (String) expectedElement);
			expectedElements.add(expectedCsString);
		} else if (expectedElement instanceof EStructuralFeature) {
			final ExpectedStructuralFeature expectedStructuralFeature = new ExpectedStructuralFeature(0, false, (EStructuralFeature) expectedElement, null, null);
			expectedElements.add(expectedStructuralFeature);
		//} else if (expectedElement instanceof List<?>) {
			//expectedElements.addAll((List<? extends IExpectedElement>) expectedElement);
		} else {
			fail("Unknown type of expected element given for file " + filename);
		}
		assertExpectedElementAtCursor(file, expectedElements);
	}
	
	private void checkExpectations(File file) {
		//System.out.println("-- checkExpectations(" + file.getName() + ")");
		String filename = file.getName();
		if (!accept(filename)) {
			return;
		}
		List<IExpectedElement> expectedElements = getExpectations(file);
		//System.out.println("- Actual       from " + file.getName() + "");
		for (IExpectedElement expectedElement : expectedElements) {
			System.out.println("EXPECTED ELEMENT: " + expectedElement);
		}
		assertExpectedElementsList(file, expectedElements);
	}
	
	private List<IExpectedElement> getExpectations(File file) {
		System.out.println("- Expectations from " + file.getName() + "");
		List<IExpectedElement> expectations = new ArrayList<IExpectedElement>();
		
		final String expectationFilePath = file.getPath() + ".expectations";
		File expectationFile = new File(expectationFilePath);
		assertTrue("Expectations file " + expectationFilePath + " not found.", expectationFile.exists());
		String expectationsContent = getFileContent(expectationFile);
		String[] lines = expectationsContent.split("\\r?\\n");
		for (String line : lines) {
			String[] parts = line.split("\\t");
			assertEquals("Invalid number of parts in line \"" + line + "\"", 3, parts.length);
			int beginIncl = Integer.parseInt(parts[0]);
			int beginExcl = Integer.parseInt(parts[1]);
			//int endExcl = Integer.parseInt(parts[2]);
			//int endIncl = Integer.parseInt(parts[3]);
			String expected = parts[2];
			if (expected.contains(":")) {
				// is EStructuralFeature
				String[] namespaceAndFeature = expected.split(":");
				String namespace = namespaceAndFeature[0];
				String featurePath = namespaceAndFeature[1];
				String[] classAndFeature = featurePath.split("\\.");
				String classname = classAndFeature[0];
				String featurename = classAndFeature[1];
				EStructuralFeature feature = findFeature(namespace, classname, featurename);
				assertNotNull("Can't find feature " +namespace + ":" + classname + "." + featurename, feature);
				ExpectedStructuralFeature expectedElement = new ExpectedStructuralFeature(0, false, feature, null, null);
				expectedElement.setPosition(beginIncl, beginExcl/*, endIncl, endExcl*/);
				expectations.add(expectedElement);
			} else {
				// is CsString
				ExpectedCsString expectedElement = new ExpectedCsString(0, false, expected.trim());
				expectedElement.setPosition(beginIncl, beginExcl/*, endIncl, endExcl*/);
				expectations.add(expectedElement);
			}
		}
		return expectations;
	}

	private EStructuralFeature findFeature(String namespace, String classname,
			String featureName) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(namespace);
		assertNotNull("Can't find EPackage for namespace " + namespace, ePackage);
		EClassifier eClassifier = ePackage.getEClassifier(classname);
		assertNotNull("Can't find EClassifier for class " + classname, eClassifier);
		assertTrue("Class " + classname + " is not an EClass.", eClassifier instanceof EClass);
		EClass eClass = (EClass) eClassifier;
		EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
		assertNotNull("Can't find EStructuralFeature " + featureName, feature);
		return feature;
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

	/**
	 * Asserts that the given list of expected elements is returned by the parser.
	 * This list covers only the expectations at the cursor position.
	 * 
	 * @param file the test input file
	 * @param expectedElementsList the list of expected elements that should be returned by the parser
	 *        for the given cursor position
	 */
	private void assertExpectedElementAtCursor(File file, List<IExpectedElement> expectedCompletionElement) {
		String fileExtension = getFileExtension(file);
		String fileContent = getFileContent(file);
		int cursorIndex = getCursorMarkerIndex(fileContent);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		final List<IExpectedElement> actualElements = getExpectedElementsList(fileExtension, contentWithoutMarker);
		List<IExpectedElement> finalExpectedAtCursor = new CodeCompletionHelper().getExpectedElementsAt(contentWithoutMarker, cursorIndex, actualElements);
		assertEquals(expectedCompletionElement, finalExpectedAtCursor);
	}

	/**
	 * Asserts that the given list of expected elements is returned by the parser.
	 * This list covers the whole file content and NOT only the expectations at the
	 * cursor position.
	 * 
	 * @param file the test input file
	 * @param expectedElementsList the list of expected elements that should be returned by the parser
	 */
	private void assertExpectedElementsList(File file, List<IExpectedElement> expectedElementsList) {
		String fileExtension = getFileExtension(file);
		String fileContent = getFileContent(file);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		final List<IExpectedElement> actualElements = getExpectedElementsList(fileExtension, contentWithoutMarker);
		for (IExpectedElement actualElement : actualElements) {
			System.out.println("ACTUAL ELEMENT:   " + actualElement);
		}
		removeDuplicateEntries(actualElements);
		removeInvalidEntriesAtEnd(actualElements);
		// compare lists
		final int actualSize = actualElements.size();
		final int expectedSize = expectedElementsList.size();
		int maxSize = Math.min(actualSize, expectedSize);
		for (int i = 0; i < maxSize; i++) {
			IExpectedElement actualElementAtIndex = actualElements.get(i);
			IExpectedElement expectedElementAtIndex = expectedElementsList.get(i);
			assertEquals("Types do not match.", expectedElementAtIndex, actualElementAtIndex);
			assertEquals("Expected start (excluding hidden) does not match.", expectedElementAtIndex.getStartExcludingHiddenTokens(), actualElementAtIndex.getStartExcludingHiddenTokens());
			assertEquals("Expected start (including hidden) does not match.", expectedElementAtIndex.getStartIncludingHiddenTokens(), actualElementAtIndex.getStartIncludingHiddenTokens());
			//assertEquals("Expected end (excluding hidden) does not match.", expectedElementAtIndex.getEndExcludingHiddenTokens(), actualElementAtIndex.getEndExcludingHiddenTokens());
		}
		assertEquals("List sizes should match.", expectedSize, actualSize);
	}

	private void removeDuplicateEntries(List<IExpectedElement> actualElements) {
		for (int i = 0; i < actualElements.size() - 1; i++) {
			IExpectedElement elementAtIndex = actualElements.get(i);
			for (int j = i + 1; j < actualElements.size();) {
				IExpectedElement elementAtNext = actualElements.get(j);
				if (elementAtIndex.equals(elementAtNext) &&
					elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens()) {
					actualElements.remove(j);
				} else {
					j++;
				}
			}
		}
	}

	private void removeInvalidEntriesAtEnd(List<IExpectedElement> actualElements) {
		for (int i = 0; i < actualElements.size() - 1;) {
			IExpectedElement elementAtIndex = actualElements.get(i);
			IExpectedElement elementAtNext = actualElements.get(i + 1);
			if (elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens() &&
				elementAtIndex.discardFollowingExpectations() &&
				elementAtIndex.getNestingLevel() >= elementAtNext.getNestingLevel()) {
				actualElements.remove(i + 1);
			} else {
				i++;
			}
		}
	}

	private List<IExpectedElement> getExpectedElementsList(String fileExtension,
			String contentWithoutMarker) {
		InputStream inputStream = new ByteArrayInputStream(contentWithoutMarker.getBytes());
		
		ITextParser parser = createParser(fileExtension, inputStream);
		assertNotNull("Parser should be created.", parser);
		
		final List<IExpectedElement> actualElements = parser.parseToExpectedElements(null);
		if (actualElements == null) {
			fail("Parser must return an expected elements list.");
		}
		if (actualElements.size() == 0) {
			fail("Parser must return at least one expected element.");
		}
		return actualElements;
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
		System.out.println("-------- CURSOR AT " + cursorPosition);
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
