package org.emftext.test.packrat_parser;

import java.io.ByteArrayInputStream;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.test.code_completion.resource.cct.CctMetaInformation;
import org.emftext.test.code_completion.resource.cct.CctPackratParser;
import org.emftext.test.code_completion.resource.cct.CctResourceFactory;
import org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresMetaInformation;
import org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresPackratParser;
import org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresResourceFactory;

/**
 * A basic test for the packrat parser generator. It basically
 * checks whether the input is parsed without checking the resulting
 * model.
 */
public class PackratParserTest extends TestCase {

	public static abstract class AbstractParseTest extends TestCase {
		
		private boolean expectedResult;
		private String expectedModel;
		private String expectedError;
		private ITextResourcePluginMetaInformation metaInformation;
		private ITextParser parser;

		public AbstractParseTest(String content, String expectedModel, String expectedError, ITextResourcePluginMetaInformation metaInformation, ITextParser parser) {
			super("Parse " + content.replace("\n", "").replace("\r", ""));
			this.metaInformation = metaInformation;
			this.parser = parser;
			this.expectedResult = expectedModel != null;
			this.expectedModel = expectedModel;
			this.expectedError = expectedError;
		}

		public void runTest() {
			//ITextParser parser = metaInformation.createParser(in, null);
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createURI("test." + metaInformation.getSyntaxName());
			ITextResource resource = (ITextResource) rs.createResource(uri);
			parser.setResource(resource);
			//parser.setResource(new Grammar_featuresResource(uri));
			EObject root = parser.parse();
			List<Diagnostic> errors = resource.getErrors();
			if (expectedResult) {
				assertNotNull("The root object should not be null.", root);
				resource.getContents().add(root);
				assertEquals("There should be no parse errors.", 0, errors.size());
				//assertNotNull("Parsing should be successful.", root);
				EcoreUtil.resolveAll(root);
				checkModel(root);
			} else {
				//assertNull("Parsing should fail.", root);
				assertEquals("There should be one parse error.", 1, errors.size());
				if (expectedError != null) {
					Diagnostic error = errors.get(0);
					String errorMessage = error.getMessage();
					System.out.println("checkError() EXPECTED: " + expectedError);
					System.out.println("checkError() ACTUAL:   " + errorMessage);
					assertTrue("Expected error: " + expectedError, errorMessage.contains(expectedError));
				}
			}
		}

		protected void checkModel(EObject root) {
			if (expectedModel == null) {
				return;
			}
			String modelString = EObjectTestUtil.convertToString(root);
			System.out.println("checkModel() EXPECTED: " + expectedModel);
			System.out.println("checkModel() ACTUAL:   " + modelString);
			assertEquals(expectedModel, modelString);
		}
	}
	
	public static class CctParseTest extends AbstractParseTest {
		
		public CctParseTest(String content) {
			super(content, "", null, new CctMetaInformation(), new CctPackratParser(new ByteArrayInputStream(content.getBytes()), null));
		}
		
		protected void checkModel(EObject root) {
			// do nothing
		}
	}
	
	public static class GrammarFeatureParseTest extends AbstractParseTest {
		
		public GrammarFeatureParseTest(String content, String expectedModel) {
			super(content, expectedModel == null ? null : expectedModel, null, new Grammar_featuresMetaInformation(), new Grammar_featuresPackratParser(new ByteArrayInputStream(content.getBytes()), null));
		}
	}
	
	public static class GrammarFeatureParseRootTest extends AbstractParseTest {
		
		public GrammarFeatureParseRootTest(String content, String expectedModel) {
			super(content, expectedModel == null ? null : "Root{" + expectedModel + "}", null, new Grammar_featuresMetaInformation(), new Grammar_featuresPackratParser(new ByteArrayInputStream(content.getBytes()), null));
		}
	}
	
	public static class GrammarFeatureParseErrorTest extends AbstractParseTest {
		
		public GrammarFeatureParseErrorTest(String content, String expectedError) {
			super(content, null, expectedError, new Grammar_featuresMetaInformation(), new Grammar_featuresPackratParser(new ByteArrayInputStream(content.getBytes()), null));
		}
	}
	
	public static class GrammarFeatureParseErrorModelTest extends AbstractParseTest {
		
		public GrammarFeatureParseErrorModelTest(String content, String expectedModel) {
			super(content, expectedModel, "", new Grammar_featuresMetaInformation(), new Grammar_featuresPackratParser(new ByteArrayInputStream(content.getBytes()), null));
		}
	}
	
