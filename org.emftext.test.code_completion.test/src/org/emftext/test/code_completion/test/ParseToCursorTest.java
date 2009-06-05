package org.emftext.test.code_completion.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.test.code_completion.resource.cct.CctParser;
import org.emftext.test.code_completion.resource.cct.CctResourceFactory;

public class ParseToCursorTest extends TestCase {

	private static final String INPUT_DIR = "input";

	public void testParseToCursor() {
		parseToCursor("ClassA.cct", 2);
	}
	
	private void parseToCursor(String filename, int cursorIndex) {
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
		parser.parseToIndex(cursorIndex);
	}
}
