package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.sdk.codegen.util.Pair;
import org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolveResult;
import org.junit.Test;

public class QuotenTokenResolversTest extends TestCase {

	private Collection<Pair<String, String>> testData;
	
	public void setUp() {
		testData = new ArrayList<Pair<String,String>>();
		
		// test "" -> empty string
		testData.add(new Pair<String, String>("\"\"", ""));
		// test "\"" -> "
		testData.add(new Pair<String, String>("\"\\\"\"", "\""));
		// test "\\" -> \
		testData.add(new Pair<String, String>("\"\\\\\"", "\\"));
		// test "\\\\" -> \\
		testData.add(new Pair<String, String>("\"\\\\\\\\\"", "\\\\"));
		// test "\\\"" -> \"
		testData.add(new Pair<String, String>("\"\\\\\\\"\"", "\\\""));
	}
	
	@Test
	public void testResolvers() {
		CsQUOTED_34_34TokenResolver doubleQuoteResolver = new CsQUOTED_34_34TokenResolver();
		
		for (Pair<String,String> pair : testData) {
			assertResolveTo(doubleQuoteResolver, pair.getLeft(), pair.getRight());
			assertDeResolveTo(doubleQuoteResolver, pair.getRight(), pair.getLeft());
		}
	}

	public void assertResolveTo(ITokenResolver resolver, String lexem, String expectedResult) {
		ITokenResolveResult result = new CsTokenResolveResult();
		resolver.resolve(lexem, null, result);
		assertEquals(expectedResult, result.getResolvedToken());
	}

	public void assertDeResolveTo(ITokenResolver resolver, String value, String expectedResult) {
		String result = resolver.deResolve(value, null, null);
		assertEquals(expectedResult, result);
	}
}
