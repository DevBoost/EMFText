package org.emftext.test.packrat_parser;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
		private ITextResourcePluginMetaInformation metaInformation;
		private ITextParser parser;

		public AbstractParseTest(String content, String expectedModel, ITextResourcePluginMetaInformation metaInformation, ITextParser parser) {
			super("Parse " + content.replace("\n", "").replace("\r", ""));
			this.metaInformation = metaInformation;
			this.parser = parser;
			this.expectedResult = expectedModel != null;
			this.expectedModel = expectedModel;
			if (this.expectedModel != null) {
				this.expectedModel = "Root{" + this.expectedModel + "}";
			}
		}

		public void runTest() {
			//ITextParser parser = metaInformation.createParser(in, null);
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createURI("test." + metaInformation.getSyntaxName());
			ITextResource resource = (ITextResource) rs.createResource(uri);
			parser.setResource(resource);
			//parser.setResource(new Grammar_featuresResource(uri));
			EObject root = parser.parse();
			if (expectedResult) {
				resource.getContents().add(root);
				assertNotNull("Parsing should be successful.", root);
				EcoreUtil.resolveAll(root);
				checkModel(root);
			} else {
				assertNull("Parsing should fail.", root);
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
			super(content, "", new CctMetaInformation(), new CctPackratParser(new ByteArrayInputStream(content.getBytes()), null));
		}
		
		protected void checkModel(EObject root) {
			// do nothing
		}
	}
	
	public static class GrammarFeatureParseTest extends AbstractParseTest {
		
		public GrammarFeatureParseTest(String content, String expectedModel) {
			super(content, expectedModel, new Grammar_featuresMetaInformation(), new Grammar_featuresPackratParser(new ByteArrayInputStream(content.getBytes()), null));
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
		suite.addTest(new CctParseTest("public class A {private void method() {}}"));
		
		suite.addTest(new GrammarFeatureParseTest("co", "CompoundOptional"));
		suite.addTest(new GrammarFeatureParseTest("co a b", "CompoundOptional"));
		suite.addTest(new GrammarFeatureParseTest("co a b a b", null));

		// this should not be parsable
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
		suite.addTest(new GrammarFeatureParseTest("mnc xyz", "MandatoryNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseTest("mnc xyz xyz", null));

		suite.addTest(new GrammarFeatureParseTest("onc", "OptionalNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("onc xyz", "OptionalNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseTest("onc xyz xyz", null));

		suite.addTest(new GrammarFeatureParseTest("pnc", null));
		suite.addTest(new GrammarFeatureParseTest("pnc xyz", "PlusNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseTest("pnc xyz xyz", "PlusNonContainment[reference->X;X]"));

		suite.addTest(new GrammarFeatureParseTest("snc", "StarNonContainment"));
		suite.addTest(new GrammarFeatureParseTest("snc xyz", "StarNonContainment[reference->X]"));
		suite.addTest(new GrammarFeatureParseTest("snc xyz xyz", "StarNonContainment[reference->X;X]"));
		
		suite.addTest(new GrammarFeatureParseTest("alternativeA", "AlternativeSyntax"));
		suite.addTest(new GrammarFeatureParseTest("alternativeB", "AlternativeSyntax"));
		suite.addTest(new GrammarFeatureParseTest("alternativeA alternativeB", "AlternativeSyntax,AlternativeSyntax"));
		
		suite.addTest(new GrammarFeatureParseTest("concreteA", "ConcreteSubclassA"));
		suite.addTest(new GrammarFeatureParseTest("concreteB", "ConcreteSubclassB"));
		suite.addTest(new GrammarFeatureParseTest("concreteA concreteB", "ConcreteSubclassA,ConcreteSubclassB"));

		suite.addTest(new GrammarFeatureParseTest("mc x:abc", "MandatoryContainment{X(name=abc)}"));

		suite.addTest(new GrammarFeatureParseTest("mc x:abc mnc abc", "MandatoryContainment{X(name=abc)},MandatoryNonContainment[reference->X(name=abc)]"));
		return suite;
	}
}
