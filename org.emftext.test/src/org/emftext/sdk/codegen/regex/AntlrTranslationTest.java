package org.emftext.sdk.codegen.regex;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.TextResourceUtil;
import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.junit.Before;
import org.junit.Test;

public class AntlrTranslationTest extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	public static String[] grammars = new String[] {
				"../../EMFText Languages/org.emftext.language.bool/metamodel/bool.cs",
				"../../EMFText Languages/org.emftext.language.c_sharp/metamodel/c_sharp.cs",
				"../../EMFText Languages/org.emftext.language.simple_c/metamodel/c.cs",
				"../../EMFText Languages/org.emftext.language.c_sharp.test/CSharpSyntaxCheck/CheckCSSyntax.cs",
				"../../EMFText Languages/org.emftext.language.chess/metamodel/chess.cs",
				"../../EMFText Languages/org.emftext.language.conference/metamodel/conference.cs",
				"../../EMFText Languages/org.emftext.language.custom_sandwich/metamodel/custom_sandwich.cs",
				"../../EMFText Languages/org.emftext.language.customer/metamodel/customer.cs",
				"../../EMFText Languages/org.emftext.language.db_schema/metamodel/db_schema.cs",
				"../../EMFText Languages/org.emftext.language.dot/metamodel/dot.cs",
				"../../EMFText Languages/org.emftext.language.ecore.resource.facade/metamodel/facade.ecore.cs",
				"../../EMFText Languages/org.emftext.language.featherweight_java/metamodel/featherweight_java.cs",
				"../../EMFText Languages/org.emftext.language.feature/metamodel/feature.cs",
				"../../EMFText Languages/org.emftext.language.filesystem/metamodel/filesystem.cs",
				"../../EMFText Languages/org.emftext.language.forms/metamodel/forms.cs",
				"../../EMFText Languages/org.emftext.language.forms/standardSyntax/forms.cs",
				"../../EMFText Languages/org.emftext.language.formular/metamodel/FormularMM.cs",
				"../../EMFText Languages/org.emftext.language.java_templates/metamodel/java_templates.cs",
				"../../EMFText Languages/org.emftext.language.java/metamodel/java.cs",
				"../../EMFText Languages/org.emftext.language.java.javabehavior4uml/metamodel/JavaBehavior4UML.cs",
				"../../EMFText Languages/org.emftext.language.km3/metamodel/KM3.cs",
				"../../EMFText Languages/org.emftext.language.models/metamodel/models.cs",
				"../../EMFText Languages/org.emftext.language.office/metamodel/office.cs",
				"../../EMFText Languages/org.emftext.language.owl/metamodel/owl.cs",
				"../../EMFText Languages/org.emftext.language.parametercheck/metamodel/parametercheck.cs",
				"../../EMFText Languages/org.emftext.language.pico/metamodel/pico.cs",
				"../../EMFText Languages/org.emftext.language.quickuml/metamodel/quickuml.cs",
				"../../EMFText Languages/org.emftext.language.regexp/metamodel/regular_expressions.cs",
				"../../EMFText Languages/org.emftext.language.java.reusejava/metamodel/reusejava.cs",
				"../../EMFText Languages/org.emftext.language.sandwich/metamodel/sandwich.cs",
				"../../EMFText Languages/org.emftext.language.simple_gui/metamodel/simple_gui.cs",
				"../../EMFText Languages/org.emftext.language.simple_math/metamodel/simple_math.cs",
				"../../EMFText Languages/org.emftext.language.sparql/metamodel/SPARQL.cs",
				"../../EMFText Languages/org.emftext.language.statemachine/metamodel/statemachine.cs",
				"../../EMFText Languages/org.emftext.language.tbool/metamodel/tbool.cs",
				"../../EMFText Languages/org.emftext.language.template_concepts.call/metamodel/template_call.cs",
				"../../EMFText Languages/org.emftext.language.ecore.resource.text/metamodel/text.ecore.cs",
				"../../EMFText Languages/org.emftext.language.textadventure/metamodel/textadventure.cs",
				"../../EMFText Languages/org.emftext.language.threevaluedlogic/metamodel/threevaluedlogic.cs",
				"../../EMFText Languages/org.emftext.language.java.treejava/metamodel/treejava.cs",
				"../../EMFText Languages/org.emftext.language.uml_class/metamodel/uml_class.cs",
				"../../EMFText Languages/org.emftext.language.usecaseinvariant/metamodel/UseCaseInvariant.cs",
				"../../EMFText Languages/org.emftext.language.valueflow/metamodel/valueflow.cs",
				"../../EMFText Languages/org.emftext.language.xml/metamodel/xml.cs"};

	

	
	@Test
	public void testWhitespaceTranslation() {
		 Pattern pattern = java.util.regex.Pattern.compile("\\A( |\\t|\"\\f\")");
		 Matcher matcher = pattern.matcher(" ");
		 assertTrue(matcher.matches());
		 matcher = pattern.matcher("\t");
		 assertTrue(matcher.matches());
		 
		 pattern = Pattern.compile("unsettable");
		 matcher = pattern.matcher("unsettable");
		 assertTrue(matcher.matches()); 
		 
		 pattern = Pattern.compile("((<)([^(>)]|(\\\\>))*(>))|(([A-Z]|:|[a-z]|[0-9]|_|\\-)+)");
		 matcher = pattern.matcher("<http://www.test.de>");
		 assertTrue(matcher.matches());
	}
	
	@Test
	public void testExpsFromGrammars() throws IOException, RecognitionException {
		
		for (String grammar : grammars) {
			Resource resource = loadResource(grammar);

			TreeIterator<EObject> contents = resource.getAllContents();
			while (contents.hasNext()) {
				EObject object = (EObject) contents.next();
				if (object instanceof TokenDefinition) {
					TokenDefinition td = (TokenDefinition) object;
					testExp(td.getRegex());
				}
			}
		}

	}

	private Resource loadResource(String grammar) throws IOException {


		File file = new File(grammar);
		
		ITextResource resource = TextResourceUtil.getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
	
		return resource;
	}
	
	

	private void testExp(String exp) throws IOException, RecognitionException {
		String javaStyle = RegexpTranslationHelper.translateAntLRToJavaStyle(exp);
		System.out.println("\tLoaded: " + exp);
		System.out.println("\tTranslated: " + javaStyle);
		Pattern p = Pattern.compile(javaStyle);
		System.out.println("\tCompiled: " + p);
		Matcher matcher = p.matcher("bla");
		System.out.println("\t\tMatches 'matcherWorks' " + matcher.matches());
		
	}


	
	
	

}
