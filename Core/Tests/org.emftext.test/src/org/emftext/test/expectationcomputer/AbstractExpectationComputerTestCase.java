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
package org.emftext.test.expectationcomputer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.test.ConcreteSyntaxTestHelper;

public abstract class AbstractExpectationComputerTestCase extends TestCase {

	private ExpectationComputer computer;

	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		computer = new ExpectationComputer();
	}

	protected ConcreteSyntax loadSyntax(String pathName) {
		File csFile = new File(pathName).getAbsoluteFile();
		Resource r = ConcreteSyntaxTestHelper.getConcreteSyntaxResource(URI.createFileURI(csFile.getAbsolutePath()));
		EList<EObject> contents = r.getContents();
		EcoreUtil.resolveAll(r);
		assertTrue(!contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue(root instanceof ConcreteSyntax);
		return (ConcreteSyntax) root;
	}
	
	public void assertFollowSet(SyntaxElement syntaxElement, EObject... expectedFollow) {
		Set<Expectation> actualFollowSet = computeFollowSet(syntaxElement);
		printAndCompareSets("follow", syntaxElement, actualFollowSet, expectedFollow);
	}

	protected Set<Expectation> computeFollowSet(SyntaxElement syntaxElement) {
		ConcreteSyntax syntax = syntaxElement.getContainingRule().getSyntax();
		Set<Expectation> followSet = computer.computeFollowSet(syntax, syntaxElement);
		return followSet;
	}

	public void assertFirstSet(SyntaxElement syntaxElement, EObject... expectedFirst) {
		ConcreteSyntax syntax = syntaxElement.getContainingRule().getSyntax();
		Set<Expectation> firstSet = computer.computeFirstSet(syntax, syntaxElement);
		firstSet.remove(ExpectationComputer.EPSILON);
		printAndCompareSets("first", syntaxElement, firstSet, expectedFirst);
	}

	private void printAndCompareSets(String typeOfSet, EObject element, Set<Expectation> actualSet,
			EObject... expectedSet) {
		System.out.println("-> Comparing " + typeOfSet + " for " + element);
		for (Expectation nextExp : actualSet) {
			EObject next = nextExp.getExpectedElement();
			System.out.println("Actual " + typeOfSet + ":   " + next);
		}
		for (EObject next : expectedSet) {
			System.out.println("Expected " + typeOfSet + ": " + next);
		}
		assertEquals(expectedSet.length, actualSet.size());
		int i = 0;
		for (Expectation nextExp : actualSet) {
			EObject next = nextExp.getExpectedElement();
			assertEquals(next, expectedSet[i]);
			i++;
		}
	}
	
	public List<CompoundDefinition> findCompounds(ConcreteSyntax syntax, String metaClassName) {
		List<CompoundDefinition> compoundsInRule = new ArrayList<CompoundDefinition>();
		Collection<CompoundDefinition> allCompounds = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition());
		for (CompoundDefinition compoundDefinition : allCompounds) {
			if (metaClassName.equals(compoundDefinition.getContainingRule().getMetaclass().getName())) {
				compoundsInRule.add(compoundDefinition);
			}
		}
		return compoundsInRule;
	}

	public CsString findKeyword(ConcreteSyntax syntax, String keyword) {
		return findKeyword(syntax, keyword, 0);
	}

	public CsString findKeyword(ConcreteSyntax syntax, String keyword, int index) {
		int i = 0;
		Collection<CsString> keywords = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
		for (CsString nextKeyword : keywords) {
			if (keyword.equals(nextKeyword.getValue())) {
				if (i == index) {
					return nextKeyword;
				} else {
					i++;
				}
			}
		}
		return null;
	}

	public List<Terminal> findTerminals(ConcreteSyntax syntax) {
		Collection<Terminal> terminals = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		return new ArrayList<Terminal>(terminals);
	}

	public List<BooleanTerminal> findBooleanTerminals(ConcreteSyntax syntax) {
		Collection<BooleanTerminal> terminals = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal());
		return new ArrayList<BooleanTerminal>(terminals);
	}

	public List<Containment> findContainments(ConcreteSyntax syntax) {
		Collection<Containment> containments = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getContainment());
		return new ArrayList<Containment>(containments);
	}
}
