package org.emftext.test.packrat_parser;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.test.code_completion.resource.cct.CctPackratParser;
import org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresPackratParser;

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
		private String expectedModel;

		public GrammarFeatureParseTest(String content, String expectedModel) {
			super("Parse " + content.replace("\n", "").replace("\r", ""));
			this.content = content;
			this.expectedResult = expectedModel != null;
			this.expectedModel = expectedModel;
			if (this.expectedModel != null) {
				this.expectedModel = "Root{" + this.expectedModel + "}";
			}
		}
		
		public void runTest() {
			ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
			ITextParser parser = new Grammar_featuresPackratParser().createInstance(in, null);
			EObject root = parser.parse();
			if (expectedResult) {
				assertNotNull("Parsing should be successful.", root);
				checkModel(root);
			} else {
				assertNull("Parsing should be fail.", root);
			}
		}

		private void checkModel(EObject root) {
			if (expectedModel == null) {
				return;
			}
			String modelString = EObjectTestUtil.convertToString(root);
			System.out.println("checkModel() EXPECTED: " + expectedModel);
			System.out.println("checkModel() ACTUAL:   " + modelString);
			assertEquals(expectedModel, modelString);
		}
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite("All tests");

		suite.addTest(new CctParseTest("public class A {}"));
		suite.addTest(new CctParseTest("public class A {\n}"));
		suite.addTest(new CctParseTest("public class A {private A x;}"));
		suite.addTest(new CctParseTest("public class A {private A x;private A y;}"));
		suite.addTest(new CctParseTest("public class A {private void method() {}}"));
		
		suite.addTest(new GrammarFeatureParseTest("co", "CompoundOptional"));
		suite.addTest(new GrammarFeatureParseTest("co a b", "CompoundOptional"));

		// this should not be parsable
		suite.addTest(new GrammarFeatureParseTest("co a b a b", null));
		suite.addTest(new GrammarFeatureParseTest("co a c", null));
		suite.addTest(new GrammarFeatureParseTest("some thing stupid", null));
		
		suite.addTest(new GrammarFeatureParseTest("cs", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseTest("cs a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b ab", "CompoundStar"));

		suite.addTest(new GrammarFeatureParseTest("cp", null));
		suite.addTest(new GrammarFeatureParseTest("cp a b", "CompoundPlus"));
		suite.addTest(new GrammarFeatureParseTest("cp a b a b", "CompoundPlus"));
		suite.addTest(new GrammarFeatureParseTest("cp a b a b ab", "CompoundPlus"));

		suite.addTest(new GrammarFeatureParseTest("cs", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseTest("cs a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseTest("cs a b a b ab", "CompoundStar"));
		
		suite.addTest(new GrammarFeatureParseTest("mc", null));
		suite.addTest(new GrammarFeatureParseTest("mc x", "MandatoryContainment{X}"));
		suite.addTest(new GrammarFeatureParseTest("mc x x", null));

		suite.addTest(new GrammarFeatureParseTest("oc", "OptionalContainment"));
		suite.addTest(new GrammarFeatureParseTest("oc x", "OptionalContainment{X}"));
		suite.addTest(new GrammarFeatureParseTest("oc x x", null));

		suite.addTest(new GrammarFeatureParseTest("pc", null));
		suite.addTest(new GrammarFeatureParseTest("pc x", "PlusContainment{X}"));
		suite.addTest(new GrammarFeatureParseTest("pc x x", "PlusContainment{X,X}"));

		suite.addTest(new GrammarFeatureParseTest("sc", "StarContainment"));
		suite.addTest(new GrammarFeatureParseTest("sc x", "StarContainment{X}"));
		suite.addTest(new GrammarFeatureParseTest("sc x x", "StarContainment{X,X}"));

		suite.addTest(new GrammarFeatureParseTest("mnc", null));
		suite.addTest(new GrammarFeatureParseTest("mnc xyz", "MandatoryNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("mnc xyz xyz", null));

		suite.addTest(new GrammarFeatureParseTest("onc", "OptionalNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("onc xyz", "OptionalNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("onc xyz xyz", null));

		suite.addTest(new GrammarFeatureParseTest("pnc", null));
		suite.addTest(new GrammarFeatureParseTest("pnc xyz", "PlusNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("pnc xyz xyz", "PlusNonContainment"));

		suite.addTest(new GrammarFeatureParseTest("snc", "StarNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("snc xyz", "StarNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("snc xyz xyz", "StarNonContainment"));
		
		suite.addTest(new GrammarFeatureParseTest("alternativeA", "AlternativeSyntax"));
		suite.addTest(new GrammarFeatureParseTest("alternativeB", "AlternativeSyntax"));
		suite.addTest(new GrammarFeatureParseTest("alternativeA alternativeB", "AlternativeSyntax,AlternativeSyntax"));
		
		suite.addTest(new GrammarFeatureParseTest("concreteA", "ConcreteSubclassA"));
		suite.addTest(new GrammarFeatureParseTest("concreteB", "ConcreteSubclassB"));
		suite.addTest(new GrammarFeatureParseTest("concreteA concreteB", "ConcreteSubclassA,ConcreteSubclassB"));

		suite.addTest(new GrammarFeatureParseTest("mc x:abc", "MandatoryContainment{X(name=abc)}"));

		return suite;
	}
}
