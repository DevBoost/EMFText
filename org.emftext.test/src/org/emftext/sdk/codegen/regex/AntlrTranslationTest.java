package org.emftext.sdk.codegen.regex;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;
import static org.emftext.test.ConcreteSyntaxTestHelper.findAllGrammars;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
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
	
	@Test
	public void testLineTerminatorTranslation() throws IOException, RecognitionException {
		String regex = "'$'(~('$'))*'$'";
		regex = RegexpTranslationHelper
		.translateAntLRToJavaStyle(regex);
		assertTrue("Should match example string.","$ test $".matches(regex));
		
		assertFalse("Should not match empty string.","".matches(regex));
		
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
		 matcher = pattern.matcher("<http://www.test.de>");
		 assertTrue(matcher.matches());
	}
	
	@Test
	public void testExpsFromGrammars() throws IOException, RecognitionException {
		
		Collection<String> grammars = findAllGrammars(new File(".."));
		System.out.println("AntlrTranslationTest.testExpsFromGrammars() found " + grammars.size() + " grammar files.");
		// make sure all grammars are found
		assertTrue(grammars.size() > 140);
		
		for (String grammar : grammars) {
			System.out.println("AntlrTranslationTest.testExpsFromGrammars() testing " + grammar);
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
