package org.emftext.sdk.codegen.regex;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.TextResourceUtil;
import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.junit.Before;
import org.junit.Test;

public class TokenOverlapsTests extends TestCase {
	
	
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
				"../../EMFText Languages/org.emftext.language.emfxml/metamodel/xml.cs"};

	

	
	
	@Test
	public void testSortNoConflict() throws SorterException  {
		
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs("'a'", "'b'", "'c'");
		
		assertEquals(0, ts.getNonReachables(conflicting).size());
	
		
		ts.sortTokens(conflicting, false);
		// no exception expected.
		
	}
	
	
	@Test
	public void testSortSameRegexConflict() throws SorterException  {
		
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs("'a'", "'a'", "'b'");
		
		assertEquals(1, ts.getNonReachables(conflicting).size());
		assertEquals("'a'", ((NormalToken)ts.getNonReachables(conflicting).get(0)).getRegex());
		
		try {
			ts.sortTokens(conflicting, false);
			fail("Expected SorterException when sorting conflicting tokens.");
		} catch (SorterException s) { 
			// expected exception 	
		}
		
	}
	
	@Test
	public void testSortIntersectionConflict() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs("'a'*", "'a'+", "'b'");
		
		assertEquals(1, ts.getNonReachables(conflicting).size());
		assertEquals(1, ts.getConflicting(conflicting).size());
		
		// non-reachables can be removed by clever sorting
		assertEquals(0, ts.getNonReachables(ts.sortTokens(conflicting, true)).size());
		// conflicting can not be removed
		assertEquals(1, ts.getConflicting(conflicting).size());
	}
	
	@Test
	public void testSortIntersectionConflict3() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs("'a'*", "", "'b'");
		
		assertEquals(1, ts.getConflicting(conflicting).size());
		assertEquals(1, ts.getNonReachables(conflicting).size());
		
		// non-reachables can be removed by clever sorting
		assertEquals(0, ts.getNonReachables(ts.sortTokens(conflicting, true)).size());
		// conflicting can not be removed
		assertEquals(1, ts.getConflicting(conflicting).size());
	}
	
	@Test
	public void testBadConflict() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs( 
				"('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+",
				"('\\r\\n' | '\\r' | '\\n')");
		
		assertEquals(0, ts.getNonReachables(conflicting).size());
	}
	
	
	@Test
	public void testBadConflict2() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs( 
				"'\u0040'|('\u0040'..'\u0042')",
				"'7'");
		
		assertEquals(0, ts.getNonReachables(conflicting).size());
	}
	
	
	@Test
	public void testSortIntersectionConflict2() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs("'1'|'2'", "'2'|'3'", "'b'");
		
		assertEquals(0, ts.getNonReachables(conflicting).size());
		assertEquals(1, ts.getConflicting(conflicting).size());
			
		ts.sortTokens(conflicting, false);
		
	}
	
	
	@Test
	public void testSublanguageConflict() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = createTokenDefs("'a'?", "'a'");
		
		assertEquals(1, ts.getNonReachables(conflicting).size());
		assertEquals(1, ts.getConflicting(conflicting).size());
			
		ts.sortTokens(conflicting, false);
		
	}
	
	private List<TokenDefinition> createTokenDefs(String... regex) {
		List<TokenDefinition> list = new ArrayList<TokenDefinition>();
		ConcretesyntaxFactory factory = ConcretesyntaxFactory.eINSTANCE;
		
		for (int i = 0; i < regex.length; i++) {
			TokenDefinition def = factory.createNormalToken();
			def.setRegex(regex[i]);
			list.add(def);
		}
		return list;
	}
	
	@Test
	public void testSorts() throws IOException, SorterException {
		TokenSorter ts = new TokenSorter();
		for (String grammar : grammars) {
			Resource resource = loadResource(grammar);
			if (resource.getContents().size() > 0) {
				EList<TokenDefinition> allTokenDirectives = ((ConcreteSyntax) resource.getContents().get(0)).getActiveTokens();
				//assertTrue("Grammar " + resource.getURI() + " should contain some tokens. " , allTokenDirectives.size() > 0);
				assertEquals("Grammar " + resource.getURI() + " should contain no non-reachabels.", Collections.EMPTY_LIST, ts.getNonReachables(allTokenDirectives));
				
				ts.sortTokens(allTokenDirectives, false);
				
			}
		}
	}
	
	private Resource loadResource(String grammar) throws IOException {


		File file = new File(grammar);
		
		ITextResource resource = TextResourceUtil.getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
	
		return resource;
	}
	
	
	


	
	
}
