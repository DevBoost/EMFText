package org.emftext.test.packrat_parser;

import java.io.ByteArrayInputStream;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.test.code_completion.resource.cct.CctPackratParser;
import org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresPackratParser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * A basic test for the packrat parser generator. It basically
 * checks whether the input is parsed without checking the resulting
 * model.
 */
public class PackratParserTest extends TestCase {

	public static class CctParseTest extends TestCase {
		
		private String content;

		public CctParseTest(String content) {
			super("Parse " + content.replace("\n", "").replace("\r", ""));
			this.content = content;
		}
		
		public void runTest() {
			ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
			ITextParser parser = new CctPackratParser().createInstance(in, null);
			EObject root = parser.parse();
			assertNotNull("Parsing should be successful.", root);
		}
	}
	
	public static class GrammarFeatureParseTest extends TestCase {
		
		private String content;

		public GrammarFeatureParseTest(String content) {
			super("Parse " + content.replace("\n", "").replace("\r", ""));
			this.content = content;
		}
		
		public void runTest() {
			ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
			ITextParser parser = new Grammar_featuresPackratParser().createInstance(in, null);
			EObject root = parser.parse();
			assertNotNull("Parsing should be successful.", root);
		}
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite("All tests");
		suite.addTest(new CctParseTest("public class A {}"));
		suite.addTest(new CctParseTest("public class A {\n}"));
		suite.addTest(new CctParseTest("public class A {private A x;}"));
		suite.addTest(new CctParseTest("public class A {private A x;private A y;}"));
		suite.addTest(new CctParseTest("public class A {private void method() {}}"));
		return suite;
	}
}
