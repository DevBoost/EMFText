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
		ITokenResolver doubleQuoteResolver = new CsQUOTED_34_34_92TokenResolver();
		
		for (Pair<String,String> pair : testData) {
			assertResolveTo(doubleQuoteResolver, pair.getLeft(), pair.getRight());
			assertDeResolveTo(doubleQuoteResolver, pair.getRight(), pair.getLeft());
		}
	}

	public void assertResolveTo(ITokenResolver resolver, String lexem, String expectedResult) {
		ITokenResolveResult result = new CsTokenResolveResult();
		resolver.resolve(lexem, null, result);
		Object actualResult = result.getResolvedToken();
		System.out.println("RESOLVE EXP: [" + expectedResult + "]");
		System.out.println("RESOLVE ACT: [" + actualResult + "]");
		assertEquals(expectedResult, actualResult);
	}

	public void assertDeResolveTo(ITokenResolver resolver, String value, String expectedResult) {
		String actualResult = resolver.deResolve(value, null, null);
		System.out.println("DE-RESOLVE EXP: [" + expectedResult + "]");
		System.out.println("DE-RESOLVE ACT: [" + actualResult + "]");
		assertEquals(expectedResult, actualResult);
	}
}
