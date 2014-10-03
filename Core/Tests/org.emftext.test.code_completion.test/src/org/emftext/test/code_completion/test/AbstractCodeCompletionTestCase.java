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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IMetaInformation;
import org.emftext.access.resource.IParser;
import org.emftext.access.resource.IResource;
import org.emftext.access.resource.IUIMetaInformation;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIMetaInformation;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.cct1.Cct1Package;
import org.emftext.test.cct1.resource.cct1.mopp.Cct1MetaInformation;
import org.emftext.test.cct1.resource.cct1.ui.Cct1UIMetaInformation;
import org.emftext.test.cct2.Cct2Package;
import org.emftext.test.cct2.resource.cct2.mopp.Cct2MetaInformation;
import org.emftext.test.cct2.resource.cct2.ui.Cct2UIMetaInformation;
import org.emftext.test.cct3.Cct3Package;
import org.emftext.test.cct3.resource.cct3.mopp.Cct3MetaInformation;
import org.emftext.test.cct3.resource.cct3.ui.Cct3UIMetaInformation;
import org.emftext.test.cct4.Cct4Package;
import org.emftext.test.cct4.resource.cct4.mopp.Cct4MetaInformation;
import org.emftext.test.cct4.resource.cct4.ui.Cct4UIMetaInformation;
import org.emftext.test.cct5.Cct5Package;
import org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation;
import org.emftext.test.cct5.resource.cct5.ui.Cct5UIMetaInformation;
import org.emftext.test.code_completion.test.access.ICodeCompletionHelper;
import org.emftext.test.code_completion.test.access.ICompletionProposal;
import org.emftext.test.code_completion.test.access.IContainedFeature;
import org.emftext.test.code_completion.test.access.IContainmentTrace;
import org.emftext.test.code_completion.test.access.IExpectedCsString;
import org.emftext.test.code_completion.test.access.IExpectedElement;
import org.emftext.test.code_completion.test.access.IExpectedStructuralFeature;
import org.emftext.test.code_completion.test.access.IExpectedTerminal;
import org.emftext.test.code_completion.test.access.IMetaInformation2;
import org.emftext.test.code_completion.test.util.ExpectedCsString;
import org.emftext.test.code_completion.test.util.ExpectedStructuralFeature;
import org.emftext.test.code_completion.test.util.ExpectedTerminal;
import org.junit.Before;

public abstract class AbstractCodeCompletionTestCase {

	protected static final String INPUT_DIR = "input";
	
	private static final String CURSOR_MARKER = "<CURSOR>";
	
	@Before
	public void setUp() {
		registerSyntaxes();
		registerEPackages();
		registerGenModels();
		registerResourceFactories();
	}

	private static void registerEPackages() {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ConcretesyntaxPackage.eNS_URI, ConcretesyntaxPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(Cct1Package.eNS_URI, Cct1Package.eINSTANCE);
		EPackage.Registry.INSTANCE.put(Cct2Package.eNS_URI, Cct2Package.eINSTANCE);
		EPackage.Registry.INSTANCE.put(Cct3Package.eNS_URI, Cct3Package.eINSTANCE);
		EPackage.Registry.INSTANCE.put(Cct4Package.eNS_URI, Cct4Package.eINSTANCE);
		EPackage.Registry.INSTANCE.put(Cct5Package.eNS_URI, Cct5Package.eINSTANCE);
		//TODO #1879: EPackage.Registry.INSTANCE.put(CustomerPackage.eNS_URI, CustomerPackage.eINSTANCE);
	}

	@SuppressWarnings("deprecation")
	private static void registerGenModels() {
		String pathToCsGenModel = ".." + File.separator + "org.emftext.sdk.concretesyntax" + File.separator + "metamodel" + File.separator + "concretesyntax.genmodel";
		String absolutePathToCsGenModel = new File(pathToCsGenModel).getAbsolutePath();
		EcorePlugin.getEPackageNsURIToGenModelLocationMap().put(ConcretesyntaxPackage.eNS_URI, URI.createFileURI(absolutePathToCsGenModel));
	}

