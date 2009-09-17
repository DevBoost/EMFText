package org.emftext.sdk.codegen.generators;

import junit.framework.TestCase;

import org.emftext.sdk.AntlrTokenDerivator;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.junit.Test;

public class AntlrTokenDerivatorTest extends TestCase {

	@Test
	public void testTokenDerivation() {
		String prefix = "\"";
		String suffix = "\"";
		//String expected = "('\"')(~('\"'|'\\\\')|('\\\\''\"')|('\\\\''\\\\'))*('\"')";
		String expected = "('\"')(~('\"'))*('\"')";
		String actual = getRegex(prefix, suffix);
		System.out.println("AntlrTokenDerivatorTest.testTokenDerivation() EXP " + expected);
		System.out.println("AntlrTokenDerivatorTest.testTokenDerivation() ACT " + actual);
		assertEquals(expected, actual);
	}

	private String getRegex(String prefix, String suffix) {
		AntlrTokenDerivator derivator = new AntlrTokenDerivator();
		PlaceholderInQuotes placeholder = ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		placeholder.setPrefix(prefix);
		placeholder.setSuffix(suffix);
		return derivator.deriveTokenExpression(placeholder);
	}
}
