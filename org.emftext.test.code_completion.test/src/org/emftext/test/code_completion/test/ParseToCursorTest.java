package org.emftext.test.code_completion.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.ReachedCursorIndexException;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser.IExpectedElement;
import org.emftext.test.code_completion.Code_completionPackage;
import org.emftext.test.code_completion.resource.cct.CctParser;
import org.emftext.test.code_completion.resource.cct.CctResourceFactory;

public class ParseToCursorTest extends TestCase {

	private static final String INPUT_DIR = "input";

	public void testParseToCursor() {
		parseToCursor("KeywordClassExpected.cct", 8, "class");
		parseToCursor("EnumVisibilityExpected.cct", 2, Code_completionPackage.eINSTANCE.getModifiable_Visibility());
		parseToCursor("BracketExpected.cct", 15, "{");
	}
	
	private void parseToCursor(String filename, int cursorIndex, String expectedCsString) {
		parseToCursor(filename, cursorIndex, new AbstractEMFTextParser.ExpectedCsString(expectedCsString));
	}
	
	private void parseToCursor(String filename, int cursorIndex, EStructuralFeature feature) {
		parseToCursor(filename, cursorIndex, new AbstractEMFTextParser.ExpectedStructuralFeature(feature));
	}
	
	private void parseToCursor(String filename, int cursorIndex, IExpectedElement expectedCompletionElement) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(INPUT_DIR + File.separator + filename);
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		}
		CctParser factory = new CctParser();
		ITextParser parser = factory.createInstance(inputStream, null);
		ITextResource resource = (ITextResource) new CctResourceFactory().createResource(URI.createFileURI("dummyResource.cct"));
		parser.setResource(resource);
		try {
			parser.parseToIndex(cursorIndex);
			fail("Expected ReachedCursorIndexException.");
		} catch (ReachedCursorIndexException pcie) {
			final IExpectedElement actualElement = pcie.getExpectedElement();
			assertEquals(expectedCompletionElement, actualElement);
		}
	}
}
