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
		private boolean expectedResult;

		public GrammarFeatureParseTest(String content, boolean expectedResult) {
			super("Parse " + content.replace("\n", "").replace("\r", ""));
			this.content = content;
			this.expectedResult = expectedResult;
		}
		
		public void runTest() {
			ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
			ITextParser parser = new Grammar_featuresPackratParser().createInstance(in, null);
			EObject root = parser.parse();
			if (expectedResult) {
				assertNotNull("Parsing should be successful.", root);
			} else {
				assertNull("Parsing should be fail.", root);
			}
		}
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite("All tests");
		suite.addTest(new CctParseTest("public class A {}"));
		suite.addTest(new CctParseTest("public class A {\n}"));
		suite.addTest(new CctParseTest("public class A {private A x;}"));
		suite.addTest(new CctParseTest("public class A {private A x;private A y;}"));
		suite.addTest(new CctParseTest("public class A {private void method() {}}"));
		
		suite.addTest(new GrammarFeatureParseTest("co", true));
		suite.addTest(new GrammarFeatureParseTest("co a b", true));

		// this should not be parsable
		suite.addTest(new GrammarFeatureParseTest("co a b a b", false));
		suite.addTest(new GrammarFeatureParseTest("co a c", false));
		suite.addTest(new GrammarFeatureParseTest("some thing stupid", false));
		
		suite.addTest(new GrammarFeatureParseTest("cs", true));
		suite.addTest(new GrammarFeatureParseTest("cs a b", true));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b", true));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b ab", true));

		suite.addTest(new GrammarFeatureParseTest("cp", false));
		suite.addTest(new GrammarFeatureParseTest("cp a b", true));
		suite.addTest(new GrammarFeatureParseTest("cp a b a b", true));
		suite.addTest(new GrammarFeatureParseTest("cp a b a b ab", true));

		suite.addTest(new GrammarFeatureParseTest("cs", true));
		suite.addTest(new GrammarFeatureParseTest("cs a b", true));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b", true));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b ab", true));
		
		suite.addTest(new GrammarFeatureParseTest("mc", false));
		suite.addTest(new GrammarFeatureParseTest("mc x", true));
		suite.addTest(new GrammarFeatureParseTest("mc x x", false));

		suite.addTest(new GrammarFeatureParseTest("oc", true));
		suite.addTest(new GrammarFeatureParseTest("oc x", true));
		suite.addTest(new GrammarFeatureParseTest("oc x x", false));

		suite.addTest(new GrammarFeatureParseTest("pc", false));
		suite.addTest(new GrammarFeatureParseTest("pc x", true));
		suite.addTest(new GrammarFeatureParseTest("pc x x", true));

		suite.addTest(new GrammarFeatureParseTest("sc", true));
		suite.addTest(new GrammarFeatureParseTest("sc x", true));
		suite.addTest(new GrammarFeatureParseTest("sc x x", true));

		suite.addTest(new GrammarFeatureParseTest("mnc", false));
		suite.addTest(new GrammarFeatureParseTest("mnc xyz", true));
		suite.addTest(new GrammarFeatureParseTest("mnc xyz xyz", false));

		suite.addTest(new GrammarFeatureParseTest("onc", true));
		suite.addTest(new GrammarFeatureParseTest("onc xyz", true));
		suite.addTest(new GrammarFeatureParseTest("onc xyz xyz", false));

		suite.addTest(new GrammarFeatureParseTest("pnc", false));
		suite.addTest(new GrammarFeatureParseTest("pnc xyz", true));
		suite.addTest(new GrammarFeatureParseTest("pnc xyz xyz", true));

		suite.addTest(new GrammarFeatureParseTest("snc", true));
		suite.addTest(new GrammarFeatureParseTest("snc xyz", true));
		suite.addTest(new GrammarFeatureParseTest("snc xyz xyz", true));
		
		suite.addTest(new GrammarFeatureParseTest("alternativeA", true));
		suite.addTest(new GrammarFeatureParseTest("alternativeB", true));
		suite.addTest(new GrammarFeatureParseTest("alternativeA alternativeB", true));
		
		suite.addTest(new GrammarFeatureParseTest("concreteA", true));
		suite.addTest(new GrammarFeatureParseTest("concreteB", true));
		suite.addTest(new GrammarFeatureParseTest("concreteA concreteB", true));
		
		return suite;
	}
}