	private static void registerResourceFactories() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		new CsMetaInformation().registerResourceFactory();
		new Cct1MetaInformation().registerResourceFactory();
		new Cct2MetaInformation().registerResourceFactory();
		new Cct3MetaInformation().registerResourceFactory();
		new Cct4MetaInformation().registerResourceFactory();
		new Cct5MetaInformation().registerResourceFactory();
		//TODO #1879: new CustomerMetaInformation().registerResourceFactory();
	}

	private static void registerSyntaxes() {
		List<IMetaInformation> csRegistry = EMFTextAccessPlugin.getConcreteSyntaxRegistry();
		List<IUIMetaInformation> uiPluginRegistry = EMFTextAccessPlugin.getUIPluginRegistry();

		csRegistry.add((IMetaInformation) EMFTextAccessProxy.get(new CsMetaInformation(), IMetaInformation.class, additionalAccessInterfaces));
		uiPluginRegistry.add((IUIMetaInformation) EMFTextAccessProxy.get(new CsUIMetaInformation(), IUIMetaInformation.class, additionalAccessInterfaces));
		csRegistry.add((IMetaInformation) EMFTextAccessProxy.get(new Cct1MetaInformation(), IMetaInformation.class, additionalAccessInterfaces));
		uiPluginRegistry.add((IUIMetaInformation) EMFTextAccessProxy.get(new Cct1UIMetaInformation(), IUIMetaInformation.class, additionalAccessInterfaces));
		csRegistry.add((IMetaInformation) EMFTextAccessProxy.get(new Cct2MetaInformation(), IMetaInformation.class, additionalAccessInterfaces));
		uiPluginRegistry.add((IUIMetaInformation) EMFTextAccessProxy.get(new Cct2UIMetaInformation(), IUIMetaInformation.class, additionalAccessInterfaces));
		csRegistry.add((IMetaInformation) EMFTextAccessProxy.get(new Cct3MetaInformation(), IMetaInformation.class, additionalAccessInterfaces));
		uiPluginRegistry.add((IUIMetaInformation) EMFTextAccessProxy.get(new Cct3UIMetaInformation(), IUIMetaInformation.class, additionalAccessInterfaces));
		csRegistry.add((IMetaInformation) EMFTextAccessProxy.get(new Cct4MetaInformation(), IMetaInformation.class, additionalAccessInterfaces));
		uiPluginRegistry.add((IUIMetaInformation) EMFTextAccessProxy.get(new Cct4UIMetaInformation(), IUIMetaInformation.class, additionalAccessInterfaces));
		csRegistry.add((IMetaInformation) EMFTextAccessProxy.get(new Cct5MetaInformation(), IMetaInformation.class, additionalAccessInterfaces));
		uiPluginRegistry.add((IUIMetaInformation) EMFTextAccessProxy.get(new Cct5UIMetaInformation(), IUIMetaInformation.class, additionalAccessInterfaces));
		//TODO #1879: csRegistry.add((IMetaInformation) EMFTextAccessProxy.get(new CustomerMetaInformation(), IMetaInformation.class, additionalAccessInterfaces));
		//TODO #1879: uiPluginRegistry.add((IUIMetaInformation) EMFTextAccessProxy.get(new CustomerUIMetaInformation(), IUIMetaInformation.class, additionalAccessInterfaces));
	}


	protected static List<File> listFilesRecursivly(File inputFolder,
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

	private static Class<?>[] additionalAccessInterfaces = new Class<?>[] {
		IMetaInformation2.class,
		IExpectedElement.class,
		IExpectedCsString.class,
		IExpectedStructuralFeature.class,
		IExpectedTerminal.class,
		ICompletionProposal.class,
		ICodeCompletionHelper.class,
		IContainmentTrace.class,
		IContainedFeature.class
	};

	public AbstractCodeCompletionTestCase() {
		super();
	}

	protected String[] getExpectedInsertStrings(File file) {
		List<String> expectedInsertStrings = new ArrayList<String>();
		String[] lines = getLines(file, ".expected_inserts");
		for (String line : lines) {
			if ("".equals(line)) {
				continue;
			}
			expectedInsertStrings.add(line);
		}
		return expectedInsertStrings.toArray(new String[expectedInsertStrings.size()]);
	}

	protected List<IExpectedTerminal> getExpectations(File file, String fileExtension) {
		//System.out.println("- Expectations from " + file.getName() + "");
		List<IExpectedTerminal> expectations = new ArrayList<IExpectedTerminal>();

		String[] lines = getLines(file, fileExtension);
		for (String line : lines) {
			if ("".equals(line)) {
				continue;
			}
			// Ignore comments
			if (line.startsWith("//")) {
				continue;
			}
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
				IExpectedTerminal expectedElement = new ExpectedTerminal(new ExpectedStructuralFeature(feature), beginIncl, beginExcl);
				expectations.add(expectedElement);
			} else {
				// is CsString
				IExpectedTerminal expectedElement = new ExpectedTerminal(new ExpectedCsString(expected.trim()), beginIncl, beginExcl);
				expectations.add(expectedElement);
			}
		}
		return expectations;
	}

	private String[] getLines(File file, String fileExtension) {
		final String expectationFilePath = file.getPath() + fileExtension;
		File expectationFile = new File(expectationFilePath);
		assertTrue("Expectations file " + expectationFilePath + " not found.", expectationFile.exists());
		String expectationsContent = getFileContent(expectationFile);
		String[] lines = expectationsContent.split("\\r?\\n");
		return lines;
	}

	private EStructuralFeature findFeature(String namespacePrefix, String classname,
			String featureName) {
		EPackage ePackage = findEPackage(namespacePrefix);
		assertNotNull("Can't find EPackage for namespacePrefix " + namespacePrefix, ePackage);
		EClassifier eClassifier = ePackage.getEClassifier(classname);
		assertNotNull("Can't find EClassifier for class " + classname, eClassifier);
		assertTrue("Class " + classname + " is not an EClass.", eClassifier instanceof EClass);
		EClass eClass = (EClass) eClassifier;
		EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
		assertNotNull("Can't find EStructuralFeature " + featureName, feature);
		return feature;
	}

	private EPackage findEPackage(String namespacePrefix) {
		Iterator<Map.Entry<String, Object>> it = EPackage.Registry.INSTANCE.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> next = it.next();
			Object value = next.getValue();
			if (value instanceof EPackage) {
				EPackage ePackage = (EPackage) value;
				if (namespacePrefix.equals(ePackage.getNsPrefix())) {
					return ePackage;
				}
			}
		}
		return null;
	}

	protected void checkInsertStrings(File file, String[] expectedInsertStrings) {
		String fileContent = getFileContent(file);
		int cursorIndex = getCursorMarkerIndex(fileContent);
		System.out.println("-------- " + file + " - CURSOR AT " + cursorIndex);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		IMetaInformation2 metaInformation2 = getMetaInformation2(file);
		ICodeCompletionHelper helper = metaInformation2.createCodeCompletionHelper();
		IMetaInformation metaInformation = getMetaInformation(file);
		IResource resource = createDummyResource(metaInformation.getSyntaxName());
		ICompletionProposal[] proposals = helper.computeCompletionProposals(resource, contentWithoutMarker, cursorIndex);
		assertNotNull("Proposal list should not be null", proposals);
		Collection<ICompletionProposal> proposalList = new ArrayList<ICompletionProposal>(Arrays.asList(proposals));
		Iterator<ICompletionProposal> it = proposalList.iterator();
		while (it.hasNext()) {
			ICompletionProposal proposal = it.next();
			System.out.println("Found proposal \"" + proposal.getInsertString() + "\" - prefix ok " + proposal.isMatchesPrefix());
			if (!proposal.isMatchesPrefix()) {
				it.remove();
			}
		}
		for (String expectedInsertString : expectedInsertStrings) {
			boolean foundExpectedInsertString = false;
			for (ICompletionProposal completionProposal : proposalList) {
				if (expectedInsertString.equals(completionProposal.getInsertString())) {
					foundExpectedInsertString = true;
				}
			}
			assertTrue("Proposal " + expectedInsertString + " expected.", foundExpectedInsertString);
		}
		assertEquals("Same number of proposals expected.", expectedInsertStrings.length, proposalList.size());
	}

	private IMetaInformation2 getMetaInformation2(File file) {
		IMetaInformation metaInformation = getMetaInformation(file);
		IMetaInformation2 metaInformation2 = (IMetaInformation2) EMFTextAccessProxy.get(metaInformation, IMetaInformation2.class, additionalAccessInterfaces);
		return metaInformation2;
	}

	private IMetaInformation getMetaInformation(File file) {
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
	protected void assertExpectedElementsAtCursor(File file, List<IExpectedTerminal> expectedBeforeList, List<IExpectedTerminal> expectedAfterList) {
		String fileExtension = getFileExtension(file);
		String fileContent = getFileContent(file);
		int cursorOffset = getCursorMarkerIndex(fileContent);
		System.out.println("\n--- Testing expected elements at cursor using " + file.getName() + " (" + cursorOffset + ")");
		String contentWithoutMarker = removeCursorMarker(fileContent);
		final IExpectedTerminal[] allExpectedElements = getExpectedElementsList(file, fileExtension, contentWithoutMarker);

		ICodeCompletionHelper helper = getMetaInformation2(file).createCodeCompletionHelper();

		IExpectedTerminal[] expectedBeforeCursor = helper.getElementsExpectedAt(allExpectedElements, cursorOffset - 1);
		IExpectedTerminal[] expectedAfterCursor = helper.getElementsExpectedAt(allExpectedElements, cursorOffset);

		IExpectedTerminal[] expectedBefore = expectedBeforeList.toArray(new IExpectedTerminal[expectedBeforeList.size()]);
		if (!expectedBefore.equals(expectedAfterCursor)) {
			print(cursorOffset - 1, "BEFORE", expectedBeforeCursor);
		}
		IExpectedTerminal[] expectedAfter = expectedAfterList.toArray(new IExpectedTerminal[expectedAfterList.size()]);
		if (!expectedAfter.equals(expectedAfterCursor)) {
			print(cursorOffset, "AFTER", expectedAfterCursor);
		}
		System.out.println("-> Checking assertions for elements BEFORE cursor");
		for (int i = 0; i < Math.min(expectedBefore.length, expectedBeforeCursor.length); i++) {
			assertEquals("Wrong element expected before cursor", expectedBefore[i], expectedBeforeCursor[i]);
		}
		System.out.println("-> Checking assertions for elements AFTER cursor");
		for (int i = 0; i < Math.min(expectedAfter.length, expectedAfterCursor.length); i++) {
			assertEquals("Wrong element expected after cursor", expectedAfter[i], expectedAfterCursor[i]);
		}
		assertEquals("Wrong number of elements expected before cursor.", expectedBefore.length, expectedBeforeCursor.length);
		assertEquals("Wrong number of elements expected after cursor.", expectedAfter.length, expectedAfterCursor.length);
	}

	private void print(int cursorOffset, String message, IExpectedTerminal[] expected) {
		for (IExpectedTerminal next : expected) {
			System.out.println("PARSER EXPECTED " + message + " CURSOR (" + cursorOffset + "): " + next);
		}
	}

	/**
	 * Asserts that the given list of expected elements is returned by the parser.
	 * This list covers the whole file content and NOT only the expectations at the
	 * cursor position.
	 *
	 * @param file the test input file
	 * @param expectedElementsList the list of expected elements that should be returned by the parser
	 */
	protected void assertExpectedElementsList(File file, List<IExpectedTerminal> expectedElementsList) {
		String fileExtension = getFileExtension(file);
		String fileContent = getFileContent(file);
		String contentWithoutMarker = removeCursorMarker(fileContent);
		final IExpectedTerminal[] actualElements = getExpectedElementsList(file, fileExtension, contentWithoutMarker);
		for (IExpectedTerminal actualElement : actualElements) {
			System.out.println("ACTUAL ELEMENT: " + actualElement);
		}
		// compare lists
		final int actualSize = actualElements.length;
		final int expectedSize = expectedElementsList.size();
		int maxSize = Math.min(actualSize, expectedSize);
		for (int i = 0; i < maxSize; i++) {
			IExpectedTerminal actualElementAtIndex = actualElements[i];
			IExpectedTerminal expectedElementAtIndex = expectedElementsList.get(i);
			assertEquals(i + ": Types do not match.", expectedElementAtIndex, actualElementAtIndex);
			assertEquals(i + ": Expected start (excluding hidden) does not match.", expectedElementAtIndex.getStartExcludingHiddenTokens(), actualElementAtIndex.getStartExcludingHiddenTokens());
			assertEquals(i + ": Expected start (including hidden) does not match.", expectedElementAtIndex.getStartIncludingHiddenTokens(), actualElementAtIndex.getStartIncludingHiddenTokens());
			//assertEquals("Expected end (excluding hidden) does not match.", expectedElementAtIndex.getEndExcludingHiddenTokens(), actualElementAtIndex.getEndExcludingHiddenTokens());
		}
		assertEquals("List sizes must match.", expectedSize, actualSize);
	}

	private IExpectedTerminal[] getExpectedElementsList(File file, String fileExtension,
			String contentWithoutMarker) {
		InputStream inputStream = new ByteArrayInputStream(contentWithoutMarker.getBytes());

		IParser parser = createParser(fileExtension, inputStream);
		assertNotNull("Parser should be created.", parser);

		IResource resource = createDummyResource(fileExtension);
		IMetaInformation2 metaInformation2 = getMetaInformation2(file);
		ICodeCompletionHelper codeCompletionHelper = metaInformation2.createCodeCompletionHelper();
		final IExpectedTerminal[] actualElements = codeCompletionHelper.parseToExpectedElements(parser, resource, contentWithoutMarker.length());
		if (actualElements == null) {
			fail("Parser must return an expected elements list.");
		}
		for (IExpectedTerminal iExpectedTerminal : actualElements) {
			IContainmentTrace containmentTrace = iExpectedTerminal.getContainmentTrace();
			String trace = "";
			IContainedFeature[] features = containmentTrace.getPath();
			for (IContainedFeature feature : features) {
				EStructuralFeature eStructuralFeature = feature.getFeature();
				trace += "->" + eStructuralFeature.getEContainingClass().getName() + "." + eStructuralFeature.getName();
			}
			System.out.println("EXPECT " + iExpectedTerminal + " (FOLLOWSET ID=" + iExpectedTerminal.getFollowSetID() + ", TRACE=" + trace+ ") at " + iExpectedTerminal.getStartIncludingHiddenTokens() + "," + iExpectedTerminal.getStartExcludingHiddenTokens());
		}
		if (actualElements.length == 0) {
			fail("Parser must return at least one expected element.");
		}
		return actualElements;
	}

	private IResource createDummyResource(String fileExtension) {
		Resource resource = new ResourceSetImpl().createResource(URI.createURI("temp." +  fileExtension));
		assertTrue("Cannot create Dummy Resource.", resource != null);
		IResource wrappedResource = (IResource) EMFTextAccessProxy.get(resource, IResource.class, additionalAccessInterfaces);
		return wrappedResource;
	}

	private String getFileExtension(File file) {
		final String filename = file.getName();
		String fileExtension = filename.substring(filename.lastIndexOf(".") + 1);
		return fileExtension;
	}

	private IMetaInformation getMetaInformation(String fileExtension) {
		for (IUIMetaInformation metaInformation : EMFTextAccessPlugin.getUIPluginRegistry()) {
			if (metaInformation.getSyntaxName().equals(fileExtension)) {
				return metaInformation;
			}
		}
		fail("Could not find meta information for extension " + fileExtension);
		return null;
	}

	private IParser createParser(String fileExtension, InputStream inputStream) {
		return getMetaInformation(fileExtension).createParser(inputStream, null);
	}

	private int getCursorMarkerIndex(String fileContent) {
		int cursorPosition = fileContent.indexOf(CURSOR_MARKER);
		assertTrue("Cursor position marker (" + CURSOR_MARKER + ") not found in input file.", cursorPosition >= 0);
		//System.out.println("-------- CURSOR AT " + cursorPosition);
		return cursorPosition;
	}

	private String removeCursorMarker(String fileContent) {
		// remove the marker and everything behind
		return fileContent.substring(0, fileContent.indexOf(CURSOR_MARKER));
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
			reader.close();
			return contentBuffer.toString();
		} catch (IOException e) {
			fail(e.getMessage());
			return null;
		}
	}

	protected boolean accept(String filename) {
		return true;
	}
}
