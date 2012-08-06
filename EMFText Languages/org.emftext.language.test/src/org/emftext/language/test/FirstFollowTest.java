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
package org.emftext.language.test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.test.ConcreteSyntaxTestHelper;

public class FirstFollowTest extends TestCase {

	// the generator models for these syntax contain references to Ecore or UML
	// which is not available when this test runs as JUnit test.
	// some of them refer to meta models that use textual syntax which is not
	// available either.
	private String[] excludedFiles = {
			".*/customsandwich.cs",
			".*/org.emftext.language.company/metamodel/company.text.cs",
			".*/text.text.cs",
			".*/facade.ecore.cs",
			".*/text.ecore.cs",
			".*/mecore.cs",
			".*/efactory.cs",
			".*/eJava.cs",
			".*/JavaBehavior4UML.cs",
			".*/jtemplates.cs",
			".*/owl.cs",
			".*/owlcl.cs",
			".*/owlTextTestLanguage.text.cs",
			".*/plugin.cs",
			".*/quickuml.cs",
			".*/statemachine.cs",
			".*/tbool.cs",
			".*/templatecall.cs",
			".*/valueflow.cs",
			".*/concretesyntax.cs",
			".*/fragment.cs",
			".*/rex.cs",
			".*/rolecore.cs",
			".*/YggdrasilComponents.cs",
			".*/bug856/main.cs",
			".*/test/syntax_analysis/.*.cs",
			".*/test/syntax_extension/.*.cs",
			".*/reuseextensionactivator.cs",
			".*/text.secprop.cs",
			".*/rolemapping.cs",
			".*/theater.cs",
			".*/Properties.cs",
			".*/emfdoc.cs",
			".*/tokenhandling/.*.cs",
			".*/formsembedded.cs",
			".*/formsextension.cs",
			".*/javaforms.cs",
			".*/org.emftext.test/testInput/CSAbstractSyntax.cs",
			".*/org.emftext.test/.*/org/emftext/test/bug1676/.*",
			".*/org.emftext.test.resolving/.*",
			".*/org.reuseware.air.language.abstractsyntax/metamodel/as.cs",
			".*/org.reuseware.coconut.reuseextensionactivator/model/rex_activator.cs",
			".*/org.emftext.language.appflow/metamodel/appflow.cs",
			".*/org.emftext.language.lwc11.doc/listings/simplesyntax.cs",
			".*/org.emftext.language.swrl/metamodel/swrl.cs"
	};
	private ExpectationComputer computer;

	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		computer = new ExpectationComputer();
	}

	public void testFirstAndFollowComputations() {
		Collection<String> grammars = ConcreteSyntaxTestHelper.findAllGrammars();
		for (String grammar : grammars) {
			if (isExcluded(grammar)) {
				continue;
			}
			File grammarFile = new File(grammar);
			try {
				grammarFile = grammarFile.getCanonicalFile();
			} catch (IOException e) {
				fail(e.getMessage());
			}
			testFirstAndFollowComputation(grammarFile.getAbsolutePath());
		}
	}

	private boolean isExcluded(String grammar) {
		for (String excludedFile : excludedFiles) {
			String normlizedPath = grammar.replace(File.separator, "/");
			if (normlizedPath.matches(excludedFile)) {
				System.out.println("Excluded: " + grammar);
				return true;
			}
		}
		return false;
	}
	
	private void testFirstAndFollowComputation(String syntaxPath) {
		System.out.println("--> testing " + syntaxPath);
		ConcreteSyntax syntax = loadSyntax(syntaxPath);
		EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			//System.out.println("----> testing " + rule.getMetaclass().getName());
			computer.computeFollowSet(syntax, rule);
			TreeIterator<EObject> ruleContents = rule.eAllContents();
			while (ruleContents.hasNext()) {
				EObject next = ruleContents.next();
				// ignore annotations
				if (next instanceof Annotation) {
					continue;
				}
				// ignore annotation values
				if (next instanceof KeyValuePair) {
					continue;
				}
				assertTrue(next + " must be a SyntaxElement", next instanceof SyntaxElement);
				computer.computeFollowSet(syntax, (SyntaxElement) next);
			}
		}
	}

	private ConcreteSyntax loadSyntax(String syntaxPath) {
		String pathName = syntaxPath;
		// we need to use the absolute path because the resolution of
		// the Ecore model does not work when the relative one is used
		File csFile = new File(pathName).getAbsoluteFile();
		Resource r = ConcreteSyntaxTestHelper.getConcreteSyntaxResource(URI.createFileURI(csFile.getAbsolutePath()));
		EList<EObject> contents = r.getContents();
		EcoreUtil.resolveAll(r);
		assertTrue(!contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue(root instanceof ConcreteSyntax);
		return (ConcreteSyntax) root;
	}
}