	public static Test suite() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new CctMetaInformation().getSyntaxName(),
				new CctResourceFactory());
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new Grammar_featuresMetaInformation().getSyntaxName(),
				new Grammar_featuresResourceFactory());
		
		TestSuite suite = new TestSuite("All tests");

		suite.addTest(new CctParseTest("public class A {}"));
		suite.addTest(new CctParseTest("public class A {\n}"));
		suite.addTest(new CctParseTest("public class A {private A x;}"));
		suite.addTest(new CctParseTest("public class A {private A x;private A y;}"));
		suite.addTest(new CctParseTest("private class some {\nprivate some a;\n}"));
		suite.addTest(new CctParseTest("private class some {\r\nprivate some a;\r\n}"));
		suite.addTest(new CctParseTest("private class some {\n\rprivate some a;\n\r}"));
		suite.addTest(new CctParseTest("private class some {\n\r\tprivate some a;\n\r}"));
		suite.addTest(new CctParseTest("public class A {private void method() {}}"));
		
		suite.addTest(new GrammarFeatureParseTest("SecondRoot", "SecondRoot"));

		suite.addTest(new GrammarFeatureParseRootTest("co", "CompoundOptional"));
		suite.addTest(new GrammarFeatureParseRootTest("co a b", "CompoundOptional"));
		suite.addTest(new GrammarFeatureParseRootTest("co a b a b", null));

		// this should not be parsable
		suite.addTest(new GrammarFeatureParseRootTest("co a c", null));
		suite.addTest(new GrammarFeatureParseRootTest("some thing stupid", null));
		
		suite.addTest(new GrammarFeatureParseRootTest("cs", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseRootTest("cs a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseRootTest("cs a b a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseRootTest("cs a b a b ab", "CompoundStar"));

		suite.addTest(new GrammarFeatureParseRootTest("cp", null));
		suite.addTest(new GrammarFeatureParseRootTest("cp a b", "CompoundPlus"));
		suite.addTest(new GrammarFeatureParseRootTest("cp a b a b", "CompoundPlus"));
		suite.addTest(new GrammarFeatureParseRootTest("cp a b a b ab", "CompoundPlus"));

		suite.addTest(new GrammarFeatureParseRootTest("cs", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseRootTest("cs a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseRootTest("cs a b a b", "CompoundStar"));
		suite.addTest(new GrammarFeatureParseRootTest("cs a b a b ab", "CompoundStar"));
		
		suite.addTest(new GrammarFeatureParseRootTest("mc", null));
		suite.addTest(new GrammarFeatureParseRootTest("mc x", "MandatoryContainment{X}"));
		suite.addTest(new GrammarFeatureParseRootTest("mc x x", null));

		suite.addTest(new GrammarFeatureParseRootTest("oc", "OptionalContainment"));
		suite.addTest(new GrammarFeatureParseRootTest("oc x", "OptionalContainment{X}"));
		suite.addTest(new GrammarFeatureParseRootTest("oc x x", null));

		suite.addTest(new GrammarFeatureParseRootTest("pc", null));
		suite.addTest(new GrammarFeatureParseRootTest("pc x", "PlusContainment{X}"));
		suite.addTest(new GrammarFeatureParseRootTest("pc x x", "PlusContainment{X,X}"));

		suite.addTest(new GrammarFeatureParseRootTest("sc", "StarContainment"));
		suite.addTest(new GrammarFeatureParseRootTest("sc x", "StarContainment{X}"));
		suite.addTest(new GrammarFeatureParseRootTest("sc x x", "StarContainment{X,X}"));

		suite.addTest(new GrammarFeatureParseRootTest("mnc", null));
		suite.addTest(new GrammarFeatureParseRootTest("mnc xyz", "MandatoryNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseRootTest("mnc xyz xyz", null));

		suite.addTest(new GrammarFeatureParseRootTest("onc", "OptionalNonContainment"));
		suite.addTest(new GrammarFeatureParseRootTest("onc xyz", "OptionalNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseRootTest("onc xyz xyz", null));

		suite.addTest(new GrammarFeatureParseRootTest("pnc", null));
		suite.addTest(new GrammarFeatureParseRootTest("pnc xyz", "PlusNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseRootTest("pnc xyz xyz", "PlusNonContainment[reference->X;X]"));

		suite.addTest(new GrammarFeatureParseRootTest("snc", "StarNonContainment"));
		suite.addTest(new GrammarFeatureParseRootTest("snc xyz", "StarNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseRootTest("snc xyz xyz", "StarNonContainment[reference->X;X]"));
		
		suite.addTest(new GrammarFeatureParseRootTest("alternativeA", "AlternativeSyntax"));
		suite.addTest(new GrammarFeatureParseRootTest("alternativeB", "AlternativeSyntax"));
		suite.addTest(new GrammarFeatureParseRootTest("alternativeA alternativeB", "AlternativeSyntax,AlternativeSyntax"));
		
		suite.addTest(new GrammarFeatureParseRootTest("concreteA", "ConcreteSubclassA"));
		suite.addTest(new GrammarFeatureParseRootTest("concreteB", "ConcreteSubclassB"));
		suite.addTest(new GrammarFeatureParseRootTest("concreteA concreteB", "ConcreteSubclassA,ConcreteSubclassB"));

		suite.addTest(new GrammarFeatureParseRootTest("mc x:abc", "MandatoryContainment{X(name=abc)}"));

		suite.addTest(new GrammarFeatureParseRootTest("mc x:abc mnc abc", "MandatoryContainment{X(name=abc)},MandatoryNonContainment[reference->X(name=abc)]"));

		suite.addTest(new GrammarFeatureParseErrorTest("mc ", "Keyword x"));
		suite.addTest(new GrammarFeatureParseErrorTest("mc x:", "token TEXT"));
		suite.addTest(new GrammarFeatureParseErrorTest("mnc", "token TEXT"));

		// this test does fail because no model is created for unparsable input
		//suite.addTest(new GrammarFeatureParseErrorModelTest("mc ", "MandatoryContainment"));
		return suite;
	}
}
