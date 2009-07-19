package org.emftext.test.scannerless_parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class RegexpTest extends TestCase {

	public void testExpressions() {
		assertTrue(find("abc de", "\\A[a-z]+"));
		assertTrue(find(" abc", "\\A[ ]"));
		assertTrue(find(" class A {}", "\\A[ ]"));
	}
	
	private boolean find(String text, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}
}
