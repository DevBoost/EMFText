package org.emftext.sdk.codegen.regex;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.CsResourceFactory;
import org.junit.BeforeClass;
import org.junit.Test;

public class AntlrTranslationTest {

	private static String[] grammars;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		grammars = new String[] {
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
				"../../EMFText Languages/org.emftext.language.emfxml/metamodel/xml.cs"};

	
	}
	
	@Test
	public void loadExpsFromGrammars() throws IOException, RecognitionException {
		
		for (String grammar : grammars) {
			CsResourceFactory factory = new CsResourceFactory();
			ResourceSet rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
					"cs", factory);

			URI fileURI = URI.createURI(grammar);
			Resource resource = rs.createResource(fileURI);
			resource.load(Collections.EMPTY_MAP);
			System.out.println("loaded " + fileURI);

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
		 matcher = pattern.matcher("<http://www.googl.de>");
		 assertTrue(matcher.matches());
	}

	private void testExp(String exp) throws IOException, RecognitionException {
		InputStream input = new ByteArrayInputStream(exp.getBytes());
		ANTLRInputStream inputStream = new ANTLRInputStream(input);

		ANTLRexpLexer lexer = new ANTLRexpLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);

		ANTLRexpParser parser = new ANTLRexpParser(tokenStream);
		String arhusStyle = parser.root().toString();
		System.out.println("\tLoaded: " + exp);
		System.out.println("\tTranslated: " + arhusStyle);
		Pattern p = Pattern.compile(arhusStyle);
		System.out.println("\tCompiled: " + p);
		Matcher matcher = p.matcher("bla");
		System.out.println("\t\tMatches 'matcherWorks' " + matcher.matches());
		
	}

}
