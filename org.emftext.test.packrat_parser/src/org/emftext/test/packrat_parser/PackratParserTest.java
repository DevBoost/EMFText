package org.emftext.test.packrat_parser;

import java.io.ByteArrayInputStream;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.test.code_completion.resource.cct.CctPackratParser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PackratParserTest extends TestCase {

	public static class ParseTest extends TestCase {
		
		private String content;

		public ParseTest(String content) {
			super("Parse " + content);
			this.content = content;
		}
		
		public void runTest() {
			ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
			ITextParser parser = new CctPackratParser().createInstance(in, null);
			EObject root = parser.parse();
			assertNotNull("Parsing should be successful.", root);
		}
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite("All tests");
		suite.addTest(new ParseTest("public class A {}"));
		suite.addTest(new ParseTest("public class A {private A x;}"));
		suite.addTest(new ParseTest("public class A {private A x;private A y;}"));
		suite.addTest(new ParseTest("public class A {private void method() {}}"));
		return suite;
	}
}
