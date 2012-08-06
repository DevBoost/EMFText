/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.tokenhandling;

import java.io.File;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.PluginTestHelper;

public class TokenHandlingTest extends TestCase {

	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
	}
	
	public void testExtendingSyntax1() {
		String syntaxName = "extendingsyntax1.cs";
		ConcreteSyntax syntax = loadSyntax(syntaxName);
		String expectedRegex = "('0'..'9'|'a'..'z')+";
		assertTokens(syntax, expectedRegex);
		
		// check whether the placeholder was correctly redirected to the token redefinition
		EList<Rule> allRules = syntax.getAllRules();
		assertEquals(2, allRules.size());

		Rule rule = findRule(allRules, "B1");
		Collection<PlaceholderUsingSpecifiedToken> placeholders = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken());
		PlaceholderUsingSpecifiedToken placeholder = placeholders.iterator().next();
		assertEquals("name", placeholder.getFeature().getName());
		assertEquals(expectedRegex, placeholder.getToken().getRegex());
	}

	public void testExtendingSyntax2() {
		String syntaxName = "extendingsyntax2.cs";
		ConcreteSyntax syntax = loadSyntax(syntaxName);
		String expectedRegex = "('a'..'z')+";
		assertTokens(syntax, expectedRegex);
		
		EList<Rule> allRules = syntax.getAllRules();
		assertEquals(3, allRules.size());
	}

	public void testExtendingSyntax3() {
		String syntaxName = "extendingsyntax3.cs";
		ConcreteSyntax syntax = loadSyntax(syntaxName);
		String expectedRegex = "('A'..'Z'|'a'..'z')+";
		assertTokens(syntax, expectedRegex);
		
		EList<Rule> allRules = syntax.getAllRules();
		assertEquals(3, allRules.size());
	}

	public void testExtendingSyntax4() {
		String syntaxName = "extendingsyntax4.cs";
		ConcreteSyntax syntax = loadSyntax(syntaxName);
		String expectedRegex = "('a'..'z')+";
		assertTokens(syntax, expectedRegex);
		
		EList<Rule> allRules = syntax.getAllRules();
		assertEquals(3, allRules.size());
	}

	public void testExtendingSyntax5() {
		String syntaxName = "extendingsyntax5.cs";
		ConcreteSyntax syntax = loadSyntax(syntaxName);
		String expectedRegex = "('x'..'y')+";
		assertTokens(syntax, expectedRegex);
		
		EList<Rule> allRules = syntax.getAllRules();
		assertEquals(3, allRules.size());
	}

	public void testExtendingSyntax6() {
		String syntaxName = "extendingsyntax6.cs";
		ConcreteSyntax syntax = loadSyntax(syntaxName);
		String[] expectedRegex = new String[] {"('0'..'9')+", "('0'..'9'|'a'..'z')+"};
		assertTokens(syntax, expectedRegex);
		
		EList<Rule> allRules = syntax.getAllRules();
		assertEquals(2, allRules.size());
	}

	private void assertTokens(ConcreteSyntax syntax, String... regex) {
		EList<CompleteTokenDefinition> activeTokens = syntax.getActiveTokens();
		int expected = regex.length;
		assertEquals(expected + " token(s) expected.", expected, activeTokens.size());
		for (int i = 0; i < regex.length; i++) {
			CompleteTokenDefinition activeToken = activeTokens.get(i);
			String expectedRegex = regex[i];
			assertEquals("Regex not expected", expectedRegex, activeToken.getRegex());
		}
	}

	private void printErrors(ConcreteSyntax syntax) {
		EList<Diagnostic> errors = syntax.eResource().getErrors();
		for (Resource.Diagnostic error : errors) {
			System.out.println("Error: " + error.getMessage() + " at " + error.getLine() + ":" + error.getColumn());
		}
		assertTrue("Resource must not contain errors.", errors.isEmpty());
	}
	
	private Rule findRule(List<Rule> rules, String name) {
		for (Rule rule : rules) {
			if (name.equals(rule.getMetaclass().getName())) {
				return rule;
			}
		}
		fail("Must find rule for metaclass " + name + ".");
		return null;
	}

	private ConcreteSyntax loadSyntax(String syntaxName) {
		System.out.println("loadSyntax(" + syntaxName +")");
		Class<? extends TokenHandlingTest> class1 = getClass();
		String packagePath = class1.getPackage().getName().replace(".", File.separator);
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(class1);
		ConcreteSyntax syntax = ConcreteSyntaxTestHelper.getConcreteSyntax(pluginRootPath + File.separator + "src" + File.separator + packagePath + File.separator + syntaxName);
		printErrors(syntax);
		return syntax;
	}
}
