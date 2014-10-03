/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.test.codecompletion;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsCodeCompletionHelper;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsProposalPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsPair;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.PluginTestHelper;
import org.junit.Before;
import org.junit.Test;

public class CSCodeCompletionTest {
	
	private static final String CURSOR = "<CURSOR>";
	
	@Before
	public void setUp() throws Exception {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		new CsMetaInformation().registerResourceFactory();
	}

	@Test
	public void testCompletion1() {
		// we have typed part of a feature name ('feature1')
		String input = getTestDocument("Root ::= \"root\" fea" + CURSOR + ";");
		assertProposals(input, 
				"feature1"
		);
	}
	
	@Test
	public void testCompletion2() {
		// we have typed part of a feature name ('feature1') and a space
		String input = getTestDocument("Root ::= \"root\" fea " + CURSOR + ";");
		// since there is a space after the feature name, we cannot expect
		// proposals for name, but instead, cardinalities and the semicolon
		// should be proposed
		assertProposals(input, 
				"*",
				"+",
				":",
				"?",
				";",
				"|",
				"feature1",
				"_",
				"\"keyword\"",
				"!0",
				"#0",
				"("
		);
	}
	
	@Test
	public void testCompletion3() {
		// we have not typed a feature name ('feature1') yet, but we could
		String input = getTestDocument("Root ::= \"root\" " + CURSOR + ";");
		assertProposals(input, 
				"feature1",
				"!0",
				"\"keyword\"",
				"#0",
				"(",
				")", // TODO check if we can prevent this proposal
				";",
				"|",
				"_" // the anonymous feature
		);
	}
	
	private String getTestDocument(String rule) {
		String content = "SYNTAXDEF codecompletion1 " +
		"FOR <http://www.emftext.org/test/codecompletion1> " +
		"START Root " +
		"RULES {" +
			rule +
		"}";
		return content;
	}

	private void assertProposals(String input, String... expectedProposals) {
		System.out.println("assertProposals()");
		CsPair<String, Integer> inputPair = processInput(input);
		CsCodeCompletionHelper helper = new CsCodeCompletionHelper();
		String path = CSCodeCompletionTest.class.getPackage().getName().replace(".", File.separator);
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		File testFile = new File(pluginRootPath + File.separator + "src" + File.separator + path + File.separator + "codecompletion1.cs");
		
		String uri = testFile.getAbsolutePath();
		ICsTextResource resource = (ICsTextResource) new ResourceSetImpl().createResource(URI.createFileURI(uri));
		
		CsCompletionProposal[] proposals = helper.computeCompletionProposals(resource, inputPair.getLeft(), inputPair.getRight());
		CsProposalPostProcessor postProcessor = new CsProposalPostProcessor();
		List<CsCompletionProposal> processedProposals = postProcessor.process(Arrays.asList(proposals));
		List<CsCompletionProposal> finalProposals = new ArrayList<CsCompletionProposal>();
		for (CsCompletionProposal proposal : processedProposals) {
			if (!proposal.isMatchesPrefix()) {
				continue;
			}
			System.out.println("Proposal: InsertString: " + proposal.getInsertString());
			finalProposals.add(proposal);
		}
		int delta = expectedProposals.length - finalProposals.size();
		if (delta < 0) {
			// we do not fail if there are too many proposals, but we signal a warning
			System.out.println("WARNING: Too many proposals (" + -delta + " too much).");
		} else if (delta > 0) {
			fail("Too few proposals (" + delta + " too few).");
		}
		for (String expectedProposal : expectedProposals) {
			assertTrue("Proposal '" + expectedProposal + "' is missing.", contains(finalProposals, expectedProposal));
		}
	}

	private boolean contains(List<CsCompletionProposal> processedProposals,
			String expectedProposal) {
		for (CsCompletionProposal proposal : processedProposals) {
			if (proposal.getInsertString().equals(expectedProposal)) {
				return true;
			}
		}
		return false;
	}

	private CsPair<String, Integer> processInput(String input) {
		int index = input.indexOf(CURSOR);
		if (index < 0) {
			throw new RuntimeException("Can't find cursor marker in input document");
		}
		String head = input.substring(0, index);
		String tail = input.substring(index + CURSOR.length());
		return new CsPair<String, Integer>(head + tail, index);
	}
}
