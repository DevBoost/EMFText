package org.emftext.test.bug736;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.emftext.test.GrammarGenerationTestUtil;
import org.junit.Before;
import org.junit.Test;

public class Bug736Test extends TestCase {

	private GrammarGenerationTestUtil genUtil = new GrammarGenerationTestUtil();

	@Before
	public void setUp() {
		registerResourceFactories();
	}
	
	@Test
	public void testDeterministicParserGeneration() throws IOException, CoreException, InterruptedException {
		String qualifiedClassName = getClass().getName();
		// remove simple class name - leaving the name of the package
		qualifiedClassName = qualifiedClassName.substring(0, qualifiedClassName.length() - getClass().getSimpleName().length());
		String path = "src" + File.separator + qualifiedClassName.replace(".", File.separator) + "bug736.cs";
		File file = new File(path);
		URI csURI = URI.createFileURI(file.getAbsolutePath());
		try {
			genUtil.getGrammar(csURI);
		} catch (NullPointerException e) {
			fail("Creating the grammar should not raise a NPE.");
		}
	}
}
